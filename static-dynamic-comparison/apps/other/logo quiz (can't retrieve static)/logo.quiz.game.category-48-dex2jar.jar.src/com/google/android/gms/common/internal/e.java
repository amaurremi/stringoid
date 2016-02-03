package com.google.android.gms.common.internal;

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

public final class e
{
  private final b LE;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> LF = new ArrayList();
  final ArrayList<GoogleApiClient.ConnectionCallbacks> LG = new ArrayList();
  private boolean LH = false;
  private final ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> LI = new ArrayList();
  private final Handler mHandler;
  
  public e(Context paramContext, Looper paramLooper, b paramb)
  {
    this.LE = paramb;
    this.mHandler = new a(paramLooper);
  }
  
  public void aB(int paramInt)
  {
    this.mHandler.removeMessages(1);
    synchronized (this.LF)
    {
      this.LH = true;
      Iterator localIterator = new ArrayList(this.LF).iterator();
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
      do
      {
        if (localIterator.hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator.next();
          if (this.LE.gr()) {}
        }
        else
        {
          this.LH = false;
          return;
        }
      } while (!this.LF.contains(localConnectionCallbacks));
      localConnectionCallbacks.onConnectionSuspended(paramInt);
    }
  }
  
  public void b(ConnectionResult paramConnectionResult)
  {
    this.mHandler.removeMessages(1);
    synchronized (this.LI)
    {
      Iterator localIterator = new ArrayList(this.LI).iterator();
      while (localIterator.hasNext())
      {
        GooglePlayServicesClient.OnConnectionFailedListener localOnConnectionFailedListener = (GooglePlayServicesClient.OnConnectionFailedListener)localIterator.next();
        if (!this.LE.gr()) {
          return;
        }
        if (this.LI.contains(localOnConnectionFailedListener)) {
          localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
        }
      }
    }
  }
  
  public void d(Bundle paramBundle)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (this.LF)
      {
        if (!this.LH)
        {
          bool1 = true;
          n.I(bool1);
          this.mHandler.removeMessages(1);
          this.LH = true;
          if (this.LG.size() != 0) {
            break label165;
          }
          bool1 = bool2;
          n.I(bool1);
          Iterator localIterator = new ArrayList(this.LF).iterator();
          GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
          if (localIterator.hasNext())
          {
            localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator.next();
            if ((this.LE.gr()) && (this.LE.isConnected())) {}
          }
          else
          {
            this.LG.clear();
            this.LH = false;
            return;
          }
          if (this.LG.contains(localConnectionCallbacks)) {
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
  
  protected void dM()
  {
    synchronized (this.LF)
    {
      d(this.LE.fD());
      return;
    }
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    n.i(paramConnectionCallbacks);
    synchronized (this.LF)
    {
      boolean bool = this.LF.contains(paramConnectionCallbacks);
      return bool;
    }
  }
  
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    n.i(paramOnConnectionFailedListener);
    synchronized (this.LI)
    {
      boolean bool = this.LI.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    n.i(paramConnectionCallbacks);
    synchronized (this.LF)
    {
      if (this.LF.contains(paramConnectionCallbacks))
      {
        Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + paramConnectionCallbacks + " is already registered");
        if (this.LE.isConnected()) {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramConnectionCallbacks));
        }
        return;
      }
      this.LF.add(paramConnectionCallbacks);
    }
  }
  
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    n.i(paramOnConnectionFailedListener);
    synchronized (this.LI)
    {
      if (this.LI.contains(paramOnConnectionFailedListener))
      {
        Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " is already registered");
        return;
      }
      this.LI.add(paramOnConnectionFailedListener);
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    n.i(paramConnectionCallbacks);
    synchronized (this.LF)
    {
      if (this.LF != null)
      {
        if (this.LF.remove(paramConnectionCallbacks)) {
          break label63;
        }
        Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + paramConnectionCallbacks + " not found");
      }
      label63:
      while (!this.LH) {
        return;
      }
      this.LG.add(paramConnectionCallbacks);
    }
  }
  
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    n.i(paramOnConnectionFailedListener);
    synchronized (this.LI)
    {
      if ((this.LI != null) && (!this.LI.remove(paramOnConnectionFailedListener))) {
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
        synchronized (e.a(e.this))
        {
          if ((e.b(e.this).gr()) && (e.b(e.this).isConnected()) && (e.a(e.this).contains(paramMessage.obj)))
          {
            Bundle localBundle = e.b(e.this).fD();
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
    public abstract Bundle fD();
    
    public abstract boolean gr();
    
    public abstract boolean isConnected();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */