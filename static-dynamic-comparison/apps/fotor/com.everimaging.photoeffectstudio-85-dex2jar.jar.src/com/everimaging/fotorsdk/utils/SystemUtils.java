package com.everimaging.fotorsdk.utils;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SystemUtils {
    public static final String BogoMIPS = "BogoMIPS";
    public static final String CPU_ARCHITECTURE = "CPU architecture";
    public static final String CPU_IMPLEMENTER = "CPU implementer";
    public static final String CPU_PART = "CPU part";
    public static final String CPU_REVISION = "CPU revision";
    public static final String CPU_VARIANT = "CPU variant";
    public static final String FEATURES = "Features";
    public static final String HARDWARE = "Hardware";
    public static final String PROCESSOR = "Processor";
    public static final String REVISION = "Revision";
    public static final String SERIAL = "Serial";
    private static final String TAG = SystemUtils.class.getSimpleName();
    private static final FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);
    private static int mCpuKiloHz = 0;
    private static double mMaxMemory = -1.0D;
    private static HashMap<String, String> mValues;

    public static double getApplicationTotalMemory() {
        if (mMaxMemory < 0.0D) {
            double[] arrayOfDouble = new double[3];
            getRuntimeMemoryInfo(arrayOfDouble);
            mMaxMemory = arrayOfDouble[2];
        }
        return mMaxMemory;
    }

    @SuppressLint({"NewApi"})
    public static long getAvailableExternalMemorySize() {
        StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            l = localStatFs.getBlockSizeLong();
            return localStatFs.getAvailableBlocksLong() * l;
        }
        long l = localStatFs.getBlockSize();
        return localStatFs.getAvailableBlocks() * l;
    }

    public static long getAvailableInternalMemorySize() {
        StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
        long l = localStatFs.getBlockSize();
        return localStatFs.getAvailableBlocks() * l;
    }

    public static int getCpuArchitecture() {
        int i = -1;
        if (mValues == null) {
            init();
        }
        String str = getValue("CPU architecture");
        if (str != null) {
        }
        try {
            i = Integer.parseInt(str);
            return i;
        } catch (NumberFormatException localNumberFormatException) {
        }
        return -1;
    }

    public static int getCpuFrequencyMax()
            throws Exception {
        if (mCpuKiloHz == 0) {
            mCpuKiloHz = FotorIOUtils.readSystemFileAsInt("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
        }
        return mCpuKiloHz;
    }

    public static int getCpuMhz() {
        int i = 0;
        try {
            int j = getCpuFrequencyMax();
            if (j > 0) {
                i = j / 1000;
            }
            return i;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return 0;
    }

    public static float getCpuSpeed() {
        float f = -1.0F;
        if (mValues == null) {
            init();
        }
        String str = getValue("BogoMIPS");
        if (str != null) {
        }
        try {
            double d = Double.parseDouble(str);
            f = (float) d;
            return f;
        } catch (NumberFormatException localNumberFormatException) {
        }
        return -1.0F;
    }

    public static void getRuntimeMemoryInfo(double[] paramArrayOfDouble) {
        double d1 = Double.valueOf(Runtime.getRuntime().totalMemory()).doubleValue() / 1048576.0D;
        double d2 = Double.valueOf(Runtime.getRuntime().maxMemory()).doubleValue() / 1048576.0D;
        paramArrayOfDouble[0] = (d2 - d1);
        paramArrayOfDouble[1] = d1;
        paramArrayOfDouble[2] = d2;
    }

    public static long getTotalInternalMemorySize() {
        StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
        long l = localStatFs.getBlockSize();
        return localStatFs.getBlockCount() * l;
    }

    private static String getValue(String paramString) {
        return (String) mValues.get(paramString);
    }

    public static boolean haveEnoughExternalStorage() {
        long l = getAvailableExternalMemorySize() / 1048576L;
        logger.c(new Object[]{"avaliableMB:" + l});
        return l > 10L;
    }

    private static void init() {
        mValues = new HashMap();
        InputStream localInputStream;
        try {
            Process localProcess = new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/cpuinfo"}).start();
            localInputStream = localProcess.getInputStream();
            BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
            for (; ; ) {
                String str = localBufferedReader.readLine();
                if (str == null) {
                    break;
                }
                parseLine(str);
            }
            localIOException.destroy();
        } catch (IOException localIOException) {
            localIOException.printStackTrace();
            return;
        }
        FotorIOUtils.closeSilently(localInputStream);
    }

    public static boolean isHoneyComb() {
        return (Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT < 14);
    }

    public static boolean isIceCreamSandwich() {
        return (Build.VERSION.SDK_INT >= 14) && (Build.VERSION.SDK_INT < 16);
    }

    public static boolean isJellyBean() {
        return (Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT < 18);
    }

    private static void parseLine(String paramString) {
        paramString = new StringTokenizer(paramString, ":");
        while (paramString.hasMoreTokens()) {
            String str1 = paramString.nextToken().trim();
            if (paramString.hasMoreTokens()) {
                String str2 = paramString.nextToken().trim();
                mValues.put(str1, str2);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/SystemUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */