package com.everimaging.fotorsdk.plugins;

import android.content.Context;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;

import java.io.InputStream;

public class h {
    private static final String a = h.class.getSimpleName();
    private static final FotorLoggerFactory.c b = FotorLoggerFactory.a(a, FotorLoggerFactory.LoggerType.CONSOLE);

    public static b a(Context paramContext, FeaturePack paramFeaturePack) {
        b.c(new Object[]{"create plugin:" + paramFeaturePack});
        if ((paramFeaturePack instanceof FeatureInternalPack)) {
            if ((paramFeaturePack instanceof FeatureBindPack)) {
                return new g.a(paramContext, (FeatureBindPack) paramFeaturePack);
            }
            if ((paramFeaturePack instanceof FeatureDownloadedPack)) {
                return new c(paramContext, (FeatureDownloadedPack) paramFeaturePack);
            }
            if ((paramFeaturePack instanceof FeaturePurchasedPack)) {
                return new i(paramContext, (FeaturePurchasedPack) paramFeaturePack);
            }
            FeatureInternalPack localFeatureInternalPack = (FeatureInternalPack) paramFeaturePack;
            if (paramFeaturePack.getPluginType() == 2) {
                return new f(paramContext, localFeatureInternalPack);
            }
            if (paramFeaturePack.getPluginType() == 4) {
                return new a(paramContext, localFeatureInternalPack);
            }
            if (paramFeaturePack.getPluginType() == 3) {
                return new j(paramContext, localFeatureInternalPack);
            }
            if (paramFeaturePack.getPluginType() == 6) {
                return new e(paramContext, localFeatureInternalPack);
            }
        } else if ((paramFeaturePack instanceof FeatureExternalPack)) {
            return new d(paramContext, (FeatureExternalPack) paramFeaturePack);
        }
        return null;
    }

    public static abstract interface a {
        public abstract InputStream a(String paramString);

        public abstract InputStream b();

        public abstract InputStream b(String paramString);
    }

    public static abstract interface b {
        public abstract String a();

        public abstract CharSequence b_();

        public abstract String g();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/plugins/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */