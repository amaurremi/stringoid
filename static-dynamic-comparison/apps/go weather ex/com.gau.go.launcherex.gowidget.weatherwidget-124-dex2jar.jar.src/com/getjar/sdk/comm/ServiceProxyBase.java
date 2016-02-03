package com.getjar.sdk.comm;

import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.StringUtility;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public abstract class ServiceProxyBase
{
  public static final String USER_AGENT_HEADER = "User-Agent";
  
  private void mapWaitToCallbacks(final Operation paramOperation, final CallbackInterface paramCallbackInterface)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          paramOperation.mapResultToCallbacks(paramCallbackInterface);
          return;
        }
        catch (Exception localException)
        {
          Logger.e(Area.COMM.value(), localException, "Legacy Callback Mapping Thread failed", new Object[0]);
        }
      }
    }, "Legacy Callback Mapping Thread").start();
  }
  
  protected abstract Request.ServiceName getServiceName();
  
  protected Operation makeAsyncGETRequestForJson(String paramString1, Operation.Priority paramPriority, CommContext paramCommContext, String paramString2, Map<String, String> paramMap, CallbackInterface paramCallbackInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return makeAsyncGETRequestForJson(paramString1, paramPriority, paramCommContext, paramString2, paramMap, paramCallbackInterface, paramBoolean1, paramBoolean2, paramBoolean3, null);
  }
  
  protected Operation makeAsyncGETRequestForJson(String paramString1, Operation.Priority paramPriority, CommContext paramCommContext, String paramString2, Map<String, String> paramMap, CallbackInterface paramCallbackInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    if (paramPriority == null) {
      throw new IllegalArgumentException("'priority' can not be NULL");
    }
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' can not be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'urlStr' can not be NULL or empty");
    }
    try
    {
      paramString2 = new URI(paramString2);
      CommManager.initialize(paramCommContext.getApplicationContext());
      paramString1 = CommManager.getInstance().enqueueOperation(getServiceName(), paramString1, paramString2, Request.HttpMethod.GET, null, paramMap, paramPriority, paramCommContext, false, paramBoolean2, paramBoolean3, paramString3);
      StatisticsTracker.logRequest(paramString1);
      if (paramCallbackInterface != null) {
        mapWaitToCallbacks(paramString1, paramCallbackInterface);
      }
      return paramString1;
    }
    catch (URISyntaxException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
  }
  
  protected Operation makeAsyncPOSTRequestForJson(String paramString1, Operation.Priority paramPriority, CommContext paramCommContext, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, CallbackInterface paramCallbackInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return makeAsyncPOSTRequestForJson(paramString1, paramPriority, paramCommContext, paramString2, paramMap1, paramMap2, paramCallbackInterface, paramBoolean1, paramBoolean2, paramBoolean3, null);
  }
  
  protected Operation makeAsyncPOSTRequestForJson(String paramString1, Operation.Priority paramPriority, CommContext paramCommContext, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, CallbackInterface paramCallbackInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    if (paramPriority == null) {
      throw new IllegalArgumentException("'priority' can not be NULL");
    }
    if (paramCommContext == null) {
      throw new IllegalArgumentException("'commContext' can not be NULL");
    }
    if (StringUtility.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("'urlStr' can not be NULL or empty");
    }
    try
    {
      paramString2 = new URI(paramString2);
      CommManager.initialize(paramCommContext.getApplicationContext());
      paramString1 = CommManager.getInstance().enqueueOperation(getServiceName(), paramString1, paramString2, Request.HttpMethod.POST, paramMap1, paramMap2, paramPriority, paramCommContext, false, paramBoolean2, paramBoolean3, paramString3);
      StatisticsTracker.logRequest(paramString1);
      if (paramCallbackInterface != null) {
        mapWaitToCallbacks(paramString1, paramCallbackInterface);
      }
      return paramString1;
    }
    catch (URISyntaxException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/ServiceProxyBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */