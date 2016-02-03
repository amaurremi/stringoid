package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ag;

public abstract class i
        implements Parcelable {
    private volatile transient boolean a = false;

    protected abstract void a(Parcel paramParcel, int paramInt);

    public final boolean a() {
        return this.a;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        if (!a()) {
        }
        for (boolean bool = true; ; bool = false) {
            ag.a(bool);
            this.a = true;
            a(paramParcel, paramInt);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */