package com.google.analytics.tracking.android;

import android.text.TextUtils;

public class Item
{
  private final long itemPriceInMicros;
  private final long itemQuantity;
  private final String productCategory;
  private final String productName;
  private final String productSKU;
  
  private Item(Builder paramBuilder)
  {
    this.productSKU = paramBuilder.productSKU;
    this.itemPriceInMicros = paramBuilder.itemPriceInMicros;
    this.itemQuantity = paramBuilder.itemQuantity;
    this.productName = paramBuilder.productName;
    this.productCategory = paramBuilder.productCategory;
  }
  
  public long getItemPriceInMicros()
  {
    return this.itemPriceInMicros;
  }
  
  public long getItemQuantity()
  {
    return this.itemQuantity;
  }
  
  public String getProductCategory()
  {
    return this.productCategory;
  }
  
  public String getProductName()
  {
    return this.productName;
  }
  
  public String getProductSKU()
  {
    return this.productSKU;
  }
  
  public static class Builder
  {
    private final long itemPriceInMicros;
    private final long itemQuantity;
    private String productCategory = null;
    private final String productName;
    private final String productSKU;
    
    public Builder(String paramString1, String paramString2, long paramLong1, long paramLong2)
    {
      if (TextUtils.isEmpty(paramString1)) {
        throw new IllegalArgumentException("productSKU must not be empty or null");
      }
      if (TextUtils.isEmpty(paramString2)) {
        throw new IllegalArgumentException("itemName must not be empty or null");
      }
      this.productSKU = paramString1;
      this.productName = paramString2;
      this.itemPriceInMicros = paramLong1;
      this.itemQuantity = paramLong2;
    }
    
    public Item build()
    {
      return new Item(this, null);
    }
    
    public Builder setProductCategory(String paramString)
    {
      this.productCategory = paramString;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/analytics/tracking/android/Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */