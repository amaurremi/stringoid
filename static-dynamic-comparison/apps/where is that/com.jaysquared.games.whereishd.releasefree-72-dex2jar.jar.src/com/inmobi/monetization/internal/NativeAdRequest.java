package com.inmobi.monetization.internal;

import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.bootstrapper.NativeConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.data.AppInfo;
import com.inmobi.commons.data.UserInfo;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.RequestBuilder;
import com.inmobi.commons.uid.UID;
import com.inmobi.commons.uid.UIDHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class NativeAdRequest
  extends RequestBuilder
{
  private String a;
  private String b = null;
  private String c = null;
  private String d = null;
  private HashMap<String, String> e = null;
  
  public NativeAdRequest(String paramString)
  {
    try
    {
      AppInfo.setAppId(paramString);
      this.a = paramString;
      return;
    }
    catch (Exception paramString)
    {
      Log.internal("[InMobi]-[Monetization]", "Failed to init Native Ad request", paramString);
    }
  }
  
  public String buildPostBody()
  {
    return super.buildPostBody();
  }
  
  protected String getAdFormatPostBody()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("format=native");
    localStringBuilder.append("&mk-ads=" + Initializer.getConfigParams().getNativeSdkConfigParams().getmFetchLimit());
    return localStringBuilder.toString();
  }
  
  public String getAppId()
  {
    return this.a;
  }
  
  protected String getPublisherPostBody()
  {
    Object localObject1 = new StringBuilder();
    if (this.e != null)
    {
      localObject2 = this.e.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append("&").append(getURLEncoded(((String)localEntry.getKey()).toString())).append("=").append(getURLEncoded(((String)localEntry.getValue()).toString()));
      }
    }
    if ((this.c != null) && (this.d != null)) {
      ((StringBuilder)localObject1).append("&").append(getURLEncoded(this.c)).append("=").append(getURLEncoded(this.d));
    }
    if (this.b != null)
    {
      ((StringBuilder)localObject1).append("&p-keywords=");
      ((StringBuilder)localObject1).append(getURLEncoded(this.b));
    }
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    try
    {
      if (((String)localObject2).charAt(0) == '&') {
        localObject1 = ((String)localObject2).substring(1);
      }
      return (String)localObject1;
    }
    catch (Exception localException)
    {
      Log.internal("[InMobi]-4.1.1", "Couldn't build post string in Request Builder", localException);
    }
    return (String)localObject2;
  }
  
  protected String getUidMapPostBody()
  {
    String str1 = null;
    Object localObject3 = new HashMap();
    try
    {
      localObject1 = AnalyticsInitializer.getConfigParams().getLTVId();
      if (localObject1 != null) {
        ((Map)localObject3).put("LTVID", localObject1 + "");
      }
      String str2 = Integer.toString(new Random().nextInt());
      localObject3 = Initializer.getConfigParams().getUID().getUidMap(UserInfo.getInstance().getDeviceIDMask(), str2, (Map)localObject3);
      StringBuilder localStringBuilder = new StringBuilder();
      localObject1 = str1;
      if (localObject3 != null)
      {
        localStringBuilder.append("u-id-map=");
        localStringBuilder.append(getURLEncoded((String)localObject3));
        localStringBuilder.append("&u-id-key=");
        localStringBuilder.append(str2);
        localStringBuilder.append("&u-key-ver=");
        localStringBuilder.append(UIDHelper.getRSAKeyVersion());
        str1 = localStringBuilder.toString();
        localObject1 = str1;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject1;
          if (str1.charAt(0) == '&') {
            localObject1 = str1.substring(1);
          }
          return (String)localObject1;
        }
        catch (Exception localException2)
        {
          Object localObject2;
          Log.internal("[InMobi]-4.1.1", "Couldn't build post string in Request Builder", localException2);
        }
        localException1 = localException1;
        Log.internal("[InMobi]-4.1.1", "LTVID not available yet in configs");
        localObject2 = null;
      }
    }
    return str1;
  }
  
  public void setKeywords(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString))) {
      this.b = paramString;
    }
  }
  
  public void setRefTagParam(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!"".equals(paramString1)) && (paramString2 != null) && (!"".equals(paramString2)))
    {
      this.c = paramString1;
      this.d = paramString2;
    }
  }
  
  public void setRequestParams(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      if (this.e == null) {
        this.e = new HashMap();
      }
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.e.put(str, paramMap.get(str));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/internal/NativeAdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */