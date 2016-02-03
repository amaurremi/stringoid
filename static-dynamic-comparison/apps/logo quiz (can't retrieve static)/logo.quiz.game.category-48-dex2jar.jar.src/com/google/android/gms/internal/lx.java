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
import com.google.android.gms.common.internal.n;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.a.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class lx
{
  private final md<lw> Dh;
  private ContentProviderClient aeG = null;
  private boolean aeH = false;
  private HashMap<LocationListener, b> aeI = new HashMap();
  private final Context mContext;
  
  public lx(Context paramContext, md<lw> parammd)
  {
    this.mContext = paramContext;
    this.Dh = parammd;
  }
  
  private b a(LocationListener paramLocationListener, Looper paramLooper)
  {
    if (paramLooper == null) {
      n.b(Looper.myLooper(), "Can't create handler inside thread that has not called Looper.prepare()");
    }
    synchronized (this.aeI)
    {
      b localb2 = (b)this.aeI.get(paramLocationListener);
      b localb1 = localb2;
      if (localb2 == null) {
        localb1 = new b(paramLocationListener, paramLooper);
      }
      this.aeI.put(paramLocationListener, localb1);
      return localb1;
    }
  }
  
  public void a(lz paramlz, LocationListener paramLocationListener, Looper paramLooper)
    throws RemoteException
  {
    this.Dh.dK();
    paramLocationListener = a(paramLocationListener, paramLooper);
    ((lw)this.Dh.gS()).a(paramlz, paramLocationListener);
  }
  
  public void b(lz paramlz, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.Dh.dK();
    ((lw)this.Dh.gS()).a(paramlz, paramPendingIntent);
  }
  
  public Location getLastLocation()
  {
    this.Dh.dK();
    try
    {
      Location localLocation = ((lw)this.Dh.gS()).bT(this.mContext.getPackageName());
      return localLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void lW()
  {
    if (this.aeH) {}
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
      synchronized (this.aeI)
      {
        Iterator localIterator = this.aeI.values().iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (localb != null) {
            ((lw)this.Dh.gS()).a(localb);
          }
        }
      }
      this.aeI.clear();
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void removeLocationUpdates(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.Dh.dK();
    ((lw)this.Dh.gS()).a(paramPendingIntent);
  }
  
  public void removeLocationUpdates(LocationListener paramLocationListener)
    throws RemoteException
  {
    this.Dh.dK();
    n.b(paramLocationListener, "Invalid null listener");
    synchronized (this.aeI)
    {
      paramLocationListener = (b)this.aeI.remove(paramLocationListener);
      if ((this.aeG != null) && (this.aeI.isEmpty()))
      {
        this.aeG.release();
        this.aeG = null;
      }
      if (paramLocationListener != null)
      {
        paramLocationListener.release();
        ((lw)this.Dh.gS()).a(paramLocationListener);
      }
      return;
    }
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.Dh.dK();
    ((lw)this.Dh.gS()).a(paramLocationRequest, paramPendingIntent);
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
    throws RemoteException
  {
    this.Dh.dK();
    paramLocationListener = a(paramLocationListener, paramLooper);
    ((lw)this.Dh.gS()).a(paramLocationRequest, paramLocationListener);
  }
  
  public void setMockLocation(Location paramLocation)
    throws RemoteException
  {
    this.Dh.dK();
    ((lw)this.Dh.gS()).setMockLocation(paramLocation);
  }
  
  public void setMockMode(boolean paramBoolean)
    throws RemoteException
  {
    this.Dh.dK();
    ((lw)this.Dh.gS()).setMockMode(paramBoolean);
    this.aeH = paramBoolean;
  }
  
  private static class a
    extends Handler
  {
    private final LocationListener aeJ;
    
    public a(LocationListener paramLocationListener)
    {
      this.aeJ = paramLocationListener;
    }
    
    public a(LocationListener paramLocationListener, Looper paramLooper)
    {
      super();
      this.aeJ = paramLocationListener;
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
      this.aeJ.onLocationChanged(paramMessage);
    }
  }
  
  private static class b
    extends a.a
  {
    private Handler aeK;
    
    b(LocationListener paramLocationListener, Looper paramLooper)
    {
      if (paramLooper == null) {}
      for (paramLocationListener = new lx.a(paramLocationListener);; paramLocationListener = new lx.a(paramLocationListener, paramLooper))
      {
        this.aeK = paramLocationListener;
        return;
      }
    }
    
    public void onLocationChanged(Location paramLocation)
    {
      if (this.aeK == null)
      {
        Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
        return;
      }
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramLocation;
      this.aeK.sendMessage(localMessage);
    }
    
    public void release()
    {
      this.aeK = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/lx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */