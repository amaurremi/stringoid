package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;

public class CheckResourceIdsExistRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<CheckResourceIdsExistRequest> CREATOR = new aa();
    private final int a;
    private final List<String> b;

    CheckResourceIdsExistRequest(int paramInt, List<String> paramList) {
        this.a = paramInt;
        this.b = paramList;
    }

    public int a() {
        return this.a;
    }

    public List<String> b() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        aa.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/CheckResourceIdsExistRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */