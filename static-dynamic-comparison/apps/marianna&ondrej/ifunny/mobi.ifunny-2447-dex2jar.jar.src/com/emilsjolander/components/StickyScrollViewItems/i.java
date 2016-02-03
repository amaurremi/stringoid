package com.emilsjolander.components.StickyScrollViewItems;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class i
        implements Parcelable.Creator<StickyScrollView.SavedState> {
    public StickyScrollView.SavedState a(Parcel paramParcel) {
        return new StickyScrollView.SavedState(paramParcel);
    }

    public StickyScrollView.SavedState[] a(int paramInt) {
        return new StickyScrollView.SavedState[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/emilsjolander/components/StickyScrollViewItems/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */