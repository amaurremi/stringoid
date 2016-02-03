package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class ak
        implements Parcelable.Creator<GetDriveIdFromUniqueIdentifierRequest> {
    static void a(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramGetDriveIdFromUniqueIdentifierRequest.a);
        c.a(paramParcel, 2, paramGetDriveIdFromUniqueIdentifierRequest.b, false);
        c.a(paramParcel, 3, paramGetDriveIdFromUniqueIdentifierRequest.c);
        c.a(paramParcel, paramInt);
    }

    public GetDriveIdFromUniqueIdentifierRequest a(Parcel paramParcel) {
        boolean bool = false;
        int j = a.b(paramParcel);
        String str = null;
        int i = 0;
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
                    str = a.o(paramParcel, k);
                    break;
                case 3:
                    bool = a.c(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new GetDriveIdFromUniqueIdentifierRequest(i, str, bool);
    }

    public GetDriveIdFromUniqueIdentifierRequest[] a(int paramInt) {
        return new GetDriveIdFromUniqueIdentifierRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */