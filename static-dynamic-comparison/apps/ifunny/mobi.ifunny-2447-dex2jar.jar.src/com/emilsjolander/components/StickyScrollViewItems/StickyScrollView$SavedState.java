package com.emilsjolander.components.StickyScrollViewItems;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class StickyScrollView$SavedState
        extends ClassLoaderSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new i();
    public boolean b;

    public StickyScrollView$SavedState(Parcel paramParcel) {
        super(paramParcel, StickyScrollView.class.getClassLoader());
        if (paramParcel.readInt() == 1) {
        }
        for (; ; ) {
            this.b = bool;
            return;
            bool = false;
        }
    }

    public StickyScrollView$SavedState(Parcelable paramParcelable) {
        super(paramParcelable, StickyScrollView.class.getClassLoader());
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        super.writeToParcel(paramParcel, paramInt);
        if (this.b) {
        }
        for (paramInt = 1; ; paramInt = 0) {
            paramParcel.writeInt(paramInt);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/emilsjolander/components/StickyScrollViewItems/StickyScrollView$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */