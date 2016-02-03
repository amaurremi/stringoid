package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.c.a;
import android.view.View.BaseSavedState;

public class ViewPager$SavedState
        extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = a.a(new cj());
    int a;
    Parcelable b;
    ClassLoader c;

    ViewPager$SavedState(Parcel paramParcel, ClassLoader paramClassLoader) {
        super(paramParcel);
        ClassLoader localClassLoader = paramClassLoader;
        if (paramClassLoader == null) {
            localClassLoader = getClass().getClassLoader();
        }
        this.a = paramParcel.readInt();
        this.b = paramParcel.readParcelable(localClassLoader);
        this.c = localClassLoader;
    }

    public ViewPager$SavedState(Parcelable paramParcelable) {
        super(paramParcelable);
    }

    public String toString() {
        return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeInt(this.a);
        paramParcel.writeParcelable(this.b, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/view/ViewPager$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */