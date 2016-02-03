package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Date;

public class acq
  extends abt<Object>
{
  static final acq a = new acq();
  
  public acq()
  {
    super(Object.class);
  }
  
  public void a(Object paramObject, or paramor, ru paramru)
    throws IOException, oq
  {
    if ((paramObject instanceof Date))
    {
      paramru.b((Date)paramObject, paramor);
      return;
    }
    paramor.a(paramObject.toString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/acq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */