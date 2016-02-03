package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

public class dk
  implements InAppPurchaseResult
{
  private final dg pu;
  
  public dk(dg paramdg)
  {
    this.pu = paramdg;
  }
  
  public void finishPurchase()
  {
    try
    {
      this.pu.finishPurchase();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not forward finishPurchase to InAppPurchaseResult", localRemoteException);
    }
  }
  
  public String getProductId()
  {
    try
    {
      String str = this.pu.getProductId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not forward getProductId to InAppPurchaseResult", localRemoteException);
    }
    return null;
  }
  
  public Intent getPurchaseData()
  {
    try
    {
      Intent localIntent = this.pu.getPurchaseData();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not forward getPurchaseData to InAppPurchaseResult", localRemoteException);
    }
    return null;
  }
  
  public int getResultCode()
  {
    try
    {
      int i = this.pu.getResultCode();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not forward getPurchaseData to InAppPurchaseResult", localRemoteException);
    }
    return 0;
  }
  
  public boolean isVerified()
  {
    try
    {
      boolean bool = this.pu.isVerified();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not forward isVerified to InAppPurchaseResult", localRemoteException);
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */