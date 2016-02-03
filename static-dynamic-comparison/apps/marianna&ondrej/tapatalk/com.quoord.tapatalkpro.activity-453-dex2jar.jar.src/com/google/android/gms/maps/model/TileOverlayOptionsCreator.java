package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class TileOverlayOptionsCreator
        implements Parcelable.Creator<TileOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(TileOverlayOptions paramTileOverlayOptions, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.c(paramParcel, 1, paramTileOverlayOptions.getVersionCode());
        b.a(paramParcel, 2, paramTileOverlayOptions.iG(), false);
        b.a(paramParcel, 3, paramTileOverlayOptions.isVisible());
        b.a(paramParcel, 4, paramTileOverlayOptions.getZIndex());
        b.a(paramParcel, 5, paramTileOverlayOptions.getFadeIn());
        b.F(paramParcel, paramInt);
    }

    public TileOverlayOptions createFromParcel(Parcel paramParcel) {
        boolean bool2 = false;
        int j = a.o(paramParcel);
        IBinder localIBinder = null;
        float f = 0.0F;
        boolean bool1 = true;
        int i = 0;
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
                    localIBinder = a.o(paramParcel, k);
                    break;
                case 3:
                    bool2 = a.c(paramParcel, k);
                    break;
                case 4:
                    f = a.k(paramParcel, k);
                    break;
                case 5:
                    bool1 = a.c(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new TileOverlayOptions(i, localIBinder, bool2, f, bool1);
    }

    public TileOverlayOptions[] newArray(int paramInt) {
        return new TileOverlayOptions[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/model/TileOverlayOptionsCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */