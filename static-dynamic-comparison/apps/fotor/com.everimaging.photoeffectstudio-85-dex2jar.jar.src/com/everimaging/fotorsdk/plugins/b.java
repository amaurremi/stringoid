package com.everimaging.fotorsdk.plugins;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class b
        extends g
        implements h.a {
    private FeatureBindPack d;

    public b(Context paramContext, FeatureBindPack paramFeatureBindPack) {
        super(paramContext, paramFeatureBindPack);
        this.d = paramFeatureBindPack;
    }

    private String k() {
        return "collage_effect_config";
    }

    private String l() {
        return k() + File.separator + this.d.getPackName();
    }

    public InputStream a(String paramString) {
        paramString = k() + File.separator + this.d.getPackName() + File.separator + paramString;
        try {
            paramString = this.c.getAssets().open(paramString);
            return paramString;
        } catch (IOException paramString) {
            paramString.printStackTrace();
        }
        return null;
    }

    public String a_() {
        return null;
    }

    public InputStream b() {
        Object localObject = k() + File.separator + this.d.getPackName() + File.separator + "config.json";
        try {
            localObject = this.c.getAssets().open((String) localObject);
            return (InputStream) localObject;
        } catch (IOException localIOException) {
            localIOException.printStackTrace();
        }
        return null;
    }

    public InputStream b(String paramString) {
        try {
            paramString = l() + File.separator + paramString;
            paramString = this.c.getAssets().open(paramString);
            return paramString;
        } catch (IOException paramString) {
            paramString.printStackTrace();
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/plugins/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */