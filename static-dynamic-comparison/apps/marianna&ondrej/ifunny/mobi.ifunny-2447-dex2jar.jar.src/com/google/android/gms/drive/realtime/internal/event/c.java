package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

import java.util.ArrayList;

public class c
        implements Parcelable.Creator<ParcelableEventList> {
    static void a(ParcelableEventList paramParcelableEventList, Parcel paramParcel, int paramInt) {
        int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramParcelableEventList.a);
        com.google.android.gms.common.internal.safeparcel.c.c(paramParcel, 2, paramParcelableEventList.b, false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 3, paramParcelableEventList.c, paramInt, false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 4, paramParcelableEventList.d);
        com.google.android.gms.common.internal.safeparcel.c.b(paramParcel, 5, paramParcelableEventList.e, false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
    }

    public ParcelableEventList a(Parcel paramParcel) {
        boolean bool = false;
        ArrayList localArrayList1 = null;
        int j = a.b(paramParcel);
        DataHolder localDataHolder = null;
        ArrayList localArrayList2 = null;
        int i = 0;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localArrayList2 = a.c(paramParcel, k, ParcelableEvent.CREATOR);
                    break;
                case 3:
                    localDataHolder = (DataHolder) a.a(paramParcel, k, DataHolder.CREATOR);
                    break;
                case 4:
                    bool = a.c(paramParcel, k);
                    break;
                case 5:
                    localArrayList1 = a.C(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new ParcelableEventList(i, localArrayList2, localDataHolder, bool, localArrayList1);
    }

    public ParcelableEventList[] a(int paramInt) {
        return new ParcelableEventList[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */