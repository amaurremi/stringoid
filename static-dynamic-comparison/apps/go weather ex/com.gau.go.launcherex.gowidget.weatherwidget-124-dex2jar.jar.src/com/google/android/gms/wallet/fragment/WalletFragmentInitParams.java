package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fq;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragmentInitParams
  implements SafeParcelable
{
  public static final Parcelable.Creator<WalletFragmentInitParams> CREATOR = new a();
  private MaskedWalletRequest acB;
  private int acO;
  private MaskedWallet acP;
  private String wG;
  final int xH;
  
  private WalletFragmentInitParams()
  {
    this.xH = 1;
    this.acO = -1;
  }
  
  WalletFragmentInitParams(int paramInt1, String paramString, MaskedWalletRequest paramMaskedWalletRequest, int paramInt2, MaskedWallet paramMaskedWallet)
  {
    this.xH = paramInt1;
    this.wG = paramString;
    this.acB = paramMaskedWalletRequest;
    this.acO = paramInt2;
    this.acP = paramMaskedWallet;
  }
  
  public static Builder newBuilder()
  {
    WalletFragmentInitParams localWalletFragmentInitParams = new WalletFragmentInitParams();
    localWalletFragmentInitParams.getClass();
    return new Builder(null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccountName()
  {
    return this.wG;
  }
  
  public MaskedWallet getMaskedWallet()
  {
    return this.acP;
  }
  
  public MaskedWalletRequest getMaskedWalletRequest()
  {
    return this.acB;
  }
  
  public int getMaskedWalletRequestCode()
  {
    return this.acO;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public WalletFragmentInitParams build()
    {
      boolean bool2 = true;
      if (((WalletFragmentInitParams.a(WalletFragmentInitParams.this) != null) && (WalletFragmentInitParams.b(WalletFragmentInitParams.this) == null)) || ((WalletFragmentInitParams.a(WalletFragmentInitParams.this) == null) && (WalletFragmentInitParams.b(WalletFragmentInitParams.this) != null)))
      {
        bool1 = true;
        fq.a(bool1, "Exactly one of MaskedWallet or MaskedWalletRequest is required");
        if (WalletFragmentInitParams.c(WalletFragmentInitParams.this) < 0) {
          break label78;
        }
      }
      label78:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        fq.a(bool1, "masked wallet request code is required and must be non-negative");
        return WalletFragmentInitParams.this;
        bool1 = false;
        break;
      }
    }
    
    public Builder setAccountName(String paramString)
    {
      WalletFragmentInitParams.a(WalletFragmentInitParams.this, paramString);
      return this;
    }
    
    public Builder setMaskedWallet(MaskedWallet paramMaskedWallet)
    {
      WalletFragmentInitParams.a(WalletFragmentInitParams.this, paramMaskedWallet);
      return this;
    }
    
    public Builder setMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
    {
      WalletFragmentInitParams.a(WalletFragmentInitParams.this, paramMaskedWalletRequest);
      return this;
    }
    
    public Builder setMaskedWalletRequestCode(int paramInt)
    {
      WalletFragmentInitParams.a(WalletFragmentInitParams.this, paramInt);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/wallet/fragment/WalletFragmentInitParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */