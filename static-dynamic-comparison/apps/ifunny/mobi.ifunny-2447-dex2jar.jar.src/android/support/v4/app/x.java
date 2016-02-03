package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class x
        implements Parcelable.Creator<FragmentState> {
    public FragmentState a(Parcel paramParcel) {
        return new FragmentState(paramParcel);
    }

    public FragmentState[] a(int paramInt) {
        return new FragmentState[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */