package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class eh
{
  private final Object lq = new Object();
  private boolean qL = false;
  private final ei rA;
  private final LinkedList<a> rB;
  private final String rC;
  private final String rD;
  private long rE = -1L;
  private long rF = -1L;
  private long rG = -1L;
  private long rH = 0L;
  private long rI = -1L;
  private long rJ = -1L;
  
  public eh(ei paramei, String paramString1, String paramString2)
  {
    this.rA = paramei;
    this.rC = paramString1;
    this.rD = paramString2;
    this.rB = new LinkedList();
  }
  
  public eh(String paramString1, String paramString2)
  {
    this(ei.bC(), paramString1, paramString2);
  }
  
  public void bw()
  {
    synchronized (this.lq)
    {
      if ((this.rJ != -1L) && (this.rF == -1L))
      {
        this.rF = SystemClock.elapsedRealtime();
        this.rA.a(this);
      }
      ei localei = this.rA;
      ei.bF().bw();
      return;
    }
  }
  
  public void bx()
  {
    synchronized (this.lq)
    {
      if (this.rJ != -1L)
      {
        Object localObject2 = new a();
        ((a)localObject2).bB();
        this.rB.add(localObject2);
        this.rH += 1L;
        localObject2 = this.rA;
        ei.bF().bx();
        this.rA.a(this);
      }
      return;
    }
  }
  
  public void by()
  {
    synchronized (this.lq)
    {
      if ((this.rJ != -1L) && (!this.rB.isEmpty()))
      {
        a locala = (a)this.rB.getLast();
        if (locala.bz() == -1L)
        {
          locala.bA();
          this.rA.a(this);
        }
      }
      return;
    }
  }
  
  public void f(aj paramaj)
  {
    synchronized (this.lq)
    {
      this.rI = SystemClock.elapsedRealtime();
      ei localei = this.rA;
      ei.bF().b(paramaj, this.rI);
      return;
    }
  }
  
  public void j(long paramLong)
  {
    synchronized (this.lq)
    {
      this.rJ = paramLong;
      if (this.rJ != -1L) {
        this.rA.a(this);
      }
      return;
    }
  }
  
  public void k(long paramLong)
  {
    synchronized (this.lq)
    {
      if (this.rJ != -1L)
      {
        this.rE = paramLong;
        this.rA.a(this);
      }
      return;
    }
  }
  
  public void n(boolean paramBoolean)
  {
    synchronized (this.lq)
    {
      if (this.rJ != -1L)
      {
        this.rG = SystemClock.elapsedRealtime();
        if (!paramBoolean)
        {
          this.rF = this.rG;
          this.rA.a(this);
        }
      }
      return;
    }
  }
  
  public void o(boolean paramBoolean)
  {
    synchronized (this.lq)
    {
      if (this.rJ != -1L)
      {
        this.qL = paramBoolean;
        this.rA.a(this);
      }
      return;
    }
  }
  
  public Bundle toBundle()
  {
    ArrayList localArrayList;
    synchronized (this.lq)
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("seqnum", this.rC);
      localBundle1.putString("slotid", this.rD);
      localBundle1.putBoolean("ismediation", this.qL);
      localBundle1.putLong("treq", this.rI);
      localBundle1.putLong("tresponse", this.rJ);
      localBundle1.putLong("timp", this.rF);
      localBundle1.putLong("tload", this.rG);
      localBundle1.putLong("pcc", this.rH);
      localBundle1.putLong("tfetch", this.rE);
      localArrayList = new ArrayList();
      Iterator localIterator = this.rB.iterator();
      if (localIterator.hasNext()) {
        localArrayList.add(((a)localIterator.next()).toBundle());
      }
    }
    localBundle2.putParcelableArrayList("tclick", localArrayList);
    return localBundle2;
  }
  
  private static final class a
  {
    private long rK = -1L;
    private long rL = -1L;
    
    public void bA()
    {
      this.rL = SystemClock.elapsedRealtime();
    }
    
    public void bB()
    {
      this.rK = SystemClock.elapsedRealtime();
    }
    
    public long bz()
    {
      return this.rL;
    }
    
    public Bundle toBundle()
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("topen", this.rK);
      localBundle.putLong("tclose", this.rL);
      return localBundle;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/eh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */