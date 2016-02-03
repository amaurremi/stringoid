package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

@rz
public class acv
  extends abu<Collection<String>>
  implements rp
{
  protected ra<String> a;
  
  public acv(qc paramqc)
  {
    super(Collection.class, paramqc);
  }
  
  private final void b(Collection<String> paramCollection, or paramor, ru paramru)
    throws IOException, oq
  {
    if (this.a != null) {
      c(paramCollection, paramor, paramru);
    }
    for (;;)
    {
      return;
      Iterator localIterator = paramCollection.iterator();
      int i = 0;
      label91:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str == null) {}
        try
        {
          paramru.a(paramor);
        }
        catch (Exception localException)
        {
          a(paramru, localException, paramCollection, i);
          break label91;
        }
        paramor.b(str);
        i += 1;
      }
    }
  }
  
  private void c(Collection<String> paramCollection, or paramor, ru paramru)
    throws IOException, oq
  {
    ra localra = this.a;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str == null) {
        try
        {
          paramru.a(paramor);
        }
        catch (Exception localException)
        {
          a(paramru, localException, paramCollection, 0);
        }
      } else {
        localra.a(localException, paramor, paramru);
      }
    }
  }
  
  public void a(ru paramru)
    throws qw
  {
    paramru = paramru.a(String.class, this.b);
    if (!a(paramru)) {
      this.a = paramru;
    }
  }
  
  public void a(Collection<String> paramCollection, or paramor, ru paramru)
    throws IOException, oq
  {
    paramor.b();
    if (this.a == null) {
      b(paramCollection, paramor, paramru);
    }
    for (;;)
    {
      paramor.c();
      return;
      c(paramCollection, paramor, paramru);
    }
  }
  
  public void a(Collection<String> paramCollection, or paramor, ru paramru, rx paramrx)
    throws IOException, oq
  {
    paramrx.c(paramCollection, paramor);
    if (this.a == null) {
      b(paramCollection, paramor, paramru);
    }
    for (;;)
    {
      paramrx.f(paramCollection, paramor);
      return;
      c(paramCollection, paramor, paramru);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/acv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */