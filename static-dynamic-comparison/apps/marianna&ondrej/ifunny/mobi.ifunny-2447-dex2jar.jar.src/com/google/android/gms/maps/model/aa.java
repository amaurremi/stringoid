package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class aa
        implements Parcelable.Creator<TileOverlayOptions> {
    static void a(TileOverlayOptions paramTileOverlayOptions, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramTileOverlayOptions.a());
        c.a(paramParcel, 2, paramTileOverlayOptions.b(), false);
        c.a(paramParcel, 3, paramTileOverlayOptions.d());
        c.a(paramParcel, 4, paramTileOverlayOptions.c());
        c.a(paramParcel, 5, paramTileOverlayOptions.e());
        c.a(paramParcel, paramInt);
    }

    public TileOverlayOptions a(Parcel paramParcel) {
        boolean bool2 = false;
        int j = a.b(paramParcel);
        IBinder localIBinder = null;
        float f = 0.0F;
        boolean bool1 = true;
        int i = 0;
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
                    localIBinder = a.p(paramParcel, k);
                    break;
                case 3:
                    bool2 = a.c(paramParcel, k);
                    break;
                case 4:
                    f = a.l(paramParcel, k);
                    break;
                case 5:
                    bool1 = a.c(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new TileOverlayOptions(i, localIBinder, bool2, f, bool1);
    }

    public TileOverlayOptions[] a(int paramInt) {
        return new TileOverlayOptions[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */