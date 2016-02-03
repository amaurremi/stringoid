package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class i
        implements SafeParcelable {
    public static final Parcelable.Creator<i> CREATOR = new r();
    private final int a;
    private final String b;

    i(int paramInt, String paramString) {
        this.a = paramInt;
        this.b = paramString;
    }

    private boolean a(i parami) {
        return ad.a(this.b, parami.b);
    }

    public String a() {
        return this.b;
    }

    int b() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (paramObject == this) || (((paramObject instanceof i)) && (a((i) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b});
    }

    public String toString() {
        return ad.a(this).a("name", this.b).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        r.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */