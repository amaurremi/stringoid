package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.R.style;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentStyle
        implements SafeParcelable {
    public static final Parcelable.Creator<WalletFragmentStyle> CREATOR = new c();
    Bundle acT;
    int acU;
    final int xH;

    public WalletFragmentStyle() {
        this.xH = 1;
        this.acT = new Bundle();
    }

    WalletFragmentStyle(int paramInt1, Bundle paramBundle, int paramInt2) {
        this.xH = paramInt1;
        this.acT = paramBundle;
        this.acU = paramInt2;
    }

    private void a(TypedArray paramTypedArray, int paramInt, String paramString) {
        if (this.acT.containsKey(paramString)) {
        }
        do {
            return;
            paramTypedArray = paramTypedArray.peekValue(paramInt);
        } while (paramTypedArray == null);
        this.acT.putLong(paramString, Dimension.a(paramTypedArray));
    }

    private void a(TypedArray paramTypedArray, int paramInt, String paramString1, String paramString2) {
        if ((this.acT.containsKey(paramString1)) || (this.acT.containsKey(paramString2))) {
        }
        do {
            return;
            paramTypedArray = paramTypedArray.peekValue(paramInt);
        } while (paramTypedArray == null);
        if ((paramTypedArray.type >= 28) && (paramTypedArray.type <= 31)) {
            this.acT.putInt(paramString1, paramTypedArray.data);
            return;
        }
        this.acT.putInt(paramString2, paramTypedArray.resourceId);
    }

    private void b(TypedArray paramTypedArray, int paramInt, String paramString) {
        if (this.acT.containsKey(paramString)) {
        }
        do {
            return;
            paramTypedArray = paramTypedArray.peekValue(paramInt);
        } while (paramTypedArray == null);
        this.acT.putInt(paramString, paramTypedArray.data);
    }

    public void I(Context paramContext) {
        if (this.acU <= 0) {
        }
        for (int i = R.style.WalletFragmentDefaultStyle; ; i = this.acU) {
            paramContext = paramContext.obtainStyledAttributes(i, R.styleable.WalletFragmentStyle);
            a(paramContext, 1, "buyButtonWidth");
            a(paramContext, 0, "buyButtonHeight");
            b(paramContext, 2, "buyButtonText");
            b(paramContext, 3, "buyButtonAppearance");
            b(paramContext, 4, "maskedWalletDetailsTextAppearance");
            b(paramContext, 5, "maskedWalletDetailsHeaderTextAppearance");
            a(paramContext, 6, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
            b(paramContext, 7, "maskedWalletDetailsButtonTextAppearance");
            a(paramContext, 8, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
            b(paramContext, 9, "maskedWalletDetailsLogoTextColor");
            b(paramContext, 10, "maskedWalletDetailsLogoImageType");
            paramContext.recycle();
            return;
        }
    }

    public int a(String paramString, DisplayMetrics paramDisplayMetrics, int paramInt) {
        if (this.acT.containsKey(paramString)) {
            paramInt = Dimension.a(this.acT.getLong(paramString), paramDisplayMetrics);
        }
        return paramInt;
    }

    public int describeContents() {
        return 0;
    }

    public WalletFragmentStyle setBuyButtonAppearance(int paramInt) {
        this.acT.putInt("buyButtonAppearance", paramInt);
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int paramInt) {
        this.acT.putLong("buyButtonHeight", Dimension.cz(paramInt));
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int paramInt, float paramFloat) {
        this.acT.putLong("buyButtonHeight", Dimension.a(paramInt, paramFloat));
        return this;
    }

    public WalletFragmentStyle setBuyButtonText(int paramInt) {
        this.acT.putInt("buyButtonText", paramInt);
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int paramInt) {
        this.acT.putLong("buyButtonWidth", Dimension.cz(paramInt));
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int paramInt, float paramFloat) {
        this.acT.putLong("buyButtonWidth", Dimension.a(paramInt, paramFloat));
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int paramInt) {
        this.acT.remove("maskedWalletDetailsBackgroundResource");
        this.acT.putInt("maskedWalletDetailsBackgroundColor", paramInt);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int paramInt) {
        this.acT.remove("maskedWalletDetailsBackgroundColor");
        this.acT.putInt("maskedWalletDetailsBackgroundResource", paramInt);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int paramInt) {
        this.acT.remove("maskedWalletDetailsButtonBackgroundResource");
        this.acT.putInt("maskedWalletDetailsButtonBackgroundColor", paramInt);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int paramInt) {
        this.acT.remove("maskedWalletDetailsButtonBackgroundColor");
        this.acT.putInt("maskedWalletDetailsButtonBackgroundResource", paramInt);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int paramInt) {
        this.acT.putInt("maskedWalletDetailsButtonTextAppearance", paramInt);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int paramInt) {
        this.acT.putInt("maskedWalletDetailsHeaderTextAppearance", paramInt);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int paramInt) {
        this.acT.putInt("maskedWalletDetailsLogoImageType", paramInt);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int paramInt) {
        this.acT.putInt("maskedWalletDetailsLogoTextColor", paramInt);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int paramInt) {
        this.acT.putInt("maskedWalletDetailsTextAppearance", paramInt);
        return this;
    }

    public WalletFragmentStyle setStyleResourceId(int paramInt) {
        this.acU = paramInt;
        return this;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        c.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/wallet/fragment/WalletFragmentStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */