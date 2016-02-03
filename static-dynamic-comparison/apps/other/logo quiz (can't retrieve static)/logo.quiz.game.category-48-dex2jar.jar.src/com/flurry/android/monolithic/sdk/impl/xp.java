package com.flurry.android.monolithic.sdk.impl;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class xp
  implements ado
{
  protected HashMap<Class<? extends Annotation>, Annotation> a;
  
  public xp() {}
  
  private xp(HashMap<Class<? extends Annotation>, Annotation> paramHashMap)
  {
    this.a = paramHashMap;
  }
  
  public static xp a(xp paramxp1, xp paramxp2)
  {
    if ((paramxp1 == null) || (paramxp1.a == null) || (paramxp1.a.isEmpty())) {
      localObject = paramxp2;
    }
    do
    {
      do
      {
        do
        {
          return (xp)localObject;
          localObject = paramxp1;
        } while (paramxp2 == null);
        localObject = paramxp1;
      } while (paramxp2.a == null);
      localObject = paramxp1;
    } while (paramxp2.a.isEmpty());
    Object localObject = new HashMap();
    paramxp2 = paramxp2.a.values().iterator();
    while (paramxp2.hasNext())
    {
      Annotation localAnnotation = (Annotation)paramxp2.next();
      ((HashMap)localObject).put(localAnnotation.annotationType(), localAnnotation);
    }
    paramxp1 = paramxp1.a.values().iterator();
    while (paramxp1.hasNext())
    {
      paramxp2 = (Annotation)paramxp1.next();
      ((HashMap)localObject).put(paramxp2.annotationType(), paramxp2);
    }
    return new xp((HashMap)localObject);
  }
  
  public int a()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.size();
  }
  
  public <A extends Annotation> A a(Class<A> paramClass)
  {
    if (this.a == null) {
      return null;
    }
    return (Annotation)this.a.get(paramClass);
  }
  
  public void a(Annotation paramAnnotation)
  {
    if ((this.a == null) || (!this.a.containsKey(paramAnnotation.annotationType()))) {
      c(paramAnnotation);
    }
  }
  
  public void b(Annotation paramAnnotation)
  {
    c(paramAnnotation);
  }
  
  protected final void c(Annotation paramAnnotation)
  {
    if (this.a == null) {
      this.a = new HashMap();
    }
    this.a.put(paramAnnotation.annotationType(), paramAnnotation);
  }
  
  public String toString()
  {
    if (this.a == null) {
      return "[null]";
    }
    return this.a.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */