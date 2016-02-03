package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.ArrayList;

public final class Cart
        implements SafeParcelable {
    public static final Parcelable.Creator<Cart> CREATOR = new b();
    String a;
    String b;
    ArrayList<LineItem> c;
    private final int d;

    Cart() {
        this.d = 1;
        this.c = new ArrayList();
    }

    Cart(int paramInt, String paramString1, String paramString2, ArrayList<LineItem> paramArrayList) {
        this.d = paramInt;
        this.a = paramString1;
        this.b = paramString2;
        this.c = paramArrayList;
    }

    public int a() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/Cart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */