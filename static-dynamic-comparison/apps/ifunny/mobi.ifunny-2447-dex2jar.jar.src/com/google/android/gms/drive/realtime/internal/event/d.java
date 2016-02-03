package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class d
        implements Parcelable.Creator<ReferenceShiftedDetails> {
    static void a(ReferenceShiftedDetails paramReferenceShiftedDetails, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramReferenceShiftedDetails.a);
        c.a(paramParcel, 2, paramReferenceShiftedDetails.b, false);
        c.a(paramParcel, 3, paramReferenceShiftedDetails.c, false);
        c.a(paramParcel, 4, paramReferenceShiftedDetails.d);
        c.a(paramParcel, 5, paramReferenceShiftedDetails.e);
        c.a(paramParcel, paramInt);
    }

    public ReferenceShiftedDetails a(Parcel paramParcel) {
        String str1 = null;
        int i = 0;
        int m = a.b(paramParcel);
        int j = 0;
        String str2 = null;
        int k = 0;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    str2 = a.o(paramParcel, n);
                    break;
                case 3:
                    str1 = a.o(paramParcel, n);
                    break;
                case 4:
                    j = a.g(paramParcel, n);
                    break;
                case 5:
                    i = a.g(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new ReferenceShiftedDetails(k, str2, str1, j, i);
    }

    public ReferenceShiftedDetails[] a(int paramInt) {
        return new ReferenceShiftedDetails[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */