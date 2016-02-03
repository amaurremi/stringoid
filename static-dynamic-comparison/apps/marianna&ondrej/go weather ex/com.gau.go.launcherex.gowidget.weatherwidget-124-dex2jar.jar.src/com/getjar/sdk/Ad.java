package com.getjar.sdk;

import com.getjar.sdk.data.cache.CacheEntry;
import com.getjar.sdk.utilities.OverridesUtility;
import com.getjar.sdk.utilities.StringUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class Ad
  implements Comparator<Ad>, Comparable<Ad>
{
  private final String _adDescription;
  private List<ImageAsset> _adImages = null;
  private final String _adInventoryId;
  private final Locale _adLocale;
  protected String _adPlacementTag = null;
  protected final long _cacheTTL;
  private final int _earnAmount;
  private final String _earnDisplayAmount;
  private final Locale _earnLocale = Locale.US;
  private final String _earnVirtualCurrencyKey;
  private final String _earnVirtualCurrencyName;
  private final long _expiresOn;
  private final String _productDescriptionLong;
  private final String _productDescriptionShort;
  private final Locale _productLocale;
  private final String _productTitle;
  private final String _productType;
  
  protected Ad(JSONObject paramJSONObject, CacheEntry paramCacheEntry)
  {
    if (paramJSONObject == null) {
      try
      {
        throw new IllegalArgumentException("'adJson' can not be NULL");
      }
      catch (JSONException paramJSONObject)
      {
        throw new GetjarException(paramJSONObject);
      }
    }
    if (!paramJSONObject.has("inventory_id")) {
      throw new IllegalStateException("'adJson' does not contain 'inventory_id'");
    }
    if (!paramJSONObject.has("cache_ttl")) {
      throw new IllegalStateException("'adJson' does not contain 'cache_ttl'");
    }
    if (!paramJSONObject.has("ad_description")) {
      throw new IllegalStateException("'adJson' does not contain 'ad_description'");
    }
    JSONObject localJSONObject1 = paramJSONObject.getJSONObject("ad_description");
    if (!localJSONObject1.has("text")) {
      throw new IllegalStateException("'adDescription' does not contain 'text'");
    }
    if (!localJSONObject1.has("locale")) {
      throw new IllegalStateException("'adDescription' does not contain 'locale'");
    }
    if (!paramJSONObject.has("product_type")) {
      throw new IllegalStateException("'adJson' does not contain 'product_type'");
    }
    if (!paramJSONObject.has("product")) {
      throw new IllegalStateException("'adJson' does not contain 'product'");
    }
    JSONObject localJSONObject2 = paramJSONObject.getJSONObject("product");
    if (!localJSONObject2.has("description")) {
      throw new IllegalStateException("'product' does not contain 'description'");
    }
    localJSONObject2 = localJSONObject2.getJSONObject("description");
    if (!localJSONObject2.has("locale")) {
      throw new IllegalStateException("'productDescription' does not contain 'locale'");
    }
    if (!localJSONObject2.has("title")) {
      throw new IllegalStateException("'productDescription' does not contain 'title'");
    }
    if (!localJSONObject2.has("short_description")) {
      throw new IllegalStateException("'productDescription' does not contain 'short_description'");
    }
    if (!localJSONObject2.has("full_description")) {
      throw new IllegalStateException("'productDescription' does not contain 'full_description'");
    }
    if (!paramJSONObject.has("virtual_currency_key")) {
      throw new IllegalStateException("'adJson' does not contain 'virtual_currency_key'");
    }
    if (!paramJSONObject.has("virtual_currency_name")) {
      throw new IllegalStateException("'adJson' does not contain 'virtual_currency_name'");
    }
    if (!paramJSONObject.has("earn_display_amount")) {
      throw new IllegalStateException("'adJson' does not contain 'earn_display_amount'");
    }
    if (!paramJSONObject.has("earn_amount")) {
      throw new IllegalStateException("'adJson' does not contain 'earn_amount'");
    }
    if (paramJSONObject.has("ad_placement_tag")) {
      this._adPlacementTag = paramJSONObject.getString("ad_placement_tag");
    }
    this._adInventoryId = paramJSONObject.getString("inventory_id");
    this._cacheTTL = OverridesUtility.getValueInt("ads.cache.cache_ttl_in_milliseconds", Integer.valueOf((int)(paramJSONObject.getLong("cache_ttl") * 1000L))).intValue();
    this._adDescription = localJSONObject1.getString("text");
    this._adLocale = stringToLocale(localJSONObject1.getString("locale"));
    this._productType = paramJSONObject.getString("product_type");
    this._productLocale = stringToLocale(localJSONObject2.getString("locale"));
    this._productTitle = localJSONObject2.getString("title");
    this._productDescriptionShort = localJSONObject2.getString("short_description");
    this._productDescriptionLong = localJSONObject2.getString("full_description");
    this._earnVirtualCurrencyKey = paramJSONObject.getString("virtual_currency_key");
    this._earnVirtualCurrencyName = paramJSONObject.getString("virtual_currency_name");
    this._earnAmount = paramJSONObject.getInt("earn_amount");
    this._earnDisplayAmount = paramJSONObject.getString("earn_display_amount");
    if (paramCacheEntry != null) {}
    for (long l = paramCacheEntry.getCreateTimestamp().longValue();; l = System.currentTimeMillis())
    {
      this._expiresOn = (this._cacheTTL + l);
      return;
    }
  }
  
  public int compare(Ad paramAd1, Ad paramAd2)
  {
    return paramAd1.getAdInventoryId().compareTo(paramAd2.getAdInventoryId());
  }
  
  public int compareTo(Ad paramAd)
  {
    return compare(this, paramAd);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Ad))) {
      return false;
    }
    return getAdInventoryId().equals(((Ad)paramObject).getAdInventoryId());
  }
  
  public String getAdDescription()
  {
    return this._adDescription;
  }
  
  public List<ImageAsset> getAdImages()
  {
    return this._adImages;
  }
  
  public String getAdInventoryId()
  {
    return this._adInventoryId;
  }
  
  public Locale getAdLocale()
  {
    return this._adLocale;
  }
  
  public String getAdPlacementTag()
  {
    return this._adPlacementTag;
  }
  
  public int getEarnAmount()
  {
    return this._earnAmount;
  }
  
  public String getEarnDisplayAmount()
  {
    return this._earnDisplayAmount;
  }
  
  public Locale getEarnLocale()
  {
    return this._earnLocale;
  }
  
  public String getEarnVirtualCurrencyKey()
  {
    return this._earnVirtualCurrencyKey;
  }
  
  public String getEarnVirtualCurrencyName()
  {
    return this._earnVirtualCurrencyName;
  }
  
  public long getExpiresOn()
  {
    return this._expiresOn;
  }
  
  public String getProductDescriptionLong()
  {
    return this._productDescriptionLong;
  }
  
  public String getProductDescriptionShort()
  {
    return this._productDescriptionShort;
  }
  
  public Locale getProductLocale()
  {
    return this._productLocale;
  }
  
  public String getProductTitle()
  {
    return this._productTitle;
  }
  
  public String getProductType()
  {
    return this._productType;
  }
  
  public boolean hasImageType(String paramString)
  {
    if (StringUtility.isNullOrEmpty(paramString)) {
      throw new IllegalArgumentException("'imageType' cannot be NULL or empty");
    }
    if ((!paramString.equalsIgnoreCase("ICON")) && (!paramString.equalsIgnoreCase("INTERSTITIAL"))) {
      throw new IllegalArgumentException(String.format(Locale.US, "Unsupported image type [%1$s]", new Object[] { paramString }));
    }
    if (this._adImages != null)
    {
      Iterator localIterator = this._adImages.iterator();
      while (localIterator.hasNext()) {
        if (paramString.equalsIgnoreCase(((ImageAsset)localIterator.next()).getType())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return getAdInventoryId().hashCode();
  }
  
  protected void setImages(List<JSONObject> paramList)
  {
    ArrayList localArrayList = new ArrayList(2);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new ImageAsset((JSONObject)paramList.next()));
    }
    this._adImages = Collections.unmodifiableList(localArrayList);
  }
  
  protected Locale stringToLocale(String paramString)
  {
    paramString = paramString.trim().split("-");
    return new Locale(paramString[0], paramString[1]);
  }
  
  public String toString()
  {
    return getAdInventoryId();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/Ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */