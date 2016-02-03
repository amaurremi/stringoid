package com.etsy.android.grid;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
        implements Parcelable.Creator<ClassLoaderSavedState> {
    public ClassLoaderSavedState a(Parcel paramParcel) {
        if (paramParcel.readParcelable(null) != null) {
            throw new IllegalStateException("superState must be null");
        }
        return ClassLoaderSavedState.a;
    }

    public ClassLoaderSavedState[] a(int paramInt) {
        return new ClassLoaderSavedState[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/etsy/android/grid/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */