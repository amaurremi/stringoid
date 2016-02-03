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

public final class he
  implements Handler.Callback
{
  private static final Object Gs = new Object();
  private static he Gt;
  private final HashMap<String, a> Gu = new HashMap();
  private final Context lx;
  private final Handler mHandler = new Handler(paramContext.getMainLooper(), this);
  
  private he(Context paramContext)
  {
    this.lx = paramContext.getApplicationContext();
  }
  
  public static he B(Context paramContext)
  {
    synchronized (Gs)
    {
      if (Gt == null) {
        Gt = new he(paramContext.getApplicationContext());
      }
      return Gt;
    }
  }
  
  public boolean a(String paramString, hc<?>.f paramhc)
  {
    for (;;)
    {
      a locala;
      synchronized (this.Gu)
      {
        locala = (a)this.Gu.get(paramString);
        if (locala == null)
        {
          locala = new a(paramString);
          locala.a(paramhc);
          paramhc = new Intent(paramString).setPackage("com.google.android.gms");
          locala.B(this.lx.bindService(paramhc, locala.fs(), 129));
          this.Gu.put(paramString, locala);
          paramString = locala;
          boolean bool = paramString.isBound();
          return bool;
        }
        this.mHandler.removeMessages(0, locala);
        if (locala.c(paramhc)) {
          throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + paramString);
        }
      }
      locala.a(paramhc);
      switch (locala.getState())
      {
      case 1: 
        paramhc.onServiceConnected(locala.getComponentName(), locala.getBinder());
        paramString = locala;
        break;
      case 2: 
        paramString = new Intent(paramString).setPackage("com.google.android.gms");
        locala.B(this.lx.bindService(paramString, locala.fs(), 129));
        paramString = locala;
        break;
      default: 
        paramString = locala;
      }
    }
  }
  
  public void b(String paramString, hc<?>.f paramhc)
  {
    a locala;
    synchronized (this.Gu)
    {
      locala = (a)this.Gu.get(paramString);
      if (locala == null) {
        throw new IllegalStateException("Nonexistent connection status for service action: " + paramString);
      }
    }
    if (!locala.c(paramhc)) {
      throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + paramString);
    }
    locala.b(paramhc);
    if (locala.fu())
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
    synchronized (this.Gu)
    {
      if (locala.fu())
      {
        this.lx.unbindService(locala.fs());
        this.Gu.remove(locala.ft());
      }
      return true;
    }
  }
  
  final class a
  {
    private ComponentName GA;
    private final String Gv;
    private final a Gw;
    private final HashSet<hc<?>.f> Gx;
    private boolean Gy;
    private IBinder Gz;
    private int mState;
    
    public a(String paramString)
    {
      this.Gv = paramString;
      this.Gw = new a();
      this.Gx = new HashSet();
      this.mState = 0;
    }
    
    public void B(boolean paramBoolean)
    {
      this.Gy = paramBoolean;
    }
    
    public void a(hc<?>.f paramhc)
    {
      this.Gx.add(paramhc);
    }
    
    public void b(hc<?>.f paramhc)
    {
      this.Gx.remove(paramhc);
    }
    
    public boolean c(hc<?>.f paramhc)
    {
      return this.Gx.contains(paramhc);
    }
    
    public a fs()
    {
      return this.Gw;
    }
    
    public String ft()
    {
      return this.Gv;
    }
    
    public boolean fu()
    {
      return this.Gx.isEmpty();
    }
    
    public IBinder getBinder()
    {
      return this.Gz;
    }
    
    public ComponentName getComponentName()
    {
      return this.GA;
    }
    
    public int getState()
    {
      return this.mState;
    }
    
    public boolean isBound()
    {
      return this.Gy;
    }
    
    public class a
      implements ServiceConnection
    {
      public a() {}
      
      public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
      {
        synchronized (he.a(he.this))
        {
          he.a.a(he.a.this, paramIBinder);
          he.a.a(he.a.this, paramComponentName);
          Iterator localIterator = he.a.a(he.a.this).iterator();
          if (localIterator.hasNext()) {
            ((hc.f)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
          }
        }
        he.a.a(he.a.this, 1);
      }
      
      public void onServiceDisconnected(ComponentName paramComponentName)
      {
        synchronized (he.a(he.this))
        {
          he.a.a(he.a.this, null);
          he.a.a(he.a.this, paramComponentName);
          Iterator localIterator = he.a.a(he.a.this).iterator();
          if (localIterator.hasNext()) {
            ((hc.f)localIterator.next()).onServiceDisconnected(paramComponentName);
          }
        }
        he.a.a(he.a.this, 2);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/he.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */