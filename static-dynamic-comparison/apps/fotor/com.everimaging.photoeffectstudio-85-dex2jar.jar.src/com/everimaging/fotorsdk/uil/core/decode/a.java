package com.everimaging.fotorsdk.uil.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import com.everimaging.fotorsdk.uil.core.assist.ImageScaleType;
import com.everimaging.fotorsdk.uil.core.assist.ViewScaleType;
import com.everimaging.fotorsdk.uil.core.assist.e;
import com.everimaging.fotorsdk.uil.core.download.ImageDownloader;
import com.everimaging.fotorsdk.uil.core.download.ImageDownloader.Scheme;

import java.io.IOException;
import java.io.InputStream;

public class a
        implements b {
    protected final boolean a;

    public a(boolean paramBoolean) {
        this.a = paramBoolean;
    }

    private boolean a(String paramString1, String paramString2) {
        return (Build.VERSION.SDK_INT >= 5) && ("image/jpeg".equalsIgnoreCase(paramString2)) && (ImageDownloader.Scheme.ofUri(paramString1) == ImageDownloader.Scheme.FILE);
    }

    protected Bitmap a(Bitmap paramBitmap, c paramc, int paramInt, boolean paramBoolean) {
        Matrix localMatrix = new Matrix();
        ImageScaleType localImageScaleType = paramc.d();
        e locale1;
        e locale2;
        ViewScaleType localViewScaleType;
        if ((localImageScaleType == ImageScaleType.EXACTLY) || (localImageScaleType == ImageScaleType.EXACTLY_STRETCHED)) {
            locale1 = new e(paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt);
            locale2 = paramc.c();
            localViewScaleType = paramc.e();
            if (localImageScaleType != ImageScaleType.EXACTLY_STRETCHED) {
                break label257;
            }
        }
        label257:
        for (boolean bool = true; ; bool = false) {
            float f = com.everimaging.fotorsdk.uil.utils.a.b(locale1, locale2, localViewScaleType, bool);
            if (Float.compare(f, 1.0F) != 0) {
                localMatrix.setScale(f, f);
                if (this.a) {
                    com.everimaging.fotorsdk.uil.utils.c.a("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", new Object[]{locale1, locale1.a(f), Float.valueOf(f), paramc.a()});
                }
            }
            if (paramBoolean) {
                localMatrix.postScale(-1.0F, 1.0F);
                if (this.a) {
                    com.everimaging.fotorsdk.uil.utils.c.a("Flip image horizontally [%s]", new Object[]{paramc.a()});
                }
            }
            if (paramInt != 0) {
                localMatrix.postRotate(paramInt);
                if (this.a) {
                    com.everimaging.fotorsdk.uil.utils.c.a("Rotate image on %1$d° [%2$s]", new Object[]{Integer.valueOf(paramInt), paramc.a()});
                }
            }
            paramc = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
            if (paramc != paramBitmap) {
                paramBitmap.recycle();
            }
            return paramc;
        }
    }

    public Bitmap a(c paramc)
            throws IOException {
        InputStream localInputStream2 = b(paramc);
        InputStream localInputStream1 = localInputStream2;
        b localb;
        Bitmap localBitmap;
        try {
            localb = a(localInputStream2, paramc);
            localInputStream1 = localInputStream2;
            localInputStream2 = b(localInputStream2, paramc);
            localInputStream1 = localInputStream2;
            localBitmap = BitmapFactory.decodeStream(localInputStream2, null, a(localb.a, paramc));
            com.everimaging.fotorsdk.uil.utils.b.a(localInputStream2);
            if (localBitmap == null) {
                com.everimaging.fotorsdk.uil.utils.c.d("Image can't be decoded [%s]", new Object[]{paramc.a()});
                return localBitmap;
            }
        } finally {
            com.everimaging.fotorsdk.uil.utils.b.a(localInputStream1);
        }
        return a(localBitmap, paramc, localb.b.a, localb.b.b);
    }

    protected BitmapFactory.Options a(e parame, c paramc) {
        ImageScaleType localImageScaleType = paramc.d();
        int i;
        if (localImageScaleType == ImageScaleType.NONE) {
            i = com.everimaging.fotorsdk.uil.utils.a.a(parame);
            if ((i > 1) && (this.a)) {
                com.everimaging.fotorsdk.uil.utils.c.a("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", new Object[]{parame, parame.a(i), Integer.valueOf(i), paramc.a()});
            }
            parame = paramc.i();
            parame.inSampleSize = i;
            return parame;
        }
        e locale = paramc.c();
        if (localImageScaleType == ImageScaleType.IN_SAMPLE_POWER_OF_2) {
        }
        for (boolean bool = true; ; bool = false) {
            i = com.everimaging.fotorsdk.uil.utils.a.a(parame, locale, paramc.e(), bool);
            break;
        }
    }

    protected a a(String paramString) {
        int j = 0;
        boolean bool2 = true;
        boolean bool3 = true;
        boolean bool4 = true;
        boolean bool1 = true;
        try {
            int k = new ExifInterface(ImageDownloader.Scheme.FILE.crop(paramString)).getAttributeInt("Orientation", 1);
            i = j;
            switch (k) {
            }
        } catch (IOException localIOException) {
            for (; ; ) {
                int i;
                com.everimaging.fotorsdk.uil.utils.c.c("Can't read EXIF tags from file [%s]", new Object[]{paramString});
            }
        }
        bool1 = false;
        i = j;
        for (; ; ) {
            return new a(i, bool1);
            bool2 = false;
            i = 90;
            bool1 = bool2;
            continue;
            bool3 = false;
            i = 180;
            bool1 = bool3;
            continue;
            bool4 = false;
            i = 270;
            bool1 = bool4;
        }
    }

    protected b a(InputStream paramInputStream, c paramc)
            throws IOException {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(paramInputStream, null, localOptions);
        paramInputStream = paramc.b();
        if ((paramc.h()) && (a(paramInputStream, localOptions.outMimeType))) {
        }
        for (paramInputStream = a(paramInputStream); ; paramInputStream = new a()) {
            return new b(new e(localOptions.outWidth, localOptions.outHeight, paramInputStream.a), paramInputStream);
        }
    }

    protected InputStream b(c paramc)
            throws IOException {
        return paramc.f().a(paramc.b(), paramc.g());
    }

    protected InputStream b(InputStream paramInputStream, c paramc)
            throws IOException {
        try {
            paramInputStream.reset();
            return paramInputStream;
        } catch (IOException localIOException) {
            com.everimaging.fotorsdk.uil.utils.b.a(paramInputStream);
        }
        return b(paramc);
    }

    protected static class a {
        public final int a;
        public final boolean b;

        protected a() {
            this.a = 0;
            this.b = false;
        }

        protected a(int paramInt, boolean paramBoolean) {
            this.a = paramInt;
            this.b = paramBoolean;
        }
    }

    protected static class b {
        public final e a;
        public final a.a b;

        protected b(e parame, a.a parama) {
            this.a = parame;
            this.b = parama;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/core/decode/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */