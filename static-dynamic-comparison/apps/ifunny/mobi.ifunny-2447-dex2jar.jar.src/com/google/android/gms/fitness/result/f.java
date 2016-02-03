package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.q;

import java.util.ArrayList;

public class f
        implements Parcelable.Creator<SessionReadResult> {
    static void a(SessionReadResult paramSessionReadResult, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.c(paramParcel, 1, paramSessionReadResult.b(), false);
        c.a(paramParcel, 1000, paramSessionReadResult.d());
        c.c(paramParcel, 2, paramSessionReadResult.c(), false);
        c.a(paramParcel, 3, paramSessionReadResult.a(), paramInt, false);
        c.a(paramParcel, i);
    }

    public SessionReadResult a(Parcel paramParcel) {
        Status localStatus = null;
        int j = a.b(paramParcel);
        int i = 0;
        ArrayList localArrayList2 = null;
        ArrayList localArrayList1 = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    localArrayList1 = a.c(paramParcel, k, Session.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localArrayList2 = a.c(paramParcel, k, q.CREATOR);
                    break;
                case 3:
                    localStatus = (Status) a.a(paramParcel, k, Status.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new SessionReadResult(i, localArrayList1, localArrayList2, localStatus);
    }

    public SessionReadResult[] a(int paramInt) {
        return new SessionReadResult[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/result/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */