package com.gau.go.launcherex.gowidget.googleplay;

import org.json.JSONObject;

public class SkuDetails
{
  String mDescription;
  String mItemType;
  String mJson;
  String mPrice;
  String mSku;
  String mTitle;
  String mType;
  
  public SkuDetails(String paramString)
  {
    this("inapp", paramString);
  }
  
  public SkuDetails(String paramString1, String paramString2)
  {
    this.mItemType = paramString1;
    this.mJson = paramString2;
    paramString1 = new JSONObject(this.mJson);
    this.mSku = paramString1.optString("productId");
    this.mType = paramString1.optString("type");
    this.mPrice = paramString1.optString("price");
    this.mTitle = paramString1.optString("title");
    this.mDescription = paramString1.optString("description");
  }
  
  public String getDescription()
  {
    return this.mDescription;
  }
  
  public String getPrice()
  {
    return this.mPrice;
  }
  
  public String getSku()
  {
    return this.mSku;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public String getType()
  {
    return this.mType;
  }
  
  public String toString()
  {
    return "SkuDetails:" + this.mJson;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/googleplay/SkuDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */