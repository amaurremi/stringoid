package com.flurry.android.monolithic.sdk.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;

public abstract class xg
{
  public afm a(adj paramadj)
  {
    return paramadj.a(c());
  }
  
  public abstract <A extends Annotation> A a(Class<A> paramClass);
  
  public abstract AnnotatedElement a();
  
  public abstract String b();
  
  public final <A extends Annotation> boolean b(Class<A> paramClass)
  {
    return a(paramClass) != null;
  }
  
  public abstract Type c();
  
  public abstract Class<?> d();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/xg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */