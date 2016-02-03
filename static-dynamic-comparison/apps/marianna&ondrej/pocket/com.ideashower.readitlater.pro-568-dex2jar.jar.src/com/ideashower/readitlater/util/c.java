package com.ideashower.readitlater.util;

import android.annotation.TargetApi;
import android.webkit.WebSettings;

@TargetApi(16)
public class c
{
  public static void a(WebSettings paramWebSettings)
  {
    paramWebSettings.setAllowFileAccess(true);
    paramWebSettings.setAllowUniversalAccessFromFileURLs(true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/util/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */