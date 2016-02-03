package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class bj
{
  private final LinkedList<a> EM;
  private final String EN;
  private final String EO;
  private long EP = -1L;
  private long EQ = -1L;
  private long ER = -1L;
  private long ES = 0L;
  private long ET = -1L;
  private long EU = -1L;
  private boolean Ek = false;
  private final Object xV = new Object();
  
  public bj(String paramString1, String paramString2)
  {
    this.EN = paramString1;
    this.EO = paramString2;
    this.EM = new LinkedList();
  }
  
  public void B(boolean paramBoolean)
  {
    synchronized (this.xV)
    {
      if (this.EU != -1L)
      {
        this.ER = SystemClock.elapsedRealtime();
        if (!paramBoolean)
        {
          this.EQ = this.ER;
          bk.a(this);
        }
      }
      return;
    }
  }
  
  public void C(boolean paramBoolean)
  {
    synchronized (this.xV)
    {
      if (this.EU != -1L)
      {
        this.Ek = paramBoolean;
        bk.a(this);
      }
      return;
    }
  }
  
  public void c(z paramz)
  {
    synchronized (this.xV)
    {
      this.ET = SystemClock.elapsedRealtime();
      bk.pK().a(paramz, this.ET);
      return;
    }
  }
  
  public void k(long paramLong)
  {
    synchronized (this.xV)
    {
      this.EU = paramLong;
      if (this.EU != -1L) {
        bk.a(this);
      }
      return;
    }
  }
  
  public void l(long paramLong)
  {
    synchronized (this.xV)
    {
      if (this.EU != -1L)
      {
        this.EP = paramLong;
        bk.a(this);
      }
      return;
    }
  }
  
  public void pD()
  {
    synchronized (this.xV)
    {
      if ((this.EU != -1L) && (this.EQ != -1L))
      {
        this.EQ = SystemClock.elapsedRealtime();
        bk.pK().pD();
        bk.a(this);
      }
      return;
    }
  }
  
  public void pE()
  {
    synchronized (this.xV)
    {
      if (this.EU != -1L)
      {
        a locala = new a();
        locala.pI();
        this.EM.add(locala);
        this.ES += 1L;
        bk.pK().pE();
        bk.a(this);
      }
      return;
    }
  }
  
  public void pF()
  {
    synchronized (this.xV)
    {
      if ((this.EU != -1L) && (!this.EM.isEmpty()))
      {
        a locala = (a)this.EM.getLast();
        if (locala.pG() == -1L)
        {
          locala.pH();
          bk.a(this);
        }
      }
      return;
    }
  }
  
  public Bundle toBundle()
  {
    ArrayList localArrayList;
    synchronized (this.xV)
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("seqnum", this.EN);
      localBundle1.putString("slotid", this.EO);
      localBundle1.putBoolean("ismediation", this.Ek);
      localBundle1.putLong("treq", this.ET);
      localBundle1.putLong("tresponse", this.EU);
      localBundle1.putLong("timp", this.EQ);
      localBundle1.putLong("tload", this.ER);
      localBundle1.putLong("pcc", this.ES);
      localBundle1.putLong("tfetch", this.EP);
      localArrayList = new ArrayList();
      Iterator localIterator = this.EM.iterator();
      if (localIterator.hasNext()) {
        localArrayList.add(((a)localIterator.next()).toBundle());
      }
    }
    localBundle2.putParcelableArrayList("tclick", localArrayList);
    return localBundle2;
  }
  
  private static final class a
  {
    private long EV = -1L;
    private long EW = -1L;
    
    public long pG()
    {
      return this.EW;
    }
    
    public void pH()
    {
      this.EW = SystemClock.elapsedRealtime();
    }
    
    public void pI()
    {
      this.EV = SystemClock.elapsedRealtime();
    }
    
    public Bundle toBundle()
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("topen", this.EV);
      localBundle.putLong("tclose", this.EW);
      return localBundle;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */