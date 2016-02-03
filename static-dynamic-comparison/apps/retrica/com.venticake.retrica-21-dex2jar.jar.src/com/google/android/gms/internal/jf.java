package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class jf
{
  private final jj<je> VJ;
  private ContentProviderClient VK = null;
  private boolean VL = false;
  private HashMap<LocationListener, pg> VM = new HashMap();
  private final Context mContext;
  
  public jf(Context paramContext, jj<je> paramjj)
  {
    this.mContext = paramContext;
    this.VJ = paramjj;
  }
  
  public Location getLastLocation()
  {
    this.VJ.cn();
    try
    {
      Location localLocation = ((je)this.VJ.ft()).bo(this.mContext.getPackageName());
      return localLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void iY()
  {
    if (this.VL) {}
    try
    {
      setMockMode(false);
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
      synchronized (this.VM)
      {
        Iterator localIterator = this.VM.values().iterator();
        while (localIterator.hasNext())
        {
          pg localpg = (pg)localIterator.next();
          if (localpg != null) {
            ((je)this.VJ.ft()).a(localpg);
          }
        }
      }
      this.VM.clear();
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void removeLocationUpdates(PendingIntent paramPendingIntent)
  {
    this.VJ.cn();
    ((je)this.VJ.ft()).a(paramPendingIntent);
  }
  
  public void removeLocationUpdates(LocationListener paramLocationListener)
  {
    this.VJ.cn();
    hm.b(paramLocationListener, "Invalid null listener");
    synchronized (this.VM)
    {
      paramLocationListener = (pg)this.VM.remove(paramLocationListener);
      if ((this.VK != null) && (this.VM.isEmpty()))
      {
        this.VK.release();
        this.VK = null;
      }
      if (paramLocationListener != null)
      {
        paramLocationListener.a();
        ((je)this.VJ.ft()).a(paramLocationListener);
      }
      return;
    }
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
  {
    this.VJ.cn();
    ((je)this.VJ.ft()).a(paramLocationRequest, paramPendingIntent);
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
  {
    this.VJ.cn();
    if (paramLooper == null) {
      hm.b(Looper.myLooper(), "Can't create handler inside thread that has not called Looper.prepare()");
    }
    for (;;)
    {
      pg localpg;
      synchronized (this.VM)
      {
        localpg = (pg)this.VM.get(paramLocationListener);
        if (localpg == null)
        {
          paramLooper = new pg(paramLocationListener, paramLooper);
          this.VM.put(paramLocationListener, paramLooper);
          ((je)this.VJ.ft()).a(paramLocationRequest, paramLooper, this.mContext.getPackageName());
          return;
        }
      }
      paramLooper = localpg;
    }
  }
  
  public void setMockLocation(Location paramLocation)
  {
    this.VJ.cn();
    ((je)this.VJ.ft()).setMockLocation(paramLocation);
  }
  
  public void setMockMode(boolean paramBoolean)
  {
    this.VJ.cn();
    ((je)this.VJ.ft()).setMockMode(paramBoolean);
    this.VL = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/jf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */