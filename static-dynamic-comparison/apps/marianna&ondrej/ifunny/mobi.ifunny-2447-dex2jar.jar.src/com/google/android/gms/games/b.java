package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
        implements Parcelable.Creator<GameEntity> {
    static void a(GameEntity paramGameEntity, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramGameEntity.d_(), false);
        c.a(paramParcel, 2, paramGameEntity.e_(), false);
        c.a(paramParcel, 3, paramGameEntity.f_(), false);
        c.a(paramParcel, 4, paramGameEntity.e(), false);
        c.a(paramParcel, 5, paramGameEntity.f(), false);
        c.a(paramParcel, 6, paramGameEntity.g(), false);
        c.a(paramParcel, 7, paramGameEntity.h(), paramInt, false);
        c.a(paramParcel, 8, paramGameEntity.j(), paramInt, false);
        c.a(paramParcel, 9, paramGameEntity.l(), paramInt, false);
        c.a(paramParcel, 10, paramGameEntity.n());
        c.a(paramParcel, 11, paramGameEntity.q());
        c.a(paramParcel, 12, paramGameEntity.r(), false);
        c.a(paramParcel, 13, paramGameEntity.s());
        c.a(paramParcel, 14, paramGameEntity.t());
        c.a(paramParcel, 15, paramGameEntity.u());
        c.a(paramParcel, 17, paramGameEntity.w());
        c.a(paramParcel, 16, paramGameEntity.v());
        c.a(paramParcel, 1000, paramGameEntity.z());
        c.a(paramParcel, 19, paramGameEntity.k(), false);
        c.a(paramParcel, 18, paramGameEntity.i(), false);
        c.a(paramParcel, 21, paramGameEntity.o());
        c.a(paramParcel, 20, paramGameEntity.m(), false);
        c.a(paramParcel, 23, paramGameEntity.x());
        c.a(paramParcel, 22, paramGameEntity.p());
        c.a(paramParcel, 24, paramGameEntity.y(), false);
        c.a(paramParcel, i);
    }

    public GameEntity a(Parcel paramParcel) {
        int n = a.b(paramParcel);
        int m = 0;
        String str11 = null;
        String str10 = null;
        String str9 = null;
        String str8 = null;
        String str7 = null;
        String str6 = null;
        Uri localUri3 = null;
        Uri localUri2 = null;
        Uri localUri1 = null;
        boolean bool7 = false;
        boolean bool6 = false;
        String str5 = null;
        int k = 0;
        int j = 0;
        int i = 0;
        boolean bool5 = false;
        boolean bool4 = false;
        String str4 = null;
        String str3 = null;
        String str2 = null;
        boolean bool3 = false;
        boolean bool2 = false;
        boolean bool1 = false;
        String str1 = null;
        while (paramParcel.dataPosition() < n) {
            int i1 = a.a(paramParcel);
            switch (a.a(i1)) {
                default:
                    a.b(paramParcel, i1);
                    break;
                case 1:
                    str11 = a.o(paramParcel, i1);
                    break;
                case 2:
                    str10 = a.o(paramParcel, i1);
                    break;
                case 3:
                    str9 = a.o(paramParcel, i1);
                    break;
                case 4:
                    str8 = a.o(paramParcel, i1);
                    break;
                case 5:
                    str7 = a.o(paramParcel, i1);
                    break;
                case 6:
                    str6 = a.o(paramParcel, i1);
                    break;
                case 7:
                    localUri3 = (Uri) a.a(paramParcel, i1, Uri.CREATOR);
                    break;
                case 8:
                    localUri2 = (Uri) a.a(paramParcel, i1, Uri.CREATOR);
                    break;
                case 9:
                    localUri1 = (Uri) a.a(paramParcel, i1, Uri.CREATOR);
                    break;
                case 10:
                    bool7 = a.c(paramParcel, i1);
                    break;
                case 11:
                    bool6 = a.c(paramParcel, i1);
                    break;
                case 12:
                    str5 = a.o(paramParcel, i1);
                    break;
                case 13:
                    k = a.g(paramParcel, i1);
                    break;
                case 14:
                    j = a.g(paramParcel, i1);
                    break;
                case 15:
                    i = a.g(paramParcel, i1);
                    break;
                case 17:
                    bool4 = a.c(paramParcel, i1);
                    break;
                case 16:
                    bool5 = a.c(paramParcel, i1);
                    break;
                case 1000:
                    m = a.g(paramParcel, i1);
                    break;
                case 19:
                    str3 = a.o(paramParcel, i1);
                    break;
                case 18:
                    str4 = a.o(paramParcel, i1);
                    break;
                case 21:
                    bool3 = a.c(paramParcel, i1);
                    break;
                case 20:
                    str2 = a.o(paramParcel, i1);
                    break;
                case 23:
                    bool1 = a.c(paramParcel, i1);
                    break;
                case 22:
                    bool2 = a.c(paramParcel, i1);
                    break;
                case 24:
                    str1 = a.o(paramParcel, i1);
            }
        }
        if (paramParcel.dataPosition() != n) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + n, paramParcel);
        }
        return new GameEntity(m, str11, str10, str9, str8, str7, str6, localUri3, localUri2, localUri1, bool7, bool6, str5, k, j, i, bool5, bool4, str4, str3, str2, bool3, bool2, bool1, str1);
    }

    public GameEntity[] a(int paramInt) {
        return new GameEntity[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */