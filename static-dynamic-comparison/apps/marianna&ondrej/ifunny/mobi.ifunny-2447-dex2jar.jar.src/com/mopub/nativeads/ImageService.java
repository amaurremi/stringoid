package com.mopub.nativeads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.CacheService;
import com.mopub.common.DownloadResponse;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.VersionCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ImageService {
    private static final int TWO_MEGABYTES = 2097152;
    private static int sTargetWidth = -1;

    public static Bitmap asBitmap(DownloadResponse paramDownloadResponse, int paramInt) {
        if (paramDownloadResponse == null) {
            return null;
        }
        return byteArrayToBitmap(paramDownloadResponse.getByteArray(), paramInt);
    }

    public static Bitmap byteArrayToBitmap(byte[] paramArrayOfByte, int paramInt) {
        if (paramInt <= 0) {
        }
        Object localObject;
        do {
            return null;
            localObject = new BitmapFactory.Options();
            ((BitmapFactory.Options) localObject).inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options) localObject);
            for (((BitmapFactory.Options) localObject).inSampleSize = calculateInSampleSize(((BitmapFactory.Options) localObject).outWidth, paramInt); getMemBytes((BitmapFactory.Options) localObject) > 2097152L; ((BitmapFactory.Options) localObject).inSampleSize *= 2) {
            }
            ((BitmapFactory.Options) localObject).inJustDecodeBounds = false;
            paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options) localObject);
        } while (paramArrayOfByte == null);
        if (paramArrayOfByte.getWidth() > paramInt) {
            localObject = Bitmap.createScaledBitmap(paramArrayOfByte, paramInt, (int) (paramArrayOfByte.getHeight() * paramInt / paramArrayOfByte.getWidth()), true);
            paramArrayOfByte.recycle();
            return (Bitmap) localObject;
        }
        return paramArrayOfByte;
    }

    public static int calculateInSampleSize(int paramInt1, int paramInt2) {
        int i = 1;
        int j = 1;
        if (paramInt1 > paramInt2) {
            int k = paramInt1 / 2;
            paramInt1 = j;
            for (; ; ) {
                i = paramInt1;
                if (k / paramInt1 < paramInt2) {
                    break;
                }
                paramInt1 *= 2;
            }
        }
        return i;
    }

    @VisibleForTesting
    static void clear() {
        sTargetWidth = -1;
    }

    static void get(Context paramContext, List<String> paramList, ImageService.ImageServiceListener paramImageServiceListener) {
        initialize(paramContext);
        CacheService.initialize(paramContext);
        get(paramList, paramImageServiceListener);
    }

    static void get(List<String> paramList, ImageService.ImageServiceListener paramImageServiceListener) {
        HashMap localHashMap = new HashMap(paramList.size());
        paramList = getBitmapsFromMemoryCache(paramList, localHashMap);
        if (paramList.isEmpty()) {
            paramImageServiceListener.onSuccess(localHashMap);
            return;
        }
        try {
            paramList = new ImageDiskTaskManager(paramList, new ImageService.ImageDiskTaskManagerListener(paramImageServiceListener, localHashMap), sTargetWidth);
            paramList.execute();
            return;
        } catch (IllegalArgumentException paramList) {
            MoPubLog.d("Unable to initialize ImageDiskTaskManager", paramList);
            paramImageServiceListener.onFail();
        }
    }

    @Deprecated
    static Bitmap getBitmapFromDiskCache(String paramString) {
        Object localObject = null;
        byte[] arrayOfByte = CacheService.getFromDiskCache(paramString);
        paramString = (String) localObject;
        if (arrayOfByte != null) {
            paramString = byteArrayToBitmap(arrayOfByte, sTargetWidth);
        }
        return paramString;
    }

    static Bitmap getBitmapFromMemoryCache(String paramString) {
        return CacheService.getFromBitmapCache(paramString);
    }

    static List<String> getBitmapsFromMemoryCache(List<String> paramList, Map<String, Bitmap> paramMap) {
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            String str = (String) paramList.next();
            Bitmap localBitmap = getBitmapFromMemoryCache(str);
            if (localBitmap != null) {
                paramMap.put(str, localBitmap);
            } else {
                localArrayList.add(str);
            }
        }
        return localArrayList;
    }

    public static long getMemBytes(BitmapFactory.Options paramOptions) {
        return 4L * paramOptions.outWidth * paramOptions.outHeight / paramOptions.inSampleSize / paramOptions.inSampleSize;
    }

    @VisibleForTesting
    static int getTargetWidth() {
        return sTargetWidth;
    }

    @TargetApi(13)
    @VisibleForTesting
    static void initialize(Context paramContext) {
        Point localPoint;
        if (sTargetWidth == -1) {
            paramContext = ((WindowManager) paramContext.getSystemService("window")).getDefaultDisplay();
            localPoint = new Point();
            if (!VersionCode.currentApiLevel().isBelow(VersionCode.HONEYCOMB_MR2)) {
                break label69;
            }
            localPoint.set(paramContext.getWidth(), paramContext.getHeight());
        }
        for (; ; ) {
            sTargetWidth = Math.min(localPoint.x, localPoint.y);
            return;
            label69:
            paramContext.getSize(localPoint);
        }
    }

    static void putBitmapInCache(String paramString, Bitmap paramBitmap) {
        CacheService.putToBitmapCache(paramString, paramBitmap);
    }

    static void putDataInCache(String paramString, Bitmap paramBitmap, byte[] paramArrayOfByte) {
        CacheService.putToBitmapCache(paramString, paramBitmap);
        CacheService.putToDiskCacheAsync(paramString, paramArrayOfByte);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/nativeads/ImageService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */