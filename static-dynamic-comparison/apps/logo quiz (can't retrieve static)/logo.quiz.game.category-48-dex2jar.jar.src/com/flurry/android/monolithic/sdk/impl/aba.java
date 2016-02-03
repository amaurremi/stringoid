package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Calendar;

@rz
public class aba
  extends abq<Calendar>
{
  public static aba a = new aba();
  
  public aba()
  {
    super(Calendar.class);
  }
  
  public void a(Calendar paramCalendar, or paramor, ru paramru)
    throws IOException, oq
  {
    paramru.a(paramCalendar.getTimeInMillis(), paramor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/aba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */