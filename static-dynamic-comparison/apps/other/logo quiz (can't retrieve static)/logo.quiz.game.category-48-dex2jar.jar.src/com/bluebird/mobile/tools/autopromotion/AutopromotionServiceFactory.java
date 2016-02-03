package com.bluebird.mobile.tools.autopromotion;

import android.content.Context;
import java.util.Arrays;

public class AutopromotionServiceFactory
{
  private static AutopromotionService instance;
  
  public static AutopromotionService getInstance(Application[] paramArrayOfApplication, Context paramContext)
  {
    if (instance == null) {
      instance = new AutopromotionServiceImpl(Arrays.asList(paramArrayOfApplication), paramContext.getApplicationContext());
    }
    return instance;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/autopromotion/AutopromotionServiceFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */