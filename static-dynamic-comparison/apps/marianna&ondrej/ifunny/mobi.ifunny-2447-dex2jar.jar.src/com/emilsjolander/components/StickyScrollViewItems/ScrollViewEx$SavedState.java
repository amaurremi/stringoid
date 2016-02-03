package com.emilsjolander.components.StickyScrollViewItems;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class ScrollViewEx$SavedState
        extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new e();
    public int a;

    public ScrollViewEx$SavedState(Parcel paramParcel) {
        super(paramParcel);
        this.a = paramParcel.readInt();
    }

    ScrollViewEx$SavedState(Parcelable paramParcelable) {
        super(paramParcelable);
    }

    public String toString() {
        return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.a + "}";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeInt(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/emilsjolander/components/StickyScrollViewItems/ScrollViewEx$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */