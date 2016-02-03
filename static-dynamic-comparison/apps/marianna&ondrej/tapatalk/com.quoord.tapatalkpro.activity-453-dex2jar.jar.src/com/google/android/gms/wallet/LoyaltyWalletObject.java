package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.jm;
import com.google.android.gms.internal.jo;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.ju;
import com.google.android.gms.internal.jw;
import com.google.android.gms.internal.jy;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public final class LoyaltyWalletObject
        implements SafeParcelable {
    public static final Parcelable.Creator<LoyaltyWalletObject> CREATOR = new j();
    String abA;
    String abB;
    String abC;
    String abD;
    String abE;
    String abF;
    String abG;
    String abH;
    ArrayList<jy> abI;
    ju abJ;
    ArrayList<LatLng> abK;
    String abL;
    String abM;
    ArrayList<jm> abN;
    boolean abO;
    ArrayList<jw> abP;
    ArrayList<js> abQ;
    ArrayList<jw> abR;
    jo abS;
    String abz;
    String eC;
    int state;
    private final int xH;

    LoyaltyWalletObject() {
        this.xH = 4;
        this.abI = gi.fs();
        this.abK = gi.fs();
        this.abN = gi.fs();
        this.abP = gi.fs();
        this.abQ = gi.fs();
        this.abR = gi.fs();
    }

    LoyaltyWalletObject(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt2, ArrayList<jy> paramArrayList, ju paramju, ArrayList<LatLng> paramArrayList1, String paramString11, String paramString12, ArrayList<jm> paramArrayList2, boolean paramBoolean, ArrayList<jw> paramArrayList3, ArrayList<js> paramArrayList4, ArrayList<jw> paramArrayList5, jo paramjo) {
        this.xH = paramInt1;
        this.eC = paramString1;
        this.abz = paramString2;
        this.abA = paramString3;
        this.abB = paramString4;
        this.abC = paramString5;
        this.abD = paramString6;
        this.abE = paramString7;
        this.abF = paramString8;
        this.abG = paramString9;
        this.abH = paramString10;
        this.state = paramInt2;
        this.abI = paramArrayList;
        this.abJ = paramju;
        this.abK = paramArrayList1;
        this.abL = paramString11;
        this.abM = paramString12;
        this.abN = paramArrayList2;
        this.abO = paramBoolean;
        this.abP = paramArrayList3;
        this.abQ = paramArrayList4;
        this.abR = paramArrayList5;
        this.abS = paramjo;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountId() {
        return this.abz;
    }

    public String getAccountName() {
        return this.abC;
    }

    public String getBarcodeAlternateText() {
        return this.abD;
    }

    public String getBarcodeType() {
        return this.abE;
    }

    public String getBarcodeValue() {
        return this.abF;
    }

    public String getId() {
        return this.eC;
    }

    public String getIssuerName() {
        return this.abA;
    }

    public String getProgramName() {
        return this.abB;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        j.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/wallet/LoyaltyWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */