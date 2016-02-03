package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.TimeZone;

public class us
  extends um<TimeZone>
{
  public us()
  {
    super(TimeZone.class);
  }
  
  protected TimeZone b(String paramString, qm paramqm)
    throws IOException
  {
    return TimeZone.getTimeZone(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/us.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */