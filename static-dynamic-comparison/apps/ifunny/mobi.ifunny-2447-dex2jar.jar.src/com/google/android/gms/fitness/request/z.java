package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class z
        implements SafeParcelable {
    public static final Parcelable.Creator<z> CREATOR = new a();
    private final int a;
    private final PendingIntent b;

    z(int paramInt, PendingIntent paramPendingIntent) {
        this.a = paramInt;
        this.b = paramPendingIntent;
    }

    private boolean a(z paramz) {
        return ad.a(this.b, paramz.b);
    }

    public PendingIntent a() {
        return this.b;
    }

    int b() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof z)) && (a((z) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b});
    }

    public String toString() {
        return ad.a(this).a("pendingIntent", this.b).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */