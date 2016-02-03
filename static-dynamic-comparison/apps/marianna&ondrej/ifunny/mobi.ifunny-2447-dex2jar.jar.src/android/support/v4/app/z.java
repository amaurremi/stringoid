package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class z
        implements Parcelable.Creator<FragmentTabHost.SavedState> {
    public FragmentTabHost.SavedState a(Parcel paramParcel) {
        return new FragmentTabHost.SavedState(paramParcel, null);
    }

    public FragmentTabHost.SavedState[] a(int paramInt) {
        return new FragmentTabHost.SavedState[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */