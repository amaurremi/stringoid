package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.a;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;

public abstract class hb<T extends IInterface>
  implements Api.a, hc.b
{
  public static final String[] Gh = { "service_esmobile", "service_googleme" };
  private final Looper DF;
  private final hc DS;
  private T Gb;
  private final ArrayList<hb<T>.b<?>> Gc = new ArrayList();
  private hb<T>.oq Gd;
  private volatile int Ge = 1;
  private final String[] Gf;
  boolean Gg = false;
  private final Context mContext;
  final Handler mHandler;
  
  protected hb(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String... paramVarArgs)
  {
    this.mContext = ((Context)hm.f(paramContext));
    this.DF = ((Looper)hm.b(paramLooper, "Looper must not be null"));
    this.DS = new hc(paramContext, paramLooper, this);
    this.mHandler = new op(this, paramLooper);
    b(paramVarArgs);
    this.Gf = paramVarArgs;
    registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)hm.f(paramConnectionCallbacks));
    registerConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)hm.f(paramOnConnectionFailedListener));
  }
  
  @Deprecated
  protected hb(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, String... paramVarArgs)
  {
    this(paramContext, paramContext.getMainLooper(), new hb.c(paramConnectionCallbacks), new hb.g(paramOnConnectionFailedListener), paramVarArgs);
  }
  
  private void am(int paramInt)
  {
    int i = this.Ge;
    this.Ge = paramInt;
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
      a(hi.a.L(paramIBinder), new hb.e(this));
      return;
    }
    catch (RemoteException paramIBinder)
    {
      Log.w("GmsClient", "service died");
    }
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new hb.h(this, paramInt, paramIBinder, paramBundle)));
  }
  
  @Deprecated
  public final void a(hb<T>.b<?> paramhb)
  {
    synchronized (this.Gc)
    {
      this.Gc.add(paramhb);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(2, paramhb));
      return;
    }
  }
  
  protected abstract void a(hi paramhi, hb.e parame);
  
  public void an(int paramInt)
  {
    this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(paramInt)));
  }
  
  protected void b(String... paramVarArgs) {}
  
  protected abstract String bu();
  
  protected abstract String bv();
  
  protected final void cn()
  {
    if (!isConnected()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public void connect()
  {
    this.Gg = true;
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
      if (this.Gd != null)
      {
        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
        this.Gb = null;
        hd.E(this.mContext).b(bu(), this.Gd);
      }
      this.Gd = new oq(this);
    } while (hd.E(this.mContext).a(bu(), this.Gd));
    Log.e("GmsClient", "unable to connect to service: " + bu());
    this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
  }
  
  public void disconnect()
  {
    this.Gg = false;
    synchronized (this.Gc)
    {
      int j = this.Gc.size();
      int i = 0;
      while (i < j)
      {
        ((hb.b)this.Gc.get(i)).fw();
        i += 1;
      }
      this.Gc.clear();
      am(1);
      this.Gb = null;
      if (this.Gd != null)
      {
        hd.E(this.mContext).b(bu(), this.Gd);
        this.Gd = null;
      }
      return;
    }
  }
  
  public boolean eO()
  {
    return this.Gg;
  }
  
  public Bundle ef()
  {
    return null;
  }
  
  public final String[] fs()
  {
    return this.Gf;
  }
  
  public final T ft()
  {
    cn();
    return this.Gb;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public final Looper getLooper()
  {
    return this.DF;
  }
  
  public boolean isConnected()
  {
    return this.Ge == 3;
  }
  
  public boolean isConnecting()
  {
    return this.Ge == 2;
  }
  
  @Deprecated
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.DS.isConnectionCallbacksRegistered(new hb.c(paramConnectionCallbacks));
  }
  
  @Deprecated
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.DS.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  protected void onConnected() {}
  
  protected void onDisconnected() {}
  
  @Deprecated
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.DS.registerConnectionCallbacks(new hb.c(paramConnectionCallbacks));
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.DS.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  @Deprecated
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.DS.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.DS.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  @Deprecated
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.DS.unregisterConnectionCallbacks(new hb.c(paramConnectionCallbacks));
  }
  
  @Deprecated
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.DS.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  protected abstract T x(IBinder paramIBinder);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */