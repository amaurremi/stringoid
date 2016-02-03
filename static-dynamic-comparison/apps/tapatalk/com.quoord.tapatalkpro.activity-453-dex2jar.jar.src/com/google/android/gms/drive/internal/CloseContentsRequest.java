package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class CloseContentsRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<CloseContentsRequest> CREATOR = new e();
    final Contents EX;
    final Boolean EY;
    final int xH;

    CloseContentsRequest(int paramInt, Contents paramContents, Boolean paramBoolean) {
        this.xH = paramInt;
        this.EX = paramContents;
        this.EY = paramBoolean;
    }

    public CloseContentsRequest(Contents paramContents, boolean paramBoolean) {
        this(1, paramContents, Boolean.valueOf(paramBoolean));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        e.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/CloseContentsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */