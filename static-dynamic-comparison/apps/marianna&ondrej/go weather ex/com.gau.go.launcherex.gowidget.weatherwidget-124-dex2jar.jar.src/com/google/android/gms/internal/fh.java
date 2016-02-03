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

public final class fh
  implements Handler.Callback
{
  private static final Object Du = new Object();
  private static fh Dv;
  private final HashMap<String, a> Dw = new HashMap();
  private final Context lp;
  private final Handler mHandler = new Handler(paramContext.getMainLooper(), this);
  
  private fh(Context paramContext)
  {
    this.lp = paramContext.getApplicationContext();
  }
  
  public static fh x(Context paramContext)
  {
    synchronized (Du)
    {
      if (Dv == null) {
        Dv = new fh(paramContext.getApplicationContext());
      }
      return Dv;
    }
  }
  
  public boolean a(String paramString, ff<?>.f paramff)
  {
    for (;;)
    {
      a locala;
      synchronized (this.Dw)
      {
        locala = (a)this.Dw.get(paramString);
        if (locala == null)
        {
          locala = new a(paramString);
          locala.a(paramff);
          paramff = new Intent(paramString).setPackage("com.google.android.gms");
          locala.y(this.lp.bindService(paramff, locala.eP(), 129));
          this.Dw.put(paramString, locala);
          paramString = locala;
          boolean bool = paramString.isBound();
          return bool;
        }
        this.mHandler.removeMessages(0, locala);
        if (locala.c(paramff)) {
          throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + paramString);
        }
      }
      locala.a(paramff);
      switch (locala.getState())
      {
      case 1: 
        paramff.onServiceConnected(locala.getComponentName(), locala.getBinder());
        paramString = locala;
        break;
      case 2: 
        paramString = new Intent(paramString).setPackage("com.google.android.gms");
        locala.y(this.lp.bindService(paramString, locala.eP(), 129));
        paramString = locala;
        break;
      default: 
        paramString = locala;
      }
    }
  }
  
  public void b(String paramString, ff<?>.f paramff)
  {
    a locala;
    synchronized (this.Dw)
    {
      locala = (a)this.Dw.get(paramString);
      if (locala == null) {
        throw new IllegalStateException("Nonexistent connection status for service action: " + paramString);
      }
    }
    if (!locala.c(paramff)) {
      throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + paramString);
    }
    locala.b(paramff);
    if (locala.eR())
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
    synchronized (this.Dw)
    {
      if (locala.eR())
      {
        this.lp.unbindService(locala.eP());
        this.Dw.remove(locala.eQ());
      }
      return true;
    }
  }
  
  final class a
  {
    private boolean DA;
    private IBinder DB;
    private ComponentName DC;
    private final String Dx;
    private final a Dy;
    private final HashSet<ff<?>.f> Dz;
    private int mState;
    
    public a(String paramString)
    {
      this.Dx = paramString;
      this.Dy = new a();
      this.Dz = new HashSet();
      this.mState = 0;
    }
    
    public void a(ff<?>.f paramff)
    {
      this.Dz.add(paramff);
    }
    
    public void b(ff<?>.f paramff)
    {
      this.Dz.remove(paramff);
    }
    
    public boolean c(ff<?>.f paramff)
    {
      return this.Dz.contains(paramff);
    }
    
    public a eP()
    {
      return this.Dy;
    }
    
    public String eQ()
    {
      return this.Dx;
    }
    
    public boolean eR()
    {
      return this.Dz.isEmpty();
    }
    
    public IBinder getBinder()
    {
      return this.DB;
    }
    
    public ComponentName getComponentName()
    {
      return this.DC;
    }
    
    public int getState()
    {
      return this.mState;
    }
    
    public boolean isBound()
    {
      return this.DA;
    }
    
    public void y(boolean paramBoolean)
    {
      this.DA = paramBoolean;
    }
    
    public class a
      implements ServiceConnection
    {
      public a() {}
      
      public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
      {
        synchronized (fh.a(fh.this))
        {
          fh.a.a(fh.a.this, paramIBinder);
          fh.a.a(fh.a.this, paramComponentName);
          Iterator localIterator = fh.a.a(fh.a.this).iterator();
          if (localIterator.hasNext()) {
            ((ff.f)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
          }
        }
        fh.a.a(fh.a.this, 1);
      }
      
      public void onServiceDisconnected(ComponentName paramComponentName)
      {
        synchronized (fh.a(fh.this))
        {
          fh.a.a(fh.a.this, null);
          fh.a.a(fh.a.this, paramComponentName);
          Iterator localIterator = fh.a.a(fh.a.this).iterator();
          if (localIterator.hasNext()) {
            ((ff.f)localIterator.next()).onServiceDisconnected(paramComponentName);
          }
        }
        fh.a.a(fh.a.this, 2);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/fh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */