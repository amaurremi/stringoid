package com.google.android.gms.common.internal;

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

public abstract class d<T extends IInterface>
  implements Api.a, e.b
{
  public static final String[] Lw = { "service_esmobile", "service_googleme" };
  private final String[] Ds;
  private final Looper IB;
  private final e IQ;
  private T Lr;
  private final ArrayList<d<T>.b<?>> Ls = new ArrayList();
  private d<T>.f Lt;
  private volatile int Lu = 1;
  boolean Lv = false;
  private final Context mContext;
  final Handler mHandler;
  
  protected d(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String... paramVarArgs)
  {
    this.mContext = ((Context)n.i(paramContext));
    this.IB = ((Looper)n.b(paramLooper, "Looper must not be null"));
    this.IQ = new e(paramContext, paramLooper, this);
    this.mHandler = new a(paramLooper);
    c(paramVarArgs);
    this.Ds = paramVarArgs;
    registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)n.i(paramConnectionCallbacks));
    registerConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)n.i(paramOnConnectionFailedListener));
  }
  
  @Deprecated
  protected d(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, String... paramVarArgs)
  {
    this(paramContext, paramContext.getMainLooper(), new c(paramConnectionCallbacks), new g(paramOnConnectionFailedListener), paramVarArgs);
  }
  
  private void az(int paramInt)
  {
    int i = this.Lu;
    this.Lu = paramInt;
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
  
  protected final void N(IBinder paramIBinder)
  {
    try
    {
      a(k.a.Q(paramIBinder), new e(this));
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
  public final void a(d<T>.b<?> paramd)
  {
    synchronized (this.Ls)
    {
      this.Ls.add(paramd);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(2, paramd));
      return;
    }
  }
  
  protected abstract void a(k paramk, e parame)
    throws RemoteException;
  
  public void aA(int paramInt)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(paramInt)));
  }
  
  protected void c(String... paramVarArgs) {}
  
  public void connect()
  {
    this.Lv = true;
    az(2);
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
    if (i != 0)
    {
      az(1);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(i)));
    }
    do
    {
      return;
      if (this.Lt != null)
      {
        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
        this.Lr = null;
        f.J(this.mContext).b(getStartServiceAction(), this.Lt);
      }
      this.Lt = new f();
    } while (f.J(this.mContext).a(getStartServiceAction(), this.Lt));
    Log.e("GmsClient", "unable to connect to service: " + getStartServiceAction());
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
  }
  
  protected final void dK()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public void disconnect()
  {
    this.Lv = false;
    synchronized (this.Ls)
    {
      int j = this.Ls.size();
      int i = 0;
      while (i < j)
      {
        ((b)this.Ls.get(i)).gV();
        i += 1;
      }
      this.Ls.clear();
      az(1);
      this.Lr = null;
      if (this.Lt != null)
      {
        f.J(this.mContext).b(getStartServiceAction(), this.Lt);
        this.Lt = null;
      }
      return;
    }
  }
  
  public Bundle fD()
  {
    return null;
  }
  
  public final String[] gR()
  {
    return this.Ds;
  }
  
  public final T gS()
  {
    dK();
    return this.Lr;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public final Looper getLooper()
  {
    return this.IB;
  }
  
  protected abstract String getServiceDescriptor();
  
  protected abstract String getStartServiceAction();
  
  public boolean gr()
  {
    return this.Lv;
  }
  
  public boolean isConnected()
  {
    return this.Lu == 3;
  }
  
  public boolean isConnecting()
  {
    return this.Lu == 2;
  }
  
  @Deprecated
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.IQ.isConnectionCallbacksRegistered(new c(paramConnectionCallbacks));
  }
  
  @Deprecated
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.IQ.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  protected abstract T j(IBinder paramIBinder);
  
  protected void onConnected() {}
  
  protected void onDisconnected() {}
  
  @Deprecated
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.IQ.registerConnectionCallbacks(new c(paramConnectionCallbacks));
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.IQ.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  @Deprecated
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.IQ.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.IQ.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  @Deprecated
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.IQ.unregisterConnectionCallbacks(new c(paramConnectionCallbacks));
  }
  
  @Deprecated
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.IQ.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
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
      if ((paramMessage.what == 1) && (!d.this.isConnecting()))
      {
        paramMessage = (d.b)paramMessage.obj;
        paramMessage.gT();
        paramMessage.unregister();
        return;
      }
      if (paramMessage.what == 3)
      {
        d.a(d.this).b(new ConnectionResult(((Integer)paramMessage.obj).intValue(), null));
        return;
      }
      if (paramMessage.what == 4)
      {
        d.a(d.this, 1);
        d.a(d.this, null);
        d.a(d.this).aB(((Integer)paramMessage.obj).intValue());
        return;
      }
      if ((paramMessage.what == 2) && (!d.this.isConnected()))
      {
        paramMessage = (d.b)paramMessage.obj;
        paramMessage.gT();
        paramMessage.unregister();
        return;
      }
      if ((paramMessage.what == 2) || (paramMessage.what == 1))
      {
        ((d.b)paramMessage.obj).gU();
        return;
      }
      Log.wtf("GmsClient", "Don't know how to handle this message.");
    }
  }
  
  protected abstract class b<TListener>
  {
    private boolean Ly;
    private TListener mListener;
    
    public b()
    {
      Object localObject;
      this.mListener = localObject;
      this.Ly = false;
    }
    
    protected abstract void g(TListener paramTListener);
    
    protected abstract void gT();
    
    /* Error */
    public void gU()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 24	com/google/android/gms/common/internal/d$b:mListener	Ljava/lang/Object;
      //   6: astore_1
      //   7: aload_0
      //   8: getfield 26	com/google/android/gms/common/internal/d$b:Ly	Z
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
      //   52: invokevirtual 63	com/google/android/gms/common/internal/d$b:g	(Ljava/lang/Object;)V
      //   55: aload_0
      //   56: monitorenter
      //   57: aload_0
      //   58: iconst_1
      //   59: putfield 26	com/google/android/gms/common/internal/d$b:Ly	Z
      //   62: aload_0
      //   63: monitorexit
      //   64: aload_0
      //   65: invokevirtual 66	com/google/android/gms/common/internal/d$b:unregister	()V
      //   68: return
      //   69: astore_1
      //   70: aload_0
      //   71: monitorexit
      //   72: aload_1
      //   73: athrow
      //   74: astore_1
      //   75: aload_0
      //   76: invokevirtual 68	com/google/android/gms/common/internal/d$b:gT	()V
      //   79: aload_1
      //   80: athrow
      //   81: aload_0
      //   82: invokevirtual 68	com/google/android/gms/common/internal/d$b:gT	()V
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
    
    public void gV()
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
      gV();
      synchronized (d.b(d.this))
      {
        d.b(d.this).remove(this);
        return;
      }
    }
  }
  
  public static final class c
    implements GoogleApiClient.ConnectionCallbacks
  {
    private final GooglePlayServicesClient.ConnectionCallbacks Lz;
    
    public c(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
    {
      this.Lz = paramConnectionCallbacks;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof c)) {
        return this.Lz.equals(((c)paramObject).Lz);
      }
      return this.Lz.equals(paramObject);
    }
    
    public void onConnected(Bundle paramBundle)
    {
      this.Lz.onConnected(paramBundle);
    }
    
    public void onConnectionSuspended(int paramInt)
    {
      this.Lz.onDisconnected();
    }
  }
  
  public abstract class d<TListener>
    extends d<T>.b<TListener>
  {
    private final DataHolder IC;
    
    public d(DataHolder paramDataHolder)
    {
      super(paramDataHolder);
      DataHolder localDataHolder;
      this.IC = localDataHolder;
    }
    
    protected abstract void a(TListener paramTListener, DataHolder paramDataHolder);
    
    protected final void g(TListener paramTListener)
    {
      a(paramTListener, this.IC);
    }
    
    protected void gT()
    {
      if (this.IC != null) {
        this.IC.close();
      }
    }
  }
  
  public static final class e
    extends j.a
  {
    private d LA;
    
    public e(d paramd)
    {
      this.LA = paramd;
    }
    
    public void b(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      n.b("onPostInitComplete can be called only once per call to getServiceFromBroker", this.LA);
      this.LA.a(paramInt, paramIBinder, paramBundle);
      this.LA = null;
    }
  }
  
  final class f
    implements ServiceConnection
  {
    f() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      d.this.N(paramIBinder);
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      d.this.mHandler.sendMessage(d.this.mHandler.obtainMessage(4, Integer.valueOf(1)));
    }
  }
  
  public static final class g
    implements GoogleApiClient.OnConnectionFailedListener
  {
    private final GooglePlayServicesClient.OnConnectionFailedListener LB;
    
    public g(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.LB = paramOnConnectionFailedListener;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof g)) {
        return this.LB.equals(((g)paramObject).LB);
      }
      return this.LB.equals(paramObject);
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      this.LB.onConnectionFailed(paramConnectionResult);
    }
  }
  
  protected final class h
    extends d<T>.b<Boolean>
  {
    public final Bundle LC;
    public final IBinder LD;
    public final int statusCode;
    
    public h(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      super(Boolean.valueOf(true));
      this.statusCode = paramInt;
      this.LD = paramIBinder;
      this.LC = paramBundle;
    }
    
    protected void b(Boolean paramBoolean)
    {
      if (paramBoolean == null)
      {
        d.a(d.this, 1);
        return;
      }
      switch (this.statusCode)
      {
      default: 
        if (this.LC == null) {
          break;
        }
      }
      for (paramBoolean = (PendingIntent)this.LC.getParcelable("pendingIntent");; paramBoolean = null)
      {
        if (d.d(d.this) != null)
        {
          f.J(d.e(d.this)).b(d.this.getStartServiceAction(), d.d(d.this));
          d.a(d.this, null);
        }
        d.a(d.this, 1);
        d.a(d.this, null);
        d.a(d.this).b(new ConnectionResult(this.statusCode, paramBoolean));
        return;
        try
        {
          paramBoolean = this.LD.getInterfaceDescriptor();
          if (d.this.getServiceDescriptor().equals(paramBoolean))
          {
            d.a(d.this, d.this.j(this.LD));
            if (d.c(d.this) != null)
            {
              d.a(d.this, 3);
              d.a(d.this).dM();
              return;
            }
          }
        }
        catch (RemoteException paramBoolean)
        {
          f.J(d.e(d.this)).b(d.this.getStartServiceAction(), d.d(d.this));
          d.a(d.this, null);
          d.a(d.this, 1);
          d.a(d.this, null);
          d.a(d.this).b(new ConnectionResult(8, null));
          return;
        }
        d.a(d.this, 1);
        throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
      }
    }
    
    protected void gT() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */