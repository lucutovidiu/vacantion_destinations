package com.vacations.photo.util;

import com.vacations.photo.pojo.PhotoAttachment;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.vacations.photo.util.AttachmentUtil.getFileExtension;

@Slf4j
@UtilityClass
public class ImageUtil {

    public static BufferedImage convert(byte[] originalImage) throws IOException {
        return ImageIO.read(new ByteArrayInputStream(originalImage));
    }

    public static byte[] convert(BufferedImage originalImage, String imageFormatType) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(originalImage, imageFormatType, baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        return imageInByte;
    }

    public static BufferedImage convertToThumbnail(byte[] originalImage) {
        try {
            BufferedImage image = convert(originalImage);
            return scalePhoto(image, PhotoSize.THUMBNAIL);
        } catch (IOException e) {
            throw new RuntimeException("CouldNotReadImageException");
        }
    }

    public static BufferedImage convertToMedium(byte[] originalImage) {
        try {
            BufferedImage image = convert(originalImage);
            return scalePhoto(image, PhotoSize.MEDIUM);

        } catch (IOException e) {
            throw new RuntimeException("CouldNotReadImageException");
        }
    }

    public static BufferedImage convertToLarge(byte[] originalImage) {
        try {
            BufferedImage image = convert(originalImage);
            return scalePhoto(image, PhotoSize.LARGE);
        } catch (IOException e) {
            throw new RuntimeException("CouldNotReadImageException");
        }
    }

    public static BufferedImage convertToMaxSize(byte[] originalImage) {
        try {
            BufferedImage image = convert(originalImage);
            return scalePhoto(image, PhotoSize.MAX_SIZE);
        } catch (IOException e) {
            throw new RuntimeException("CouldNotReadImageException");
        }
    }

    public static BufferedImage scalePhoto(BufferedImage originalImage, PhotoSize photoSize) {
        return Scalr.resize(originalImage, Scalr.Method.BALANCED, photoSize.widthPx, photoSize.heightPx);
    }

    public static BufferedImage scalePhoto(BufferedImage targetImage, BufferedImage image) {
        return Scalr.resize(targetImage, Scalr.Method.BALANCED, image.getWidth(), image.getHeight());
    }

    public static byte[] scalePhoto(PhotoAttachment drugAttachment, PhotoSize photoSize) {
        return scalePhotoWithSize(drugAttachment, photoSize);
    }

    private static byte[] scalePhotoWithSize(PhotoAttachment attachment, PhotoSize photoSize) {
        byte[] content = attachment.getContent();
        String imageType = getFileExtension(content);
        log.debug("Convert photo size for attachment: " + attachment.getFilename() + ", size: " + photoSize.name() + ", imageType: " + imageType);
        try {
            switch (photoSize) {
                case THUMBNAIL:
                    content = ImageUtil.convert(ImageUtil.convertToThumbnail(content), imageType);
                    break;
                case MEDIUM:
                    content = ImageUtil.convert(ImageUtil.convertToMedium(content), imageType);
                    break;
                case LARGE:
                    content = ImageUtil.convert(ImageUtil.convertToLarge(content), imageType);
                    break;
                case MAX_SIZE:
                    content = ImageUtil.convert(ImageUtil.convertToMaxSize(content), imageType);
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException("Count not parse photo for: " + attachment.getFilename(), e);
        }
        return content;
    }


    public static BufferedImage crop(BufferedImage image, int percent) {
        int cropLength = image.getWidth() / 10;
        return image.getSubimage(cropLength, cropLength, image.getWidth() - cropLength, image.getHeight() - cropLength);
    }

    public static BufferedImage convertToGrayscale(BufferedImage image) {
        //get image width and height
        int width = image.getWidth();
        int height = image.getHeight();

        //convert to grayscale
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = image.getRGB(x, y);

                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                //calculate average
                int avg = (r + g + b) / 3;

                //replace RGB value with avg
                p = (a << 24) | (avg << 16) | (avg << 8) | avg;

                image.setRGB(x, y, p);
            }
        }

        return image;
    }

}
