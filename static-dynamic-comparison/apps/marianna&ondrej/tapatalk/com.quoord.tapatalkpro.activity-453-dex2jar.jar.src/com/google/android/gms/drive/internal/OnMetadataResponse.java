package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse
        implements SafeParcelable {
    public static final Parcelable.Creator<OnMetadataResponse> CREATOR = new af();
    final MetadataBundle EZ;
    final int xH;

    OnMetadataResponse(int paramInt, MetadataBundle paramMetadataBundle) {
        this.xH = paramInt;
        this.EZ = paramMetadataBundle;
    }

    public int describeContents() {
        return 0;
    }

    public MetadataBundle fQ() {
        return this.EZ;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        af.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/OnMetadataResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */