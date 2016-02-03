package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.iu;

public final class Wallet
{
  public static final Api API = new Api(jO, new Scope[0]);
  static final Api.b<iu> jO = new Api.b()
  {
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
    
    public iu h(Context paramAnonymousContext, dt paramAnonymousdt, GoogleApiClient.ApiOptions paramAnonymousApiOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      eg.b(paramAnonymousContext instanceof Activity, "An Activity must be used for Wallet APIs");
      Activity localActivity = (Activity)paramAnonymousContext;
      boolean bool;
      if ((paramAnonymousApiOptions == null) || ((paramAnonymousApiOptions instanceof Wallet.WalletOptions)))
      {
        bool = true;
        eg.b(bool, "WalletOptions must be used for Wallet APIs");
        if (paramAnonymousApiOptions == null) {
          break label77;
        }
      }
      label77:
      for (paramAnonymousContext = (Wallet.WalletOptions)paramAnonymousApiOptions;; paramAnonymousContext = new Wallet.WalletOptions(null))
      {
        return new iu(localActivity, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymousContext.environment, paramAnonymousdt.getAccountName(), paramAnonymousContext.theme);
        bool = false;
        break;
      }
    }
  };
  
  public static void changeMaskedWallet(GoogleApiClient paramGoogleApiClient, String paramString1, final String paramString2, final int paramInt)
  {
    paramGoogleApiClient.a(new a()
    {
      protected void a(iu paramAnonymousiu)
      {
        paramAnonymousiu.changeMaskedWallet(this.Hf, paramString2, paramInt);
        a(Status.nA);
      }
    });
  }
  
  public static void checkForPreAuthorization(GoogleApiClient paramGoogleApiClient, int paramInt)
  {
    paramGoogleApiClient.a(new a()
    {
      protected void a(iu paramAnonymousiu)
      {
        paramAnonymousiu.checkForPreAuthorization(this.Hc);
        a(Status.nA);
      }
    });
  }
  
  public static void loadFullWallet(GoogleApiClient paramGoogleApiClient, FullWalletRequest paramFullWalletRequest, final int paramInt)
  {
    paramGoogleApiClient.a(new a()
    {
      protected void a(iu paramAnonymousiu)
      {
        paramAnonymousiu.loadFullWallet(this.He, paramInt);
        a(Status.nA);
      }
    });
  }
  
  public static void loadMaskedWallet(GoogleApiClient paramGoogleApiClient, MaskedWalletRequest paramMaskedWalletRequest, final int paramInt)
  {
    paramGoogleApiClient.a(new a()
    {
      protected void a(iu paramAnonymousiu)
      {
        paramAnonymousiu.loadMaskedWallet(this.Hd, paramInt);
        a(Status.nA);
      }
    });
  }
  
  public static void notifyTransactionStatus(GoogleApiClient paramGoogleApiClient, NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest)
  {
    paramGoogleApiClient.a(new a()
    {
      protected void a(iu paramAnonymousiu)
      {
        paramAnonymousiu.notifyTransactionStatus(this.Hh);
        a(Status.nA);
      }
    });
  }
  
  public static final class WalletOptions
    implements GoogleApiClient.ApiOptions
  {
    public final int environment;
    public final int theme;
    
    private WalletOptions()
    {
      this(new Builder());
    }
    
    private WalletOptions(Builder paramBuilder)
    {
      this.environment = Builder.a(paramBuilder);
      this.theme = Builder.b(paramBuilder);
    }
    
    public static final class Builder
    {
      private int Hi = 0;
      private int mTheme = 0;
      
      public Wallet.WalletOptions build()
      {
        return new Wallet.WalletOptions(this, null);
      }
      
      public Builder setEnvironment(int paramInt)
      {
        if ((paramInt == 0) || (paramInt == 2) || (paramInt == 1))
        {
          this.Hi = paramInt;
          return this;
        }
        throw new IllegalArgumentException(String.format("Invalid environment value %d", new Object[] { Integer.valueOf(paramInt) }));
      }
      
      public Builder setTheme(int paramInt)
      {
        if ((paramInt == 0) || (paramInt == 1))
        {
          this.mTheme = paramInt;
          return this;
        }
        throw new IllegalArgumentException(String.format("Invalid theme value %d", new Object[] { Integer.valueOf(paramInt) }));
      }
    }
  }
  
  private static abstract class a
    extends a.a<Status, iu>
  {
    public a()
    {
      super();
    }
    
    public Status g(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/wallet/Wallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */