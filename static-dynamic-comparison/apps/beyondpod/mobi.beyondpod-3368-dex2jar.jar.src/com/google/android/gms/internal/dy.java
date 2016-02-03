package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class dy
  implements Handler.Callback
{
  private static dy pA;
  private static final Object pz = new Object();
  private final Context iT;
  private final Handler mHandler = new Handler(paramContext.getMainLooper(), this);
  private final HashMap<String, a> pB = new HashMap();
  
  private dy(Context paramContext)
  {
    this.iT = paramContext.getApplicationContext();
  }
  
  public static dy s(Context paramContext)
  {
    synchronized (pz)
    {
      if (pA == null) {
        pA = new dy(paramContext.getApplicationContext());
      }
      return pA;
    }
  }
  
  public boolean a(String paramString, dw<?>.f paramdw)
  {
    for (;;)
    {
      a locala;
      synchronized (this.pB)
      {
        locala = (a)this.pB.get(paramString);
        if (locala == null)
        {
          locala = new a(paramString);
          locala.a(paramdw);
          paramdw = new Intent(paramString).setPackage("com.google.android.gms");
          locala.q(this.iT.bindService(paramdw, locala.bU(), 129));
          this.pB.put(paramString, locala);
          paramString = locala;
          boolean bool = paramString.isBound();
          return bool;
        }
        this.mHandler.removeMessages(0, locala);
        if (locala.c(paramdw)) {
          throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + paramString);
        }
      }
      locala.a(paramdw);
      switch (locala.getState())
      {
      case 1: 
        paramdw.onServiceConnected(locala.getComponentName(), locala.getBinder());
        paramString = locala;
        break;
      case 2: 
        paramString = new Intent(paramString).setPackage("com.google.android.gms");
        locala.q(this.iT.bindService(paramString, locala.bU(), 129));
        paramString = locala;
        break;
      default: 
        paramString = locala;
      }
    }
  }
  
  public void b(String paramString, dw<?>.f paramdw)
  {
    a locala;
    synchronized (this.pB)
    {
      locala = (a)this.pB.get(paramString);
      if (locala == null) {
        throw new IllegalStateException("Nonexistent connection status for service action: " + paramString);
      }
    }
    if (!locala.c(paramdw)) {
      throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + paramString);
    }
    locala.b(paramdw);
    if (locala.bW())
    {
      paramString = this.mHandler.obtainMessage(0, locala);
      this.mHandler.sendMessageDelayed(paramString, 5000L);
    }
  }
  
  public boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
      return false;
    }
    a locala = (a)???.obj;
    synchronized (this.pB)
    {
      if (locala.bW())
      {
        this.iT.unbindService(locala.bU());
        this.pB.remove(locala.bV());
      }
      return true;
    }
  }
  
  final class a
  {
    private int mState;
    private final String pC;
    private final a pD;
    private final HashSet<dw<?>.f> pE;
    private boolean pF;
    private IBinder pG;
    private ComponentName pH;
    
    public a(String paramString)
    {
      this.pC = paramString;
      this.pD = new a();
      this.pE = new HashSet();
      this.mState = 0;
    }
    
    public void a(dw<?>.f paramdw)
    {
      this.pE.add(paramdw);
    }
    
    public void b(dw<?>.f paramdw)
    {
      this.pE.remove(paramdw);
    }
    
    public a bU()
    {
      return this.pD;
    }
    
    public String bV()
    {
      return this.pC;
    }
    
    public boolean bW()
    {
      return this.pE.isEmpty();
    }
    
    public boolean c(dw<?>.f paramdw)
    {
      return this.pE.contains(paramdw);
    }
    
    public IBinder getBinder()
    {
      return this.pG;
    }
    
    public ComponentName getComponentName()
    {
      return this.pH;
    }
    
    public int getState()
    {
      return this.mState;
    }
    
    public boolean isBound()
    {
      return this.pF;
    }
    
    public void q(boolean paramBoolean)
    {
      this.pF = paramBoolean;
    }
    
    public class a
      implements ServiceConnection
    {
      public a() {}
      
      public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
      {
        synchronized (dy.a(dy.this))
        {
          dy.a.a(dy.a.this, paramIBinder);
          dy.a.a(dy.a.this, paramComponentName);
          Iterator localIterator = dy.a.a(dy.a.this).iterator();
          if (localIterator.hasNext()) {
            ((dw.f)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
          }
        }
        dy.a.a(dy.a.this, 1);
      }
      
      public void onServiceDisconnected(ComponentName paramComponentName)
      {
        synchronized (dy.a(dy.this))
        {
          dy.a.a(dy.a.this, null);
          dy.a.a(dy.a.this, paramComponentName);
          Iterator localIterator = dy.a.a(dy.a.this).iterator();
          if (localIterator.hasNext()) {
            ((dw.f)localIterator.next()).onServiceDisconnected(paramComponentName);
          }
        }
        dy.a.a(dy.a.this, 2);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */