package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class v
        implements Parcelable.Creator<Value> {
    static void a(Value paramValue, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramValue.b());
        c.a(paramParcel, 1000, paramValue.e());
        c.a(paramParcel, 2, paramValue.a());
        c.a(paramParcel, 3, paramValue.f());
        c.a(paramParcel, paramInt);
    }

    public Value a(Parcel paramParcel) {
        boolean bool = false;
        int k = a.b(paramParcel);
        float f = 0.0F;
        int j = 0;
        int i = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    j = a.g(paramParcel, m);
                    break;
                case 1000:
                    i = a.g(paramParcel, m);
                    break;
                case 2:
                    bool = a.c(paramParcel, m);
                    break;
                case 3:
                    f = a.l(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new Value(i, j, bool, f);
    }

    public Value[] a(int paramInt) {
        return new Value[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */