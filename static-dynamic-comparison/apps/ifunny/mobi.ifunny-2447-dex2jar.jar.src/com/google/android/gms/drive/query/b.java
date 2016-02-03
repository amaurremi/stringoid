package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;

import java.util.ArrayList;

public class b
        implements Parcelable.Creator<SortOrder> {
    static void a(SortOrder paramSortOrder, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1000, paramSortOrder.c);
        c.c(paramParcel, 1, paramSortOrder.a, false);
        c.a(paramParcel, 2, paramSortOrder.b);
        c.a(paramParcel, paramInt);
    }

    public SortOrder a(Parcel paramParcel) {
        boolean bool = false;
        int j = a.b(paramParcel);
        ArrayList localArrayList = null;
        int i = 0;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 1:
                    localArrayList = a.c(paramParcel, k, FieldWithSortOrder.CREATOR);
                    break;
                case 2:
                    bool = a.c(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + j, paramParcel);
        }
        return new SortOrder(i, localArrayList, bool);
    }

    public SortOrder[] a(int paramInt) {
        return new SortOrder[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */