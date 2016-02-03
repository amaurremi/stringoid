package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class gi
  extends hc<gm>
{
  private static final go BD = new go("CastClientImpl");
  private static final Object BX = new Object();
  private static final Object BY = new Object();
  private double AM;
  private boolean AN;
  private final Cast.Listener Ab;
  private ApplicationMetadata BE;
  private final CastDevice BF;
  private final gn BG;
  private final Map<String, Cast.MessageReceivedCallback> BH;
  private final long BI;
  private String BJ;
  private boolean BK;
  private boolean BL;
  private boolean BM;
  private AtomicBoolean BN;
  private int BO;
  private final AtomicLong BP;
  private String BQ;
  private String BR;
  private Bundle BS;
  private Map<Long, a.d<Status>> BT;
  private b BU;
  private a.d<Cast.ApplicationConnectionResult> BV;
  private a.d<Status> BW;
  private final Handler mHandler;
  
  public gi(Context paramContext, Looper paramLooper, CastDevice paramCastDevice, long paramLong, Cast.Listener paramListener, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, (String[])null);
    this.BF = paramCastDevice;
    this.Ab = paramListener;
    this.BI = paramLong;
    this.mHandler = new Handler(paramLooper);
    this.BH = new HashMap();
    this.BM = false;
    this.BO = -1;
    this.BE = null;
    this.BJ = null;
    this.BN = new AtomicBoolean(false);
    this.AM = 0.0D;
    this.AN = false;
    this.BP = new AtomicLong(0L);
    this.BT = new HashMap();
    this.BU = new b(null);
    registerConnectionFailedListener(this.BU);
    this.BG = new gn.a()
    {
      private boolean X(int paramAnonymousInt)
      {
        synchronized ()
        {
          if (gi.i(gi.this) != null)
          {
            gi.i(gi.this).a(new Status(paramAnonymousInt));
            gi.b(gi.this, null);
            return true;
          }
          return false;
        }
      }
      
      private void b(long paramAnonymousLong, int paramAnonymousInt)
      {
        synchronized (gi.h(gi.this))
        {
          a.d locald = (a.d)gi.h(gi.this).remove(Long.valueOf(paramAnonymousLong));
          if (locald != null) {
            locald.a(new Status(paramAnonymousInt));
          }
          return;
        }
      }
      
      public void T(int paramAnonymousInt)
      {
        gi.ef().b("ICastDeviceControllerListener.onDisconnected: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        gi.a(gi.this, false);
        gi.b(gi.this).set(false);
        gi.a(gi.this, null);
        if (paramAnonymousInt != 0) {
          gi.this.an(2);
        }
      }
      
      public void U(int paramAnonymousInt)
      {
        synchronized ()
        {
          if (gi.c(gi.this) != null)
          {
            gi.c(gi.this).a(new gi.a(new Status(paramAnonymousInt)));
            gi.a(gi.this, null);
          }
          return;
        }
      }
      
      public void V(int paramAnonymousInt)
      {
        X(paramAnonymousInt);
      }
      
      public void W(int paramAnonymousInt)
      {
        X(paramAnonymousInt);
      }
      
      public void a(ApplicationMetadata paramAnonymousApplicationMetadata, String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        gi.a(gi.this, paramAnonymousApplicationMetadata);
        gi.a(gi.this, paramAnonymousApplicationMetadata.getApplicationId());
        gi.b(gi.this, paramAnonymousString2);
        synchronized (gi.eg())
        {
          if (gi.c(gi.this) != null)
          {
            gi.c(gi.this).a(new gi.a(new Status(0), paramAnonymousApplicationMetadata, paramAnonymousString1, paramAnonymousString2, paramAnonymousBoolean));
            gi.a(gi.this, null);
          }
          return;
        }
      }
      
      public void a(String paramAnonymousString, double paramAnonymousDouble, boolean paramAnonymousBoolean)
      {
        gi.ef().b("Deprecated callback: \"onStatusreceived\"", new Object[0]);
      }
      
      public void a(String paramAnonymousString, long paramAnonymousLong)
      {
        b(paramAnonymousLong, 0);
      }
      
      public void a(String paramAnonymousString, long paramAnonymousLong, int paramAnonymousInt)
      {
        b(paramAnonymousLong, paramAnonymousInt);
      }
      
      public void b(final gf paramAnonymousgf)
      {
        gi.ef().b("onApplicationStatusChanged", new Object[0]);
        gi.e(gi.this).post(new Runnable()
        {
          public void run()
          {
            gi.a(gi.this, paramAnonymousgf);
          }
        });
      }
      
      public void b(final gk paramAnonymousgk)
      {
        gi.ef().b("onDeviceStatusChanged", new Object[0]);
        gi.e(gi.this).post(new Runnable()
        {
          public void run()
          {
            gi.a(gi.this, paramAnonymousgk);
          }
        });
      }
      
      public void b(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        gi.ef().b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousArrayOfByte.length) });
      }
      
      public void g(final String paramAnonymousString1, final String paramAnonymousString2)
      {
        gi.ef().b("Receive (type=text, ns=%s) %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        gi.e(gi.this).post(new Runnable()
        {
          public void run()
          {
            synchronized (gi.f(gi.this))
            {
              Cast.MessageReceivedCallback localMessageReceivedCallback = (Cast.MessageReceivedCallback)gi.f(gi.this).get(paramAnonymousString1);
              if (localMessageReceivedCallback != null)
              {
                localMessageReceivedCallback.onMessageReceived(gi.g(gi.this), paramAnonymousString1, paramAnonymousString2);
                return;
              }
            }
            gi.ef().b("Discarded message for unknown namespace '%s'", new Object[] { paramAnonymousString1 });
          }
        });
      }
      
      public void onApplicationDisconnected(final int paramAnonymousInt)
      {
        gi.a(gi.this, null);
        gi.b(gi.this, null);
        X(paramAnonymousInt);
        if (gi.d(gi.this) != null) {
          gi.e(gi.this).post(new Runnable()
          {
            public void run()
            {
              if (gi.d(gi.this) != null) {
                gi.d(gi.this).onApplicationDisconnected(paramAnonymousInt);
              }
            }
          });
        }
      }
    };
  }
  
  private void a(gf paramgf)
  {
    paramgf = paramgf.dX();
    if (!gj.a(paramgf, this.BJ)) {
      this.BJ = paramgf;
    }
    for (boolean bool = true;; bool = false)
    {
      BD.b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.BK) });
      if ((this.Ab != null) && ((bool) || (this.BK))) {
        this.Ab.onApplicationStatusChanged();
      }
      this.BK = false;
      return;
    }
  }
  
  private void a(gk paramgk)
  {
    double d = paramgk.ec();
    if ((d != NaN.0D) && (d != this.AM)) {
      this.AM = d;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = paramgk.ei();
      if (bool2 != this.AN)
      {
        this.AN = bool2;
        bool1 = true;
      }
      BD.b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.BL) });
      if ((this.Ab != null) && ((bool1) || (this.BL))) {
        this.Ab.onVolumeChanged();
      }
      int i = paramgk.ej();
      if (i != this.BO) {
        this.BO = i;
      }
      for (bool1 = true;; bool1 = false)
      {
        BD.b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.BL) });
        if ((this.Ab != null) && ((bool1) || (this.BL))) {
          this.Ab.O(this.BO);
        }
        this.BL = false;
        return;
      }
    }
  }
  
  private void c(a.d<Cast.ApplicationConnectionResult> paramd)
  {
    synchronized (BX)
    {
      if (this.BV != null) {
        this.BV.a(new a(new Status(2002)));
      }
      this.BV = paramd;
      return;
    }
  }
  
  private void e(a.d<Status> paramd)
  {
    synchronized (BY)
    {
      if (this.BW != null)
      {
        paramd.a(new Status(2001));
        return;
      }
      this.BW = paramd;
      return;
    }
  }
  
  private void ed()
  {
    BD.b("removing all MessageReceivedCallbacks", new Object[0]);
    synchronized (this.BH)
    {
      this.BH.clear();
      return;
    }
  }
  
  private void ee()
    throws IllegalStateException
  {
    if ((!this.BM) || (this.BN.get())) {
      throw new IllegalStateException("Not connected to a device");
    }
  }
  
  protected gm G(IBinder paramIBinder)
  {
    return gm.a.H(paramIBinder);
  }
  
  public void a(double paramDouble)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
      throw new IllegalArgumentException("Volume cannot be " + paramDouble);
    }
    ((gm)fo()).a(paramDouble, this.AM, this.AN);
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    BD.b("in onPostInitHandler; statusCode=%d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) || (paramInt == 1001))
    {
      this.BM = true;
      this.BK = true;
      this.BL = true;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 1001)
      {
        this.BS = new Bundle();
        this.BS.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
        i = 0;
      }
      super.a(i, paramIBinder, paramBundle);
      return;
      this.BM = false;
    }
  }
  
  protected void a(hj paramhj, hc.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    BD.b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", new Object[] { this.BQ, this.BR });
    this.BF.putInBundle(localBundle);
    localBundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.BI);
    if (this.BQ != null)
    {
      localBundle.putString("last_application_id", this.BQ);
      if (this.BR != null) {
        localBundle.putString("last_session_id", this.BR);
      }
    }
    paramhj.a(parame, 5077000, getContext().getPackageName(), this.BG.asBinder(), localBundle);
  }
  
  public void a(String paramString, Cast.MessageReceivedCallback paramMessageReceivedCallback)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    gj.ak(paramString);
    aj(paramString);
    if (paramMessageReceivedCallback != null) {}
    synchronized (this.BH)
    {
      this.BH.put(paramString, paramMessageReceivedCallback);
      ((gm)fo()).an(paramString);
      return;
    }
  }
  
  public void a(String paramString, LaunchOptions paramLaunchOptions, a.d<Cast.ApplicationConnectionResult> paramd)
    throws IllegalStateException, RemoteException
  {
    c(paramd);
    ((gm)fo()).a(paramString, paramLaunchOptions);
  }
  
  public void a(String paramString, a.d<Status> paramd)
    throws IllegalStateException, RemoteException
  {
    e(paramd);
    ((gm)fo()).am(paramString);
  }
  
  public void a(String paramString1, String paramString2, a.d<Status> paramd)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    if (TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("The message payload cannot be null or empty");
    }
    if (paramString2.length() > 65536) {
      throw new IllegalArgumentException("Message exceeds maximum size");
    }
    gj.ak(paramString1);
    ee();
    long l = this.BP.incrementAndGet();
    ((gm)fo()).a(paramString1, paramString2, l);
    this.BT.put(Long.valueOf(l), paramd);
  }
  
  public void a(String paramString, boolean paramBoolean, a.d<Cast.ApplicationConnectionResult> paramd)
    throws IllegalStateException, RemoteException
  {
    c(paramd);
    ((gm)fo()).e(paramString, paramBoolean);
  }
  
  public void aj(String paramString)
    throws IllegalArgumentException, RemoteException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Channel namespace cannot be null or empty");
    }
    synchronized (this.BH)
    {
      Cast.MessageReceivedCallback localMessageReceivedCallback = (Cast.MessageReceivedCallback)this.BH.remove(paramString);
      if (localMessageReceivedCallback == null) {}
    }
  }
  
  public void b(String paramString1, String paramString2, a.d<Cast.ApplicationConnectionResult> paramd)
    throws IllegalStateException, RemoteException
  {
    c(paramd);
    ((gm)fo()).h(paramString1, paramString2);
  }
  
  protected String bp()
  {
    return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
  }
  
  protected String bq()
  {
    return "com.google.android.gms.cast.internal.ICastDeviceController";
  }
  
  public void d(a.d<Status> paramd)
    throws IllegalStateException, RemoteException
  {
    e(paramd);
    ((gm)fo()).ek();
  }
  
  public void disconnect()
  {
    BD.b("disconnect(); mDisconnecting=%b, isConnected=%b", new Object[] { Boolean.valueOf(this.BN.get()), Boolean.valueOf(isConnected()) });
    if (this.BN.getAndSet(true))
    {
      BD.b("mDisconnecting is set, so short-circuiting", new Object[0]);
      return;
    }
    ed();
    try
    {
      if ((isConnected()) || (isConnecting())) {
        ((gm)fo()).disconnect();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      BD.a(localRemoteException, "Error while disconnecting the controller interface: %s", new Object[] { localRemoteException.getMessage() });
      return;
    }
    finally
    {
      super.disconnect();
    }
  }
  
  public Bundle ea()
  {
    if (this.BS != null)
    {
      Bundle localBundle = this.BS;
      this.BS = null;
      return localBundle;
    }
    return super.ea();
  }
  
  public void eb()
    throws IllegalStateException, RemoteException
  {
    ((gm)fo()).eb();
  }
  
  public double ec()
    throws IllegalStateException
  {
    ee();
    return this.AM;
  }
  
  public ApplicationMetadata getApplicationMetadata()
    throws IllegalStateException
  {
    ee();
    return this.BE;
  }
  
  public String getApplicationStatus()
    throws IllegalStateException
  {
    ee();
    return this.BJ;
  }
  
  public boolean isMute()
    throws IllegalStateException
  {
    ee();
    return this.AN;
  }
  
  public void y(boolean paramBoolean)
    throws IllegalStateException, RemoteException
  {
    ((gm)fo()).a(paramBoolean, this.AM, this.AN);
  }
  
  private static final class a
    implements Cast.ApplicationConnectionResult
  {
    private final ApplicationMetadata Cf;
    private final String Cg;
    private final boolean Ch;
    private final String rO;
    private final Status yw;
    
    public a(Status paramStatus)
    {
      this(paramStatus, null, null, null, false);
    }
    
    public a(Status paramStatus, ApplicationMetadata paramApplicationMetadata, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.yw = paramStatus;
      this.Cf = paramApplicationMetadata;
      this.Cg = paramString1;
      this.rO = paramString2;
      this.Ch = paramBoolean;
    }
    
    public ApplicationMetadata getApplicationMetadata()
    {
      return this.Cf;
    }
    
    public String getApplicationStatus()
    {
      return this.Cg;
    }
    
    public String getSessionId()
    {
      return this.rO;
    }
    
    public Status getStatus()
    {
      return this.yw;
    }
    
    public boolean getWasLaunched()
    {
      return this.Ch;
    }
  }
  
  private class b
    implements GoogleApiClient.OnConnectionFailedListener
  {
    private b() {}
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      gi.j(gi.this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/gi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */