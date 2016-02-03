package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

public class dj
  implements InAppPurchaseResult
{
  private final df pw;
  
  public dj(df paramdf)
  {
    this.pw = paramdf;
  }
  
  public void finishPurchase()
  {
    try
    {
      this.pw.finishPurchase();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Could not forward finishPurchase to InAppPurchaseResult", localRemoteException);
    }
  }
  
  public String getProductId()
  {
    try
    {
      String str = this.pw.getProductId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Could not forward getProductId to InAppPurchaseResult", localRemoteException);
    }
    return null;
  }
  
  public Intent getPurchaseData()
  {
    try
    {
      Intent localIntent = this.pw.getPurchaseData();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Could not forward getPurchaseData to InAppPurchaseResult", localRemoteException);
    }
    return null;
  }
  
  public int getResultCode()
  {
    try
    {
      int i = this.pw.getResultCode();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Could not forward getPurchaseData to InAppPurchaseResult", localRemoteException);
    }
    return 0;
  }
  
  public boolean isVerified()
  {
    try
    {
      boolean bool = this.pw.isVerified();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Could not forward isVerified to InAppPurchaseResult", localRemoteException);
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */