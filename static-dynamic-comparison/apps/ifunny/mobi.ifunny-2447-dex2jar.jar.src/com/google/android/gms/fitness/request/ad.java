package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;

import java.util.ArrayList;
import java.util.List;

public class ad
        implements Parcelable.Creator<SessionInsertRequest> {
    static void a(SessionInsertRequest paramSessionInsertRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramSessionInsertRequest.a(), paramInt, false);
        c.a(paramParcel, 1000, paramSessionInsertRequest.d());
        c.c(paramParcel, 2, paramSessionInsertRequest.b(), false);
        c.c(paramParcel, 3, paramSessionInsertRequest.c(), false);
        c.a(paramParcel, i);
    }

    public SessionInsertRequest a(Parcel paramParcel) {
        ArrayList localArrayList = null;
        int j = a.b(paramParcel);
        int i = 0;
        Object localObject2 = null;
        Object localObject1 = null;
        if (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            Object localObject3;
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    localObject3 = localObject2;
                    localObject2 = localObject1;
                    localObject1 = localObject3;
            }
            for (; ; ) {
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject3;
                break;
                localObject3 = (Session) a.a(paramParcel, k, Session.CREATOR);
                localObject1 = localObject2;
                localObject2 = localObject3;
                continue;
                i = a.g(paramParcel, k);
                localObject3 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject3;
                continue;
                localObject3 = a.c(paramParcel, k, DataSet.CREATOR);
                localObject2 = localObject1;
                localObject1 = localObject3;
                continue;
                localArrayList = a.c(paramParcel, k, DataPoint.CREATOR);
                localObject3 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject3;
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new SessionInsertRequest(i, (Session) localObject1, (List) localObject2, localArrayList);
    }

    public SessionInsertRequest[] a(int paramInt) {
        return new SessionInsertRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */