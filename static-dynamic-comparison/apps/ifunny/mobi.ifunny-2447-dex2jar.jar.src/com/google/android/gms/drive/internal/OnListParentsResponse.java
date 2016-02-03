package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.i;

public class OnListParentsResponse
        extends i
        implements SafeParcelable {
    public static final Parcelable.Creator<OnListParentsResponse> CREATOR = new l();
    final int a;
    final DataHolder b;

    OnListParentsResponse(int paramInt, DataHolder paramDataHolder) {
        this.a = paramInt;
        this.b = paramDataHolder;
    }

    protected void a(Parcel paramParcel, int paramInt) {
        l.a(this, paramParcel, paramInt);
    }

    public int describeContents() {
        return 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/OnListParentsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */