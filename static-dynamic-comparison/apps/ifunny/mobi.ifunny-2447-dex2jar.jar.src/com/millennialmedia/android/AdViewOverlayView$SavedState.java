package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class AdViewOverlayView$SavedState
        extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new AdViewOverlayView.SavedState
    .1();
    String a;
    public Object customInlineLayoutParams;

    private AdViewOverlayView$SavedState(Parcel paramParcel) {
        super(paramParcel);
        this.a = paramParcel.readString();
    }

    AdViewOverlayView$SavedState(Parcelable paramParcelable) {
        super(paramParcelable);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeString(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/AdViewOverlayView$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */