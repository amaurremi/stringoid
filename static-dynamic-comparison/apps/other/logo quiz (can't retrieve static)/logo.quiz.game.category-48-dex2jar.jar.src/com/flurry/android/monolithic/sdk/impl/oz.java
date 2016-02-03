package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;

public class oz
  extends IOException
{
  protected ot a;
  
  protected oz(String paramString)
  {
    super(paramString);
  }
  
  protected oz(String paramString, ot paramot)
  {
    this(paramString, paramot, null);
  }
  
  protected oz(String paramString, ot paramot, Throwable paramThrowable)
  {
    super(paramString);
    if (paramThrowable != null) {
      initCause(paramThrowable);
    }
    this.a = paramot;
  }
  
  protected oz(String paramString, Throwable paramThrowable)
  {
    this(paramString, null, paramThrowable);
  }
  
  public ot a()
  {
    return this.a;
  }
  
  public String getMessage()
  {
    Object localObject2 = super.getMessage();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "N/A";
    }
    ot localot = a();
    localObject2 = localObject1;
    if (localot != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append('\n');
      ((StringBuilder)localObject2).append(" at ");
      ((StringBuilder)localObject2).append(localot.toString());
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return (String)localObject2;
  }
  
  public String toString()
  {
    return getClass().getName() + ": " + getMessage();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/oz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */