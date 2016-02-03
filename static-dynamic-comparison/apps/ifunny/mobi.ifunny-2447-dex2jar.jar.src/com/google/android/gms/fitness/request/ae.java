package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Subscription;

public class ae
        implements SafeParcelable {
    public static final Parcelable.Creator<ae> CREATOR = new e();
    private final int a;
    private final Subscription b;
    private final boolean c;

    ae(int paramInt, Subscription paramSubscription, boolean paramBoolean) {
        this.a = paramInt;
        this.b = paramSubscription;
        this.c = paramBoolean;
    }

    public Subscription a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    int c() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ad.a(this).a("subscription", this.b).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        e.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */