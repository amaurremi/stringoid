package com.emilsjolander.components.StickyScrollViewItems;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public abstract class ClassLoaderSavedState
        implements Parcelable {
    public static final Parcelable.Creator<ClassLoaderSavedState> CREATOR = new a();
    public static final ClassLoaderSavedState a = new ClassLoaderSavedState
    .1();
    private Parcelable b = a;
    private ClassLoader c;

    private ClassLoaderSavedState() {
        this.b = null;
        this.c = null;
    }

    protected ClassLoaderSavedState(Parcel paramParcel, ClassLoader paramClassLoader) {
        this.c = paramClassLoader;
        paramParcel = paramParcel.readParcelable(this.c);
        if (paramParcel != null) {
        }
        for (; ; ) {
            this.b = paramParcel;
            return;
            paramParcel = a;
        }
    }

    protected ClassLoaderSavedState(Parcelable paramParcelable, ClassLoader paramClassLoader) {
        this.c = paramClassLoader;
        if (paramParcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (paramParcelable != a) {
        }
        for (; ; ) {
            this.b = paramParcelable;
            return;
            paramParcelable = null;
        }
    }

    public final Parcelable a() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeParcelable(this.b, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/emilsjolander/components/StickyScrollViewItems/ClassLoaderSavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */