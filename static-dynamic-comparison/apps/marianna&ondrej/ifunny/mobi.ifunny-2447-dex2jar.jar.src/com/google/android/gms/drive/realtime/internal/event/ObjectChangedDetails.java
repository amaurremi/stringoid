package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ObjectChangedDetails
        implements SafeParcelable {
    public static final Parcelable.Creator<ObjectChangedDetails> CREATOR = new a();
    final int a;
    final int b;
    final int c;

    ObjectChangedDetails(int paramInt1, int paramInt2, int paramInt3) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramInt3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ObjectChangedDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */