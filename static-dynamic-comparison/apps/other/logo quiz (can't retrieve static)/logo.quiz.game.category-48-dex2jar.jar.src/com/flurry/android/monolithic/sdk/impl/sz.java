package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class sz
  extends sw
{
  protected final String i;
  protected final boolean j;
  protected final sw k;
  protected final sw l;
  
  protected sz(sz paramsz, qu<Object> paramqu)
  {
    super(paramsz, paramqu);
    this.i = paramsz.i;
    this.j = paramsz.j;
    this.k = paramsz.k;
    this.l = paramsz.l;
  }
  
  public sz(String paramString, sw paramsw1, sw paramsw2, ado paramado, boolean paramBoolean)
  {
    super(paramsw1.c(), paramsw1.a(), paramsw1.e, paramado);
    this.i = paramString;
    this.k = paramsw1;
    this.l = paramsw2;
    this.j = paramBoolean;
  }
  
  public void a(ow paramow, qm paramqm, Object paramObject)
    throws IOException, oz
  {
    a(paramObject, this.k.a(paramow, paramqm));
  }
  
  public final void a(Object paramObject1, Object paramObject2)
    throws IOException
  {
    this.k.a(paramObject1, paramObject2);
    if (paramObject2 != null)
    {
      if (this.j)
      {
        Object localObject;
        if ((paramObject2 instanceof Object[]))
        {
          paramObject2 = (Object[])paramObject2;
          int n = paramObject2.length;
          int m = 0;
          while (m < n)
          {
            localObject = paramObject2[m];
            if (localObject != null) {
              this.l.a(localObject, paramObject1);
            }
            m += 1;
          }
        }
        if ((paramObject2 instanceof Collection))
        {
          paramObject2 = ((Collection)paramObject2).iterator();
          while (((Iterator)paramObject2).hasNext())
          {
            localObject = ((Iterator)paramObject2).next();
            if (localObject != null) {
              this.l.a(localObject, paramObject1);
            }
          }
        }
        if ((paramObject2 instanceof Map))
        {
          paramObject2 = ((Map)paramObject2).values().iterator();
          while (((Iterator)paramObject2).hasNext())
          {
            localObject = ((Iterator)paramObject2).next();
            if (localObject != null) {
              this.l.a(localObject, paramObject1);
            }
          }
        }
        throw new IllegalStateException("Unsupported container type (" + paramObject2.getClass().getName() + ") when resolving reference '" + this.i + "'");
      }
      this.l.a(paramObject2, paramObject1);
    }
  }
  
  public sz b(qu<Object> paramqu)
  {
    return new sz(this, paramqu);
  }
  
  public xk b()
  {
    return this.k.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/sz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */