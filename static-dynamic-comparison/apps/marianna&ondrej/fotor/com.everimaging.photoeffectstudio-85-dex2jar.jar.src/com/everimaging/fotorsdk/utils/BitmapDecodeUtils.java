package com.everimaging.fotorsdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build.VERSION;
import com.everimaging.bitmap.EIBitmapUtil;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BitmapDecodeUtils {
    private static final String TAG = BitmapDecodeUtils.class.getSimpleName();
    private static final FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);

    private static int computeSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        double d1;
        if ((paramInt5 == 0) || (paramInt5 == 180)) {
            d1 = paramInt1;
        }
        for (double d2 = paramInt2; ; d2 = paramInt1) {
            return (int) Math.ceil(Math.max(d1 / paramInt3, d2 / paramInt4));
            d1 = paramInt2;
        }
    }

    public static Bitmap decode(Context paramContext, Uri paramUri) {
        return decode(paramContext, paramUri, 0, 0);
    }

    public static Bitmap decode(Context paramContext, Uri paramUri, int paramInt1, int paramInt2) {
        return decode(paramContext, paramUri, paramInt1, paramInt2, null, ExifUtils.getExifOrientation(paramContext, paramUri));
    }

    public static Bitmap decode(Context paramContext, Uri paramUri, int paramInt1, int paramInt2, ImageSize paramImageSize) {
        return decode(paramContext, paramUri, paramInt1, paramInt2, paramImageSize, ExifUtils.getExifOrientation(paramContext, paramUri));
    }

    public static Bitmap decode(Context paramContext, Uri paramUri, int paramInt1, int paramInt2, ImageSize paramImageSize, int paramInt3) {
        Object localObject = new int[2];
        logger.f(new Object[]{"decode: " + paramUri});
        InputStream localInputStream = openInputStream(paramContext, paramUri);
        if (localInputStream == null) {
            paramContext = null;
            return paramContext;
        }
        logger.d(new Object[]{"opened input stream"});
        boolean bool = decodeImageBounds(localInputStream, (int[]) localObject);
        FotorIOUtils.closeSilently(localInputStream);
        logger.d(new Object[]{"docodeImageBounds:w" + localObject[0], "h:" + localObject[1]});
        int i = paramInt3 % 360;
        int j;
        if ((i == 90) || (i == 270)) {
            j = 1;
            label174:
            if (j == 0) {
                break label451;
            }
            i = localObject[1];
            label185:
            if (j == 0) {
                break label460;
            }
            j = localObject[0];
            label196:
            if (paramInt1 > 0) {
                break label481;
            }
            paramInt1 = i;
        }
        label451:
        label460:
        label481:
        for (; ; ) {
            if (paramInt2 <= 0) {
                paramInt2 = j;
            }
            for (; ; ) {
                logger.c(new Object[]{"maxW:" + paramInt1, "maxH:" + paramInt2, "orientation: " + paramInt3});
                if (bool) {
                    if (paramImageSize != null) {
                        paramImageSize.setOriginalSize(i, j);
                    }
                    int k = computeSampleSize(localObject[0], localObject[1], (int) (paramInt1 * 1.2D), (int) (paramInt2 * 1.2D), paramInt3);
                    localObject = getDefaultOptions();
                    float f1 = paramInt1;
                    float f2 = paramInt2;
                    if ((i < f1 * 1.5F + 100.0F) && (j < f2 * 1.5F)) {
                        logger.f(new Object[]{"try to use sample size = 1"});
                    }
                    for (i = 1; ; i = k) {
                        ((BitmapFactory.Options) localObject).inSampleSize = i;
                        paramUri = decodeBitmap(paramContext, paramUri, (BitmapFactory.Options) localObject, paramInt1, paramInt2, paramInt3, 0);
                        paramContext = paramUri;
                        if (paramUri == null) {
                            break;
                        }
                        paramContext = paramUri;
                        if (paramImageSize == null) {
                            break;
                        }
                        paramImageSize.setNewSize(paramUri.getWidth(), paramUri.getHeight());
                        return paramUri;
                        j = 0;
                        break label174;
                        i = localObject[0];
                        break label185;
                        j = localObject[1];
                        break label196;
                    }
                }
                return null;
            }
        }
    }

    static Bitmap decodeBitmap(Context paramContext, Uri paramUri, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        logger.f(new Object[]{"decodeBitmap: " + paramOptions.inSampleSize + ", pass: " + paramInt4});
        if (paramInt4 > 10) {
            paramContext = null;
        }
        for (; ; ) {
            return paramContext;
            Object localObject1 = openInputStream(paramContext, paramUri);
            if (localObject1 == null) {
                return null;
            }
            logger.d(new Object[]{"opened input stream"});
            try {
                localObject4 = decodeStreamNative((InputStream) localObject1, paramOptions);
                localObject5 = localObject1;
                localObject3 = localObject4;
            } catch (OutOfMemoryError localOutOfMemoryError3) {
                for (; ; ) {
                    try {
                        FotorIOUtils.closeSilently((Closeable) localObject1);
                        localObject3 = localObject1;
                        localObject5 = localObject4;
                        if (localObject4 == null) {
                            localObject5 = localObject1;
                            localObject3 = localObject4;
                            logger.e(new Object[]{"decodeStreamNative return null"});
                            localObject5 = localObject1;
                            localObject3 = localObject4;
                            localObject1 = openInputStream(paramContext, paramUri);
                            if (localObject1 == null) {
                                return null;
                            }
                            localObject5 = localObject1;
                            localObject3 = localObject4;
                            localObject4 = BitmapFactory.decodeStream((InputStream) localObject1, null, paramOptions);
                            localObject5 = localObject1;
                            localObject3 = localObject4;
                            FotorIOUtils.closeSilently((Closeable) localObject1);
                            localObject5 = localObject4;
                            localObject3 = localObject1;
                        }
                        localObject4 = localObject5;
                        if (localObject4 == null) {
                            continue;
                        }
                    } catch (OutOfMemoryError localOutOfMemoryError1) {
                        Object localObject5;
                        Object localObject4 = localObject3;
                        Object localObject3 = localOutOfMemoryError3;
                        continue;
                        Object localObject2 = localObject4;
                        continue;
                    }
                    try {
                        logger.b(new Object[]{"loaded bitmap: " + ((Bitmap) localObject4).getWidth() + "x" + ((Bitmap) localObject4).getHeight()});
                        localObject5 = BitmapUtils.resizeBitmap((Bitmap) localObject4, paramInt1, paramInt2, BitmapUtils.ResizeMode.ASPECT_FIT, paramInt3);
                        logger.b(new Object[]{"resized: " + ((Bitmap) localObject5).getWidth() + "x" + ((Bitmap) localObject5).getHeight()});
                        localObject1 = localObject5;
                        if (localObject4 != localObject5) {
                            ((Bitmap) localObject4).recycle();
                            localObject1 = localObject5;
                        }
                        paramContext = (Context) localObject1;
                        if (localObject1 == null) {
                            break;
                        }
                        logger.c(new Object[]{"decode result bitmap w:" + ((Bitmap) localObject1).getWidth(), "h:" + ((Bitmap) localObject1).getHeight()});
                        return (Bitmap) localObject1;
                    } catch (OutOfMemoryError localOutOfMemoryError2) {
                        continue;
                    }
                    localOutOfMemoryError3 = localOutOfMemoryError3;
                    localObject4 = null;
                    localObject3 = localObject1;
                    localObject1 = localOutOfMemoryError3;
                    logger.e(new Object[]{((OutOfMemoryError) localObject1).getMessage()});
                    if (localObject4 != null) {
                        ((Bitmap) localObject4).recycle();
                    }
                    paramOptions.inSampleSize += 1;
                    localObject1 = decodeBitmap(paramContext, paramUri, paramOptions, paramInt1, paramInt2, paramInt3, paramInt4 + 1);
                    FotorIOUtils.closeSilently((Closeable) localObject3);
                }
            }
        }
    }

    public static Bitmap decodeFile(String paramString) {
        return decodeFile(paramString, null);
    }

    public static Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions) {
        if (EIBitmapUtil.a) {
            return EIBitmapUtil.a(paramString, Bitmap.Config.ARGB_8888);
        }
        return BitmapFactory.decodeFile(paramString, paramOptions);
    }

    public static boolean decodeImageBounds(InputStream paramInputStream, int[] paramArrayOfInt) {
        boolean bool2 = false;
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(paramInputStream, null, localOptions);
        if ((Build.VERSION.SDK_INT >= 19) && (paramInputStream.markSupported())) {
        }
        try {
            paramInputStream.reset();
            boolean bool1 = bool2;
            if (localOptions.outHeight > 0) {
                bool1 = bool2;
                if (localOptions.outWidth > 0) {
                    paramArrayOfInt[0] = localOptions.outWidth;
                    paramArrayOfInt[1] = localOptions.outHeight;
                    bool1 = true;
                }
            }
            return bool1;
        } catch (IOException paramInputStream) {
            paramInputStream.printStackTrace();
        }
        return false;
    }

    public static int[] decodeImageBounds(Context paramContext, Uri paramUri) {
        int[] arrayOfInt = new int[2];
        paramContext = openInputStream(paramContext, paramUri);
        if (paramContext == null) {
            return null;
        }
        decodeImageBounds(paramContext, arrayOfInt);
        return arrayOfInt;
    }

    public static Bitmap decodeStream(InputStream paramInputStream) {
        Bitmap localBitmap1 = null;
        if (EIBitmapUtil.a) {
            localBitmap1 = EIBitmapUtil.a(paramInputStream);
        }
        Bitmap localBitmap2 = localBitmap1;
        if (localBitmap1 == null) {
            localBitmap2 = BitmapFactory.decodeStream(paramInputStream);
        }
        return localBitmap2;
    }

    private static Bitmap decodeStreamNative(InputStream paramInputStream, BitmapFactory.Options paramOptions) {
        Object localObject = null;
        if (EIBitmapUtil.a) {
            paramInputStream = EIBitmapUtil.a(paramInputStream);
            localObject = paramInputStream;
            if (paramInputStream != null) {
                localObject = paramInputStream;
                if (paramOptions != null) {
                    localObject = paramInputStream;
                    if (paramOptions.inSampleSize != 1) {
                        float f = 1.0F / paramOptions.inSampleSize;
                        logger.c(new Object[]{"scale beforw:" + paramInputStream.getWidth() + ",h:" + paramInputStream.getHeight()});
                        localObject = BitmapUtils.scaleBitmap(paramInputStream, f);
                        logger.c(new Object[]{"scale after:" + ((Bitmap) localObject).getWidth() + ",h:" + ((Bitmap) localObject).getHeight()});
                    }
                }
            }
        }
        return (Bitmap) localObject;
    }

    private static BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inScaled = false;
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        localOptions.inDither = false;
        localOptions.inJustDecodeBounds = false;
        localOptions.inPurgeable = false;
        localOptions.inInputShareable = false;
        localOptions.inTempStorage = new byte['䀀'];
        return localOptions;
    }

    public static Bitmap nativeDecode(Context paramContext, Uri paramUri, int paramInt1, int paramInt2) {
        int j = ExifUtils.getExifOrientation(paramContext, paramUri);
        int i = j % 360;
        boolean bool;
        if ((i == 90) || (i == 270)) {
            bool = true;
            logger.c(new Object[]{"nativeDecode:" + paramInt1, "maxH:" + paramInt2 + ",isSwapWidth:" + bool});
            if (!bool) {
                break label132;
            }
            i = paramInt2;
            label109:
            if (!bool) {
                break label138;
            }
        }
        for (; ; ) {
            return decode(paramContext, paramUri, i, paramInt1, null, j);
            bool = false;
            break;
            label132:
            i = paramInt1;
            break label109;
            label138:
            paramInt1 = paramInt2;
        }
    }

    private static InputStream openAndroidSourcenputStream(Context paramContext, Uri paramUri) {
        try {
            paramContext = paramContext.getContentResolver().openInputStream(paramUri);
            return paramContext;
        } catch (FileNotFoundException paramContext) {
            paramContext.printStackTrace();
        }
        return null;
    }

    private static InputStream openContentInputStream(Context paramContext, Uri paramUri) {
        try {
            paramContext = paramContext.getContentResolver().openInputStream(paramUri);
            return paramContext;
        } catch (FileNotFoundException paramContext) {
            paramContext.printStackTrace();
        }
        return null;
    }

    private static InputStream openFileInputStream(String paramString) {
        try {
            paramString = new FileInputStream(paramString);
            return paramString;
        } catch (FileNotFoundException paramString) {
            paramString.printStackTrace();
        }
        return null;
    }

    private static InputStream openInputStream(Context paramContext, Uri paramUri) {
        if (paramUri == null) {
        }
        String str;
        do {
            return null;
            str = paramUri.getScheme();
            if ((str == null) || ("file".equals(str))) {
                if (("file".equals(str)) && (paramUri.getPath().startsWith("/android_asset/"))) {
                    try {
                        paramContext = paramContext.getAssets().open(paramUri.getPath().substring("/android_asset/".length()));
                        return paramContext;
                    } catch (IOException paramContext) {
                        paramContext.printStackTrace();
                        return null;
                    }
                }
                return openFileInputStream(paramUri.getPath());
            }
            if ("content".equals(str)) {
                return openContentInputStream(paramContext, paramUri);
            }
            if (("http".equals(str)) || ("https".equals(str))) {
                return openRemoteInputStream(paramUri);
            }
        } while (!"android.resource".equals(str));
        return openAndroidSourcenputStream(paramContext, paramUri);
    }

    private static InputStream openRemoteInputStream(Uri paramUri) {
        try {
            paramUri = new URL(paramUri.toString());
            try {
                HttpURLConnection localHttpURLConnection;
                int i;
                paramUri = (InputStream) paramUri.getContent();
                return paramUri;
            } catch (IOException paramUri) {
                paramUri.printStackTrace();
            }
        } catch (MalformedURLException paramUri) {
            for (; ; ) {
                try {
                    localHttpURLConnection = (HttpURLConnection) paramUri.openConnection();
                    localHttpURLConnection.setInstanceFollowRedirects(false);
                } catch (IOException paramUri) {
                    paramUri.printStackTrace();
                    return null;
                }
                try {
                    i = localHttpURLConnection.getResponseCode();
                    if ((i != 301) && (i != 302) && (i != 303)) {
                        break;
                    }
                    return openRemoteInputStream(Uri.parse(localHttpURLConnection.getHeaderField("Location")));
                } catch (IOException paramUri) {
                    paramUri.printStackTrace();
                    return null;
                }
            }
            paramUri = paramUri;
            paramUri.printStackTrace();
            return null;
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/BitmapDecodeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */