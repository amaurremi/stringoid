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
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class gh
  extends hb<gl>
{
  private static final gn BG = new gn("CastClientImpl");
  private static final Object Ca = new Object();
  private static final Object Cb = new Object();
  private double AP;
  private boolean AQ;
  private final Cast.Listener Ae;
  private ApplicationMetadata BH;
  private final CastDevice BI;
  private final gm BJ;
  private final Map<String, Cast.MessageReceivedCallback> BK;
  private final long BL;
  private String BM;
  private boolean BN;
  private boolean BO;
  private boolean BP;
  private AtomicBoolean BQ;
  private int BR;
  private final AtomicLong BS;
  private String BT;
  private String BU;
  private Bundle BV;
  private Map<Long, a.d<Status>> BW;
  private oj BX;
  private a.d<Cast.ApplicationConnectionResult> BY;
  private a.d<Status> BZ;
  private final Handler mHandler;
  
  public gh(Context paramContext, Looper paramLooper, CastDevice paramCastDevice, long paramLong, Cast.Listener paramListener, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, (String[])null);
    this.BI = paramCastDevice;
    this.Ae = paramListener;
    this.BL = paramLong;
    this.mHandler = new Handler(paramLooper);
    this.BK = new HashMap();
    this.BP = false;
    this.BR = -1;
    this.BH = null;
    this.BM = null;
    this.BQ = new AtomicBoolean(false);
    this.AP = 0.0D;
    this.AQ = false;
    this.BS = new AtomicLong(0L);
    this.BW = new HashMap();
    this.BX = new oj(this, null);
    registerConnectionFailedListener(this.BX);
    this.BJ = new gm.a()
    {
      private void a(long paramAnonymousLong, int paramAnonymousInt)
      {
        synchronized (gh.h(gh.this))
        {
          a.d locald = (a.d)gh.h(gh.this).remove(Long.valueOf(paramAnonymousLong));
          if (locald != null) {
            locald.a(new Status(paramAnonymousInt));
          }
          return;
        }
      }
      
      private boolean a(int paramAnonymousInt)
      {
        synchronized ()
        {
          if (gh.i(gh.this) != null)
          {
            gh.i(gh.this).a(new Status(paramAnonymousInt));
            gh.b(gh.this, null);
            return true;
          }
          return false;
        }
      }
      
      public void T(int paramAnonymousInt)
      {
        gh.ek().b("ICastDeviceControllerListener.onDisconnected: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        gh.a(gh.this, false);
        gh.b(gh.this).set(false);
        gh.a(gh.this, null);
        if (paramAnonymousInt != 0) {
          gh.this.an(2);
        }
      }
      
      public void U(int paramAnonymousInt)
      {
        synchronized ()
        {
          if (gh.c(gh.this) != null)
          {
            gh.c(gh.this).a(new oi(new Status(paramAnonymousInt)));
            gh.a(gh.this, null);
          }
          return;
        }
      }
      
      public void V(int paramAnonymousInt)
      {
        a(paramAnonymousInt);
      }
      
      public void W(int paramAnonymousInt)
      {
        a(paramAnonymousInt);
      }
      
      public void a(ApplicationMetadata paramAnonymousApplicationMetadata, String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        gh.a(gh.this, paramAnonymousApplicationMetadata);
        gh.a(gh.this, paramAnonymousApplicationMetadata.getApplicationId());
        gh.b(gh.this, paramAnonymousString2);
        synchronized (gh.el())
        {
          if (gh.c(gh.this) != null)
          {
            gh.c(gh.this).a(new oi(new Status(0), paramAnonymousApplicationMetadata, paramAnonymousString1, paramAnonymousString2, paramAnonymousBoolean));
            gh.a(gh.this, null);
          }
          return;
        }
      }
      
      public void a(String paramAnonymousString, double paramAnonymousDouble, boolean paramAnonymousBoolean)
      {
        gh.ek().b("Deprecated callback: \"onStatusreceived\"", new Object[0]);
      }
      
      public void a(String paramAnonymousString, long paramAnonymousLong)
      {
        a(paramAnonymousLong, 0);
      }
      
      public void a(String paramAnonymousString, long paramAnonymousLong, int paramAnonymousInt)
      {
        a(paramAnonymousLong, paramAnonymousInt);
      }
      
      public void b(final ge paramAnonymousge)
      {
        gh.ek().b("onApplicationStatusChanged", new Object[0]);
        gh.e(gh.this).post(new Runnable()
        {
          public void run()
          {
            gh.a(gh.this, paramAnonymousge);
          }
        });
      }
      
      public void b(final gj paramAnonymousgj)
      {
        gh.ek().b("onDeviceStatusChanged", new Object[0]);
        gh.e(gh.this).post(new Runnable()
        {
          public void run()
          {
            gh.a(gh.this, paramAnonymousgj);
          }
        });
      }
      
      public void b(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        gh.ek().b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousArrayOfByte.length) });
      }
      
      public void g(final String paramAnonymousString1, final String paramAnonymousString2)
      {
        gh.ek().b("Receive (type=text, ns=%s) %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        gh.e(gh.this).post(new Runnable()
        {
          public void run()
          {
            synchronized (gh.f(gh.this))
            {
              Cast.MessageReceivedCallback localMessageReceivedCallback = (Cast.MessageReceivedCallback)gh.f(gh.this).get(paramAnonymousString1);
              if (localMessageReceivedCallback != null)
              {
                localMessageReceivedCallback.onMessageReceived(gh.g(gh.this), paramAnonymousString1, paramAnonymousString2);
                return;
              }
            }
            gh.ek().b("Discarded message for unknown namespace '%s'", new Object[] { paramAnonymousString1 });
          }
        });
      }
      
      public void onApplicationDisconnected(final int paramAnonymousInt)
      {
        gh.a(gh.this, null);
        gh.b(gh.this, null);
        a(paramAnonymousInt);
        if (gh.d(gh.this) != null) {
          gh.e(gh.this).post(new Runnable()
          {
            public void run()
            {
              if (gh.d(gh.this) != null) {
                gh.d(gh.this).onApplicationDisconnected(paramAnonymousInt);
              }
            }
          });
        }
      }
    };
  }
  
  private void a(ge paramge)
  {
    paramge = paramge.ec();
    if (!gi.a(paramge, this.BM)) {
      this.BM = paramge;
    }
    for (boolean bool = true;; bool = false)
    {
      BG.b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.BN) });
      if ((this.Ae != null) && ((bool) || (this.BN))) {
        this.Ae.onApplicationStatusChanged();
      }
      this.BN = false;
      return;
    }
  }
  
  private void a(gj paramgj)
  {
    double d = paramgj.eh();
    if ((d != NaN.0D) && (d != this.AP)) {
      this.AP = d;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = paramgj.en();
      if (bool2 != this.AQ)
      {
        this.AQ = bool2;
        bool1 = true;
      }
      BG.b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.BO) });
      if ((this.Ae != null) && ((bool1) || (this.BO))) {
        this.Ae.onVolumeChanged();
      }
      int i = paramgj.eo();
      if (i != this.BR) {
        this.BR = i;
      }
      for (bool1 = true;; bool1 = false)
      {
        BG.b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.BO) });
        if ((this.Ae != null) && ((bool1) || (this.BO))) {
          this.Ae.O(this.BR);
        }
        this.BO = false;
        return;
      }
    }
  }
  
  private void c(a.d<Cast.ApplicationConnectionResult> paramd)
  {
    synchronized (Ca)
    {
      if (this.BY != null) {
        this.BY.a(new oi(new Status(2002)));
      }
      this.BY = paramd;
      return;
    }
  }
  
  private void e(a.d<Status> paramd)
  {
    synchronized (Cb)
    {
      if (this.BZ != null)
      {
        paramd.a(new Status(2001));
        return;
      }
      this.BZ = paramd;
      return;
    }
  }
  
  private void ei()
  {
    BG.b("removing all MessageReceivedCallbacks", new Object[0]);
    synchronized (this.BK)
    {
      this.BK.clear();
      return;
    }
  }
  
  private void ej()
  {
    if ((!this.BP) || (this.BQ.get())) {
      throw new IllegalStateException("Not connected to a device");
    }
  }
  
  protected gl G(IBinder paramIBinder)
  {
    return gl.a.H(paramIBinder);
  }
  
  public void a(double paramDouble)
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
      throw new IllegalArgumentException("Volume cannot be " + paramDouble);
    }
    ((gl)ft()).a(paramDouble, this.AP, this.AQ);
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    BG.b("in onPostInitHandler; statusCode=%d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) || (paramInt == 1001))
    {
      this.BP = true;
      this.BN = true;
      this.BO = true;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 1001)
      {
        this.BV = new Bundle();
        this.BV.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
        i = 0;
      }
      super.a(i, paramIBinder, paramBundle);
      return;
      this.BP = false;
    }
  }
  
  protected void a(hi paramhi, hb.e parame)
  {
    Bundle localBundle = new Bundle();
    BG.b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", new Object[] { this.BT, this.BU });
    this.BI.putInBundle(localBundle);
    localBundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.BL);
    if (this.BT != null)
    {
      localBundle.putString("last_application_id", this.BT);
      if (this.BU != null) {
        localBundle.putString("last_session_id", this.BU);
      }
    }
    paramhi.a(parame, 5089000, getContext().getPackageName(), this.BJ.asBinder(), localBundle);
  }
  
  public void a(String paramString, Cast.MessageReceivedCallback paramMessageReceivedCallback)
  {
    gi.ak(paramString);
    aj(paramString);
    if (paramMessageReceivedCallback != null) {}
    synchronized (this.BK)
    {
      this.BK.put(paramString, paramMessageReceivedCallback);
      ((gl)ft()).an(paramString);
      return;
    }
  }
  
  public void a(String paramString, LaunchOptions paramLaunchOptions, a.d<Cast.ApplicationConnectionResult> paramd)
  {
    c(paramd);
    ((gl)ft()).a(paramString, paramLaunchOptions);
  }
  
  public void a(String paramString, a.d<Status> paramd)
  {
    e(paramd);
    ((gl)ft()).am(paramString);
  }
  
  public void a(String paramString1, String paramString2, a.d<Status> paramd)
  {
    if (TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("The message payload cannot be null or empty");
    }
    if (paramString2.length() > 65536) {
      throw new IllegalArgumentException("Message exceeds maximum size");
    }
    gi.ak(paramString1);
    ej();
    long l = this.BS.incrementAndGet();
    ((gl)ft()).a(paramString1, paramString2, l);
    this.BW.put(Long.valueOf(l), paramd);
  }
  
  public void a(String paramString, boolean paramBoolean, a.d<Cast.ApplicationConnectionResult> paramd)
  {
    c(paramd);
    ((gl)ft()).e(paramString, paramBoolean);
  }
  
  public void aj(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Channel namespace cannot be null or empty");
    }
    synchronized (this.BK)
    {
      Cast.MessageReceivedCallback localMessageReceivedCallback = (Cast.MessageReceivedCallback)this.BK.remove(paramString);
      if (localMessageReceivedCallback == null) {}
    }
  }
  
  public void b(String paramString1, String paramString2, a.d<Cast.ApplicationConnectionResult> paramd)
  {
    c(paramd);
    ((gl)ft()).h(paramString1, paramString2);
  }
  
  protected String bu()
  {
    return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
  }
  
  protected String bv()
  {
    return "com.google.android.gms.cast.internal.ICastDeviceController";
  }
  
  public void d(a.d<Status> paramd)
  {
    e(paramd);
    ((gl)ft()).ep();
  }
  
  public void disconnect()
  {
    BG.b("disconnect(); mDisconnecting=%b, isConnected=%b", new Object[] { Boolean.valueOf(this.BQ.get()), Boolean.valueOf(isConnected()) });
    if (this.BQ.getAndSet(true))
    {
      BG.b("mDisconnecting is set, so short-circuiting", new Object[0]);
      return;
    }
    ei();
    try
    {
      if ((isConnected()) || (isConnecting())) {
        ((gl)ft()).disconnect();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      BG.a(localRemoteException, "Error while disconnecting the controller interface: %s", new Object[] { localRemoteException.getMessage() });
      return;
    }
    finally
    {
      super.disconnect();
    }
  }
  
  public Bundle ef()
  {
    if (this.BV != null)
    {
      Bundle localBundle = this.BV;
      this.BV = null;
      return localBundle;
    }
    return super.ef();
  }
  
  public void eg()
  {
    ((gl)ft()).eg();
  }
  
  public double eh()
  {
    ej();
    return this.AP;
  }
  
  public ApplicationMetadata getApplicationMetadata()
  {
    ej();
    return this.BH;
  }
  
  public String getApplicationStatus()
  {
    ej();
    return this.BM;
  }
  
  public boolean isMute()
  {
    ej();
    return this.AQ;
  }
  
  public void y(boolean paramBoolean)
  {
    ((gl)ft()).a(paramBoolean, this.AP, this.AQ);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/gh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */