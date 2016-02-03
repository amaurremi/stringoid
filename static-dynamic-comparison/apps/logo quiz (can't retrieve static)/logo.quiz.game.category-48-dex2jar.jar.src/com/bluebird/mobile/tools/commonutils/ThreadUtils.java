package com.bluebird.mobile.tools.commonutils;

public class ThreadUtils
{
  public static void sleep(long paramLong)
  {
    try
    {
      Thread.sleep(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/commonutils/ThreadUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */