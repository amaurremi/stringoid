package com.everimaging.fotorsdk.plugins;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.DeviceUtils;
import com.everimaging.fotorsdk.utils.FotorIOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class c
        extends g
        implements h.a {
    private static final String d = c.class.getSimpleName();
    private static final FotorLoggerFactory.c e = FotorLoggerFactory.a(d, FotorLoggerFactory.LoggerType.CONSOLE);

    public c(Context paramContext, FeatureInternalPack paramFeatureInternalPack) {
        super(paramContext, paramFeatureInternalPack);
    }

    private InputStream d(String paramString) {
        String str = ((FeatureDownloadedPack) this.b).getPackFolderPath();
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        for (; ; ) {
            try {
                if (new File(str).exists()) {
                    paramString = new FileInputStream(str + paramString);
                    return paramString;
                }
            } catch (Exception paramString) {
                e.e(new Object[]{"open download pack item error : " + paramString.getMessage()});
                paramString.printStackTrace();
            }
            return null;
        }
    }

    public InputStream a(String paramString) {
        return d(paramString);
    }

    public String a_() {
        return ((FeatureDownloadedPack) this.b).getPackFolderPath();
    }

    public InputStream b() {
        return d("config.json");
    }

    public InputStream b(String paramString) {
        return d(paramString);
    }

    public Drawable c() {
        Object localObject2 = this.c.getResources();
        try {
            Object localObject1 = "pack_icon" + "_default.png";
            Object localObject3 = "pack_icon" + "_pressed.png";
            BitmapFactory.Options localOptions = new BitmapFactory.Options();
            localOptions.inDensity = 320;
            localOptions.inTargetDensity = DeviceUtils.getDensity();
            InputStream localInputStream = d((String) localObject1);
            localObject1 = Drawable.createFromResourceStream((Resources) localObject2, null, localInputStream, (String) localObject1, localOptions);
            FotorIOUtils.closeSilently(localInputStream);
            localInputStream = d((String) localObject3);
            localObject2 = Drawable.createFromResourceStream((Resources) localObject2, null, localInputStream, (String) localObject3, localOptions);
            FotorIOUtils.closeSilently(localInputStream);
            localObject3 = new StateListDrawable();
            ((StateListDrawable) localObject3).addState(new int[]{16842919}, (Drawable) localObject2);
            ((StateListDrawable) localObject3).addState(new int[]{16842913}, (Drawable) localObject2);
            ((StateListDrawable) localObject3).addState(new int[0], (Drawable) localObject1);
            return (Drawable) localObject3;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/plugins/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */