package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public abstract class aaz
  extends abt<Object>
  implements rp
{
  protected static final zf[] a = new zf[0];
  protected final zf[] b;
  protected final zf[] c;
  protected final zc d;
  protected final Object e;
  
  protected aaz(aaz paramaaz)
  {
    this(paramaaz.k, paramaaz.b, paramaaz.c, paramaaz.d, paramaaz.e);
  }
  
  protected aaz(afm paramafm, zf[] paramArrayOfzf1, zf[] paramArrayOfzf2, zc paramzc, Object paramObject)
  {
    super(paramafm);
    this.b = paramArrayOfzf1;
    this.c = paramArrayOfzf2;
    this.d = paramzc;
    this.e = paramObject;
  }
  
  public aaz(Class<?> paramClass, zf[] paramArrayOfzf1, zf[] paramArrayOfzf2, zc paramzc, Object paramObject)
  {
    super(paramClass);
    this.b = paramArrayOfzf1;
    this.c = paramArrayOfzf2;
    this.d = paramzc;
    this.e = paramObject;
  }
  
  public void a(ru paramru)
    throws qw
  {
    int i;
    int j;
    label18:
    zf localzf;
    if (this.c == null)
    {
      i = 0;
      int k = this.b.length;
      j = 0;
      if (j >= k) {
        break label240;
      }
      localzf = this.b[j];
      if (!localzf.e()) {
        break label56;
      }
    }
    for (;;)
    {
      j += 1;
      break label18;
      i = this.c.length;
      break;
      label56:
      Object localObject1 = localzf.f();
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = paramru.a(localzf.g());
        localObject2 = localObject1;
        if (!((afm)localObject1).u())
        {
          if ((!((afm)localObject1).f()) && (((afm)localObject1).h() <= 0)) {
            continue;
          }
          localzf.a((afm)localObject1);
          continue;
        }
      }
      ra localra = paramru.a((afm)localObject2, localzf);
      localObject1 = localra;
      if (((afm)localObject2).f())
      {
        localObject2 = (rx)((afm)localObject2).g().o();
        localObject1 = localra;
        if (localObject2 != null)
        {
          localObject1 = localra;
          if ((localra instanceof abc)) {
            localObject1 = ((abc)localra).b((rx)localObject2);
          }
        }
      }
      localObject2 = localzf.a((ra)localObject1);
      this.b[j] = localObject2;
      if (j < i)
      {
        localObject2 = this.c[j];
        if (localObject2 != null) {
          this.c[j] = ((zf)localObject2).a((ra)localObject1);
        }
      }
    }
    label240:
    if (this.d != null) {
      this.d.a(paramru);
    }
  }
  
  public void a(Object paramObject, or paramor, ru paramru, rx paramrx)
    throws IOException, oq
  {
    paramrx.b(paramObject, paramor);
    if (this.e != null) {
      c(paramObject, paramor, paramru);
    }
    for (;;)
    {
      paramrx.e(paramObject, paramor);
      return;
      b(paramObject, paramor, paramru);
    }
  }
  
  protected ze b(ru paramru)
    throws qw
  {
    Object localObject = this.e;
    paramru = paramru.b();
    if (paramru == null) {
      throw new qw("Can not resolve BeanPropertyFilter with id '" + localObject + "'; no FilterProvider configured");
    }
    return paramru.a(localObject);
  }
  
  protected void b(Object paramObject, or paramor, ru paramru)
    throws IOException, oq
  {
    zf[] arrayOfzf;
    if ((this.c != null) && (paramru.a() != null)) {
      arrayOfzf = this.c;
    }
    int k;
    for (;;)
    {
      int j = 0;
      k = 0;
      int i = 0;
      try
      {
        int m = arrayOfzf.length;
        for (;;)
        {
          if (i < m)
          {
            zf localzf = arrayOfzf[i];
            if (localzf != null)
            {
              j = i;
              k = i;
              localzf.a(paramObject, paramor, paramru);
            }
            i += 1;
            continue;
            arrayOfzf = this.b;
            break;
          }
        }
        j = i;
        k = i;
        if (this.d != null)
        {
          j = i;
          k = i;
          this.d.a(paramObject, paramor, paramru);
        }
        return;
      }
      catch (Exception localException)
      {
        if (j == arrayOfzf.length) {}
        for (paramor = "[anySetter]";; paramor = arrayOfzf[j].d())
        {
          a(paramru, localException, paramObject, paramor);
          return;
        }
      }
      catch (StackOverflowError paramor)
      {
        paramru = new qw("Infinite recursion (StackOverflowError)");
        if (k != arrayOfzf.length) {}
      }
    }
    for (paramor = "[anySetter]";; paramor = arrayOfzf[k].d())
    {
      paramru.a(new qx(paramObject, paramor));
      throw paramru;
    }
  }
  
  protected void c(Object paramObject, or paramor, ru paramru)
    throws IOException, oq
  {
    zf[] arrayOfzf;
    ze localze;
    if ((this.c != null) && (paramru.a() != null))
    {
      arrayOfzf = this.c;
      localze = b(paramru);
      if (localze != null) {
        break label49;
      }
      b(paramObject, paramor, paramru);
    }
    for (;;)
    {
      return;
      arrayOfzf = this.b;
      break;
      label49:
      int j = 0;
      int k = 0;
      int i = 0;
      try
      {
        int m = arrayOfzf.length;
        if (i < m)
        {
          zf localzf = arrayOfzf[i];
          if (localzf != null)
          {
            j = i;
            k = i;
            localze.a(paramObject, paramor, paramru, localzf);
          }
        }
        else
        {
          j = i;
          k = i;
          if (this.d == null) {
            continue;
          }
          j = i;
          k = i;
          this.d.a(paramObject, paramor, paramru);
          return;
        }
      }
      catch (Exception localException)
      {
        if (j == arrayOfzf.length) {}
        for (paramor = "[anySetter]";; paramor = arrayOfzf[j].d())
        {
          a(paramru, localException, paramObject, paramor);
          return;
        }
      }
      catch (StackOverflowError paramor)
      {
        for (;;)
        {
          paramru = new qw("Infinite recursion (StackOverflowError)");
          if (k == arrayOfzf.length) {}
          for (paramor = "[anySetter]";; paramor = arrayOfzf[k].d())
          {
            paramru.a(new qx(paramObject, paramor));
            throw paramru;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */