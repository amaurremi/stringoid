package com.google.ads;

import android.net.Uri;
import android.webkit.WebView;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AdViewCommunicator
{
  private static final String AFMA_MESSAGE_HOST = "afma.google.com";
  private static final String JS_PROTOCOL_PREFIX = "javascript: ";
  public static final String JS_SEND_FUNCTION = "adsense.mobileads.afmanotify.receiveMessage";
  private static final String RESPONSE_SCHEME = "gmsg";
  private Map<String, AdResponse> mAdResponses = new HashMap();
  private GoogleAdView mView;
  
  public AdViewCommunicator(GoogleAdView paramGoogleAdView)
  {
    this.mView = paramGoogleAdView;
  }
  
  private static Map<String, String> generateParamMap(Uri paramUri)
  {
    if (paramUri == null) {
      paramUri = null;
    }
    HashMap localHashMap;
    String str1;
    do
    {
      return paramUri;
      localHashMap = new HashMap();
      str1 = paramUri.getEncodedQuery();
      paramUri = localHashMap;
    } while (str1 == null);
    paramUri = str1.split("&");
    int i = 0;
    while (i < paramUri.length)
    {
      int j = paramUri[i].indexOf('=');
      if (j == -1) {
        return null;
      }
      if (paramUri[i].indexOf('=', j + 1) != -1) {
        return null;
      }
      str1 = paramUri[i].substring(0, j);
      String str2 = paramUri[i].substring(j + 1);
      localHashMap.put(URLDecoder.decode(str1), URLDecoder.decode(str2));
      i += 1;
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public static boolean isMessage(Uri paramUri)
  {
    if ((paramUri == null) || (!paramUri.isHierarchical()) || (paramUri.getScheme() == null) || (!paramUri.getScheme().equals("gmsg"))) {}
    do
    {
      return false;
      paramUri = paramUri.getAuthority();
    } while ((paramUri == null) || (!paramUri.equals("afma.google.com")));
    return true;
  }
  
  public static void sendJavaScriptMessage(WebView paramWebView, JsMessageAction paramJsMessageAction, List<AdSpec.Parameter> paramList)
  {
    if ((paramList == null) || (paramWebView == null)) {
      throw new NullPointerException();
    }
    paramList = AdUtil.generateJSONParameters(paramList);
    paramJsMessageAction = "adsense.mobileads.afmanotify.receiveMessage(\"" + paramJsMessageAction.getMessageString() + "\", " + paramList + ");";
    paramWebView.loadUrl("javascript: " + paramJsMessageAction);
  }
  
  public AdResponse registerAdResponse(String paramString, AdResponse paramAdResponse)
  {
    return (AdResponse)this.mAdResponses.put(paramString, paramAdResponse);
  }
  
  public boolean testAndForwardMessage(Uri paramUri)
  {
    if (!isMessage(paramUri)) {
      throw new IllegalArgumentException("Invalid syntax in forwarded message: " + paramUri);
    }
    Object localObject = paramUri.getPath();
    localObject = (AdResponse)this.mAdResponses.get(localObject);
    if (localObject == null) {}
    do
    {
      return false;
      paramUri = generateParamMap(paramUri);
    } while (paramUri == null);
    ((AdResponse)localObject).run(paramUri, this.mView);
    return true;
  }
  
  public static enum JsMessageAction
  {
    JS_OUTSIDE_CLICK_MESSAGE("click_outside_ad"),  JS_REPORT_INSTALL_STATE("report_application_installation_state");
    
    private String mMessageString;
    
    private JsMessageAction(String paramString)
    {
      this.mMessageString = paramString;
    }
    
    public String getMessageString()
    {
      return this.mMessageString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/AdViewCommunicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */