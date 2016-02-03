package android.support.v7.internal.view.menu;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class ActionMenuPresenter$SavedState
        implements Parcelable {
    public static final Parcelable.Creator<SavedState> CREATOR = new i();
    public int a;

    ActionMenuPresenter$SavedState() {
    }

    ActionMenuPresenter$SavedState(Parcel paramParcel) {
        this.a = paramParcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeInt(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/view/menu/ActionMenuPresenter$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */