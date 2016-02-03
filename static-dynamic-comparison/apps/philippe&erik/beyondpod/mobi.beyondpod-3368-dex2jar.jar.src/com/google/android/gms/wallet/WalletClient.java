package com.google.android.gms.wallet;

import android.app.Activity;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.iu;

@Deprecated
public class WalletClient
  implements GooglePlayServicesClient
{
  private final iu Hj;
  
  public WalletClient(Activity paramActivity, int paramInt1, String paramString, int paramInt2, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.Hj = new iu(paramActivity, paramConnectionCallbacks, paramOnConnectionFailedListener, paramInt1, paramString, paramInt2);
  }
  
  public WalletClient(Activity paramActivity, int paramInt, String paramString, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramActivity, paramInt, paramString, 0, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public void changeMaskedWallet(String paramString1, String paramString2, int paramInt)
  {
    this.Hj.changeMaskedWallet(paramString1, paramString2, paramInt);
  }
  
  public void checkForPreAuthorization(int paramInt)
  {
    this.Hj.checkForPreAuthorization(paramInt);
  }
  
  public void connect()
  {
    this.Hj.connect();
  }
  
  public void disconnect()
  {
    this.Hj.disconnect();
  }
  
  public boolean isConnected()
  {
    return this.Hj.isConnected();
  }
  
  public boolean isConnecting()
  {
    return this.Hj.isConnecting();
  }
  
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.Hj.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.Hj.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public void loadFullWallet(FullWalletRequest paramFullWalletRequest, int paramInt)
  {
    this.Hj.loadFullWallet(paramFullWalletRequest, paramInt);
  }
  
  public void loadMaskedWallet(MaskedWalletRequest paramMaskedWalletRequest, int paramInt)
  {
    this.Hj.loadMaskedWallet(paramMaskedWalletRequest, paramInt);
  }
  
  public void notifyTransactionStatus(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest)
  {
    this.Hj.notifyTransactionStatus(paramNotifyTransactionStatusRequest);
  }
  
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.Hj.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.Hj.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.Hj.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.Hj.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/wallet/WalletClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */