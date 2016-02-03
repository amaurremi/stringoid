package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.lang.reflect.Array;

@rz
public class vc
  extends ug<Object[]>
{
  protected final afm a;
  protected final boolean b;
  protected final Class<?> c;
  protected final qu<Object> d;
  protected final rw e;
  
  public vc(ada paramada, qu<Object> paramqu, rw paramrw)
  {
    super(Object[].class);
    this.a = paramada;
    this.c = paramada.g().p();
    if (this.c == Object.class) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      this.d = paramqu;
      this.e = paramrw;
      return;
    }
  }
  
  private final Object[] d(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if ((paramow.e() == pb.h) && (paramqm.a(ql.q)) && (paramow.k().length() == 0)) {
      return null;
    }
    if (!paramqm.a(ql.o))
    {
      if ((paramow.e() == pb.h) && (this.c == Byte.class)) {
        return c(paramow, paramqm);
      }
      throw paramqm.b(this.a.p());
    }
    if (paramow.e() == pb.m)
    {
      paramow = null;
      if (!this.b) {
        break label147;
      }
    }
    label147:
    for (paramqm = new Object[1];; paramqm = (Object[])Array.newInstance(this.c, 1))
    {
      paramqm[0] = paramow;
      return paramqm;
      if (this.e == null)
      {
        paramow = this.d.a(paramow, paramqm);
        break;
      }
      paramow = this.d.a(paramow, paramqm, this.e);
      break;
    }
  }
  
  public Object[] b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    if (!paramow.j()) {
      return d(paramow, paramqm);
    }
    aeh localaeh = paramqm.g();
    Object[] arrayOfObject = localaeh.a();
    rw localrw = this.e;
    int i = 0;
    Object localObject = paramow.b();
    if (localObject != pb.e) {
      if (localObject == pb.m)
      {
        localObject = null;
        label60:
        if (i < arrayOfObject.length) {
          break label170;
        }
        arrayOfObject = localaeh.a(arrayOfObject);
        i = 0;
      }
    }
    label170:
    for (;;)
    {
      int j = i + 1;
      arrayOfObject[i] = localObject;
      i = j;
      break;
      if (localrw == null)
      {
        localObject = this.d.a(paramow, paramqm);
        break label60;
      }
      localObject = this.d.a(paramow, paramqm, localrw);
      break label60;
      if (this.b) {}
      for (paramow = localaeh.a(arrayOfObject, i);; paramow = localaeh.a(arrayOfObject, i, this.c))
      {
        paramqm.a(localaeh);
        return paramow;
      }
    }
  }
  
  public Object[] b(ow paramow, qm paramqm, rw paramrw)
    throws IOException, oz
  {
    return (Object[])paramrw.b(paramow, paramqm);
  }
  
  protected Byte[] c(ow paramow, qm paramqm)
    throws IOException, oz
  {
    paramow = paramow.a(paramqm.c());
    paramqm = new Byte[paramow.length];
    int i = 0;
    int j = paramow.length;
    while (i < j)
    {
      paramqm[i] = Byte.valueOf(paramow[i]);
      i += 1;
    }
    return paramqm;
  }
  
  public qu<Object> d()
  {
    return this.d;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/vc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */