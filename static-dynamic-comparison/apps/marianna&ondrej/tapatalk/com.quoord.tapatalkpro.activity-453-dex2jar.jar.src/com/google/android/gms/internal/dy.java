package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class dy
        implements Parcelable.Creator<dx> {
    static void a(dx paramdx, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.c(paramParcel, 1, paramdx.versionCode);
        b.a(paramParcel, 2, paramdx.rq, false);
        b.c(paramParcel, 3, paramdx.rr);
        b.c(paramParcel, 4, paramdx.rs);
        b.a(paramParcel, 5, paramdx.rt);
        b.F(paramParcel, paramInt);
    }

    public dx h(Parcel paramParcel) {
        boolean bool = false;
        int m = a.o(paramParcel);
        String str = null;
        int i = 0;
        int j = 0;
        int k = 0;
        while (paramParcel.dataPosition() < m) {
            int n = a.n(paramParcel);
            switch (a.R(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    str = a.n(paramParcel, n);
                    break;
                case 3:
                    j = a.g(paramParcel, n);
                    break;
                case 4:
                    i = a.g(paramParcel, n);
                    break;
                case 5:
                    bool = a.c(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new a.a("Overread allowed size end=" + m, paramParcel);
        }
        return new dx(k, str, j, i, bool);
    }

    public dx[] o(int paramInt) {
        return new dx[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */