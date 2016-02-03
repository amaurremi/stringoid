package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class f
        implements Parcelable.Creator<DataSet> {
    static void a(DataSet paramDataSet, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramDataSet.a(), paramInt, false);
        c.a(paramParcel, 1000, paramDataSet.d());
        c.a(paramParcel, 2, paramDataSet.b(), paramInt, false);
        c.d(paramParcel, 3, paramDataSet.e(), false);
        c.c(paramParcel, 4, paramDataSet.f(), false);
        c.a(paramParcel, 5, paramDataSet.c());
        c.a(paramParcel, i);
    }

    public DataSet a(Parcel paramParcel) {
        boolean bool = false;
        ArrayList localArrayList1 = null;
        int j = a.b(paramParcel);
        ArrayList localArrayList2 = new ArrayList();
        DataType localDataType = null;
        DataSource localDataSource = null;
        int i = 0;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    localDataSource = (DataSource) a.a(paramParcel, k, DataSource.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localDataType = (DataType) a.a(paramParcel, k, DataType.CREATOR);
                    break;
                case 3:
                    a.a(paramParcel, k, localArrayList2, getClass().getClassLoader());
                    break;
                case 4:
                    localArrayList1 = a.c(paramParcel, k, DataSource.CREATOR);
                    break;
                case 5:
                    bool = a.c(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new DataSet(i, localDataSource, localDataType, localArrayList2, localArrayList1, bool);
    }

    public DataSet[] a(int paramInt) {
        return new DataSet[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */