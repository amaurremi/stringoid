package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.b;

public class i {
    static void a(Tile paramTile, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.c(paramParcel, 1, paramTile.getVersionCode());
        b.c(paramParcel, 2, paramTile.width);
        b.c(paramParcel, 3, paramTile.height);
        b.a(paramParcel, 4, paramTile.data, false);
        b.F(paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/maps/model/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */