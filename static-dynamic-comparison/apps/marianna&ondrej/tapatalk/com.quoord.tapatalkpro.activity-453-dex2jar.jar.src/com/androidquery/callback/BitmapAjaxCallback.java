package com.androidquery.callback;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.ExifInterface;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.androidquery.auth.AccountHandle;
import com.androidquery.util.AQUtility;
import com.androidquery.util.BitmapCache;
import com.androidquery.util.Common;
import com.androidquery.util.RatioDrawable;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.apache.http.HttpHost;

public class BitmapAjaxCallback
        extends AbstractAjaxCallback<Bitmap, BitmapAjaxCallback> {
    private static int BIG_MAX = 0;
    private static int BIG_PIXELS = 0;
    private static int BIG_TPIXELS = 0;
    private static boolean DELAY_WRITE = false;
    private static final int FADE_DUR = 300;
    private static int SMALL_MAX = 20;
    private static int SMALL_PIXELS;
    private static Map<String, Bitmap> bigCache;
    private static Bitmap dummy = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    private static Bitmap empty;
    private static Map<String, Bitmap> invalidCache;
    private static HashMap<String, WeakHashMap<ImageView, BitmapAjaxCallback>> queueMap;
    private static Map<String, Bitmap> smallCache;
    private float anchor = Float.MAX_VALUE;
    private int animation;
    private Bitmap bm;
    private int fallback;
    private File imageFile;
    private boolean invalid;
    private Bitmap preset;
    private float ratio;
    private boolean rotate;
    private int round;
    private boolean targetDim = true;
    private int targetWidth;
    private WeakReference<ImageView> v;

    static {
        BIG_MAX = 20;
        SMALL_PIXELS = 2500;
        BIG_PIXELS = 160000;
        BIG_TPIXELS = 1000000;
        DELAY_WRITE = false;
        queueMap = new HashMap();
        empty = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    }

    public BitmapAjaxCallback() {
        ((BitmapAjaxCallback) ((BitmapAjaxCallback) ((BitmapAjaxCallback) type(Bitmap.class)).memCache(true)).fileCache(true)).url("");
    }

    private void addQueue(String paramString, ImageView paramImageView) {
        WeakHashMap localWeakHashMap = (WeakHashMap) queueMap.get(paramString);
        if (localWeakHashMap == null) {
            if (queueMap.containsKey(paramString)) {
                localWeakHashMap = new WeakHashMap();
                localWeakHashMap.put(paramImageView, this);
                queueMap.put(paramString, localWeakHashMap);
                return;
            }
            queueMap.put(paramString, null);
            return;
        }
        localWeakHashMap.put(paramImageView, this);
    }

    public static void async(Activity paramActivity, Context paramContext, ImageView paramImageView, String paramString1, Object paramObject, AccountHandle paramAccountHandle, ImageOptions paramImageOptions, HttpHost paramHttpHost, String paramString2) {
        async(paramActivity, paramContext, paramImageView, paramString1, paramImageOptions.memCache, paramImageOptions.fileCache, paramImageOptions.targetWidth, paramImageOptions.fallback, paramImageOptions.preset, paramImageOptions.animation, paramImageOptions.ratio, paramImageOptions.anchor, paramObject, paramAccountHandle, paramImageOptions.policy, paramImageOptions.round, paramHttpHost, paramString2);
    }

    public static void async(Activity paramActivity, Context paramContext, ImageView paramImageView, String paramString1, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, float paramFloat1, float paramFloat2, Object paramObject, AccountHandle paramAccountHandle, int paramInt4, int paramInt5, HttpHost paramHttpHost, String paramString2) {
        Object localObject = null;
        if (paramBoolean1) {
            localObject = memGet(paramString1, paramInt1, paramInt5);
        }
        if (localObject != null) {
            paramImageView.setTag(1090453505, paramString1);
            Common.showProgress(paramObject, paramString1, false);
            setBmAnimate(paramImageView, (Bitmap) localObject, paramBitmap, paramInt2, paramInt3, paramFloat1, paramFloat2, 4);
            return;
        }
        localObject = new BitmapAjaxCallback();
        ((BitmapAjaxCallback) ((BitmapAjaxCallback) ((BitmapAjaxCallback) ((BitmapAjaxCallback) ((BitmapAjaxCallback) ((BitmapAjaxCallback) ((BitmapAjaxCallback) localObject).url(paramString1)).imageView(paramImageView).memCache(paramBoolean1)).fileCache(paramBoolean2)).targetWidth(paramInt1).fallback(paramInt2).preset(paramBitmap).animation(paramInt3).ratio(paramFloat1).anchor(paramFloat2).progress(paramObject)).auth(paramAccountHandle)).policy(paramInt4)).round(paramInt5).networkUrl(paramString2);
        if (paramHttpHost != null) {
            ((BitmapAjaxCallback) localObject).proxy(paramHttpHost.getHostName(), paramHttpHost.getPort());
        }
        if (paramActivity != null) {
            ((BitmapAjaxCallback) localObject).async(paramActivity);
            return;
        }
        ((BitmapAjaxCallback) localObject).async(paramContext);
    }

    private Bitmap bmGet(String paramString, byte[] paramArrayOfByte) {
        return getResizedImage(paramString, paramArrayOfByte, this.targetWidth, this.targetDim, this.round, this.rotate);
    }

    private void checkCb(BitmapAjaxCallback paramBitmapAjaxCallback, String paramString, ImageView paramImageView, Bitmap paramBitmap, AjaxStatus paramAjaxStatus) {
        if ((paramImageView == null) || (paramBitmapAjaxCallback == null)) {
            return;
        }
        if (paramString.equals(paramImageView.getTag(1090453505))) {
            if (!(paramImageView instanceof ImageView)) {
                break label45;
            }
            paramBitmapAjaxCallback.callback(paramString, paramImageView, paramBitmap, paramAjaxStatus);
        }
        for (; ; ) {
            paramBitmapAjaxCallback.showProgress(false);
            return;
            label45:
            paramBitmapAjaxCallback.setBitmap(paramString, paramImageView, paramBitmap, false);
        }
    }

    public static void clearCache() {
        bigCache = null;
        smallCache = null;
        invalidCache = null;
    }

    protected static void clearTasks() {
        queueMap.clear();
    }

    private static Bitmap decode(String paramString, byte[] paramArrayOfByte, BitmapFactory.Options paramOptions, boolean paramBoolean) {
        Bitmap localBitmap = null;
        if (paramString != null) {
            localBitmap = decodeFile(paramString, paramOptions, paramBoolean);
        }
        for (; ; ) {
            if ((localBitmap == null) && (paramOptions != null) && (!paramOptions.inJustDecodeBounds)) {
                AQUtility.debug("decode image failed", paramString);
            }
            return localBitmap;
            if (paramArrayOfByte != null) {
                localBitmap = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, paramOptions);
            }
        }
    }

    /* Error */
    private static Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions, boolean paramBoolean) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 7
        //   3: aconst_null
        //   4: astore 5
        //   6: aload_1
        //   7: astore 4
        //   9: aload_1
        //   10: ifnonnull +12 -> 22
        //   13: new 278	android/graphics/BitmapFactory$Options
        //   16: dup
        //   17: invokespecial 298	android/graphics/BitmapFactory$Options:<init>	()V
        //   20: astore 4
        //   22: aload 4
        //   24: iconst_1
        //   25: putfield 301	android/graphics/BitmapFactory$Options:inInputShareable	Z
        //   28: aload 4
        //   30: iconst_1
        //   31: putfield 304	android/graphics/BitmapFactory$Options:inPurgeable	Z
        //   34: aconst_null
        //   35: astore_1
        //   36: aconst_null
        //   37: astore 6
        //   39: new 306	java/io/FileInputStream
        //   42: dup
        //   43: aload_0
        //   44: invokespecial 309	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
        //   47: astore_3
        //   48: aload 7
        //   50: astore_1
        //   51: aload_3
        //   52: invokevirtual 313	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
        //   55: aconst_null
        //   56: aload 4
        //   58: invokestatic 317	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
        //   61: astore 4
        //   63: aload 4
        //   65: astore_1
        //   66: aload 4
        //   68: ifnull +22 -> 90
        //   71: aload 4
        //   73: astore_1
        //   74: iload_2
        //   75: ifeq +15 -> 90
        //   78: aload 4
        //   80: astore_1
        //   81: aload_0
        //   82: aload 4
        //   84: invokestatic 320	com/androidquery/callback/BitmapAjaxCallback:rotate	(Ljava/lang/String;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
        //   87: astore_0
        //   88: aload_0
        //   89: astore_1
        //   90: aload_3
        //   91: invokestatic 324	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
        //   94: aload_1
        //   95: areturn
        //   96: astore_3
        //   97: aload 5
        //   99: astore 4
        //   101: aload 6
        //   103: astore_0
        //   104: aload_0
        //   105: astore_1
        //   106: aload_3
        //   107: invokestatic 328	com/androidquery/util/AQUtility:report	(Ljava/lang/Throwable;)V
        //   110: aload_0
        //   111: invokestatic 324	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
        //   114: aload 4
        //   116: areturn
        //   117: astore_0
        //   118: aload_1
        //   119: invokestatic 324	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
        //   122: aload_0
        //   123: athrow
        //   124: astore_0
        //   125: aload_3
        //   126: astore_1
        //   127: goto -9 -> 118
        //   130: astore 4
        //   132: aload_3
        //   133: astore_0
        //   134: aload 4
        //   136: astore_3
        //   137: aload_1
        //   138: astore 4
        //   140: goto -36 -> 104
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	143	0	paramString	String
        //   0	143	1	paramOptions	BitmapFactory.Options
        //   0	143	2	paramBoolean	boolean
        //   47	44	3	localFileInputStream	java.io.FileInputStream
        //   96	37	3	localIOException1	java.io.IOException
        //   136	1	3	localIOException2	java.io.IOException
        //   7	108	4	localObject1	Object
        //   130	5	4	localIOException3	java.io.IOException
        //   138	1	4	localOptions	BitmapFactory.Options
        //   4	94	5	localObject2	Object
        //   37	65	6	localObject3	Object
        //   1	48	7	localObject4	Object
        // Exception table:
        //   from	to	target	type
        //   39	48	96	java/io/IOException
        //   39	48	117	finally
        //   106	110	117	finally
        //   51	63	124	finally
        //   81	88	124	finally
        //   51	63	130	java/io/IOException
        //   81	88	130	java/io/IOException
    }

    private static boolean fadeIn(int paramInt1, int paramInt2) {
        boolean bool2 = true;
        boolean bool1 = bool2;
        switch (paramInt1) {
        }
        do {
            bool1 = false;
            do {
                return bool1;
                bool1 = bool2;
            } while (paramInt2 == 3);
        } while (paramInt2 != 1);
        return true;
    }

    private static Bitmap filter(View paramView, Bitmap paramBitmap, int paramInt) {
        Bitmap localBitmap = paramBitmap;
        if (paramBitmap != null) {
            localBitmap = paramBitmap;
            if (paramBitmap.getWidth() == 1) {
                localBitmap = paramBitmap;
                if (paramBitmap.getHeight() == 1) {
                    localBitmap = paramBitmap;
                    if (paramBitmap != empty) {
                        localBitmap = null;
                    }
                }
            }
        }
        if (localBitmap != null) {
            paramView.setVisibility(0);
        }
        do {
            return localBitmap;
            if (paramInt == -2) {
                paramView.setVisibility(8);
                return localBitmap;
            }
        } while (paramInt != -1);
        paramView.setVisibility(4);
        return localBitmap;
    }

    private static Map<String, Bitmap> getBCache() {
        if (bigCache == null) {
            bigCache = Collections.synchronizedMap(new BitmapCache(BIG_MAX, BIG_PIXELS, BIG_TPIXELS));
        }
        return bigCache;
    }

    public static Bitmap getEmptyBitmap() {
        return empty;
    }

    private Bitmap getFallback() {
        Object localObject = null;
        View localView = (View) this.v.get();
        if (localView != null) {
            String str = Integer.toString(this.fallback);
            Bitmap localBitmap = memGet(str);
            localObject = localBitmap;
            if (localBitmap == null) {
                localBitmap = BitmapFactory.decodeResource(localView.getResources(), this.fallback);
                localObject = localBitmap;
                if (localBitmap != null) {
                    memPut(str, localBitmap);
                    localObject = localBitmap;
                }
            }
        }
        return (Bitmap) localObject;
    }

    private static Map<String, Bitmap> getICache() {
        if (invalidCache == null) {
            invalidCache = Collections.synchronizedMap(new BitmapCache(100, BIG_PIXELS, 250000));
        }
        return invalidCache;
    }

    private static String getKey(String paramString, int paramInt1, int paramInt2) {
        String str = paramString;
        if (paramInt1 > 0) {
            str = paramString + "#" + paramInt1;
        }
        paramString = str;
        if (paramInt2 > 0) {
            paramString = str + "#" + paramInt2;
        }
        return paramString;
    }

    public static Bitmap getMemoryCached(Context paramContext, int paramInt) {
        String str = Integer.toString(paramInt);
        Bitmap localBitmap = memGet(str, 0, 0);
        Object localObject = localBitmap;
        if (localBitmap == null) {
            paramContext = BitmapFactory.decodeResource(paramContext.getResources(), paramInt);
            localObject = paramContext;
            if (paramContext != null) {
                memPut(str, 0, 0, paramContext, false);
                localObject = paramContext;
            }
        }
        return (Bitmap) localObject;
    }

    public static Bitmap getMemoryCached(String paramString, int paramInt) {
        return memGet(paramString, paramInt, 0);
    }

    public static Bitmap getResizedImage(String paramString, byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean, int paramInt2) {
        return getResizedImage(paramString, paramArrayOfByte, paramInt1, paramBoolean, paramInt2, false);
    }

    public static Bitmap getResizedImage(String paramString, byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2) {
        if ((paramString == null) && (paramArrayOfByte == null)) {
            paramArrayOfByte = null;
        }
        for (; ; ) {
            return paramArrayOfByte;
            BitmapFactory.Options localOptions = null;
            if (paramInt1 > 0) {
                localOptions = new BitmapFactory.Options();
                localOptions.inJustDecodeBounds = true;
                decode(paramString, paramArrayOfByte, localOptions, paramBoolean2);
                int j = localOptions.outWidth;
                int i = j;
                if (!paramBoolean1) {
                    i = Math.max(j, localOptions.outHeight);
                }
                paramInt1 = sampleSize(i, paramInt1);
                localOptions = new BitmapFactory.Options();
                localOptions.inSampleSize = paramInt1;
            }
            Object localObject = null;
            try {
                paramString = decode(paramString, paramArrayOfByte, localOptions, paramBoolean2);
                paramArrayOfByte = paramString;
                if (paramInt2 <= 0) {
                    continue;
                }
                return getRoundedCornerBitmap(paramString, paramInt2);
            } catch (OutOfMemoryError paramString) {
                for (; ; ) {
                    clearCache();
                    AQUtility.report(paramString);
                    paramString = (String) localObject;
                }
            }
        }
    }

    private static Matrix getRotateMatrix(int paramInt) {
        Matrix localMatrix = new Matrix();
        switch (paramInt) {
            default:
                return localMatrix;
            case 2:
                localMatrix.setScale(-1.0F, 1.0F);
                return localMatrix;
            case 3:
                localMatrix.setRotate(180.0F);
                return localMatrix;
            case 4:
                localMatrix.setRotate(180.0F);
                localMatrix.postScale(-1.0F, 1.0F);
                return localMatrix;
            case 5:
                localMatrix.setRotate(90.0F);
                localMatrix.postScale(-1.0F, 1.0F);
                return localMatrix;
            case 6:
                localMatrix.setRotate(90.0F);
                return localMatrix;
            case 7:
                localMatrix.setRotate(-90.0F);
                localMatrix.postScale(-1.0F, 1.0F);
                return localMatrix;
        }
        localMatrix.setRotate(-90.0F);
        return localMatrix;
    }

    private static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, int paramInt) {
        Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
        RectF localRectF = new RectF(localRect);
        float f = paramInt;
        localPaint.setAntiAlias(true);
        localCanvas.drawARGB(0, 0, 0, 0);
        localPaint.setColor(-12434878);
        localCanvas.drawRoundRect(localRectF, f, f, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
        return localBitmap;
    }

    private static Map<String, Bitmap> getSCache() {
        if (smallCache == null) {
            smallCache = Collections.synchronizedMap(new BitmapCache(SMALL_MAX, SMALL_PIXELS, 250000));
        }
        return smallCache;
    }

    public static boolean isMemoryCached(String paramString) {
        return (getBCache().containsKey(paramString)) || (getSCache().containsKey(paramString)) || (getICache().containsKey(paramString));
    }

    private static Drawable makeDrawable(ImageView paramImageView, Bitmap paramBitmap, float paramFloat1, float paramFloat2) {
        if (paramFloat1 > 0.0F) {
            return new RatioDrawable(paramImageView.getResources(), paramBitmap, paramImageView, paramFloat1, paramFloat2);
        }
        return new BitmapDrawable(paramImageView.getResources(), paramBitmap);
    }

    private static Bitmap memGet(String paramString, int paramInt1, int paramInt2) {
        String str = getKey(paramString, paramInt1, paramInt2);
        Object localObject = (Bitmap) getBCache().get(str);
        paramString = (String) localObject;
        if (localObject == null) {
            paramString = (Bitmap) getSCache().get(str);
        }
        localObject = paramString;
        if (paramString == null) {
            paramString = (Bitmap) getICache().get(str);
            localObject = paramString;
            if (paramString != null) {
                localObject = paramString;
                if (getLastStatus() == 200) {
                    invalidCache = null;
                    localObject = null;
                }
            }
        }
        return (Bitmap) localObject;
    }

    private static void memPut(String paramString, int paramInt1, int paramInt2, Bitmap paramBitmap, boolean paramBoolean) {
        if (paramBitmap == null) {
            return;
        }
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        Map localMap;
        if (paramBoolean) {
            localMap = getICache();
        }
        for (; ; ) {
            if ((paramInt1 <= 0) && (paramInt2 <= 0)) {
                break label99;
            }
            localMap.put(getKey(paramString, paramInt1, paramInt2), paramBitmap);
            if (localMap.containsKey(paramString)) {
                break;
            }
            localMap.put(paramString, null);
            return;
            if (i * j <= SMALL_PIXELS) {
                localMap = getSCache();
            } else {
                localMap = getBCache();
            }
        }
        label99:
        localMap.put(paramString, paramBitmap);
    }

    private void presetBitmap(String paramString, ImageView paramImageView) {
        if ((!paramString.equals(paramImageView.getTag(1090453505))) || (this.preset != null)) {
            paramImageView.setTag(1090453505, paramString);
            if ((this.preset != null) && (!cacheAvailable(paramImageView.getContext()))) {
                setBitmap(paramString, paramImageView, this.preset, true);
            }
        } else {
            return;
        }
        setBitmap(paramString, paramImageView, null, true);
    }

    private static Bitmap rotate(String paramString, Bitmap paramBitmap) {
        if (paramBitmap == null) {
            paramString = null;
        }
        Bitmap localBitmap;
        do {
            int i;
            do {
                return paramString;
                localBitmap = paramBitmap;
                i = 1;
                try {
                    int j = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
                    i = j;
                } catch (Exception paramString) {
                    for (; ; ) {
                        AQUtility.debug(paramString);
                    }
                }
                paramString = localBitmap;
            } while (i <= 0);
            paramString = getRotateMatrix(i);
            localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramString, true);
            AQUtility.debug("before", paramBitmap.getWidth() + ":" + paramBitmap.getHeight());
            AQUtility.debug("after", localBitmap.getWidth() + ":" + localBitmap.getHeight());
            paramString = localBitmap;
        } while (paramBitmap == localBitmap);
        paramBitmap.recycle();
        return localBitmap;
    }

    private static int sampleSize(int paramInt1, int paramInt2) {
        int i = 1;
        int k = 0;
        int j = paramInt1;
        paramInt1 = k;
        for (; ; ) {
            if (paramInt1 >= 10) {
            }
            while (j < paramInt2 * 2) {
                return i;
            }
            j /= 2;
            i *= 2;
            paramInt1 += 1;
        }
    }

    private void setBitmap(String paramString, ImageView paramImageView, Bitmap paramBitmap, boolean paramBoolean) {
        if (paramBitmap == null) {
            paramImageView.setImageDrawable(null);
        }
        do {
            return;
            if (paramBoolean) {
                paramImageView.setImageDrawable(makeDrawable(paramImageView, paramBitmap, this.ratio, this.anchor));
                return;
            }
        } while (this.status == null);
        setBmAnimate(paramImageView, paramBitmap, this.preset, this.fallback, this.animation, this.ratio, this.anchor, this.status.getSource());
    }

    private static void setBmAnimate(ImageView paramImageView, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3) {
        paramBitmap1 = filter(paramImageView, paramBitmap1, paramInt1);
        if (paramBitmap1 == null) {
            paramImageView.setImageBitmap(null);
            return;
        }
        Drawable localDrawable = makeDrawable(paramImageView, paramBitmap1, paramFloat1, paramFloat2);
        paramBitmap1 = null;
        if (fadeIn(paramInt2, paramInt3)) {
            if (paramBitmap2 == null) {
                paramBitmap1 = new AlphaAnimation(0.0F, 1.0F);
                paramBitmap1.setInterpolator(new DecelerateInterpolator());
                paramBitmap1.setDuration(300L);
                paramBitmap2 = localDrawable;
            }
        }
        for (; ; ) {
            paramImageView.setImageDrawable(paramBitmap2);
            if (paramBitmap1 == null) {
                break;
            }
            paramBitmap1.setStartTime(AnimationUtils.currentAnimationTimeMillis());
            paramImageView.startAnimation(paramBitmap1);
            return;
            paramBitmap2 = new TransitionDrawable(new Drawable[]{makeDrawable(paramImageView, paramBitmap2, paramFloat1, paramFloat2), localDrawable});
            paramBitmap2.setCrossFadeEnabled(true);
            paramBitmap2.startTransition(300);
            continue;
            paramBitmap2 = localDrawable;
            if (paramInt2 > 0) {
                paramBitmap1 = AnimationUtils.loadAnimation(paramImageView.getContext(), paramInt2);
                paramBitmap2 = localDrawable;
            }
        }
        paramImageView.setAnimation(null);
    }

    public static void setCacheLimit(int paramInt) {
        BIG_MAX = paramInt;
        clearCache();
    }

    public static void setDelayWrite(boolean paramBoolean) {
        DELAY_WRITE = paramBoolean;
    }

    public static void setIconCacheLimit(int paramInt) {
        SMALL_MAX = paramInt;
        clearCache();
    }

    public static void setMaxPixelLimit(int paramInt) {
        BIG_TPIXELS = paramInt;
        clearCache();
    }

    public static void setPixelLimit(int paramInt) {
        BIG_PIXELS = paramInt;
        clearCache();
    }

    public static void setSmallPixel(int paramInt) {
        SMALL_PIXELS = paramInt;
        clearCache();
    }

    protected File accessFile(File paramFile, String paramString) {
        if ((this.imageFile != null) && (this.imageFile.exists())) {
            return this.imageFile;
        }
        return super.accessFile(paramFile, paramString);
    }

    public BitmapAjaxCallback anchor(float paramFloat) {
        this.anchor = paramFloat;
        return this;
    }

    public BitmapAjaxCallback animation(int paramInt) {
        this.animation = paramInt;
        return this;
    }

    public void async(Context paramContext) {
        paramContext = getUrl();
        ImageView localImageView = (ImageView) this.v.get();
        if (paramContext == null) {
            showProgress(false);
            setBitmap(paramContext, localImageView, null, false);
            return;
        }
        Bitmap localBitmap = memGet(paramContext);
        if (localBitmap != null) {
            localImageView.setTag(1090453505, paramContext);
            this.status = new AjaxStatus().source(4).done();
            callback(paramContext, localBitmap, this.status);
            return;
        }
        presetBitmap(paramContext, localImageView);
        if (!queueMap.containsKey(paramContext)) {
            addQueue(paramContext, localImageView);
            super.async(localImageView.getContext());
            return;
        }
        showProgress(true);
        addQueue(paramContext, localImageView);
    }

    public BitmapAjaxCallback bitmap(Bitmap paramBitmap) {
        this.bm = paramBitmap;
        return this;
    }

    public final void callback(String paramString, Bitmap paramBitmap, AjaxStatus paramAjaxStatus) {
        Object localObject = (ImageView) this.v.get();
        WeakHashMap localWeakHashMap = (WeakHashMap) queueMap.remove(paramString);
        if ((localWeakHashMap == null) || (!localWeakHashMap.containsKey(localObject))) {
            checkCb(this, paramString, (ImageView) localObject, paramBitmap, paramAjaxStatus);
        }
        if (localWeakHashMap != null) {
            localObject = localWeakHashMap.keySet().iterator();
        }
        for (; ; ) {
            if (!((Iterator) localObject).hasNext()) {
                return;
            }
            ImageView localImageView = (ImageView) ((Iterator) localObject).next();
            BitmapAjaxCallback localBitmapAjaxCallback = (BitmapAjaxCallback) localWeakHashMap.get(localImageView);
            localBitmapAjaxCallback.status = paramAjaxStatus;
            checkCb(localBitmapAjaxCallback, paramString, localImageView, paramBitmap, paramAjaxStatus);
        }
    }

    protected void callback(String paramString, ImageView paramImageView, Bitmap paramBitmap, AjaxStatus paramAjaxStatus) {
        setBitmap(paramString, paramImageView, paramBitmap, false);
    }

    public BitmapAjaxCallback fallback(int paramInt) {
        this.fallback = paramInt;
        return this;
    }

    public BitmapAjaxCallback file(File paramFile) {
        this.imageFile = paramFile;
        return this;
    }

    protected Bitmap fileGet(String paramString, File paramFile, AjaxStatus paramAjaxStatus) {
        return bmGet(paramFile.getAbsolutePath(), null);
    }

    public BitmapAjaxCallback imageView(ImageView paramImageView) {
        this.v = new WeakReference(paramImageView);
        return this;
    }

    protected boolean isStreamingContent() {
        return !DELAY_WRITE;
    }

    protected Bitmap memGet(String paramString) {
        if (this.bm != null) {
            return this.bm;
        }
        if (!this.memCache) {
            return null;
        }
        return memGet(paramString, this.targetWidth, this.round);
    }

    protected void memPut(String paramString, Bitmap paramBitmap) {
        memPut(paramString, this.targetWidth, this.round, paramBitmap, this.invalid);
    }

    public BitmapAjaxCallback preset(Bitmap paramBitmap) {
        this.preset = paramBitmap;
        return this;
    }

    public BitmapAjaxCallback ratio(float paramFloat) {
        this.ratio = paramFloat;
        return this;
    }

    public BitmapAjaxCallback rotate(boolean paramBoolean) {
        this.rotate = paramBoolean;
        return this;
    }

    public BitmapAjaxCallback round(int paramInt) {
        this.round = paramInt;
        return this;
    }

    protected void skip(String paramString, Bitmap paramBitmap, AjaxStatus paramAjaxStatus) {
        queueMap.remove(paramString);
    }

    public BitmapAjaxCallback targetWidth(int paramInt) {
        this.targetWidth = paramInt;
        return this;
    }

    public Bitmap transform(String paramString, byte[] paramArrayOfByte, AjaxStatus paramAjaxStatus) {
        paramString = null;
        File localFile = paramAjaxStatus.getFile();
        if (localFile != null) {
            paramString = localFile.getAbsolutePath();
        }
        paramString = bmGet(paramString, paramArrayOfByte);
        paramArrayOfByte = paramString;
        if (paramString == null) {
            if (this.fallback <= 0) {
                break label92;
            }
            paramString = getFallback();
        }
        for (; ; ) {
            if (paramAjaxStatus.getCode() != 200) {
                this.invalid = true;
            }
            paramArrayOfByte = paramString;
            if (paramAjaxStatus.getSource() == 1) {
                paramArrayOfByte = paramString;
                if (localFile != null) {
                    AQUtility.debug("invalid bm from net");
                    localFile.delete();
                    paramArrayOfByte = paramString;
                }
            }
            return paramArrayOfByte;
            label92:
            if ((this.fallback == -2) || (this.fallback == -1)) {
                paramString = dummy;
            } else if (this.fallback == -3) {
                paramString = this.preset;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/callback/BitmapAjaxCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */