package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<WalletFragmentOptions> CREATOR = new b();
  private int Hy;
  private WalletFragmentStyle akC;
  private int akb;
  private int mTheme;
  final int xM;
  
  private WalletFragmentOptions()
  {
    this.xM = 1;
  }
  
  WalletFragmentOptions(int paramInt1, int paramInt2, int paramInt3, WalletFragmentStyle paramWalletFragmentStyle, int paramInt4)
  {
    this.xM = paramInt1;
    this.akb = paramInt2;
    this.mTheme = paramInt3;
    this.akC = paramWalletFragmentStyle;
    this.Hy = paramInt4;
  }
  
  public static WalletFragmentOptions a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WalletFragmentOptions);
    int i = paramAttributeSet.getInt(0, 0);
    int j = paramAttributeSet.getInt(1, 1);
    int k = paramAttributeSet.getResourceId(2, 0);
    int m = paramAttributeSet.getInt(3, 1);
    paramAttributeSet.recycle();
    paramAttributeSet = new WalletFragmentOptions();
    paramAttributeSet.mTheme = i;
    paramAttributeSet.akb = j;
    paramAttributeSet.akC = new WalletFragmentStyle().setStyleResourceId(k);
    paramAttributeSet.akC.Q(paramContext);
    paramAttributeSet.Hy = m;
    return paramAttributeSet;
  }
  
  public static WalletFragmentOptions.Builder newBuilder()
  {
    WalletFragmentOptions localWalletFragmentOptions = new WalletFragmentOptions();
    localWalletFragmentOptions.getClass();
    return new WalletFragmentOptions.Builder(localWalletFragmentOptions, null);
  }
  
  public void Q(Context paramContext)
  {
    if (this.akC != null) {
      this.akC.Q(paramContext);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getEnvironment()
  {
    return this.akb;
  }
  
  public WalletFragmentStyle getFragmentStyle()
  {
    return this.akC;
  }
  
  public int getMode()
  {
    return this.Hy;
  }
  
  public int getTheme()
  {
    return this.mTheme;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/fragment/WalletFragmentOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */