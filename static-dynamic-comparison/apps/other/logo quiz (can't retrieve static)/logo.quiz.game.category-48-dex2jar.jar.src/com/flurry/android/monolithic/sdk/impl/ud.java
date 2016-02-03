package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@rz
public class ud
  extends wv<Calendar>
{
  protected final Class<? extends Calendar> a;
  
  public ud()
  {
    this(null);
  }
  
  public ud(Class<? extends Calendar> paramClass)
  {
    super(Calendar.class);
    this.a = paramClass;
  }
  
  public Calendar b(ow paramow, qm paramqm)
    throws IOException, oz
  {
    paramow = B(paramow, paramqm);
    if (paramow == null) {
      return null;
    }
    if (this.a == null) {
      return paramqm.a(paramow);
    }
    try
    {
      Calendar localCalendar = (Calendar)this.a.newInstance();
      localCalendar.setTimeInMillis(paramow.getTime());
      return localCalendar;
    }
    catch (Exception paramow)
    {
      throw paramqm.a(this.a, paramow);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */