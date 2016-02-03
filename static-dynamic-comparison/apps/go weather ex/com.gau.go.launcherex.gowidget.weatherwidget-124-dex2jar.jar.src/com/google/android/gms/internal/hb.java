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
import com.google.android.gms.location.a.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class hb
{
  private final hf<ha> Ok;
  private ContentProviderClient Ol = null;
  private boolean Om = false;
  private HashMap<LocationListener, b> On = new HashMap();
  private final Context mContext;
  
  public hb(Context paramContext, hf<ha> paramhf)
  {
    this.mContext = paramContext;
    this.Ok = paramhf;
  }
  
  public Location getLastLocation()
  {
    this.Ok.bT();
    try
    {
      Location localLocation = ((ha)this.Ok.eM()).aW(this.mContext.getPackageName());
      return localLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void hQ()
  {
    if (this.Om) {
      setMockMode(false);
    }
  }
  
  public void removeAllListeners()
  {
    try
    {
      synchronized (this.On)
      {
        Iterator localIterator = this.On.values().iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (localb != null) {
            ((ha)this.Ok.eM()).a(localb);
          }
        }
      }
      this.On.clear();
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void removeLocationUpdates(PendingIntent paramPendingIntent)
  {
    this.Ok.bT();
    try
    {
      ((ha)this.Ok.eM()).a(paramPendingIntent);
      return;
    }
    catch (RemoteException paramPendingIntent)
    {
      throw new IllegalStateException(paramPendingIntent);
    }
  }
  
  public void removeLocationUpdates(LocationListener paramLocationListener)
  {
    this.Ok.bT();
    fq.b(paramLocationListener, "Invalid null listener");
    synchronized (this.On)
    {
      paramLocationListener = (b)this.On.remove(paramLocationListener);
      if ((this.Ol != null) && (this.On.isEmpty()))
      {
        this.Ol.release();
        this.Ol = null;
      }
      if (paramLocationListener != null) {
        paramLocationListener.release();
      }
      try
      {
        ((ha)this.Ok.eM()).a(paramLocationListener);
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
    this.Ok.bT();
    try
    {
      ((ha)this.Ok.eM()).a(paramLocationRequest, paramPendingIntent);
      return;
    }
    catch (RemoteException paramLocationRequest)
    {
      throw new IllegalStateException(paramLocationRequest);
    }
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
  {
    this.Ok.bT();
    if (paramLooper == null) {
      fq.b(Looper.myLooper(), "Can't create handler inside thread that has not called Looper.prepare()");
    }
    for (;;)
    {
      b localb;
      synchronized (this.On)
      {
        localb = (b)this.On.get(paramLocationListener);
        if (localb == null)
        {
          paramLooper = new b(paramLocationListener, paramLooper);
          this.On.put(paramLocationListener, paramLooper);
          try
          {
            ((ha)this.Ok.eM()).a(paramLocationRequest, paramLooper, this.mContext.getPackageName());
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
    this.Ok.bT();
    try
    {
      ((ha)this.Ok.eM()).setMockLocation(paramLocation);
      return;
    }
    catch (RemoteException paramLocation)
    {
      throw new IllegalStateException(paramLocation);
    }
  }
  
  public void setMockMode(boolean paramBoolean)
  {
    this.Ok.bT();
    try
    {
      ((ha)this.Ok.eM()).setMockMode(paramBoolean);
      this.Om = paramBoolean;
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
    private final LocationListener Oo;
    
    public a(LocationListener paramLocationListener)
    {
      this.Oo = paramLocationListener;
    }
    
    public a(LocationListener paramLocationListener, Looper paramLooper)
    {
      super();
      this.Oo = paramLocationListener;
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
      this.Oo.onLocationChanged(paramMessage);
    }
  }
  
  private static class b
    extends a.a
  {
    private Handler Op;
    
    b(LocationListener paramLocationListener, Looper paramLooper)
    {
      if (paramLooper == null) {}
      for (paramLocationListener = new hb.a(paramLocationListener);; paramLocationListener = new hb.a(paramLocationListener, paramLooper))
      {
        this.Op = paramLocationListener;
        return;
      }
    }
    
    public void onLocationChanged(Location paramLocation)
    {
      if (this.Op == null)
      {
        Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
        return;
      }
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramLocation;
      this.Op.sendMessage(localMessage);
    }
    
    public void release()
    {
      this.Op = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/hb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */