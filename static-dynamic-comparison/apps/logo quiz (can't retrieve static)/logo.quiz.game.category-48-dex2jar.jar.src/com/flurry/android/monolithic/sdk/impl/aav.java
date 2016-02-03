package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public class aav
  extends abt<Object>
{
  public aav()
  {
    super(Object.class);
  }
  
  protected void a(Object paramObject)
    throws qw
  {
    throw new qw("No serializer found for class " + paramObject.getClass().getName() + " and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS) )");
  }
  
  public void a(Object paramObject, or paramor, ru paramru)
    throws IOException, qw
  {
    if (paramru.a(rr.m)) {
      a(paramObject);
    }
    paramor.d();
    paramor.e();
  }
  
  public final void a(Object paramObject, or paramor, ru paramru, rx paramrx)
    throws IOException, oq
  {
    if (paramru.a(rr.m)) {
      a(paramObject);
    }
    paramrx.b(paramObject, paramor);
    paramrx.e(paramObject, paramor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */