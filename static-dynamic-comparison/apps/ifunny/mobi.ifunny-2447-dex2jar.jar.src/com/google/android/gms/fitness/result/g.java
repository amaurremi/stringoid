package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.Session;

import java.util.ArrayList;

public class g
        implements Parcelable.Creator<SessionStopResult> {
    static void a(SessionStopResult paramSessionStopResult, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1000, paramSessionStopResult.c());
        c.a(paramParcel, 2, paramSessionStopResult.a(), paramInt, false);
        c.c(paramParcel, 3, paramSessionStopResult.b(), false);
        c.a(paramParcel, i);
    }

    public SessionStopResult a(Parcel paramParcel) {
        ArrayList localArrayList = null;
        int j = a.b(paramParcel);
        int i = 0;
        Status localStatus = null;
        if (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
            }
            for (; ; ) {
                break;
                i = a.g(paramParcel, k);
                continue;
                localStatus = (Status) a.a(paramParcel, k, Status.CREATOR);
                continue;
                localArrayList = a.c(paramParcel, k, Session.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new SessionStopResult(i, localStatus, localArrayList);
    }

    public SessionStopResult[] a(int paramInt) {
        return new SessionStopResult[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/result/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */