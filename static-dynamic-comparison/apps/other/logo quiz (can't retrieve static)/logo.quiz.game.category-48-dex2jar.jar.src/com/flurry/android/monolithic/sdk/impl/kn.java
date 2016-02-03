package com.flurry.android.monolithic.sdk.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class kn<T extends lf>
{
  private static final ConcurrentMap<String, ConcurrentMap<Integer, Object>> a = new ConcurrentHashMap();
  private static final js[] b = new js[0];
  private final ji c;
  private final js[] d;
  private final boolean[] e;
  private final kq f;
  private lr g = null;
  private ll h = null;
  
  protected kn(ji paramji, kq paramkq)
  {
    this.c = paramji;
    this.f = paramkq;
    this.d = ((js[])paramji.b().toArray(b));
    this.e = new boolean[this.d.length];
  }
  
  protected static boolean b(js paramjs, Object paramObject)
  {
    if (paramObject != null) {
      return true;
    }
    paramjs = paramjs.c();
    paramObject = paramjs.a();
    if (paramObject == kj.n) {
      return true;
    }
    if (paramObject == kj.e)
    {
      paramjs = paramjs.k().iterator();
      while (paramjs.hasNext()) {
        if (((ji)paramjs.next()).a() == kj.n) {
          return true;
        }
      }
    }
    return false;
  }
  
  protected Object a(js paramjs)
    throws IOException
  {
    ou localou = paramjs.e();
    if (localou == null) {
      throw new jg("Field " + paramjs + " not set and has no default value");
    }
    if ((localou.g()) && ((paramjs.c().a() == kj.n) || ((paramjs.c().a() == kj.e) && (((ji)paramjs.c().k().get(0)).a() == kj.n)))) {
      return null;
    }
    Object localObject2 = (ConcurrentMap)a.get(this.c.g());
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      a.putIfAbsent(this.c.g(), new ConcurrentHashMap(this.d.length));
      localObject1 = (ConcurrentMap)a.get(this.c.g());
    }
    Object localObject3 = ((ConcurrentMap)localObject1).get(Integer.valueOf(paramjs.b()));
    localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = new ByteArrayOutputStream();
      this.g = md.a().a((OutputStream)localObject2, this.g);
      ml.a(this.g, paramjs.c(), localou);
      this.g.flush();
      this.h = ly.a().a(((ByteArrayOutputStream)localObject2).toByteArray(), this.h);
      localObject2 = this.f.a(paramjs.c()).a(null, this.h);
      ((ConcurrentMap)localObject1).putIfAbsent(Integer.valueOf(paramjs.b()), localObject2);
    }
    return this.f.b(paramjs.c(), localObject2);
  }
  
  protected void a(js paramjs, Object paramObject)
  {
    if (b(paramjs, paramObject)) {}
    while (paramjs.e() != null) {
      return;
    }
    throw new jg("Field " + paramjs + " does not accept null values");
  }
  
  protected final js[] b()
  {
    return this.d;
  }
  
  protected final boolean[] c()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (kn)paramObject;
        if (!Arrays.equals(this.e, ((kn)paramObject).e)) {
          return false;
        }
        if (this.c != null) {
          break;
        }
      } while (((kn)paramObject).c == null);
      return false;
    } while (this.c.equals(((kn)paramObject).c));
    return false;
  }
  
  public int hashCode()
  {
    int j = Arrays.hashCode(this.e);
    if (this.c == null) {}
    for (int i = 0;; i = this.c.hashCode()) {
      return i + (j + 31) * 31;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/kn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */