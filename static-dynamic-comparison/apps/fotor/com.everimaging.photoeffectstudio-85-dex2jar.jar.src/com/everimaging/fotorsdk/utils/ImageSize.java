package com.everimaging.fotorsdk.utils;

public class ImageSize {
    private int newHeight;
    private int newWidth;
    private int originalHeight;
    private int originalWidth;

    public ImageSize() {
        this.originalHeight = -1;
        this.originalWidth = -1;
    }

    public ImageSize(int paramInt1, int paramInt2) {
        this.originalWidth = paramInt1;
        this.originalHeight = paramInt2;
    }

    public int getNewHeight() {
        return this.newHeight;
    }

    public int getNewWidth() {
        return this.newWidth;
    }

    public int getOriginalHeight() {
        return this.originalHeight;
    }

    public int getOriginalWidth() {
        return this.originalWidth;
    }

    public void setNewHeight(int paramInt) {
        this.newHeight = paramInt;
    }

    public void setNewSize(int paramInt1, int paramInt2) {
        this.newWidth = paramInt1;
        this.newHeight = paramInt2;
    }

    public void setNewWidth(int paramInt) {
        this.newWidth = paramInt;
    }

    public void setOriginalHeight(int paramInt) {
        this.originalHeight = paramInt;
    }

    public void setOriginalSize(int paramInt1, int paramInt2) {
        this.originalWidth = paramInt1;
        this.originalHeight = paramInt2;
    }

    public void setOriginalWidth(int paramInt) {
        this.originalWidth = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/ImageSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */