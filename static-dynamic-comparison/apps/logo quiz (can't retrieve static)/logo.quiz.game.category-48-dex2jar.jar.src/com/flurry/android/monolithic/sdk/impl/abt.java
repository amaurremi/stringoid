package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public abstract class abt<T>
  extends ra<T>
{
  protected final Class<T> k;
  
  protected abt(afm paramafm)
  {
    this.k = paramafm.p();
  }
  
  protected abt(Class<T> paramClass)
  {
    this.k = paramClass;
  }
  
  protected abt(Class<?> paramClass, boolean paramBoolean)
  {
    this.k = paramClass;
  }
  
  public void a(ru paramru, Throwable paramThrowable, Object paramObject, int paramInt)
    throws IOException
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if ((paramru == null) || (paramru.a(rr.n))) {}
    for (int i = 1; (paramThrowable instanceof IOException); i = 0)
    {
      if ((i != 0) && ((paramThrowable instanceof qw))) {
        break label98;
      }
      throw ((IOException)paramThrowable);
    }
    if ((i == 0) && ((paramThrowable instanceof RuntimeException))) {
      throw ((RuntimeException)paramThrowable);
    }
    label98:
    throw qw.a(paramThrowable, paramObject, paramInt);
  }
  
  public void a(ru paramru, Throwable paramThrowable, Object paramObject, String paramString)
    throws IOException
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if ((paramru == null) || (paramru.a(rr.n))) {}
    for (int i = 1; (paramThrowable instanceof IOException); i = 0)
    {
      if ((i != 0) && ((paramThrowable instanceof qw))) {
        break label98;
      }
      throw ((IOException)paramThrowable);
    }
    if ((i == 0) && ((paramThrowable instanceof RuntimeException))) {
      throw ((RuntimeException)paramThrowable);
    }
    label98:
    throw qw.a(paramThrowable, paramObject, paramString);
  }
  
  public abstract void a(T paramT, or paramor, ru paramru)
    throws IOException, oq;
  
  protected boolean a(ra<?> paramra)
  {
    return (paramra != null) && (paramra.getClass().getAnnotation(rz.class) != null);
  }
  
  public final Class<T> c()
  {
    return this.k;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/abt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */