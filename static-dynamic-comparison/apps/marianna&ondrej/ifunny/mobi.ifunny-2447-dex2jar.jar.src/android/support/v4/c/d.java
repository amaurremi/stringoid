package android.support.v4.c;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

class d<T>
        implements Parcelable.ClassLoaderCreator<T> {
    private final c<T> a;

    public d(c<T> paramc) {
        this.a = paramc;
    }

    public T createFromParcel(Parcel paramParcel) {
        return (T) this.a.a(paramParcel, null);
    }

    public T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader) {
        return (T) this.a.a(paramParcel, paramClassLoader);
    }

    public T[] newArray(int paramInt) {
        return this.a.a(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */