package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
        implements Parcelable.Creator<DriveId> {
    static void a(DriveId paramDriveId, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramDriveId.a);
        c.a(paramParcel, 2, paramDriveId.b, false);
        c.a(paramParcel, 3, paramDriveId.c);
        c.a(paramParcel, 4, paramDriveId.d);
        c.a(paramParcel, paramInt);
    }

    public DriveId a(Parcel paramParcel) {
        long l1 = 0L;
        int j = a.b(paramParcel);
        int i = 0;
        String str = null;
        long l2 = 0L;
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
                    l2 = a.i(paramParcel, k);
                    break;
                case 4:
                    l1 = a.i(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + j, paramParcel);
        }
        return new DriveId(i, str, l2, l1);
    }

    public DriveId[] a(int paramInt) {
        return new DriveId[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */