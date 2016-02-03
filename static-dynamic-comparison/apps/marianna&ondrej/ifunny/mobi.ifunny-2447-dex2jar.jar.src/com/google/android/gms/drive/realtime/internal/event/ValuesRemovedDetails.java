package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesRemovedDetails
        implements SafeParcelable {
    public static final Parcelable.Creator<ValuesRemovedDetails> CREATOR = new i();
    final int a;
    final int b;
    final int c;
    final int d;
    final String e;
    final int f;

    ValuesRemovedDetails(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramInt3;
        this.d = paramInt4;
        this.e = paramString;
        this.f = paramInt5;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        i.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ValuesRemovedDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */