package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataType;

import java.util.ArrayList;

public class c
        implements Parcelable.Creator<StartBleScanRequest> {
    static void a(StartBleScanRequest paramStartBleScanRequest, Parcel paramParcel, int paramInt) {
        paramInt = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
        com.google.android.gms.common.internal.safeparcel.c.c(paramParcel, 1, paramStartBleScanRequest.a(), false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1000, paramStartBleScanRequest.d());
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramStartBleScanRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramStartBleScanRequest.c());
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, paramInt);
    }

    public StartBleScanRequest a(Parcel paramParcel) {
        IBinder localIBinder = null;
        int j = 0;
        int k = a.b(paramParcel);
        ArrayList localArrayList = null;
        int i = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    localArrayList = a.c(paramParcel, m, DataType.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, m);
                    break;
                case 2:
                    localIBinder = a.p(paramParcel, m);
                    break;
                case 3:
                    j = a.g(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new StartBleScanRequest(i, localArrayList, localIBinder, j);
    }

    public StartBleScanRequest[] a(int paramInt) {
        return new StartBleScanRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */