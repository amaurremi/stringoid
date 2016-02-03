package com.a.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class d
  extends a
{
  boolean b = false;
  private ArrayList c = new ArrayList();
  private HashMap d = new HashMap();
  private ArrayList e = new ArrayList();
  private ArrayList f = new ArrayList();
  private boolean g = true;
  private f h = null;
  private boolean i = false;
  private long j = 0L;
  private an k = null;
  private long l = -1L;
  
  private void i()
  {
    Object localObject1;
    int n;
    int m;
    Object localObject2;
    int i1;
    int i2;
    if (this.g)
    {
      this.f.clear();
      localObject1 = new ArrayList();
      n = this.e.size();
      m = 0;
      while (m < n)
      {
        localObject2 = (j)this.e.get(m);
        if ((((j)localObject2).b == null) || (((j)localObject2).b.size() == 0)) {
          ((ArrayList)localObject1).add(localObject2);
        }
        m += 1;
      }
      localObject2 = new ArrayList();
      while (((ArrayList)localObject1).size() > 0)
      {
        i1 = ((ArrayList)localObject1).size();
        m = 0;
        while (m < i1)
        {
          j localj1 = (j)((ArrayList)localObject1).get(m);
          this.f.add(localj1);
          if (localj1.e != null)
          {
            i2 = localj1.e.size();
            n = 0;
            while (n < i2)
            {
              j localj2 = (j)localj1.e.get(n);
              localj2.d.remove(localj1);
              if (localj2.d.size() == 0) {
                ((ArrayList)localObject2).add(localj2);
              }
              n += 1;
            }
          }
          m += 1;
        }
        ((ArrayList)localObject1).clear();
        ((ArrayList)localObject1).addAll((Collection)localObject2);
        ((ArrayList)localObject2).clear();
      }
      this.g = false;
      if (this.f.size() != this.e.size()) {
        throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
      }
    }
    else
    {
      i1 = this.e.size();
      m = 0;
      while (m < i1)
      {
        localObject1 = (j)this.e.get(m);
        if ((((j)localObject1).b != null) && (((j)localObject1).b.size() > 0))
        {
          i2 = ((j)localObject1).b.size();
          n = 0;
          while (n < i2)
          {
            localObject2 = (h)((j)localObject1).b.get(n);
            if (((j)localObject1).d == null) {
              ((j)localObject1).d = new ArrayList();
            }
            if (!((j)localObject1).d.contains(((h)localObject2).a)) {
              ((j)localObject1).d.add(((h)localObject2).a);
            }
            n += 1;
          }
        }
        ((j)localObject1).f = false;
        m += 1;
      }
    }
  }
  
  public g a(a parama)
  {
    if (parama != null)
    {
      this.g = true;
      return new g(this, parama);
    }
    return null;
  }
  
  public void a()
  {
    int i1 = 0;
    this.b = false;
    this.i = true;
    i();
    int i2 = this.f.size();
    int m = 0;
    Object localObject2;
    Object localObject3;
    while (m < i2)
    {
      localObject1 = (j)this.f.get(m);
      localObject2 = ((j)localObject1).a.f();
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = new ArrayList((Collection)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (b)((Iterator)localObject2).next();
          if (((localObject3 instanceof i)) || ((localObject3 instanceof f))) {
            ((j)localObject1).a.b((b)localObject3);
          }
        }
      }
      m += 1;
    }
    Object localObject1 = new ArrayList();
    m = 0;
    int n;
    if (m < i2)
    {
      localObject2 = (j)this.f.get(m);
      if (this.h == null) {
        this.h = new f(this, this);
      }
      if ((((j)localObject2).b == null) || (((j)localObject2).b.size() == 0)) {
        ((ArrayList)localObject1).add(localObject2);
      }
      for (;;)
      {
        ((j)localObject2).a.a(this.h);
        m += 1;
        break;
        int i3 = ((j)localObject2).b.size();
        n = 0;
        while (n < i3)
        {
          localObject3 = (h)((j)localObject2).b.get(n);
          ((h)localObject3).a.a.a(new i(this, (j)localObject2, ((h)localObject3).b));
          n += 1;
        }
        ((j)localObject2).c = ((ArrayList)((j)localObject2).b.clone());
      }
    }
    if (this.j <= 0L)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (j)((Iterator)localObject1).next();
        ((j)localObject2).a.a();
        this.c.add(((j)localObject2).a);
      }
    }
    this.k = an.b(new float[] { 0.0F, 1.0F });
    this.k.c(this.j);
    this.k.a(new e(this, (ArrayList)localObject1));
    this.k.a();
    if (this.a != null)
    {
      localObject1 = (ArrayList)this.a.clone();
      n = ((ArrayList)localObject1).size();
      m = 0;
      while (m < n)
      {
        ((b)((ArrayList)localObject1).get(m)).a(this);
        m += 1;
      }
    }
    if ((this.e.size() == 0) && (this.j == 0L))
    {
      this.i = false;
      if (this.a != null)
      {
        localObject1 = (ArrayList)this.a.clone();
        n = ((ArrayList)localObject1).size();
        m = i1;
        while (m < n)
        {
          ((b)((ArrayList)localObject1).get(m)).c(this);
          m += 1;
        }
      }
    }
  }
  
  public void a(Interpolator paramInterpolator)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).a.a(paramInterpolator);
    }
  }
  
  public void a(Object paramObject)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      a locala = ((j)localIterator.next()).a;
      if ((locala instanceof d)) {
        ((d)locala).a(paramObject);
      } else if ((locala instanceof s)) {
        ((s)locala).a(paramObject);
      }
    }
  }
  
  public void a(a... paramVarArgs)
  {
    int m = 1;
    if (paramVarArgs != null)
    {
      this.g = true;
      g localg = a(paramVarArgs[0]);
      while (m < paramVarArgs.length)
      {
        localg.a(paramVarArgs[m]);
        m += 1;
      }
    }
  }
  
  public void b()
  {
    this.b = true;
    Object localObject;
    Iterator localIterator;
    if (e())
    {
      if (this.a == null) {
        break label173;
      }
      localObject = (ArrayList)this.a.clone();
      localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext()) {
        ((b)localIterator.next()).d(this);
      }
    }
    for (;;)
    {
      if ((this.k != null) && (this.k.d())) {
        this.k.b();
      }
      while (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((b)((Iterator)localObject).next()).c(this);
        }
        if (this.f.size() > 0)
        {
          localIterator = this.f.iterator();
          while (localIterator.hasNext()) {
            ((j)localIterator.next()).a.b();
          }
        }
      }
      this.i = false;
      return;
      label173:
      localObject = null;
    }
  }
  
  public void b(long paramLong)
  {
    this.j = paramLong;
  }
  
  public d c(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("duration must be a value of zero or greater");
    }
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).a.a(paramLong);
    }
    this.l = paramLong;
    return this;
  }
  
  public void c()
  {
    this.b = true;
    if (e())
    {
      Iterator localIterator;
      if (this.f.size() != this.e.size())
      {
        i();
        localIterator = this.f.iterator();
        while (localIterator.hasNext())
        {
          j localj = (j)localIterator.next();
          if (this.h == null) {
            this.h = new f(this, this);
          }
          localj.a.a(this.h);
        }
      }
      if (this.k != null) {
        this.k.b();
      }
      if (this.f.size() > 0)
      {
        localIterator = this.f.iterator();
        while (localIterator.hasNext()) {
          ((j)localIterator.next()).a.c();
        }
      }
      if (this.a != null)
      {
        localIterator = ((ArrayList)this.a.clone()).iterator();
        while (localIterator.hasNext()) {
          ((b)localIterator.next()).c(this);
        }
      }
      this.i = false;
    }
  }
  
  public boolean d()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      if (((j)localIterator.next()).a.d()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean e()
  {
    return this.i;
  }
  
  public d h()
  {
    d locald = (d)super.g();
    locald.g = true;
    locald.b = false;
    locald.i = false;
    locald.c = new ArrayList();
    locald.d = new HashMap();
    locald.e = new ArrayList();
    locald.f = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject3 = this.e.iterator();
    Object localObject2;
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (j)((Iterator)localObject3).next();
      localObject2 = ((j)localObject1).a();
      localHashMap.put(localObject1, localObject2);
      locald.e.add(localObject2);
      locald.d.put(((j)localObject2).a, localObject2);
      ((j)localObject2).b = null;
      ((j)localObject2).c = null;
      ((j)localObject2).e = null;
      ((j)localObject2).d = null;
      localObject4 = ((j)localObject2).a.f();
      if (localObject4 != null)
      {
        Iterator localIterator = ((ArrayList)localObject4).iterator();
        localObject1 = null;
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if ((localb instanceof f))
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localb);
            localObject1 = localObject2;
          }
        }
        if (localObject1 != null)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((ArrayList)localObject4).remove((b)((Iterator)localObject1).next());
          }
        }
      }
    }
    Object localObject1 = this.e.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (j)((Iterator)localObject1).next();
      localObject2 = (j)localHashMap.get(localObject3);
      if (((j)localObject3).b != null)
      {
        localObject3 = ((j)localObject3).b.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (h)((Iterator)localObject3).next();
          ((j)localObject2).a(new h((j)localHashMap.get(((h)localObject4).a), ((h)localObject4).b));
        }
      }
    }
    return locald;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */