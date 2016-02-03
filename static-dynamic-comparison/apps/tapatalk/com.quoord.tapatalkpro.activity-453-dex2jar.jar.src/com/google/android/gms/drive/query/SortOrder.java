package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;

import java.util.List;

public class SortOrder
        implements SafeParcelable {
    public static final Parcelable.Creator<SortOrder> CREATOR = new b();
    final List<FieldWithSortOrder> GF;
    final int xH;

    SortOrder(int paramInt, List<FieldWithSortOrder> paramList) {
        this.xH = paramInt;
        this.GF = paramList;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/query/SortOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */