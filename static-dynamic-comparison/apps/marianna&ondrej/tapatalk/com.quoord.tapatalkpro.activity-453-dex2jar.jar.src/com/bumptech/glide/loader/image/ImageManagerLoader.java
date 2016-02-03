package com.bumptech.glide.loader.image;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.loader.stream.StreamLoader;
import com.bumptech.glide.resize.ImageManager;
import com.bumptech.glide.resize.ImageManager.LoadToken;
import com.bumptech.glide.resize.LoadedCallback;
import com.bumptech.glide.resize.load.Downsampler;
import com.bumptech.glide.resize.load.Transformation;

public class ImageManagerLoader
        implements ImageLoader {
    private Bitmap acquired;
    private final Downsampler downsampler;
    private final ImageManager imageManager;
    private ImageManager.LoadToken loadToken;

    public ImageManagerLoader(Context paramContext) {
        this(paramContext, Downsampler.AT_LEAST);
    }

    public ImageManagerLoader(Context paramContext, Downsampler paramDownsampler) {
        this(Glide.get().getImageManager(paramContext), paramDownsampler);
    }

    public ImageManagerLoader(ImageManager paramImageManager) {
        this(paramImageManager, Downsampler.AT_LEAST);
    }

    public ImageManagerLoader(ImageManager paramImageManager, Downsampler paramDownsampler) {
        this.imageManager = paramImageManager;
        this.downsampler = paramDownsampler;
    }

    private void releaseAcquired() {
        if (this.acquired != null) {
            this.imageManager.releaseBitmap(this.acquired);
            this.acquired = null;
        }
    }

    public void clear() {
        releaseAcquired();
        if (this.loadToken != null) {
            this.loadToken.cancel();
            this.loadToken = null;
        }
    }

    public Object fetchImage(String paramString, StreamLoader paramStreamLoader, Transformation paramTransformation, int paramInt1, int paramInt2, final ImageLoader.ImageReadyCallback paramImageReadyCallback) {
        if (!isHandled(paramInt1, paramInt2)) {
            throw new IllegalArgumentException(getClass() + " cannot handle width=" + paramInt1 + " and/or height =" + paramInt2);
        }
        this.loadToken = this.imageManager.getImage(paramString, paramStreamLoader, paramTransformation, this.downsampler, paramInt1, paramInt2, new LoadedCallback() {
            public void onLoadCompleted(Bitmap paramAnonymousBitmap) {
                ImageManagerLoader.this.onImageReady(paramAnonymousBitmap, paramImageReadyCallback.onImageReady(paramAnonymousBitmap));
            }

            public void onLoadFailed(Exception paramAnonymousException) {
                paramImageReadyCallback.onException(paramAnonymousException);
            }
        });
        return this.loadToken;
    }

    protected boolean isHandled(int paramInt1, int paramInt2) {
        return ((paramInt1 >= 0) && (paramInt2 >= 0)) || ((this.downsampler == Downsampler.NONE) && ((paramInt1 == -2) || (paramInt2 == -2)));
    }

    protected void onImageReady(Bitmap paramBitmap, boolean paramBoolean) {
        if (paramBoolean) {
            releaseAcquired();
            this.acquired = paramBitmap;
            return;
        }
        this.imageManager.releaseBitmap(paramBitmap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/loader/image/ImageManagerLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */