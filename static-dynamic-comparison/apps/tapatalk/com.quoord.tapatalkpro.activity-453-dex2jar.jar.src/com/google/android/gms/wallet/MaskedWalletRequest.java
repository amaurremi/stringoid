package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new l();
    boolean abV;
    boolean abW;
    boolean abX;
    String abY;
    String abZ;
    String abd;
    String abi;
    Cart abr;
    boolean aca;
    boolean acb;
    CountrySpecification[] acc;
    boolean acd;
    boolean ace;
    ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> acf;
    private final int xH;

    MaskedWalletRequest() {
        this.xH = 3;
        this.acd = true;
        this.ace = true;
    }

    MaskedWalletRequest(int paramInt, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4, Cart paramCart, boolean paramBoolean4, boolean paramBoolean5, CountrySpecification[] paramArrayOfCountrySpecification, boolean paramBoolean6, boolean paramBoolean7, ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> paramArrayList) {
        this.xH = paramInt;
        this.abi = paramString1;
        this.abV = paramBoolean1;
        this.abW = paramBoolean2;
        this.abX = paramBoolean3;
        this.abY = paramString2;
        this.abd = paramString3;
        this.abZ = paramString4;
        this.abr = paramCart;
        this.aca = paramBoolean4;
        this.acb = paramBoolean5;
        this.acc = paramArrayOfCountrySpecification;
        this.acd = paramBoolean6;
        this.ace = paramBoolean7;
        this.acf = paramArrayList;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest localMaskedWalletRequest = new MaskedWalletRequest();
        localMaskedWalletRequest.getClass();
        return new Builder(null);
    }

    public boolean allowDebitCard() {
        return this.ace;
    }

    public boolean allowPrepaidCard() {
        return this.acd;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.acf;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.acc;
    }

    public Cart getCart() {
        return this.abr;
    }

    public String getCurrencyCode() {
        return this.abd;
    }

    public String getEstimatedTotalPrice() {
        return this.abY;
    }

    public String getMerchantName() {
        return this.abZ;
    }

    public String getMerchantTransactionId() {
        return this.abi;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public boolean isBillingAgreement() {
        return this.acb;
    }

    public boolean isPhoneNumberRequired() {
        return this.abV;
    }

    public boolean isShippingAddressRequired() {
        return this.abW;
    }

    public boolean shouldRetrieveWalletObjects() {
        return this.aca;
    }

    public boolean useMinimalBillingAddress() {
        return this.abX;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        l.a(this, paramParcel, paramInt);
    }

    public final class Builder {
        private Builder() {
        }

        public Builder addAllowedCountrySpecificationForShipping(com.google.android.gms.identity.intents.model.CountrySpecification paramCountrySpecification) {
            if (MaskedWalletRequest.this.acf == null) {
                MaskedWalletRequest.this.acf = new ArrayList();
            }
            MaskedWalletRequest.this.acf.add(paramCountrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecificationsForShipping(Collection<com.google.android.gms.identity.intents.model.CountrySpecification> paramCollection) {
            if (paramCollection != null) {
                if (MaskedWalletRequest.this.acf == null) {
                    MaskedWalletRequest.this.acf = new ArrayList();
                }
                MaskedWalletRequest.this.acf.addAll(paramCollection);
            }
            return this;
        }

        public MaskedWalletRequest build() {
            return MaskedWalletRequest.this;
        }

        public Builder setAllowDebitCard(boolean paramBoolean) {
            MaskedWalletRequest.this.ace = paramBoolean;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean paramBoolean) {
            MaskedWalletRequest.this.acd = paramBoolean;
            return this;
        }

        public Builder setCart(Cart paramCart) {
            MaskedWalletRequest.this.abr = paramCart;
            return this;
        }

        public Builder setCurrencyCode(String paramString) {
            MaskedWalletRequest.this.abd = paramString;
            return this;
        }

        public Builder setEstimatedTotalPrice(String paramString) {
            MaskedWalletRequest.this.abY = paramString;
            return this;
        }

        public Builder setIsBillingAgreement(boolean paramBoolean) {
            MaskedWalletRequest.this.acb = paramBoolean;
            return this;
        }

        public Builder setMerchantName(String paramString) {
            MaskedWalletRequest.this.abZ = paramString;
            return this;
        }

        public Builder setMerchantTransactionId(String paramString) {
            MaskedWalletRequest.this.abi = paramString;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean paramBoolean) {
            MaskedWalletRequest.this.abV = paramBoolean;
            return this;
        }

        public Builder setShippingAddressRequired(boolean paramBoolean) {
            MaskedWalletRequest.this.abW = paramBoolean;
            return this;
        }

        public Builder setShouldRetrieveWalletObjects(boolean paramBoolean) {
            MaskedWalletRequest.this.aca = paramBoolean;
            return this;
        }

        public Builder setUseMinimalBillingAddress(boolean paramBoolean) {
            MaskedWalletRequest.this.abX = paramBoolean;
            return this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/wallet/MaskedWalletRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */