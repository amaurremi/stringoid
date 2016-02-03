package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.Comparator;

public class DetectedActivity
        implements SafeParcelable {
    public static final e CREATOR = new e();
    public static final Comparator<DetectedActivity> a = new d();
    int b;
    int c;
    private final int d;

    public DetectedActivity(int paramInt1, int paramInt2, int paramInt3) {
        this.d = paramInt1;
        this.b = paramInt2;
        this.c = paramInt3;
    }

    private int a(int paramInt) {
        int i = paramInt;
        if (paramInt > 9) {
            i = 4;
        }
        return i;
    }

    public int a() {
        return a(this.b);
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "DetectedActivity [type=" + a() + ", confidence=" + this.c + "]";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        e.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/location/DetectedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */