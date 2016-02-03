package com.flurry.android.monolithic.sdk.impl;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id;
import java.util.Collection;

public abstract interface yj<T extends yj<T>>
{
  public abstract rw a(qk paramqk, afm paramafm, Collection<yg> paramCollection, qc paramqc);
  
  public abstract rx a(rq paramrq, afm paramafm, Collection<yg> paramCollection, qc paramqc);
  
  public abstract T a(JsonTypeInfo.As paramAs);
  
  public abstract T a(JsonTypeInfo.Id paramId, yi paramyi);
  
  public abstract T a(Class<?> paramClass);
  
  public abstract T a(String paramString);
  
  public abstract Class<?> a();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/yj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */