package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;

public class RealtimeDocumentSyncRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<RealtimeDocumentSyncRequest> CREATOR = new d();
    final int a;
    final List<String> b;
    final List<String> c;

    RealtimeDocumentSyncRequest(int paramInt, List<String> paramList1, List<String> paramList2) {
        this.a = paramInt;
        this.b = ((List) ag.a(paramList1));
        this.c = ((List) ag.a(paramList2));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        d.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/RealtimeDocumentSyncRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */