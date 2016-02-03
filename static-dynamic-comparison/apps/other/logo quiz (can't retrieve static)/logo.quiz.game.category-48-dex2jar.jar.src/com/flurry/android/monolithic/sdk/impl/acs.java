package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Calendar;

public class acs
  extends abt<Calendar>
{
  protected static final ra<?> a = new acs();
  
  public acs()
  {
    super(Calendar.class);
  }
  
  public void a(Calendar paramCalendar, or paramor, ru paramru)
    throws IOException, oq
  {
    paramru.b(paramCalendar.getTimeInMillis(), paramor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/acs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */