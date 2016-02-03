package com.bluebird.mobile.tools.commonutils;

import java.util.Calendar;

public class TimeUtils
{
  public static boolean isEveningNow()
  {
    int i = Calendar.getInstance().get(11);
    return (18 < i) && (i < 22);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/commonutils/TimeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */