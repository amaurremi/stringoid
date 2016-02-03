package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class eg
{
  private final Object ls = new Object();
  private boolean qO = false;
  private final eh rD;
  private final LinkedList<nb> rE;
  private final String rF;
  private final String rG;
  private long rH = -1L;
  private long rI = -1L;
  private long rJ = -1L;
  private long rK = 0L;
  private long rL = -1L;
  private long rM = -1L;
  
  public eg(eh parameh, String paramString1, String paramString2)
  {
    this.rD = parameh;
    this.rF = paramString1;
    this.rG = paramString2;
    this.rE = new LinkedList();
  }
  
  public eg(String paramString1, String paramString2)
  {
    this(eh.bH(), paramString1, paramString2);
  }
  
  public void bB()
  {
    synchronized (this.ls)
    {
      if ((this.rM != -1L) && (this.rI == -1L))
      {
        this.rI = SystemClock.elapsedRealtime();
        this.rD.a(this);
      }
      eh localeh = this.rD;
      eh.bK().bB();
      return;
    }
  }
  
  public void bC()
  {
    synchronized (this.ls)
    {
      if (this.rM != -1L)
      {
        Object localObject2 = new nb();
        ((nb)localObject2).c();
        this.rE.add(localObject2);
        this.rK += 1L;
        localObject2 = this.rD;
        eh.bK().bC();
        this.rD.a(this);
      }
      return;
    }
  }
  
  public void bD()
  {
    synchronized (this.ls)
    {
      if ((this.rM != -1L) && (!this.rE.isEmpty()))
      {
        nb localnb = (nb)this.rE.getLast();
        if (localnb.a() == -1L)
        {
          localnb.b();
          this.rD.a(this);
        }
      }
      return;
    }
  }
  
  public void f(ai paramai)
  {
    synchronized (this.ls)
    {
      this.rL = SystemClock.elapsedRealtime();
      eh localeh = this.rD;
      eh.bK().b(paramai, this.rL);
      return;
    }
  }
  
  public void j(long paramLong)
  {
    synchronized (this.ls)
    {
      this.rM = paramLong;
      if (this.rM != -1L) {
        this.rD.a(this);
      }
      return;
    }
  }
  
  public void k(long paramLong)
  {
    synchronized (this.ls)
    {
      if (this.rM != -1L)
      {
        this.rH = paramLong;
        this.rD.a(this);
      }
      return;
    }
  }
  
  public void n(boolean paramBoolean)
  {
    synchronized (this.ls)
    {
      if (this.rM != -1L)
      {
        this.rJ = SystemClock.elapsedRealtime();
        if (!paramBoolean)
        {
          this.rI = this.rJ;
          this.rD.a(this);
        }
      }
      return;
    }
  }
  
  public void o(boolean paramBoolean)
  {
    synchronized (this.ls)
    {
      if (this.rM != -1L)
      {
        this.qO = paramBoolean;
        this.rD.a(this);
      }
      return;
    }
  }
  
  public Bundle toBundle()
  {
    ArrayList localArrayList;
    synchronized (this.ls)
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("seqnum", this.rF);
      localBundle1.putString("slotid", this.rG);
      localBundle1.putBoolean("ismediation", this.qO);
      localBundle1.putLong("treq", this.rL);
      localBundle1.putLong("tresponse", this.rM);
      localBundle1.putLong("timp", this.rI);
      localBundle1.putLong("tload", this.rJ);
      localBundle1.putLong("pcc", this.rK);
      localBundle1.putLong("tfetch", this.rH);
      localArrayList = new ArrayList();
      Iterator localIterator = this.rE.iterator();
      if (localIterator.hasNext()) {
        localArrayList.add(((nb)localIterator.next()).d());
      }
    }
    localBundle2.putParcelableArrayList("tclick", localArrayList);
    return localBundle2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/eg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */