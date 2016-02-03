package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.internal.fa;
import com.google.android.gms.internal.fb;
import com.google.android.gms.internal.fu;
import com.google.android.gms.internal.gr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object BY = new Object();
    private static HashSet<Uri> BZ = new HashSet();
    private static ImageManager Ca;
    private static ImageManager Cb;
    private final ExecutorService Cc;
    private final b Cd;
    private final fa Ce;
    private final Map<a, ImageReceiver> Cf;
    private final Map<Uri, ImageReceiver> Cg;
    private final Context mContext;
    private final Handler mHandler;

    private ImageManager(Context paramContext, boolean paramBoolean) {
        this.mContext = paramContext.getApplicationContext();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.Cc = Executors.newFixedThreadPool(4);
        if (paramBoolean) {
            this.Cd = new b(this.mContext);
            if (gr.fx()) {
                ev();
            }
        }
        for (; ; ) {
            this.Ce = new fa();
            this.Cf = new HashMap();
            this.Cg = new HashMap();
            return;
            this.Cd = null;
        }
    }

    private Bitmap a(a.a parama) {
        if (this.Cd == null) {
            return null;
        }
        return (Bitmap) this.Cd.get(parama);
    }

    public static ImageManager a(Context paramContext, boolean paramBoolean) {
        if (paramBoolean) {
            if (Cb == null) {
                Cb = new ImageManager(paramContext, true);
            }
            return Cb;
        }
        if (Ca == null) {
            Ca = new ImageManager(paramContext, false);
        }
        return Ca;
    }

    public static ImageManager create(Context paramContext) {
        return a(paramContext, false);
    }

    private void ev() {
        this.mContext.registerComponentCallbacks(new e(this.Cd));
    }

    public void a(a parama) {
        fb.aj("ImageManager.loadImage() must be called in the main thread");
        new d(parama).run();
    }

    public void loadImage(ImageView paramImageView, int paramInt) {
        a(new a.b(paramImageView, paramInt));
    }

    public void loadImage(ImageView paramImageView, Uri paramUri) {
        a(new a.b(paramImageView, paramUri));
    }

    public void loadImage(ImageView paramImageView, Uri paramUri, int paramInt) {
        paramImageView = new a.b(paramImageView, paramUri);
        paramImageView.J(paramInt);
        a(paramImageView);
    }

    public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri) {
        a(new a.c(paramOnImageLoadedListener, paramUri));
    }

    public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt) {
        paramOnImageLoadedListener = new a.c(paramOnImageLoadedListener, paramUri);
        paramOnImageLoadedListener.J(paramInt);
        a(paramOnImageLoadedListener);
    }

    private final class ImageReceiver
            extends ResultReceiver {
        private final ArrayList<a> Ch;
        private final Uri mUri;

        ImageReceiver(Uri paramUri) {
            super();
            this.mUri = paramUri;
            this.Ch = new ArrayList();
        }

        public void b(a parama) {
            fb.aj("ImageReceiver.addImageRequest() must be called in the main thread");
            this.Ch.add(parama);
        }

        public void c(a parama) {
            fb.aj("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.Ch.remove(parama);
        }

        public void ey() {
            Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            localIntent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            localIntent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.b(ImageManager.this).sendBroadcast(localIntent);
        }

        public void onReceiveResult(int paramInt, Bundle paramBundle) {
            paramBundle = (ParcelFileDescriptor) paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            ImageManager.e(ImageManager.this).execute(new ImageManager.c(ImageManager.this, this.mUri, paramBundle));
        }
    }

    public static abstract interface OnImageLoadedListener {
        public abstract void onImageLoaded(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
    }

    private static final class a {
        static int a(ActivityManager paramActivityManager) {
            return paramActivityManager.getLargeMemoryClass();
        }
    }

    private static final class b
            extends fu<a.a, Bitmap> {
        public b(Context paramContext) {
            super();
        }

        private static int w(Context paramContext) {
            ActivityManager localActivityManager = (ActivityManager) paramContext.getSystemService("activity");
            if ((paramContext.getApplicationInfo().flags & 0x100000) != 0) {
                i = 1;
                if ((i == 0) || (!gr.fu())) {
                    break label55;
                }
            }
            label55:
            for (int i = ImageManager.a.a(localActivityManager); ; i = localActivityManager.getMemoryClass()) {
                return (int) (i * 1048576 * 0.33F);
                i = 0;
                break;
            }
        }

        protected int a(a.a parama, Bitmap paramBitmap) {
            return paramBitmap.getHeight() * paramBitmap.getRowBytes();
        }

        protected void a(boolean paramBoolean, a.a parama, Bitmap paramBitmap1, Bitmap paramBitmap2) {
            super.entryRemoved(paramBoolean, parama, paramBitmap1, paramBitmap2);
        }
    }

    private final class c
            implements Runnable {
        private final ParcelFileDescriptor Cj;
        private final Uri mUri;

        public c(Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor) {
            this.mUri = paramUri;
            this.Cj = paramParcelFileDescriptor;
        }

        public void run() {
            fb.ak("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean bool1 = false;
            boolean bool2 = false;
            Bitmap localBitmap = null;
            CountDownLatch localCountDownLatch = null;
            if (this.Cj != null) {
            }
            try {
                localBitmap = BitmapFactory.decodeFileDescriptor(this.Cj.getFileDescriptor());
                bool1 = bool2;
                Object localObject;
                return;
            } catch (OutOfMemoryError localOutOfMemoryError) {
                try {
                    for (; ; ) {
                        this.Cj.close();
                        localCountDownLatch = new CountDownLatch(1);
                        ImageManager.f(ImageManager.this).post(new ImageManager.f(ImageManager.this, this.mUri, localBitmap, bool1, localCountDownLatch));
                        try {
                            localCountDownLatch.await();
                            return;
                        } catch (InterruptedException localInterruptedException) {
                            Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
                        }
                        localOutOfMemoryError = localOutOfMemoryError;
                        Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, localOutOfMemoryError);
                        bool1 = true;
                        localObject = localCountDownLatch;
                    }
                } catch (IOException localIOException) {
                    for (; ; ) {
                        Log.e("ImageManager", "closed failed", localIOException);
                    }
                }
            }
        }
    }

    private final class d
            implements Runnable {
        private final a Ck;

        public d(a parama) {
            this.Ck = parama;
        }

        public void run() {
            fb.aj("LoadImageRunnable must be executed on the main thread");
            Object localObject1 = (ImageManager.ImageReceiver) ImageManager.a(ImageManager.this).get(this.Ck);
            if (localObject1 != null) {
                ImageManager.a(ImageManager.this).remove(this.Ck);
                ((ImageManager.ImageReceiver) localObject1).c(this.Ck);
            }
            a.a locala = this.Ck.Cm;
            if (locala.uri == null) {
                this.Ck.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this), true);
                return;
            }
            localObject1 = ImageManager.a(ImageManager.this, locala);
            if (localObject1 != null) {
                this.Ck.a(ImageManager.b(ImageManager.this), (Bitmap) localObject1, true);
                return;
            }
            this.Ck.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this));
            ???=(ImageManager.ImageReceiver) ImageManager.d(ImageManager.this).get(locala.uri);
            localObject1 =???;
            if (???==null)
            {
                localObject1 = new ImageManager.ImageReceiver(ImageManager.this, locala.uri);
                ImageManager.d(ImageManager.this).put(locala.uri, localObject1);
            }
            ((ImageManager.ImageReceiver) localObject1).b(this.Ck);
            if (!(this.Ck instanceof a.c)) {
                ImageManager.a(ImageManager.this).put(this.Ck, localObject1);
            }
            synchronized (ImageManager.ew()) {
                if (!ImageManager.ex().contains(locala.uri)) {
                    ImageManager.ex().add(locala.uri);
                    ((ImageManager.ImageReceiver) localObject1).ey();
                }
                return;
            }
        }
    }

    private static final class e
            implements ComponentCallbacks2 {
        private final ImageManager.b Cd;

        public e(ImageManager.b paramb) {
            this.Cd = paramb;
        }

        public void onConfigurationChanged(Configuration paramConfiguration) {
        }

        public void onLowMemory() {
            this.Cd.evictAll();
        }

        public void onTrimMemory(int paramInt) {
            if (paramInt >= 60) {
                this.Cd.evictAll();
            }
            while (paramInt < 20) {
                return;
            }
            this.Cd.trimToSize(this.Cd.size() / 2);
        }
    }

    private final class f
            implements Runnable {
        private final CountDownLatch AD;
        private boolean Cl;
        private final Bitmap mBitmap;
        private final Uri mUri;

        public f(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch) {
            this.mUri = paramUri;
            this.mBitmap = paramBitmap;
            this.Cl = paramBoolean;
            this.AD = paramCountDownLatch;
        }

        private void a(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean) {
            paramImageReceiver = ImageManager.ImageReceiver.a(paramImageReceiver);
            int j = paramImageReceiver.size();
            int i = 0;
            if (i < j) {
                a locala = (a) paramImageReceiver.get(i);
                if (paramBoolean) {
                    locala.a(ImageManager.b(ImageManager.this), this.mBitmap, false);
                }
                for (; ; ) {
                    if (!(locala instanceof a.c)) {
                        ImageManager.a(ImageManager.this).remove(locala);
                    }
                    i += 1;
                    break;
                    locala.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this), false);
                }
            }
        }

        public void run() {
            fb.aj("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean bool;
            if (this.mBitmap != null) {
                bool = true;
            }
            while (ImageManager.g(ImageManager.this) != null) {
                if (this.Cl) {
                    ImageManager.g(ImageManager.this).evictAll();
                    System.gc();
                    this.Cl = false;
                    ImageManager.f(ImageManager.this).post(this);
                    return;
                    bool = false;
                } else if (bool) {
                    ImageManager.g(ImageManager.this).put(new a.a(this.mUri), this.mBitmap);
                }
            }
            ???=(ImageManager.ImageReceiver) ImageManager.d(ImageManager.this).remove(this.mUri);
            if (???!=null){
                a((ImageManager.ImageReceiver) ? ??,bool);
            }
            this.AD.countDown();
            synchronized (ImageManager.ew()) {
                ImageManager.ex().remove(this.mUri);
                return;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/common/images/ImageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */