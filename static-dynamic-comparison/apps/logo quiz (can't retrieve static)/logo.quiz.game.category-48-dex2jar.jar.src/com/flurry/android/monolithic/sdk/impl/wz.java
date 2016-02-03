package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.HashSet;

public class wz
  extends sp
{
  public wz(sp paramsp)
  {
    super(paramsp);
  }
  
  protected wz(sp paramsp, boolean paramBoolean)
  {
    super(paramsp, paramBoolean);
  }
  
  public qu<Object> a()
  {
    if (getClass() != wz.class) {
      return this;
    }
    return new wz(this, true);
  }
  
  public Object b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    int k = 0;
    if (this.f != null) {
      paramow = i(paramow, paramqm);
    }
    boolean bool1;
    int i;
    Object localObject2;
    Object localObject1;
    int j;
    do
    {
      return paramow;
      if (this.e != null) {
        return this.d.a(this.e.a(paramow, paramqm));
      }
      if (this.b.c()) {
        throw qw.a(paramow, "Can not instantiate abstract type " + this.b + " (need to add/enable type information?)");
      }
      bool1 = this.d.c();
      boolean bool2 = this.d.h();
      if ((!bool1) && (!bool2)) {
        throw new qw("Can not deserialize Throwable of type " + this.b + " without having a default contructor, a single-String-arg constructor; or explicit @JsonCreator");
      }
      i = 0;
      localObject2 = null;
      localObject1 = null;
      if (paramow.e() != pb.c)
      {
        Object localObject3 = paramow.g();
        sw localsw = this.h.a((String)localObject3);
        paramow.b();
        if (localsw != null) {
          if (localObject1 != null)
          {
            localsw.a(paramow, paramqm, localObject1);
            localObject3 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
        }
        for (;;)
        {
          paramow.b();
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
          break;
          localObject3 = localObject2;
          if (localObject2 == null)
          {
            j = this.h.b();
            localObject3 = new Object[j + j];
          }
          j = i + 1;
          localObject3[i] = localsw;
          i = j + 1;
          localObject3[j] = localsw.a(paramow, paramqm);
          localObject2 = localObject1;
          localObject1 = localObject3;
          continue;
          if (("message".equals(localObject3)) && (bool1))
          {
            localObject3 = this.d.a(paramow.k());
            localObject1 = localObject3;
            if (localObject2 != null)
            {
              j = 0;
              while (j < i)
              {
                ((sw)localObject2[j]).a(localObject3, localObject2[(j + 1)]);
                j += 2;
              }
              localObject2 = localObject3;
              localObject1 = null;
            }
          }
          else
          {
            if ((this.k != null) && (this.k.contains(localObject3)))
            {
              paramow.d();
              localObject3 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject3;
              continue;
            }
            if (this.j != null)
            {
              this.j.a(paramow, paramqm, localObject1, (String)localObject3);
              localObject3 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject3;
              continue;
            }
            a(paramow, paramqm, localObject1, (String)localObject3);
          }
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
      }
      paramow = (ow)localObject1;
    } while (localObject1 != null);
    if (bool1) {}
    for (paramqm = this.d.a(null);; paramqm = this.d.m())
    {
      paramow = paramqm;
      if (localObject2 == null) {
        break;
      }
      j = k;
      for (;;)
      {
        paramow = paramqm;
        if (j >= i) {
          break;
        }
        ((sw)localObject2[j]).a(paramqm, localObject2[(j + 1)]);
        j += 2;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/wz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */