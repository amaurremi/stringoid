package com.everimaging.fotorsdk.collage.params;

import com.everimaging.fotorsdk.filter.params.EffectsParams;
import com.everimaging.fotorsdk.imagepicker.Picture;

public class CollageSlotItemParam {
    private float displayCenterX = 0.0F;
    private float displayCenterY = 0.0F;
    private EffectsParams effectParams = null;
    private int imageAngle = 0;
    private boolean isFlipH = false;
    private boolean isFlipV = false;
    private Picture picture = null;
    private int slotIndex;
    private int thumbnailHeight;
    private int thumbnailWidth;
    private float userScale = 1.0F;
    private int zIndex;

    public float getDisplayCenterX() {
        return this.displayCenterX;
    }

    public float getDisplayCenterY() {
        return this.displayCenterY;
    }

    public EffectsParams getEffectParams() {
        return this.effectParams;
    }

    public int getImageAngle() {
        return this.imageAngle;
    }

    public Picture getPicture() {
        return this.picture;
    }

    public int getSlotIndex() {
        return this.slotIndex;
    }

    public int getThumbnailHeight() {
        return this.thumbnailHeight;
    }

    public int getThumbnailWidth() {
        return this.thumbnailWidth;
    }

    public float getUserScale() {
        return this.userScale;
    }

    public int getZIndex() {
        return this.zIndex;
    }

    public boolean isFlipH() {
        return this.isFlipH;
    }

    public boolean isFlipV() {
        return this.isFlipV;
    }

    public void setDisplayCenterX(float paramFloat) {
        this.displayCenterX = paramFloat;
    }

    public void setDisplayCenterY(float paramFloat) {
        this.displayCenterY = paramFloat;
    }

    public void setEffectParams(EffectsParams paramEffectsParams) {
        this.effectParams = paramEffectsParams;
    }

    public void setFlipH(boolean paramBoolean) {
        this.isFlipH = paramBoolean;
    }

    public void setFlipV(boolean paramBoolean) {
        this.isFlipV = paramBoolean;
    }

    public void setImageAngle(int paramInt) {
        this.imageAngle = paramInt;
    }

    public void setPicture(Picture paramPicture) {
        this.picture = paramPicture;
    }

    public void setSlotIndex(int paramInt) {
        this.slotIndex = paramInt;
    }

    public void setThumbnailHeight(int paramInt) {
        this.thumbnailHeight = paramInt;
    }

    public void setThumbnailWidth(int paramInt) {
        this.thumbnailWidth = paramInt;
    }

    public void setUserScale(float paramFloat) {
        this.userScale = paramFloat;
    }

    public void setZIndex(int paramInt) {
        this.zIndex = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/params/CollageSlotItemParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */