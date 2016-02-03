package com.flurry.android.monolithic.sdk.impl;

import java.util.HashMap;

public final class aat
{
  private HashMap<aau, ra<Object>> a = new HashMap(64);
  private aas b = null;
  
  public aas a()
  {
    try
    {
      aas localaas2 = this.b;
      aas localaas1 = localaas2;
      if (localaas2 == null)
      {
        localaas1 = aas.a(this.a);
        this.b = localaas1;
      }
      return localaas1.a();
    }
    finally {}
  }
  
  public ra<Object> a(afm paramafm)
  {
    try
    {
      paramafm = (ra)this.a.get(new aau(paramafm, false));
      return paramafm;
    }
    finally {}
  }
  
  public ra<Object> a(Class<?> paramClass)
  {
    try
    {
      paramClass = (ra)this.a.get(new aau(paramClass, false));
      return paramClass;
    }
    finally {}
  }
  
  public void a(afm paramafm, ra<Object> paramra)
  {
    try
    {
      if (this.a.put(new aau(paramafm, true), paramra) == null) {
        this.b = null;
      }
      return;
    }
    finally {}
  }
  
  public void a(afm paramafm, ra<Object> paramra, ru paramru)
    throws qw
  {
    try
    {
      if (this.a.put(new aau(paramafm, false), paramra) == null) {
        this.b = null;
      }
      if ((paramra instanceof rp)) {
        ((rp)paramra).a(paramru);
      }
      return;
    }
    finally {}
  }
  
  public void a(Class<?> paramClass, ra<Object> paramra)
  {
    try
    {
      if (this.a.put(new aau(paramClass, true), paramra) == null) {
        this.b = null;
      }
      return;
    }
    finally {}
  }
  
  public void a(Class<?> paramClass, ra<Object> paramra, ru paramru)
    throws qw
  {
    try
    {
      if (this.a.put(new aau(paramClass, false), paramra) == null) {
        this.b = null;
      }
      if ((paramra instanceof rp)) {
        ((rp)paramra).a(paramru);
      }
      return;
    }
    finally {}
  }
  
  public ra<Object> b(afm paramafm)
  {
    try
    {
      paramafm = (ra)this.a.get(new aau(paramafm, true));
      return paramafm;
    }
    finally {}
  }
  
  public ra<Object> b(Class<?> paramClass)
  {
    try
    {
      paramClass = (ra)this.a.get(new aau(paramClass, true));
      return paramClass;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */