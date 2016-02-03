package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class d
        implements Parcelable.Creator<RealtimeDocumentSyncRequest> {
    static void a(RealtimeDocumentSyncRequest paramRealtimeDocumentSyncRequest, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramRealtimeDocumentSyncRequest.a);
        c.b(paramParcel, 2, paramRealtimeDocumentSyncRequest.b, false);
        c.b(paramParcel, 3, paramRealtimeDocumentSyncRequest.c, false);
        c.a(paramParcel, paramInt);
    }

    public RealtimeDocumentSyncRequest a(Parcel paramParcel) {
        ArrayList localArrayList2 = null;
        int j = a.b(paramParcel);
        int i = 0;
        ArrayList localArrayList1 = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localArrayList1 = a.C(paramParcel, k);
                    break;
                case 3:
                    localArrayList2 = a.C(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new RealtimeDocumentSyncRequest(i, localArrayList1, localArrayList2);
    }

    public RealtimeDocumentSyncRequest[] a(int paramInt) {
        return new RealtimeDocumentSyncRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */