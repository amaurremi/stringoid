package com.bluebird.mobile.tools.sound;

import android.content.Context;

public class SoundUtilsFactory
{
  private static SoundUtils instance;
  
  public static SoundUtils getInstance(Context paramContext)
  {
    if (instance == null) {
      instance = new SoundUtils(paramContext);
    }
    return instance;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/sound/SoundUtilsFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */