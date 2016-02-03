package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragmentInitParams
  implements SafeParcelable
{
  public static final Parcelable.Creator<WalletFragmentInitParams> CREATOR = new a();
  private int akA;
  private MaskedWalletRequest akm;
  private MaskedWallet akn;
  final int xM;
  private String yQ;
  
  private WalletFragmentInitParams()
  {
    this.xM = 1;
    this.akA = -1;
  }
  
  WalletFragmentInitParams(int paramInt1, String paramString, MaskedWalletRequest paramMaskedWalletRequest, int paramInt2, MaskedWallet paramMaskedWallet)
  {
    this.xM = paramInt1;
    this.yQ = paramString;
    this.akm = paramMaskedWalletRequest;
    this.akA = paramInt2;
    this.akn = paramMaskedWallet;
  }
  
  public static WalletFragmentInitParams.Builder newBuilder()
  {
    WalletFragmentInitParams localWalletFragmentInitParams = new WalletFragmentInitParams();
    localWalletFragmentInitParams.getClass();
    return new WalletFragmentInitParams.Builder(localWalletFragmentInitParams, null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccountName()
  {
    return this.yQ;
  }
  
  public MaskedWallet getMaskedWallet()
  {
    return this.akn;
  }
  
  public MaskedWalletRequest getMaskedWalletRequest()
  {
    return this.akm;
  }
  
  public int getMaskedWalletRequestCode()
  {
    return this.akA;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/fragment/WalletFragmentInitParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */