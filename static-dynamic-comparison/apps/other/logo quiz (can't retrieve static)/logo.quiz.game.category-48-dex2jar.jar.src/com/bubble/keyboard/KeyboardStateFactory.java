package com.bubble.keyboard;

import android.content.Context;

public class KeyboardStateFactory
{
  static KeyboardState instance;
  
  public static KeyboardState getInstance(Context paramContext)
  {
    if (instance == null) {
      instance = new KeyboardState(paramContext);
    }
    return instance;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/keyboard/KeyboardStateFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */