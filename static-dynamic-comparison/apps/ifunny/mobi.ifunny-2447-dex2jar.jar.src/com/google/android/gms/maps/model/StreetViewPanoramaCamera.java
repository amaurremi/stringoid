package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StreetViewPanoramaCamera
        implements SafeParcelable {
    public static final u CREATOR = new u();
    public final float a;
    public final float b;
    public final float c;
    private final int d;
    private StreetViewPanoramaOrientation e;

    StreetViewPanoramaCamera(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
        boolean bool;
        if ((-90.0F <= paramFloat2) && (paramFloat2 <= 90.0F)) {
            bool = true;
            ag.b(bool, "Tilt needs to be between -90 and 90 inclusive");
            this.d = paramInt;
            this.a = paramFloat1;
            this.b = (0.0F + paramFloat2);
            if (paramFloat3 > 0.0D) {
                break label100;
            }
        }
        label100:
        for (paramFloat1 = paramFloat3 % 360.0F + 360.0F; ; paramFloat1 = paramFloat3) {
            this.c = (paramFloat1 % 360.0F);
            this.e = new b().a(paramFloat2).b(paramFloat3).a();
            return;
            bool = false;
            break;
        }
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
            if (!(paramObject instanceof StreetViewPanoramaCamera)) {
                return false;
            }
            paramObject = (StreetViewPanoramaCamera) paramObject;
        }
        while ((Float.floatToIntBits(this.a) == Float.floatToIntBits(((StreetViewPanoramaCamera) paramObject).a)) && (Float.floatToIntBits(this.b) == Float.floatToIntBits(((StreetViewPanoramaCamera) paramObject).b)) && (Float.floatToIntBits(this.c) == Float.floatToIntBits(((StreetViewPanoramaCamera) paramObject).c)));
        return false;
    }

    public int hashCode() {
        return ad.a(new Object[]{Float.valueOf(this.a), Float.valueOf(this.b), Float.valueOf(this.c)});
    }

    public String toString() {
        return ad.a(this).a("zoom", Float.valueOf(this.a)).a("tilt", Float.valueOf(this.b)).a("bearing", Float.valueOf(this.c)).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        u.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/StreetViewPanoramaCamera.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */