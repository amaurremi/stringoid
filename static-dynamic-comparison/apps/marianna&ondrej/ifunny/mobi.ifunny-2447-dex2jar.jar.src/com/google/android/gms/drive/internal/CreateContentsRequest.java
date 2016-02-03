package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CreateContentsRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<CreateContentsRequest> CREATOR = new ad();
    final int a;
    final int b;

    CreateContentsRequest(int paramInt1, int paramInt2) {
        this.a = paramInt1;
        if ((paramInt2 == 536870912) || (paramInt2 == 805306368)) {
        }
        for (boolean bool = true; ; bool = false) {
            ag.b(bool, "Cannot create a new read-only contents!");
            this.b = paramInt2;
            return;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ad.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/CreateContentsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */