package com.flurry.android;

import java.io.File;

final class bc
{
  private static String d = "FlurryAgent";
  
  static boolean b(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    paramFile = paramFile.getParentFile();
    if ((!paramFile.mkdirs()) && (!paramFile.exists()))
    {
      db.d(d, "Unable to create persistent dir: " + paramFile);
      return false;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */