package com.bubble.bugsense;

import android.content.Context;

public class BugSenseFactory
{
  private static BugSense instance;
  
  public static BugSense getInstance(Context paramContext)
  {
    if (instance == null) {
      instance = new BugSense(paramContext);
    }
    return instance;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/bugsense/BugSenseFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */