package com.amazon.device.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class Controller$PlayerProperties
        extends Controller.ReflectedParcelable {
    public static final Parcelable.Creator<PlayerProperties> CREATOR = new cv();
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public String f;
    public String g;

    public Controller$PlayerProperties() {
        this.a = true;
        this.b = true;
        this.c = false;
        this.d = false;
        this.g = "normal";
        this.f = "normal";
    }

    public Controller$PlayerProperties(Parcel paramParcel) {
        super(paramParcel);
    }

    public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString1, String paramString2) {
        this.d = paramBoolean1;
        this.a = paramBoolean2;
        this.b = paramBoolean3;
        this.e = paramBoolean4;
        this.c = paramBoolean5;
        this.g = paramString1;
        this.f = paramString2;
    }

    public boolean a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public boolean e() {
        return this.f.equalsIgnoreCase("exit");
    }

    public boolean f() {
        return this.g.equalsIgnoreCase("fullscreen");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/Controller$PlayerProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */