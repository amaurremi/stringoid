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
import java.util.Iterator;

public final class fg
{
  private final b Do;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> Dp = new ArrayList();
  final ArrayList<GoogleApiClient.ConnectionCallbacks> Dq = new ArrayList();
  private boolean Dr = false;
  private final ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> Ds = new ArrayList();
  private final Handler mHandler;
  
  public fg(Context paramContext, Looper paramLooper, b paramb)
  {
    this.Do = paramb;
    this.mHandler = new a(paramLooper);
  }
  
  public void O(int paramInt)
  {
    this.mHandler.removeMessages(1);
    synchronized (this.Dp)
    {
      this.Dr = true;
      Iterator localIterator = new ArrayList(this.Dp).iterator();
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
      do
      {
        if (localIterator.hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator.next();
          if (this.Do.em()) {}
        }
        else
        {
          this.Dr = false;
          return;
        }
      } while (!this.Dp.contains(localConnectionCallbacks));
      localConnectionCallbacks.onConnectionSuspended(paramInt);
    }
  }
  
  public void a(ConnectionResult paramConnectionResult)
  {
    this.mHandler.removeMessages(1);
    synchronized (this.Ds)
    {
      Iterator localIterator = new ArrayList(this.Ds).iterator();
      while (localIterator.hasNext())
      {
        GooglePlayServicesClient.OnConnectionFailedListener localOnConnectionFailedListener = (GooglePlayServicesClient.OnConnectionFailedListener)localIterator.next();
        if (!this.Do.em()) {
          return;
        }
        if (this.Ds.contains(localOnConnectionFailedListener)) {
          localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
        }
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.Dp)
      {
        if (!this.Dr)
        {
          bool1 = true;
          fq.x(bool1);
          this.mHandler.removeMessages(1);
          this.Dr = true;
          if (this.Dq.size() != 0) {
            break label165;
          }
          bool1 = bool2;
          fq.x(bool1);
          Iterator localIterator = new ArrayList(this.Dp).iterator();
          GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
          if (localIterator.hasNext())
          {
            localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator.next();
            if ((this.Do.em()) && (this.Do.isConnected())) {}
          }
          else
          {
            this.Dq.clear();
            this.Dr = false;
            return;
          }
          if (this.Dq.contains(localConnectionCallbacks)) {
            continue;
          }
          localConnectionCallbacks.onConnected(paramBundle);
        }
      }
      boolean bool1 = false;
      continue;
      label165:
      bool1 = false;
    }
  }
  
  protected void bV()
  {
    synchronized (this.Dp)
    {
      b(this.Do.dG());
      return;
    }
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    fq.f(paramConnectionCallbacks);
    synchronized (this.Dp)
    {
      boolean bool = this.Dp.contains(paramConnectionCallbacks);
      return bool;
    }
  }
  
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    fq.f(paramOnConnectionFailedListener);
    synchronized (this.Ds)
    {
      boolean bool = this.Ds.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    fq.f(paramConnectionCallbacks);
    synchronized (this.Dp)
    {
      if (this.Dp.contains(paramConnectionCallbacks))
      {
        Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + paramConnectionCallbacks + " is already registered");
        if (this.Do.isConnected()) {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramConnectionCallbacks));
        }
        return;
      }
      this.Dp.add(paramConnectionCallbacks);
    }
  }
  
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    fq.f(paramOnConnectionFailedListener);
    synchronized (this.Ds)
    {
      if (this.Ds.contains(paramOnConnectionFailedListener))
      {
        Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " is already registered");
        return;
      }
      this.Ds.add(paramOnConnectionFailedListener);
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    fq.f(paramConnectionCallbacks);
    synchronized (this.Dp)
    {
      if (this.Dp != null)
      {
        if (this.Dp.remove(paramConnectionCallbacks)) {
          break label63;
        }
        Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + paramConnectionCallbacks + " not found");
      }
      label63:
      while (!this.Dr) {
        return;
      }
      this.Dq.add(paramConnectionCallbacks);
    }
  }
  
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    fq.f(paramOnConnectionFailedListener);
    synchronized (this.Ds)
    {
      if ((this.Ds != null) && (!this.Ds.remove(paramOnConnectionFailedListener))) {
        Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " not found");
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
        synchronized (fg.a(fg.this))
        {
          if ((fg.b(fg.this).em()) && (fg.b(fg.this).isConnected()) && (fg.a(fg.this).contains(paramMessage.obj)))
          {
            Bundle localBundle = fg.b(fg.this).dG();
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
    public abstract Bundle dG();
    
    public abstract boolean em();
    
    public abstract boolean isConnected();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/fg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */