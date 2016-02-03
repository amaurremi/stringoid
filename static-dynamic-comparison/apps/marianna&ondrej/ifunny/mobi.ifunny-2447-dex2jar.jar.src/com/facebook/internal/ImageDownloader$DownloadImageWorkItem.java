package com.facebook.internal;

import android.content.Context;

class ImageDownloader$DownloadImageWorkItem
        implements Runnable {
    private Context context;
    private ImageDownloader.RequestKey key;

    ImageDownloader$DownloadImageWorkItem(Context paramContext, ImageDownloader.RequestKey paramRequestKey) {
        this.context = paramContext;
        this.key = paramRequestKey;
    }

    public void run() {
        ImageDownloader.access$200(this.key, this.context);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/ImageDownloader$DownloadImageWorkItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */