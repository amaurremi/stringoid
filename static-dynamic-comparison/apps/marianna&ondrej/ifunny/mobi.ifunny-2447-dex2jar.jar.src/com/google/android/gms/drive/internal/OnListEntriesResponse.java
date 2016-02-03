package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.i;

public class OnListEntriesResponse
        extends i
        implements SafeParcelable {
    public static final Parcelable.Creator<OnListEntriesResponse> CREATOR = new k();
    final int a;
    final DataHolder b;
    final boolean c;

    OnListEntriesResponse(int paramInt, DataHolder paramDataHolder, boolean paramBoolean) {
        this.a = paramInt;
        this.b = paramDataHolder;
        this.c = paramBoolean;
    }

    protected void a(Parcel paramParcel, int paramInt) {
        k.a(this, paramParcel, paramInt);
    }

    public int describeContents() {
        return 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/OnListEntriesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */