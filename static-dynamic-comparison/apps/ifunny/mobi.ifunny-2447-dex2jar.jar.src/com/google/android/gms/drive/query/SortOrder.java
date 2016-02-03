package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;

import java.util.List;
import java.util.Locale;

public class SortOrder
        implements SafeParcelable {
    public static final Parcelable.Creator<SortOrder> CREATOR = new b();
    final List<FieldWithSortOrder> a;
    final boolean b;
    final int c;

    SortOrder(int paramInt, List<FieldWithSortOrder> paramList, boolean paramBoolean) {
        this.c = paramInt;
        this.a = paramList;
        this.b = paramBoolean;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "SortOrder[%s, %s]", new Object[]{TextUtils.join(",", this.a), Boolean.valueOf(this.b)});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/SortOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */