package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class td
  extends qm
{
  protected ow c;
  protected final qq d;
  protected final qt e;
  protected adp f;
  protected aeh g;
  protected DateFormat h;
  
  public td(qk paramqk, ow paramow, qq paramqq, qt paramqt)
  {
    super(paramqk);
    this.c = paramow;
    this.d = paramqq;
    this.e = paramqt;
  }
  
  public qw a(afm paramafm, String paramString)
  {
    return qw.a(this.c, "Could not resolve type id '" + paramString + "' into a subtype of " + paramafm);
  }
  
  public qw a(ow paramow, pb parampb, String paramString)
  {
    return qw.a(paramow, "Unexpected token (" + paramow.e() + "), expected " + parampb + ": " + paramString);
  }
  
  public qw a(Class<?> paramClass, pb parampb)
  {
    paramClass = c(paramClass);
    return qw.a(this.c, "Can not deserialize instance of " + paramClass + " out of " + parampb + " token");
  }
  
  public qw a(Class<?> paramClass, String paramString)
  {
    return qw.a(this.c, "Can not construct instance of " + paramClass.getName() + ", problem: " + paramString);
  }
  
  public qw a(Class<?> paramClass, String paramString1, String paramString2)
  {
    return qw.a(this.c, "Can not construct Map key of type " + paramClass.getName() + " from String \"" + c(paramString1) + "\": " + paramString2);
  }
  
  public qw a(Class<?> paramClass, Throwable paramThrowable)
  {
    return qw.a(this.c, "Can not construct instance of " + paramClass.getName() + ", problem: " + paramThrowable.getMessage(), paramThrowable);
  }
  
  public qw a(Object paramObject, String paramString)
  {
    return xe.a(this.c, paramObject, paramString);
  }
  
  public Object a(Object paramObject1, qc paramqc, Object paramObject2)
  {
    if (this.e == null) {
      throw new IllegalStateException("No 'injectableValues' configured, can not inject value with id [" + paramObject1 + "]");
    }
    return this.e.a(paramObject1, this, paramqc, paramObject2);
  }
  
  public Calendar a(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar;
  }
  
  public Date a(String paramString)
    throws IllegalArgumentException
  {
    try
    {
      paramString = i().parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      throw new IllegalArgumentException(paramString.getMessage());
    }
  }
  
  public final void a(aeh paramaeh)
  {
    if ((this.g == null) || (paramaeh.b() >= this.g.b())) {
      this.g = paramaeh;
    }
  }
  
  public boolean a(ow paramow, qu<?> paramqu, Object paramObject, String paramString)
    throws IOException, oz
  {
    aeg localaeg = this.a.f();
    if (localaeg != null)
    {
      localow = this.c;
      this.c = paramow;
      paramow = localaeg;
    }
    for (;;)
    {
      if (paramow != null) {}
      try
      {
        boolean bool = ((qn)paramow.b()).a(this, paramqu, paramObject, paramString);
        if (bool) {
          return true;
        }
        paramow = paramow.a();
      }
      finally
      {
        this.c = localow;
      }
    }
    this.c = localow;
    return false;
  }
  
  public qq b()
  {
    return this.d;
  }
  
  public qw b(Class<?> paramClass)
  {
    return a(paramClass, this.c.e());
  }
  
  public qw b(Class<?> paramClass, String paramString)
  {
    return qw.a(this.c, "Can not construct instance of " + paramClass.getName() + " from String value '" + j() + "': " + paramString);
  }
  
  public qw c(Class<?> paramClass, String paramString)
  {
    return qw.a(this.c, "Can not construct instance of " + paramClass.getName() + " from number value (" + j() + "): " + paramString);
  }
  
  protected String c(Class<?> paramClass)
  {
    if (paramClass.isArray()) {
      return c(paramClass.getComponentType()) + "[]";
    }
    return paramClass.getName();
  }
  
  protected String c(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 500) {
      str = paramString.substring(0, 500) + "]...[" + paramString.substring(paramString.length() - 500);
    }
    return str;
  }
  
  public ow d()
  {
    return this.c;
  }
  
  public final aeh g()
  {
    aeh localaeh = this.g;
    if (localaeh == null) {
      return new aeh();
    }
    this.g = null;
    return localaeh;
  }
  
  public final adp h()
  {
    if (this.f == null) {
      this.f = new adp();
    }
    return this.f;
  }
  
  protected DateFormat i()
  {
    if (this.h == null) {
      this.h = ((DateFormat)this.a.n().clone());
    }
    return this.h;
  }
  
  protected String j()
  {
    try
    {
      String str = c(this.c.k());
      return str;
    }
    catch (Exception localException) {}
    return "[N/A]";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/td.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */