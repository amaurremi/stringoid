package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ae
        implements Parcelable.Creator<OnListParentsResponse> {
    static void a(OnListParentsResponse paramOnListParentsResponse, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1, paramOnListParentsResponse.xH);
        b.a(paramParcel, 2, paramOnListParentsResponse.FK, paramInt, false);
        b.F(paramParcel, i);
    }

    public OnListParentsResponse S(Parcel paramParcel) {
        int j = a.o(paramParcel);
        int i = 0;
        DataHolder localDataHolder = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            switch (a.R(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localDataHolder = (DataHolder) a.a(paramParcel, k, DataHolder.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new OnListParentsResponse(i, localDataHolder);
    }

    public OnListParentsResponse[] aw(int paramInt) {
        return new OnListParentsResponse[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */