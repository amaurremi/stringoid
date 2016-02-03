package com.inmobi.androidsdk.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class AppGalleryConfigParams
{
  String a = "http://appgalleries.inmobi.com/inmobi_sdk";
  
  public String getUrl()
  {
    return this.a;
  }
  
  public void setFromMap(Map<String, Object> paramMap)
  {
    this.a = InternalSDKUtil.getStringFromMap(paramMap, "url");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/bootstrapper/AppGalleryConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */