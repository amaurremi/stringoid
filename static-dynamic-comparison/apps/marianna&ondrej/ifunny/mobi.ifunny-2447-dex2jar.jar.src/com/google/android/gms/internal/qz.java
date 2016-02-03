package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.location.LocationRequest;

import java.util.List;

public class qz
        implements Parcelable.Creator<lz> {
    static void a(lz paramlz, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramlz.b, paramInt, false);
        c.a(paramParcel, 1000, paramlz.a());
        c.a(paramParcel, 2, paramlz.c);
        c.a(paramParcel, 3, paramlz.d);
        c.a(paramParcel, 4, paramlz.e);
        c.c(paramParcel, 5, paramlz.f, false);
        c.a(paramParcel, 6, paramlz.g, false);
        c.a(paramParcel, i);
    }

    public lz a(Parcel paramParcel) {
        String str = null;
        boolean bool1 = true;
        boolean bool3 = false;
        int j = a.b(paramParcel);
        Object localObject = lz.a;
        boolean bool2 = true;
        LocationRequest localLocationRequest = null;
        int i = 0;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    localLocationRequest = (LocationRequest) a.a(paramParcel, k, LocationRequest.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    bool3 = a.c(paramParcel, k);
                    break;
                case 3:
                    bool2 = a.c(paramParcel, k);
                    break;
                case 4:
                    bool1 = a.c(paramParcel, k);
                    break;
                case 5:
                    localObject = a.c(paramParcel, k, lr.CREATOR);
                    break;
                case 6:
                    str = a.o(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new lz(i, localLocationRequest, bool3, bool2, bool1, (List) localObject, str);
    }

    public lz[] a(int paramInt) {
        return new lz[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/qz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */