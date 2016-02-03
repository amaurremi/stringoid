package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StreetViewPanoramaLink
        implements SafeParcelable {
    public static final v CREATOR = new v();
    public final String a;
    public final float b;
    private final int c;

    StreetViewPanoramaLink(int paramInt, String paramString, float paramFloat) {
        this.c = paramInt;
        this.a = paramString;
        float f = paramFloat;
        if (paramFloat <= 0.0D) {
            f = paramFloat % 360.0F + 360.0F;
        }
        this.b = (f % 360.0F);
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
            if (!(paramObject instanceof StreetViewPanoramaLink)) {
                return false;
            }
            paramObject = (StreetViewPanoramaLink) paramObject;
        }
        while ((this.a.equals(((StreetViewPanoramaLink) paramObject).a)) && (Float.floatToIntBits(this.b) == Float.floatToIntBits(((StreetViewPanoramaLink) paramObject).b)));
        return false;
    }

    public int hashCode() {
        return ad.a(new Object[]{this.a, Float.valueOf(this.b)});
    }

    public String toString() {
        return ad.a(this).a("panoId", this.a).a("bearing", Float.valueOf(this.b)).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        v.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/StreetViewPanoramaLink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */