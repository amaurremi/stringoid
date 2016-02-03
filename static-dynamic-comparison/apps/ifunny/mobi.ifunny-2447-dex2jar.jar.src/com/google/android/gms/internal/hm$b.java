package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;

public class hm$b
        implements r, SafeParcelable {
    public static final oe CREATOR = new oe();
    public Status a;
    public List<hs> b;
    final int c;

    public hm$b() {
        this.c = 1;
    }

    hm$b(int paramInt, Status paramStatus, List<hs> paramList) {
        this.c = paramInt;
        this.a = paramStatus;
        this.b = paramList;
    }

    public Status a() {
        return this.a;
    }

    public int describeContents() {
        oe localoe = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        oe localoe = CREATOR;
        oe.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/hm$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */