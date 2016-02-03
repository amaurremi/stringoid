package com.google.android.gms.common.internal;

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

public final class f
  implements Handler.Callback
{
  private static final Object LK = new Object();
  private static f LL;
  private final HashMap<String, a> LM = new HashMap();
  private final Context mD;
  private final Handler mHandler = new Handler(paramContext.getMainLooper(), this);
  
  private f(Context paramContext)
  {
    this.mD = paramContext.getApplicationContext();
  }
  
  public static f J(Context paramContext)
  {
    synchronized (LK)
    {
      if (LL == null) {
        LL = new f(paramContext.getApplicationContext());
      }
      return LL;
    }
  }
  
  public boolean a(String paramString, d<?>.f paramd)
  {
    for (;;)
    {
      a locala;
      synchronized (this.LM)
      {
        locala = (a)this.LM.get(paramString);
        if (locala == null)
        {
          locala = new a(paramString);
          locala.a(paramd);
          paramd = new Intent(paramString).setPackage("com.google.android.gms");
          locala.J(this.mD.bindService(paramd, locala.gW(), 129));
          this.LM.put(paramString, locala);
          paramString = locala;
          boolean bool = paramString.isBound();
          return bool;
        }
        this.mHandler.removeMessages(0, locala);
        if (locala.c(paramd)) {
          throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + paramString);
        }
      }
      locala.a(paramd);
      switch (locala.getState())
      {
      case 1: 
        paramd.onServiceConnected(locala.getComponentName(), locala.getBinder());
        paramString = locala;
        break;
      case 2: 
        paramString = new Intent(paramString).setPackage("com.google.android.gms");
        locala.J(this.mD.bindService(paramString, locala.gW(), 129));
        paramString = locala;
        break;
      default: 
        paramString = locala;
      }
    }
  }
  
  public void b(String paramString, d<?>.f paramd)
  {
    a locala;
    synchronized (this.LM)
    {
      locala = (a)this.LM.get(paramString);
      if (locala == null) {
        throw new IllegalStateException("Nonexistent connection status for service action: " + paramString);
      }
    }
    if (!locala.c(paramd)) {
      throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + paramString);
    }
    locala.b(paramd);
    if (locala.gY())
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
    synchronized (this.LM)
    {
      if (locala.gY())
      {
        this.mD.unbindService(locala.gW());
        this.LM.remove(locala.gX());
      }
      return true;
    }
  }
  
  final class a
  {
    private final String LN;
    private final a LO;
    private final HashSet<d<?>.f> LP;
    private boolean LQ;
    private IBinder LR;
    private ComponentName LS;
    private int mState;
    
    public a(String paramString)
    {
      this.LN = paramString;
      this.LO = new a();
      this.LP = new HashSet();
      this.mState = 0;
    }
    
    public void J(boolean paramBoolean)
    {
      this.LQ = paramBoolean;
    }
    
    public void a(d<?>.f paramd)
    {
      this.LP.add(paramd);
    }
    
    public void b(d<?>.f paramd)
    {
      this.LP.remove(paramd);
    }
    
    public boolean c(d<?>.f paramd)
    {
      return this.LP.contains(paramd);
    }
    
    public a gW()
    {
      return this.LO;
    }
    
    public String gX()
    {
      return this.LN;
    }
    
    public boolean gY()
    {
      return this.LP.isEmpty();
    }
    
    public IBinder getBinder()
    {
      return this.LR;
    }
    
    public ComponentName getComponentName()
    {
      return this.LS;
    }
    
    public int getState()
    {
      return this.mState;
    }
    
    public boolean isBound()
    {
      return this.LQ;
    }
    
    public class a
      implements ServiceConnection
    {
      public a() {}
      
      public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
      {
        synchronized (f.a(f.this))
        {
          f.a.a(f.a.this, paramIBinder);
          f.a.a(f.a.this, paramComponentName);
          Iterator localIterator = f.a.a(f.a.this).iterator();
          if (localIterator.hasNext()) {
            ((d.f)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
          }
        }
        f.a.a(f.a.this, 1);
      }
      
      public void onServiceDisconnected(ComponentName paramComponentName)
      {
        synchronized (f.a(f.this))
        {
          f.a.a(f.a.this, null);
          f.a.a(f.a.this, paramComponentName);
          Iterator localIterator = f.a.a(f.a.this).iterator();
          if (localIterator.hasNext()) {
            ((d.f)localIterator.next()).onServiceDisconnected(paramComponentName);
          }
        }
        f.a.a(f.a.this, 2);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */