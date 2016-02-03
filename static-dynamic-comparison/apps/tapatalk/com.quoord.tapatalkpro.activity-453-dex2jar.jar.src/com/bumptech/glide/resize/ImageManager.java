package com.bumptech.glide.resize;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.bumptech.glide.loader.stream.StreamLoader;
import com.bumptech.glide.loader.stream.StreamLoader.StreamReadyCallback;
import com.bumptech.glide.resize.bitmap_recycle.BitmapPool;
import com.bumptech.glide.resize.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.resize.bitmap_recycle.BitmapReferenceCounter;
import com.bumptech.glide.resize.bitmap_recycle.BitmapReferenceCounterAdapter;
import com.bumptech.glide.resize.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.resize.bitmap_recycle.SerialBitmapReferenceCounter;
import com.bumptech.glide.resize.cache.DiskCache;
import com.bumptech.glide.resize.cache.DiskCache.Writer;
import com.bumptech.glide.resize.cache.DiskCacheAdapter;
import com.bumptech.glide.resize.cache.DiskLruCacheWrapper;
import com.bumptech.glide.resize.cache.LruMemoryCache;
import com.bumptech.glide.resize.cache.MemoryCache;
import com.bumptech.glide.resize.cache.MemoryCache.ImageRemovedListener;
import com.bumptech.glide.resize.cache.MemoryCacheAdapter;
import com.bumptech.glide.resize.load.Downsampler;
import com.bumptech.glide.resize.load.ImageResizer;
import com.bumptech.glide.resize.load.Transformation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class ImageManager {
    public static final boolean CAN_RECYCLE;
    private static final int DEFAULT_BITMAP_COMPRESS_QUALITY = 90;
    private static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
    private static final int DEFAULT_DISK_CACHE_SIZE = 31457280;
    private static Downsampler DISK_CACHE_DOWNSAMPLER;
    private static final float MEMORY_SIZE_RATIO = 0.1F;
    private static final String TAG = "ImageManager";
    private final Handler bgHandler;
    private final int bitmapCompressQuality;
    private final BitmapPool bitmapPool;
    private final BitmapReferenceCounter bitmapReferenceCounter;
    private final DiskCache diskCache;
    private final ExecutorService executor;
    private final Map<String, ImageManagerJob> jobs = new HashMap();
    private final Handler mainHandler = new Handler();
    private final MemoryCache memoryCache;
    private final ImageResizer resizer;
    private final SafeKeyGenerator safeKeyGenerator = new SafeKeyGenerator();
    private boolean shutdown = false;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
        }
        for (boolean bool = true; ; bool = false) {
            CAN_RECYCLE = bool;
            DISK_CACHE_DOWNSAMPLER = new Downsampler() {
                public Bitmap downsample(RecyclableBufferedInputStream paramAnonymousRecyclableBufferedInputStream, BitmapFactory.Options paramAnonymousOptions, BitmapPool paramAnonymousBitmapPool, int paramAnonymousInt1, int paramAnonymousInt2) {
                    return downsampleWithSize(paramAnonymousRecyclableBufferedInputStream, paramAnonymousOptions, paramAnonymousBitmapPool, paramAnonymousInt1, paramAnonymousInt2, 1);
                }

                protected int getSampleSize(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4) {
                    return 0;
                }
            };
            return;
        }
    }

    private ImageManager(Builder paramBuilder) {
        HandlerThread localHandlerThread = new HandlerThread("bg_thread", 10);
        localHandlerThread.start();
        this.bgHandler = new Handler(localHandlerThread.getLooper());
        this.executor = paramBuilder.resizeService;
        this.bitmapCompressQuality = paramBuilder.bitmapCompressQuality;
        this.memoryCache = paramBuilder.memoryCache;
        this.diskCache = paramBuilder.diskCache;
        this.bitmapReferenceCounter = paramBuilder.bitmapReferenceCounter;
        this.bitmapPool = paramBuilder.bitmapPool;
        this.resizer = new ImageResizer(paramBuilder.bitmapPool, paramBuilder.decodeBitmapOptions);
        this.memoryCache.setImageRemovedListener(new MemoryCache.ImageRemovedListener() {
            public void onImageRemoved(Bitmap paramAnonymousBitmap) {
                ImageManager.this.releaseBitmap(paramAnonymousBitmap);
            }
        });
    }

    public static File getPhotoCacheDir(Context paramContext) {
        return getPhotoCacheDir(paramContext, "image_manager_disk_cache");
    }

    public static File getPhotoCacheDir(Context paramContext, String paramString) {
        File localFile1 = null;
        if (("mounted".equals(Environment.getExternalStorageState())) || (!isExternalStorageRemovable())) {
            localFile1 = paramContext.getExternalCacheDir();
        }
        File localFile2 = localFile1;
        if (localFile1 == null) {
            localFile2 = paramContext.getCacheDir();
        }
        if (localFile2 != null) {
            paramContext = new File(localFile2, paramString);
            paramContext.mkdirs();
            return paramContext;
        }
        if (Log.isLoggable("ImageManager", 6)) {
            Log.e("ImageManager", "default disk cache dir is null");
        }
        return null;
    }

    public static int getSafeMemoryCacheSize(Context paramContext) {
        return Math.round(0.1F * ((ActivityManager) paramContext.getSystemService("activity")).getMemoryClass() * 1024.0F * 1024.0F);
    }

    @TargetApi(9)
    private static boolean isExternalStorageRemovable() {
        return (Build.VERSION.SDK_INT < 9) || (Environment.isExternalStorageRemovable());
    }

    private void putInDiskCache(String paramString, final Bitmap paramBitmap) {
        this.diskCache.put(paramString, new DiskCache.Writer() {
            public void write(OutputStream paramAnonymousOutputStream) {
                Object localObject = paramBitmap.getConfig();
                if ((localObject == null) || (localObject == Bitmap.Config.ARGB_4444) || (localObject == Bitmap.Config.ARGB_8888)) {
                }
                for (localObject = Bitmap.CompressFormat.PNG; ; localObject = Bitmap.CompressFormat.JPEG) {
                    paramBitmap.compress((Bitmap.CompressFormat) localObject, ImageManager.this.bitmapCompressQuality, paramAnonymousOutputStream);
                    return;
                }
            }
        });
    }

    private void putInMemoryCache(String paramString, Bitmap paramBitmap) {
        if (!this.memoryCache.contains(paramString)) {
            this.bitmapReferenceCounter.acquireBitmap(paramBitmap);
            this.memoryCache.put(paramString, paramBitmap);
        }
    }

    private boolean returnFromCache(String paramString, LoadedCallback paramLoadedCallback) {
        paramString = this.memoryCache.get(paramString);
        if (paramString != null) {
        }
        for (boolean bool = true; ; bool = false) {
            if (bool) {
                this.bitmapReferenceCounter.acquireBitmap(paramString);
                paramLoadedCallback.onLoadCompleted(paramString);
            }
            return bool;
        }
    }

    public void clearMemory() {
        this.memoryCache.clearMemory();
        this.bitmapPool.clearMemory();
    }

    public BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    public LoadToken getImage(String paramString, StreamLoader paramStreamLoader, Transformation paramTransformation, Downsampler paramDownsampler, int paramInt1, int paramInt2, LoadedCallback paramLoadedCallback) {
        if (this.shutdown) {
        }
        String str;
        do {
            return null;
            str = this.safeKeyGenerator.getSafeKey(paramString, paramTransformation, paramDownsampler, paramInt1, paramInt2);
        } while (returnFromCache(str, paramLoadedCallback));
        ImageManagerJob localImageManagerJob = (ImageManagerJob) this.jobs.get(str);
        paramString = localImageManagerJob;
        if (localImageManagerJob == null) {
            paramStreamLoader = new ImageManagerRunner(str, paramStreamLoader, paramTransformation, paramDownsampler, paramInt1, paramInt2);
            paramString = new ImageManagerJob(paramStreamLoader, str);
            this.jobs.put(str, paramString);
            paramStreamLoader.execute();
        }
        paramString.addCallback(paramLoadedCallback);
        return new LoadToken(paramLoadedCallback, paramString);
    }

    public void releaseBitmap(Bitmap paramBitmap) {
        this.bitmapReferenceCounter.releaseBitmap(paramBitmap);
    }

    public void shutdown() {
        this.shutdown = true;
        this.executor.shutdown();
        this.bgHandler.getLooper().quit();
    }

    public void trimMemory(int paramInt) {
        this.memoryCache.trimMemory(paramInt);
        this.bitmapPool.trimMemory(paramInt);
    }

    public static class Builder {
        private Bitmap.CompressFormat bitmapCompressFormat = Bitmap.CompressFormat.JPEG;
        private int bitmapCompressQuality = 90;
        private BitmapPool bitmapPool;
        private BitmapReferenceCounter bitmapReferenceCounter;
        private final Context context;
        @Deprecated
        public BitmapFactory.Options decodeBitmapOptions = ImageResizer.getDefaultOptions();
        private DiskCache diskCache = null;
        private MemoryCache memoryCache = null;
        private boolean recycleBitmaps = ImageManager.CAN_RECYCLE;
        private ExecutorService resizeService = null;

        public Builder(Context paramContext) {
            this.context = paramContext;
            if (!ImageManager.CAN_RECYCLE) {
                this.bitmapPool = new BitmapPoolAdapter();
            }
        }

        private void setDefaults() {
            if (this.resizeService == null) {
                this.resizeService = Executors.newFixedThreadPool(Math.max(1, Runtime.getRuntime().availableProcessors()), new ThreadFactory() {
                    public Thread newThread(Runnable paramAnonymousRunnable) {
                        paramAnonymousRunnable = new Thread(paramAnonymousRunnable);
                        paramAnonymousRunnable.setPriority(10);
                        return paramAnonymousRunnable;
                    }
                });
            }
            if (this.memoryCache == null) {
                this.memoryCache = new LruMemoryCache(ImageManager.getSafeMemoryCacheSize(this.context));
            }
            File localFile;
            if (this.diskCache == null) {
                localFile = ImageManager.getPhotoCacheDir(this.context);
                if (localFile == null) {
                }
            }
            try {
                this.diskCache = DiskLruCacheWrapper.get(localFile, 31457280);
                if (this.diskCache == null) {
                    this.diskCache = new DiskCacheAdapter();
                }
                if (!this.recycleBitmaps) {
                    this.bitmapPool = new BitmapPoolAdapter();
                    this.bitmapReferenceCounter = new BitmapReferenceCounterAdapter();
                    return;
                }
            } catch (IOException localIOException) {
                for (; ; ) {
                    localIOException.printStackTrace();
                }
                if (this.bitmapPool == null) {
                    this.bitmapPool = new LruBitmapPool(ImageManager.getSafeMemoryCacheSize(this.context));
                }
                this.bitmapReferenceCounter = new SerialBitmapReferenceCounter(this.bitmapPool);
            }
        }

        public ImageManager build() {
            setDefaults();
            return new ImageManager(this, null);
        }

        public Builder disableBitmapRecycling() {
            this.recycleBitmaps = false;
            return this;
        }

        public Builder disableDiskCache() {
            return setDiskCache(new DiskCacheAdapter());
        }

        public Builder disableMemoryCache() {
            return setMemoryCache(new MemoryCacheAdapter());
        }

        @Deprecated
        public Builder setBitmapCompressFormat(Bitmap.CompressFormat paramCompressFormat) {
            this.bitmapCompressFormat = paramCompressFormat;
            return this;
        }

        public Builder setBitmapCompressQuality(int paramInt) {
            if (paramInt < 0) {
                throw new IllegalArgumentException("Bitmap compression quality must be >= 0");
            }
            this.bitmapCompressQuality = paramInt;
            return this;
        }

        public Builder setBitmapPool(BitmapPool paramBitmapPool) {
            if (ImageManager.CAN_RECYCLE) {
                this.bitmapPool = paramBitmapPool;
            }
            return this;
        }

        public Builder setDiskCache(DiskCache paramDiskCache) {
            this.diskCache = paramDiskCache;
            return this;
        }

        public Builder setMemoryCache(MemoryCache paramMemoryCache) {
            this.memoryCache = paramMemoryCache;
            return this;
        }

        public Builder setResizeService(ExecutorService paramExecutorService) {
            this.resizeService = paramExecutorService;
            return this;
        }
    }

    private class ImageManagerJob {
        private final List<LoadedCallback> cbs = new ArrayList();
        private final String key;
        private final ImageManager.ImageManagerRunner runner;

        public ImageManagerJob(ImageManager.ImageManagerRunner paramImageManagerRunner, String paramString) {
            this.runner = paramImageManagerRunner;
            this.key = paramString;
        }

        public void addCallback(LoadedCallback paramLoadedCallback) {
            this.cbs.add(paramLoadedCallback);
        }

        public void cancel(LoadedCallback paramLoadedCallback) {
            this.cbs.remove(paramLoadedCallback);
            if (this.cbs.size() == 0) {
                this.runner.cancel();
                ImageManager.this.jobs.remove(this.key);
            }
        }

        public void onLoadComplete(Bitmap paramBitmap) {
            Iterator localIterator = this.cbs.iterator();
            for (; ; ) {
                if (!localIterator.hasNext()) {
                    ImageManager.this.jobs.remove(this.key);
                    return;
                }
                LoadedCallback localLoadedCallback = (LoadedCallback) localIterator.next();
                ImageManager.this.bitmapReferenceCounter.acquireBitmap(paramBitmap);
                localLoadedCallback.onLoadCompleted(paramBitmap);
            }
        }

        public void onLoadFailed(Exception paramException) {
            int i = 0;
            for (; ; ) {
                try {
                    int j = this.cbs.size();
                    if (i < j) {
                        continue;
                    }
                } catch (Exception paramException) {
                    continue;
                }
                ImageManager.this.jobs.remove(this.key);
                return;
                ((LoadedCallback) this.cbs.get(i)).onLoadFailed(paramException);
                i += 1;
            }
        }
    }

    private class ImageManagerRunner
            implements Runnable {
        private volatile boolean cancelled = false;
        private final Downsampler downsampler;
        private volatile Future<?> future;
        public final int height;
        public final String key;
        private final StreamLoader streamLoader;
        private final Transformation transformation;
        public final int width;

        public ImageManagerRunner(String paramString, StreamLoader paramStreamLoader, Transformation paramTransformation, Downsampler paramDownsampler, int paramInt1, int paramInt2) {
            this.key = paramString;
            this.height = paramInt2;
            this.width = paramInt1;
            this.streamLoader = paramStreamLoader;
            this.transformation = paramTransformation;
            this.downsampler = paramDownsampler;
        }

        private void execute() {
            ImageManager.this.bgHandler.post(this);
        }

        private void finishResize(final Bitmap paramBitmap, boolean paramBoolean) {
            if (paramBitmap != null) {
                if (!paramBoolean) {
                    ImageManager.this.putInDiskCache(this.key, paramBitmap);
                }
                ImageManager.this.mainHandler.post(new Runnable() {
                    public void run() {
                        ImageManager.this.putInMemoryCache(ImageManager.ImageManagerRunner.this.key, paramBitmap);
                        ImageManager.ImageManagerJob localImageManagerJob = (ImageManager.ImageManagerJob) ImageManager.this.jobs.get(ImageManager.ImageManagerRunner.this.key);
                        if (localImageManagerJob != null) {
                            localImageManagerJob.onLoadComplete(paramBitmap);
                        }
                    }
                });
                return;
            }
            handleException(null);
        }

        private Bitmap getFromDiskCache(String paramString) {
            Object localObject1 = null;
            Object localObject2 = ImageManager.this.diskCache.get(paramString);
            if (localObject2 != null) {
                localObject2 = ImageManager.this.resizer.load((InputStream) localObject2, this.width, this.height, ImageManager.DISK_CACHE_DOWNSAMPLER);
                localObject1 = localObject2;
                if (localObject2 == null) {
                    ImageManager.this.diskCache.delete(paramString);
                    localObject1 = localObject2;
                }
            }
            return (Bitmap) localObject1;
        }

        private void handleException(final Exception paramException) {
            try {
                ImageManager.this.mainHandler.post(new Runnable() {
                    public void run() {
                        try {
                            ImageManager.ImageManagerJob localImageManagerJob = (ImageManager.ImageManagerJob) ImageManager.this.jobs.get(ImageManager.ImageManagerRunner.this.key);
                            if (localImageManagerJob != null) {
                                localImageManagerJob.onLoadFailed(paramException);
                            }
                            return;
                        } catch (Exception localException) {
                        }
                    }
                });
                return;
            } catch (Exception paramException) {
            }
        }

        private Bitmap resizeIfNotFound(InputStream paramInputStream, Downsampler paramDownsampler, Transformation paramTransformation) {
            return ImageManager.this.resizer.load(paramInputStream, this.width, this.height, paramDownsampler, paramTransformation);
        }

        private void resizeWithPool() {
            this.future = ImageManager.this.executor.submit(new Runnable() {
                public void run() {
                    ImageManager.ImageManagerRunner.this.streamLoader.loadStream(new StreamLoader.StreamReadyCallback() {
                        public void onException(Exception paramAnonymous2Exception) {
                            ImageManager.ImageManagerRunner.this.handleException(paramAnonymous2Exception);
                        }

                        public void onStreamReady(final InputStream paramAnonymous2InputStream) {
                            if (ImageManager.ImageManagerRunner.this.cancelled) {
                                return;
                            }
                            ImageManager.ImageManagerRunner.this.future = ImageManager.this.executor.submit(new Runnable() {
                                public void run() {
                                    try {
                                        Bitmap localBitmap = ImageManager.ImageManagerRunner.this.resizeIfNotFound(paramAnonymous2InputStream, ImageManager.ImageManagerRunner.this.downsampler, ImageManager.ImageManagerRunner.this.transformation);
                                        ImageManager.ImageManagerRunner.this.finishResize(localBitmap, false);
                                        return;
                                    } catch (Exception localException) {
                                        ImageManager.ImageManagerRunner.this.handleException(localException);
                                    }
                                }
                            });
                        }
                    });
                }
            });
        }

        public void cancel() {
            this.cancelled = true;
            ImageManager.this.bgHandler.removeCallbacks(this);
            Future localFuture = this.future;
            if (localFuture != null) {
                localFuture.cancel(false);
            }
            if (this.streamLoader != null) {
                this.streamLoader.cancel();
            }
        }

        public void run() {
            Object localObject = null;
            try {
                Bitmap localBitmap = getFromDiskCache(this.key);
                localObject = localBitmap;
            } catch (Exception localException2) {
                for (; ; ) {
                    try {
                        resizeWithPool();
                        return;
                    } catch (Exception localException1) {
                        handleException(localException1);
                        return;
                    }
                    localException2 = localException2;
                    handleException(localException2);
                }
            }
            if (localObject == null) {
            }
            finishResize(localException1, true);
        }
    }

    public static class LoadToken {
        private final LoadedCallback cb;
        private final ImageManager.ImageManagerJob job;

        public LoadToken(LoadedCallback paramLoadedCallback, ImageManager.ImageManagerJob paramImageManagerJob) {
            this.cb = paramLoadedCallback;
            this.job = paramImageManagerJob;
        }

        public void cancel() {
            this.job.cancel(this.cb);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/bumptech/glide/resize/ImageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */