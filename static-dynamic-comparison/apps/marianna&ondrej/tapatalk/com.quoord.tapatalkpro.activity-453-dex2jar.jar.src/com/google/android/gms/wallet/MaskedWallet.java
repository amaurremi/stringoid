package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet
        implements SafeParcelable {
    public static final Parcelable.Creator<MaskedWallet> CREATOR = new k();
    LoyaltyWalletObject[] abT;
    OfferWalletObject[] abU;
    String abh;
    String abi;
    String abk;
    Address abl;
    Address abm;
    String[] abn;
    UserAddress abo;
    UserAddress abp;
    InstrumentInfo[] abq;
    private final int xH;

    private MaskedWallet() {
        this.xH = 2;
    }

    MaskedWallet(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, Address paramAddress1, Address paramAddress2, LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject, OfferWalletObject[] paramArrayOfOfferWalletObject, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo) {
        this.xH = paramInt;
        this.abh = paramString1;
        this.abi = paramString2;
        this.abn = paramArrayOfString;
        this.abk = paramString3;
        this.abl = paramAddress1;
        this.abm = paramAddress2;
        this.abT = paramArrayOfLoyaltyWalletObject;
        this.abU = paramArrayOfOfferWalletObject;
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

    public LoyaltyWalletObject[] getLoyaltyWalletObjects() {
        return this.abT;
    }

    public String getMerchantTransactionId() {
        return this.abi;
    }

    public OfferWalletObject[] getOfferWalletObjects() {
        return this.abU;
    }

    public String[] getPaymentDescriptions() {
        return this.abn;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.abm;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        k.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/wallet/MaskedWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */