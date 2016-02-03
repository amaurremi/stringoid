package com.etsy.android.grid;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class q
        implements Parcelable.Creator<StaggeredGridView.GridItemRecord> {
    public StaggeredGridView.GridItemRecord a(Parcel paramParcel) {
        return new StaggeredGridView.GridItemRecord(paramParcel, null);
    }

    public StaggeredGridView.GridItemRecord[] a(int paramInt) {
        return new StaggeredGridView.GridItemRecord[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/etsy/android/grid/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */