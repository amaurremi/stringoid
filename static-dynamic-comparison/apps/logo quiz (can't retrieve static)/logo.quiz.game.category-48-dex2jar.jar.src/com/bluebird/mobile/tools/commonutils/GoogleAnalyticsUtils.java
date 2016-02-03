package com.bluebird.mobile.tools.commonutils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class GoogleAnalyticsUtils
{
  public static String getAppUrl(String paramString1, String paramString2, String paramString3, Context paramContext)
  {
    paramContext = ApplicationUtils.getCurrentApplicationName(paramContext).replaceAll("'", "").replaceAll(" ", "_").replaceAll("\\?", "").replaceAll("!", "");
    return "market://details?id=" + paramString1 + "&referrer=utm_source%3D" + paramContext + "%26utm_medium%3D" + paramString2 + "%26utm_campaign%3D" + paramString3;
  }
  
  public static Intent getIntentToAppWithAnalytics(String paramString1, String paramString2, Context paramContext)
  {
    return getIntentToAppWithAnalytics(paramString1, paramString2, ApplicationUtils.getCurrentApplicationName(paramContext).replaceAll("'", "").replaceAll(" ", "_").replaceAll("\\?", "").replaceAll("!", ""), paramContext);
  }
  
  public static Intent getIntentToAppWithAnalytics(String paramString1, String paramString2, String paramString3, Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(getAppUrl(paramString1, paramString2, paramString3, paramContext)));
    return localIntent;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/commonutils/GoogleAnalyticsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */