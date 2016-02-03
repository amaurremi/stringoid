package com.facebook.internal;

import android.content.Context;

class ImageDownloader$CacheReadWorkItem
        implements Runnable {
    private boolean allowCachedRedirects;
    private Context context;
    private ImageDownloader.RequestKey key;

    ImageDownloader$CacheReadWorkItem(Context paramContext, ImageDownloader.RequestKey paramRequestKey, boolean paramBoolean) {
        this.context = paramContext;
        this.key = paramRequestKey;
        this.allowCachedRedirects = paramBoolean;
    }

    public void run() {
        ImageDownloader.access$100(this.key, this.context, this.allowCachedRedirects);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/ImageDownloader$CacheReadWorkItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */