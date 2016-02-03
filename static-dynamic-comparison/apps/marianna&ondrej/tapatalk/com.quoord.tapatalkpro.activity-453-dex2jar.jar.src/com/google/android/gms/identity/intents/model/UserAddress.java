package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UserAddress
        implements SafeParcelable {
    public static final Parcelable.Creator<UserAddress> CREATOR = new b();
    String NB;
    String NC;
    String ND;
    String NE;
    String NF;
    String NG;
    String NH;
    String NI;
    String NJ;
    String NK;
    boolean NL;
    String NM;
    String NN;
    String name;
    String qd;
    private final int xH;

    UserAddress() {
        this.xH = 1;
    }

    UserAddress(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, boolean paramBoolean, String paramString13, String paramString14) {
        this.xH = paramInt;
        this.name = paramString1;
        this.NB = paramString2;
        this.NC = paramString3;
        this.ND = paramString4;
        this.NE = paramString5;
        this.NF = paramString6;
        this.NG = paramString7;
        this.NH = paramString8;
        this.qd = paramString9;
        this.NI = paramString10;
        this.NJ = paramString11;
        this.NK = paramString12;
        this.NL = paramBoolean;
        this.NM = paramString13;
        this.NN = paramString14;
    }

    public static UserAddress fromIntent(Intent paramIntent) {
        if ((paramIntent == null) || (!paramIntent.hasExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS"))) {
            return null;
        }
        return (UserAddress) paramIntent.getParcelableExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS");
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress1() {
        return this.NB;
    }

    public String getAddress2() {
        return this.NC;
    }

    public String getAddress3() {
        return this.ND;
    }

    public String getAddress4() {
        return this.NE;
    }

    public String getAddress5() {
        return this.NF;
    }

    public String getAdministrativeArea() {
        return this.NG;
    }

    public String getCompanyName() {
        return this.NM;
    }

    public String getCountryCode() {
        return this.qd;
    }

    public String getEmailAddress() {
        return this.NN;
    }

    public String getLocality() {
        return this.NH;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.NK;
    }

    public String getPostalCode() {
        return this.NI;
    }

    public String getSortingCode() {
        return this.NJ;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public boolean isPostBox() {
        return this.NL;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/identity/intents/model/UserAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */