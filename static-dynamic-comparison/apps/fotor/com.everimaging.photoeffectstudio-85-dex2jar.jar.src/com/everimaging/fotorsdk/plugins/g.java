package com.everimaging.fotorsdk.plugins;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.everimaging.fotorsdk.log.FotorLoggerFactory;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.LoggerType;
import com.everimaging.fotorsdk.log.FotorLoggerFactory.c;
import com.everimaging.fotorsdk.utils.FotorIOUtils;
import com.everimaging.fotorsdk.utils.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public abstract class g
        implements h.b {
    protected String[] a;
    protected FeatureInternalPack b;
    protected Context c;
    private int d;
    private String e;
    private PackageManager f;
    private WeakReference<ApplicationInfo> g;
    private WeakReference<Resources> h;
    private HashMap<String, HashMap<String, Integer>> i = new HashMap();

    g(Context paramContext, FeatureInternalPack paramFeatureInternalPack) {
        this.e = paramFeatureInternalPack.getPackageName();
        this.d = paramFeatureInternalPack.getPackageVersionCode();
        this.f = paramContext.getPackageManager();
        this.b = paramFeatureInternalPack;
        this.c = paramContext;
    }

    private Drawable k() {
        ApplicationInfo localApplicationInfo = e();
        if (localApplicationInfo != null) {
            return localApplicationInfo.loadIcon(this.f);
        }
        return null;
    }

    protected final int a(Resources paramResources, String paramString1, String paramString2) {
        if (!this.i.containsKey(paramString2)) {
            this.i.put(paramString2, new HashMap());
        }
        HashMap localHashMap = (HashMap) this.i.get(paramString2);
        if (localHashMap.containsKey(paramString1)) {
            return ((Integer) localHashMap.get(paramString1)).intValue();
        }
        int j = paramResources.getIdentifier(paramString1, paramString2, this.e);
        localHashMap.put(paramString1, Integer.valueOf(j));
        return j;
    }

    protected final Drawable a(String paramString, boolean paramBoolean) {
        Resources localResources = f();
        if (localResources == null) {
            return k();
        }
        try {
            Object localObject1 = paramString + "_default.png";
            Object localObject2 = paramString + "_pressed.png";
            Object localObject3 = new BitmapFactory.Options();
            ((BitmapFactory.Options) localObject3).inDensity = 320;
            ((BitmapFactory.Options) localObject3).inTargetDensity = localResources.getDisplayMetrics().densityDpi;
            InputStream localInputStream = localResources.getAssets().open((String) localObject1);
            localObject1 = Drawable.createFromResourceStream(localResources, null, localInputStream, (String) localObject1, (BitmapFactory.Options) localObject3);
            FotorIOUtils.closeSilently(localInputStream);
            localInputStream = localResources.getAssets().open((String) localObject2);
            localObject2 = Drawable.createFromResourceStream(localResources, null, localInputStream, (String) localObject2, (BitmapFactory.Options) localObject3);
            FotorIOUtils.closeSilently(localInputStream);
            localObject3 = new StateListDrawable();
            ((StateListDrawable) localObject3).addState(new int[]{16842919}, (Drawable) localObject2);
            ((StateListDrawable) localObject3).addState(new int[]{16842913}, (Drawable) localObject2);
            ((StateListDrawable) localObject3).addState(new int[0], (Drawable) localObject1);
            return (Drawable) localObject3;
        } catch (Exception localException) {
            localException.printStackTrace();
            int j = a(localResources, paramString, "drawable");
            if (j != 0) {
                return this.f.getDrawable(this.e, j, e());
            }
            if (paramBoolean) {
                return k();
            }
        }
        return null;
    }

    protected final CharSequence a(String paramString, CharSequence paramCharSequence) {
        Resources localResources = f();
        if (localResources == null) {
            paramString = h();
        }
        do {
            return paramString;
            int j = a(localResources, paramString, "string");
            if (j != 0) {
                return this.f.getText(this.e, j, e());
            }
            paramString = paramCharSequence;
        } while (paramCharSequence != null);
        return h();
    }

    public String a() {
        return this.e;
    }

    public abstract String a_();

    public CharSequence b_() {
        return a("pack_name", null);
    }

    public Drawable c() {
        return a("pack_icon", false);
    }

    protected final InputStream c(String paramString)
            throws IOException {
        Resources localResources = f();
        if (localResources != null) {
            return localResources.getAssets().open(paramString);
        }
        return null;
    }

    public FeatureInternalPack d() {
        return this.b;
    }

    protected final ApplicationInfo e() {
        if ((this.g == null) || (this.g.get() == null)) {
        }
        try {
            this.g = new WeakReference(this.f.getApplicationInfo(this.e, 0));
            return (ApplicationInfo) this.g.get();
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            localNameNotFoundException.printStackTrace();
        }
        return null;
    }

    public final Resources f() {
        Resources localResources = null;
        ApplicationInfo localApplicationInfo;
        if ((this.h == null) || (this.h.get() == null)) {
            localApplicationInfo = e();
            if (localApplicationInfo == null) {
                break label60;
            }
        }
        try {
            localResources = this.f.getResourcesForApplication(localApplicationInfo);
            this.h = new WeakReference(localResources);
            localResources = (Resources) this.h.get();
            label60:
            return localResources;
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
        }
        return null;
    }

    protected void finalize()
            throws Throwable {
        j();
        super.finalize();
    }

    public String g() {
        return this.b.getPackID();
    }

    protected final CharSequence h() {
        ApplicationInfo localApplicationInfo = e();
        if (localApplicationInfo != null) {
            return localApplicationInfo.loadLabel(this.f);
        }
        return null;
    }

    public AssetManager i() {
        Resources localResources = f();
        if (localResources != null) {
            return localResources.getAssets();
        }
        return null;
    }

    public void j() {
        this.f = null;
        this.g = null;
        this.h = null;
        this.a = null;
        this.i.clear();
    }

    public static class a
            extends g
            implements h.a {
        private static final String d = a.class.getSimpleName();
        private static FotorLoggerFactory.c e = FotorLoggerFactory.a(d, FotorLoggerFactory.LoggerType.CONSOLE);
        private String f = null;
        private String g = null;
        private FeatureBindPack h;
        private String i;

        a(Context paramContext, FeatureBindPack paramFeatureBindPack) {
            super(paramFeatureBindPack);
            this.h = paramFeatureBindPack;
        }

        private String l() {
            if (this.f == null) {
                if (!FeaturePack.b.b(k())) {
                    break label28;
                }
                this.f = "fx_config";
            }
            for (; ; ) {
                return this.f;
                label28:
                if (FeaturePack.b.c(k())) {
                    this.f = "border_config";
                } else if (FeaturePack.b.a(k())) {
                    this.f = "stickers_config";
                } else if (FeaturePack.b.d(k())) {
                    this.f = "fonts_config";
                } else if (FeaturePack.b.e(k())) {
                    this.f = "collage_template_config";
                } else if (FeaturePack.b.f(k())) {
                    this.f = "collage_poster_config";
                } else if (FeaturePack.b.g(k())) {
                    this.f = "collage_background_config";
                }
            }
        }

        private String m() {
            String str;
            if (this.g == null) {
                str = null;
                if ((!FeaturePack.b.b(k())) && (!FeaturePack.b.c(k()))) {
                    break label70;
                }
                str = l() + File.separator + n();
            }
            for (; ; ) {
                this.g = str;
                return this.g;
                label70:
                if (FeaturePack.b.a(k())) {
                    str = l() + File.separator + n();
                } else if (FeaturePack.b.d(k())) {
                    str = l() + File.separator + n();
                } else if (FeaturePack.b.e(k())) {
                    str = l() + File.separator + n();
                } else if (FeaturePack.b.f(k())) {
                    str = l() + File.separator + n();
                } else if (FeaturePack.b.g(k())) {
                    str = l() + File.separator + n();
                }
            }
        }

        private String n() {
            if (TextUtils.isEmpty(this.i)) {
                this.i = StringUtils.removeSpeicalCharacter(this.h.getPackName());
            }
            return this.i;
        }

        public InputStream a(String paramString) {
            paramString = l() + File.separator + n() + File.separator + paramString;
            try {
                paramString = this.c.getAssets().open(paramString);
                return paramString;
            } catch (IOException paramString) {
                paramString.printStackTrace();
            }
            return null;
        }

        public String a_() {
            return m();
        }

        public InputStream b() {
            Object localObject = l() + File.separator + n() + File.separator + "config.json";
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
                Object localObject = m() + File.separator + paramString;
                e.c(new Object[]{"getTexture path:" + (String) localObject});
                localObject = this.c.getAssets().open((String) localObject);
                return (InputStream) localObject;
            } catch (IOException localIOException) {
                e.e(new Object[]{"textureName not found in pack:" + paramString});
            }
            return null;
        }

        public CharSequence b_() {
            return this.h.getPackName();
        }

        public Drawable c() {
            return a(l() + "/" + n() + "/pack_icon", false);
        }

        public int k() {
            return this.b.getPluginType();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/plugins/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */