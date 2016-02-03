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
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.a;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public abstract class dw<T extends IInterface>
  implements GooglePlayServicesClient, Api.a, dx.b
{
  public static final String[] pk = { "service_esmobile", "service_googleme" };
  private final String[] jF;
  private final Context mContext;
  final Handler mHandler;
  private final dx ne;
  private T pe;
  private final ArrayList<dw<T>.b<?>> pf = new ArrayList();
  private dw<T>.f pg;
  boolean ph = false;
  boolean pi = false;
  private final Object pj = new Object();
  
  protected dw(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, String... paramVarArgs)
  {
    this(paramContext, new c(paramConnectionCallbacks), new g(paramOnConnectionFailedListener), paramVarArgs);
  }
  
  protected dw(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String... paramVarArgs)
  {
    this.mContext = ((Context)eg.f(paramContext));
    this.ne = new dx(paramContext, this, null);
    this.mHandler = new a(paramContext.getMainLooper());
    a(paramVarArgs);
    this.jF = paramVarArgs;
    registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)eg.f(paramConnectionCallbacks));
    registerConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)eg.f(paramOnConnectionFailedListener));
  }
  
  public void I(int paramInt)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(paramInt)));
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new h(paramInt, paramIBinder, paramBundle)));
  }
  
  public final void a(dw<T>.b<?> paramdw)
  {
    synchronized (this.pf)
    {
      this.pf.add(paramdw);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(2, paramdw));
      return;
    }
  }
  
  protected abstract void a(ec paramec, e parame)
    throws RemoteException;
  
  protected void a(String... paramVarArgs) {}
  
  public Bundle aU()
  {
    return null;
  }
  
  protected abstract String am();
  
  protected abstract String an();
  
  public final String[] bO()
  {
    return this.jF;
  }
  
  protected final void bP()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  protected final T bQ()
  {
    bP();
    return this.pe;
  }
  
  public boolean bp()
  {
    return this.ph;
  }
  
  public void connect()
  {
    this.ph = true;
    do
    {
      synchronized (this.pj)
      {
        this.pi = true;
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (i != 0)
        {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(i)));
          return;
        }
      }
      if (this.pg != null)
      {
        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
        this.pe = null;
        dy.s(this.mContext).b(am(), this.pg);
      }
      this.pg = new f();
    } while (dy.s(this.mContext).a(am(), this.pg));
    Log.e("GmsClient", "unable to connect to service: " + am());
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
  }
  
  public void disconnect()
  {
    this.ph = false;
    synchronized (this.pj)
    {
      this.pi = false;
    }
    synchronized (this.pf)
    {
      int j = this.pf.size();
      int i = 0;
      while (i < j)
      {
        ((b)this.pf.get(i)).bS();
        i += 1;
        continue;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      this.pf.clear();
      this.pe = null;
      if (this.pg != null)
      {
        dy.s(this.mContext).b(am(), this.pg);
        this.pg = null;
        this.ne.J(-1);
      }
      return;
    }
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public boolean isConnected()
  {
    return this.pe != null;
  }
  
  public boolean isConnecting()
  {
    synchronized (this.pj)
    {
      boolean bool = this.pi;
      return bool;
    }
  }
  
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.ne.isConnectionCallbacksRegistered(new c(paramConnectionCallbacks));
  }
  
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.ne.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  protected abstract T p(IBinder paramIBinder);
  
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.ne.registerConnectionCallbacks(new c(paramConnectionCallbacks));
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.ne.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.ne.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.ne.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.ne.unregisterConnectionCallbacks(new c(paramConnectionCallbacks));
  }
  
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.ne.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  protected final void w(IBinder paramIBinder)
  {
    try
    {
      a(ec.a.y(paramIBinder), new e(this));
      return;
    }
    catch (RemoteException paramIBinder)
    {
      Log.w("GmsClient", "service died");
    }
  }
  
  final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((paramMessage.what == 1) && (!dw.this.isConnecting()))
      {
        paramMessage = (dw.b)paramMessage.obj;
        paramMessage.aL();
        paramMessage.unregister();
        return;
      }
      synchronized (dw.b(dw.this))
      {
        dw.this.pi = false;
        if (paramMessage.what == 3)
        {
          dw.a(dw.this).a(new ConnectionResult(((Integer)paramMessage.obj).intValue(), null));
          return;
        }
      }
      if (paramMessage.what == 4)
      {
        dw.a(dw.this).J(((Integer)paramMessage.obj).intValue());
        return;
      }
      if ((paramMessage.what == 2) && (!dw.this.isConnected()))
      {
        paramMessage = (dw.b)paramMessage.obj;
        paramMessage.aL();
        paramMessage.unregister();
        return;
      }
      if ((paramMessage.what == 2) || (paramMessage.what == 1))
      {
        ((dw.b)paramMessage.obj).bR();
        return;
      }
      Log.wtf("GmsClient", "Don't know how to handle this message.");
    }
  }
  
  protected abstract class b<TListener>
  {
    private TListener mListener;
    private boolean pm;
    
    public b()
    {
      Object localObject;
      this.mListener = localObject;
      this.pm = false;
    }
    
    protected abstract void aL();
    
    protected abstract void b(TListener paramTListener);
    
    /* Error */
    public void bR()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 24	com/google/android/gms/internal/dw$b:mListener	Ljava/lang/Object;
      //   6: astore_1
      //   7: aload_0
      //   8: getfield 26	com/google/android/gms/internal/dw$b:pm	Z
      //   11: ifeq +33 -> 44
      //   14: ldc 36
      //   16: new 38	java/lang/StringBuilder
      //   19: dup
      //   20: invokespecial 39	java/lang/StringBuilder:<init>	()V
      //   23: ldc 41
      //   25: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   28: aload_0
      //   29: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   32: ldc 50
      //   34: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   40: invokestatic 60	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   43: pop
      //   44: aload_0
      //   45: monitorexit
      //   46: aload_1
      //   47: ifnull +34 -> 81
      //   50: aload_0
      //   51: aload_1
      //   52: invokevirtual 62	com/google/android/gms/internal/dw$b:b	(Ljava/lang/Object;)V
      //   55: aload_0
      //   56: monitorenter
      //   57: aload_0
      //   58: iconst_1
      //   59: putfield 26	com/google/android/gms/internal/dw$b:pm	Z
      //   62: aload_0
      //   63: monitorexit
      //   64: aload_0
      //   65: invokevirtual 65	com/google/android/gms/internal/dw$b:unregister	()V
      //   68: return
      //   69: astore_1
      //   70: aload_0
      //   71: monitorexit
      //   72: aload_1
      //   73: athrow
      //   74: astore_1
      //   75: aload_0
      //   76: invokevirtual 67	com/google/android/gms/internal/dw$b:aL	()V
      //   79: aload_1
      //   80: athrow
      //   81: aload_0
      //   82: invokevirtual 67	com/google/android/gms/internal/dw$b:aL	()V
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
    
    public void bS()
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
      bS();
      synchronized (dw.c(dw.this))
      {
        dw.c(dw.this).remove(this);
        return;
      }
    }
  }
  
  public static final class c
    implements GoogleApiClient.ConnectionCallbacks
  {
    private final GooglePlayServicesClient.ConnectionCallbacks pn;
    
    public c(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      this.pn = paramConnectionCallbacks;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof c)) {
        return this.pn.equals(((c)paramObject).pn);
      }
      return this.pn.equals(paramObject);
    }
    
    public void onConnected(Bundle paramBundle)
    {
      this.pn.onConnected(paramBundle);
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      this.pn.onDisconnected();
    }
  }
  
  public abstract class d<TListener>
    extends dw<T>.b<TListener>
  {
    private final DataHolder nE;
    
    public d(DataHolder paramDataHolder)
    {
      super(paramDataHolder);
      DataHolder localDataHolder;
      this.nE = localDataHolder;
    }
    
    protected abstract void a(TListener paramTListener, DataHolder paramDataHolder);
    
    protected void aL()
    {
      if (this.nE != null) {
        this.nE.close();
      }
    }
    
    protected final void b(TListener paramTListener)
    {
      a(paramTListener, this.nE);
    }
  }
  
  public static final class e
    extends eb.a
  {
    private dw po;
    
    public e(dw paramdw)
    {
      this.po = paramdw;
    }
    
    public void b(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      eg.b("onPostInitComplete can be called only once per call to getServiceFromBroker", this.po);
      this.po.a(paramInt, paramIBinder, paramBundle);
      this.po = null;
    }
  }
  
  final class f
    implements ServiceConnection
  {
    f() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      dw.this.w(paramIBinder);
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      dw.a(dw.this, null);
      dw.a(dw.this).J(1);
    }
  }
  
  public static final class g
    implements GoogleApiClient.OnConnectionFailedListener
  {
    private final GooglePlayServicesClient.OnConnectionFailedListener pp;
    
    public g(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.pp = paramOnConnectionFailedListener;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof g)) {
        return this.pp.equals(((g)paramObject).pp);
      }
      return this.pp.equals(paramObject);
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      this.pp.onConnectionFailed(paramConnectionResult);
    }
  }
  
  protected final class h
    extends dw<T>.b<Boolean>
  {
    public final Bundle pq;
    public final IBinder pr;
    public final int statusCode;
    
    public h(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      super(Boolean.valueOf(true));
      this.statusCode = paramInt;
      this.pr = paramIBinder;
      this.pq = paramBundle;
    }
    
    protected void aL() {}
    
    protected void b(Boolean paramBoolean)
    {
      if (paramBoolean == null) {
        return;
      }
      switch (this.statusCode)
      {
      default: 
        if (this.pq == null) {
          break;
        }
      }
      for (paramBoolean = (PendingIntent)this.pq.getParcelable("pendingIntent");; paramBoolean = null)
      {
        if (dw.e(dw.this) != null)
        {
          dy.s(dw.f(dw.this)).b(dw.this.am(), dw.e(dw.this));
          dw.a(dw.this, null);
        }
        dw.a(dw.this, null);
        dw.a(dw.this).a(new ConnectionResult(this.statusCode, paramBoolean));
        return;
        try
        {
          paramBoolean = this.pr.getInterfaceDescriptor();
          if (dw.this.an().equals(paramBoolean))
          {
            dw.a(dw.this, dw.this.p(this.pr));
            if (dw.d(dw.this) != null)
            {
              dw.a(dw.this).bT();
              return;
            }
          }
        }
        catch (RemoteException paramBoolean)
        {
          dy.s(dw.f(dw.this)).b(dw.this.am(), dw.e(dw.this));
          dw.a(dw.this, null);
          dw.a(dw.this, null);
          dw.a(dw.this).a(new ConnectionResult(8, null));
          return;
        }
        throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */