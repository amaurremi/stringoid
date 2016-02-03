package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.b;

public final class LatLng
        implements SafeParcelable {
    public static final m CREATOR = new m();
    public final double a;
    public final double b;
    private final int c;

    LatLng(int paramInt, double paramDouble1, double paramDouble2) {
        this.c = paramInt;
        if ((-180.0D <= paramDouble2) && (paramDouble2 < 180.0D)) {
        }
        for (this.b = paramDouble2; ; this.b = (((paramDouble2 - 180.0D) % 360.0D + 360.0D) % 360.0D - 180.0D)) {
            this.a = Math.max(-90.0D, Math.min(90.0D, paramDouble1));
            return;
        }
    }

    int a() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof LatLng)) {
                return false;
            }
            paramObject = (LatLng) paramObject;
        }
        while ((Double.doubleToLongBits(this.a) == Double.doubleToLongBits(((LatLng) paramObject).a)) && (Double.doubleToLongBits(this.b) == Double.doubleToLongBits(((LatLng) paramObject).b)));
        return false;
    }

    public int hashCode() {
        long l = Double.doubleToLongBits(this.a);
        int i = (int) (l ^ l >>> 32);
        l = Double.doubleToLongBits(this.b);
        return (i + 31) * 31 + (int) (l ^ l >>> 32);
    }

    public String toString() {
        return "lat/lng: (" + this.a + "," + this.b + ")";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        if (b.a()) {
            n.a(this, paramParcel, paramInt);
            return;
        }
        m.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/LatLng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */