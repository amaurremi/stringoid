package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class mq
        implements SafeParcelable {
    public static final Parcelable.Creator<mq> CREATOR = new rh();
    final int a;
    private final String b;
    private final LatLng c;
    private final String d;
    private final List<mo> e;
    private final String f;
    private final String g;

    mq(int paramInt, String paramString1, LatLng paramLatLng, String paramString2, List<mo> paramList, String paramString3, String paramString4) {
        this.a = paramInt;
        this.b = paramString1;
        this.c = paramLatLng;
        this.d = paramString2;
        this.e = new ArrayList(paramList);
        this.f = paramString3;
        this.g = paramString4;
    }

    public String a() {
        return this.b;
    }

    public LatLng b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public List<mo> d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        rh.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/mq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */