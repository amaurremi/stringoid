package com.everimaging.fotorsdk.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StorageManager {
    private static final String EXTERNAL_STORAGE_PATH = Environment.getExternalStorageDirectory().getPath();
    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String INDIVIDUAL_DIR_NAME = "uil-images";
    private static final String TAG = StorageManager.class.getSimpleName();
    private static final FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);

    private static List<String> compareMountsWithVold(List<String> paramList1, List<String> paramList2) {
        int i = paramList1.size() - 1;
        if (i >= 0) {
            String str = (String) paramList1.get(i);
            File localFile = new File(str);
            if ((!localFile.exists()) || (!localFile.isDirectory()) || (!localFile.canWrite())) {
                paramList1.remove(i);
            }
            for (; ; ) {
                i -= 1;
                break;
                if ((paramList2 != null) && (!paramList2.contains(str))) {
                    paramList1.remove(i);
                }
            }
        }
        if (paramList2 != null) {
            paramList2.clear();
        }
        return paramList1;
    }

    public static final long getAvailMemory(Context paramContext) {
        paramContext = (ActivityManager) paramContext.getSystemService("activity");
        ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
        paramContext.getMemoryInfo(localMemoryInfo);
        return localMemoryInfo.availMem;
    }

    public static File getCacheDirectory(Context paramContext) {
        return getCacheDirectory(paramContext, true);
    }

    public static File getCacheDirectory(Context paramContext, boolean paramBoolean) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramBoolean) {
            localObject1 = localObject2;
            if ("mounted".equals(Environment.getExternalStorageState())) {
                localObject1 = localObject2;
                if (hasExternalStoragePermission(paramContext)) {
                    localObject1 = getExternalCacheDir(paramContext);
                }
            }
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
            localObject2 = paramContext.getCacheDir();
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
            paramContext = "/data/data/" + paramContext.getPackageName() + "/cache/";
            logger.d(new Object[]{"Can't define system cache directory! '%s' will be used.", paramContext});
            localObject1 = new File(paramContext);
        }
        return (File) localObject1;
    }

    private static File getExternalCacheDir(Context paramContext) {
        File localFile = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), paramContext.getPackageName()), "cache");
        paramContext = localFile;
        if (!localFile.exists()) {
            if (!localFile.mkdirs()) {
                logger.d(new Object[]{"Unable to create external cache directory"});
                paramContext = null;
            }
        } else {
            return paramContext;
        }
        try {
            new File(localFile, ".nomedia").createNewFile();
            return localFile;
        } catch (IOException paramContext) {
            logger.f(new Object[]{"Can't create \".nomedia\" file in application external cache directory"});
        }
        return localFile;
    }

    public static File getIndividualCacheDirectory(Context paramContext) {
        paramContext = getCacheDirectory(paramContext);
        File localFile = new File(paramContext, "uil-images");
        if ((!localFile.exists()) && (!localFile.mkdir())) {
            return paramContext;
        }
        return localFile;
    }

    public static File getOwnCacheDirectory(Context paramContext, String paramString) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            localObject1 = localObject2;
            if (hasExternalStoragePermission(paramContext)) {
                localObject1 = new File(Environment.getExternalStorageDirectory(), paramString);
            }
        }
        if (localObject1 != null) {
            paramString = (String) localObject1;
            if (!((File) localObject1).exists()) {
                paramString = (String) localObject1;
                if (((File) localObject1).mkdirs()) {
                }
            }
        } else {
            paramString = paramContext.getCacheDir();
        }
        return paramString;
    }

    public static List<String> getSDVolumns() {
        return compareMountsWithVold(readMountsFile(), readVoldFile());
    }

    /* Error */
    public static final long getTotalMemory() {
        // Byte code:
        //   0: new 215	java/io/BufferedReader
        //   3: dup
        //   4: new 217	java/io/FileReader
        //   7: dup
        //   8: ldc -37
        //   10: invokespecial 220	java/io/FileReader:<init>	(Ljava/lang/String;)V
        //   13: sipush 8192
        //   16: invokespecial 223	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
        //   19: astore_3
        //   20: aload_3
        //   21: invokevirtual 226	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   24: ldc -28
        //   26: invokevirtual 232	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
        //   29: iconst_1
        //   30: aaload
        //   31: invokestatic 238	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
        //   34: invokevirtual 241	java/lang/Integer:intValue	()I
        //   37: istore_0
        //   38: iload_0
        //   39: sipush 1024
        //   42: imul
        //   43: i2l
        //   44: lstore_1
        //   45: aload_3
        //   46: invokevirtual 244	java/io/BufferedReader:close	()V
        //   49: lload_1
        //   50: lreturn
        //   51: astore_3
        //   52: lconst_0
        //   53: lstore_1
        //   54: aload_3
        //   55: invokevirtual 247	java/io/IOException:printStackTrace	()V
        //   58: lload_1
        //   59: lreturn
        //   60: astore_3
        //   61: goto -7 -> 54
        // Local variable table:
        //   start	length	slot	name	signature
        //   37	6	0	i	int
        //   44	15	1	l	long
        //   19	27	3	localBufferedReader	java.io.BufferedReader
        //   51	4	3	localIOException1	IOException
        //   60	1	3	localIOException2	IOException
        // Exception table:
        //   from	to	target	type
        //   0	38	51	java/io/IOException
        //   45	49	60	java/io/IOException
    }

    private static boolean hasExternalStoragePermission(Context paramContext) {
        return paramContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    private static List<String> readMountsFile() {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        localArrayList1.add(EXTERNAL_STORAGE_PATH);
        for (; ; ) {
            String str;
            Object localObject;
            try {
                Scanner localScanner = new Scanner(new File("/proc/mounts"));
                if (localScanner.hasNext()) {
                    str = localScanner.nextLine();
                    if ((!str.startsWith("/dev/block/vold/")) && (!str.startsWith("/dev/block//vold/"))) {
                        continue;
                    }
                    localObject = str.split(" ");
                    str = localObject[0];
                    localObject = localObject[1];
                    if (((String) localObject).equals(EXTERNAL_STORAGE_PATH)) {
                        if (localArrayList2.contains(str)) {
                            continue;
                        }
                        localArrayList2.add(str);
                    }
                } else {
                    return localArrayList1;
                }
            } catch (Exception localException) {
                localException.printStackTrace();
            }
            if (!localException.contains(str)) {
                localException.add(str);
                localArrayList1.add(localObject);
            }
        }
    }

    private static List<String> readVoldFile() {
        try {
            Scanner localScanner1 = new Scanner(new File("/system/etc/vold.fstab"));
            localArrayList = new ArrayList();
            try {
                localArrayList.add(EXTERNAL_STORAGE_PATH);
                while (localScanner1.hasNext()) {
                    localObject1 = localScanner1.nextLine();
                    if (!TextUtils.isEmpty((CharSequence) localObject1)) {
                        localObject1 = ((String) localObject1).trim();
                        if (!((String) localObject1).startsWith("dev_mount")) {
                            break label167;
                        }
                        localObject1 = ((String) localObject1).split(" ");
                        if ((localObject1 != null) && (localObject1.length >= 3)) {
                            Object localObject2 = localObject1[2];
                            localObject1 = localObject2;
                            if (((String) localObject2).contains(":")) {
                                localObject1 = ((String) localObject2).substring(0, ((String) localObject2).indexOf(":"));
                            }
                            if (!((String) localObject1).equals(EXTERNAL_STORAGE_PATH)) {
                                localArrayList.add(localObject1);
                            }
                        }
                    }
                }
                return localArrayList;
            } catch (Exception localException1) {
            }
        } catch (FileNotFoundException localFileNotFoundException) {
            for (; ; ) {
                ArrayList localArrayList;
                Object localObject1;
                localFileNotFoundException.printStackTrace();
                Scanner localScanner2 = new Scanner(new File("/system/etc/vold.conf"));
                continue;
                label167:
                if (((String) localObject1).startsWith("mount_point")) {
                    localObject1 = ((String) localObject1).replaceAll("mount_point", "").trim();
                    if (!((String) localObject1).equals(EXTERNAL_STORAGE_PATH)) {
                        localArrayList.add(localObject1);
                    }
                }
            }
        } catch (Exception localException2) {
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/StorageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */