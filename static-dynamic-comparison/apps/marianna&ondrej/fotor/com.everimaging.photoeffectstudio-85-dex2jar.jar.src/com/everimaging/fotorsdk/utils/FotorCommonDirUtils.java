package com.everimaging.fotorsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

import java.io.File;

public class FotorCommonDirUtils {
    private static final String TAG = FotorCommonDirUtils.class.getSimpleName();
    private static String downloadPath;
    private static final FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);
    private static String temporaryPath;
    private static String workspacePath;

    private static void cleanDirectory(File paramFile) {
        int i = 0;
        logger.c(new Object[]{"clean temporary directory"});
        String[] arrayOfString = paramFile.list();
        if (arrayOfString != null) {
            if (i < arrayOfString.length) {
                File localFile = new File(paramFile, arrayOfString[i]);
                if (localFile.isDirectory()) {
                    cleanDirectory(localFile);
                }
                for (; ; ) {
                    i += 1;
                    break;
                    localFile.delete();
                }
            }
        }
    }

    public static void cleanTemporaryDir() {
        if (!TextUtils.isEmpty(temporaryPath)) {
            cleanDirectory(new File(temporaryPath));
        }
    }

    public static String getDownloadBorderPath() {
        return new File(downloadPath, "Border").getAbsolutePath();
    }

    public static String getDownloadCollageClassicPath() {
        return new File(downloadPath, "Collage_Classic").getAbsolutePath();
    }

    public static String getDownloadCollageMagazinePath() {
        return new File(downloadPath, "Collage_Magazine").getAbsolutePath();
    }

    public static String getDownloadCollagePatternPath() {
        return new File(downloadPath, "Collage_Pattern").getAbsolutePath();
    }

    public static String getDownloadEffectPath() {
        return new File(downloadPath, "Effect").getAbsolutePath();
    }

    public static String getDownloadFontPath() {
        return new File(downloadPath, "Font").getAbsolutePath();
    }

    public static String getDownloadPath() {
        return downloadPath;
    }

    public static String getDownloadStickerPath() {
        return new File(downloadPath, "Sticker").getAbsolutePath();
    }

    public static String getTemporaryPath() {
        return temporaryPath;
    }

    public static String getWorkspacePath() {
        return workspacePath;
    }

    public static void init(Context paramContext) {
        File localFile1;
        File localFile2;
        if (TextUtils.isEmpty(workspacePath)) {
            localFile1 = new File(paramContext.getExternalCacheDir(), "FotorSDK_WS");
            if (!localFile1.exists()) {
                localFile1.mkdirs();
            }
            localFile2 = new File(localFile1, "temporary");
            if (localFile2.exists()) {
                break label109;
            }
            localFile2.mkdirs();
        }
        for (; ; ) {
            paramContext = new File(paramContext.getFilesDir(), "download_pack");
            if (!paramContext.exists()) {
                paramContext.mkdirs();
            }
            workspacePath = localFile1.getAbsolutePath();
            temporaryPath = localFile2.getAbsolutePath();
            downloadPath = paramContext.getAbsolutePath();
            cleanTemporaryDir();
            return;
            label109:
            cleanDirectory(localFile2);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/FotorCommonDirUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */