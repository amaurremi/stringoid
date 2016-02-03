package com.etsy.android.grid;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class StaggeredGridView$GridListSavedState
        extends ExtendableListView.ListSavedState {
    public static final Parcelable.Creator<GridListSavedState> CREATOR = new s();
    int g;
    int[] h;

    public StaggeredGridView$GridListSavedState(Parcel paramParcel) {
        super(paramParcel);
        this.g = paramParcel.readInt();
        if (this.g >= 0) {
        }
        for (int i = this.g; ; i = 0) {
            this.h = new int[i];
            paramParcel.readIntArray(this.h);
            return;
        }
    }

    public StaggeredGridView$GridListSavedState(Parcelable paramParcelable) {
        super(paramParcelable);
    }

    public String toString() {
        return "StaggeredGridView.GridListSavedState{" + Integer.toHexString(System.identityHashCode(this)) + "}";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeInt(this.g);
        paramParcel.writeIntArray(this.h);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/etsy/android/grid/StaggeredGridView$GridListSavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */