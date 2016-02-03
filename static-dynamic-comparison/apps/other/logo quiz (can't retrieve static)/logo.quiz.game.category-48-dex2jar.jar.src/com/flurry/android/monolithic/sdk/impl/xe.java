package com.flurry.android.monolithic.sdk.impl;

public class xe
  extends qw
{
  protected final Class<?> c;
  protected final String d;
  
  public xe(String paramString1, ot paramot, Class<?> paramClass, String paramString2)
  {
    super(paramString1, paramot);
    this.c = paramClass;
    this.d = paramString2;
  }
  
  public static xe a(ow paramow, Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException();
    }
    if ((paramObject instanceof Class)) {}
    for (Class localClass = (Class)paramObject;; localClass = paramObject.getClass())
    {
      paramow = new xe("Unrecognized field \"" + paramString + "\" (Class " + localClass.getName() + "), not marked as ignorable", paramow.i(), localClass, paramString);
      paramow.a(paramObject, paramString);
      return paramow;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */