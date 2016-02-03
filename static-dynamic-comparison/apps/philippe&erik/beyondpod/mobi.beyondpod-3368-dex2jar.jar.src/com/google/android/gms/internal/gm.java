package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.c.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class gm
{
  private final Context mContext;
  private final gq<gl> xP;
  private ContentProviderClient xQ = null;
  private boolean xR = false;
  private HashMap<LocationListener, b> xS = new HashMap();
  
  public gm(Context paramContext, gq<gl> paramgq)
  {
    this.mContext = paramContext;
    this.xP = paramgq;
  }
  
  public void dI()
  {
    if (this.xR) {
      setMockMode(false);
    }
  }
  
  public Location getLastLocation()
  {
    this.xP.bP();
    try
    {
      Location localLocation = ((gl)this.xP.bQ()).an(this.mContext.getPackageName());
      return localLocation;
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
      synchronized (this.xS)
      {
        Iterator localIterator = this.xS.values().iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (localb != null) {
            ((gl)this.xP.bQ()).a(localb);
          }
        }
      }
      this.xS.clear();
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void removeLocationUpdates(PendingIntent paramPendingIntent)
  {
    this.xP.bP();
    try
    {
      ((gl)this.xP.bQ()).a(paramPendingIntent);
      return;
    }
    catch (RemoteException paramPendingIntent)
    {
      throw new IllegalStateException(paramPendingIntent);
    }
  }
  
  public void removeLocationUpdates(LocationListener paramLocationListener)
  {
    this.xP.bP();
    eg.b(paramLocationListener, "Invalid null listener");
    synchronized (this.xS)
    {
      paramLocationListener = (b)this.xS.remove(paramLocationListener);
      if ((this.xQ != null) && (this.xS.isEmpty()))
      {
        this.xQ.release();
        this.xQ = null;
      }
      if (paramLocationListener != null) {
        paramLocationListener.release();
      }
      try
      {
        ((gl)this.xP.bQ()).a(paramLocationListener);
        return;
      }
      catch (RemoteException paramLocationListener)
      {
        throw new IllegalStateException(paramLocationListener);
      }
    }
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
  {
    this.xP.bP();
    try
    {
      ((gl)this.xP.bQ()).a(paramLocationRequest, paramPendingIntent);
      return;
    }
    catch (RemoteException paramLocationRequest)
    {
      throw new IllegalStateException(paramLocationRequest);
    }
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
  {
    this.xP.bP();
    if (paramLooper == null) {
      eg.b(Looper.myLooper(), "Can't create handler inside thread that has not called Looper.prepare()");
    }
    for (;;)
    {
      b localb;
      synchronized (this.xS)
      {
        localb = (b)this.xS.get(paramLocationListener);
        if (localb == null)
        {
          paramLooper = new b(paramLocationListener, paramLooper);
          this.xS.put(paramLocationListener, paramLooper);
          try
          {
            ((gl)this.xP.bQ()).a(paramLocationRequest, paramLooper, this.mContext.getPackageName());
            return;
          }
          catch (RemoteException paramLocationRequest)
          {
            throw new IllegalStateException(paramLocationRequest);
          }
        }
      }
      paramLooper = localb;
    }
  }
  
  public void setMockLocation(Location paramLocation)
  {
    this.xP.bP();
    try
    {
      ((gl)this.xP.bQ()).setMockLocation(paramLocation);
      return;
    }
    catch (RemoteException paramLocation)
    {
      throw new IllegalStateException(paramLocation);
    }
  }
  
  public void setMockMode(boolean paramBoolean)
  {
    this.xP.bP();
    try
    {
      ((gl)this.xP.bQ()).setMockMode(paramBoolean);
      this.xR = paramBoolean;
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  private static class a
    extends Handler
  {
    private final LocationListener xT;
    
    public a(LocationListener paramLocationListener)
    {
      this.xT = paramLocationListener;
    }
    
    public a(LocationListener paramLocationListener, Looper paramLooper)
    {
      super();
      this.xT = paramLocationListener;
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
        return;
      }
      paramMessage = new Location((Location)paramMessage.obj);
      this.xT.onLocationChanged(paramMessage);
    }
  }
  
  private static class b
    extends c.a
  {
    private Handler xU;
    
    b(LocationListener paramLocationListener, Looper paramLooper)
    {
      if (paramLooper == null) {}
      for (paramLocationListener = new gm.a(paramLocationListener);; paramLocationListener = new gm.a(paramLocationListener, paramLooper))
      {
        this.xU = paramLocationListener;
        return;
      }
    }
    
    public void onLocationChanged(Location paramLocation)
    {
      if (this.xU == null)
      {
        Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
        return;
      }
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramLocation;
      this.xU.sendMessage(localMessage);
    }
    
    public void release()
    {
      this.xU = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/gm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */