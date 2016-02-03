package com.everimaging.fotorsdk.uil.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

public final class d {
    public static File a(Context paramContext) {
        return a(paramContext, true);
    }

    public static File a(Context paramContext, boolean paramBoolean) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramBoolean) {
            localObject1 = localObject2;
            if ("mounted".equals(Environment.getExternalStorageState())) {
                localObject1 = localObject2;
                if (d(paramContext)) {
                    localObject1 = c(paramContext);
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
            c.c("Can't define system cache directory! '%s' will be used.", new Object[]{paramContext});
            localObject1 = new File(paramContext);
        }
        return (File) localObject1;
    }

    public static File b(Context paramContext) {
        paramContext = a(paramContext);
        File localFile = new File(paramContext, "uil-images");
        if ((!localFile.exists()) && (!localFile.mkdir())) {
            return paramContext;
        }
        return localFile;
    }

    private static File c(Context paramContext) {
        File localFile = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), paramContext.getPackageName()), "cache");
        paramContext = localFile;
        if (!localFile.exists()) {
            if (!localFile.mkdirs()) {
                c.c("Unable to create external cache directory", new Object[0]);
                paramContext = null;
            }
        } else {
            return paramContext;
        }
        try {
            new File(localFile, ".nomedia").createNewFile();
            return localFile;
        } catch (IOException paramContext) {
            c.b("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
        }
        return localFile;
    }

    private static boolean d(Context paramContext) {
        return paramContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */