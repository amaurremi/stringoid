package com.everimaging.fotorsdk.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class TypefaceUtils {
    private static final boolean DEBUG = false;
    private static final String PREFIX_PATH = "fonts_res";
    private static final String[] SUBFIX_STRINGS = {".ttf", ".ttc", ".otf"};
    public static final String SYSTEM_MONOSPACE = "Monospace";
    public static final String SYSTEM_SANS_SERIF = "Sans Serif";
    public static final String SYSTEM_SERIF = "Serif";
    private static final String TAG = TypefaceUtils.class.getSimpleName();
    private static final FotorLoggerFactory.c logger = FotorLoggerFactory.a(TAG, FotorLoggerFactory.LoggerType.CONSOLE);
    private static final HashMap<String, SoftReference<Typeface>> sTypeCache = new HashMap();

    public static Typeface createFromAsset(AssetManager paramAssetManager, String paramString1, String paramString2) {
        Object localObject = null;
        new StringBuilder().append(paramString1).append(paramString2).toString();
        String str;
        if (TextUtils.isEmpty(paramString1)) {
            str = paramString2;
        }
        for (; ; ) {
            paramString1 = getFromCache(paramString2);
            if ((paramString1 == null) || (paramString1.get() == null)) {
                break;
            }
            return (Typeface) paramString1.get();
            if (paramString1.endsWith("/")) {
                str = paramString1 + paramString2;
            } else {
                str = paramString1 + "/" + paramString2;
            }
        }
        if (paramAssetManager == null) {
            return null;
        }
        if (paramString2.split("\\.").length > 1) {
        }
        try {
            paramAssetManager.open(str);
            paramString1 = Typeface.createFromAsset(paramAssetManager, str);
            if ((paramString1 == null) && (!str.startsWith("fonts_res"))) {
                logger.d(new Object[]{"load typeface error,"});
                paramAssetManager = createFromAsset(paramAssetManager, "fonts_res", paramString2);
                paramString1 = paramAssetManager;
                if (paramAssetManager == null) {
                    paramString1 = Typeface.DEFAULT;
                }
                putIntoCache(paramString2, paramString1);
                return paramString1;
                String[] arrayOfString = SUBFIX_STRINGS;
                int j = arrayOfString.length;
                int i = 0;
                for (; ; ) {
                    paramString1 = (String) localObject;
                    if (i >= j) {
                        break;
                    }
                    paramString1 = arrayOfString[i];
                    try {
                        paramString1 = str + paramString1;
                        paramAssetManager.open(paramString1);
                        paramString1 = Typeface.createFromAsset(paramAssetManager, paramString1);
                    } catch (IOException paramString1) {
                        Log.e(TAG, "create font error:" + paramString1.getMessage());
                        i += 1;
                    }
                }
            }
        } catch (IOException paramString1) {
            for (; ; ) {
                paramString1 = (String) localObject;
                continue;
                paramAssetManager = paramString1;
            }
        }
    }

    public static Typeface createFromAssetPath(Context paramContext, String paramString) {
        if (paramString.equals("Monospace")) {
            return Typeface.MONOSPACE;
        }
        if (paramString.equals("Sans Serif")) {
            return Typeface.SANS_SERIF;
        }
        if (paramString.equals("Serif")) {
            return Typeface.SERIF;
        }
        try {
            str1 = paramString.substring(0, paramString.lastIndexOf("/"));
            String str3 = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length());
            paramString = str3;
        } catch (Exception localException) {
            for (; ; ) {
                String str1;
                String str2 = "";
            }
        }
        return createFromAsset(paramContext.getAssets(), str1, paramString);
    }

    public static Typeface createFromLocalPath(String paramString1, String paramString2) {
        new StringBuilder().append(paramString1).append(paramString2).toString();
        if (paramString1.endsWith(File.separator)) {
        }
        Object localObject;
        for (paramString1 = paramString1 + paramString2; ; paramString1 = paramString1 + File.separator + paramString2) {
            localObject = getFromCache(paramString2);
            if ((localObject == null) || (((SoftReference) localObject).get() == null)) {
                break;
            }
            return (Typeface) ((SoftReference) localObject).get();
        }
        if (paramString2.split("\\.").length > 1) {
        }
        label193:
        for (paramString1 = Typeface.createFromFile(paramString1); ; paramString1 = null) {
            putIntoCache(paramString2, paramString1);
            return paramString1;
            String[] arrayOfString = SUBFIX_STRINGS;
            int j = arrayOfString.length;
            int i = 0;
            for (; ; ) {
                if (i >= j) {
                    break label193;
                }
                localObject = arrayOfString[i];
                try {
                    localObject = Typeface.createFromFile(paramString1 + (String) localObject);
                    paramString1 = (String) localObject;
                } catch (Exception localException) {
                    localException.printStackTrace();
                    i += 1;
                }
            }
        }
    }

    private static SoftReference<Typeface> getFromCache(String paramString) {
        synchronized (sTypeCache) {
            paramString = (SoftReference) sTypeCache.get(paramString);
            return paramString;
        }
    }

    private static void putIntoCache(String paramString, Typeface paramTypeface) {
        synchronized (sTypeCache) {
            sTypeCache.put(paramString, new SoftReference(paramTypeface));
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/TypefaceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */