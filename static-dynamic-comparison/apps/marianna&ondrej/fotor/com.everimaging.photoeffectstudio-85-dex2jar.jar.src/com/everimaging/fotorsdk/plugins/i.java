package com.everimaging.fotorsdk.plugins;

import android.content.Context;

public class i
        implements h.b {
    protected FeaturePurchasedPack a;
    private int b;
    private String c;

    public i(Context paramContext, FeaturePurchasedPack paramFeaturePurchasedPack) {
        this.c = paramFeaturePurchasedPack.getPackageName();
        this.b = paramFeaturePurchasedPack.getPackageVersionCode();
        this.a = paramFeaturePurchasedPack;
    }

    public String a() {
        return this.c;
    }

    public CharSequence b_() {
        return this.a.getPackName();
    }

    public boolean c() {
        return true;
    }

    public String d() {
        return this.a.getIconUrlDefault();
    }

    public String e() {
        return this.a.getIconUrlPressed();
    }

    public FeaturePurchasedPack f() {
        return this.a;
    }

    public String g() {
        return this.a.getPackID();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/plugins/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */