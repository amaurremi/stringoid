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
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.a;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.d.b;
import com.google.android.gms.common.internal.d.e;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

public class ly
  extends d<lw>
{
  private final md<lw> Dh = new c(null);
  private final lx aeL = new lx(paramContext, this.Dh);
  private final mv aeM;
  private final lo aeN;
  private final ie aeO;
  private final String aeP;
  
  public ly(Context paramContext, Looper paramLooper, String paramString1, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString2)
  {
    this(paramContext, paramLooper, paramString1, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString2, null);
  }
  
  public ly(Context paramContext, Looper paramLooper, String paramString1, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString2, String paramString3)
  {
    this(paramContext, paramLooper, paramString1, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString2, paramString3, null);
  }
  
  public ly(Context paramContext, Looper paramLooper, String paramString1, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString2, String paramString3, String paramString4)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.aeP = paramString2;
    this.aeM = new mv(paramString1, this.Dh, paramString3);
    this.aeN = lo.a(paramContext, paramString3, paramString4, this.Dh);
    this.aeO = ie.a(paramContext, this.Dh);
  }
  
  public ly(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
    this.aeP = paramString;
    this.aeM = new mv(paramContext.getPackageName(), this.Dh, null);
    this.aeN = lo.a(paramContext, null, null, this.Dh);
    this.aeO = ie.a(paramContext, this.Dh);
  }
  
  protected void a(k paramk, d.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("client_name", this.aeP);
    paramk.e(parame, 6111000, getContext().getPackageName(), localBundle);
  }
  
  public void a(lz paramlz, LocationListener paramLocationListener)
    throws RemoteException
  {
    a(paramlz, paramLocationListener, null);
  }
  
  public void a(lz paramlz, LocationListener paramLocationListener, Looper paramLooper)
    throws RemoteException
  {
    synchronized (this.aeL)
    {
      this.aeL.a(paramlz, paramLocationListener, paramLooper);
      return;
    }
  }
  
  protected lw aL(IBinder paramIBinder)
  {
    return lw.a.aK(paramIBinder);
  }
  
  public void addGeofences(List<mb> paramList, PendingIntent paramPendingIntent, LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener)
    throws RemoteException
  {
    dK();
    boolean bool;
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool = true;
      n.b(bool, "At least one geofence must be specified.");
      n.b(paramPendingIntent, "PendingIntent must be specified.");
      n.b(paramOnAddGeofencesResultListener, "OnAddGeofencesResultListener not provided.");
      if (paramOnAddGeofencesResultListener != null) {
        break label76;
      }
    }
    label76:
    for (paramOnAddGeofencesResultListener = null;; paramOnAddGeofencesResultListener = new b(paramOnAddGeofencesResultListener, this))
    {
      ((lw)gS()).a(paramList, paramPendingIntent, paramOnAddGeofencesResultListener, getContext().getPackageName());
      return;
      bool = false;
      break;
    }
  }
  
  public void b(lz paramlz, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.aeL.b(paramlz, paramPendingIntent);
  }
  
  public void disconnect()
  {
    synchronized (this.aeL)
    {
      if (isConnected())
      {
        this.aeL.removeAllListeners();
        this.aeL.lW();
      }
      super.disconnect();
      return;
    }
  }
  
  public Location getLastLocation()
  {
    return this.aeL.getLastLocation();
  }
  
  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
  }
  
  protected String getStartServiceAction()
  {
    return "com.google.android.location.internal.GoogleLocationManagerService.START";
  }
  
  public void removeActivityUpdates(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    dK();
    n.i(paramPendingIntent);
    ((lw)gS()).removeActivityUpdates(paramPendingIntent);
  }
  
  public void removeGeofences(PendingIntent paramPendingIntent, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
    throws RemoteException
  {
    dK();
    n.b(paramPendingIntent, "PendingIntent must be specified.");
    n.b(paramOnRemoveGeofencesResultListener, "OnRemoveGeofencesResultListener not provided.");
    if (paramOnRemoveGeofencesResultListener == null) {}
    for (paramOnRemoveGeofencesResultListener = null;; paramOnRemoveGeofencesResultListener = new b(paramOnRemoveGeofencesResultListener, this))
    {
      ((lw)gS()).a(paramPendingIntent, paramOnRemoveGeofencesResultListener, getContext().getPackageName());
      return;
    }
  }
  
  public void removeGeofences(List<String> paramList, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
    throws RemoteException
  {
    dK();
    boolean bool;
    String[] arrayOfString;
    if ((paramList != null) && (paramList.size() > 0))
    {
      bool = true;
      n.b(bool, "geofenceRequestIds can't be null nor empty.");
      n.b(paramOnRemoveGeofencesResultListener, "OnRemoveGeofencesResultListener not provided.");
      arrayOfString = (String[])paramList.toArray(new String[0]);
      if (paramOnRemoveGeofencesResultListener != null) {
        break label81;
      }
    }
    label81:
    for (paramList = null;; paramList = new b(paramOnRemoveGeofencesResultListener, this))
    {
      ((lw)gS()).a(arrayOfString, paramList, getContext().getPackageName());
      return;
      bool = false;
      break;
    }
  }
  
  public void removeLocationUpdates(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.aeL.removeLocationUpdates(paramPendingIntent);
  }
  
  public void removeLocationUpdates(LocationListener paramLocationListener)
    throws RemoteException
  {
    this.aeL.removeLocationUpdates(paramLocationListener);
  }
  
  public void requestActivityUpdates(long paramLong, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    dK();
    n.i(paramPendingIntent);
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      n.b(bool, "detectionIntervalMillis must be >= 0");
      ((lw)gS()).a(paramLong, true, paramPendingIntent);
      return;
    }
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.aeL.requestLocationUpdates(paramLocationRequest, paramPendingIntent);
  }
  
  public void requestLocationUpdates(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
    throws RemoteException
  {
    synchronized (this.aeL)
    {
      this.aeL.requestLocationUpdates(paramLocationRequest, paramLocationListener, paramLooper);
      return;
    }
  }
  
  public void setMockLocation(Location paramLocation)
    throws RemoteException
  {
    this.aeL.setMockLocation(paramLocation);
  }
  
  public void setMockMode(boolean paramBoolean)
    throws RemoteException
  {
    this.aeL.setMockMode(paramBoolean);
  }
  
  private final class a
    extends d<lw>.b<LocationClient.OnAddGeofencesResultListener>
  {
    private final int HF;
    private final String[] aeQ;
    
    public a(LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener, int paramInt, String[] paramArrayOfString)
    {
      super(paramOnAddGeofencesResultListener);
      this.HF = LocationStatusCodes.ee(paramInt);
      this.aeQ = paramArrayOfString;
    }
    
    protected void a(LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener)
    {
      if (paramOnAddGeofencesResultListener != null) {
        paramOnAddGeofencesResultListener.onAddGeofencesResult(this.HF, this.aeQ);
      }
    }
    
    protected void gT() {}
  }
  
  private static final class b
    extends lv.a
  {
    private LocationClient.OnAddGeofencesResultListener aeS;
    private LocationClient.OnRemoveGeofencesResultListener aeT;
    private ly aeU;
    
    public b(LocationClient.OnAddGeofencesResultListener paramOnAddGeofencesResultListener, ly paramly)
    {
      this.aeS = paramOnAddGeofencesResultListener;
      this.aeT = null;
      this.aeU = paramly;
    }
    
    public b(LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener, ly paramly)
    {
      this.aeT = paramOnRemoveGeofencesResultListener;
      this.aeS = null;
      this.aeU = paramly;
    }
    
    public void onAddGeofencesResult(int paramInt, String[] paramArrayOfString)
      throws RemoteException
    {
      if (this.aeU == null)
      {
        Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
        return;
      }
      ly locally1 = this.aeU;
      ly locally2 = this.aeU;
      locally2.getClass();
      locally1.a(new ly.a(locally2, this.aeS, paramInt, paramArrayOfString));
      this.aeU = null;
      this.aeS = null;
      this.aeT = null;
    }
    
    public void onRemoveGeofencesByPendingIntentResult(int paramInt, PendingIntent paramPendingIntent)
    {
      if (this.aeU == null)
      {
        Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
        return;
      }
      ly locally1 = this.aeU;
      ly locally2 = this.aeU;
      locally2.getClass();
      locally1.a(new ly.d(locally2, 1, this.aeT, paramInt, paramPendingIntent));
      this.aeU = null;
      this.aeS = null;
      this.aeT = null;
    }
    
    public void onRemoveGeofencesByRequestIdsResult(int paramInt, String[] paramArrayOfString)
    {
      if (this.aeU == null)
      {
        Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
        return;
      }
      ly locally1 = this.aeU;
      ly locally2 = this.aeU;
      locally2.getClass();
      locally1.a(new ly.d(locally2, 2, this.aeT, paramInt, paramArrayOfString));
      this.aeU = null;
      this.aeS = null;
      this.aeT = null;
    }
  }
  
  private final class c
    implements md<lw>
  {
    private c() {}
    
    public void dK()
    {
      ly.b(ly.this);
    }
    
    public lw lX()
    {
      return (lw)ly.this.gS();
    }
  }
  
  private final class d
    extends d<lw>.b<LocationClient.OnRemoveGeofencesResultListener>
  {
    private final int HF;
    private final String[] aeQ;
    private final int aeV;
    private final PendingIntent mPendingIntent;
    
    public d(int paramInt1, LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener, int paramInt2, PendingIntent paramPendingIntent)
    {
      super(paramOnRemoveGeofencesResultListener);
      if (paramInt1 == 1) {}
      for (;;)
      {
        a.I(bool);
        this.aeV = paramInt1;
        this.HF = LocationStatusCodes.ee(paramInt2);
        this.mPendingIntent = paramPendingIntent;
        this.aeQ = null;
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
        a.I(bool);
        this.aeV = paramInt1;
        this.HF = LocationStatusCodes.ee(paramInt2);
        this.aeQ = paramArrayOfString;
        this.mPendingIntent = null;
        return;
      }
    }
    
    protected void a(LocationClient.OnRemoveGeofencesResultListener paramOnRemoveGeofencesResultListener)
    {
      if (paramOnRemoveGeofencesResultListener != null) {}
      switch (this.aeV)
      {
      default: 
        Log.wtf("LocationClientImpl", "Unsupported action: " + this.aeV);
        return;
      case 1: 
        paramOnRemoveGeofencesResultListener.onRemoveGeofencesByPendingIntentResult(this.HF, this.mPendingIntent);
        return;
      }
      paramOnRemoveGeofencesResultListener.onRemoveGeofencesByRequestIdsResult(this.HF, this.aeQ);
    }
    
    protected void gT() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/ly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */