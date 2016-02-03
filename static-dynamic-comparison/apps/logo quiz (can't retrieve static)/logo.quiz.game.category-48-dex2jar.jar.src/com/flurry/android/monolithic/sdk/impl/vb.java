package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

@rz
public class vb
  extends ug<Map<Object, Object>>
  implements ro
{
  protected final afm a;
  protected final rc b;
  protected final qu<Object> c;
  protected final rw d;
  protected final th e;
  protected final boolean f;
  protected tr g;
  protected qu<Object> h;
  protected HashSet<String> i;
  
  public vb(afm paramafm, th paramth, rc paramrc, qu<Object> paramqu, rw paramrw)
  {
    super(Map.class);
    this.a = paramafm;
    this.b = paramrc;
    this.c = paramqu;
    this.d = paramrw;
    this.e = paramth;
    if (paramth.j()) {}
    for (this.g = new tr(paramth);; this.g = null)
    {
      this.f = paramth.h();
      return;
    }
  }
  
  public Object a(ow paramow, qm paramqm, rw paramrw)
    throws IOException, oz
  {
    return paramrw.a(paramow, paramqm);
  }
  
  public Map<Object, Object> a(ow paramow, qm paramqm, Map<Object, Object> paramMap)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if ((localpb != pb.b) && (localpb != pb.f)) {
      throw paramqm.b(e());
    }
    b(paramow, paramqm, paramMap);
    return paramMap;
  }
  
  public void a(qk paramqk, qq paramqq)
    throws qw
  {
    Object localObject;
    if (this.e.i())
    {
      localObject = this.e.l();
      if (localObject == null) {
        throw new IllegalArgumentException("Invalid delegate-creator definition for " + this.a + ": value instantiator (" + this.e.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
      }
      this.h = a(paramqk, paramqq, (afm)localObject, new qd(null, (afm)localObject, null, this.e.o()));
    }
    if (this.g != null)
    {
      localObject = this.g.a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        sw localsw = (sw)((Iterator)localObject).next();
        if (!localsw.f()) {
          this.g.a(localsw, a(paramqk, paramqq, localsw.a(), localsw));
        }
      }
    }
  }
  
  protected void a(Throwable paramThrowable, Object paramObject)
    throws IOException
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if (((paramThrowable instanceof IOException)) && (!(paramThrowable instanceof qw))) {
      throw ((IOException)paramThrowable);
    }
    throw qw.a(paramThrowable, paramObject, null);
  }
  
  public void a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    for (paramArrayOfString = null;; paramArrayOfString = adp.a(paramArrayOfString))
    {
      this.i = paramArrayOfString;
      return;
    }
  }
  
  public Map<Object, Object> b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (this.g != null) {
      return c(paramow, paramqm);
    }
    if (this.h != null) {
      return (Map)this.e.a(this.h.a(paramow, paramqm));
    }
    if (!this.f) {
      throw paramqm.a(e(), "No default constructor found");
    }
    Object localObject = paramow.e();
    if ((localObject != pb.b) && (localObject != pb.f) && (localObject != pb.c))
    {
      if (localObject == pb.h) {
        return (Map)this.e.a(paramow.k());
      }
      throw paramqm.b(e());
    }
    localObject = (Map)this.e.m();
    b(paramow, paramqm, (Map)localObject);
    return (Map<Object, Object>)localObject;
  }
  
  protected final void b(ow paramow, qm paramqm, Map<Object, Object> paramMap)
    throws IOException, oz
  {
    Object localObject2 = paramow.e();
    Object localObject1 = localObject2;
    if (localObject2 == pb.b) {
      localObject1 = paramow.b();
    }
    localObject2 = this.b;
    qu localqu = this.c;
    rw localrw = this.d;
    while (localObject1 == pb.f)
    {
      localObject1 = paramow.g();
      Object localObject3 = ((rc)localObject2).a((String)localObject1, paramqm);
      pb localpb = paramow.b();
      if ((this.i != null) && (this.i.contains(localObject1)))
      {
        paramow.d();
        localObject1 = paramow.b();
      }
      else
      {
        if (localpb == pb.m) {
          localObject1 = null;
        }
        for (;;)
        {
          paramMap.put(localObject3, localObject1);
          break;
          if (localrw == null) {
            localObject1 = localqu.a(paramow, paramqm);
          } else {
            localObject1 = localqu.a(paramow, paramqm, localrw);
          }
        }
      }
    }
  }
  
  public Map<Object, Object> c(ow paramow, qm paramqm)
    throws IOException, oz
  {
    tr localtr = this.g;
    tw localtw = localtr.a(paramow, paramqm);
    Object localObject2 = paramow.e();
    Object localObject1 = localObject2;
    if (localObject2 == pb.b) {
      localObject1 = paramow.b();
    }
    localObject2 = this.c;
    rw localrw = this.d;
    if (localObject1 == pb.f)
    {
      Object localObject3 = paramow.g();
      localObject1 = paramow.b();
      if ((this.i != null) && (this.i.contains(localObject3))) {
        paramow.d();
      }
      do
      {
        localObject1 = paramow.b();
        break;
        localObject3 = localtr.a((String)localObject3);
        if (localObject3 == null) {
          break label175;
        }
        localObject1 = ((sw)localObject3).a(paramow, paramqm);
      } while (!localtw.a(((sw)localObject3).j(), localObject1));
      paramow.b();
      try
      {
        localObject1 = (Map)localtr.a(localtw);
        b(paramow, paramqm, (Map)localObject1);
        return (Map<Object, Object>)localObject1;
      }
      catch (Exception paramow)
      {
        a(paramow, this.a.p());
        return null;
      }
      label175:
      localObject3 = paramow.g();
      localObject3 = this.b.a((String)localObject3, paramqm);
      if (localObject1 == pb.m) {
        localObject1 = null;
      }
      for (;;)
      {
        localtw.a(localObject3, localObject1);
        break;
        if (localrw == null) {
          localObject1 = ((qu)localObject2).a(paramow, paramqm);
        } else {
          localObject1 = ((qu)localObject2).a(paramow, paramqm, localrw);
        }
      }
    }
    try
    {
      paramow = (Map)localtr.a(localtw);
      return paramow;
    }
    catch (Exception paramow)
    {
      a(paramow, this.a.p());
    }
    return null;
  }
  
  public qu<Object> d()
  {
    return this.c;
  }
  
  public final Class<?> e()
  {
    return this.a.p();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/vb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */