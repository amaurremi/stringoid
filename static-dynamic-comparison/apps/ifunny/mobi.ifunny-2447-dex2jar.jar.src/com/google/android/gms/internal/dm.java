package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.b.a;
import com.google.android.gms.b.b;
import com.google.android.gms.b.d;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ii
public final class dm
        implements SafeParcelable {
    public static final fp CREATOR = new fp();
    public final int a;
    public final dj b;
    public final td c;
    public final fq d;
    public final mz e;
    public final cf f;
    public final String g;
    public final boolean h;
    public final String i;
    public final fv j;
    public final int k;
    public final int l;
    public final String m;
    public final gt n;
    public final cq o;
    public final String p;
    public final x q;

    dm(int paramInt1, dj paramdj, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt2, int paramInt3, String paramString3, gt paramgt, IBinder paramIBinder6, String paramString4, x paramx) {
        this.a = paramInt1;
        this.b = paramdj;
        this.c = ((td) d.a(b.a(paramIBinder1)));
        this.d = ((fq) d.a(b.a(paramIBinder2)));
        this.e = ((mz) d.a(b.a(paramIBinder3)));
        this.f = ((cf) d.a(b.a(paramIBinder4)));
        this.g = paramString1;
        this.h = paramBoolean;
        this.i = paramString2;
        this.j = ((fv) d.a(b.a(paramIBinder5)));
        this.k = paramInt2;
        this.l = paramInt3;
        this.m = paramString3;
        this.n = paramgt;
        this.o = ((cq) d.a(b.a(paramIBinder6)));
        this.p = paramString4;
        this.q = paramx;
    }

    public dm(dj paramdj, td paramtd, fq paramfq, fv paramfv, gt paramgt) {
        this.a = 4;
        this.b = paramdj;
        this.c = paramtd;
        this.d = paramfq;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = null;
        this.j = paramfv;
        this.k = -1;
        this.l = 4;
        this.m = null;
        this.n = paramgt;
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public dm(td paramtd, fq paramfq, cf paramcf, fv paramfv, mz parammz, boolean paramBoolean, int paramInt, String paramString, gt paramgt, cq paramcq) {
        this.a = 4;
        this.b = null;
        this.c = paramtd;
        this.d = paramfq;
        this.e = parammz;
        this.f = paramcf;
        this.g = null;
        this.h = paramBoolean;
        this.i = null;
        this.j = paramfv;
        this.k = paramInt;
        this.l = 3;
        this.m = paramString;
        this.n = paramgt;
        this.o = paramcq;
        this.p = null;
        this.q = null;
    }

    public dm(td paramtd, fq paramfq, cf paramcf, fv paramfv, mz parammz, boolean paramBoolean, int paramInt, String paramString1, String paramString2, gt paramgt, cq paramcq) {
        this.a = 4;
        this.b = null;
        this.c = paramtd;
        this.d = paramfq;
        this.e = parammz;
        this.f = paramcf;
        this.g = paramString2;
        this.h = paramBoolean;
        this.i = paramString1;
        this.j = paramfv;
        this.k = paramInt;
        this.l = 3;
        this.m = null;
        this.n = paramgt;
        this.o = paramcq;
        this.p = null;
        this.q = null;
    }

    public dm(td paramtd, fq paramfq, fv paramfv, mz parammz, int paramInt, gt paramgt, String paramString, x paramx) {
        this.a = 4;
        this.b = null;
        this.c = paramtd;
        this.d = paramfq;
        this.e = parammz;
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = null;
        this.j = paramfv;
        this.k = paramInt;
        this.l = 1;
        this.m = null;
        this.n = paramgt;
        this.o = null;
        this.p = paramString;
        this.q = paramx;
    }

    public dm(td paramtd, fq paramfq, fv paramfv, mz parammz, boolean paramBoolean, int paramInt, gt paramgt) {
        this.a = 4;
        this.b = null;
        this.c = paramtd;
        this.d = paramfq;
        this.e = parammz;
        this.f = null;
        this.g = null;
        this.h = paramBoolean;
        this.i = null;
        this.j = paramfv;
        this.k = paramInt;
        this.l = 2;
        this.m = null;
        this.n = paramgt;
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public static dm a(Intent paramIntent) {
        try {
            paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            paramIntent.setClassLoader(dm.class.getClassLoader());
            paramIntent = (dm) paramIntent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            return paramIntent;
        } catch (Exception paramIntent) {
        }
        return null;
    }

    public static void a(Intent paramIntent, dm paramdm) {
        Bundle localBundle = new Bundle(1);
        localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", paramdm);
        paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
    }

    IBinder a() {
        return d.a(this.c).asBinder();
    }

    IBinder b() {
        return d.a(this.d).asBinder();
    }

    IBinder c() {
        return d.a(this.e).asBinder();
    }

    IBinder d() {
        return d.a(this.f).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    IBinder e() {
        return d.a(this.o).asBinder();
    }

    IBinder f() {
        return d.a(this.j).asBinder();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        fp.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/dm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */