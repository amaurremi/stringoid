package com.ideashower.readitlater.a;

import java.io.File;

public class j
{
  public static String a(boolean paramBoolean, String paramString)
  {
    return a(paramBoolean, true).concat(paramString);
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (String str1 = "file:///android_asset/assets-extra";; str1 = "/android_asset/assets-extra")
    {
      String str2 = str1;
      if (paramBoolean2) {
        str2 = str1.concat(File.separator);
      }
      return str2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */