package com.google.android.gms.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.f.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class en
{
  private final eq<em> MJ;
  private ContentProviderClient MK = null;
  private boolean ML = false;
  private HashMap<LocationListener, a> MM = new HashMap();
  private final Context mContext;
  
  public en(Context paramContext, eq<em> parameq)
  {
    this.mContext = paramContext;
    this.MJ = parameq;
  }
  
  public void J(boolean paramBoolean)
  {
    this.MJ.lf();
    try
    {
      ((em)this.MJ.qr()).J(paramBoolean);
      this.ML = paramBoolean;
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void removeAllListeners()
  {
    try
    {
      synchronized (this.MM)
      {
        Iterator localIterator = this.MM.values().iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala != null) {
            ((em)this.MJ.qr()).a(locala);
          }
        }
      }
      this.MM.clear();
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public Location rf()
  {
    this.MJ.lf();
    try
    {
      Location localLocation = ((em)this.MJ.qr()).aV(this.mContext.getPackageName());
      return localLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void rg()
  {
    if (this.ML) {
      J(false);
    }
  }
  
  private static class a
    extends f.a
  {
    private Handler MN;
    
    public void onLocationChanged(Location paramLocation)
    {
      if (this.MN == null)
      {
        Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
        return;
      }
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramLocation;
      this.MN.sendMessage(localMessage);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/en.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */