package com.everimaging.fotorsdk.imagepicker;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.support.v4.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.uil.core.assist.e;
import com.everimaging.fotorsdk.uil.core.assist.f;
import com.everimaging.fotorsdk.utils.BitmapDecodeUtils;
import com.everimaging.fotorsdk.utils.BitmapUtils;
import com.everimaging.fotorsdk.utils.DeviceUtils;
import com.everimaging.fotorsdk.utils.FotorAsyncTask;
import com.everimaging.fotorsdk.utils.Utils;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class c {
    private static final String a = c.class.getSimpleName();
    private static final FotorLoggerFactory.c c = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);
    private final Map<Integer, String> b = Collections.synchronizedMap(new HashMap());
    private LruCache<String, Bitmap> d;
    private final Map<String, b> e = Collections.synchronizedMap(new HashMap());
    private Context f;

    public c(Context paramContext) {
        this.f = paramContext;
        int i = 30;
        if (paramContext != null) {
            i = ((ActivityManager) paramContext.getSystemService("activity")).getMemoryClass();
        }
        c.f(new Object[]{"memory class is:" + i + "MB"});
        this.d = new LruCache(i * 1048576 / 4) {
            protected int a(String paramAnonymousString, Bitmap paramAnonymousBitmap) {
                if (paramAnonymousBitmap != null) {
                    return paramAnonymousBitmap.getRowBytes() * paramAnonymousBitmap.getHeight();
                }
                return super.sizeOf(paramAnonymousString, paramAnonymousBitmap);
            }
        };
    }

    private boolean b(com.everimaging.fotorsdk.uil.core.imageaware.a parama, String paramString) {
        return !paramString.equals(a(parama));
    }

    String a(com.everimaging.fotorsdk.uil.core.imageaware.a parama) {
        return (String) this.b.get(Integer.valueOf(parama.f()));
    }

    public void a() {
        c.c(new Object[]{"======clearMemory====="});
        Utils.printMemoryInfo();
        this.d.trimToSize(-1);
        Utils.printMemoryInfo();
    }

    public void a(ImageView paramImageView, Picture paramPicture, int paramInt1, int paramInt2, int paramInt3, a parama) {
        a(new com.everimaging.fotorsdk.uil.core.imageaware.c(paramImageView), paramPicture, paramInt1, paramInt2, paramInt3, parama);
    }

    public void a(com.everimaging.fotorsdk.uil.core.imageaware.a parama, Picture paramPicture, int paramInt1, int paramInt2, int paramInt3, a parama1) {
        Object localObject = com.everimaging.fotorsdk.uil.utils.a.a(parama, new e(DeviceUtils.getScreenWidth(), DeviceUtils.getScreenHeight()));
        localObject = f.a(paramPicture.c(), (e) localObject);
        a(parama, (String) localObject);
        Bitmap localBitmap = (Bitmap) this.d.get(localObject);
        if (parama1 != null) {
            parama1.a((ImageView) parama.d(), paramPicture);
        }
        if (localBitmap == null) {
            if (this.e.containsKey(localObject)) {
                c.e(new Object[]{"load bitmap task is already running.key->" + (String) localObject});
            }
        }
        do {
            return;
            parama.a(null);
            parama = new b(parama, (String) localObject, paramPicture, paramInt1, paramInt2, paramInt3, parama1);
            parama.execute(new Bitmap[0]);
            this.e.put(localObject, parama);
            return;
            parama.a(localBitmap);
        } while (parama1 == null);
        parama1.b((ImageView) parama.d(), paramPicture);
    }

    void a(com.everimaging.fotorsdk.uil.core.imageaware.a parama, String paramString) {
        this.b.put(Integer.valueOf(parama.f()), paramString);
    }

    void b(com.everimaging.fotorsdk.uil.core.imageaware.a parama) {
        this.b.remove(Integer.valueOf(parama.f()));
    }

    protected void finalize()
            throws Throwable {
        c.c(new Object[]{"======finalize====="});
        a();
        super.finalize();
    }

    public static abstract interface a {
        public abstract void a(View paramView, Picture paramPicture);

        public abstract void b(View paramView, Picture paramPicture);

        public abstract void c(View paramView, Picture paramPicture);
    }

    private class b
            extends FotorAsyncTask<Bitmap, Void, Bitmap> {
        private com.everimaging.fotorsdk.uil.core.imageaware.a b;
        private Picture c;
        private int d;
        private c.a e;
        private String f;
        private int g;
        private int h;

        public b(com.everimaging.fotorsdk.uil.core.imageaware.a parama, String paramString, Picture paramPicture, int paramInt1, int paramInt2, int paramInt3, c.a parama1) {
            this.b = parama;
            this.c = paramPicture;
            this.d = paramInt1;
            this.e = parama1;
            this.f = paramString;
            this.g = paramInt2;
            this.h = paramInt3;
        }

        private void b(Bitmap paramBitmap) {
            if (this.b.e()) {
                c.b().c(new Object[]{"ImageAware is GC ,so cancel. "});
                if (this.e != null) {
                    this.e.c(this.b.d(), this.c);
                }
            }
            do {
                do {
                    return;
                    if (!c.a(c.this, this.b, this.f)) {
                        break;
                    }
                    c.b().c(new Object[]{"ImageAware is reused for another image. "});
                } while (this.e == null);
                this.e.c(this.b.d(), this.c);
                return;
                this.b.a(paramBitmap);
                c.this.b(this.b);
            } while (this.e == null);
            this.e.b(this.b.d(), this.c);
        }

        public Bitmap a(int paramInt1, int paramInt2) {
            try {
                Bitmap localBitmap = MediaStore.Images.Thumbnails.getThumbnail(c.a(c.this).getContentResolver(), paramInt1, paramInt2, 1, null);
                return localBitmap;
            } catch (OutOfMemoryError localOutOfMemoryError) {
            }
            return null;
        }

        protected Bitmap a(Bitmap... paramVarArgs) {
            paramVarArgs = null;
            if ((this.b.e()) || (c.a(c.this, this.b, this.f))) {
                c.b().c(new Object[]{"task was canceled"});
            }
            Bitmap localBitmap2;
            Bitmap localBitmap1;
            do {
                return paramVarArgs;
                localBitmap2 = a(this.c.f(), Integer.parseInt(this.c.a()));
                if (localBitmap2 == null) {
                    return BitmapDecodeUtils.decode(null, Uri.fromFile(new File(this.c.c())), this.g, this.h, null, this.c.d());
                }
                if (this.c.d() == 0) {
                    break;
                }
                localBitmap1 = BitmapUtils.rotateBitmap(localBitmap2, this.c.d(), false, false);
                paramVarArgs = localBitmap1;
            } while (localBitmap2 == localBitmap1);
            localBitmap2.recycle();
            return localBitmap1;
            return localBitmap2;
        }

        protected void a(Bitmap paramBitmap) {
            if (paramBitmap != null) {
                c.b(c.this).put(this.f, paramBitmap);
            }
            b(paramBitmap);
            c.c(c.this).remove(this.f);
        }

        protected void onCancelled() {
            c.c(c.this).remove(this.f);
        }

        protected void onPreExecute() {
            ImageView localImageView = (ImageView) this.b.d();
            if ((localImageView != null) && (localImageView.getDrawable() == null)) {
                if (this.d == 0) {
                    this.b.a(null);
                }
            } else {
                return;
            }
            this.b.a(this.d);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/imagepicker/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */