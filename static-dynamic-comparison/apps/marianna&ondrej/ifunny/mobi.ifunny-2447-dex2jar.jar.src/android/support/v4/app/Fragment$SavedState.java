package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Fragment$SavedState
        implements Parcelable {
    public static final Parcelable.Creator<SavedState> CREATOR = new j();
    final Bundle a;

    Fragment$SavedState(Bundle paramBundle) {
        this.a = paramBundle;
    }

    Fragment$SavedState(Parcel paramParcel, ClassLoader paramClassLoader) {
        this.a = paramParcel.readBundle();
        if ((paramClassLoader != null) && (this.a != null)) {
            this.a.setClassLoader(paramClassLoader);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeBundle(this.a);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/app/Fragment$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */