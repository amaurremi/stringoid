package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class SlidingPaneLayout$SavedState
        extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new x();
    boolean a;

    private SlidingPaneLayout$SavedState(Parcel paramParcel) {
        super(paramParcel);
        if (paramParcel.readInt() != 0) {
        }
        for (boolean bool = true; ; bool = false) {
            this.a = bool;
            return;
        }
    }

    SlidingPaneLayout$SavedState(Parcelable paramParcelable) {
        super(paramParcelable);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        super.writeToParcel(paramParcel, paramInt);
        if (this.a) {
        }
        for (paramInt = 1; ; paramInt = 0) {
            paramParcel.writeInt(paramInt);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/widget/SlidingPaneLayout$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */