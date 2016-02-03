package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class e
        implements Parcelable.Creator<CameraPosition> {
    static void a(CameraPosition paramCameraPosition, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramCameraPosition.a());
        c.a(paramParcel, 2, paramCameraPosition.a, paramInt, false);
        c.a(paramParcel, 3, paramCameraPosition.b);
        c.a(paramParcel, 4, paramCameraPosition.c);
        c.a(paramParcel, 5, paramCameraPosition.d);
        c.a(paramParcel, i);
    }

    public CameraPosition a(Parcel paramParcel) {
        float f1 = 0.0F;
        int j = a.b(paramParcel);
        int i = 0;
        LatLng localLatLng = null;
        float f2 = 0.0F;
        float f3 = 0.0F;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
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
                    f3 = a.l(paramParcel, k);
                    break;
                case 4:
                    f2 = a.l(paramParcel, k);
                    break;
                case 5:
                    f1 = a.l(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new CameraPosition(i, localLatLng, f3, f2, f1);
    }

    public CameraPosition[] a(int paramInt) {
        return new CameraPosition[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */