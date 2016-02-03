package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public abstract class qm
{
  protected final qk a;
  protected final int b;
  
  protected qm(qk paramqk)
  {
    this.a = paramqk;
    this.b = paramqk.i;
  }
  
  public afm a(Class<?> paramClass)
  {
    return this.a.b(paramClass);
  }
  
  public qk a()
  {
    return this.a;
  }
  
  public abstract qw a(afm paramafm, String paramString);
  
  public abstract qw a(ow paramow, pb parampb, String paramString);
  
  public abstract qw a(Class<?> paramClass, pb parampb);
  
  public abstract qw a(Class<?> paramClass, String paramString);
  
  public abstract qw a(Class<?> paramClass, String paramString1, String paramString2);
  
  public abstract qw a(Class<?> paramClass, Throwable paramThrowable);
  
  public abstract qw a(Object paramObject, String paramString);
  
  public abstract Object a(Object paramObject1, qc paramqc, Object paramObject2);
  
  public abstract Calendar a(Date paramDate);
  
  public abstract Date a(String paramString)
    throws IllegalArgumentException;
  
  public abstract void a(aeh paramaeh);
  
  public abstract boolean a(ow paramow, qu<?> paramqu, Object paramObject, String paramString)
    throws IOException, oz;
  
  public boolean a(ql paramql)
  {
    return (this.b & paramql.b()) != 0;
  }
  
  public qq b()
  {
    return null;
  }
  
  public abstract qw b(Class<?> paramClass);
  
  public abstract qw b(Class<?> paramClass, String paramString);
  
  public qw b(String paramString)
  {
    return qw.a(d(), paramString);
  }
  
  public on c()
  {
    return this.a.g();
  }
  
  public abstract qw c(Class<?> paramClass, String paramString);
  
  public abstract ow d();
  
  public final aez e()
  {
    return this.a.h();
  }
  
  public adk f()
  {
    return this.a.m();
  }
  
  public abstract aeh g();
  
  public abstract adp h();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/qm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */