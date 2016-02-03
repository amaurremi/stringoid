package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchase;

public class dk
  implements InAppPurchase
{
  private final db pi;
  
  public dk(db paramdb)
  {
    this.pi = paramdb;
  }
  
  public String getProductId()
  {
    try
    {
      String str = this.pi.getProductId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Could not forward getProductId to InAppPurchase", localRemoteException);
    }
    return null;
  }
  
  public void recordPlayBillingResolution(int paramInt)
  {
    try
    {
      this.pi.recordPlayBillingResolution(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Could not forward recordPlayBillingResolution to InAppPurchase", localRemoteException);
    }
  }
  
  public void recordResolution(int paramInt)
  {
    try
    {
      this.pi.recordResolution(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      eu.c("Could not forward recordResolution to InAppPurchase", localRemoteException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */