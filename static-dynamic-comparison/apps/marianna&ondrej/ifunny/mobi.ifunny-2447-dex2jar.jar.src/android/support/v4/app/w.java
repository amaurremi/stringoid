package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class w
        implements Parcelable.Creator<FragmentManagerState> {
    public FragmentManagerState a(Parcel paramParcel) {
        return new FragmentManagerState(paramParcel);
    }

    public FragmentManagerState[] a(int paramInt) {
        return new FragmentManagerState[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */