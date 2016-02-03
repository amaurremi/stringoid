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
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.c;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class dg
  extends dw<di>
{
  private static final dk lA = new dk("CastClientImpl");
  private static final Object lQ = new Object();
  private static final Object lR = new Object();
  private final Cast.Listener kw;
  private ApplicationMetadata lB;
  private final CastDevice lC;
  private final dj lD;
  private final Map<String, Cast.MessageReceivedCallback> lE;
  private final long lF;
  private String lG;
  private boolean lH;
  private boolean lI;
  private final AtomicLong lJ;
  private String lK;
  private String lL;
  private Bundle lM;
  private Map<Long, a.c<Status>> lN;
  private a.c<Cast.ApplicationConnectionResult> lO;
  private a.c<Status> lP;
  private double lb;
  private boolean lc;
  private final Handler mHandler;
  
  public dg(Context paramContext, CastDevice paramCastDevice, long paramLong, Cast.Listener paramListener, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, (String[])null);
    this.lC = paramCastDevice;
    this.kw = paramListener;
    this.lF = paramLong;
    this.mHandler = new Handler(Looper.getMainLooper());
    this.lE = new HashMap();
    this.lI = false;
    this.lB = null;
    this.lG = null;
    this.lb = 0.0D;
    this.lc = false;
    this.lJ = new AtomicLong(0L);
    this.lN = new HashMap();
    this.lD = new dj.a()
    {
      private void b(long paramAnonymousLong, int paramAnonymousInt)
      {
        synchronized (dg.g(dg.this))
        {
          a.c localc = (a.c)dg.g(dg.this).remove(Long.valueOf(paramAnonymousLong));
          if (localc != null) {
            localc.a(new Status(paramAnonymousInt));
          }
          return;
        }
      }
      
      private boolean x(int paramAnonymousInt)
      {
        synchronized ()
        {
          if (dg.h(dg.this) != null)
          {
            dg.h(dg.this).a(new Status(paramAnonymousInt));
            dg.b(dg.this, null);
            return true;
          }
          return false;
        }
      }
      
      public void a(ApplicationMetadata paramAnonymousApplicationMetadata, String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        dg.a(dg.this, paramAnonymousApplicationMetadata.getApplicationId());
        dg.b(dg.this, paramAnonymousString2);
        synchronized (dg.aZ())
        {
          if (dg.b(dg.this) != null)
          {
            dg.b(dg.this).a(new dg.a(new Status(0), paramAnonymousApplicationMetadata, paramAnonymousString1, paramAnonymousString2, paramAnonymousBoolean));
            dg.a(dg.this, null);
          }
          return;
        }
      }
      
      public void a(String paramAnonymousString, long paramAnonymousLong)
      {
        b(paramAnonymousLong, 0);
      }
      
      public void a(String paramAnonymousString, long paramAnonymousLong, int paramAnonymousInt)
      {
        b(paramAnonymousLong, paramAnonymousInt);
      }
      
      public void a(final String paramAnonymousString1, final String paramAnonymousString2)
      {
        dg.aY().b("Receive (type=text, ns=%s) %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        dg.d(dg.this).post(new Runnable()
        {
          public void run()
          {
            synchronized (dg.e(dg.this))
            {
              Cast.MessageReceivedCallback localMessageReceivedCallback = (Cast.MessageReceivedCallback)dg.e(dg.this).get(paramAnonymousString1);
              if (localMessageReceivedCallback != null)
              {
                localMessageReceivedCallback.onMessageReceived(dg.f(dg.this), paramAnonymousString1, paramAnonymousString2);
                return;
              }
            }
            dg.aY().b("Discarded message for unknown namespace '%s'", new Object[] { paramAnonymousString1 });
          }
        });
      }
      
      public void b(final String paramAnonymousString, final double paramAnonymousDouble, boolean paramAnonymousBoolean)
      {
        dg.d(dg.this).post(new Runnable()
        {
          public void run()
          {
            dg.a(dg.this, paramAnonymousString, paramAnonymousDouble, this.lq);
          }
        });
      }
      
      public void b(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        dg.aY().b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousArrayOfByte.length) });
      }
      
      public void onApplicationDisconnected(final int paramAnonymousInt)
      {
        dg.a(dg.this, null);
        dg.b(dg.this, null);
        if (x(paramAnonymousInt)) {}
        while (dg.c(dg.this) == null) {
          return;
        }
        dg.d(dg.this).post(new Runnable()
        {
          public void run()
          {
            if (dg.c(dg.this) != null) {
              dg.c(dg.this).onApplicationDisconnected(paramAnonymousInt);
            }
          }
        });
      }
      
      public void t(int paramAnonymousInt)
      {
        dg.aY().b("ICastDeviceControllerListener.onDisconnected", new Object[0]);
        dg.a(dg.this, false);
        dg.a(dg.this, null);
        if (paramAnonymousInt != 0) {
          dg.this.I(2);
        }
      }
      
      public void u(int paramAnonymousInt)
      {
        synchronized ()
        {
          if (dg.b(dg.this) != null)
          {
            dg.b(dg.this).a(new dg.a(new Status(paramAnonymousInt)));
            dg.a(dg.this, null);
          }
          return;
        }
      }
      
      public void v(int paramAnonymousInt)
      {
        x(paramAnonymousInt);
      }
      
      public void w(int paramAnonymousInt)
      {
        x(paramAnonymousInt);
      }
    };
  }
  
  private void a(String paramString, double paramDouble, boolean paramBoolean)
  {
    if (!dh.a(paramString, this.lG)) {
      this.lG = paramString;
    }
    for (int i = 1;; i = 0)
    {
      if ((this.kw != null) && ((i != 0) || (this.lH))) {
        this.kw.onApplicationStatusChanged();
      }
      if (paramDouble != this.lb) {
        this.lb = paramDouble;
      }
      for (boolean bool = true;; bool = false)
      {
        if (paramBoolean != this.lc)
        {
          this.lc = paramBoolean;
          bool = true;
        }
        lA.b("hasChange=%b, mFirstStatusUpdate=%b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.lH) });
        if ((this.kw != null) && ((bool) || (this.lH))) {
          this.kw.onVolumeChanged();
        }
        this.lH = false;
        return;
      }
    }
  }
  
  private void aX()
    throws IllegalStateException
  {
    if (!this.lI) {
      throw new IllegalStateException("not connected to a device");
    }
  }
  
  private void d(a.c<Cast.ApplicationConnectionResult> paramc)
  {
    synchronized (lQ)
    {
      if (this.lO != null) {
        this.lO.a(new a(new Status(2002)));
      }
      this.lO = paramc;
      return;
    }
  }
  
  private void f(a.c<Status> paramc)
  {
    synchronized (lR)
    {
      if (this.lP != null)
      {
        paramc.a(new Status(2001));
        return;
      }
      this.lP = paramc;
      return;
    }
  }
  
  public void C(String paramString)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Channel namespace cannot be null or empty");
    }
    synchronized (this.lE)
    {
      Cast.MessageReceivedCallback localMessageReceivedCallback = (Cast.MessageReceivedCallback)this.lE.remove(paramString);
      if (localMessageReceivedCallback != null) {
        ((di)bQ()).F(paramString);
      }
      return;
    }
  }
  
  public void a(double paramDouble)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
      throw new IllegalArgumentException("Volume cannot be " + paramDouble);
    }
    ((di)bQ()).a(paramDouble, this.lb, this.lc);
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if ((paramInt == 0) || (paramInt == 1001))
    {
      this.lI = true;
      this.lH = true;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 1001)
      {
        this.lM = new Bundle();
        this.lM.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
        i = 0;
      }
      super.a(i, paramIBinder, paramBundle);
      return;
      this.lI = false;
    }
  }
  
  protected void a(ec paramec, dw.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    lA.b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", new Object[] { this.lK, this.lL });
    this.lC.putInBundle(localBundle);
    localBundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.lF);
    if (this.lK != null)
    {
      localBundle.putString("last_application_id", this.lK);
      if (this.lL != null) {
        localBundle.putString("last_session_id", this.lL);
      }
    }
    paramec.a(parame, 4242000, getContext().getPackageName(), this.lD.asBinder(), localBundle);
  }
  
  public void a(String paramString, Cast.MessageReceivedCallback paramMessageReceivedCallback)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Channel namespace cannot be null or empty");
    }
    C(paramString);
    if (paramMessageReceivedCallback != null) {}
    synchronized (this.lE)
    {
      this.lE.put(paramString, paramMessageReceivedCallback);
      ((di)bQ()).E(paramString);
      return;
    }
  }
  
  public void a(String paramString, a.c<Status> paramc)
    throws IllegalStateException, RemoteException
  {
    f(paramc);
    ((di)bQ()).D(paramString);
  }
  
  public void a(String paramString1, String paramString2, a.c<Status> paramc)
    throws IllegalArgumentException, IllegalStateException, RemoteException
  {
    if (TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("The message payload cannot be null or empty");
    }
    if ((paramString1 == null) || (paramString1.length() > 128)) {
      throw new IllegalArgumentException("Invalid namespace length");
    }
    if (paramString2.length() > 65536) {
      throw new IllegalArgumentException("Message exceeds maximum size");
    }
    aX();
    long l = this.lJ.incrementAndGet();
    ((di)bQ()).a(paramString1, paramString2, l);
    this.lN.put(Long.valueOf(l), paramc);
  }
  
  public void a(String paramString, boolean paramBoolean, a.c<Cast.ApplicationConnectionResult> paramc)
    throws IllegalStateException, RemoteException
  {
    d(paramc);
    ((di)bQ()).c(paramString, paramBoolean);
  }
  
  public Bundle aU()
  {
    if (this.lM != null)
    {
      Bundle localBundle = this.lM;
      this.lM = null;
      return localBundle;
    }
    return super.aU();
  }
  
  public void aV()
    throws IllegalStateException, RemoteException
  {
    ((di)bQ()).aV();
  }
  
  public double aW()
    throws IllegalStateException
  {
    aX();
    return this.lb;
  }
  
  protected String am()
  {
    return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
  }
  
  protected String an()
  {
    return "com.google.android.gms.cast.internal.ICastDeviceController";
  }
  
  public void b(String paramString1, String paramString2, a.c<Cast.ApplicationConnectionResult> paramc)
    throws IllegalStateException, RemoteException
  {
    d(paramc);
    ((di)bQ()).b(paramString1, paramString2);
  }
  
  public void disconnect()
  {
    for (;;)
    {
      try
      {
        if (!isConnected()) {}
      }
      catch (RemoteException localRemoteException)
      {
        lA.b("Error while disconnecting the controller interface: %s", new Object[] { localRemoteException.getMessage() });
        continue;
      }
      finally
      {
        super.disconnect();
      }
      synchronized (this.lE)
      {
        this.lE.clear();
        ((di)bQ()).disconnect();
        super.disconnect();
        return;
      }
    }
  }
  
  public void e(a.c<Status> paramc)
    throws IllegalStateException, RemoteException
  {
    f(paramc);
    ((di)bQ()).bb();
  }
  
  public ApplicationMetadata getApplicationMetadata()
    throws IllegalStateException
  {
    aX();
    return this.lB;
  }
  
  public String getApplicationStatus()
    throws IllegalStateException
  {
    aX();
    return this.lG;
  }
  
  public boolean isMute()
    throws IllegalStateException
  {
    aX();
    return this.lc;
  }
  
  public void n(boolean paramBoolean)
    throws IllegalStateException, RemoteException
  {
    ((di)bQ()).a(paramBoolean, this.lb, this.lc);
  }
  
  protected di u(IBinder paramIBinder)
  {
    return di.a.v(paramIBinder);
  }
  
  private static final class a
    implements Cast.ApplicationConnectionResult
  {
    private final Status jY;
    private final ApplicationMetadata lX;
    private final String lY;
    private final String lZ;
    private final boolean ma;
    
    public a(Status paramStatus)
    {
      this(paramStatus, null, null, null, false);
    }
    
    public a(Status paramStatus, ApplicationMetadata paramApplicationMetadata, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.jY = paramStatus;
      this.lX = paramApplicationMetadata;
      this.lY = paramString1;
      this.lZ = paramString2;
      this.ma = paramBoolean;
    }
    
    public ApplicationMetadata getApplicationMetadata()
    {
      return this.lX;
    }
    
    public String getApplicationStatus()
    {
      return this.lY;
    }
    
    public String getSessionId()
    {
      return this.lZ;
    }
    
    public Status getStatus()
    {
      return this.jY;
    }
    
    public boolean getWasLaunched()
    {
      return this.ma;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */