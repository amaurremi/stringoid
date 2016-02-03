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

public final class cu
  implements Handler.Callback
{
  private static final Object Hk = new Object();
  private static cu Hl;
  private final Context FU;
  private final HashMap<String, a> Hm = new HashMap();
  private final Handler mHandler = new Handler(paramContext.getMainLooper(), this);
  
  private cu(Context paramContext)
  {
    this.FU = paramContext.getApplicationContext();
  }
  
  public static cu I(Context paramContext)
  {
    synchronized (Hk)
    {
      if (Hl == null) {
        Hl = new cu(paramContext.getApplicationContext());
      }
      return Hl;
    }
  }
  
  public boolean a(String paramString, cs<?>.e paramcs)
  {
    for (;;)
    {
      a locala;
      synchronized (this.Hm)
      {
        locala = (a)this.Hm.get(paramString);
        if (locala == null)
        {
          locala = new a(paramString);
          locala.a(paramcs);
          paramcs = new Intent(paramString).setPackage("com.google.android.gms");
          locala.H(this.FU.bindService(paramcs, locala.qv(), 129));
          this.Hm.put(paramString, locala);
          paramString = locala;
          boolean bool = paramString.isBound();
          return bool;
        }
        this.mHandler.removeMessages(0, locala);
        if (locala.c(paramcs)) {
          throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + paramString);
        }
      }
      locala.a(paramcs);
      switch (locala.getState())
      {
      case 1: 
        paramcs.onServiceConnected(locala.getComponentName(), locala.getBinder());
        paramString = locala;
        break;
      case 2: 
        paramString = new Intent(paramString).setPackage("com.google.android.gms");
        locala.H(this.FU.bindService(paramString, locala.qv(), 129));
        paramString = locala;
        break;
      default: 
        paramString = locala;
      }
    }
  }
  
  public void b(String paramString, cs<?>.e paramcs)
  {
    a locala;
    synchronized (this.Hm)
    {
      locala = (a)this.Hm.get(paramString);
      if (locala == null) {
        throw new IllegalStateException("Nonexistent connection status for service action: " + paramString);
      }
    }
    if (!locala.c(paramcs)) {
      throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + paramString);
    }
    locala.b(paramcs);
    if (locala.qx())
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
    synchronized (this.Hm)
    {
      if (locala.qx())
      {
        this.FU.unbindService(locala.qv());
        this.Hm.remove(locala.qw());
      }
      return true;
    }
  }
  
  final class a
  {
    private final String Hn;
    private final a Ho;
    private final HashSet<cs<?>.e> Hp;
    private boolean Hq;
    private IBinder Hr;
    private ComponentName Hs;
    private int mState;
    
    public a(String paramString)
    {
      this.Hn = paramString;
      this.Ho = new a();
      this.Hp = new HashSet();
      this.mState = 0;
    }
    
    public void H(boolean paramBoolean)
    {
      this.Hq = paramBoolean;
    }
    
    public void a(cs<?>.e paramcs)
    {
      this.Hp.add(paramcs);
    }
    
    public void b(cs<?>.e paramcs)
    {
      this.Hp.remove(paramcs);
    }
    
    public boolean c(cs<?>.e paramcs)
    {
      return this.Hp.contains(paramcs);
    }
    
    public IBinder getBinder()
    {
      return this.Hr;
    }
    
    public ComponentName getComponentName()
    {
      return this.Hs;
    }
    
    public int getState()
    {
      return this.mState;
    }
    
    public boolean isBound()
    {
      return this.Hq;
    }
    
    public a qv()
    {
      return this.Ho;
    }
    
    public String qw()
    {
      return this.Hn;
    }
    
    public boolean qx()
    {
      return this.Hp.isEmpty();
    }
    
    public class a
      implements ServiceConnection
    {
      public a() {}
      
      public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
      {
        synchronized (cu.a(cu.this))
        {
          cu.a.a(cu.a.this, paramIBinder);
          cu.a.a(cu.a.this, paramComponentName);
          Iterator localIterator = cu.a.a(cu.a.this).iterator();
          if (localIterator.hasNext()) {
            ((cs.e)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
          }
        }
        cu.a.a(cu.a.this, 1);
      }
      
      public void onServiceDisconnected(ComponentName paramComponentName)
      {
        synchronized (cu.a(cu.this))
        {
          cu.a.a(cu.a.this, null);
          cu.a.a(cu.a.this, paramComponentName);
          Iterator localIterator = cu.a.a(cu.a.this).iterator();
          if (localIterator.hasNext()) {
            ((cs.e)localIterator.next()).onServiceDisconnected(paramComponentName);
          }
        }
        cu.a.a(cu.a.this, 2);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */