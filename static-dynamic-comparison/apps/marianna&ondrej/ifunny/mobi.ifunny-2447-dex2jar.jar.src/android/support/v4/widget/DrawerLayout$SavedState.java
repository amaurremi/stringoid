package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class DrawerLayout$SavedState
        extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new j();
    int a = 0;
    int b = 0;
    int c = 0;

    public DrawerLayout$SavedState(Parcel paramParcel) {
        super(paramParcel);
        this.a = paramParcel.readInt();
    }

    public DrawerLayout$SavedState(Parcelable paramParcelable) {
        super(paramParcelable);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeInt(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/widget/DrawerLayout$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */