package com.inmobi.monetization.internal.objects;

import android.content.Context;
import android.util.Base64;
import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.bootstrapper.NativeConfigParams;
import com.inmobi.commons.ads.cache.AdData;
import com.inmobi.commons.ads.cache.AdDatabaseManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.IMNative;
import java.util.List;
import org.json.JSONObject;

public class NativeAdsCache
{
  static NativeAdsCache a;
  
  private NativeAdsCache(Context paramContext) {}
  
  public static NativeAdsCache getInstance()
  {
    if (a == null) {}
    try
    {
      a = new NativeAdsCache(InternalSDKUtil.getContext());
      AdDatabaseManager.getInstance().setDBLimit(Initializer.getConfigParams().getNativeSdkConfigParams().getmMaxCacheSize());
      return a;
    }
    finally {}
  }
  
  public IMNative getCachedAd(String paramString)
  {
    try
    {
      paramString = new JSONObject(AdDatabaseManager.getInstance().getAd(paramString).getContent());
      paramString = new NativeAd(new String(Base64.decode(paramString.getString("pubContent"), 0)).trim(), paramString.getString("contextCode"), paramString.getString("namespace"));
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.internal("[InMobi]-[Monetization]", "Exception getting cached ad", paramString);
    }
    return null;
  }
  
  public int getNumCachedAds(String paramString)
  {
    try
    {
      int i = AdDatabaseManager.getInstance().getNoOfAds(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public void saveNativeAds(String paramString, List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        AdData localAdData = new AdData();
        localAdData.setContent((String)paramList.get(i));
        localAdData.setTimestamp(System.currentTimeMillis());
        localAdData.setAppId(paramString);
        localAdData.setAdType("native");
        AdDatabaseManager.getInstance().insertAd(localAdData);
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/monetization/internal/objects/NativeAdsCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */