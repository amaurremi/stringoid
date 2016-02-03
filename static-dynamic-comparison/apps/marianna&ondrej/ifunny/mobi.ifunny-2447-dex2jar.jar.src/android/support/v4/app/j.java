package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class j
        implements Parcelable.Creator<Fragment.SavedState> {
    public Fragment.SavedState a(Parcel paramParcel) {
        return new Fragment.SavedState(paramParcel, null);
    }

    public Fragment.SavedState[] a(int paramInt) {
        return new Fragment.SavedState[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */