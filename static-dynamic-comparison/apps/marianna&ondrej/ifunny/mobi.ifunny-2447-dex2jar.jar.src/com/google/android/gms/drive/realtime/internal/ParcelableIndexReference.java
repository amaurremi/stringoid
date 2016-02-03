package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableIndexReference
        implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableIndexReference> CREATOR = new d();
    final int a;
    final String b;
    final int c;
    final boolean d;

    ParcelableIndexReference(int paramInt1, String paramString, int paramInt2, boolean paramBoolean) {
        this.a = paramInt1;
        this.b = paramString;
        this.c = paramInt2;
        this.d = paramBoolean;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        d.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/ParcelableIndexReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */