package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;

public class StreetViewPanoramaLink
        implements SafeParcelable {
    public static final StreetViewPanoramaLinkCreator CREATOR = new StreetViewPanoramaLinkCreator();
    public final float bearing;
    public final String panoId;
    private final int xH;

    StreetViewPanoramaLink(int paramInt, String paramString, float paramFloat) {
        this.xH = paramInt;
        this.panoId = paramString;
        float f = paramFloat;
        if (paramFloat <= 0.0D) {
            f = paramFloat % 360.0F + 360.0F;
        }
        this.bearing = (f % 360.0F);
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
        while ((this.panoId.equals(((StreetViewPanoramaLink) paramObject).panoId)) && (Float.floatToIntBits(this.bearing) == Float.floatToIntBits(((StreetViewPanoramaLink) paramObject).bearing)));
        return false;
    }

    int getVersionCode() {
        return this.xH;
    }

    public int hashCode() {
        return fo.hashCode(new Object[]{this.panoId, Float.valueOf(this.bearing)});
    }

    public String toString() {
        return fo.e(this).a("panoId", this.panoId).a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        StreetViewPanoramaLinkCreator.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/model/StreetViewPanoramaLink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */