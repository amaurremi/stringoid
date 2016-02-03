package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class e
        implements Parcelable.Creator<ParticipantResult> {
    static void a(ParticipantResult paramParticipantResult, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramParticipantResult.b(), false);
        c.a(paramParcel, 1000, paramParticipantResult.a());
        c.a(paramParcel, 2, paramParticipantResult.c());
        c.a(paramParcel, 3, paramParticipantResult.d());
        c.a(paramParcel, paramInt);
    }

    public ParticipantResult a(Parcel paramParcel) {
        int k = 0;
        int m = a.b(paramParcel);
        String str = null;
        int j = 0;
        int i = 0;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    str = a.o(paramParcel, n);
                    break;
                case 1000:
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
        return new ParticipantResult(i, str, j, k);
    }

    public ParticipantResult[] a(int paramInt) {
        return new ParticipantResult[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */