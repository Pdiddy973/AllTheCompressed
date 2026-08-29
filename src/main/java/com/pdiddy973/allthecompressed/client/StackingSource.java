package com.pdiddy973.allthecompressed.client;

import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.renderer.texture.SpriteContents;
import net.minecraft.client.renderer.texture.atlas.SpriteResourceLoader;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.renderer.texture.atlas.sources.LazyLoadedImage;
import net.minecraft.client.resources.metadata.animation.AnimationMetadataSection;
import net.minecraft.client.resources.metadata.animation.FrameSize;
import net.minecraft.client.resources.metadata.texture.TextureMetadataSection;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.metadata.MetadataSectionType;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceMetadata;
import net.minecraft.util.ARGB;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.pdiddy973.allthecompressed.util.ResourceUtil.prefix;

public record StackingSource(Identifier base, Identifier overlay, Identifier sprite) implements SpriteSource {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final MapCodec<StackingSource> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
        Identifier.CODEC.fieldOf("base").forGetter(StackingSource::base),
        Identifier.CODEC.fieldOf("overlay").forGetter(StackingSource::overlay),
        Identifier.CODEC.fieldOf("sprite").forGetter(StackingSource::sprite)
    ).apply(inst, StackingSource::new));
    public static final Identifier ID = prefix("stacking");

    @Override
    public void run(ResourceManager resourceManager, Output output) {
        run(resourceManager, output, Set.of());
    }

    @Override
    public void run(ResourceManager resourceManager, Output output, Set<MetadataSectionType<?>> additionalMetadata) {
        Identifier baseFile = TEXTURE_ID_CONVERTER.idToFile(base);
        Optional<Resource> optBase = resourceManager.getResource(baseFile);
        if (optBase.isEmpty()) {
            LOGGER.warn("Missing base source texture: {}", baseFile);
            return;
        }
        Identifier overlayFile = TEXTURE_ID_CONVERTER.idToFile(overlay);
        Optional<Resource> optOverlay = resourceManager.getResource(overlayFile);
        if (optOverlay.isEmpty()) {
            LOGGER.warn("Missing overlay source texture: {}", overlayFile);
            return;
        }

        output.add(sprite, new StackingLoader(
            optBase.get(),
            new LazyLoadedImage(baseFile, optBase.get(), 1),
            optOverlay.get(),
            new LazyLoadedImage(overlayFile, optOverlay.get(), 1),
            sprite,
            additionalMetadata
        ));
    }

    @Override
    public MapCodec<StackingSource> codec() {
        return CODEC;
    }

    private record StackingLoader(
        Resource baseResource,
        LazyLoadedImage baseImage,
        Resource overlayResource,
        LazyLoadedImage overlayImage,
        Identifier sprite,
        Set<MetadataSectionType<?>> additionalMetadata
    ) implements DiscardableLoader {
        @Override
        public @Nullable SpriteContents get(SpriteResourceLoader loader) {
            try {
                if (baseResource.metadata().getSection(AnimationMetadataSection.TYPE).isPresent()) {
                    throw new IllegalArgumentException("Base texture may not be animated");
                }
                if (overlayResource.metadata().getSection(AnimationMetadataSection.TYPE).isPresent()) {
                    throw new IllegalArgumentException("Overlay texture may not be animated");
                }

                NativeImage baseImage = this.baseImage.get();
                NativeImage overlayImage = this.overlayImage.get();
                FrameSize frameSize = new FrameSize(baseImage.getWidth(), baseImage.getHeight());
                if (overlayImage.getWidth() != baseImage.getWidth() || overlayImage.getHeight() != baseImage.getHeight()) {
                    throw new IllegalArgumentException("Input textures have mismatched sizes");
                }

                NativeImage image = new NativeImage(frameSize.width(), frameSize.height(), false);
                image.copyFrom(baseImage);
                for (int y = 0; y < frameSize.height(); y++) {
                    for (int x = 0; x < frameSize.width(); x++) {
                        int overlayColor = overlayImage.getPixel(x, y);
                        int overlayAlpha = ARGB.alpha(overlayColor);
                        if (overlayAlpha == 0) {
                            continue;
                        }
                        if (overlayAlpha < 255) {
                            int baseColor = baseImage.getPixel(x, y);
                            if (ARGB.alpha(baseColor) > 0) {
                                overlayColor = ARGB.alphaBlend(baseColor, overlayColor);
                            }
                        }
                        image.setPixel(x, y, overlayColor);
                    }
                }

                ResourceMetadata baseMetadata = baseResource.metadata();
                Optional<TextureMetadataSection> textureInfo = baseMetadata.getSection(TextureMetadataSection.TYPE);
                List<MetadataSectionType.WithValue<?>> metaSections = baseMetadata.getTypedSections(additionalMetadata);
                return new SpriteContents(sprite, frameSize, image, Optional.empty(), metaSections, textureInfo);
            } catch (Throwable t) {
                LOGGER.error("Failed to create stacked texture '{}'", sprite, t);
                return null;
            } finally {
                discard();
            }
        }

        @Override
        public void discard() {
            baseImage.release();
            overlayImage.release();
        }
    }
}
