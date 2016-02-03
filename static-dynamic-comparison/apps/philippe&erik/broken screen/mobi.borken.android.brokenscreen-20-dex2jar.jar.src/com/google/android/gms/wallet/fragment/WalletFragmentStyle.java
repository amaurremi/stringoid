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
  implements SafeParcelable
{
  public static final Parcelable.Creator<WalletFragmentStyle> CREATOR = new c();
  Bundle akB;
  int akC;
  final int xJ;
  
  public WalletFragmentStyle()
  {
    this.xJ = 1;
    this.akB = new Bundle();
  }
  
  WalletFragmentStyle(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    this.xJ = paramInt1;
    this.akB = paramBundle;
    this.akC = paramInt2;
  }
  
  private void a(TypedArray paramTypedArray, int paramInt, String paramString)
  {
    if (this.akB.containsKey(paramString)) {}
    do
    {
      return;
      paramTypedArray = paramTypedArray.peekValue(paramInt);
    } while (paramTypedArray == null);
    this.akB.putLong(paramString, Dimension.a(paramTypedArray));
  }
  
  private void a(TypedArray paramTypedArray, int paramInt, String paramString1, String paramString2)
  {
    if ((this.akB.containsKey(paramString1)) || (this.akB.containsKey(paramString2))) {}
    do
    {
      return;
      paramTypedArray = paramTypedArray.peekValue(paramInt);
    } while (paramTypedArray == null);
    if ((paramTypedArray.type >= 28) && (paramTypedArray.type <= 31))
    {
      this.akB.putInt(paramString1, paramTypedArray.data);
      return;
    }
    this.akB.putInt(paramString2, paramTypedArray.resourceId);
  }
  
  private void b(TypedArray paramTypedArray, int paramInt, String paramString)
  {
    if (this.akB.containsKey(paramString)) {}
    do
    {
      return;
      paramTypedArray = paramTypedArray.peekValue(paramInt);
    } while (paramTypedArray == null);
    this.akB.putInt(paramString, paramTypedArray.data);
  }
  
  public void N(Context paramContext)
  {
    if (this.akC <= 0) {}
    for (int i = R.style.WalletFragmentDefaultStyle;; i = this.akC)
    {
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
  
  public int a(String paramString, DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    if (this.akB.containsKey(paramString)) {
      paramInt = Dimension.a(this.akB.getLong(paramString), paramDisplayMetrics);
    }
    return paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public WalletFragmentStyle setBuyButtonAppearance(int paramInt)
  {
    this.akB.putInt("buyButtonAppearance", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonHeight(int paramInt)
  {
    this.akB.putLong("buyButtonHeight", Dimension.dM(paramInt));
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonHeight(int paramInt, float paramFloat)
  {
    this.akB.putLong("buyButtonHeight", Dimension.a(paramInt, paramFloat));
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonText(int paramInt)
  {
    this.akB.putInt("buyButtonText", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonWidth(int paramInt)
  {
    this.akB.putLong("buyButtonWidth", Dimension.dM(paramInt));
    return this;
  }
  
  public WalletFragmentStyle setBuyButtonWidth(int paramInt, float paramFloat)
  {
    this.akB.putLong("buyButtonWidth", Dimension.a(paramInt, paramFloat));
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int paramInt)
  {
    this.akB.remove("maskedWalletDetailsBackgroundResource");
    this.akB.putInt("maskedWalletDetailsBackgroundColor", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int paramInt)
  {
    this.akB.remove("maskedWalletDetailsBackgroundColor");
    this.akB.putInt("maskedWalletDetailsBackgroundResource", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int paramInt)
  {
    this.akB.remove("maskedWalletDetailsButtonBackgroundResource");
    this.akB.putInt("maskedWalletDetailsButtonBackgroundColor", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int paramInt)
  {
    this.akB.remove("maskedWalletDetailsButtonBackgroundColor");
    this.akB.putInt("maskedWalletDetailsButtonBackgroundResource", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int paramInt)
  {
    this.akB.putInt("maskedWalletDetailsButtonTextAppearance", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int paramInt)
  {
    this.akB.putInt("maskedWalletDetailsHeaderTextAppearance", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int paramInt)
  {
    this.akB.putInt("maskedWalletDetailsLogoImageType", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int paramInt)
  {
    this.akB.putInt("maskedWalletDetailsLogoTextColor", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int paramInt)
  {
    this.akB.putInt("maskedWalletDetailsTextAppearance", paramInt);
    return this;
  }
  
  public WalletFragmentStyle setStyleResourceId(int paramInt)
  {
    this.akC = paramInt;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wallet/fragment/WalletFragmentStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */