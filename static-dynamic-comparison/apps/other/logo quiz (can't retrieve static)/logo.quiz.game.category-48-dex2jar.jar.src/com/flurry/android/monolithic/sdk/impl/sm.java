package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public class sm
  extends qu<Object>
{
  protected final afm a;
  protected final boolean b;
  protected final boolean c;
  protected final boolean d;
  protected final boolean e;
  
  public sm(afm paramafm)
  {
    this.a = paramafm;
    paramafm = paramafm.p();
    this.b = paramafm.isAssignableFrom(String.class);
    if ((paramafm == Boolean.TYPE) || (paramafm.isAssignableFrom(Boolean.class)))
    {
      bool1 = true;
      this.c = bool1;
      if ((paramafm != Integer.TYPE) && (!paramafm.isAssignableFrom(Integer.class))) {
        break label103;
      }
    }
    label103:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.d = bool1;
      if (paramafm != Double.TYPE)
      {
        bool1 = bool2;
        if (!paramafm.isAssignableFrom(Double.class)) {}
      }
      else
      {
        bool1 = true;
      }
      this.e = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public Object a(ow paramow, qm paramqm)
    throws IOException, oz
  {
    throw paramqm.a(this.a.p(), "abstract types can only be instantiated with additional type information");
  }
  
  public Object a(ow paramow, qm paramqm, rw paramrw)
    throws IOException, oz
  {
    Object localObject = b(paramow, paramqm);
    if (localObject != null) {
      return localObject;
    }
    return paramrw.a(paramow, paramqm);
  }
  
  protected Object b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    switch (sn.a[paramow.e().ordinal()])
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
            } while (!this.b);
            return paramow.k();
          } while (!this.d);
          return Integer.valueOf(paramow.t());
        } while (!this.e);
        return Double.valueOf(paramow.x());
      } while (!this.c);
      return Boolean.TRUE;
    } while (!this.c);
    return Boolean.FALSE;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/sm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */