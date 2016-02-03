package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.ArrayList;
import java.util.Iterator;

public final class hc
{
  private final hc.b Gp;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> Gq = new ArrayList();
  final ArrayList<GoogleApiClient.ConnectionCallbacks> Gr = new ArrayList();
  private boolean Gs = false;
  private final ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> Gt = new ArrayList();
  private final Handler mHandler;
  
  public hc(Context paramContext, Looper paramLooper, hc.b paramb)
  {
    this.Gp = paramb;
    this.mHandler = new or(this, paramLooper);
  }
  
  public void a(ConnectionResult paramConnectionResult)
  {
    this.mHandler.removeMessages(1);
    synchronized (this.Gt)
    {
      Iterator localIterator = new ArrayList(this.Gt).iterator();
      while (localIterator.hasNext())
      {
        GooglePlayServicesClient.OnConnectionFailedListener localOnConnectionFailedListener = (GooglePlayServicesClient.OnConnectionFailedListener)localIterator.next();
        if (!this.Gp.eO()) {
          return;
        }
        if (this.Gt.contains(localOnConnectionFailedListener)) {
          localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
        }
      }
    }
  }
  
  public void ao(int paramInt)
  {
    this.mHandler.removeMessages(1);
    synchronized (this.Gq)
    {
      this.Gs = true;
      Iterator localIterator = new ArrayList(this.Gq).iterator();
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
      do
      {
        if (localIterator.hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator.next();
          if (this.Gp.eO()) {}
        }
        else
        {
          this.Gs = false;
          return;
        }
      } while (!this.Gq.contains(localConnectionCallbacks));
      localConnectionCallbacks.onConnectionSuspended(paramInt);
    }
  }
  
  public void c(Bundle paramBundle)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.Gq)
      {
        if (!this.Gs)
        {
          bool1 = true;
          hm.A(bool1);
          this.mHandler.removeMessages(1);
          this.Gs = true;
          if (this.Gr.size() != 0) {
            break label165;
          }
          bool1 = bool2;
          hm.A(bool1);
          Iterator localIterator = new ArrayList(this.Gq).iterator();
          GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
          if (localIterator.hasNext())
          {
            localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator.next();
            if ((this.Gp.eO()) && (this.Gp.isConnected())) {}
          }
          else
          {
            this.Gr.clear();
            this.Gs = false;
            return;
          }
          if (this.Gr.contains(localConnectionCallbacks)) {
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
  
  protected void cp()
  {
    synchronized (this.Gq)
    {
      c(this.Gp.ef());
      return;
    }
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    hm.f(paramConnectionCallbacks);
    synchronized (this.Gq)
    {
      boolean bool = this.Gq.contains(paramConnectionCallbacks);
      return bool;
    }
  }
  
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    hm.f(paramOnConnectionFailedListener);
    synchronized (this.Gt)
    {
      boolean bool = this.Gt.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    hm.f(paramConnectionCallbacks);
    synchronized (this.Gq)
    {
      if (this.Gq.contains(paramConnectionCallbacks))
      {
        Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + paramConnectionCallbacks + " is already registered");
        if (this.Gp.isConnected()) {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramConnectionCallbacks));
        }
        return;
      }
      this.Gq.add(paramConnectionCallbacks);
    }
  }
  
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    hm.f(paramOnConnectionFailedListener);
    synchronized (this.Gt)
    {
      if (this.Gt.contains(paramOnConnectionFailedListener))
      {
        Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " is already registered");
        return;
      }
      this.Gt.add(paramOnConnectionFailedListener);
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    hm.f(paramConnectionCallbacks);
    synchronized (this.Gq)
    {
      if (this.Gq != null)
      {
        if (this.Gq.remove(paramConnectionCallbacks)) {
          break label63;
        }
        Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + paramConnectionCallbacks + " not found");
      }
      label63:
      while (!this.Gs) {
        return;
      }
      this.Gr.add(paramConnectionCallbacks);
    }
  }
  
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    hm.f(paramOnConnectionFailedListener);
    synchronized (this.Gt)
    {
      if ((this.Gt != null) && (!this.Gt.remove(paramOnConnectionFailedListener))) {
        Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " not found");
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */