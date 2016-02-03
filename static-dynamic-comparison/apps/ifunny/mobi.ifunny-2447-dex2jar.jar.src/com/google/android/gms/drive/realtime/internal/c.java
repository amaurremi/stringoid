package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
        implements Parcelable.Creator<ParcelableCollaborator> {
    static void a(ParcelableCollaborator paramParcelableCollaborator, Parcel paramParcel, int paramInt) {
        paramInt = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramParcelableCollaborator.a);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramParcelableCollaborator.b);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramParcelableCollaborator.c);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 4, paramParcelableCollaborator.d, false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 5, paramParcelableCollaborator.e, false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 6, paramParcelableCollaborator.f, false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 7, paramParcelableCollaborator.g, false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 8, paramParcelableCollaborator.h, false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, paramInt);
    }

    public ParcelableCollaborator a(Parcel paramParcel) {
        boolean bool1 = false;
        String str1 = null;
        int j = a.b(paramParcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean bool2 = false;
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
                    bool2 = a.c(paramParcel, k);
                    break;
                case 3:
                    bool1 = a.c(paramParcel, k);
                    break;
                case 4:
                    str5 = a.o(paramParcel, k);
                    break;
                case 5:
                    str4 = a.o(paramParcel, k);
                    break;
                case 6:
                    str3 = a.o(paramParcel, k);
                    break;
                case 7:
                    str2 = a.o(paramParcel, k);
                    break;
                case 8:
                    str1 = a.o(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new ParcelableCollaborator(i, bool2, bool1, str5, str4, str3, str2, str1);
    }

    public ParcelableCollaborator[] a(int paramInt) {
        return new ParcelableCollaborator[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */