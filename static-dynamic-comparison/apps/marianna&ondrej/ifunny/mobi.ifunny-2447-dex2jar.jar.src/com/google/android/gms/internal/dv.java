package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.b.a;
import com.google.android.gms.b.b;
import com.google.android.gms.b.d;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ii
public final class dv
        implements SafeParcelable {
    public static final ge CREATOR = new ge();
    public final int a;
    public final hh b;
    public final gq c;
    public final gs d;
    public final Context e;

    dv(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4) {
        this.a = paramInt;
        this.b = ((hh) d.a(b.a(paramIBinder1)));
        this.c = ((gq) d.a(b.a(paramIBinder2)));
        this.d = ((gs) d.a(b.a(paramIBinder3)));
        this.e = ((Context) d.a(b.a(paramIBinder4)));
    }

    public dv(gs paramgs, hh paramhh, gq paramgq, Context paramContext) {
        this.a = 1;
        this.d = paramgs;
        this.b = paramhh;
        this.c = paramgq;
        this.e = paramContext;
    }

    public static dv a(Intent paramIntent) {
        try {
            paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            paramIntent.setClassLoader(dv.class.getClassLoader());
            paramIntent = (dv) paramIntent.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            return paramIntent;
        } catch (Exception paramIntent) {
        }
        return null;
    }

    public static void a(Intent paramIntent, dv paramdv) {
        Bundle localBundle = new Bundle(1);
        localBundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", paramdv);
        paramIntent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", localBundle);
    }

    IBinder a() {
        return d.a(this.b).asBinder();
    }

    IBinder b() {
        return d.a(this.c).asBinder();
    }

    IBinder c() {
        return d.a(this.d).asBinder();
    }

    IBinder d() {
        return d.a(this.e).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ge.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */