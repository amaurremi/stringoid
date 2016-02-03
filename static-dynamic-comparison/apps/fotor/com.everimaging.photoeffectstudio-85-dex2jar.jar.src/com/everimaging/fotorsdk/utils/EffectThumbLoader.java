package com.everimaging.fotorsdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import com.everimaging.fotorsdk.algorithms.xml.entity.EffectEntity;
import com.everimaging.fotorsdk.entity.EffectInfo;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.uil.core.assist.e;
import com.everimaging.fotorsdk.uil.core.assist.f;
import com.everimaging.fotorsdk.uil.core.imageaware.c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EffectThumbLoader {
    private static final int CACHE_SIZE_FRACTION = 4;
    private static final String TAG = EffectThumbLoader.class.getSimpleName();
    private static final FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);
    private final Map<Integer, String> cacheKeysForImageAwares = Collections.synchronizedMap(new HashMap());
    private LruCache<String, Bitmap> mLruCache;
    private EffectThumbProcessor mProcessor;
    private Bitmap mSourceBitmap;
    private final Map<String, a> mTaskMaps = Collections.synchronizedMap(new HashMap());

    public EffectThumbLoader(Context paramContext, EffectThumbProcessor paramEffectThumbProcessor, Bitmap paramBitmap) {
        this.mProcessor = paramEffectThumbProcessor;
        this.mSourceBitmap = paramBitmap;
        int i = ((ActivityManager) paramContext.getSystemService("activity")).getMemoryClass();
        logger.f(new Object[]{"memory class is:" + i + "MB"});
        this.mLruCache = new LruCache(i * 1048576 / 4) {
            protected int a(String paramAnonymousString, Bitmap paramAnonymousBitmap) {
                if (paramAnonymousBitmap != null) {
                    return paramAnonymousBitmap.getRowBytes() * paramAnonymousBitmap.getHeight();
                }
                return super.sizeOf(paramAnonymousString, paramAnonymousBitmap);
            }
        };
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

    public void displayImage(ImageView paramImageView, EffectInfo paramEffectInfo, int paramInt, BitmapLoadListener paramBitmapLoadListener) {
        displayImage(new c(paramImageView), paramEffectInfo, paramInt, paramBitmapLoadListener);
    }

    public void displayImage(com.everimaging.fotorsdk.uil.core.imageaware.a parama, EffectInfo paramEffectInfo, int paramInt, BitmapLoadListener paramBitmapLoadListener) {
        Object localObject = com.everimaging.fotorsdk.uil.utils.a.a(parama, new e(DeviceUtils.getScreenWidth(), DeviceUtils.getScreenHeight()));
        localObject = f.a(String.valueOf(paramEffectInfo.effectEntity.getID()), (e) localObject);
        prepareDisplayTaskFor(parama, (String) localObject);
        Bitmap localBitmap = (Bitmap) this.mLruCache.get(localObject);
        if (paramBitmapLoadListener != null) {
            paramBitmapLoadListener.onBitmapLoadStart((ImageView) parama.d(), paramEffectInfo);
        }
        if (localBitmap == null) {
            if (this.mTaskMaps.containsKey(localObject)) {
                logger.e(new Object[]{"load bitmap task is already running.key->" + (String) localObject});
            }
        }
        do {
            return;
            parama = new a(parama, (String) localObject, paramEffectInfo, paramInt, paramBitmapLoadListener, this.mSourceBitmap);
            this.mTaskMaps.put(localObject, parama);
            parama.execute(new Bitmap[0]);
            return;
            parama.a(localBitmap);
        } while (paramBitmapLoadListener == null);
        paramBitmapLoadListener.onBitmapLoadCompletion((ImageView) parama.d(), paramEffectInfo);
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

    public void setSourceBitmap(Bitmap paramBitmap) {
        this.mSourceBitmap = paramBitmap;
    }

    public static abstract interface BitmapLoadListener {
        public abstract void onBitmapLoadCancelled(View paramView, EffectInfo paramEffectInfo);

        public abstract void onBitmapLoadCompletion(View paramView, EffectInfo paramEffectInfo);

        public abstract void onBitmapLoadStart(View paramView, EffectInfo paramEffectInfo);
    }

    public static abstract interface EffectThumbProcessor {
        public abstract Bitmap processBitmap(EffectInfo paramEffectInfo, Bitmap paramBitmap);
    }

    private class a
            extends FotorAsyncTask<Bitmap, Void, Bitmap> {
        private com.everimaging.fotorsdk.uil.core.imageaware.a b;
        private EffectInfo c;
        private int d;
        private EffectThumbLoader.BitmapLoadListener e;
        private String f;
        private Bitmap g;

        public a(com.everimaging.fotorsdk.uil.core.imageaware.a parama, String paramString, EffectInfo paramEffectInfo, int paramInt, EffectThumbLoader.BitmapLoadListener paramBitmapLoadListener, Bitmap paramBitmap) {
            this.b = parama;
            this.c = paramEffectInfo;
            this.d = paramInt;
            this.e = paramBitmapLoadListener;
            this.f = paramString;
            this.g = paramBitmap;
        }

        private void b(Bitmap paramBitmap) {
            if (this.b.e()) {
                EffectThumbLoader.logger.c(new Object[]{"ImageAware is GC ,so cancel. "});
                if (this.e != null) {
                    this.e.onBitmapLoadCancelled(this.b.d(), this.c);
                }
            }
            do {
                do {
                    return;
                    if (!EffectThumbLoader.this.isViewWasReused(this.b, this.f)) {
                        break;
                    }
                    EffectThumbLoader.logger.c(new Object[]{"ImageAware is reused for another image. "});
                } while (this.e == null);
                this.e.onBitmapLoadCancelled(this.b.d(), this.c);
                return;
                this.b.a(paramBitmap);
                EffectThumbLoader.this.cancelDisplayTaskFor(this.b);
            } while (this.e == null);
            this.e.onBitmapLoadCompletion(this.b.d(), this.c);
        }

        protected Bitmap a(Bitmap... paramVarArgs) {
            return EffectThumbLoader.this.mProcessor.processBitmap(this.c, this.g);
        }

        protected void a(Bitmap paramBitmap) {
            if (paramBitmap != null) {
                EffectThumbLoader.this.mLruCache.put(this.f, paramBitmap);
            }
            b(paramBitmap);
            EffectThumbLoader.this.mTaskMaps.remove(this.f);
        }

        protected void onPreExecute() {
            ImageView localImageView = (ImageView) this.b.d();
            if ((localImageView != null) && (localImageView.getDrawable() == null)) {
                if (this.d == 0) {
                    this.b.a(this.g);
                }
            } else {
                return;
            }
            this.b.a(this.d);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/EffectThumbLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */