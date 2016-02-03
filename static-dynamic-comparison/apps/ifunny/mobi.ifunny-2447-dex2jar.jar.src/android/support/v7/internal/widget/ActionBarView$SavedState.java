package android.support.v7.internal.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class ActionBarView$SavedState
        extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new k();
    int a;
    boolean b;

    private ActionBarView$SavedState(Parcel paramParcel) {
        super(paramParcel);
        this.a = paramParcel.readInt();
        if (paramParcel.readInt() != 0) {
        }
        for (boolean bool = true; ; bool = false) {
            this.b = bool;
            return;
        }
    }

    ActionBarView$SavedState(Parcelable paramParcelable) {
        super(paramParcelable);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeInt(this.a);
        if (this.b) {
        }
        for (paramInt = 1; ; paramInt = 0) {
            paramParcel.writeInt(paramInt);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/ActionBarView$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */