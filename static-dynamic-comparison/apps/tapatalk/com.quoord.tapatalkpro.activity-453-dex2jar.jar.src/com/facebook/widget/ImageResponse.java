package com.facebook.widget;

import android.graphics.Bitmap;

class ImageResponse {
    private Bitmap bitmap;
    private Exception error;
    private boolean isCachedRedirect;
    private ImageRequest request;

    ImageResponse(ImageRequest paramImageRequest, Exception paramException, boolean paramBoolean, Bitmap paramBitmap) {
        this.request = paramImageRequest;
        this.error = paramException;
        this.bitmap = paramBitmap;
        this.isCachedRedirect = paramBoolean;
    }

    Bitmap getBitmap() {
        return this.bitmap;
    }

    Exception getError() {
        return this.error;
    }

    ImageRequest getRequest() {
        return this.request;
    }

    boolean isCachedRedirect() {
        return this.isCachedRedirect;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/widget/ImageResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */