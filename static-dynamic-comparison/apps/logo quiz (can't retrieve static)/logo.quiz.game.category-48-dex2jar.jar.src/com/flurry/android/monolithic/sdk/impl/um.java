package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.ArrayList;

public abstract class um<T>
  extends wv<T>
{
  protected um(Class<?> paramClass)
  {
    super(paramClass);
  }
  
  public static Iterable<um<?>> d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new uv());
    localArrayList.add(new uu());
    localArrayList.add(new ut());
    localArrayList.add(new uo());
    localArrayList.add(new ur());
    localArrayList.add(new uq());
    localArrayList.add(new up());
    localArrayList.add(new us());
    localArrayList.add(new un());
    return localArrayList;
  }
  
  public final T a(ow paramow, qm paramqm)
    throws IOException, oz
  {
    Object localObject1 = null;
    if (paramow.e() == pb.h)
    {
      paramow = paramow.k().trim();
      if (paramow.length() == 0) {
        paramow = (ow)localObject1;
      }
    }
    do
    {
      for (;;)
      {
        return paramow;
        try
        {
          localObject1 = a(paramow, paramqm);
          paramow = (ow)localObject1;
          if (localObject1 != null) {}
        }
        catch (IllegalArgumentException paramow)
        {
          Object localObject2;
          for (;;) {}
        }
      }
      throw paramqm.b(this.q, "not a valid textual representation");
      if (paramow.e() != pb.g) {
        break;
      }
      localObject2 = paramow.z();
      paramow = (ow)localObject1;
    } while (localObject2 == null);
    if (this.q.isAssignableFrom(localObject2.getClass())) {
      return (T)localObject2;
    }
    return (T)a(localObject2, paramqm);
    throw paramqm.b(this.q);
  }
  
  protected T a(Object paramObject, qm paramqm)
    throws IOException, oz
  {
    throw paramqm.b("Don't know how to convert embedded Object of type " + paramObject.getClass().getName() + " into " + this.q.getName());
  }
  
  protected abstract T a(String paramString, qm paramqm)
    throws IOException, oz;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/um.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */