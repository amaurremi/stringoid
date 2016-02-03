package com.jumptap.adtag.actions;

import android.net.Uri;
import android.util.Log;

public class ActionFactory
{
  private static AdAction browserAction = new BrowserAdAction();
  private static AdAction callAction = new CallAdAction();
  private static AdAction mapAdAction = new MapAdAction();
  private static AdAction storeAdAction = new StoreAdAction();
  private static AdAction videoAdAction = new VideoAdAction();
  private static AdAction youTubeAdAction = new YouTubeAdAction();
  
  public static AdAction createAction(String paramString1, String paramString2)
  {
    Log.d("JtAd", "createAction from url:" + paramString1);
    String str = AdAction.getRedirectedUrl(paramString1, paramString2);
    Log.d("JtAd", "redirected Url:" + str);
    Object localObject1;
    if ((str != null) && (!"".equals(str))) {
      localObject1 = createActionByUri(Uri.parse(str));
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = Uri.parse(paramString1).getQueryParameter("t");
        Log.d("JtAd", "actionType= " + (String)localObject1);
        localObject2 = createActionByType((String)localObject1);
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = browserAction;
      }
      ((AdAction)localObject1).setUrl(paramString1);
      ((AdAction)localObject1).setRedirectedUrl(str);
      ((AdAction)localObject1).setUserAgent(paramString2);
      return (AdAction)localObject1;
      localObject1 = browserAction;
      str = paramString1;
    }
  }
  
  private static AdAction createActionByType(String paramString)
  {
    AdAction localAdAction = null;
    if ((paramString == null) || (paramString.equals("uri")) || (paramString.equals("url"))) {
      localAdAction = browserAction;
    }
    do
    {
      return localAdAction;
      if ((paramString.equals("call")) || (paramString.equals("tel"))) {
        return callAction;
      }
      if ((paramString.equals("video")) || (paramString.equals("movie"))) {
        return videoAdAction;
      }
      if (paramString.equals("youtube")) {
        return youTubeAdAction;
      }
      if ((paramString.equals("map")) || (paramString.equals("gmap"))) {
        return mapAdAction;
      }
    } while ((!paramString.equals("itunes")) && (!paramString.equals("store")));
    return storeAdAction;
  }
  
  private static AdAction createActionByUri(Uri paramUri)
  {
    Object localObject = null;
    String str2 = paramUri.getScheme();
    String str1 = paramUri.getHost();
    String str3 = paramUri.getPath();
    Log.d("JtAd", "Creating action from scheme:" + str2 + "  host: " + str1 + "   path:" + str3);
    if ("about".equals(str2)) {
      paramUri = browserAction;
    }
    do
    {
      do
      {
        do
        {
          return paramUri;
          if (("tel".equals(str2)) || ("sms".equals(str2))) {
            return callAction;
          }
          if ((str3 != null) && (!"".equals(str3)) && (isVideoExt(str3))) {
            return videoAdAction;
          }
          if ("maps.google.com".equals(str1)) {
            return mapAdAction;
          }
          paramUri = (Uri)localObject;
        } while (!"www.youtube.com".equals(str1));
        paramUri = (Uri)localObject;
      } while (str3 == null);
      paramUri = (Uri)localObject;
    } while (!"/watch".contains(str3));
    return youTubeAdAction;
  }
  
  private static boolean isVideoExt(String paramString)
  {
    return (paramString.endsWith(".mov")) || (paramString.endsWith(".avi")) || (paramString.endsWith(".mpg")) || (paramString.endsWith(".mpeg")) || (paramString.endsWith(".wmv")) || (paramString.endsWith(".wma")) || (paramString.endsWith(".mp4")) || (paramString.endsWith(".3pg"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/actions/ActionFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */