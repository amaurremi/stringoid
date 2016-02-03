package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;

import java.util.Collections;
import java.util.List;

public class StartBleScanRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<StartBleScanRequest> CREATOR = new c();
    private final int a;
    private final List<DataType> b;
    private final s c;
    private final int d;

    StartBleScanRequest(int paramInt1, List<DataType> paramList, IBinder paramIBinder, int paramInt2) {
        this.a = paramInt1;
        this.b = paramList;
        this.c = u.a(paramIBinder);
        this.d = paramInt2;
    }

    public List<DataType> a() {
        return Collections.unmodifiableList(this.b);
    }

    public IBinder b() {
        return this.c.asBinder();
    }

    public int c() {
        return this.d;
    }

    int d() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ad.a(this).a("dataTypes", this.b).a("timeoutSecs", Integer.valueOf(this.d)).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        c.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/StartBleScanRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */