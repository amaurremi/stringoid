package com.chartboost.sdk.impl;

import java.util.Iterator;
import java.util.List;

class ac
  extends ab
{
  private bi<ag> a = new bi();
  
  void a(Class paramClass, ag paramag)
  {
    this.a.a(paramClass, paramag);
  }
  
  public void a(Object paramObject, StringBuilder paramStringBuilder)
  {
    Object localObject2 = y.a(paramObject);
    if (localObject2 == null)
    {
      paramStringBuilder.append(" null ");
      return;
    }
    paramObject = null;
    Iterator localIterator = bi.a(localObject2.getClass()).iterator();
    while (localIterator.hasNext())
    {
      paramObject = (Class)localIterator.next();
      localObject1 = (ag)this.a.a(paramObject);
      paramObject = localObject1;
      if (localObject1 != null) {
        paramObject = localObject1;
      }
    }
    Object localObject1 = paramObject;
    if (paramObject == null)
    {
      localObject1 = paramObject;
      if (localObject2.getClass().isArray()) {
        localObject1 = (ag)this.a.a(Object[].class);
      }
    }
    if (localObject1 == null) {
      throw new RuntimeException("json can't serialize type : " + localObject2.getClass());
    }
    ((ag)localObject1).a(localObject2, paramStringBuilder);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */