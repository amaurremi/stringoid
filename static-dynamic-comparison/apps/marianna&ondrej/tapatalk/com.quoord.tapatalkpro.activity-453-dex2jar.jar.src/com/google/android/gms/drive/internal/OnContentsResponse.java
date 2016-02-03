package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class OnContentsResponse
        implements SafeParcelable {
    public static final Parcelable.Creator<OnContentsResponse> CREATOR = new z();
    final Contents EA;
    final int xH;

    OnContentsResponse(int paramInt, Contents paramContents) {
        this.xH = paramInt;
        this.EA = paramContents;
    }

    public int describeContents() {
        return 0;
    }

    public Contents fI() {
        return this.EA;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        z.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/OnContentsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */