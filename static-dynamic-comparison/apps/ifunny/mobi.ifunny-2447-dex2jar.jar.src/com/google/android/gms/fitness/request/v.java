package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;

public class v
        implements SafeParcelable {
    public static final Parcelable.Creator<v> CREATOR = new ai();
    private final int a;
    private final Session b;

    v(int paramInt, Session paramSession) {
        this.a = paramInt;
        this.b = paramSession;
    }

    private boolean a(v paramv) {
        return ad.a(this.b, paramv.b);
    }

    public Session a() {
        return this.b;
    }

    int b() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (paramObject == this) || (((paramObject instanceof v)) && (a((v) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b});
    }

    public String toString() {
        return ad.a(this).a("session", this.b).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ai.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */