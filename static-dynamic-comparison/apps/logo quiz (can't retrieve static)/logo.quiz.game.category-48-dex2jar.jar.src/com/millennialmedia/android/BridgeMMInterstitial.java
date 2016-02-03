package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class BridgeMMInterstitial
  extends MMJSObject
{
  private Intent getExpandExtrasIntent(String paramString, OverlaySettings paramOverlaySettings)
  {
    Intent localIntent = new Intent();
    if (paramString != null) {
      localIntent.setData(Uri.parse(paramString));
    }
    localIntent.putExtra("settings", paramOverlaySettings);
    localIntent.putExtra("internalId", paramOverlaySettings.creatorAdImplId);
    return localIntent;
  }
  
  private boolean isForcingOrientation(MMJSResponse paramMMJSResponse)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMMJSResponse.result == 1)
    {
      bool1 = bool2;
      if ((paramMMJSResponse.response instanceof String))
      {
        paramMMJSResponse = (String)paramMMJSResponse.response;
        if (!paramMMJSResponse.contains("portrait"))
        {
          bool1 = bool2;
          if (!paramMMJSResponse.contains("landscape")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private MMJSResponse setAllowOrientationChange(HashMap<String, String> paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("allowOrientationChange");
    if (paramHashMap != null)
    {
      AdViewOverlayActivity localAdViewOverlayActivity = getBaseActivity();
      if (localAdViewOverlayActivity != null)
      {
        localAdViewOverlayActivity.setAllowOrientationChange(Boolean.parseBoolean(paramHashMap));
        return MMJSResponse.responseWithSuccess();
      }
    }
    return null;
  }
  
  private MMJSResponse setForceOrientation(HashMap<String, String> paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("forceOrientation");
    if (!"none".equals(paramHashMap))
    {
      AdViewOverlayActivity localAdViewOverlayActivity = getBaseActivity();
      if (localAdViewOverlayActivity != null)
      {
        if ("portrait".equals(paramHashMap))
        {
          localAdViewOverlayActivity.setRequestedOrientationPortrait();
          return MMJSResponse.responseWithSuccess("portrait");
        }
        if ("landscape".equals(paramHashMap))
        {
          localAdViewOverlayActivity.setRequestedOrientationLandscape();
          return MMJSResponse.responseWithSuccess("landscape");
        }
      }
    }
    return null;
  }
  
  public MMJSResponse close(HashMap<String, String> paramHashMap)
  {
    paramHashMap = (MMWebView)this.mmWebViewRef.get();
    if (paramHashMap != null)
    {
      paramHashMap.getMMLayout().closeAreaTouched();
      return MMJSResponse.responseWithSuccess();
    }
    return null;
  }
  
  public MMJSResponse expandToExternalBrowser(HashMap<String, String> paramHashMap)
  {
    return open(paramHashMap);
  }
  
  public MMJSResponse expandWithProperties(HashMap<String, String> paramHashMap)
  {
    Object localObject = (String)paramHashMap.get("PROPERTY_BANNER_TYPE");
    if ((localObject != null) && (!Boolean.parseBoolean((String)localObject))) {
      return MMJSResponse.responseWithError("Cannot expand a non banner ad");
    }
    String str2 = (String)paramHashMap.get("url");
    localObject = (String)paramHashMap.get("transparent");
    String str7 = (String)paramHashMap.get("useCustomClose");
    String str8 = (String)paramHashMap.get("transition");
    String str1 = (String)paramHashMap.get("orientation");
    String str3 = (String)paramHashMap.get("transitionDuration");
    String str4 = (String)paramHashMap.get("height");
    String str5 = (String)paramHashMap.get("width");
    String str6 = (String)paramHashMap.get("modal");
    String str9 = (String)paramHashMap.get("PROPERTY_EXPANDING");
    String str10 = (String)paramHashMap.get("allowOrientationChange");
    Context localContext = (Context)this.contextRef.get();
    OverlaySettings localOverlaySettings;
    if (localContext != null)
    {
      localOverlaySettings = new OverlaySettings();
      if (str2 != null) {
        localOverlaySettings.urlToLoad = str2;
      }
      if (str9 != null) {
        localOverlaySettings.creatorAdImplId = ((int)Float.parseFloat(str9));
      }
      if (localObject != null) {
        localOverlaySettings.setIsTransparent(Boolean.parseBoolean((String)localObject));
      }
      if (str7 != null) {
        localOverlaySettings.setUseCustomClose(Boolean.parseBoolean(str7));
      }
      if (str8 != null) {
        localOverlaySettings.setTransition(str8);
      }
      if (str10 != null) {
        localOverlaySettings.allowOrientationChange = Boolean.parseBoolean(str10);
      }
      localObject = str1;
      if (str1 == null) {
        localObject = (String)paramHashMap.get("forceOrientation");
      }
      if (localObject != null) {
        localOverlaySettings.orientation = ((String)localObject);
      }
      if (str4 != null) {
        localOverlaySettings.height = ((int)Float.parseFloat(str4));
      }
      if (str5 != null) {
        localOverlaySettings.width = ((int)Float.parseFloat(str5));
      }
      if (str6 != null) {
        localOverlaySettings.modal = Boolean.parseBoolean(str6);
      }
      if (str3 == null) {}
    }
    try
    {
      localOverlaySettings.setTransitionDurationInMillis(Long.parseLong(str3) * 1000L);
      Utils.IntentUtils.startAdViewOverlayActivity(localContext, getExpandExtrasIntent(str2, localOverlaySettings));
      MMSDK.Event.overlayOpenedBroadCast(localContext, getAdImplId((String)paramHashMap.get("PROPERTY_EXPANDING")));
      return MMJSResponse.responseWithSuccess();
      return null;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public MMJSResponse open(HashMap<String, String> paramHashMap)
  {
    Object localObject = (String)paramHashMap.get("url");
    Context localContext = (Context)this.contextRef.get();
    if ((localObject != null) && (localContext != null))
    {
      localObject = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject));
      MMSDK.Event.intentStarted(localContext, "browser", getAdImplId((String)paramHashMap.get("PROPERTY_EXPANDING")));
      Utils.IntentUtils.startActivity(localContext, (Intent)localObject);
      return MMJSResponse.responseWithSuccess();
    }
    return null;
  }
  
  public MMJSResponse setOrientation(HashMap<String, String> paramHashMap)
  {
    MMJSResponse localMMJSResponse2 = setForceOrientation(paramHashMap);
    MMJSResponse localMMJSResponse1;
    if (localMMJSResponse2 != null)
    {
      localMMJSResponse1 = localMMJSResponse2;
      if (isForcingOrientation(localMMJSResponse2)) {}
    }
    else
    {
      localMMJSResponse1 = setAllowOrientationChange(paramHashMap);
    }
    return localMMJSResponse1;
  }
  
  public MMJSResponse show(HashMap<String, String> paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("url");
    Context localContext = (Context)this.contextRef.get();
    if ((paramHashMap != null) && (localContext != null))
    {
      Utils.IntentUtils.startAdViewOverlayActivityWithData(localContext, paramHashMap);
      return MMJSResponse.responseWithSuccess();
    }
    return null;
  }
  
  public MMJSResponse useCustomClose(HashMap<String, String> paramHashMap)
  {
    Object localObject = (MMWebView)this.mmWebViewRef.get();
    paramHashMap = (String)paramHashMap.get("useCustomClose");
    if ((paramHashMap != null) && (localObject != null))
    {
      localObject = ((MMWebView)localObject).getAdViewOverlayView();
      if (localObject != null)
      {
        ((AdViewOverlayView)localObject).setUseCustomClose(Boolean.parseBoolean(paramHashMap));
        return MMJSResponse.responseWithSuccess();
      }
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/BridgeMMInterstitial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */