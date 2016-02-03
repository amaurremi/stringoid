package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem
        implements SafeParcelable {
    public static final Parcelable.Creator<LineItem> CREATOR = new i();
    String a;
    String b;
    String c;
    String d;
    int e;
    String f;
    private final int g;

    LineItem() {
        this.g = 1;
        this.e = 0;
    }

    LineItem(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5) {
        this.g = paramInt1;
        this.a = paramString1;
        this.b = paramString2;
        this.c = paramString3;
        this.d = paramString4;
        this.e = paramInt2;
        this.f = paramString5;
    }

    public int a() {
        return this.g;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        i.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/LineItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */