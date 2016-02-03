package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.k;
import com.google.android.gms.fitness.data.l;

public class p
        implements SafeParcelable {
    public static final Parcelable.Creator<p> CREATOR = new ab();
    private final int a;
    private final k b;
    private final PendingIntent c;

    p(int paramInt, IBinder paramIBinder, PendingIntent paramPendingIntent) {
        this.a = paramInt;
        if (paramIBinder == null) {
        }
        for (paramIBinder = null; ; paramIBinder = l.a(paramIBinder)) {
            this.b = paramIBinder;
            this.c = paramPendingIntent;
            return;
        }
    }

    public PendingIntent a() {
        return this.c;
    }

    int b() {
        return this.a;
    }

    IBinder c() {
        if (this.b == null) {
            return null;
        }
        return this.b.asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("SensorUnregistrationRequest{%s}", new Object[]{this.b});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ab.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */