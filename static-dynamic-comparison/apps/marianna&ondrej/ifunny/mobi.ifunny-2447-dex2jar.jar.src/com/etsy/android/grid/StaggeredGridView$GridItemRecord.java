package com.etsy.android.grid;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class StaggeredGridView$GridItemRecord
        implements Parcelable {
    public static final Parcelable.Creator<GridItemRecord> CREATOR = new q();
    int a;
    double b;
    boolean c;

    StaggeredGridView$GridItemRecord() {
    }

    private StaggeredGridView$GridItemRecord(Parcel paramParcel) {
        this.a = paramParcel.readInt();
        this.b = paramParcel.readDouble();
        if (paramParcel.readByte() == 1) {
        }
        for (; ; ) {
            this.c = bool;
            return;
            bool = false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "GridItemRecord.ListSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " column:" + this.a + " heightRatio:" + this.b + " isHeaderFooter:" + this.c + "}";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeInt(this.a);
        paramParcel.writeDouble(this.b);
        if (this.c) {
        }
        for (paramInt = 1; ; paramInt = 0) {
            paramParcel.writeByte((byte) paramInt);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/etsy/android/grid/StaggeredGridView$GridItemRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */