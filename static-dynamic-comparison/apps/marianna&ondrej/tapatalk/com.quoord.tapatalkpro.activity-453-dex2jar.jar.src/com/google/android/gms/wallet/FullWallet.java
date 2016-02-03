package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet
        implements SafeParcelable {
    public static final Parcelable.Creator<FullWallet> CREATOR = new f();
    String abh;
    String abi;
    ProxyCard abj;
    String abk;
    Address abl;
    Address abm;
    String[] abn;
    UserAddress abo;
    UserAddress abp;
    InstrumentInfo[] abq;
    private final int xH;

    private FullWallet() {
        this.xH = 1;
    }

    FullWallet(int paramInt, String paramString1, String paramString2, ProxyCard paramProxyCard, String paramString3, Address paramAddress1, Address paramAddress2, String[] paramArrayOfString, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo) {
        this.xH = paramInt;
        this.abh = paramString1;
        this.abi = paramString2;
        this.abj = paramProxyCard;
        this.abk = paramString3;
        this.abl = paramAddress1;
        this.abm = paramAddress2;
        this.abn = paramArrayOfString;
        this.abo = paramUserAddress1;
        this.abp = paramUserAddress2;
        this.abq = paramArrayOfInstrumentInfo;
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public Address getBillingAddress() {
        return this.abl;
    }

    public UserAddress getBuyerBillingAddress() {
        return this.abo;
    }

    public UserAddress getBuyerShippingAddress() {
        return this.abp;
    }

    public String getEmail() {
        return this.abk;
    }

    public String getGoogleTransactionId() {
        return this.abh;
    }

    public InstrumentInfo[] getInstrumentInfos() {
        return this.abq;
    }

    public String getMerchantTransactionId() {
        return this.abi;
    }

    public String[] getPaymentDescriptions() {
        return this.abn;
    }

    public ProxyCard getProxyCard() {
        return this.abj;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.abm;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        f.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/wallet/FullWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */