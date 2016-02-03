package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
        implements Parcelable.Creator<Contents> {
    static void a(Contents paramContents, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramContents.xH);
        b.a(paramParcel, 2, paramContents.Cj, paramInt, false);
        b.c(paramParcel, 3, paramContents.Eu);
        b.c(paramParcel, 4, paramContents.Ev);
        b.a(paramParcel, 5, paramContents.Ew, paramInt, false);
        b.F(paramParcel, i);
    }

    public Contents[] ac(int paramInt) {
        return new Contents[paramInt];
    }

    public Contents y(Parcel paramParcel) {
        DriveId localDriveId = null;
        int i = 0;
        int m = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel);
        int j = 0;
        ParcelFileDescriptor localParcelFileDescriptor = null;
        int k = 0;
        while (paramParcel.dataPosition() < m) {
            int n = com.google.android.gms.common.internal.safeparcel.a.n(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.R(n)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, n);
                    break;
                case 1:
                    k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
                    break;
                case 2:
                    localParcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, n, ParcelFileDescriptor.CREATOR);
                    break;
                case 3:
                    j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
                    break;
                case 4:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
                    break;
                case 5:
                    localDriveId = (DriveId) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, n, DriveId.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new a.a("Overread allowed size end=" + m, paramParcel);
        }
        return new Contents(k, localParcelFileDescriptor, j, i, localDriveId);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */