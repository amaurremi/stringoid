package com.flurry.android.monolithic.sdk.impl;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@sa
public class sp
  extends vo<Object>
  implements ro
{
  protected final xh a;
  protected final afm b;
  protected final qc c;
  protected final th d;
  protected qu<Object> e;
  protected final tr f;
  protected boolean g;
  protected final tj h;
  protected final ty[] i;
  protected sv j;
  protected final HashSet<String> k;
  protected final boolean l;
  protected final Map<String, sw> m;
  protected HashMap<adb, qu<Object>> n;
  protected tx o;
  protected to p;
  
  public sp(qb paramqb, qc paramqc, th paramth, tj paramtj, Map<String, sw> paramMap, HashSet<String> paramHashSet, boolean paramBoolean, sv paramsv, List<ty> paramList)
  {
    this(paramqb.c(), paramqb.a(), paramqc, paramth, paramtj, paramMap, paramHashSet, paramBoolean, paramsv, paramList);
  }
  
  protected sp(sp paramsp)
  {
    this(paramsp, paramsp.l);
  }
  
  protected sp(sp paramsp, boolean paramBoolean)
  {
    super(paramsp.b);
    this.a = paramsp.a;
    this.b = paramsp.b;
    this.c = paramsp.c;
    this.d = paramsp.d;
    this.e = paramsp.e;
    this.f = paramsp.f;
    this.h = paramsp.h;
    this.m = paramsp.m;
    this.k = paramsp.k;
    this.l = paramBoolean;
    this.j = paramsp.j;
    this.i = paramsp.i;
    this.g = paramsp.g;
    this.o = paramsp.o;
  }
  
  protected sp(xh paramxh, afm paramafm, qc paramqc, th paramth, tj paramtj, Map<String, sw> paramMap, HashSet<String> paramHashSet, boolean paramBoolean, sv paramsv, List<ty> paramList)
  {
    super(paramafm);
    this.a = paramxh;
    this.b = paramafm;
    this.c = paramqc;
    this.d = paramth;
    if (paramth.j())
    {
      this.f = new tr(paramth);
      this.h = paramtj;
      this.m = paramMap;
      this.k = paramHashSet;
      this.l = paramBoolean;
      this.j = paramsv;
      paramxh = (xh)localObject;
      if (paramList != null)
      {
        if (!paramList.isEmpty()) {
          break label154;
        }
        paramxh = (xh)localObject;
      }
      label101:
      this.i = paramxh;
      if ((!paramth.i()) && (this.f == null) && (paramth.h()) && (this.o == null)) {
        break label178;
      }
    }
    label154:
    label178:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.g = paramBoolean;
      return;
      this.f = null;
      break;
      paramxh = (ty[])paramList.toArray(new ty[paramList.size()]);
      break label101;
    }
  }
  
  private final void b(ow paramow, qm paramqm, Object paramObject, String paramString)
    throws IOException, oz
  {
    if ((this.k != null) && (this.k.contains(paramString)))
    {
      paramow.d();
      return;
    }
    if (this.j != null) {
      try
      {
        this.j.a(paramow, paramqm, paramObject, paramString);
        return;
      }
      catch (Exception paramow)
      {
        a(paramow, paramObject, paramString, paramqm);
        return;
      }
    }
    a(paramow, paramqm, paramObject, paramString);
  }
  
  public qu<Object> a()
  {
    if (getClass() != sp.class) {
      return this;
    }
    return new sp(this, true);
  }
  
  protected sw a(qk paramqk, sw paramsw)
  {
    String str = paramsw.e();
    if (str == null) {
      return paramsw;
    }
    paramqk = paramsw.h();
    boolean bool = false;
    if ((paramqk instanceof sp)) {
      paramqk = ((sp)paramqk).a(str);
    }
    while (paramqk == null)
    {
      throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': no back reference property found from type " + paramsw.a());
      if ((paramqk instanceof ug))
      {
        paramqk = ((ug)paramqk).d();
        if (!(paramqk instanceof sp)) {
          throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': value deserializer is of type ContainerDeserializerBase, but content type is not handled by a BeanDeserializer " + " (instead it's of type " + paramqk.getClass().getName() + ")");
        }
        paramqk = ((sp)paramqk).a(str);
        bool = true;
      }
      else
      {
        if ((paramqk instanceof sm)) {
          throw new IllegalArgumentException("Can not handle managed/back reference for abstract types (property " + this.b.p().getName() + "." + paramsw.c() + ")");
        }
        throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': type for value deserializer is not BeanDeserializer or ContainerDeserializerBase, but " + paramqk.getClass().getName());
      }
    }
    afm localafm1 = this.b;
    afm localafm2 = paramqk.a();
    if (!localafm2.p().isAssignableFrom(localafm1.p())) {
      throw new IllegalArgumentException("Can not handle managed/back reference '" + str + "': back reference type (" + localafm2.p().getName() + ") not compatible with managed type (" + localafm1.p().getName() + ")");
    }
    return new sz(str, paramsw, paramqk, this.a.f(), bool);
  }
  
  public sw a(String paramString)
  {
    if (this.m == null) {
      return null;
    }
    return (sw)this.m.get(paramString);
  }
  
  public final Object a(ow paramow, qm paramqm)
    throws IOException, oz
  {
    pb localpb = paramow.e();
    if (localpb == pb.b)
    {
      paramow.b();
      return b(paramow, paramqm);
    }
    switch (sq.a[localpb.ordinal()])
    {
    default: 
      throw paramqm.b(d());
    case 1: 
      return d(paramow, paramqm);
    case 2: 
      return e(paramow, paramqm);
    case 3: 
      return f(paramow, paramqm);
    case 4: 
      return paramow.z();
    case 5: 
    case 6: 
      return g(paramow, paramqm);
    case 7: 
      return h(paramow, paramqm);
    }
    return b(paramow, paramqm);
  }
  
  public Object a(ow paramow, qm paramqm, rw paramrw)
    throws IOException, oz
  {
    return paramrw.a(paramow, paramqm);
  }
  
  public Object a(ow paramow, qm paramqm, Object paramObject)
    throws IOException, oz
  {
    if (this.i != null) {
      a(paramqm, paramObject);
    }
    if (this.o != null) {
      localObject2 = b(paramow, paramqm, paramObject);
    }
    do
    {
      return localObject2;
      if (this.p != null) {
        return c(paramow, paramqm, paramObject);
      }
      localObject2 = paramow.e();
      localObject1 = localObject2;
      if (localObject2 == pb.b) {
        localObject1 = paramow.b();
      }
      localObject2 = paramObject;
    } while (localObject1 != pb.f);
    Object localObject1 = paramow.g();
    paramow.b();
    Object localObject2 = this.h.a((String)localObject1);
    if (localObject2 != null) {}
    for (;;)
    {
      try
      {
        ((sw)localObject2).a(paramow, paramqm, paramObject);
        localObject1 = paramow.b();
      }
      catch (Exception localException)
      {
        a(localException, paramObject, (String)localObject1, paramqm);
        continue;
      }
      if ((this.k != null) && (this.k.contains(localObject1))) {
        paramow.d();
      } else if (this.j != null) {
        this.j.a(paramow, paramqm, paramObject, (String)localObject1);
      } else {
        a(paramow, paramqm, paramObject, (String)localObject1);
      }
    }
  }
  
  protected Object a(ow paramow, qm paramqm, Object paramObject, afz paramafz)
    throws IOException, oz
  {
    qu localqu = b(paramqm, paramObject, paramafz);
    if (localqu != null)
    {
      if (paramafz == null) {
        break label105;
      }
      paramafz.e();
      paramafz = paramafz.h();
      paramafz.b();
    }
    label105:
    for (paramafz = localqu.a(paramafz, paramqm, paramObject);; paramafz = (afz)paramObject)
    {
      paramObject = paramafz;
      if (paramow != null) {
        paramObject = localqu.a(paramow, paramqm, paramafz);
      }
      return paramObject;
      if (paramafz != null) {}
      for (paramafz = a(paramqm, paramObject, paramafz);; paramafz = (afz)paramObject)
      {
        paramObject = paramafz;
        if (paramow == null) {
          break;
        }
        return a(paramow, paramqm, paramafz);
      }
    }
  }
  
  protected Object a(qm paramqm, Object paramObject, afz paramafz)
    throws IOException, oz
  {
    paramafz.e();
    paramafz = paramafz.h();
    while (paramafz.b() != pb.c)
    {
      String str = paramafz.g();
      paramafz.b();
      a(paramafz, paramqm, paramObject, str);
    }
    return paramObject;
  }
  
  protected void a(ow paramow, qm paramqm, Object paramObject, String paramString)
    throws IOException, oz
  {
    if ((this.l) || ((this.k != null) && (this.k.contains(paramString))))
    {
      paramow.d();
      return;
    }
    super.a(paramow, paramqm, paramObject, paramString);
  }
  
  public void a(qk paramqk, qq paramqq)
    throws qw
  {
    Iterator localIterator = this.h.c();
    tp localtp = null;
    Object localObject1 = null;
    Object localObject4;
    if (localIterator.hasNext())
    {
      localObject4 = (sw)localIterator.next();
      if (((sw)localObject4).f()) {
        break label510;
      }
    }
    label510:
    for (Object localObject2 = ((sw)localObject4).a(a(paramqk, paramqq, ((sw)localObject4).a(), (qc)localObject4));; localObject2 = localObject4)
    {
      localObject2 = a(paramqk, (sw)localObject2);
      Object localObject3 = b(paramqk, (sw)localObject2);
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new tx();
        }
        ((tx)localObject2).a((sw)localObject3);
      }
      for (localObject1 = localObject3;; localObject1 = localObject3)
      {
        localObject3 = c(paramqk, (sw)localObject1);
        if (localObject3 != localObject4) {
          this.h.a((sw)localObject3);
        }
        localObject1 = localObject2;
        if (!((sw)localObject3).g()) {
          break;
        }
        localObject4 = ((sw)localObject3).i();
        localObject1 = localObject2;
        if (((rw)localObject4).a() != JsonTypeInfo.As.EXTERNAL_PROPERTY) {
          break;
        }
        if (localtp == null) {
          localtp = new tp();
        }
        for (;;)
        {
          localtp.a((sw)localObject3, ((rw)localObject4).b());
          this.h.b((sw)localObject3);
          localObject1 = localObject2;
          break;
          if ((this.j != null) && (!this.j.b())) {
            this.j = this.j.a(a(paramqk, paramqq, this.j.c(), this.j.a()));
          }
          if (this.d.i())
          {
            localObject2 = this.d.l();
            if (localObject2 == null) {
              throw new IllegalArgumentException("Invalid delegate-creator definition for " + this.b + ": value instantiator (" + this.d.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
            }
            localObject3 = this.d.o();
            this.e = a(paramqk, paramqq, (afm)localObject2, new qd(null, (afm)localObject2, this.a.f(), (xk)localObject3));
          }
          if (this.f != null)
          {
            localObject2 = this.f.a().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (sw)((Iterator)localObject2).next();
              if (!((sw)localObject3).f()) {
                this.f.a((sw)localObject3, a(paramqk, paramqq, ((sw)localObject3).a(), (qc)localObject3));
              }
            }
          }
          if (localtp != null)
          {
            this.p = localtp.a();
            this.g = true;
          }
          this.o = ((tx)localObject1);
          if (localObject1 != null) {
            this.g = true;
          }
          return;
        }
        localObject3 = localObject2;
        localObject2 = localObject1;
      }
    }
  }
  
  protected void a(qm paramqm, Object paramObject)
    throws IOException, oz
  {
    ty[] arrayOfty = this.i;
    int i2 = arrayOfty.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfty[i1].b(paramqm, paramObject);
      i1 += 1;
    }
  }
  
  protected void a(Throwable paramThrowable, qm paramqm)
    throws IOException
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if ((paramqm == null) || (paramqm.a(ql.n))) {}
    for (int i1 = 1; (paramThrowable instanceof IOException); i1 = 0) {
      throw ((IOException)paramThrowable);
    }
    if ((i1 == 0) && ((paramThrowable instanceof RuntimeException))) {
      throw ((RuntimeException)paramThrowable);
    }
    throw paramqm.a(this.b.p(), paramThrowable);
  }
  
  public void a(Throwable paramThrowable, Object paramObject, String paramString, qm paramqm)
    throws IOException
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if ((paramqm == null) || (paramqm.a(ql.n))) {}
    for (int i1 = 1; (paramThrowable instanceof IOException); i1 = 0)
    {
      if ((i1 != 0) && ((paramThrowable instanceof qw))) {
        break label100;
      }
      throw ((IOException)paramThrowable);
    }
    if ((i1 == 0) && ((paramThrowable instanceof RuntimeException))) {
      throw ((RuntimeException)paramThrowable);
    }
    label100:
    throw qw.a(paramThrowable, paramObject, paramString);
  }
  
  protected qu<Object> b(qm paramqm, Object paramObject, afz paramafz)
    throws IOException, oz
  {
    try
    {
      if (this.n == null) {}
      for (paramafz = null;; paramafz = (qu)this.n.get(new adb(paramObject.getClass())))
      {
        if (paramafz == null) {
          break;
        }
        return paramafz;
      }
      localqq = paramqm.b();
    }
    finally {}
    qq localqq;
    if (localqq != null)
    {
      paramafz = paramqm.a(paramObject.getClass());
      paramqm = localqq.a(paramqm.a(), paramafz, this.c);
      paramafz = paramqm;
      if (paramqm != null) {
        try
        {
          if (this.n == null) {
            this.n = new HashMap();
          }
          this.n.put(new adb(paramObject.getClass()), paramqm);
          return paramqm;
        }
        finally {}
      }
    }
    return paramafz;
  }
  
  protected sw b(qk paramqk, sw paramsw)
  {
    Object localObject = paramsw.b();
    if ((localObject != null) && (paramqk.a().b((xk)localObject) == Boolean.TRUE))
    {
      paramqk = paramsw.h();
      localObject = paramqk.a();
      if ((localObject != paramqk) && (localObject != null)) {
        return paramsw.a((qu)localObject);
      }
    }
    return null;
  }
  
  public Object b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (this.g) {
      if (this.o != null) {
        localObject1 = j(paramow, paramqm);
      }
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (this.p != null) {
        return l(paramow, paramqm);
      }
      return c(paramow, paramqm);
      localObject2 = this.d.m();
      if (this.i != null) {
        a(paramqm, localObject2);
      }
      localObject1 = localObject2;
    } while (paramow.e() == pb.c);
    Object localObject1 = paramow.g();
    paramow.b();
    sw localsw = this.h.a((String)localObject1);
    if (localsw != null) {}
    for (;;)
    {
      try
      {
        localsw.a(paramow, paramqm, localObject2);
        paramow.b();
      }
      catch (Exception localException)
      {
        a(localException, localObject2, (String)localObject1, paramqm);
        continue;
      }
      b(paramow, paramqm, localObject2, (String)localObject1);
    }
  }
  
  protected Object b(ow paramow, qm paramqm, Object paramObject)
    throws IOException, oz
  {
    Object localObject2 = paramow.e();
    Object localObject1 = localObject2;
    if (localObject2 == pb.b) {
      localObject1 = paramow.b();
    }
    localObject2 = new afz(paramow.a());
    ((afz)localObject2).d();
    if (localObject1 == pb.f)
    {
      localObject1 = paramow.g();
      sw localsw = this.h.a((String)localObject1);
      paramow.b();
      if (localsw != null) {}
      for (;;)
      {
        try
        {
          localsw.a(paramow, paramqm, paramObject);
          localObject1 = paramow.b();
        }
        catch (Exception localException)
        {
          a(localException, paramObject, (String)localObject1, paramqm);
          continue;
        }
        if ((this.k != null) && (this.k.contains(localObject1)))
        {
          paramow.d();
        }
        else
        {
          ((afz)localObject2).a((String)localObject1);
          ((afz)localObject2).c(paramow);
          if (this.j != null) {
            this.j.a(paramow, paramqm, paramObject, (String)localObject1);
          }
        }
      }
    }
    ((afz)localObject2).e();
    this.o.a(paramow, paramqm, paramObject, (afz)localObject2);
    return paramObject;
  }
  
  protected sw c(qk paramqk, sw paramsw)
  {
    Object localObject2 = paramsw.h();
    Object localObject1 = paramsw;
    Object localObject3;
    int i2;
    int i1;
    if ((localObject2 instanceof sp))
    {
      localObject1 = paramsw;
      if (!((sp)localObject2).e().h())
      {
        localObject3 = paramsw.a().p();
        localObject2 = adz.b((Class)localObject3);
        localObject1 = paramsw;
        if (localObject2 != null)
        {
          localObject1 = paramsw;
          if (localObject2 == this.b.p())
          {
            localObject3 = ((Class)localObject3).getConstructors();
            i2 = localObject3.length;
            i1 = 0;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = paramsw;
      if (i1 < i2)
      {
        localObject1 = localObject3[i1];
        Class[] arrayOfClass = ((Constructor)localObject1).getParameterTypes();
        if ((arrayOfClass.length == 1) && (arrayOfClass[0] == localObject2))
        {
          if (paramqk.a(ql.f)) {
            adz.a((Member)localObject1);
          }
          localObject1 = new sy(paramsw, (Constructor)localObject1);
        }
      }
      else
      {
        return (sw)localObject1;
      }
      i1 += 1;
    }
  }
  
  protected Object c(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (this.e != null) {
      return this.d.a(this.e.a(paramow, paramqm));
    }
    if (this.f != null) {
      return i(paramow, paramqm);
    }
    if (this.b.c()) {
      throw qw.a(paramow, "Can not instantiate abstract type " + this.b + " (need to add/enable type information?)");
    }
    throw qw.a(paramow, "No suitable constructor found for type " + this.b + ": can not instantiate from JSON object (need to add/enable type information?)");
  }
  
  protected Object c(ow paramow, qm paramqm, Object paramObject)
    throws IOException, oz
  {
    to localto = this.p.a();
    if (paramow.e() != pb.c)
    {
      String str = paramow.g();
      paramow.b();
      sw localsw = this.h.a(str);
      if (localsw != null) {}
      for (;;)
      {
        try
        {
          localsw.a(paramow, paramqm, paramObject);
          paramow.b();
        }
        catch (Exception localException1)
        {
          a(localException1, paramObject, str, paramqm);
          continue;
        }
        if ((this.k != null) && (this.k.contains(str))) {
          paramow.d();
        } else if (!localto.a(paramow, paramqm, str, paramObject)) {
          if (this.j != null) {
            try
            {
              this.j.a(paramow, paramqm, paramObject, str);
            }
            catch (Exception localException2)
            {
              a(localException2, paramObject, str, paramqm);
            }
          } else {
            a(paramow, paramqm, paramObject, str);
          }
        }
      }
    }
    return localto.a(paramow, paramqm, paramObject);
  }
  
  public final Class<?> d()
  {
    return this.b.p();
  }
  
  public Object d(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if ((this.e != null) && (!this.d.c()))
    {
      paramow = this.d.a(this.e.a(paramow, paramqm));
      if (this.i != null) {
        a(paramqm, paramow);
      }
      return paramow;
    }
    return this.d.a(paramow.k());
  }
  
  public th e()
  {
    return this.d;
  }
  
  public Object e(ow paramow, qm paramqm)
    throws IOException, oz
  {
    Object localObject;
    switch (sq.b[paramow.q().ordinal()])
    {
    default: 
      if (this.e == null) {
        break label201;
      }
      localObject = this.d.a(this.e.a(paramow, paramqm));
      paramow = (ow)localObject;
      if (this.i != null)
      {
        a(paramqm, localObject);
        paramow = (ow)localObject;
      }
      break;
    }
    do
    {
      do
      {
        return paramow;
        if ((this.e == null) || (this.d.d())) {
          break;
        }
        localObject = this.d.a(this.e.a(paramow, paramqm));
        paramow = (ow)localObject;
      } while (this.i == null);
      a(paramqm, localObject);
      return localObject;
      return this.d.a(paramow.t());
      if ((this.e == null) || (this.d.d())) {
        break;
      }
      localObject = this.d.a(this.e.a(paramow, paramqm));
      paramow = (ow)localObject;
    } while (this.i == null);
    a(paramqm, localObject);
    return localObject;
    return this.d.a(paramow.u());
    label201:
    throw paramqm.a(d(), "no suitable creator method found to deserialize from JSON integer number");
  }
  
  public Object f(ow paramow, qm paramqm)
    throws IOException, oz
  {
    switch (sq.b[paramow.q().ordinal()])
    {
    default: 
      if (this.e != null) {
        paramow = this.d.a(this.e.a(paramow, paramqm));
      }
      break;
    case 3: 
    case 4: 
      Object localObject;
      do
      {
        return paramow;
        if ((this.e == null) || (this.d.f())) {
          break;
        }
        localObject = this.d.a(this.e.a(paramow, paramqm));
        paramow = (ow)localObject;
      } while (this.i == null);
      a(paramqm, localObject);
      return localObject;
      return this.d.a(paramow.x());
    }
    throw paramqm.a(d(), "no suitable creator method found to deserialize from JSON floating-point number");
  }
  
  public Object g(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if ((this.e != null) && (!this.d.g()))
    {
      paramow = this.d.a(this.e.a(paramow, paramqm));
      if (this.i != null) {
        a(paramqm, paramow);
      }
      return paramow;
    }
    if (paramow.e() == pb.k) {}
    for (boolean bool = true;; bool = false) {
      return this.d.a(bool);
    }
  }
  
  public Object h(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (this.e != null) {
      try
      {
        paramow = this.d.a(this.e.a(paramow, paramqm));
        if (this.i != null) {
          a(paramqm, paramow);
        }
        return paramow;
      }
      catch (Exception paramow)
      {
        a(paramow, paramqm);
      }
    }
    throw paramqm.b(d());
  }
  
  protected final Object i(ow paramow, qm paramqm)
    throws IOException, oz
  {
    tr localtr = this.f;
    tw localtw = localtr.a(paramow, paramqm);
    Object localObject2 = paramow.e();
    Object localObject1 = null;
    Object localObject4;
    Object localObject3;
    for (;;)
    {
      if (localObject2 == pb.f)
      {
        localObject4 = paramow.g();
        paramow.b();
        sw localsw = localtr.a((String)localObject4);
        if (localsw != null)
        {
          Object localObject5 = localsw.a(paramow, paramqm);
          localObject2 = localObject1;
          if (localtw.a(localsw.j(), localObject5))
          {
            paramow.b();
            try
            {
              localObject2 = localtr.a(localtw);
              if (localObject2.getClass() == this.b.p()) {
                break label159;
              }
              return a(paramow, paramqm, localObject2, (afz)localObject1);
            }
            catch (Exception localException)
            {
              a(localException, this.b.p(), (String)localObject4, paramqm);
              localObject3 = localObject1;
            }
          }
          else
          {
            localObject4 = paramow.b();
            localObject1 = localObject3;
            localObject3 = localObject4;
            continue;
          }
          label159:
          if (localObject1 == null) {
            break label369;
          }
        }
      }
    }
    label367:
    label369:
    for (localObject1 = a(paramqm, localObject3, (afz)localObject1);; localObject1 = localObject3)
    {
      return a(paramow, paramqm, localObject1);
      localObject3 = this.h.a((String)localObject4);
      if (localObject3 != null)
      {
        localtw.a((sw)localObject3, ((sw)localObject3).a(paramow, paramqm));
        localObject3 = localObject1;
        break;
      }
      if ((this.k != null) && (this.k.contains(localObject4)))
      {
        paramow.d();
        localObject3 = localObject1;
        break;
      }
      if (this.j != null)
      {
        localtw.a(this.j, (String)localObject4, this.j.a(paramow, paramqm));
        localObject3 = localObject1;
        break;
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new afz(paramow.a());
      }
      ((afz)localObject3).a((String)localObject4);
      ((afz)localObject3).c(paramow);
      break;
      try
      {
        paramow = localtr.a(localtw);
        if (localObject1 == null) {
          break label367;
        }
        if (paramow.getClass() != this.b.p()) {
          return a(null, paramqm, paramow, (afz)localObject1);
        }
      }
      catch (Exception paramow)
      {
        a(paramow, paramqm);
        return null;
      }
      return a(paramqm, paramow, (afz)localObject1);
      return paramow;
    }
  }
  
  protected Object j(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (this.e != null) {
      return this.d.a(this.e.a(paramow, paramqm));
    }
    if (this.f != null) {
      return k(paramow, paramqm);
    }
    afz localafz = new afz(paramow.a());
    localafz.d();
    Object localObject = this.d.m();
    if (this.i != null) {
      a(paramqm, localObject);
    }
    if (paramow.e() != pb.c)
    {
      String str = paramow.g();
      paramow.b();
      sw localsw = this.h.a(str);
      if (localsw != null) {}
      for (;;)
      {
        try
        {
          localsw.a(paramow, paramqm, localObject);
          paramow.b();
        }
        catch (Exception localException1)
        {
          a(localException1, localObject, str, paramqm);
          continue;
        }
        if ((this.k != null) && (this.k.contains(str)))
        {
          paramow.d();
        }
        else
        {
          localafz.a(str);
          localafz.c(paramow);
          if (this.j != null) {
            try
            {
              this.j.a(paramow, paramqm, localObject, str);
            }
            catch (Exception localException2)
            {
              a(localException2, localObject, str, paramqm);
            }
          }
        }
      }
    }
    localafz.e();
    this.o.a(paramow, paramqm, localObject, localafz);
    return localObject;
  }
  
  protected Object k(ow paramow, qm paramqm)
    throws IOException, oz
  {
    tr localtr = this.f;
    tw localtw = localtr.a(paramow, paramqm);
    afz localafz = new afz(paramow.a());
    localafz.d();
    Object localObject1 = paramow.e();
    Object localObject2;
    if (localObject1 == pb.f)
    {
      String str = paramow.g();
      paramow.b();
      localObject1 = localtr.a(str);
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = ((sw)localObject1).a(paramow, paramqm);
        if (localtw.a(((sw)localObject1).j(), localObject3))
        {
          localObject1 = paramow.b();
          try
          {
            localObject3 = localtr.a(localtw);
            while (localObject1 == pb.f)
            {
              paramow.b();
              localafz.c(paramow);
              localObject1 = paramow.b();
              continue;
              localObject2 = paramow.b();
            }
          }
          catch (Exception localException)
          {
            a(localException, this.b.p(), str, paramqm);
          }
        }
      }
      for (;;)
      {
        break;
        localafz.e();
        if (localObject3.getClass() != this.b.p()) {
          throw paramqm.b("Can not create polymorphic instances with unwrapped values");
        }
        return this.o.a(paramow, paramqm, localObject3, localafz);
        localObject2 = this.h.a(str);
        if (localObject2 != null)
        {
          localtw.a((sw)localObject2, ((sw)localObject2).a(paramow, paramqm));
        }
        else if ((this.k != null) && (this.k.contains(str)))
        {
          paramow.d();
        }
        else
        {
          localafz.a(str);
          localafz.c(paramow);
          if (this.j != null) {
            localtw.a(this.j, str, this.j.a(paramow, paramqm));
          }
        }
      }
    }
    try
    {
      localObject2 = localtr.a(localtw);
      return this.o.a(paramow, paramqm, localObject2, localafz);
    }
    catch (Exception paramow)
    {
      a(paramow, paramqm);
    }
    return null;
  }
  
  protected Object l(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (this.f != null) {
      return m(paramow, paramqm);
    }
    return c(paramow, paramqm, this.d.m());
  }
  
  protected Object m(ow paramow, qm paramqm)
    throws IOException, oz
  {
    to localto = this.p.a();
    tr localtr = this.f;
    tw localtw = localtr.a(paramow, paramqm);
    afz localafz = new afz(paramow.a());
    localafz.d();
    Object localObject1 = paramow.e();
    Object localObject2;
    if (localObject1 == pb.f)
    {
      String str = paramow.g();
      paramow.b();
      localObject1 = localtr.a(str);
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = ((sw)localObject1).a(paramow, paramqm);
        if (localtw.a(((sw)localObject1).j(), localObject3))
        {
          localObject1 = paramow.b();
          try
          {
            localObject3 = localtr.a(localtw);
            while (localObject1 == pb.f)
            {
              paramow.b();
              localafz.c(paramow);
              localObject1 = paramow.b();
              continue;
              localObject2 = paramow.b();
            }
          }
          catch (Exception localException)
          {
            a(localException, this.b.p(), str, paramqm);
          }
        }
      }
      for (;;)
      {
        break;
        if (localObject3.getClass() != this.b.p()) {
          throw paramqm.b("Can not create polymorphic instances with unwrapped values");
        }
        return localto.a(paramow, paramqm, localObject3);
        localObject2 = this.h.a(str);
        if (localObject2 != null) {
          localtw.a((sw)localObject2, ((sw)localObject2).a(paramow, paramqm));
        } else if (!localto.a(paramow, paramqm, str, null)) {
          if ((this.k != null) && (this.k.contains(str))) {
            paramow.d();
          } else if (this.j != null) {
            localtw.a(this.j, str, this.j.a(paramow, paramqm));
          }
        }
      }
    }
    try
    {
      localObject2 = localtr.a(localtw);
      return localto.a(paramow, paramqm, localObject2);
    }
    catch (Exception paramow)
    {
      a(paramow, paramqm);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/sp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */