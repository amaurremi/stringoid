package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class FragmentTabHost$SavedState
        extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new z();
    String a;

    private FragmentTabHost$SavedState(Parcel paramParcel) {
        super(paramParcel);
        this.a = paramParcel.readString();
    }

    FragmentTabHost$SavedState(Parcelable paramParcelable) {
        super(paramParcelable);
    }

    public String toString() {
        return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.a + "}";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeString(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/FragmentTabHost$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */