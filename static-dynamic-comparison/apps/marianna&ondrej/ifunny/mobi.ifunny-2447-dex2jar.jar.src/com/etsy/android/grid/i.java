package com.etsy.android.grid;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class i
        implements Parcelable.Creator<ExtendableListView.ListSavedState> {
    public ExtendableListView.ListSavedState a(Parcel paramParcel) {
        return new ExtendableListView.ListSavedState(paramParcel);
    }

    public ExtendableListView.ListSavedState[] a(int paramInt) {
        return new ExtendableListView.ListSavedState[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/etsy/android/grid/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */