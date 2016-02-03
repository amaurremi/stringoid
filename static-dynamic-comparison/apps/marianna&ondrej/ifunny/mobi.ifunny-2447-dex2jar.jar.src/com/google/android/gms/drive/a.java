package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class a
        implements Parcelable.Creator<Contents> {
    static void a(Contents paramContents, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramContents.a);
        c.a(paramParcel, 2, paramContents.b, paramInt, false);
        c.a(paramParcel, 3, paramContents.c);
        c.a(paramParcel, 4, paramContents.d);
        c.a(paramParcel, 5, paramContents.e, paramInt, false);
        c.a(paramParcel, 7, paramContents.f);
        c.a(paramParcel, i);
    }

    public Contents a(Parcel paramParcel) {
        DriveId localDriveId = null;
        boolean bool = false;
        int m = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        int i = 0;
        int j = 0;
        ParcelFileDescriptor localParcelFileDescriptor = null;
        int k = 0;
        while (paramParcel.dataPosition() < m) {
            int n = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(n)) {
                case 6:
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
                    break;
                case 7:
                    bool = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new Contents(k, localParcelFileDescriptor, j, i, localDriveId, bool);
    }

    public Contents[] a(int paramInt) {
        return new Contents[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */