package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StreetViewPanoramaOrientation
        implements SafeParcelable {
    public static final x CREATOR = new x();
    public final float a;
    public final float b;
    private final int c;

    public StreetViewPanoramaOrientation(float paramFloat1, float paramFloat2) {
        this(1, paramFloat1, paramFloat2);
    }

    StreetViewPanoramaOrientation(int paramInt, float paramFloat1, float paramFloat2) {
        if ((-90.0F <= paramFloat1) && (paramFloat1 <= 90.0F)) {
        }
        for (boolean bool = true; ; bool = false) {
            ag.b(bool, "Tilt needs to be between -90 and 90 inclusive");
            this.c = paramInt;
            this.a = (0.0F + paramFloat1);
            paramFloat1 = paramFloat2;
            if (paramFloat2 <= 0.0D) {
                paramFloat1 = paramFloat2 % 360.0F + 360.0F;
            }
            this.b = (paramFloat1 % 360.0F);
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
            if (!(paramObject instanceof StreetViewPanoramaOrientation)) {
                return false;
            }
            paramObject = (StreetViewPanoramaOrientation) paramObject;
        }
        while ((Float.floatToIntBits(this.a) == Float.floatToIntBits(((StreetViewPanoramaOrientation) paramObject).a)) && (Float.floatToIntBits(this.b) == Float.floatToIntBits(((StreetViewPanoramaOrientation) paramObject).b)));
        return false;
    }

    public int hashCode() {
        return ad.a(new Object[]{Float.valueOf(this.a), Float.valueOf(this.b)});
    }

    public String toString() {
        return ad.a(this).a("tilt", Float.valueOf(this.a)).a("bearing", Float.valueOf(this.b)).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        x.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/StreetViewPanoramaOrientation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */