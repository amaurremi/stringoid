package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class a
        implements Parcelable.Creator<ObjectChangedDetails> {
    static void a(ObjectChangedDetails paramObjectChangedDetails, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramObjectChangedDetails.a);
        c.a(paramParcel, 2, paramObjectChangedDetails.b);
        c.a(paramParcel, 3, paramObjectChangedDetails.c);
        c.a(paramParcel, paramInt);
    }

    public ObjectChangedDetails a(Parcel paramParcel) {
        int k = 0;
        int m = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        int j = 0;
        int i = 0;
        while (paramParcel.dataPosition() < m) {
            int n = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(n)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, n);
                    break;
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
                    break;
                case 3:
                    k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new ObjectChangedDetails(i, j, k);
    }

    public ObjectChangedDetails[] a(int paramInt) {
        return new ObjectChangedDetails[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */