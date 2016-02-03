package com.facebook.internal;

import android.graphics.Bitmap;

final class ImageDownloader$1
        implements Runnable {
    ImageDownloader$1(ImageRequest paramImageRequest, Exception paramException, boolean paramBoolean, Bitmap paramBitmap, ImageRequest.Callback paramCallback) {
    }

    public void run() {
        ImageResponse localImageResponse = new ImageResponse(this.val$request, this.val$error, this.val$isCachedRedirect, this.val$bitmap);
        this.val$callback.onCompleted(localImageResponse);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/ImageDownloader$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */