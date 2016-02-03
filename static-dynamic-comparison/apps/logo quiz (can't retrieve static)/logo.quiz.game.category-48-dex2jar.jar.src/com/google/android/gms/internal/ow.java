package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.b;

public class ow
  implements Payments
{
  public void changeMaskedWallet(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2, final int paramInt)
  {
    paramGoogleApiClient.a(new Wallet.b()
    {
      protected void a(ox paramAnonymousox)
      {
        paramAnonymousox.d(paramString1, paramString2, paramInt);
        b(Status.Jo);
      }
    });
  }
  
  public void checkForPreAuthorization(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.a(new Wallet.b()
    {
      protected void a(ox paramAnonymousox)
      {
        paramAnonymousox.fH(paramInt);
        b(Status.Jo);
      }
    });
  }
  
  public void loadFullWallet(GoogleApiClient paramGoogleApiClient, final FullWalletRequest paramFullWalletRequest, final int paramInt)
  {
    paramGoogleApiClient.a(new Wallet.b()
    {
      protected void a(ox paramAnonymousox)
      {
        paramAnonymousox.a(paramFullWalletRequest, paramInt);
        b(Status.Jo);
      }
    });
  }
  
  public void loadMaskedWallet(GoogleApiClient paramGoogleApiClient, final MaskedWalletRequest paramMaskedWalletRequest, final int paramInt)
  {
    paramGoogleApiClient.a(new Wallet.b()
    {
      protected void a(ox paramAnonymousox)
      {
        paramAnonymousox.a(paramMaskedWalletRequest, paramInt);
        b(Status.Jo);
      }
    });
  }
  
  public void notifyTransactionStatus(GoogleApiClient paramGoogleApiClient, final NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest)
  {
    paramGoogleApiClient.a(new Wallet.b()
    {
      protected void a(ox paramAnonymousox)
      {
        paramAnonymousox.a(paramNotifyTransactionStatusRequest);
        b(Status.Jo);
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */