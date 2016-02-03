package android.support.v4.content;

import android.content.Context;

import java.io.File;

class ContextCompatFroyo {
    public static File getExternalCacheDir(Context paramContext) {
        return paramContext.getExternalCacheDir();
    }

    public static File getExternalFilesDir(Context paramContext, String paramString) {
        return paramContext.getExternalFilesDir(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v4/content/ContextCompatFroyo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */