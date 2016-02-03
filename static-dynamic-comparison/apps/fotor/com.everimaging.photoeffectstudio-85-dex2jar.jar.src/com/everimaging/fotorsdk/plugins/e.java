package com.everimaging.fotorsdk.plugins;

import android.content.Context;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

import java.io.IOException;
import java.io.InputStream;

public class e
        extends g
        implements h.a {
    private static final String d = e.class.getSimpleName();
    private static final FotorLoggerFactory.c e = FotorLoggerFactory.a(d, FotorLoggerFactory.LoggerType.CONSOLE);

    public e(Context paramContext, FeatureInternalPack paramFeatureInternalPack) {
        super(paramContext, paramFeatureInternalPack);
    }

    public InputStream a(String paramString) {
        try {
            paramString = c(paramString);
            return paramString;
        } catch (IOException paramString) {
            paramString.printStackTrace();
        }
        return null;
    }

    public String a_() {
        return "";
    }

    public InputStream b() {
        try {
            InputStream localInputStream = c("config.json");
            return localInputStream;
        } catch (IOException localIOException) {
            localIOException.printStackTrace();
        }
        return null;
    }

    public InputStream b(String paramString) {
        try {
            paramString = c(paramString);
            return paramString;
        } catch (IOException paramString) {
            paramString.printStackTrace();
        }
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/plugins/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */