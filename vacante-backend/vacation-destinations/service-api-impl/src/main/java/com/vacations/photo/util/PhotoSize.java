package com.vacations.photo.util;

import java.util.Arrays;
import java.util.List;

public enum PhotoSize {
    THUMBNAIL(200, 200, 2),
    MEDIUM(800, 800, 1.7f),
    LARGE(1280, 1280, 1.3f),
    BARCODE_LARGE(8000, 8000, 1),//scale photo to bigger size to improve barcode reading
    ORIGINAL(20000, 20000, 1), //the size should not be take in consideration for original
    MAX_SIZE(1500, 1500, 1);

    final public int heightPx;
    final public int widthPx;
    public final float scaleFactor;

    PhotoSize(int heightPx, int widthPx, float scaleFactor) {
        this.heightPx = heightPx;
        this.widthPx = widthPx;
        this.scaleFactor = scaleFactor;
    }

    public static boolean isNotMinPhotoSize(int width, int height) {
        return width < 470 || height < 470;
    }

    public static boolean isPhotoSizeBiggerThanMaxSize(int width, int height) {
        return width > 1500 || height > 1500;
    }

    private static final List<PhotoSize> SCALABLE_PHOTO_SIZES = Arrays.asList(
            THUMBNAIL, MEDIUM, LARGE);

    public static List<PhotoSize> getScalablePhotoSizes() {
        return SCALABLE_PHOTO_SIZES;
    }
}
