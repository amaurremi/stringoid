package com.androidquery.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.androidquery.AQuery;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AQUtility {
    private static final int IO_BUFFER_SIZE = 4096;
    public static boolean TEST_IO_EXCEPTION;
    private static File cacheDir;
    private static Context context;
    private static boolean debug = false;
    private static Thread.UncaughtExceptionHandler eh;
    private static Handler handler;
    private static final char[] map1;
    private static final byte[] map2;
    private static File pcacheDir;
    private static ScheduledExecutorService storeExe;
    private static Map<String, Long> times = new HashMap();
    private static Object wait;

    static {
        TEST_IO_EXCEPTION = false;
        map1 = new char[64];
        int i = 65;
        int j = 0;
        if (i > 90) {
            i = 97;
            label39:
            if (i <= 122) {
                break label119;
            }
            i = 48;
            label48:
            if (i <= 57) {
                break label137;
            }
            char[] arrayOfChar = map1;
            int k = j + 1;
            arrayOfChar[j] = '+';
            map1[k] = '/';
            map2 = new byte[''];
            j = 0;
            label84:
            if (j < map2.length) {
                break label155;
            }
            j = 0;
        }
        for (; ; ) {
            if (j >= 64) {
                return;
                map1[j] = i;
                i = (char) (i + 1);
                j += 1;
                break;
                label119:
                map1[j] = i;
                i = (char) (i + 1);
                j += 1;
                break label39;
                label137:
                map1[j] = i;
                i = (char) (i + 1);
                j += 1;
                break label48;
                label155:
                map2[j] = -1;
                j += 1;
                break label84;
            }
            map2[map1[j]] = ((byte) j);
            j += 1;
        }
    }

    public static void apply(SharedPreferences.Editor paramEditor) {
        if (AQuery.SDK_INT >= 9) {
            invokeHandler(paramEditor, "apply", false, true, null, null);
            return;
        }
        paramEditor.commit();
    }

    public static void cleanCache(File paramFile, long paramLong1, long paramLong2) {
        try {
            paramFile = paramFile.listFiles();
            if (paramFile == null) {
                return;
            }
            Arrays.sort(paramFile, new Common());
            if (testCleanNeeded(paramFile, paramLong1)) {
                cleanCache(paramFile, paramLong2);
            }
            paramFile = getTempDir();
            if ((paramFile != null) && (paramFile.exists())) {
                cleanCache(paramFile.listFiles(), 0L);
                return;
            }
        } catch (Exception paramFile) {
            report(paramFile);
        }
    }

    private static void cleanCache(File[] paramArrayOfFile, long paramLong) {
        long l2 = 0L;
        int j = 0;
        int i = 0;
        for (; ; ) {
            if (i >= paramArrayOfFile.length) {
                debug("deleted", Integer.valueOf(j));
                return;
            }
            File localFile = paramArrayOfFile[i];
            int k = j;
            long l1 = l2;
            if (localFile.isFile()) {
                l2 += localFile.length();
                k = j;
                l1 = l2;
                if (l2 >= paramLong) {
                    localFile.delete();
                    k = j + 1;
                    l1 = l2;
                }
            }
            i += 1;
            j = k;
            l2 = l1;
        }
    }

    public static void cleanCacheAsync(Context paramContext) {
        cleanCacheAsync(paramContext, 3000000L, 2000000L);
    }

    public static void cleanCacheAsync(Context paramContext, long paramLong1, long paramLong2) {
        try {
            paramContext = getCacheDir(paramContext);
            paramContext = new Common().method(2, new Object[]{paramContext, Long.valueOf(paramLong1), Long.valueOf(paramLong2)});
            getFileStoreExecutor().schedule(paramContext, 0L, TimeUnit.MILLISECONDS);
            return;
        } catch (Exception paramContext) {
            report(paramContext);
        }
    }

    public static void close(Closeable paramCloseable) {
        if (paramCloseable != null) {
        }
        try {
            paramCloseable.close();
            return;
        } catch (Exception paramCloseable) {
        }
    }

    public static void copy(InputStream paramInputStream, OutputStream paramOutputStream)
            throws IOException {
        copy(paramInputStream, paramOutputStream, 0, null);
    }

    public static void copy(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt, Progress paramProgress)
            throws IOException {
        if (paramProgress != null) {
            paramProgress.reset();
            paramProgress.setBytes(paramInt);
        }
        byte[] arrayOfByte = new byte['က'];
        paramInt = 0;
        for (; ; ) {
            int j = paramInputStream.read(arrayOfByte);
            if (j == -1) {
                if (paramProgress != null) {
                    paramProgress.done();
                }
                return;
            }
            paramOutputStream.write(arrayOfByte, 0, j);
            int i = paramInt + 1;
            if ((TEST_IO_EXCEPTION) && (i > 2)) {
                debug("simulating internet error");
                throw new IOException();
            }
            paramInt = i;
            if (paramProgress != null) {
                paramProgress.increment(j);
                paramInt = i;
            }
        }
    }

    public static void debug(Object paramObject) {
        if (debug) {
            Log.w("AQuery", paramObject);
        }
    }

    public static void debug(Object paramObject1, Object paramObject2) {
        if (debug) {
            Log.w("AQuery", paramObject1 + ":" + paramObject2);
        }
    }

    public static void debug(Throwable paramThrowable) {
        if (debug) {
            Log.w("AQuery", Log.getStackTraceString(paramThrowable));
        }
    }

    public static void debugNotify() {
        if ((!debug) || (wait == null)) {
            return;
        }
        synchronized (wait) {
            wait.notifyAll();
            return;
        }
    }

    public static void debugWait(long paramLong) {
        if (!debug) {
            return;
        }
        if (wait == null) {
            wait = new Object();
        }
        try {
            synchronized (wait) {
                wait.wait(paramLong);
                return;
            }
        } catch (InterruptedException localInterruptedException) {
            for (; ; ) {
                localInterruptedException.printStackTrace();
            }
        }
    }

    public static int dip2pixel(Context paramContext, float paramFloat) {
        return (int) TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
    }

    public static char[] encode64(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        int n = (paramInt2 * 4 + 2) / 3;
        char[] arrayOfChar = new char[(paramInt2 + 2) / 3 * 4];
        int i1 = paramInt1 + paramInt2;
        paramInt2 = 0;
        if (paramInt1 >= i1) {
            return arrayOfChar;
        }
        int j = paramInt1 + 1;
        int i2 = paramArrayOfByte[paramInt1] & 0xFF;
        label72:
        int k;
        if (j < i1) {
            paramInt1 = j + 1;
            j = paramArrayOfByte[j] & 0xFF;
            if (paramInt1 >= i1) {
                break label215;
            }
            k = paramInt1 + 1;
            int m = paramArrayOfByte[paramInt1] & 0xFF;
            paramInt1 = k;
            k = m;
            label99:
            m = paramInt2 + 1;
            arrayOfChar[paramInt2] = map1[(i2 >>> 2)];
            paramInt2 = m + 1;
            arrayOfChar[m] = map1[((i2 & 0x3) << 4 | j >>> 4)];
            if (paramInt2 >= n) {
                break label221;
            }
            i = map1[((j & 0xF) << 2 | k >>> 6)];
            label165:
            arrayOfChar[paramInt2] = i;
            paramInt2 += 1;
            if (paramInt2 >= n) {
                break label227;
            }
        }
        label215:
        label221:
        label227:
        for (int i = map1[(k & 0x3F)]; ; i = 61) {
            arrayOfChar[paramInt2] = i;
            paramInt2 += 1;
            break;
            k = 0;
            paramInt1 = j;
            j = k;
            break label72;
            k = 0;
            break label99;
            i = 61;
            break label165;
        }
    }

    public static void ensureUIThread() {
        if (!isUIThread()) {
            report(new IllegalStateException("Not UI Thread"));
        }
    }

    public static File getCacheDir(Context paramContext) {
        if (cacheDir == null) {
            cacheDir = new File(paramContext.getCacheDir(), "aquery");
            cacheDir.mkdirs();
        }
        return cacheDir;
    }

    public static File getCacheDir(Context paramContext, int paramInt) {
        if (paramInt == 1) {
            if (pcacheDir != null) {
                return pcacheDir;
            }
            pcacheDir = new File(getCacheDir(paramContext), "persistent");
            pcacheDir.mkdirs();
            return pcacheDir;
        }
        return getCacheDir(paramContext);
    }

    public static File getCacheFile(File paramFile, String paramString) {
        if (paramString == null) {
            return null;
        }
        if (paramString.startsWith(File.separator)) {
            return new File(paramString);
        }
        return makeCacheFile(paramFile, getCacheFileName(paramString));
    }

    private static String getCacheFileName(String paramString) {
        return getMD5Hex(paramString);
    }

    public static Context getContext() {
        if (context == null) {
            warn("warn", "getContext with null");
            debug(new IllegalStateException());
        }
        return context;
    }

    public static File getExistedCacheByUrl(File paramFile, String paramString) {
        paramString = getCacheFile(paramFile, paramString);
        if ((paramString != null) && (paramString.exists())) {
            paramFile = paramString;
            if (paramString.length() != 0L) {
            }
        } else {
            paramFile = null;
        }
        return paramFile;
    }

    public static File getExistedCacheByUrlSetAccess(File paramFile, String paramString) {
        paramFile = getExistedCacheByUrl(paramFile, paramString);
        if (paramFile != null) {
            lastAccess(paramFile);
        }
        return paramFile;
    }

    private static ScheduledExecutorService getFileStoreExecutor() {
        if (storeExe == null) {
            storeExe = Executors.newSingleThreadScheduledExecutor();
        }
        return storeExe;
    }

    public static Handler getHandler() {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        return handler;
    }

    private static byte[] getMD5(byte[] paramArrayOfByte) {
        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
            localMessageDigest.update(paramArrayOfByte);
            paramArrayOfByte = localMessageDigest.digest();
            return paramArrayOfByte;
        } catch (NoSuchAlgorithmException paramArrayOfByte) {
            report(paramArrayOfByte);
        }
        return null;
    }

    private static String getMD5Hex(String paramString) {
        return new BigInteger(getMD5(paramString.getBytes())).abs().toString(36);
    }

    public static File getTempDir() {
        File localFile2 = new File(Environment.getExternalStorageDirectory(), "aquery/temp");
        localFile2.mkdirs();
        File localFile1;
        if (localFile2.exists()) {
            localFile1 = localFile2;
            if (localFile2.canWrite()) {
            }
        } else {
            localFile1 = null;
        }
        return localFile1;
    }

    public static Object invokeHandler(Object paramObject, String paramString, boolean paramBoolean1, boolean paramBoolean2, Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2, Object... paramVarArgs) {
        try {
            paramObject = invokeMethod(paramObject, paramString, paramBoolean1, paramArrayOfClass1, paramArrayOfClass2, paramVarArgs);
            return paramObject;
        } catch (Exception paramObject) {
            if (!paramBoolean2) {
                break label26;
            }
        }
        report((Throwable) paramObject);
        for (; ; ) {
            return null;
            label26:
            debug((Throwable) paramObject);
        }
    }

    public static Object invokeHandler(Object paramObject, String paramString, boolean paramBoolean1, boolean paramBoolean2, Class<?>[] paramArrayOfClass, Object... paramVarArgs) {
        return invokeHandler(paramObject, paramString, paramBoolean1, paramBoolean2, paramArrayOfClass, null, paramVarArgs);
    }

    private static Object invokeMethod(Object paramObject, String paramString, boolean paramBoolean, Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2, Object... paramVarArgs)
            throws Exception {
        if ((paramObject == null) || (paramString == null)) {
        }
        do {
            return null;
            Object localObject = paramArrayOfClass1;
            if (paramArrayOfClass1 == null) {
            }
            try {
                localObject = new Class[0];
                paramArrayOfClass1 = paramObject.getClass().getMethod(paramString, (Class[]) localObject).invoke(paramObject, paramVarArgs);
                return paramArrayOfClass1;
            } catch (NoSuchMethodException paramArrayOfClass1) {
            }
        } while (!paramBoolean);
        if (paramArrayOfClass2 == null) {
        }
        try {
            return paramObject.getClass().getMethod(paramString, new Class[0]).invoke(paramObject, new Object[0]);
        } catch (NoSuchMethodException paramObject) {
        }
        paramObject = paramObject.getClass().getMethod(paramString, paramArrayOfClass2).invoke(paramObject, paramVarArgs);
        return paramObject;
        return null;
    }

    public static boolean isDebug() {
        return debug;
    }

    public static boolean isUIThread() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }

    private static void lastAccess(File paramFile) {
        paramFile.setLastModified(System.currentTimeMillis());
    }

    private static File makeCacheFile(File paramFile, String paramString) {
        return new File(paramFile, paramString);
    }

    public static float pixel2dip(Context paramContext, float paramFloat) {
        return paramFloat / (paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F);
    }

    public static void post(Object paramObject, String paramString) {
        post(paramObject, paramString, new Class[0], new Object[0]);
    }

    public static void post(Object paramObject, final String paramString, final Class<?>[] paramArrayOfClass, final Object... paramVarArgs) {
        post(new Runnable() {
            public void run() {
                AQUtility.invokeHandler(AQUtility.this, paramString, false, true, paramArrayOfClass, paramVarArgs);
            }
        });
    }

    public static void post(Runnable paramRunnable) {
        getHandler().post(paramRunnable);
    }

    public static void postAsync(Object paramObject, String paramString) {
        postAsync(paramObject, paramString, new Class[0], new Object[0]);
    }

    public static void postAsync(Object paramObject, final String paramString, final Class<?>[] paramArrayOfClass, final Object... paramVarArgs) {
        postAsync(new Runnable() {
            public void run() {
                AQUtility.invokeHandler(AQUtility.this, paramString, false, true, paramArrayOfClass, paramVarArgs);
            }
        });
    }

    public static void postAsync(Runnable paramRunnable) {
        new AsyncTask() {
            protected String doInBackground(Void... paramAnonymousVarArgs) {
                try {
                    AQUtility.this.run();
                    return null;
                } catch (Exception paramAnonymousVarArgs) {
                    for (; ; ) {
                        AQUtility.report(paramAnonymousVarArgs);
                    }
                }
            }
        }.execute(new Void[0]);
    }

    public static void postDelayed(Runnable paramRunnable, long paramLong) {
        getHandler().postDelayed(paramRunnable, paramLong);
    }

    public static void removePost(Runnable paramRunnable) {
        getHandler().removeCallbacks(paramRunnable);
    }

    public static void report(Throwable paramThrowable) {
        if (paramThrowable == null) {
        }
        for (; ; ) {
            return;
            try {
                warn("reporting", Log.getStackTraceString(paramThrowable));
                if (eh != null) {
                    eh.uncaughtException(Thread.currentThread(), paramThrowable);
                    return;
                }
            } catch (Exception paramThrowable) {
                paramThrowable.printStackTrace();
            }
        }
    }

    private static void setAlpha(View paramView, float paramFloat) {
        if (paramFloat == 1.0F) {
            paramView.clearAnimation();
            return;
        }
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
        localAlphaAnimation.setDuration(0L);
        localAlphaAnimation.setFillAfter(true);
        paramView.startAnimation(localAlphaAnimation);
    }

    public static void setCacheDir(File paramFile) {
        cacheDir = paramFile;
        if (cacheDir != null) {
            cacheDir.mkdirs();
        }
    }

    public static void setContext(Application paramApplication) {
        context = paramApplication.getApplicationContext();
    }

    public static void setDebug(boolean paramBoolean) {
        debug = paramBoolean;
    }

    public static void setExceptionHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {
        eh = paramUncaughtExceptionHandler;
    }

    public static void store(File paramFile, byte[] paramArrayOfByte) {
        if (paramFile != null) {
        }
        try {
            write(paramFile, paramArrayOfByte);
            return;
        } catch (Exception paramFile) {
            report(paramFile);
        }
    }

    public static void storeAsync(File paramFile, byte[] paramArrayOfByte, long paramLong) {
        getFileStoreExecutor().schedule(new Common().method(1, new Object[]{paramFile, paramArrayOfByte}), paramLong, TimeUnit.MILLISECONDS);
    }

    private static boolean testCleanNeeded(File[] paramArrayOfFile, long paramLong) {
        long l = 0L;
        int j = paramArrayOfFile.length;
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                return false;
            }
            l += paramArrayOfFile[i].length();
            if (l > paramLong) {
                return true;
            }
            i += 1;
        }
    }

    public static void time(String paramString) {
        times.put(paramString, Long.valueOf(System.currentTimeMillis()));
    }

    public static long timeEnd(String paramString, long paramLong) {
        Long localLong = (Long) times.get(paramString);
        long l1;
        if (localLong == null) {
            l1 = 0L;
        }
        long l2;
        do {
            return l1;
            l2 = System.currentTimeMillis() - localLong.longValue();
            if (paramLong == 0L) {
                break;
            }
            l1 = l2;
        } while (l2 <= paramLong);
        debug(paramString, Long.valueOf(l2));
        return l2;
    }

    public static byte[] toBytes(InputStream paramInputStream) {
        Object localObject1 = null;
        Object localObject2 = new ByteArrayOutputStream();
        try {
            copy(paramInputStream, (OutputStream) localObject2);
            localObject2 = ((ByteArrayOutputStream) localObject2).toByteArray();
            localObject1 = localObject2;
        } catch (IOException localIOException) {
            for (; ; ) {
                report(localIOException);
            }
        }
        close(paramInputStream);
        return (byte[]) localObject1;
    }

    public static void transparent(View paramView, boolean paramBoolean) {
        float f = 1.0F;
        if (paramBoolean) {
            f = 0.5F;
        }
        setAlpha(paramView, f);
    }

    public static void warn(Object paramObject1, Object paramObject2) {
        Log.w("AQuery", paramObject1 + ":" + paramObject2);
    }

    public static void write(File paramFile, byte[] paramArrayOfByte) {
        try {
            boolean bool = paramFile.exists();
            if (!bool) {
            }
            try {
                paramFile.createNewFile();
                paramFile = new FileOutputStream(paramFile);
                paramFile.write(paramArrayOfByte);
                paramFile.close();
                return;
            } catch (Exception localException) {
                for (; ; ) {
                    debug("file create fail", paramFile);
                    report(localException);
                }
            }
            return;
        } catch (Exception paramFile) {
            report(paramFile);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/util/AQUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */