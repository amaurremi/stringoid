package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.d;

public class PlusCommonExtras
        implements SafeParcelable {
    public static final l CREATOR = new l();
    public static String a = "PlusCommonExtras";
    private final int b;
    private String c;
    private String d;

    public PlusCommonExtras() {
        this.b = 1;
        this.c = "";
        this.d = "";
    }

    PlusCommonExtras(int paramInt, String paramString1, String paramString2) {
        this.b = paramInt;
        this.c = paramString1;
        this.d = paramString2;
    }

    public int a() {
        return this.b;
    }

    public void a(Bundle paramBundle) {
        paramBundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", d.a(this));
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof PlusCommonExtras)) {
        }
        do {
            return false;
            paramObject = (PlusCommonExtras) paramObject;
        }
        while ((this.b != ((PlusCommonExtras) paramObject).b) || (!ad.a(this.c, ((PlusCommonExtras) paramObject).c)) || (!ad.a(this.d, ((PlusCommonExtras) paramObject).d)));
        return true;
    }

    public int hashCode() {
        return ad.a(new Object[]{Integer.valueOf(this.b), this.c, this.d});
    }

    public String toString() {
        return ad.a(this).a("versionCode", Integer.valueOf(this.b)).a("Gpsrc", this.c).a("ClientCallingPackage", this.d).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        l.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/plus/internal/PlusCommonExtras.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */