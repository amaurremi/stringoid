package com.flurry.android.monolithic.sdk.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class yb
{
  protected final rf<?> a;
  protected final boolean b;
  protected final afm c;
  protected final xh d;
  protected final ye<?> e;
  protected final py f;
  protected final LinkedHashMap<String, yc> g = new LinkedHashMap();
  protected LinkedList<yc> h = null;
  protected LinkedList<xl> i = null;
  protected LinkedList<xl> j = null;
  protected LinkedList<xl> k = null;
  protected Set<String> l;
  protected Set<String> m;
  protected LinkedHashMap<Object, xk> n;
  
  protected yb(rf<?> paramrf, boolean paramBoolean, afm paramafm, xh paramxh)
  {
    this.a = paramrf;
    this.b = paramBoolean;
    this.c = paramafm;
    this.d = paramxh;
    paramafm = (afm)localObject;
    if (paramrf.b()) {
      paramafm = this.a.a();
    }
    this.f = paramafm;
    if (this.f == null)
    {
      this.e = this.a.e();
      return;
    }
    this.e = this.f.a(paramxh, this.a.e());
  }
  
  private Set<String> a(Set<String> paramSet, String paramString)
  {
    Object localObject = paramSet;
    if (paramSet == null) {
      localObject = new HashSet();
    }
    ((Set)localObject).add(paramString);
    return (Set<String>)localObject;
  }
  
  private void a(yc paramyc)
  {
    if (this.b) {}
    String str;
    do
    {
      return;
      str = paramyc.a();
      this.l = a(this.l, str);
    } while (!paramyc.t());
    this.m = a(this.m, str);
  }
  
  public rf<?> a()
  {
    return this.a;
  }
  
  protected void a(rl paramrl)
  {
    yc[] arrayOfyc = (yc[])this.g.values().toArray(new yc[this.g.size()]);
    this.g.clear();
    int i2 = arrayOfyc.length;
    int i1 = 0;
    yc localyc2;
    String str;
    if (i1 < i2)
    {
      localyc2 = arrayOfyc[i1];
      str = localyc2.a();
      if (this.b) {
        if (localyc2.b()) {
          str = paramrl.a(this.a, localyc2.g(), str);
        }
      }
    }
    label90:
    label305:
    for (;;)
    {
      yc localyc1 = localyc2;
      if (!str.equals(localyc2.a())) {
        localyc1 = localyc2.a(str);
      }
      localyc2 = (yc)this.g.get(str);
      if (localyc2 == null) {
        this.g.put(str, localyc1);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (!localyc2.d()) {
          break label305;
        }
        str = paramrl.a(this.a, localyc2.i(), str);
        break label90;
        if (localyc2.c())
        {
          str = paramrl.b(this.a, localyc2.h(), str);
          break label90;
        }
        if (localyc2.e())
        {
          str = paramrl.a(this.a, localyc2.m(), str);
          break label90;
        }
        if (localyc2.d())
        {
          str = paramrl.a(this.a, localyc2.i(), str);
          break label90;
        }
        if (!localyc2.b()) {
          break label305;
        }
        str = paramrl.a(this.a, localyc2.g(), str);
        break label90;
        localyc2.b(localyc1);
      }
      return;
    }
  }
  
  protected void a(Object paramObject, xk paramxk)
  {
    if (paramObject == null) {}
    do
    {
      return;
      if (this.n == null) {
        this.n = new LinkedHashMap();
      }
    } while ((xk)this.n.put(paramObject, paramxk) == null);
    if (paramObject == null) {}
    for (paramxk = "[null]";; paramxk = paramObject.getClass().getName()) {
      throw new IllegalArgumentException("Duplicate injectable value with id '" + String.valueOf(paramObject) + "' (of type " + paramxk + ")");
    }
  }
  
  protected void a(String paramString)
  {
    throw new IllegalArgumentException("Problem with definition of " + this.d + ": " + paramString);
  }
  
  public afm b()
  {
    return this.c;
  }
  
  protected yc b(String paramString)
  {
    yc localyc2 = (yc)this.g.get(paramString);
    yc localyc1 = localyc2;
    if (localyc2 == null)
    {
      localyc1 = new yc(paramString);
      this.g.put(paramString, localyc1);
    }
    return localyc1;
  }
  
  public xh c()
  {
    return this.d;
  }
  
  public List<qe> d()
  {
    return new ArrayList(this.g.values());
  }
  
  public Map<Object, xk> e()
  {
    return this.n;
  }
  
  public xl f()
  {
    if (this.k != null)
    {
      if (this.k.size() > 1) {
        a("Multiple value properties defined (" + this.k.get(0) + " vs " + this.k.get(1) + ")");
      }
      return (xl)this.k.get(0);
    }
    return null;
  }
  
  public xl g()
  {
    if (this.i != null)
    {
      if (this.i.size() > 1) {
        a("Multiple 'any-getters' defined (" + this.i.get(0) + " vs " + this.i.get(1) + ")");
      }
      return (xl)this.i.getFirst();
    }
    return null;
  }
  
  public xl h()
  {
    if (this.j != null)
    {
      if (this.j.size() > 1) {
        a("Multiple 'any-setters' defined (" + this.j.get(0) + " vs " + this.j.get(1) + ")");
      }
      return (xl)this.j.getFirst();
    }
    return null;
  }
  
  public Set<String> i()
  {
    return this.l;
  }
  
  public Set<String> j()
  {
    return this.m;
  }
  
  public yb k()
  {
    this.g.clear();
    m();
    o();
    n();
    p();
    q();
    r();
    Object localObject = this.a.j();
    if (localObject != null) {
      a((rl)localObject);
    }
    localObject = this.g.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((yc)((Iterator)localObject).next()).p();
    }
    localObject = this.g.values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((yc)((Iterator)localObject).next()).a(this.b);
    }
    l();
    return this;
  }
  
  protected void l()
  {
    Object localObject1 = this.a.a();
    Object localObject2 = ((py)localObject1).i(this.d);
    if (localObject2 == null) {}
    String[] arrayOfString;
    for (boolean bool = this.a.d();; bool = ((Boolean)localObject2).booleanValue())
    {
      arrayOfString = ((py)localObject1).h(this.d);
      if ((bool) || (this.h != null) || (arrayOfString != null)) {
        break;
      }
      return;
    }
    int i1 = this.g.size();
    if (bool) {}
    for (localObject1 = new TreeMap();; localObject1 = new LinkedHashMap(i1 + i1))
    {
      localObject2 = this.g.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (yc)((Iterator)localObject2).next();
        ((Map)localObject1).put(((yc)localObject3).a(), localObject3);
      }
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(i1 + i1);
    String str;
    if (arrayOfString != null)
    {
      int i2 = arrayOfString.length;
      i1 = 0;
      if (i1 < i2)
      {
        str = arrayOfString[i1];
        localObject2 = (yc)((Map)localObject1).get(str);
        if (localObject2 != null) {
          break label383;
        }
        Iterator localIterator = this.g.values().iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (yc)localIterator.next();
          if (str.equals(((yc)localObject3).l()))
          {
            str = ((yc)localObject3).a();
            localObject2 = localObject3;
          }
        }
      }
    }
    label383:
    for (Object localObject3 = str;; localObject3 = str)
    {
      if (localObject2 != null) {
        localLinkedHashMap.put(localObject3, localObject2);
      }
      i1 += 1;
      break;
      if (this.h != null)
      {
        localObject2 = this.h.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (yc)((Iterator)localObject2).next();
          localLinkedHashMap.put(((yc)localObject3).a(), localObject3);
        }
      }
      localLinkedHashMap.putAll((Map)localObject1);
      this.g.clear();
      this.g.putAll(localLinkedHashMap);
      return;
    }
  }
  
  protected void m()
  {
    py localpy = this.f;
    Iterator localIterator = this.d.l().iterator();
    xj localxj;
    String str;
    Object localObject;
    if (localIterator.hasNext())
    {
      localxj = (xj)localIterator.next();
      str = localxj.b();
      if (localpy == null)
      {
        localObject = null;
        label56:
        if (!"".equals(localObject)) {
          break label168;
        }
        localObject = str;
      }
    }
    label75:
    label165:
    label168:
    for (;;)
    {
      boolean bool1;
      if (localObject != null)
      {
        bool1 = true;
        if (bool1) {
          break label165;
        }
        bool1 = this.e.a(localxj);
      }
      for (;;)
      {
        if ((localpy != null) && (localpy.c(localxj))) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          b(str).a(localxj, (String)localObject, bool1, bool2);
          break;
          if (this.b)
          {
            localObject = localpy.b(localxj);
            break label56;
          }
          localObject = localpy.c(localxj);
          break label56;
          bool1 = false;
          break label75;
        }
        return;
      }
    }
  }
  
  protected void n()
  {
    py localpy = this.f;
    if (localpy == null) {
      return;
    }
    Iterator localIterator = this.d.i().iterator();
    Object localObject;
    int i2;
    int i1;
    xn localxn;
    String str;
    yc localyc;
    while (localIterator.hasNext())
    {
      localObject = (xi)localIterator.next();
      if (this.h == null) {
        this.h = new LinkedList();
      }
      i2 = ((xi)localObject).f();
      i1 = 0;
      while (i1 < i2)
      {
        localxn = ((xi)localObject).c(i1);
        str = localpy.a(localxn);
        if (str != null)
        {
          localyc = b(str);
          localyc.a(localxn, str, true, false);
          this.h.add(localyc);
        }
        i1 += 1;
      }
    }
    localIterator = this.d.j().iterator();
    while (localIterator.hasNext())
    {
      localObject = (xl)localIterator.next();
      if (this.h == null) {
        this.h = new LinkedList();
      }
      i2 = ((xl)localObject).f();
      i1 = 0;
      while (i1 < i2)
      {
        localxn = ((xl)localObject).c(i1);
        str = localpy.a(localxn);
        if (str != null)
        {
          localyc = b(str);
          localyc.a(localxn, str, true, false);
          this.h.add(localyc);
        }
        i1 += 1;
      }
    }
  }
  
  protected void o()
  {
    py localpy = this.f;
    Iterator localIterator = this.d.k().iterator();
    while (localIterator.hasNext())
    {
      xl localxl = (xl)localIterator.next();
      int i1 = localxl.f();
      Object localObject1;
      label147:
      Object localObject3;
      boolean bool1;
      Object localObject2;
      label206:
      boolean bool2;
      if (i1 == 0)
      {
        if (localpy != null)
        {
          if (localpy.f(localxl))
          {
            if (this.i == null) {
              this.i = new LinkedList();
            }
            this.i.add(localxl);
            continue;
          }
          if (localpy.c(localxl))
          {
            if (this.k == null) {
              this.k = new LinkedList();
            }
            this.k.add(localxl);
            continue;
          }
        }
        if (localpy == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label266;
          }
          localObject3 = ady.a(localxl, localxl.b());
          if (localObject3 != null) {
            break label243;
          }
          localObject3 = ady.b(localxl, localxl.b());
          if (localObject3 == null) {
            continue;
          }
          bool1 = this.e.b(localxl);
          localObject2 = localObject1;
          localObject1 = localObject3;
          if (localpy != null) {
            break label318;
          }
        }
        label243:
        label266:
        label318:
        for (bool2 = false;; bool2 = localpy.c(localxl))
        {
          b((String)localObject1).a(localxl, (String)localObject2, bool1, bool2);
          break;
          localObject1 = localpy.b(localxl);
          break label147;
          bool1 = this.e.a(localxl);
          localObject2 = localObject1;
          localObject1 = localObject3;
          break label206;
          localObject3 = ady.a(localxl);
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = localxl.b();
          }
          localObject3 = localObject1;
          if (((String)localObject1).length() == 0) {
            localObject3 = localObject2;
          }
          localObject1 = localObject2;
          localObject2 = localObject3;
          bool1 = true;
          break label206;
        }
      }
      else if (i1 == 1)
      {
        if (localpy == null)
        {
          localObject1 = null;
          label342:
          if (localObject1 != null) {
            break label416;
          }
          localObject3 = ady.b(localxl);
          if (localObject3 == null) {
            continue;
          }
          bool1 = this.e.c(localxl);
          localObject2 = localObject1;
          localObject1 = localObject3;
          label379:
          if (localpy != null) {
            break label468;
          }
        }
        label416:
        label468:
        for (bool2 = false;; bool2 = localpy.c(localxl))
        {
          b((String)localObject1).b(localxl, (String)localObject2, bool1, bool2);
          break;
          localObject1 = localpy.d(localxl);
          break label342;
          localObject3 = ady.b(localxl);
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = localxl.b();
          }
          localObject3 = localObject1;
          if (((String)localObject1).length() == 0) {
            localObject3 = localObject2;
          }
          localObject1 = localObject2;
          localObject2 = localObject3;
          bool1 = true;
          break label379;
        }
      }
      else if ((i1 == 2) && (localpy != null) && (localpy.e(localxl)))
      {
        if (this.j == null) {
          this.j = new LinkedList();
        }
        this.j.add(localxl);
      }
    }
  }
  
  protected void p()
  {
    py localpy = this.f;
    if (localpy == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.d.l().iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (xj)localIterator.next();
        a(localpy.d((xk)localObject), (xk)localObject);
      }
      localIterator = this.d.k().iterator();
      while (localIterator.hasNext())
      {
        localObject = (xl)localIterator.next();
        if (((xl)localObject).f() == 1) {
          a(localpy.d((xk)localObject), (xk)localObject);
        }
      }
    }
  }
  
  protected void q()
  {
    Iterator localIterator = this.g.entrySet().iterator();
    while (localIterator.hasNext())
    {
      yc localyc = (yc)((Map.Entry)localIterator.next()).getValue();
      if (!localyc.r())
      {
        localIterator.remove();
      }
      else if (localyc.s())
      {
        a(localyc);
        if (!localyc.q()) {
          localIterator.remove();
        } else {
          localyc.n();
        }
      }
      else
      {
        localyc.o();
      }
    }
  }
  
  protected void r()
  {
    Object localObject3 = this.g.entrySet().iterator();
    Object localObject1 = null;
    yc localyc;
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      localyc = (yc)((Map.Entry)((Iterator)localObject3).next()).getValue();
      String str = localyc.u();
      if (str != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new LinkedList();
        }
        ((LinkedList)localObject2).add(localyc.a(str));
        ((Iterator)localObject3).remove();
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (yc)((Iterator)localObject1).next();
        localObject3 = ((yc)localObject2).a();
        localyc = (yc)this.g.get(localObject3);
        if (localyc == null) {
          this.g.put(localObject3, localObject2);
        } else {
          localyc.b((yc)localObject2);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/yb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */