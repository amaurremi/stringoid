package com.flurry.android.monolithic.sdk.impl;

import java.io.File;
import java.io.FilenameFilter;

final class iq
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith(".flurryagent.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/iq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */