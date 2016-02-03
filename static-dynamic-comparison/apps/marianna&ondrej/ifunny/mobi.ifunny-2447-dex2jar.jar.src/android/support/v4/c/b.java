package android.support.v4.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class b<T>
        implements Parcelable.Creator<T> {
    final c<T> a;

    public b(c<T> paramc) {
        this.a = paramc;
    }

    public T createFromParcel(Parcel paramParcel) {
        return (T) this.a.a(paramParcel, null);
    }

    public T[] newArray(int paramInt) {
        return this.a.a(paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */