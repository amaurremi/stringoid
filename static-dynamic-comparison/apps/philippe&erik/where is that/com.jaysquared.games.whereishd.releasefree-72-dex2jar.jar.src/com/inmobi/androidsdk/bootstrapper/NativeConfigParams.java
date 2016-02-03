package com.inmobi.androidsdk.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class NativeConfigParams
{
  int a = 100;
  int b = 3;
  int c = 10;
  
  public int getmFetchLimit()
  {
    return this.c;
  }
  
  public int getmMaxCacheSize()
  {
    return this.a;
  }
  
  public int getmMinLimit()
  {
    return this.b;
  }
  
  public void setFromMap(Map<String, Object> paramMap)
  {
    this.a = InternalSDKUtil.getIntFromMap(paramMap, "mcl", 1, 2147483647L);
    this.b = InternalSDKUtil.getIntFromMap(paramMap, "mt", 1, 2147483647L);
    this.c = InternalSDKUtil.getIntFromMap(paramMap, "fl", 1, 2147483647L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/androidsdk/bootstrapper/NativeConfigParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */