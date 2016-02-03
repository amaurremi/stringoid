package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.d.a;
import com.google.android.gms.dynamic.e;

public final class ce
        implements SafeParcelable {
    public static final cd CREATOR = new cd();
    public final dx kK;
    public final String nO;
    public final cb og;
    public final u oh;
    public final cf oi;
    public final dz oj;
    public final az ok;
    public final String ol;
    public final boolean om;
    public final String on;
    public final ci oo;
    public final int op;
    public final bc oq;
    public final String or;
    public final int orientation;
    public final int versionCode;

    ce(int paramInt1, cb paramcb, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt2, int paramInt3, String paramString3, dx paramdx, IBinder paramIBinder6, String paramString4) {
        this.versionCode = paramInt1;
        this.og = paramcb;
        this.oh = ((u) e.d(d.a.K(paramIBinder1)));
        this.oi = ((cf) e.d(d.a.K(paramIBinder2)));
        this.oj = ((dz) e.d(d.a.K(paramIBinder3)));
        this.ok = ((az) e.d(d.a.K(paramIBinder4)));
        this.ol = paramString1;
        this.om = paramBoolean;
        this.on = paramString2;
        this.oo = ((ci) e.d(d.a.K(paramIBinder5)));
        this.orientation = paramInt2;
        this.op = paramInt3;
        this.nO = paramString3;
        this.kK = paramdx;
        this.oq = ((bc) e.d(d.a.K(paramIBinder6)));
        this.or = paramString4;
    }

    public ce(cb paramcb, u paramu, cf paramcf, ci paramci, dx paramdx) {
        this.versionCode = 3;
        this.og = paramcb;
        this.oh = paramu;
        this.oi = paramcf;
        this.oj = null;
        this.ok = null;
        this.ol = null;
        this.om = false;
        this.on = null;
        this.oo = paramci;
        this.orientation = -1;
        this.op = 4;
        this.nO = null;
        this.kK = paramdx;
        this.oq = null;
        this.or = null;
    }

    public ce(u paramu, cf paramcf, az paramaz, ci paramci, dz paramdz, boolean paramBoolean, int paramInt, String paramString, dx paramdx, bc parambc) {
        this.versionCode = 3;
        this.og = null;
        this.oh = paramu;
        this.oi = paramcf;
        this.oj = paramdz;
        this.ok = paramaz;
        this.ol = null;
        this.om = paramBoolean;
        this.on = null;
        this.oo = paramci;
        this.orientation = paramInt;
        this.op = 3;
        this.nO = paramString;
        this.kK = paramdx;
        this.oq = parambc;
        this.or = null;
    }

    public ce(u paramu, cf paramcf, az paramaz, ci paramci, dz paramdz, boolean paramBoolean, int paramInt, String paramString1, String paramString2, dx paramdx, bc parambc) {
        this.versionCode = 3;
        this.og = null;
        this.oh = paramu;
        this.oi = paramcf;
        this.oj = paramdz;
        this.ok = paramaz;
        this.ol = paramString2;
        this.om = paramBoolean;
        this.on = paramString1;
        this.oo = paramci;
        this.orientation = paramInt;
        this.op = 3;
        this.nO = null;
        this.kK = paramdx;
        this.oq = parambc;
        this.or = null;
    }

    public ce(u paramu, cf paramcf, ci paramci, dz paramdz, int paramInt, dx paramdx, String paramString) {
        this.versionCode = 3;
        this.og = null;
        this.oh = paramu;
        this.oi = paramcf;
        this.oj = paramdz;
        this.ok = null;
        this.ol = null;
        this.om = false;
        this.on = null;
        this.oo = paramci;
        this.orientation = paramInt;
        this.op = 1;
        this.nO = null;
        this.kK = paramdx;
        this.oq = null;
        this.or = paramString;
    }

    public ce(u paramu, cf paramcf, ci paramci, dz paramdz, boolean paramBoolean, int paramInt, dx paramdx) {
        this.versionCode = 3;
        this.og = null;
        this.oh = paramu;
        this.oi = paramcf;
        this.oj = paramdz;
        this.ok = null;
        this.ol = null;
        this.om = paramBoolean;
        this.on = null;
        this.oo = paramci;
        this.orientation = paramInt;
        this.op = 2;
        this.nO = null;
        this.kK = paramdx;
        this.oq = null;
        this.or = null;
    }

    public static ce a(Intent paramIntent) {
        try {
            paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            paramIntent.setClassLoader(ce.class.getClassLoader());
            paramIntent = (ce) paramIntent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            return paramIntent;
        } catch (Exception paramIntent) {
        }
        return null;
    }

    public static void a(Intent paramIntent, ce paramce) {
        Bundle localBundle = new Bundle(1);
        localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", paramce);
        paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
    }

    IBinder aO() {
        return e.h(this.oh).asBinder();
    }

    IBinder aP() {
        return e.h(this.oi).asBinder();
    }

    IBinder aQ() {
        return e.h(this.oj).asBinder();
    }

    IBinder aR() {
        return e.h(this.ok).asBinder();
    }

    IBinder aS() {
        return e.h(this.oq).asBinder();
    }

    IBinder aT() {
        return e.h(this.oo).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        cd.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */