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
import java.util.HashMap;
import java.util.List;

public class gn
  extends dw<gl>
{
  private final String jG;
  private final gq<gl> xP = new c(null);
  private final gm xV = new gm(paramContext, this.xP);
  private final HashMap xW = new HashMap();
  private final String xX;
  
  public gn(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.xX = paramString;
    this.jG = null;
  }
  
  protected gl M(IBinder paramIBinder)
  {
    return gl.a.L(paramIBinder);
  }
  
  protected void a(ec paramec, dw.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", this.xX);
    paramec.e(parame, 4242000, getContext().getPackageName(), localBundle);
  }
  
  public void addGeofences(List<go> paramList, PendingIntent paramPendingIntent, LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener)
  {
    bP();
    if ((paramList != null) && (paramList.size() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      eg.b(bool, "At least one geofence must be specified.");
      eg.b(paramPendingIntent, "PendingIntent must be specified.");
      eg.b(paramOnAddGeofencesResultListener, "OnAddGeofencesResultListener not provided.");
      if (paramOnAddGeofencesResultListener == null) {}
      for (paramOnAddGeofencesResultListener = null;; paramOnAddGeofencesResultListener = new b(paramOnAddGeofencesResultListener, this)) {
        try
        {
          ((gl)bQ()).a(paramList, paramPendingIntent, paramOnAddGeofencesResultListener, getContext().getPackageName());
          return;
        }
        catch (RemoteException paramList)
        {
          throw new IllegalStateException(paramList);
        }
      }
    }
  }
  
  protected String am()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }
  
  protected String an()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }
  
  public void disconnect()
  {
    synchronized (this.xV)
    {
      if (isConnected())
      {
        this.xV.removeAllListeners();
        this.xV.dI();
      }
      super.disconnect();
      return;
    }
  }
  
  public Location getLastLocation()
  {
    return this.xV.getLastLocation();
  }
  
  public void removeActivityUpdates(PendingIntent paramPendingIntent)
  {
    bP();
    eg.f(paramPendingIntent);
    try
    {
      ((gl)bQ()).removeActivityUpdates(paramPendingIntent);
      return;
    }
    catch (RemoteException paramPendingIntent)
    {
      throw new IllegalStateException(paramPendingIntent);
    }
  }
  
  public void removeGeofences(PendingIntent paramPendingIntent, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
  {
    bP();
    eg.b(paramPendingIntent, "PendingIntent must be specified.");
    eg.b(paramOnRemoveGeofencesResultListener, "OnRemoveGeofencesResultListener not provided.");
    if (paramOnRemoveGeofencesResultListener == null) {}
    for (paramOnRemoveGeofencesResultListener = null;; paramOnRemoveGeofencesResultListener = new b(paramOnRemoveGeofencesResultListener, this)) {
      try
      {
        ((gl)bQ()).a(paramPendingIntent, paramOnRemoveGeofencesResultListener, getContext().getPackageName());
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
    bP();
    if ((paramList != null) && (paramList.size() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      eg.b(bool, "geofenceRequestIds can't be null nor empty.");
      eg.b(paramOnRemoveGeofencesResultListener, "OnRemoveGeofencesResultListener not provided.");
      String[] arrayOfString = (String[])paramList.toArray(new String[0]);
      if (paramOnRemoveGeofencesResultListener == null) {}
      for (paramList = null;; paramList = new b(paramOnRemoveGeofencesResultListener, this)) {
        try
        {
          ((gl)bQ()).a(arrayOfString, paramList, getContext().getPackageName());
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
    this.xV.removeLocationUpdates(paramPendingIntent);
  }
  
  public void removeLocationUpdates(LocationListener paramLocationListener)
  {
    this.xV.removeLocationUpdates(paramLocationListener);
  }
  
  public void requestActivityUpdates(long paramLong, PendingIntent paramPendingIntent)
  {
    boolean bool = true;
    bP();
    eg.f(paramPendingIntent);
    if (paramLong >= 0L) {}
    for (;;)
    {
      eg.b(bool, "detectionIntervalMillis must be >= 0");
      try
      {
        ((gl)bQ()).a(paramLong, true, paramPendingIntent);
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
    this.xV.requestLocationUpdates(paramLocationRequest, paramPendingIntent);
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener)
  {
    requestLocationUpdates(paramLocationRequest, paramLocationListener, null);
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
  {
    synchronized (this.xV)
    {
      this.xV.requestLocationUpdates(paramLocationRequest, paramLocationListener, paramLooper);
      return;
    }
  }
  
  public void setMockLocation(Location paramLocation)
  {
    this.xV.setMockLocation(paramLocation);
  }
  
  public void setMockMode(boolean paramBoolean)
  {
    this.xV.setMockMode(paramBoolean);
  }
  
  private final class a
    extends dw<gl>.b<LocationClient.OnAddGeofencesResultListener>
  {
    private final int mC;
    private final String[] xY;
    
    public a(LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener, int paramInt, String[] paramArrayOfString)
    {
      super(paramOnAddGeofencesResultListener);
      this.mC = LocationStatusCodes.aR(paramInt);
      this.xY = paramArrayOfString;
    }
    
    protected void a(LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener)
    {
      if (paramOnAddGeofencesResultListener != null) {
        paramOnAddGeofencesResultListener.onAddGeofencesResult(this.mC, this.xY);
      }
    }
    
    protected void aL() {}
  }
  
  private static final class b
    extends gk.a
  {
    private LocationClient.OnAddGeofencesResultListener ya;
    private LocationClient.OnRemoveGeofencesResultListener yb;
    private gn yc;
    
    public b(LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener, gn paramgn)
    {
      this.ya = paramOnAddGeofencesResultListener;
      this.yb = null;
      this.yc = paramgn;
    }
    
    public b(LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener, gn paramgn)
    {
      this.yb = paramOnRemoveGeofencesResultListener;
      this.ya = null;
      this.yc = paramgn;
    }
    
    public void onAddGeofencesResult(int paramInt, String[] paramArrayOfString)
      throws RemoteException
    {
      if (this.yc == null)
      {
        Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
        return;
      }
      gn localgn1 = this.yc;
      gn localgn2 = this.yc;
      localgn2.getClass();
      localgn1.a(new gn.a(localgn2, this.ya, paramInt, paramArrayOfString));
      this.yc = null;
      this.ya = null;
      this.yb = null;
    }
    
    public void onRemoveGeofencesByPendingIntentResult(int paramInt, PendingIntent paramPendingIntent)
    {
      if (this.yc == null)
      {
        Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
        return;
      }
      gn localgn1 = this.yc;
      gn localgn2 = this.yc;
      localgn2.getClass();
      localgn1.a(new gn.d(localgn2, 1, this.yb, paramInt, paramPendingIntent));
      this.yc = null;
      this.ya = null;
      this.yb = null;
    }
    
    public void onRemoveGeofencesByRequestIdsResult(int paramInt, String[] paramArrayOfString)
    {
      if (this.yc == null)
      {
        Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
        return;
      }
      gn localgn1 = this.yc;
      gn localgn2 = this.yc;
      localgn2.getClass();
      localgn1.a(new gn.d(localgn2, 2, this.yb, paramInt, paramArrayOfString));
      this.yc = null;
      this.ya = null;
      this.yb = null;
    }
  }
  
  private final class c
    implements gq<gl>
  {
    private c() {}
    
    public void bP()
    {
      gn.a(gn.this);
    }
    
    public gl dJ()
    {
      return (gl)gn.b(gn.this);
    }
  }
  
  private final class d
    extends dw<gl>.b<LocationClient.OnRemoveGeofencesResultListener>
  {
    private final int mC;
    private final PendingIntent mPendingIntent;
    private final String[] xY;
    private final int yd;
    
    public d(int paramInt1, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener, int paramInt2, PendingIntent paramPendingIntent)
    {
      super(paramOnRemoveGeofencesResultListener);
      if (paramInt1 == 1) {}
      for (;;)
      {
        ds.p(bool);
        this.yd = paramInt1;
        this.mC = LocationStatusCodes.aR(paramInt2);
        this.mPendingIntent = paramPendingIntent;
        this.xY = null;
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
        ds.p(bool);
        this.yd = paramInt1;
        this.mC = LocationStatusCodes.aR(paramInt2);
        this.xY = paramArrayOfString;
        this.mPendingIntent = null;
        return;
      }
    }
    
    protected void a(LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
    {
      if (paramOnRemoveGeofencesResultListener != null) {}
      switch (this.yd)
      {
      default: 
        Log.wtf("LocationClientImpl", "Unsupported action: " + this.yd);
        return;
      case 1: 
        paramOnRemoveGeofencesResultListener.onRemoveGeofencesByPendingIntentResult(this.mC, this.mPendingIntent);
        return;
      }
      paramOnRemoveGeofencesResultListener.onRemoveGeofencesByRequestIdsResult(this.mC, this.xY);
    }
    
    protected void aL() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/gn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */