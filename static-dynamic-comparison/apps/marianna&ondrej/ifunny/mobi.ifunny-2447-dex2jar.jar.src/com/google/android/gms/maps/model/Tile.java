package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.a.b;

public final class Tile
        implements SafeParcelable {
    public static final y CREATOR = new y();
    public final int a;
    public final int b;
    public final byte[] c;
    private final int d;

    Tile(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte) {
        this.d = paramInt1;
        this.a = paramInt2;
        this.b = paramInt3;
        this.c = paramArrayOfByte;
    }

    public Tile(int paramInt1, int paramInt2, byte[] paramArrayOfByte) {
        this(1, paramInt1, paramInt2, paramArrayOfByte);
    }

    int a() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        if (b.a()) {
            z.a(this, paramParcel, paramInt);
            return;
        }
        y.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/maps/model/Tile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */