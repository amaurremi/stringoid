package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.List;

@rz
public final class abh
  extends abu<List<String>>
  implements rp
{
  protected ra<String> a;
  
  public abh(qc paramqc)
  {
    super(List.class, paramqc);
  }
  
  private final void b(List<String> paramList, or paramor, ru paramru)
    throws IOException, oq
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      try
      {
        int k = paramList.size();
        if (i < k)
        {
          j = i;
          String str = (String)paramList.get(i);
          if (str == null)
          {
            j = i;
            paramru.a(paramor);
          }
          else
          {
            j = i;
            paramor.b(str);
          }
        }
      }
      catch (Exception paramor)
      {
        a(paramru, paramor, paramList, j);
      }
      return;
      i += 1;
    }
  }
  
  private final void c(List<String> paramList, or paramor, ru paramru)
    throws IOException, oq
  {
    int k = 0;
    int i = 0;
    int j = k;
    for (;;)
    {
      try
      {
        int m = paramList.size();
        j = k;
        ra localra = this.a;
        if (i < m)
        {
          j = i;
          String str = (String)paramList.get(i);
          if (str == null)
          {
            j = i;
            paramru.a(paramor);
          }
          else
          {
            j = i;
            localra.a(str, paramor, paramru);
          }
        }
      }
      catch (Exception paramor)
      {
        a(paramru, paramor, paramList, j);
      }
      return;
      i += 1;
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
  
  public void a(List<String> paramList, or paramor, ru paramru)
    throws IOException, oq
  {
    paramor.b();
    if (this.a == null) {
      b(paramList, paramor, paramru);
    }
    for (;;)
    {
      paramor.c();
      return;
      c(paramList, paramor, paramru);
    }
  }
  
  public void a(List<String> paramList, or paramor, ru paramru, rx paramrx)
    throws IOException, oq
  {
    paramrx.c(paramList, paramor);
    if (this.a == null) {
      b(paramList, paramor, paramru);
    }
    for (;;)
    {
      paramrx.f(paramList, paramor);
      return;
      c(paramList, paramor, paramru);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */