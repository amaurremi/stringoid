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

public class jg
{
  private final jk<jf> VG;
  private ContentProviderClient VH = null;
  private boolean VI = false;
  private HashMap<LocationListener, b> VJ = new HashMap();
  private final Context mContext;
  
  public jg(Context paramContext, jk<jf> paramjk)
  {
    this.mContext = paramContext;
    this.VG = paramjk;
  }
  
  public Location getLastLocation()
  {
    this.VG.ci();
    try
    {
      Location localLocation = ((jf)this.VG.fo()).bo(this.mContext.getPackageName());
      return localLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void iT()
  {
    if (this.VI) {}
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
      synchronized (this.VJ)
      {
        Iterator localIterator = this.VJ.values().iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (localb != null) {
            ((jf)this.VG.fo()).a(localb);
          }
        }
      }
      this.VJ.clear();
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void removeLocationUpdates(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.VG.ci();
    ((jf)this.VG.fo()).a(paramPendingIntent);
  }
  
  public void removeLocationUpdates(LocationListener paramLocationListener)
    throws RemoteException
  {
    this.VG.ci();
    hn.b(paramLocationListener, "Invalid null listener");
    synchronized (this.VJ)
    {
      paramLocationListener = (b)this.VJ.remove(paramLocationListener);
      if ((this.VH != null) && (this.VJ.isEmpty()))
      {
        this.VH.release();
        this.VH = null;
      }
      if (paramLocationListener != null)
      {
        paramLocationListener.release();
        ((jf)this.VG.fo()).a(paramLocationListener);
      }
      return;
    }
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.VG.ci();
    ((jf)this.VG.fo()).a(paramLocationRequest, paramPendingIntent);
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
    throws RemoteException
  {
    this.VG.ci();
    if (paramLooper == null) {
      hn.b(Looper.myLooper(), "Can't create handler inside thread that has not called Looper.prepare()");
    }
    for (;;)
    {
      b localb;
      synchronized (this.VJ)
      {
        localb = (b)this.VJ.get(paramLocationListener);
        if (localb == null)
        {
          paramLooper = new b(paramLocationListener, paramLooper);
          this.VJ.put(paramLocationListener, paramLooper);
          ((jf)this.VG.fo()).a(paramLocationRequest, paramLooper, this.mContext.getPackageName());
          return;
        }
      }
      paramLooper = localb;
    }
  }
  
  public void setMockLocation(Location paramLocation)
    throws RemoteException
  {
    this.VG.ci();
    ((jf)this.VG.fo()).setMockLocation(paramLocation);
  }
  
  public void setMockMode(boolean paramBoolean)
    throws RemoteException
  {
    this.VG.ci();
    ((jf)this.VG.fo()).setMockMode(paramBoolean);
    this.VI = paramBoolean;
  }
  
  private static class a
    extends Handler
  {
    private final LocationListener VK;
    
    public a(LocationListener paramLocationListener)
    {
      this.VK = paramLocationListener;
    }
    
    public a(LocationListener paramLocationListener, Looper paramLooper)
    {
      super();
      this.VK = paramLocationListener;
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
      this.VK.onLocationChanged(paramMessage);
    }
  }
  
  private static class b
    extends a.a
  {
    private Handler VL;
    
    b(LocationListener paramLocationListener, Looper paramLooper)
    {
      if (paramLooper == null) {}
      for (paramLocationListener = new jg.a(paramLocationListener);; paramLocationListener = new jg.a(paramLocationListener, paramLooper))
      {
        this.VL = paramLocationListener;
        return;
      }
    }
    
    public void onLocationChanged(Location paramLocation)
    {
      if (this.VL == null)
      {
        Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
        return;
      }
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramLocation;
      this.VL.sendMessage(localMessage);
    }
    
    public void release()
    {
      this.VL = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/jg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */