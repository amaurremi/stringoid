package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class CameraPositionCreator
        implements Parcelable.Creator<CameraPosition> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(CameraPosition paramCameraPosition, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramCameraPosition.getVersionCode());
        b.a(paramParcel, 2, paramCameraPosition.target, paramInt, false);
        b.a(paramParcel, 3, paramCameraPosition.zoom);
        b.a(paramParcel, 4, paramCameraPosition.tilt);
        b.a(paramParcel, 5, paramCameraPosition.bearing);
        b.F(paramParcel, i);
    }

    public CameraPosition createFromParcel(Parcel paramParcel) {
        float f1 = 0.0F;
        int j = a.o(paramParcel);
        int i = 0;
        LatLng localLatLng = null;
        float f2 = 0.0F;
        float f3 = 0.0F;
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
                    localLatLng = (LatLng) a.a(paramParcel, k, LatLng.CREATOR);
                    break;
                case 3:
                    f3 = a.k(paramParcel, k);
                    break;
                case 4:
                    f2 = a.k(paramParcel, k);
                    break;
                case 5:
                    f1 = a.k(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new CameraPosition(i, localLatLng, f3, f2, f1);
    }

    public CameraPosition[] newArray(int paramInt) {
        return new CameraPosition[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/model/CameraPositionCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */