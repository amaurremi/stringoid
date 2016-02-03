package com.everimaging.fotorsdk.collage.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.SystemUtils;

public class c {
    private static final String a = c.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private static c d;
    private LruCache<String, Bitmap> c = new LruCache((int) (SystemUtils.getApplicationTotalMemory() * 1048576.0D / 6.0D)) {
        protected int a(String paramAnonymousString, Bitmap paramAnonymousBitmap) {
            if (paramAnonymousBitmap != null) {
                return paramAnonymousBitmap.getRowBytes() * paramAnonymousBitmap.getHeight();
            }
            return super.sizeOf(paramAnonymousString, paramAnonymousBitmap);
        }
    };

    public static c a() {
        if (d == null) {
            d = new c();
        }
        return d;
    }

    public Bitmap a(String paramString) {
        return (Bitmap) this.c.get(paramString);
    }

    public void a(String paramString, Bitmap paramBitmap) {
        this.c.put(paramString, paramBitmap);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/utils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */