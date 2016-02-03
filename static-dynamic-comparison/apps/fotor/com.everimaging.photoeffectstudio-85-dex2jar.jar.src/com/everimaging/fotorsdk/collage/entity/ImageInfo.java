package com.everimaging.fotorsdk.collage.entity;

import android.graphics.Bitmap;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;
import com.everimaging.fotorsdk.imagepicker.Picture;

public class ImageInfo {
    private EffectEntity effectEntity;
    private Picture picture;
    private Bitmap previewBitmap;
    private Bitmap sourceBitmap;
    private Bitmap thumbnail;

    public EffectEntity getEffectEntity() {
        return this.effectEntity;
    }

    public int getImageId() {
        if (this.picture != null) {
            return this.picture.f();
        }
        return -1;
    }

    public Picture getPicture() {
        return this.picture;
    }

    public Bitmap getPreviewBitmap() {
        return this.previewBitmap;
    }

    public Bitmap getSourceBitmap() {
        return this.sourceBitmap;
    }

    public Bitmap getThumbnail() {
        return this.thumbnail;
    }

    public void setEffectEntity(EffectEntity paramEffectEntity) {
        this.effectEntity = paramEffectEntity;
    }

    public void setPicture(Picture paramPicture) {
        this.picture = paramPicture;
    }

    public void setPreviewBitmap(Bitmap paramBitmap) {
        this.previewBitmap = paramBitmap;
    }

    public void setSourceBitmap(Bitmap paramBitmap) {
        this.sourceBitmap = paramBitmap;
    }

    public void setThumbnail(Bitmap paramBitmap) {
        this.thumbnail = paramBitmap;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/entity/ImageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */