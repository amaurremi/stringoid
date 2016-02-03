package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
public final class acf
  extends abw<String[]>
  implements rp
{
  protected ra<Object> a;
  
  public acf(qc paramqc)
  {
    super(String[].class, null, paramqc);
  }
  
  private void a(String[] paramArrayOfString, or paramor, ru paramru, ra<Object> paramra)
    throws IOException, oq
  {
    int i = 0;
    int j = paramArrayOfString.length;
    if (i < j)
    {
      if (paramArrayOfString[i] == null) {
        paramru.a(paramor);
      }
      for (;;)
      {
        i += 1;
        break;
        paramra.a(paramArrayOfString[i], paramor, paramru);
      }
    }
  }
  
  public abc<?> a(rx paramrx)
  {
    return this;
  }
  
  public void a(ru paramru)
    throws qw
  {
    paramru = paramru.a(String.class, this.f);
    if ((paramru != null) && (paramru.getClass().getAnnotation(rz.class) == null)) {
      this.a = paramru;
    }
  }
  
  public void a(String[] paramArrayOfString, or paramor, ru paramru)
    throws IOException, oq
  {
    int j = paramArrayOfString.length;
    if (j == 0) {
      return;
    }
    if (this.a != null)
    {
      a(paramArrayOfString, paramor, paramru, this.a);
      return;
    }
    int i = 0;
    label32:
    if (i < j)
    {
      if (paramArrayOfString[i] != null) {
        break label59;
      }
      paramor.f();
    }
    for (;;)
    {
      i += 1;
      break label32;
      break;
      label59:
      paramor.b(paramArrayOfString[i]);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/acf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */