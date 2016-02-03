package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class cx
        implements SafeParcelable {
    public static final cy CREATOR = new cy();
    public final ApplicationInfo applicationInfo;
    public final String kH;
    public final dx kK;
    public final ak kN;
    public final Bundle pf;
    public final ah pg;
    public final PackageInfo ph;
    public final String pi;
    public final String pj;
    public final String pk;
    public final Bundle pl;
    public final int versionCode;

    cx(int paramInt, Bundle paramBundle1, ah paramah, ak paramak, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, dx paramdx, Bundle paramBundle2) {
        this.versionCode = paramInt;
        this.pf = paramBundle1;
        this.pg = paramah;
        this.kN = paramak;
        this.kH = paramString1;
        this.applicationInfo = paramApplicationInfo;
        this.ph = paramPackageInfo;
        this.pi = paramString2;
        this.pj = paramString3;
        this.pk = paramString4;
        this.kK = paramdx;
        this.pl = paramBundle2;
    }

    public cx(Bundle paramBundle1, ah paramah, ak paramak, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, dx paramdx, Bundle paramBundle2) {
        this(2, paramBundle1, paramah, paramak, paramString1, paramApplicationInfo, paramPackageInfo, paramString2, paramString3, paramString4, paramdx, paramBundle2);
    }

    public cx(a parama, String paramString) {
        this(parama.pf, parama.pg, parama.kN, parama.kH, parama.applicationInfo, parama.ph, paramString, parama.pj, parama.pk, parama.kK, parama.pl);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        cy.a(this, paramParcel, paramInt);
    }

    public static final class a {
        public final ApplicationInfo applicationInfo;
        public final String kH;
        public final dx kK;
        public final ak kN;
        public final Bundle pf;
        public final ah pg;
        public final PackageInfo ph;
        public final String pj;
        public final String pk;
        public final Bundle pl;

        public a(Bundle paramBundle1, ah paramah, ak paramak, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, dx paramdx, Bundle paramBundle2) {
            this.pf = paramBundle1;
            this.pg = paramah;
            this.kN = paramak;
            this.kH = paramString1;
            this.applicationInfo = paramApplicationInfo;
            this.ph = paramPackageInfo;
            this.pj = paramString2;
            this.pk = paramString3;
            this.kK = paramdx;
            this.pl = paramBundle2;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */