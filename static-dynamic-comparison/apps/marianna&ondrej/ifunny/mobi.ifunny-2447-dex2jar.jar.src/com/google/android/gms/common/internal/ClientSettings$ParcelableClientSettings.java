package com.google.android.gms.common.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ClientSettings$ParcelableClientSettings
        implements SafeParcelable {
    public static final a CREATOR = new a();
    private final int a;
    private final String b;
    private final List<String> c = new ArrayList();
    private final int d;
    private final String e;

    ClientSettings$ParcelableClientSettings(int paramInt1, String paramString1, List<String> paramList, int paramInt2, String paramString2) {
        this.a = paramInt1;
        this.b = paramString1;
        this.c.addAll(paramList);
        this.d = paramInt2;
        this.e = paramString2;
    }

    public ClientSettings$ParcelableClientSettings(String paramString1, Collection<String> paramCollection, int paramInt, String paramString2) {
        this(3, paramString1, new ArrayList(paramCollection), paramInt, paramString2);
    }

    public String a() {
        return this.b;
    }

    public String b() {
        if (this.b != null) {
            return this.b;
        }
        return "<<default account>>";
    }

    public int c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public List<String> e() {
        return new ArrayList(this.c);
    }

    public int f() {
        return this.a;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/ClientSettings$ParcelableClientSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */