package com.bluebird.mobile.tools.commonutils;

import android.content.Context;
import android.content.res.Resources;

public class ResourceUtils
{
  public static int getResourceId(String paramString1, String paramString2, Context paramContext)
  {
    return paramContext.getResources().getIdentifier(paramString1, paramString2, paramContext.getPackageName());
  }
  
  public static String getStringFromResources(String paramString, Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName());
    if (i != 0) {
      return paramContext.getString(i);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/commonutils/ResourceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */