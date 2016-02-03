package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.b;
import com.google.android.gms.common.c.b;
import java.util.ArrayList;

public final class ct
{
  private final b Hd;
  private ArrayList<c.c> He = new ArrayList();
  final ArrayList<c.c> Hf = new ArrayList();
  private boolean Hg = false;
  private ArrayList<c.b> Hh = new ArrayList();
  private boolean Hi = false;
  private final Handler mHandler;
  
  public ct(Context paramContext, Looper paramLooper, b paramb)
  {
    this.Hd = paramb;
    this.mHandler = new a(paramLooper);
  }
  
  public void a(c.b paramb)
  {
    dc.N(paramb);
    synchronized (this.Hh)
    {
      if (this.Hh.contains(paramb))
      {
        Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + paramb + " is already registered");
        return;
      }
      if (this.Hi) {
        this.Hh = new ArrayList(this.Hh);
      }
      this.Hh.add(paramb);
    }
  }
  
  public void b(c.c paramc)
  {
    dc.N(paramc);
    synchronized (this.He)
    {
      if (this.He.contains(paramc))
      {
        Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + paramc + " is already registered");
        if (this.Hd.isConnected()) {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramc));
        }
        return;
      }
      if (this.Hg) {
        this.He = new ArrayList(this.He);
      }
      this.He.add(paramc);
    }
  }
  
  public void b(b paramb)
  {
    this.mHandler.removeMessages(1);
    for (;;)
    {
      int i;
      synchronized (this.Hh)
      {
        this.Hi = true;
        ArrayList localArrayList2 = this.Hh;
        int j = localArrayList2.size();
        i = 0;
        if (i < j)
        {
          if (!this.Hd.mG()) {
            return;
          }
          if (this.Hh.contains(localArrayList2.get(i))) {
            ((c.b)localArrayList2.get(i)).a(paramb);
          }
        }
        else
        {
          this.Hi = false;
          return;
        }
      }
      i += 1;
    }
  }
  
  public void cF(int paramInt)
  {
    this.mHandler.removeMessages(1);
    for (;;)
    {
      int i;
      synchronized (this.He)
      {
        this.Hg = true;
        ArrayList localArrayList2 = this.He;
        int j = localArrayList2.size();
        i = 0;
        if ((i >= j) || (!this.Hd.mG()))
        {
          this.Hg = false;
          return;
        }
        if (this.He.contains(localArrayList2.get(i))) {
          ((c.c)localArrayList2.get(i)).bl(paramInt);
        }
      }
      i += 1;
    }
  }
  
  public void l(Bundle paramBundle)
  {
    boolean bool2 = true;
    for (;;)
    {
      int i;
      synchronized (this.He)
      {
        if (!this.Hg)
        {
          bool1 = true;
          dc.G(bool1);
          this.mHandler.removeMessages(1);
          this.Hg = true;
          if (this.Hf.size() != 0) {
            break label172;
          }
          bool1 = bool2;
          dc.G(bool1);
          ArrayList localArrayList2 = this.He;
          int j = localArrayList2.size();
          i = 0;
          if ((i >= j) || (!this.Hd.mG()) || (!this.Hd.isConnected()))
          {
            this.Hf.clear();
            this.Hg = false;
            return;
          }
          this.Hf.size();
          if (this.Hf.contains(localArrayList2.get(i))) {
            break label178;
          }
          ((c.c)localArrayList2.get(i)).a(paramBundle);
        }
      }
      boolean bool1 = false;
      continue;
      label172:
      bool1 = false;
      continue;
      label178:
      i += 1;
    }
  }
  
  protected void lh()
  {
    synchronized (this.He)
    {
      l(this.Hd.mH());
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
        synchronized (ct.a(ct.this))
        {
          if ((ct.b(ct.this).mG()) && (ct.b(ct.this).isConnected()) && (ct.a(ct.this).contains(paramMessage.obj)))
          {
            Bundle localBundle = ct.b(ct.this).mH();
            ((c.c)paramMessage.obj).a(localBundle);
          }
          return;
        }
      }
      Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean isConnected();
    
    public abstract boolean mG();
    
    public abstract Bundle mH();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */