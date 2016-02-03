package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;

import java.util.Arrays;

public class h
        implements SafeParcelable {
    public static final j CREATOR = new j();
    private final String[] Uk;
    private final String[] Ul;
    private final String[] Um;
    private final String Un;
    private final String Uo;
    private final String Up;
    private final String Uq;
    private final PlusCommonExtras Ur;
    private final String wG;
    private final int xH;

    h(int paramInt, String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, String paramString5, PlusCommonExtras paramPlusCommonExtras) {
        this.xH = paramInt;
        this.wG = paramString1;
        this.Uk = paramArrayOfString1;
        this.Ul = paramArrayOfString2;
        this.Um = paramArrayOfString3;
        this.Un = paramString2;
        this.Uo = paramString3;
        this.Up = paramString4;
        this.Uq = paramString5;
        this.Ur = paramPlusCommonExtras;
    }

    public h(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, PlusCommonExtras paramPlusCommonExtras) {
        this.xH = 1;
        this.wG = paramString1;
        this.Uk = paramArrayOfString1;
        this.Ul = paramArrayOfString2;
        this.Um = paramArrayOfString3;
        this.Un = paramString2;
        this.Uo = paramString3;
        this.Up = paramString4;
        this.Uq = null;
        this.Ur = paramPlusCommonExtras;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof h)) {
        }
        do {
            return false;
            paramObject = (h) paramObject;
        }
        while ((this.xH != ((h) paramObject).xH) || (!fo.equal(this.wG, ((h) paramObject).wG)) || (!Arrays.equals(this.Uk, ((h) paramObject).Uk)) || (!Arrays.equals(this.Ul, ((h) paramObject).Ul)) || (!Arrays.equals(this.Um, ((h) paramObject).Um)) || (!fo.equal(this.Un, ((h) paramObject).Un)) || (!fo.equal(this.Uo, ((h) paramObject).Uo)) || (!fo.equal(this.Up, ((h) paramObject).Up)) || (!fo.equal(this.Uq, ((h) paramObject).Uq)) || (!fo.equal(this.Ur, ((h) paramObject).Ur)));
        return true;
    }

    public String getAccountName() {
        return this.wG;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public int hashCode() {
        return fo.hashCode(new Object[]{Integer.valueOf(this.xH), this.wG, this.Uk, this.Ul, this.Um, this.Un, this.Uo, this.Up, this.Uq, this.Ur});
    }

    public String[] iP() {
        return this.Uk;
    }

    public String[] iQ() {
        return this.Ul;
    }

    public String[] iR() {
        return this.Um;
    }

    public String iS() {
        return this.Un;
    }

    public String iT() {
        return this.Uo;
    }

    public String iU() {
        return this.Up;
    }

    public String iV() {
        return this.Uq;
    }

    public PlusCommonExtras iW() {
        return this.Ur;
    }

    public Bundle iX() {
        Bundle localBundle = new Bundle();
        localBundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.Ur.m(localBundle);
        return localBundle;
    }

    public String toString() {
        return fo.e(this).a("versionCode", Integer.valueOf(this.xH)).a("accountName", this.wG).a("requestedScopes", this.Uk).a("visibleActivities", this.Ul).a("requiredFeatures", this.Um).a("packageNameForAuth", this.Un).a("callingPackageName", this.Uo).a("applicationName", this.Up).a("extra", this.Ur.toString()).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        j.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/plus/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */