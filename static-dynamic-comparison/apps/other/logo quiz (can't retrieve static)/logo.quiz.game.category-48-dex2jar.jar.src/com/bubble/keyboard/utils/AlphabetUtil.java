package com.bubble.keyboard.utils;

import java.util.Random;

public class AlphabetUtil
{
  static Random r = new Random();
  
  public static char getRandomLetter(String paramString)
  {
    return paramString.charAt(r.nextInt(paramString.length()));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/keyboard/utils/AlphabetUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */