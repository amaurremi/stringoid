package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class z
        implements SafeParcelable {
    public static final Parcelable.Creator<z> CREATOR = new a();
    public final int a;
    public final int b;
    public final ParcelFileDescriptor c;

    z(int paramInt1, int paramInt2, ParcelFileDescriptor paramParcelFileDescriptor) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramParcelFileDescriptor;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt | 0x1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */