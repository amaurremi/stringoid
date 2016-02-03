package com.flurry.android.monolithic.sdk.impl;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;

public class gz
{
  public long a = 30000L;
  protected HashMap<String, hb> b = new HashMap();
  private String c = null;
  private String d = null;
  private boolean e = false;
  
  gz(String paramString)
  {
    this.c = paramString;
    this.d = null;
  }
  
  private long a(int paramInt)
  {
    if (paramInt == 0) {
      return 0L;
    }
    return this.a;
  }
  
  private void a(String paramString, long paramLong)
  {
    ft localft;
    if (TextUtils.isEmpty(this.d))
    {
      localft = new ft();
      localft.b(this.c);
    }
    try
    {
      localft.a(new ha(this, paramString, paramLong));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean a(fq paramfq, String paramString)
  {
    if ((paramfq == null) || (paramfq.a())) {}
    while (!paramfq.b().equals("invalid user session")) {
      return true;
    }
    if (this.b.containsKey(paramString))
    {
      paramfq = ((hb)this.b.get(paramString)).c().iterator();
      while (paramfq.hasNext()) {
        ((fz)paramfq.next()).a(new hy(405, "Session not valid, user has to relogin!"));
      }
    }
    return false;
  }
  
  private void c(String paramString)
  {
    if (((hb)this.b.get(paramString)).a == null) {
      return;
    }
    hb localhb = (hb)this.b.get(paramString);
    if (localhb == null)
    {
      ja.a(6, "ObserverItem", "stopTimerForKey ERROR, info == null");
      return;
    }
    localhb.b();
    if (localhb.b() != null)
    {
      localhb.b().cancel();
      localhb.a(null);
    }
    this.b.put(paramString, localhb);
  }
  
  private void d(String paramString)
  {
    a(paramString, Long.valueOf(a(0)));
  }
  
  private void e()
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext()) {
      d((String)((Map.Entry)localIterator.next()).getKey());
    }
  }
  
  private void f()
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext()) {
      c((String)((Map.Entry)localIterator.next()).getKey());
    }
  }
  
  public int a()
  {
    return this.b.size();
  }
  
  protected void a(String paramString, fz paramfz)
  {
    Object localObject;
    if (this.b.containsKey(paramString))
    {
      localObject = (hb)this.b.get(paramString);
      if (localObject == null) {
        ja.a(6, "ObserverItem", "addObserverForKey ERROR, info == null");
      }
    }
    for (;;)
    {
      return;
      ((hb)localObject).c().add(paramfz);
      this.b.put(paramString, localObject);
      while (this.e)
      {
        d(paramString);
        return;
        localObject = new LinkedList();
        ((List)localObject).add(paramfz);
        this.b.put(paramString, new hb(this, (List)localObject));
      }
    }
  }
  
  protected void a(String paramString, Long paramLong)
  {
    c(paramString);
    if (!this.e) {
      return;
    }
    hb localhb = (hb)this.b.get(paramString);
    if (localhb == null)
    {
      ja.a(6, "ObserverItem", "scheduleTimerForKey ERROR, info == null");
      return;
    }
    localhb.a = new Timer();
    hc localhc = new hc(this, paramString);
    ja.a(4, "ObserverItem", "schedule");
    localhb.a.schedule(localhc, paramLong.longValue());
    this.b.put(paramString, localhb);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.b.containsKey(paramString1))
    {
      Iterator localIterator = ((hb)this.b.get(paramString1)).c().iterator();
      while (localIterator.hasNext()) {
        ((fz)localIterator.next()).a(paramString1, paramString2);
      }
    }
  }
  
  public boolean a(fz paramfz)
  {
    Iterator localIterator = this.b.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      List localList = ((hb)((Map.Entry)localIterator.next()).getValue()).c();
      if (!localList.contains(paramfz)) {
        break label89;
      }
      localList.remove(paramfz);
      if (localList.size() == 0) {
        localIterator.remove();
      }
      bool = true;
    }
    label89:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  protected boolean a(String paramString)
  {
    if (!this.b.containsKey(paramString)) {
      return false;
    }
    c(paramString);
    this.b.remove(paramString);
    return true;
  }
  
  public void b()
  {
    this.e = true;
    e();
  }
  
  protected void b(String paramString)
  {
    hb localhb = (hb)this.b.get(paramString);
    if (localhb == null)
    {
      ja.a(6, "ObserverItem", "addObserverForKey ERROR, info == null");
      return;
    }
    localhb.a();
    long l = a(localhb.d());
    this.b.put(paramString, localhb);
    a(paramString, l);
  }
  
  void c()
  {
    if (this.e) {
      e();
    }
  }
  
  void d()
  {
    f();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/gz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */