package com.everimaging.fotorsdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.uil.core.assist.e;
import com.everimaging.fotorsdk.uil.core.assist.f;
import com.everimaging.fotorsdk.uil.core.imageaware.c;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GridThumbStreamLoader {
    private static final int DEFAULT_CACHE_SIZE_FRACTION = 10;
    private static final String TAG = GridThumbStreamLoader.class.getSimpleName();
    private static final FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);
    private final Map<Integer, String> cacheKeysForImageAwares = Collections.synchronizedMap(new HashMap());
    private int mCacheSizeFraction;
    private Context mContext;
    private LruCache<String, Bitmap> mLruCache;
    private int mTargetDensity;
    private final Map<String, a> mTaskMaps = Collections.synchronizedMap(new HashMap());
    private StreamThumbProcessor mThumbProcessor;

    public GridThumbStreamLoader(Context paramContext, StreamThumbProcessor paramStreamThumbProcessor) {
        this(paramContext, paramStreamThumbProcessor, 0);
    }

    public GridThumbStreamLoader(Context paramContext, StreamThumbProcessor paramStreamThumbProcessor, int paramInt) {
        this.mContext = paramContext;
        this.mThumbProcessor = paramStreamThumbProcessor;
        int i = ((ActivityManager) paramContext.getSystemService("activity")).getMemoryClass();
        logger.f(new Object[]{"memory class is:" + i + "MB"});
        this.mCacheSizeFraction = paramInt;
        if (paramInt <= 0) {
            this.mCacheSizeFraction = 10;
        }
        this.mLruCache = new LruCache(i * 1048576 / this.mCacheSizeFraction) {
            protected int a(String paramAnonymousString, Bitmap paramAnonymousBitmap) {
                if (paramAnonymousBitmap != null) {
                    return paramAnonymousBitmap.getRowBytes() * paramAnonymousBitmap.getHeight();
                }
                return super.sizeOf(paramAnonymousString, paramAnonymousBitmap);
            }
        };
        this.mTargetDensity = 320;
    }

    private boolean isViewWasReused(com.everimaging.fotorsdk.uil.core.imageaware.a parama, String paramString) {
        return !paramString.equals(getLoadingUriForView(parama));
    }

    void cancelDisplayTaskFor(com.everimaging.fotorsdk.uil.core.imageaware.a parama) {
        this.cacheKeysForImageAwares.remove(Integer.valueOf(parama.f()));
    }

    public void clearMemory() {
        logger.c(new Object[]{"======clearMemory====="});
        Utils.printMemoryInfo();
        this.mLruCache.trimToSize(-1);
        Utils.printMemoryInfo();
    }

    public void displayImage(ImageView paramImageView, IInputStreamReader paramIInputStreamReader, String paramString1, String paramString2, ImageStreamLoadListener paramImageStreamLoadListener) {
        displayImage(new c(paramImageView), paramIInputStreamReader, paramString1, paramString2, paramImageStreamLoadListener);
    }

    public void displayImage(com.everimaging.fotorsdk.uil.core.imageaware.a parama, IInputStreamReader paramIInputStreamReader, String paramString1, String paramString2, ImageStreamLoadListener paramImageStreamLoadListener) {
        paramString1 = f.a(paramString1, com.everimaging.fotorsdk.uil.utils.a.a(parama, new e(DeviceUtils.getScreenWidth(), DeviceUtils.getScreenHeight())));
        prepareDisplayTaskFor(parama, paramString1);
        Bitmap localBitmap = (Bitmap) this.mLruCache.get(paramString1);
        if (paramImageStreamLoadListener != null) {
            paramImageStreamLoadListener.onImageStreamLoadStart((ImageView) parama.d());
        }
        if (localBitmap == null) {
            if (this.mTaskMaps.containsKey(paramString1)) {
                logger.e(new Object[]{"load bitmap task is already running.key->" + paramString1});
            }
        }
        do {
            return;
            parama = new a(parama, paramString1, paramString2, paramImageStreamLoadListener, paramIInputStreamReader);
            this.mTaskMaps.put(paramString1, parama);
            parama.execute(new Void[0]);
            return;
            paramIInputStreamReader = new BitmapDrawable(this.mContext.getResources(), localBitmap);
            paramIInputStreamReader.setTargetDensity(this.mTargetDensity);
            parama.a(paramIInputStreamReader);
        } while (paramImageStreamLoadListener == null);
        paramImageStreamLoadListener.onImageStreamLoadCompletion((ImageView) parama.d());
    }

    protected void finalize()
            throws Throwable {
        logger.c(new Object[]{"======finalize====="});
        clearMemory();
        super.finalize();
    }

    String getLoadingUriForView(com.everimaging.fotorsdk.uil.core.imageaware.a parama) {
        return (String) this.cacheKeysForImageAwares.get(Integer.valueOf(parama.f()));
    }

    void prepareDisplayTaskFor(com.everimaging.fotorsdk.uil.core.imageaware.a parama, String paramString) {
        this.cacheKeysForImageAwares.put(Integer.valueOf(parama.f()), paramString);
    }

    public void setDisplayDensity(int paramInt) {
        this.mTargetDensity = paramInt;
    }

    public static abstract interface IInputStreamReader {
        public abstract InputStream readInputStream(String paramString);
    }

    public static abstract interface ImageStreamLoadListener {
        public abstract void onImageStreamLoadCancelled(View paramView);

        public abstract void onImageStreamLoadCompletion(View paramView);

        public abstract void onImageStreamLoadStart(View paramView);
    }

    public static abstract interface StreamThumbProcessor {
        public abstract Bitmap processImageStream(InputStream paramInputStream);
    }

    private class a
            extends FotorAsyncTask<Void, Void, Bitmap> {
        private com.everimaging.fotorsdk.uil.core.imageaware.a b;
        private GridThumbStreamLoader.ImageStreamLoadListener c;
        private String d;
        private GridThumbStreamLoader.IInputStreamReader e;
        private String f;

        public a(com.everimaging.fotorsdk.uil.core.imageaware.a parama, String paramString1, String paramString2, GridThumbStreamLoader.ImageStreamLoadListener paramImageStreamLoadListener, GridThumbStreamLoader.IInputStreamReader paramIInputStreamReader) {
            this.b = parama;
            this.c = paramImageStreamLoadListener;
            this.d = paramString1;
            this.e = paramIInputStreamReader;
            this.f = paramString2;
        }

        private void b(Bitmap paramBitmap) {
            ImageView localImageView = (ImageView) this.b.d();
            if (this.b.e()) {
                GridThumbStreamLoader.logger.c(new Object[]{"ImageAware is GC ,so cancel. "});
                if (this.c != null) {
                    this.c.onImageStreamLoadCancelled(localImageView);
                }
            }
            do {
                do {
                    do {
                        return;
                        if (!GridThumbStreamLoader.this.isViewWasReused(this.b, this.d)) {
                            break;
                        }
                        GridThumbStreamLoader.logger.c(new Object[]{"ImageAware is reused for another image. "});
                    } while (this.c == null);
                    this.c.onImageStreamLoadCancelled(localImageView);
                    return;
                    if (paramBitmap != null) {
                        break;
                    }
                    GridThumbStreamLoader.logger.c(new Object[]{"Load stream failed. "});
                } while (this.c == null);
                this.c.onImageStreamLoadCancelled(localImageView);
                return;
                paramBitmap = new BitmapDrawable(GridThumbStreamLoader.this.mContext.getResources(), paramBitmap);
                paramBitmap.setTargetDensity(GridThumbStreamLoader.this.mTargetDensity);
                this.b.a(paramBitmap);
                GridThumbStreamLoader.this.cancelDisplayTaskFor(this.b);
            } while (this.c == null);
            this.c.onImageStreamLoadCompletion(localImageView);
        }

        protected Bitmap a(Void... paramVarArgs) {
            paramVarArgs = this.e.readInputStream(this.f);
            Bitmap localBitmap = GridThumbStreamLoader.this.mThumbProcessor.processImageStream(paramVarArgs);
            FotorIOUtils.closeSilently(paramVarArgs);
            return localBitmap;
        }

        protected void a(Bitmap paramBitmap) {
            if (paramBitmap != null) {
                GridThumbStreamLoader.this.mLruCache.put(this.d, paramBitmap);
            }
            b(paramBitmap);
            GridThumbStreamLoader.this.mTaskMaps.remove(this.d);
        }

        protected void onPreExecute() {
            ((ImageView) this.b.d()).setImageDrawable(null);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/GridThumbStreamLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */