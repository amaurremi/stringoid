package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.ArrayList;

public final class dx
{
  private final Handler mHandler;
  private final b ps;
  private ArrayList<GoogleApiClient.ConnectionCallbacks> pt;
  final ArrayList<GoogleApiClient.ConnectionCallbacks> pu = new ArrayList();
  private boolean pv = false;
  private ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> pw;
  private boolean px = false;
  
  public dx(Context paramContext, b paramb)
  {
    this(paramContext, paramb, null);
  }
  
  dx(Context paramContext, b paramb, Handler paramHandler)
  {
    paramContext = paramHandler;
    if (paramHandler == null) {
      paramContext = new a(Looper.getMainLooper());
    }
    this.pt = new ArrayList();
    this.pw = new ArrayList();
    this.ps = paramb;
    this.mHandler = paramContext;
  }
  
  public void J(int paramInt)
  {
    this.mHandler.removeMessages(1);
    for (;;)
    {
      int i;
      synchronized (this.pt)
      {
        this.pv = true;
        ArrayList localArrayList2 = this.pt;
        int j = localArrayList2.size();
        i = 0;
        if ((i >= j) || (!this.ps.bp()))
        {
          this.pv = false;
          return;
        }
        if (this.pt.contains(localArrayList2.get(i))) {
          ((GoogleApiClient.ConnectionCallbacks)localArrayList2.get(i)).onConnectionSuspended(paramInt);
        }
      }
      i += 1;
    }
  }
  
  public void a(ConnectionResult paramConnectionResult)
  {
    this.mHandler.removeMessages(1);
    for (;;)
    {
      int i;
      synchronized (this.pw)
      {
        this.px = true;
        ArrayList localArrayList2 = this.pw;
        int j = localArrayList2.size();
        i = 0;
        if (i < j)
        {
          if (!this.ps.bp()) {
            return;
          }
          if (this.pw.contains(localArrayList2.get(i))) {
            ((GooglePlayServicesClient.OnConnectionFailedListener)localArrayList2.get(i)).onConnectionFailed(paramConnectionResult);
          }
        }
        else
        {
          this.px = false;
          return;
        }
      }
      i += 1;
    }
  }
  
  public void b(Bundle paramBundle)
  {
    boolean bool2 = true;
    for (;;)
    {
      int i;
      synchronized (this.pt)
      {
        if (!this.pv)
        {
          bool1 = true;
          eg.p(bool1);
          this.mHandler.removeMessages(1);
          this.pv = true;
          if (this.pu.size() != 0) {
            break label172;
          }
          bool1 = bool2;
          eg.p(bool1);
          ArrayList localArrayList2 = this.pt;
          int j = localArrayList2.size();
          i = 0;
          if ((i >= j) || (!this.ps.bp()) || (!this.ps.isConnected()))
          {
            this.pu.clear();
            this.pv = false;
            return;
          }
          this.pu.size();
          if (this.pu.contains(localArrayList2.get(i))) {
            break label178;
          }
          ((GoogleApiClient.ConnectionCallbacks)localArrayList2.get(i)).onConnected(paramBundle);
        }
      }
      boolean bool1 = false;
      continue;
      label172:
      bool1 = false;
      continue;
      label178:
      i += 1;
    }
  }
  
  protected void bT()
  {
    synchronized (this.pt)
    {
      b(this.ps.aU());
      return;
    }
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    eg.f(paramConnectionCallbacks);
    synchronized (this.pt)
    {
      boolean bool = this.pt.contains(paramConnectionCallbacks);
      return bool;
    }
  }
  
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    eg.f(paramOnConnectionFailedListener);
    synchronized (this.pw)
    {
      boolean bool = this.pw.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    eg.f(paramConnectionCallbacks);
    synchronized (this.pt)
    {
      if (this.pt.contains(paramConnectionCallbacks))
      {
        Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + paramConnectionCallbacks + " is already registered");
        if (this.ps.isConnected()) {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramConnectionCallbacks));
        }
        return;
      }
      if (this.pv) {
        this.pt = new ArrayList(this.pt);
      }
      this.pt.add(paramConnectionCallbacks);
    }
  }
  
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    eg.f(paramOnConnectionFailedListener);
    synchronized (this.pw)
    {
      if (this.pw.contains(paramOnConnectionFailedListener))
      {
        Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " is already registered");
        return;
      }
      if (this.px) {
        this.pw = new ArrayList(this.pw);
      }
      this.pw.add(paramOnConnectionFailedListener);
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    eg.f(paramConnectionCallbacks);
    synchronized (this.pt)
    {
      if (this.pt != null)
      {
        if (this.pv) {
          this.pt = new ArrayList(this.pt);
        }
        if (this.pt.remove(paramConnectionCallbacks)) {
          break label85;
        }
        Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + paramConnectionCallbacks + " not found");
      }
      label85:
      while ((!this.pv) || (this.pu.contains(paramConnectionCallbacks))) {
        return;
      }
      this.pu.add(paramConnectionCallbacks);
    }
  }
  
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    eg.f(paramOnConnectionFailedListener);
    synchronized (this.pw)
    {
      if (this.pw != null)
      {
        if (this.px) {
          this.pw = new ArrayList(this.pw);
        }
        if (!this.pw.remove(paramOnConnectionFailedListener)) {
          Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " not found");
        }
      }
      return;
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
      if (paramMessage.what == 1) {
        synchronized (dx.a(dx.this))
        {
          if ((dx.b(dx.this).bp()) && (dx.b(dx.this).isConnected()) && (dx.a(dx.this).contains(paramMessage.obj)))
          {
            Bundle localBundle = dx.b(dx.this).aU();
            ((GoogleApiClient.ConnectionCallbacks)paramMessage.obj).onConnected(localBundle);
          }
          return;
        }
      }
      Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
    }
  }
  
  public static abstract interface b
  {
    public abstract Bundle aU();
    
    public abstract boolean bp();
    
    public abstract boolean isConnected();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */