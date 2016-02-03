package com.mopub.mobileads;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.HttpResponses;
import com.mopub.mobileads.util.Json;
import com.mopub.mobileads.util.ResponseHeader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

abstract class AdLoadTask
{
  WeakReference<AdViewController> mWeakAdViewController;
  
  AdLoadTask(AdViewController paramAdViewController)
  {
    this.mWeakAdViewController = new WeakReference(paramAdViewController);
  }
  
  static AdLoadTask fromHttpResponse(HttpResponse paramHttpResponse, AdViewController paramAdViewController)
    throws IOException
  {
    return new TaskExtractor(paramHttpResponse, paramAdViewController).extract();
  }
  
  abstract void cleanup();
  
  abstract void execute();
  
  static class CustomEventAdLoadTask
    extends AdLoadTask
  {
    private Map<String, String> mParamsMap;
    
    public CustomEventAdLoadTask(AdViewController paramAdViewController, Map<String, String> paramMap)
    {
      super();
      this.mParamsMap = paramMap;
    }
    
    void cleanup()
    {
      this.mParamsMap = null;
    }
    
    void execute()
    {
      AdViewController localAdViewController = (AdViewController)this.mWeakAdViewController.get();
      if ((localAdViewController == null) || (localAdViewController.isDestroyed())) {
        return;
      }
      localAdViewController.setNotLoading();
      localAdViewController.getMoPubView().loadCustomEvent(this.mParamsMap);
    }
    
    @Deprecated
    Map<String, String> getParamsMap()
    {
      return this.mParamsMap;
    }
  }
  
  @Deprecated
  static class LegacyCustomEventAdLoadTask
    extends AdLoadTask
  {
    private Header mHeader;
    
    public LegacyCustomEventAdLoadTask(AdViewController paramAdViewController, Header paramHeader)
    {
      super();
      this.mHeader = paramHeader;
    }
    
    void cleanup()
    {
      this.mHeader = null;
    }
    
    void execute()
    {
      Object localObject = (AdViewController)this.mWeakAdViewController.get();
      if ((localObject == null) || (((AdViewController)localObject).isDestroyed())) {
        return;
      }
      ((AdViewController)localObject).setNotLoading();
      localObject = ((AdViewController)localObject).getMoPubView();
      if (this.mHeader == null)
      {
        Log.i("MoPub", "Couldn't call custom method because the server did not specify one.");
        ((MoPubView)localObject).loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
        return;
      }
      String str = this.mHeader.getValue();
      Log.i("MoPub", "Trying to call method named " + str);
      Activity localActivity = ((MoPubView)localObject).getActivity();
      try
      {
        localActivity.getClass().getMethod(str, new Class[] { MoPubView.class }).invoke(localActivity, new Object[] { localObject });
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.d("MoPub", "Couldn't perform custom method named " + str + "(MoPubView view) because your activity class has no such method");
        ((MoPubView)localObject).loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
        return;
      }
      catch (Exception localException)
      {
        Log.d("MoPub", "Couldn't perform custom method named " + str);
        ((MoPubView)localObject).loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
      }
    }
    
    @Deprecated
    Header getHeader()
    {
      return this.mHeader;
    }
  }
  
  private static class TaskExtractor
  {
    private String adType;
    private String adTypeCustomEventName;
    private final AdViewController adViewController;
    private String fullAdType;
    private final HttpResponse response;
    
    TaskExtractor(HttpResponse paramHttpResponse, AdViewController paramAdViewController)
    {
      this.response = paramHttpResponse;
      this.adViewController = paramAdViewController;
    }
    
    private AdLoadTask createCustomEventAdLoadTask(String paramString)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(ResponseHeader.CUSTOM_EVENT_NAME.getKey(), this.adTypeCustomEventName);
      if (paramString != null) {
        localHashMap.put(ResponseHeader.CUSTOM_EVENT_DATA.getKey(), paramString);
      }
      return new AdLoadTask.CustomEventAdLoadTask(this.adViewController, localHashMap);
    }
    
    private boolean eventDataIsInResponseBody(String paramString)
    {
      return ("mraid".equals(paramString)) || ("html".equals(paramString)) || (("interstitial".equals(paramString)) && ("vast".equals(this.fullAdType)));
    }
    
    private AdLoadTask extractCustomEventAdLoadTask()
    {
      Log.i("MoPub", "Performing custom event.");
      this.adTypeCustomEventName = HttpResponses.extractHeader(this.response, ResponseHeader.CUSTOM_EVENT_NAME);
      if (this.adTypeCustomEventName != null) {
        return createCustomEventAdLoadTask(HttpResponses.extractHeader(this.response, ResponseHeader.CUSTOM_EVENT_DATA));
      }
      Header localHeader = this.response.getFirstHeader(ResponseHeader.CUSTOM_SELECTOR.getKey());
      return new AdLoadTask.LegacyCustomEventAdLoadTask(this.adViewController, localHeader);
    }
    
    private AdLoadTask extractCustomEventAdLoadTaskFromNativeParams()
      throws IOException
    {
      return createCustomEventAdLoadTask(HttpResponses.extractHeader(this.response, ResponseHeader.NATIVE_PARAMS));
    }
    
    private AdLoadTask extractCustomEventAdLoadTaskFromResponseBody()
      throws IOException
    {
      Object localObject = this.response.getEntity();
      if (localObject != null) {}
      for (localObject = Strings.fromStream(((HttpEntity)localObject).getContent());; localObject = "")
      {
        this.adViewController.getAdConfiguration().setResponseString((String)localObject);
        String str1 = HttpResponses.extractHeader(this.response, ResponseHeader.REDIRECT_URL);
        String str2 = HttpResponses.extractHeader(this.response, ResponseHeader.CLICKTHROUGH_URL);
        boolean bool = HttpResponses.extractBooleanHeader(this.response, ResponseHeader.SCROLLABLE, false);
        HashMap localHashMap = new HashMap();
        localHashMap.put("Html-Response-Body", Uri.encode((String)localObject));
        localHashMap.put("Scrollable", Boolean.toString(bool));
        if (str1 != null) {
          localHashMap.put("Redirect-Url", str1);
        }
        if (str2 != null) {
          localHashMap.put("Clickthrough-Url", str2);
        }
        return createCustomEventAdLoadTask(Json.mapToJsonString(localHashMap));
      }
    }
    
    AdLoadTask extract()
      throws IOException
    {
      this.adType = HttpResponses.extractHeader(this.response, ResponseHeader.AD_TYPE);
      this.fullAdType = HttpResponses.extractHeader(this.response, ResponseHeader.FULL_AD_TYPE);
      Log.d("MoPub", "Loading ad type: " + AdTypeTranslator.getAdNetworkType(this.adType, this.fullAdType));
      this.adTypeCustomEventName = AdTypeTranslator.getCustomEventNameForAdType(this.adViewController.getMoPubView(), this.adType, this.fullAdType);
      if ("custom".equals(this.adType)) {
        return extractCustomEventAdLoadTask();
      }
      if (eventDataIsInResponseBody(this.adType)) {
        return extractCustomEventAdLoadTaskFromResponseBody();
      }
      return extractCustomEventAdLoadTaskFromNativeParams();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/AdLoadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */