package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.a;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.d.e;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.n;
import java.util.ArrayList;
import java.util.Iterator;

public class nn
  extends d<ng>
{
  private final String BZ;
  private final nk akL;
  private final ni akM;
  private boolean akN;
  private final Object mw;
  
  public nn(Context paramContext, nk paramnk)
  {
    super(paramContext, paramnk, paramnk, new String[0]);
    this.BZ = paramContext.getPackageName();
    this.akL = ((nk)n.i(paramnk));
    this.akL.a(this);
    this.akM = new ni();
    this.mw = new Object();
    this.akN = true;
  }
  
  private void c(nl paramnl, nh paramnh)
  {
    this.akM.a(paramnl, paramnh);
  }
  
  private void d(nl paramnl, nh paramnh)
  {
    try
    {
      mW();
      ((ng)gS()).a(this.BZ, paramnl, paramnh);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
      c(paramnl, paramnh);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
      c(paramnl, paramnh);
    }
  }
  
  private void mW()
  {
    boolean bool;
    if (!this.akN)
    {
      bool = true;
      a.I(bool);
      if (!this.akM.isEmpty()) {
        Object localObject = null;
      }
    }
    label122:
    label195:
    label228:
    for (;;)
    {
      ArrayList localArrayList;
      ni.a locala;
      try
      {
        localArrayList = new ArrayList();
        Iterator localIterator = this.akM.mU().iterator();
        if (!localIterator.hasNext()) {
          break label195;
        }
        locala = (ni.a)localIterator.next();
        if (locala.akD == null) {
          break label122;
        }
        ((ng)gS()).a(this.BZ, locala.akB, pm.f(locala.akD));
        continue;
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
      }
      bool = false;
      break;
      if (locala.akB.equals(localRemoteException))
      {
        localArrayList.add(locala.akC);
      }
      else
      {
        if (!localArrayList.isEmpty())
        {
          ((ng)gS()).a(this.BZ, localRemoteException, localArrayList);
          localArrayList.clear();
        }
        nl localnl = locala.akB;
        localArrayList.add(locala.akC);
        break label228;
        if (!localArrayList.isEmpty()) {
          ((ng)gS()).a(this.BZ, localnl, localArrayList);
        }
        this.akM.clear();
        return;
      }
    }
  }
  
  void S(boolean paramBoolean)
  {
    synchronized (this.mw)
    {
      boolean bool = this.akN;
      this.akN = paramBoolean;
      if ((bool) && (!this.akN)) {
        mW();
      }
      return;
    }
  }
  
  protected void a(k paramk, d.e parame)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    paramk.f(parame, 6111000, getContext().getPackageName(), localBundle);
  }
  
  public void b(nl paramnl, nh paramnh)
  {
    synchronized (this.mw)
    {
      if (this.akN)
      {
        c(paramnl, paramnh);
        return;
      }
      d(paramnl, paramnh);
    }
  }
  
  protected ng bD(IBinder paramIBinder)
  {
    return ng.a.bC(paramIBinder);
  }
  
  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.playlog.internal.IPlayLogService";
  }
  
  protected String getStartServiceAction()
  {
    return "com.google.android.gms.playlog.service.START";
  }
  
  public void start()
  {
    synchronized (this.mw)
    {
      if ((isConnecting()) || (isConnected())) {
        return;
      }
      this.akL.R(true);
      connect();
      return;
    }
  }
  
  public void stop()
  {
    synchronized (this.mw)
    {
      this.akL.R(false);
      disconnect();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/nn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */