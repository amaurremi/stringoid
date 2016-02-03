package android.support.v7.internal.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class AbsSpinnerICS$SavedState
        extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new e();
    long a;
    int b;

    private AbsSpinnerICS$SavedState(Parcel paramParcel) {
        super(paramParcel);
        this.a = paramParcel.readLong();
        this.b = paramParcel.readInt();
    }

    AbsSpinnerICS$SavedState(Parcelable paramParcelable) {
        super(paramParcelable);
    }

    public String toString() {
        return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.a + " position=" + this.b + "}";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeLong(this.a);
        paramParcel.writeInt(this.b);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/AbsSpinnerICS$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */