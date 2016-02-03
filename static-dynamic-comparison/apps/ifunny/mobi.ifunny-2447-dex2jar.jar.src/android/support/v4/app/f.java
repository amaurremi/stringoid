package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class f
        implements Parcelable.Creator<BackStackState> {
    public BackStackState a(Parcel paramParcel) {
        return new BackStackState(paramParcel);
    }

    public BackStackState[] a(int paramInt) {
        return new BackStackState[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */