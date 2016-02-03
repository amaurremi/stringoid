package com.mopub.nativeads;

import android.widget.ImageView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Utils;

import java.util.Arrays;
import java.util.WeakHashMap;

class ImageViewService {
    private static final WeakHashMap<ImageView, Long> sImageViewRequestIds = new WeakHashMap();

    @Deprecated
    @VisibleForTesting
    static Long getImageViewUniqueId(ImageView paramImageView) {
        return (Long) sImageViewRequestIds.get(paramImageView);
    }

    static void loadImageView(String paramString, ImageView paramImageView) {
        if (paramImageView == null) {
            MoPubLog.d("Attempted to load an image into a null ImageView");
        }
        do {
            return;
            paramImageView.setImageDrawable(null);
        } while (paramString == null);
        long l = Utils.generateUniqueId();
        sImageViewRequestIds.put(paramImageView, Long.valueOf(l));
        ImageService.get(Arrays.asList(new String[]{paramString}), new ImageViewService.MyImageViewServiceListener(paramString, paramImageView, l));
    }

    @Deprecated
    @VisibleForTesting
    static void setImageViewUniqueId(ImageView paramImageView, long paramLong) {
        sImageViewRequestIds.put(paramImageView, Long.valueOf(paramLong));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/ImageViewService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */