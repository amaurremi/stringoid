package com.everimaging.fotorsdk.plugins;

import android.content.Context;

public class d
        implements h.b {
    protected FeatureExternalPack a;
    private int b;
    private String c;

    d(Context paramContext, FeatureExternalPack paramFeatureExternalPack) {
        this.c = paramFeatureExternalPack.getPackageName();
        this.b = paramFeatureExternalPack.getPackageVersionCode();
        this.a = paramFeatureExternalPack;
    }

    public String a() {
        return this.c;
    }

    public CharSequence b_() {
        return this.a.getName();
    }

    public boolean c() {
        return this.a.isLocalPack();
    }

    public String d() {
        return this.a.getIconUrlDefault();
    }

    public String e() {
        return this.a.getIconUrlPressed();
    }

    public FeatureExternalPack f() {
        return this.a;
    }

    public String g() {
        return this.a.getPackID();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/plugins/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */