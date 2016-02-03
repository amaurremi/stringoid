package com.everimaging.fotorsdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Debug;
import android.os.Environment;
import android.os.Looper;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Utils {
    private static final String TAG = Utils.class.getSimpleName();
    private static FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);

    public static boolean copyFile(File paramFile1, File paramFile2) {
        if (!paramFile1.exists()) {
            return false;
        }
        try {
            paramFile1 = new FileInputStream(paramFile1);
            paramFile2 = new FileOutputStream(paramFile2);
            byte[] arrayOfByte = new byte[' '];
            for (; ; ) {
                int i = paramFile1.read(arrayOfByte);
                if (i == -1) {
                    break;
                }
                paramFile2.write(arrayOfByte, 0, i);
            }
            paramFile1.close();
        } catch (IOException paramFile1) {
            paramFile1.printStackTrace();
            return false;
        }
        paramFile2.close();
        return true;
    }

    public static boolean copyFile(String paramString1, String paramString2) {
        return copyFile(new File(paramString1), new File(paramString2));
    }

    public static final String generateFileName(String paramString) {
        return System.currentTimeMillis() + "." + paramString;
    }

    public static final String generateJPGFullPath(String paramString) {
        return paramString + File.separator + generateFileName("jpg");
    }

    public static long getApplicationMaxMemory() {
        return Runtime.getRuntime().maxMemory();
    }

    public static long getFreeMemory() {
        return Runtime.getRuntime().maxMemory() - Debug.getNativeHeapAllocatedSize();
    }

    public static float getFreeMemoryM() {
        int i = (int) (getFreeMemory() >> 10);
        return i % 1024 / 1000.0F + (i >> 10);
    }

    public static float getMemoryM(long paramLong) {
        paramLong >>= 10;
        int i = (int) (paramLong >> 10);
        return (float) (paramLong % 1024L) / 1000.0F + i;
    }

    public static float getNativeUseredMemoryM() {
        return getMemoryM(Debug.getNativeHeapAllocatedSize());
    }

    public static String getSDPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static boolean isSDCardAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean isUIThread(Context paramContext) {
        return Thread.currentThread() == paramContext.getMainLooper().getThread();
    }

    public static void makeNomedia(File paramFile) {
        paramFile = new File(paramFile, ".nomedia");
        if (!paramFile.exists()) {
            paramFile.mkdir();
        }
    }

    public static void printBitmapPixles(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt) {
        if ((paramBitmap1 != null) && (paramBitmap2 != null)) {
        }
        for (; ; ) {
            try {
                if ((paramBitmap1.getConfig() != paramBitmap2.getConfig()) || (paramBitmap1.getWidth() != paramBitmap2.getWidth()) || (paramBitmap1.getHeight() != paramBitmap2.getHeight())) {
                    break label197;
                }
                arrayOfInt = new int[paramBitmap1.getWidth() * paramBitmap1.getHeight()];
                paramBitmap1.getPixels(arrayOfInt, 0, paramBitmap1.getWidth(), 0, 0, paramBitmap1.getWidth(), paramBitmap1.getHeight());
                paramBitmap1 = new int[paramBitmap2.getWidth() * paramBitmap2.getHeight()];
                paramBitmap2.getPixels(paramBitmap1, 0, paramBitmap2.getWidth(), 0, 0, paramBitmap2.getWidth(), paramBitmap2.getHeight());
                i = paramInt;
                if (paramInt != 0) {
                    break label198;
                }
                i = paramBitmap1.length;
            } catch (Exception paramBitmap1) {
                int[] arrayOfInt;
                int i;
                paramBitmap1.printStackTrace();
            }
            if (paramInt < i) {
                System.out.println("arg1 pixels:" + Integer.toHexString(arrayOfInt[paramInt]));
                System.out.println("arg2 pixels:" + Integer.toHexString(paramBitmap1[paramInt]));
                paramInt += 1;
            } else {
                label197:
                return;
                label198:
                paramInt = 0;
            }
        }
    }

    public static void printMemoryInfo() {
        if (FotorLoggerFactory.a) {
            System.gc();
            System.gc();
        }
        try {
            logger.f(new Object[]{"*******MemoryInfo from class:" + Thread.currentThread().getStackTrace()[3].getClassName().substring(Thread.currentThread().getStackTrace()[3].getClassName().lastIndexOf(".")) + ",methodname:" + Thread.currentThread().getStackTrace()[3].getMethodName() + ",linenumber:" + Thread.currentThread().getStackTrace()[3].getLineNumber() + "********************"});
            double[] arrayOfDouble = new double[3];
            SystemUtils.getRuntimeMemoryInfo(arrayOfDouble);
            logger.f(new Object[]{"heap_max:" + arrayOfDouble[2] + "M"});
            logger.f(new Object[]{"heap_used:" + arrayOfDouble[1] + "M"});
            logger.f(new Object[]{"heap_free:" + arrayOfDouble[0] + "M"});
            logger.f(new Object[]{"native_size:" + getMemoryM(Debug.getNativeHeapSize()) + "M"});
            logger.f(new Object[]{"native_AllocatedSize:" + getMemoryM(Debug.getNativeHeapAllocatedSize()) + "M"});
            logger.f(new Object[]{"native_free:" + getMemoryM(Debug.getNativeHeapFreeSize()) + "M"});
            return;
        } catch (Exception localException) {
            for (; ; ) {
                logger.f(new Object[]{"******************MemoryInfo********************"});
            }
        }
    }

    public static String readStringFromInputStream(InputStream paramInputStream) {
        try {
            paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
            StringBuilder localStringBuilder = new StringBuilder();
            for (; ; ) {
                String str = paramInputStream.readLine();
                if (str == null) {
                    break;
                }
                localStringBuilder.append(str);
            }
            paramInputStream = localStringBuilder.toString();
            return paramInputStream;
        } catch (Exception paramInputStream) {
        }
        return null;
    }

    public static boolean saveBitmap2Path(String paramString, Bitmap paramBitmap, int paramInt) {
        logger.f(new Object[]{">>>>>saveBitmap2Path>>>>>:" + paramString});
        try {
            bool = paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, new FileOutputStream(paramString));
            logger.f(new Object[]{"<<<<<<saveBitmap2Path<<<<<<"});
            return bool;
        } catch (FileNotFoundException paramString) {
            for (; ; ) {
                paramString.printStackTrace();
                boolean bool = false;
            }
        }
    }

    public static void sleep(int paramInt) {
        long l = paramInt;
        try {
            Thread.sleep(l);
            return;
        } catch (InterruptedException localInterruptedException) {
            localInterruptedException.printStackTrace();
        }
    }

    public static void throwIfNonUiThread(Context paramContext) {
        if (isUIThread(paramContext)) {
            throw new IllegalThreadStateException("Called from wrong thread!");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */