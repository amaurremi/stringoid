package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class StreetViewPanoramaLinkCreator
        implements Parcelable.Creator<StreetViewPanoramaLink> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(StreetViewPanoramaLink paramStreetViewPanoramaLink, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.c(paramParcel, 1, paramStreetViewPanoramaLink.getVersionCode());
        b.a(paramParcel, 2, paramStreetViewPanoramaLink.panoId, false);
        b.a(paramParcel, 3, paramStreetViewPanoramaLink.bearing);
        b.F(paramParcel, paramInt);
    }

    public StreetViewPanoramaLink createFromParcel(Parcel paramParcel) {
        int j = a.o(paramParcel);
        int i = 0;
        String str = null;
        float f = 0.0F;
        while (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            switch (a.R(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    str = a.n(paramParcel, k);
                    break;
                case 3:
                    f = a.k(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new StreetViewPanoramaLink(i, str, f);
    }

    public StreetViewPanoramaLink[] newArray(int paramInt) {
        return new StreetViewPanoramaLink[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/model/StreetViewPanoramaLinkCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */