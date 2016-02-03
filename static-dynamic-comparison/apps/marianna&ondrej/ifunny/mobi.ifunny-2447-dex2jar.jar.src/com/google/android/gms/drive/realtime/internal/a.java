package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class a
        implements Parcelable.Creator<BeginCompoundOperationRequest> {
    static void a(BeginCompoundOperationRequest paramBeginCompoundOperationRequest, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramBeginCompoundOperationRequest.a);
        c.a(paramParcel, 2, paramBeginCompoundOperationRequest.b);
        c.a(paramParcel, 3, paramBeginCompoundOperationRequest.c, false);
        c.a(paramParcel, 4, paramBeginCompoundOperationRequest.d);
        c.a(paramParcel, paramInt);
    }

    public BeginCompoundOperationRequest a(Parcel paramParcel) {
        boolean bool1 = false;
        int j = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        String str = null;
        boolean bool2 = true;
        int i = 0;
        while (paramParcel.dataPosition() < j) {
            int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(k)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
                    break;
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
                    break;
                case 2:
                    bool1 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 4:
                    bool2 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new BeginCompoundOperationRequest(i, bool1, str, bool2);
    }

    public BeginCompoundOperationRequest[] a(int paramInt) {
        return new BeginCompoundOperationRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */