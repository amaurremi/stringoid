package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnListParentsResponse
        implements SafeParcelable {
    public static final Parcelable.Creator<OnListParentsResponse> CREATOR = new ae();
    final DataHolder FK;
    final int xH;

    OnListParentsResponse(int paramInt, DataHolder paramDataHolder) {
        this.xH = paramInt;
        this.FK = paramDataHolder;
    }

    public int describeContents() {
        return 0;
    }

    public DataHolder fP() {
        return this.FK;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ae.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/OnListParentsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */