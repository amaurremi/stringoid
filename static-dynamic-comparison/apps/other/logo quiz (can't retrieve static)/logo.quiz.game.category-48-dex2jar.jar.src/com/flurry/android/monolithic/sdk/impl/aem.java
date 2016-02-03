package com.flurry.android.monolithic.sdk.impl;

public class aem
{
  protected aef<adb, pw> a;
  
  public pw a(afm paramafm, rf<?> paramrf)
  {
    return a(paramafm.p(), paramrf);
  }
  
  public pw a(Class<?> paramClass, rf<?> paramrf)
  {
    for (;;)
    {
      try
      {
        adb localadb = new adb(paramClass);
        Object localObject;
        if (this.a == null)
        {
          this.a = new aef(20, 200);
          localObject = (xq)paramrf.c(paramClass);
          paramrf = paramrf.a().b(((xq)localObject).c());
          if (paramrf == null)
          {
            paramClass = paramClass.getSimpleName();
            paramClass = new pw(paramClass);
            this.a.put(localadb, paramClass);
            return paramClass;
          }
        }
        else
        {
          localObject = (pw)this.a.get(localadb);
          if (localObject == null) {
            continue;
          }
          paramClass = (Class<?>)localObject;
          continue;
        }
        paramClass = paramrf;
      }
      finally {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */