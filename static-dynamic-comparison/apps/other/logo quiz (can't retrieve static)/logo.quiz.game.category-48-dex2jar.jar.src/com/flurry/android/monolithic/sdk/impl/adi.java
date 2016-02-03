package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public abstract class adi
  extends afm
  implements qz
{
  volatile String c;
  
  protected adi(Class<?> paramClass, int paramInt, Object paramObject1, Object paramObject2)
  {
    super(paramClass, paramInt);
    this.f = paramObject1;
    this.g = paramObject2;
  }
  
  protected abstract String a();
  
  public void a(or paramor, ru paramru)
    throws IOException, oz
  {
    paramor.b(m());
  }
  
  public void a(or paramor, ru paramru, rx paramrx)
    throws IOException, oz
  {
    paramrx.a(this, paramor);
    a(paramor, paramru);
    paramrx.d(this, paramor);
  }
  
  public String m()
  {
    String str2 = this.c;
    String str1 = str2;
    if (str2 == null) {
      str1 = a();
    }
    return str1;
  }
  
  public <T> T n()
  {
    return (T)this.f;
  }
  
  public <T> T o()
  {
    return (T)this.g;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/adi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */