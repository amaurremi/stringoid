package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState
        implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new w();
    FragmentState[] a;
    int[] b;
    BackStackState[] c;

    public FragmentManagerState() {
    }

    public FragmentManagerState(Parcel paramParcel) {
        this.a = ((FragmentState[]) paramParcel.createTypedArray(FragmentState.CREATOR));
        this.b = paramParcel.createIntArray();
        this.c = ((BackStackState[]) paramParcel.createTypedArray(BackStackState.CREATOR));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeTypedArray(this.a, paramInt);
        paramParcel.writeIntArray(this.b);
        paramParcel.writeTypedArray(this.c, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/FragmentManagerState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */