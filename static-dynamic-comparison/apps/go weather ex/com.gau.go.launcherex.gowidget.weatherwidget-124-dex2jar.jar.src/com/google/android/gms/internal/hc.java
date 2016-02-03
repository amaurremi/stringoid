package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

public class hc
  extends ff<ha>
{
  private final hf<ha> Ok = new c(null);
  private final hb Oq;
  private final hr Or;
  private final String Os;
  private final Context mContext;
  private final String wG;
  
  public hc(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.mContext = paramContext;
    this.Oq = new hb(paramContext, this.Ok);
    this.Os = paramString;
    this.wG = null;
    this.Or = new hr(getContext(), paramContext.getPackageName(), this.Ok);
  }
  
  protected ha X(IBinder paramIBinder)
  {
    return ha.a.W(paramIBinder);
  }
  
  protected void a(fm paramfm, ff.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", this.Os);
    paramfm.e(parame, 4452000, getContext().getPackageName(), localBundle);
  }
  
  public void addGeofences(List<hd> paramList, PendingIntent paramPendingIntent, LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener)
  {
    bT();
    if ((paramList != null) && (paramList.size() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      fq.b(bool, "At least one geofence must be specified.");
      fq.b(paramPendingIntent, "PendingIntent must be specified.");
      fq.b(paramOnAddGeofencesResultListener, "OnAddGeofencesResultListener not provided.");
      if (paramOnAddGeofencesResultListener == null) {}
      for (paramOnAddGeofencesResultListener = null;; paramOnAddGeofencesResultListener = new b(paramOnAddGeofencesResultListener, this)) {
        try
        {
          ((ha)eM()).a(paramList, paramPendingIntent, paramOnAddGeofencesResultListener, getContext().getPackageName());
          return;
        }
        catch (RemoteException paramList)
        {
          throw new IllegalStateException(paramList);
        }
      }
    }
  }
  
  protected String bg()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }
  
  protected String bh()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }
  
  public void disconnect()
  {
    synchronized (this.Oq)
    {
      if (isConnected())
      {
        this.Oq.removeAllListeners();
        this.Oq.hQ();
      }
      super.disconnect();
      return;
    }
  }
  
  public Location getLastLocation()
  {
    return this.Oq.getLastLocation();
  }
  
  public void removeActivityUpdates(PendingIntent paramPendingIntent)
  {
    bT();
    fq.f(paramPendingIntent);
    try
    {
      ((ha)eM()).removeActivityUpdates(paramPendingIntent);
      return;
    }
    catch (RemoteException paramPendingIntent)
    {
      throw new IllegalStateException(paramPendingIntent);
    }
  }
  
  public void removeGeofences(PendingIntent paramPendingIntent, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
  {
    bT();
    fq.b(paramPendingIntent, "PendingIntent must be specified.");
    fq.b(paramOnRemoveGeofencesResultListener, "OnRemoveGeofencesResultListener not provided.");
    if (paramOnRemoveGeofencesResultListener == null) {}
    for (paramOnRemoveGeofencesResultListener = null;; paramOnRemoveGeofencesResultListener = new b(paramOnRemoveGeofencesResultListener, this)) {
      try
      {
        ((ha)eM()).a(paramPendingIntent, paramOnRemoveGeofencesResultListener, getContext().getPackageName());
        return;
      }
      catch (RemoteException paramPendingIntent)
      {
        throw new IllegalStateException(paramPendingIntent);
      }
    }
  }
  
  public void removeGeofences(List<String> paramList, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
  {
    bT();
    if ((paramList != null) && (paramList.size() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      fq.b(bool, "geofenceRequestIds can't be null nor empty.");
      fq.b(paramOnRemoveGeofencesResultListener, "OnRemoveGeofencesResultListener not provided.");
      String[] arrayOfString = (String[])paramList.toArray(new String[0]);
      if (paramOnRemoveGeofencesResultListener == null) {}
      for (paramList = null;; paramList = new b(paramOnRemoveGeofencesResultListener, this)) {
        try
        {
          ((ha)eM()).a(arrayOfString, paramList, getContext().getPackageName());
          return;
        }
        catch (RemoteException paramList)
        {
          throw new IllegalStateException(paramList);
        }
      }
    }
  }
  
  public void removeLocationUpdates(PendingIntent paramPendingIntent)
  {
    this.Oq.removeLocationUpdates(paramPendingIntent);
  }
  
  public void removeLocationUpdates(LocationListener paramLocationListener)
  {
    this.Oq.removeLocationUpdates(paramLocationListener);
  }
  
  public void requestActivityUpdates(long paramLong, PendingIntent paramPendingIntent)
  {
    boolean bool = true;
    bT();
    fq.f(paramPendingIntent);
    if (paramLong >= 0L) {}
    for (;;)
    {
      fq.b(bool, "detectionIntervalMillis must be >= 0");
      try
      {
        ((ha)eM()).a(paramLong, true, paramPendingIntent);
        return;
      }
      catch (RemoteException paramPendingIntent)
      {
        throw new IllegalStateException(paramPendingIntent);
      }
      bool = false;
    }
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
  {
    this.Oq.requestLocationUpdates(paramLocationRequest, paramPendingIntent);
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener)
  {
    requestLocationUpdates(paramLocationRequest, paramLocationListener, null);
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
  {
    synchronized (this.Oq)
    {
      this.Oq.requestLocationUpdates(paramLocationRequest, paramLocationListener, paramLooper);
      return;
    }
  }
  
  public void setMockLocation(Location paramLocation)
  {
    this.Oq.setMockLocation(paramLocation);
  }
  
  public void setMockMode(boolean paramBoolean)
  {
    this.Oq.setMockMode(paramBoolean);
  }
  
  private final class a
    extends ff<ha>.b<LocationClient.OnAddGeofencesResultListener>
  {
    private final int Ah;
    private final String[] Ot;
    
    public a(LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener, int paramInt, String[] paramArrayOfString)
    {
      super(paramOnAddGeofencesResultListener);
      this.Ah = LocationStatusCodes.bz(paramInt);
      this.Ot = paramArrayOfString;
    }
    
    protected void a(LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener)
    {
      if (paramOnAddGeofencesResultListener != null) {
        paramOnAddGeofencesResultListener.onAddGeofencesResult(this.Ah, this.Ot);
      }
    }
    
    protected void dx() {}
  }
  
  private static final class b
    extends gz.a
  {
    private LocationClient.OnAddGeofencesResultListener Ov;
    private LocationClient.OnRemoveGeofencesResultListener Ow;
    private hc Ox;
    
    public b(LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener, hc paramhc)
    {
      this.Ov = paramOnAddGeofencesResultListener;
      this.Ow = null;
      this.Ox = paramhc;
    }
    
    public b(LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener, hc paramhc)
    {
      this.Ow = paramOnRemoveGeofencesResultListener;
      this.Ov = null;
      this.Ox = paramhc;
    }
    
    public void onAddGeofencesResult(int paramInt, String[] paramArrayOfString)
      throws RemoteException
    {
      if (this.Ox == null)
      {
        Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
        return;
      }
      hc localhc1 = this.Ox;
      hc localhc2 = this.Ox;
      localhc2.getClass();
      localhc1.a(new hc.a(localhc2, this.Ov, paramInt, paramArrayOfString));
      this.Ox = null;
      this.Ov = null;
      this.Ow = null;
    }
    
    public void onRemoveGeofencesByPendingIntentResult(int paramInt, PendingIntent paramPendingIntent)
    {
      if (this.Ox == null)
      {
        Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
        return;
      }
      hc localhc1 = this.Ox;
      hc localhc2 = this.Ox;
      localhc2.getClass();
      localhc1.a(new hc.d(localhc2, 1, this.Ow, paramInt, paramPendingIntent));
      this.Ox = null;
      this.Ov = null;
      this.Ow = null;
    }
    
    public void onRemoveGeofencesByRequestIdsResult(int paramInt, String[] paramArrayOfString)
    {
      if (this.Ox == null)
      {
        Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
        return;
      }
      hc localhc1 = this.Ox;
      hc localhc2 = this.Ox;
      localhc2.getClass();
      localhc1.a(new hc.d(localhc2, 2, this.Ow, paramInt, paramArrayOfString));
      this.Ox = null;
      this.Ov = null;
      this.Ow = null;
    }
  }
  
  private final class c
    implements hf<ha>
  {
    private c() {}
    
    public void bT()
    {
      hc.a(hc.this);
    }
    
    public ha hR()
    {
      return (ha)hc.b(hc.this);
    }
  }
  
  private final class d
    extends ff<ha>.b<LocationClient.OnRemoveGeofencesResultListener>
  {
    private final int Ah;
    private final String[] Ot;
    private final int Oy;
    private final PendingIntent mPendingIntent;
    
    public d(int paramInt1, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener, int paramInt2, PendingIntent paramPendingIntent)
    {
      super(paramOnRemoveGeofencesResultListener);
      if (paramInt1 == 1) {}
      for (;;)
      {
        fb.x(bool);
        this.Oy = paramInt1;
        this.Ah = LocationStatusCodes.bz(paramInt2);
        this.mPendingIntent = paramPendingIntent;
        this.Ot = null;
        return;
        bool = false;
      }
    }
    
    public d(int paramInt1, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener, int paramInt2, String[] paramArrayOfString)
    {
      super(paramOnRemoveGeofencesResultListener);
      if (paramInt1 == 2) {}
      for (boolean bool = true;; bool = false)
      {
        fb.x(bool);
        this.Oy = paramInt1;
        this.Ah = LocationStatusCodes.bz(paramInt2);
        this.Ot = paramArrayOfString;
        this.mPendingIntent = null;
        return;
      }
    }
    
    protected void a(LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
    {
      if (paramOnRemoveGeofencesResultListener != null) {}
      switch (this.Oy)
      {
      default: 
        Log.wtf("LocationClientImpl", "Unsupported action: " + this.Oy);
        return;
      case 1: 
        paramOnRemoveGeofencesResultListener.onRemoveGeofencesByPendingIntentResult(this.Ah, this.mPendingIntent);
        return;
      }
      paramOnRemoveGeofencesResultListener.onRemoveGeofencesByRequestIdsResult(this.Ah, this.Ot);
    }
    
    protected void dx() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/hc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */