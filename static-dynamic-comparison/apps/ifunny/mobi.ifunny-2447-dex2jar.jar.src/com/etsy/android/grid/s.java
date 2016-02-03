package com.etsy.android.grid;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class s
        implements Parcelable.Creator<StaggeredGridView.GridListSavedState> {
    public StaggeredGridView.GridListSavedState a(Parcel paramParcel) {
        return new StaggeredGridView.GridListSavedState(paramParcel);
    }

    public StaggeredGridView.GridListSavedState[] a(int paramInt) {
        return new StaggeredGridView.GridListSavedState[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/etsy/android/grid/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */