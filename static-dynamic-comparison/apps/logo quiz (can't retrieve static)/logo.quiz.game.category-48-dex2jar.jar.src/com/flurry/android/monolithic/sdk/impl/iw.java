package com.flurry.android.monolithic.sdk.impl;

import java.io.File;

public final class iw
{
  static String a = iw.class.getSimpleName();
  
  public static boolean a(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    paramFile = paramFile.getParentFile();
    if ((!paramFile.mkdirs()) && (!paramFile.exists()))
    {
      ja.a(6, a, "Unable to create persistent dir: " + paramFile);
      return false;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/iw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */