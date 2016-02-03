package com.adfonic.android.api.request.utils;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.Constructor;

public class UserAgentBuilder
{
  public static String getUserAgentString(Context paramContext)
  {
    try
    {
      Constructor localConstructor = WebSettings.class.getDeclaredConstructor(new Class[] { Context.class, WebView.class });
      localConstructor.setAccessible(true);
      try
      {
        String str = ((WebSettings)localConstructor.newInstance(new Object[] { paramContext, null })).getUserAgentString();
        return str;
      }
      finally
      {
        localConstructor.setAccessible(false);
      }
      return new WebView(paramContext).getSettings().getUserAgentString();
    }
    catch (Exception localException) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/adfonic/android/api/request/utils/UserAgentBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */