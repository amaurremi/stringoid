package com.bluebird.mobile.tools.score;

import android.content.Context;

public class GroupServiceFactory
{
  private static GroupService instance;
  
  public static GroupService getInstance(Context paramContext)
  {
    if (instance == null) {
      instance = new GroupServiceImpl(paramContext);
    }
    return instance;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/score/GroupServiceFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */