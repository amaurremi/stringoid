package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class e
        implements Parcelable.Creator<TextDeletedDetails> {
    static void a(TextDeletedDetails paramTextDeletedDetails, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramTextDeletedDetails.a);
        c.a(paramParcel, 2, paramTextDeletedDetails.b);
        c.a(paramParcel, 3, paramTextDeletedDetails.c);
        c.a(paramParcel, paramInt);
    }

    public TextDeletedDetails a(Parcel paramParcel) {
        int k = 0;
        int m = a.b(paramParcel);
        int j = 0;
        int i = 0;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    i = a.g(paramParcel, n);
                    break;
                case 2:
                    j = a.g(paramParcel, n);
                    break;
                case 3:
                    k = a.g(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new TextDeletedDetails(i, j, k);
    }

    public TextDeletedDetails[] a(int paramInt) {
        return new TextDeletedDetails[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */