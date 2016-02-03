package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FieldWithSortOrder
        implements SafeParcelable {
    public static final c CREATOR = new c();
    final String FM;
    final boolean GJ;
    final int xH;

    FieldWithSortOrder(int paramInt, String paramString, boolean paramBoolean) {
        this.xH = paramInt;
        this.FM = paramString;
        this.GJ = paramBoolean;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        c.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/query/internal/FieldWithSortOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */