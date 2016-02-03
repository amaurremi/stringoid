package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class g
        implements Parcelable.Creator<ValueChangedDetails> {
    static void a(ValueChangedDetails paramValueChangedDetails, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramValueChangedDetails.a);
        c.a(paramParcel, 2, paramValueChangedDetails.b);
        c.a(paramParcel, paramInt);
    }

    public ValueChangedDetails a(Parcel paramParcel) {
        int j = 0;
        int k = a.b(paramParcel);
        int i = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    i = a.g(paramParcel, m);
                    break;
                case 2:
                    j = a.g(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new ValueChangedDetails(i, j);
    }

    public ValueChangedDetails[] a(int paramInt) {
        return new ValueChangedDetails[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */