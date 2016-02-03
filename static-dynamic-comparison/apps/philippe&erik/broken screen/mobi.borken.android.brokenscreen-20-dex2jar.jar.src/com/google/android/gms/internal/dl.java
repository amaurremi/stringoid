package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchase;

public class dl
  implements InAppPurchase
{
  private final dc pg;
  
  public dl(dc paramdc)
  {
    this.pg = paramdc;
  }
  
  public String getProductId()
  {
    try
    {
      String str = this.pg.getProductId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not forward getProductId to InAppPurchase", localRemoteException);
    }
    return null;
  }
  
  public void recordPlayBillingResolution(int paramInt)
  {
    try
    {
      this.pg.recordPlayBillingResolution(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not forward recordPlayBillingResolution to InAppPurchase", localRemoteException);
    }
  }
  
  public void recordResolution(int paramInt)
  {
    try
    {
      this.pg.recordResolution(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      ev.c("Could not forward recordResolution to InAppPurchase", localRemoteException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */