package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.a;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public abstract class hc<T extends IInterface>
  implements Api.a, hd.b
{
  public static final String[] Ge = { "service_esmobile", "service_googleme" };
  private final Looper DC;
  private final hd DP;
  private T FY;
  private final ArrayList<hc<T>.b<?>> FZ = new ArrayList();
  private hc<T>.f Ga;
  private volatile int Gb = 1;
  private final String[] Gc;
  boolean Gd = false;
  private final Context mContext;
  final Handler mHandler;
  
  protected hc(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String... paramVarArgs)
  {
    this.mContext = ((Context)hn.f(paramContext));
    this.DC = ((Looper)hn.b(paramLooper, "Looper must not be null"));
    this.DP = new hd(paramContext, paramLooper, this);
    this.mHandler = new a(paramLooper);
    b(paramVarArgs);
    this.Gc = paramVarArgs;
    registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)hn.f(paramConnectionCallbacks));
    registerConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)hn.f(paramOnConnectionFailedListener));
  }
  
  @Deprecated
  protected hc(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, String... paramVarArgs)
  {
    this(paramContext, paramContext.getMainLooper(), new c(paramConnectionCallbacks), new g(paramOnConnectionFailedListener), paramVarArgs);
  }
  
  private void am(int paramInt)
  {
    int i = this.Gb;
    this.Gb = paramInt;
    if (i != paramInt)
    {
      if (paramInt != 3) {
        break label25;
      }
      onConnected();
    }
    label25:
    while ((i != 3) || (paramInt != 1)) {
      return;
    }
    onDisconnected();
  }
  
  protected final void I(IBinder paramIBinder)
  {
    try
    {
      a(hj.a.L(paramIBinder), new e(this));
      return;
    }
    catch (RemoteException paramIBinder)
    {
      Log.w("GmsClient", "service died");
    }
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new h(paramInt, paramIBinder, paramBundle)));
  }
  
  @Deprecated
  public final void a(hc<T>.b<?> paramhc)
  {
    synchronized (this.FZ)
    {
      this.FZ.add(paramhc);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(2, paramhc));
      return;
    }
  }
  
  protected abstract void a(hj paramhj, e parame)
    throws RemoteException;
  
  public void an(int paramInt)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(paramInt)));
  }
  
  protected void b(String... paramVarArgs) {}
  
  protected abstract String bp();
  
  protected abstract String bq();
  
  protected final void ci()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public void connect()
  {
    this.Gd = true;
    am(2);
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
    if (i != 0)
    {
      am(1);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(i)));
    }
    do
    {
      return;
      if (this.Ga != null)
      {
        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
        this.FY = null;
        he.B(this.mContext).b(bp(), this.Ga);
      }
      this.Ga = new f();
    } while (he.B(this.mContext).a(bp(), this.Ga));
    Log.e("GmsClient", "unable to connect to service: " + bp());
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
  }
  
  public void disconnect()
  {
    this.Gd = false;
    synchronized (this.FZ)
    {
      int j = this.FZ.size();
      int i = 0;
      while (i < j)
      {
        ((b)this.FZ.get(i)).fr();
        i += 1;
      }
      this.FZ.clear();
      am(1);
      this.FY = null;
      if (this.Ga != null)
      {
        he.B(this.mContext).b(bp(), this.Ga);
        this.Ga = null;
      }
      return;
    }
  }
  
  public boolean eJ()
  {
    return this.Gd;
  }
  
  public Bundle ea()
  {
    return null;
  }
  
  public final String[] fn()
  {
    return this.Gc;
  }
  
  public final T fo()
  {
    ci();
    return this.FY;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public final Looper getLooper()
  {
    return this.DC;
  }
  
  public boolean isConnected()
  {
    return this.Gb == 3;
  }
  
  public boolean isConnecting()
  {
    return this.Gb == 2;
  }
  
  @Deprecated
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.DP.isConnectionCallbacksRegistered(new c(paramConnectionCallbacks));
  }
  
  @Deprecated
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.DP.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  protected void onConnected() {}
  
  protected void onDisconnected() {}
  
  @Deprecated
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.DP.registerConnectionCallbacks(new c(paramConnectionCallbacks));
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.DP.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  @Deprecated
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.DP.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.DP.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  @Deprecated
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.DP.unregisterConnectionCallbacks(new c(paramConnectionCallbacks));
  }
  
  @Deprecated
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.DP.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  protected abstract T x(IBinder paramIBinder);
  
  final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((paramMessage.what == 1) && (!hc.this.isConnecting()))
      {
        paramMessage = (hc.b)paramMessage.obj;
        paramMessage.fp();
        paramMessage.unregister();
        return;
      }
      if (paramMessage.what == 3)
      {
        hc.a(hc.this).a(new ConnectionResult(((Integer)paramMessage.obj).intValue(), null));
        return;
      }
      if (paramMessage.what == 4)
      {
        hc.a(hc.this, 1);
        hc.a(hc.this, null);
        hc.a(hc.this).ao(((Integer)paramMessage.obj).intValue());
        return;
      }
      if ((paramMessage.what == 2) && (!hc.this.isConnected()))
      {
        paramMessage = (hc.b)paramMessage.obj;
        paramMessage.fp();
        paramMessage.unregister();
        return;
      }
      if ((paramMessage.what == 2) || (paramMessage.what == 1))
      {
        ((hc.b)paramMessage.obj).fq();
        return;
      }
      Log.wtf("GmsClient", "Don't know how to handle this message.");
    }
  }
  
  protected abstract class b<TListener>
  {
    private boolean Gg;
    private TListener mListener;
    
    public b()
    {
      Object localObject;
      this.mListener = localObject;
      this.Gg = false;
    }
    
    protected abstract void d(TListener paramTListener);
    
    protected abstract void fp();
    
    /* Error */
    public void fq()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 24	com/google/android/gms/internal/hc$b:mListener	Ljava/lang/Object;
      //   6: astore_1
      //   7: aload_0
      //   8: getfield 26	com/google/android/gms/internal/hc$b:Gg	Z
      //   11: ifeq +33 -> 44
      //   14: ldc 37
      //   16: new 39	java/lang/StringBuilder
      //   19: dup
      //   20: invokespecial 40	java/lang/StringBuilder:<init>	()V
      //   23: ldc 42
      //   25: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   28: aload_0
      //   29: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   32: ldc 51
      //   34: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   40: invokestatic 61	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   43: pop
      //   44: aload_0
      //   45: monitorexit
      //   46: aload_1
      //   47: ifnull +34 -> 81
      //   50: aload_0
      //   51: aload_1
      //   52: invokevirtual 63	com/google/android/gms/internal/hc$b:d	(Ljava/lang/Object;)V
      //   55: aload_0
      //   56: monitorenter
      //   57: aload_0
      //   58: iconst_1
      //   59: putfield 26	com/google/android/gms/internal/hc$b:Gg	Z
      //   62: aload_0
      //   63: monitorexit
      //   64: aload_0
      //   65: invokevirtual 66	com/google/android/gms/internal/hc$b:unregister	()V
      //   68: return
      //   69: astore_1
      //   70: aload_0
      //   71: monitorexit
      //   72: aload_1
      //   73: athrow
      //   74: astore_1
      //   75: aload_0
      //   76: invokevirtual 68	com/google/android/gms/internal/hc$b:fp	()V
      //   79: aload_1
      //   80: athrow
      //   81: aload_0
      //   82: invokevirtual 68	com/google/android/gms/internal/hc$b:fp	()V
      //   85: goto -30 -> 55
      //   88: astore_1
      //   89: aload_0
      //   90: monitorexit
      //   91: aload_1
      //   92: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	93	0	this	b
      //   6	46	1	localObject1	Object
      //   69	4	1	localObject2	Object
      //   74	6	1	localRuntimeException	RuntimeException
      //   88	4	1	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   2	44	69	finally
      //   44	46	69	finally
      //   70	72	69	finally
      //   50	55	74	java/lang/RuntimeException
      //   57	64	88	finally
      //   89	91	88	finally
    }
    
    public void fr()
    {
      try
      {
        this.mListener = null;
        return;
      }
      finally {}
    }
    
    public void unregister()
    {
      fr();
      synchronized (hc.b(hc.this))
      {
        hc.b(hc.this).remove(this);
        return;
      }
    }
  }
  
  public static final class c
    implements GoogleApiClient.ConnectionCallbacks
  {
    private final GooglePlayServicesClient.ConnectionCallbacks Gh;
    
    public c(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      this.Gh = paramConnectionCallbacks;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof c)) {
        return this.Gh.equals(((c)paramObject).Gh);
      }
      return this.Gh.equals(paramObject);
    }
    
    public void onConnected(Bundle paramBundle)
    {
      this.Gh.onConnected(paramBundle);
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      this.Gh.onDisconnected();
    }
  }
  
  public abstract class d<TListener>
    extends hc<T>.b<TListener>
  {
    private final DataHolder DD;
    
    public d(DataHolder paramDataHolder)
    {
      super(paramDataHolder);
      DataHolder localDataHolder;
      this.DD = localDataHolder;
    }
    
    protected abstract void a(TListener paramTListener, DataHolder paramDataHolder);
    
    protected final void d(TListener paramTListener)
    {
      a(paramTListener, this.DD);
    }
    
    protected void fp()
    {
      if (this.DD != null) {
        this.DD.close();
      }
    }
  }
  
  public static final class e
    extends hi.a
  {
    private hc Gi;
    
    public e(hc paramhc)
    {
      this.Gi = paramhc;
    }
    
    public void b(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      hn.b("onPostInitComplete can be called only once per call to getServiceFromBroker", this.Gi);
      this.Gi.a(paramInt, paramIBinder, paramBundle);
      this.Gi = null;
    }
  }
  
  final class f
    implements ServiceConnection
  {
    f() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      hc.this.I(paramIBinder);
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      hc.this.mHandler.sendMessage(hc.this.mHandler.obtainMessage(4, Integer.valueOf(1)));
    }
  }
  
  public static final class g
    implements GoogleApiClient.OnConnectionFailedListener
  {
    private final GooglePlayServicesClient.OnConnectionFailedListener Gj;
    
    public g(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.Gj = paramOnConnectionFailedListener;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof g)) {
        return this.Gj.equals(((g)paramObject).Gj);
      }
      return this.Gj.equals(paramObject);
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      this.Gj.onConnectionFailed(paramConnectionResult);
    }
  }
  
  protected final class h
    extends hc<T>.b<Boolean>
  {
    public final Bundle Gk;
    public final IBinder Gl;
    public final int statusCode;
    
    public h(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      super(Boolean.valueOf(true));
      this.statusCode = paramInt;
      this.Gl = paramIBinder;
      this.Gk = paramBundle;
    }
    
    protected void b(Boolean paramBoolean)
    {
      if (paramBoolean == null)
      {
        hc.a(hc.this, 1);
        return;
      }
      switch (this.statusCode)
      {
      default: 
        if (this.Gk == null) {
          break;
        }
      }
      for (paramBoolean = (PendingIntent)this.Gk.getParcelable("pendingIntent");; paramBoolean = null)
      {
        if (hc.d(hc.this) != null)
        {
          he.B(hc.e(hc.this)).b(hc.this.bp(), hc.d(hc.this));
          hc.a(hc.this, null);
        }
        hc.a(hc.this, 1);
        hc.a(hc.this, null);
        hc.a(hc.this).a(new ConnectionResult(this.statusCode, paramBoolean));
        return;
        try
        {
          paramBoolean = this.Gl.getInterfaceDescriptor();
          if (hc.this.bq().equals(paramBoolean))
          {
            hc.a(hc.this, hc.this.x(this.Gl));
            if (hc.c(hc.this) != null)
            {
              hc.a(hc.this, 3);
              hc.a(hc.this).ck();
              return;
            }
          }
        }
        catch (RemoteException paramBoolean)
        {
          he.B(hc.e(hc.this)).b(hc.this.bp(), hc.d(hc.this));
          hc.a(hc.this, null);
          hc.a(hc.this, 1);
          hc.a(hc.this, null);
          hc.a(hc.this).a(new ConnectionResult(8, null));
          return;
        }
        hc.a(hc.this, 1);
        throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
      }
    }
    
    protected void fp() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/hc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */