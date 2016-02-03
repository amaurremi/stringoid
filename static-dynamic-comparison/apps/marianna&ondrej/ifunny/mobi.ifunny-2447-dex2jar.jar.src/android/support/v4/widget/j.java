package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class j
        implements Parcelable.Creator<DrawerLayout.SavedState> {
    public DrawerLayout.SavedState a(Parcel paramParcel) {
        return new DrawerLayout.SavedState(paramParcel);
    }

    public DrawerLayout.SavedState[] a(int paramInt) {
        return new DrawerLayout.SavedState[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/widget/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */