package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

@rz
public class abr
  extends zv<qy>
{
  public static final abr a = new abr();
  
  protected abr()
  {
    super(qy.class);
  }
  
  public void a(qy paramqy, or paramor, ru paramru)
    throws IOException, oq
  {
    paramqy.a(paramor, paramru);
  }
  
  public final void a(qy paramqy, or paramor, ru paramru, rx paramrx)
    throws IOException, oq
  {
    if ((paramqy instanceof qz))
    {
      ((qz)paramqy).a(paramor, paramru, paramrx);
      return;
    }
    a(paramqy, paramor, paramru);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */