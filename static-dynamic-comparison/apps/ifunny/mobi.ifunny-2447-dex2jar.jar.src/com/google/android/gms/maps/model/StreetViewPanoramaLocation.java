package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StreetViewPanoramaLocation
        implements SafeParcelable {
    public static final w CREATOR = new w();
    public final StreetViewPanoramaLink[] a;
    public final LatLng b;
    public final String c;
    private final int d;

    StreetViewPanoramaLocation(int paramInt, StreetViewPanoramaLink[] paramArrayOfStreetViewPanoramaLink, LatLng paramLatLng, String paramString) {
        this.d = paramInt;
        this.a = paramArrayOfStreetViewPanoramaLink;
        this.b = paramLatLng;
        this.c = paramString;
    }

    int a() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof StreetViewPanoramaLocation)) {
                return false;
            }
            paramObject = (StreetViewPanoramaLocation) paramObject;
        }
        while ((this.c.equals(((StreetViewPanoramaLocation) paramObject).c)) && (this.b.equals(((StreetViewPanoramaLocation) paramObject).b)));
        return false;
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b, this.c});
    }

    public String toString() {
        return ad.a(this).a("panoId", this.c).a("position", this.b.toString()).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        w.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/StreetViewPanoramaLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */