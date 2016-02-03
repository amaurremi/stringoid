package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class g
        implements Parcelable.Creator<DataHolder> {
    static void a(DataHolder paramDataHolder, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramDataHolder.c(), false);
        c.a(paramParcel, 1000, paramDataHolder.b());
        c.a(paramParcel, 2, paramDataHolder.d(), paramInt, false);
        c.a(paramParcel, 3, paramDataHolder.e());
        c.a(paramParcel, 4, paramDataHolder.f(), false);
        c.a(paramParcel, i);
    }

    public DataHolder a(Parcel paramParcel) {
        int i = 0;
        Bundle localBundle = null;
        int k = a.b(paramParcel);
        CursorWindow[] arrayOfCursorWindow = null;
        String[] arrayOfString = null;
        int j = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    arrayOfString = a.A(paramParcel, m);
                    break;
                case 1000:
                    j = a.g(paramParcel, m);
                    break;
                case 2:
                    arrayOfCursorWindow = (CursorWindow[]) a.b(paramParcel, m, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = a.g(paramParcel, m);
                    break;
                case 4:
                    localBundle = a.q(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        paramParcel = new DataHolder(j, arrayOfString, arrayOfCursorWindow, i, localBundle);
        paramParcel.a();
        return paramParcel;
    }

    public DataHolder[] a(int paramInt) {
        return new DataHolder[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/data/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */