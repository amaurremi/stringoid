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

public final class hd
{
  private final b Gm;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> Gn = new ArrayList();
  final ArrayList<GoogleApiClient.ConnectionCallbacks> Go = new ArrayList();
  private boolean Gp = false;
  private final ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> Gq = new ArrayList();
  private final Handler mHandler;
  
  public hd(Context paramContext, Looper paramLooper, b paramb)
  {
    this.Gm = paramb;
    this.mHandler = new a(paramLooper);
  }
  
  public void a(ConnectionResult paramConnectionResult)
  {
    this.mHandler.removeMessages(1);
    synchronized (this.Gq)
    {
      Iterator localIterator = new ArrayList(this.Gq).iterator();
      while (localIterator.hasNext())
      {
        GooglePlayServicesClient.OnConnectionFailedListener localOnConnectionFailedListener = (GooglePlayServicesClient.OnConnectionFailedListener)localIterator.next();
        if (!this.Gm.eJ()) {
          return;
        }
        if (this.Gq.contains(localOnConnectionFailedListener)) {
          localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
        }
      }
    }
  }
  
  public void ao(int paramInt)
  {
    this.mHandler.removeMessages(1);
    synchronized (this.Gn)
    {
      this.Gp = true;
      Iterator localIterator = new ArrayList(this.Gn).iterator();
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
      do
      {
        if (localIterator.hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator.next();
          if (this.Gm.eJ()) {}
        }
        else
        {
          this.Gp = false;
          return;
        }
      } while (!this.Gn.contains(localConnectionCallbacks));
      localConnectionCallbacks.onConnectionSuspended(paramInt);
    }
  }
  
  public void c(Bundle paramBundle)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.Gn)
      {
        if (!this.Gp)
        {
          bool1 = true;
          hn.A(bool1);
          this.mHandler.removeMessages(1);
          this.Gp = true;
          if (this.Go.size() != 0) {
            break label165;
          }
          bool1 = bool2;
          hn.A(bool1);
          Iterator localIterator = new ArrayList(this.Gn).iterator();
          GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
          if (localIterator.hasNext())
          {
            localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator.next();
            if ((this.Gm.eJ()) && (this.Gm.isConnected())) {}
          }
          else
          {
            this.Go.clear();
            this.Gp = false;
            return;
          }
          if (this.Go.contains(localConnectionCallbacks)) {
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
  
  protected void ck()
  {
    synchronized (this.Gn)
    {
      c(this.Gm.ea());
      return;
    }
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    hn.f(paramConnectionCallbacks);
    synchronized (this.Gn)
    {
      boolean bool = this.Gn.contains(paramConnectionCallbacks);
      return bool;
    }
  }
  
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    hn.f(paramOnConnectionFailedListener);
    synchronized (this.Gq)
    {
      boolean bool = this.Gq.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    hn.f(paramConnectionCallbacks);
    synchronized (this.Gn)
    {
      if (this.Gn.contains(paramConnectionCallbacks))
      {
        Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + paramConnectionCallbacks + " is already registered");
        if (this.Gm.isConnected()) {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramConnectionCallbacks));
        }
        return;
      }
      this.Gn.add(paramConnectionCallbacks);
    }
  }
  
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    hn.f(paramOnConnectionFailedListener);
    synchronized (this.Gq)
    {
      if (this.Gq.contains(paramOnConnectionFailedListener))
      {
        Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " is already registered");
        return;
      }
      this.Gq.add(paramOnConnectionFailedListener);
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    hn.f(paramConnectionCallbacks);
    synchronized (this.Gn)
    {
      if (this.Gn != null)
      {
        if (this.Gn.remove(paramConnectionCallbacks)) {
          break label63;
        }
        Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + paramConnectionCallbacks + " not found");
      }
      label63:
      while (!this.Gp) {
        return;
      }
      this.Go.add(paramConnectionCallbacks);
    }
  }
  
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    hn.f(paramOnConnectionFailedListener);
    synchronized (this.Gq)
    {
      if ((this.Gq != null) && (!this.Gq.remove(paramOnConnectionFailedListener))) {
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
        synchronized (hd.a(hd.this))
        {
          if ((hd.b(hd.this).eJ()) && (hd.b(hd.this).isConnected()) && (hd.a(hd.this).contains(paramMessage.obj)))
          {
            Bundle localBundle = hd.b(hd.this).ea();
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
    public abstract boolean eJ();
    
    public abstract Bundle ea();
    
    public abstract boolean isConnected();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/hd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */