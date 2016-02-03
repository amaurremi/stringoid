package com.flurry.android.monolithic.sdk.impl;

final class zn
  extends zf
{
  protected final zf p;
  protected final Class<?>[] q;
  
  protected zn(zf paramzf, Class<?>[] paramArrayOfClass)
  {
    super(paramzf);
    this.p = paramzf;
    this.q = paramArrayOfClass;
  }
  
  public zf a(ra<Object> paramra)
  {
    return new zn(this.p.a(paramra), this.q);
  }
  
  public void a(Object paramObject, or paramor, ru paramru)
    throws Exception
  {
    Class localClass = paramru.a();
    if (localClass != null)
    {
      int i = 0;
      int j = this.q.length;
      for (;;)
      {
        if ((i >= j) || (this.q[i].isAssignableFrom(localClass)))
        {
          if (i != j) {
            break;
          }
          return;
        }
        i += 1;
      }
    }
    this.p.a(paramObject, paramor, paramru);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/zn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */