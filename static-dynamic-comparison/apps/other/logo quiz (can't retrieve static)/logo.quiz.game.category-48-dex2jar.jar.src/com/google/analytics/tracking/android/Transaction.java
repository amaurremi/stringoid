package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transaction
{
  private final String affiliation;
  private final String currencyCode;
  private final Map<String, Item> items;
  private final long shippingCostInMicros;
  private final long totalCostInMicros;
  private final long totalTaxInMicros;
  private final String transactionId;
  
  private Transaction(Builder paramBuilder)
  {
    this.transactionId = paramBuilder.transactionId;
    this.totalCostInMicros = paramBuilder.totalCostInMicros;
    this.affiliation = paramBuilder.affiliation;
    this.totalTaxInMicros = paramBuilder.totalTaxInMicros;
    this.shippingCostInMicros = paramBuilder.shippingCostInMicros;
    this.currencyCode = paramBuilder.currencyCode;
    this.items = new HashMap();
  }
  
  public void addItem(Item paramItem)
  {
    this.items.put(paramItem.getProductSKU(), paramItem);
  }
  
  public String getAffiliation()
  {
    return this.affiliation;
  }
  
  String getCurrencyCode()
  {
    return this.currencyCode;
  }
  
  public List<Item> getItems()
  {
    return new ArrayList(this.items.values());
  }
  
  public long getShippingCostInMicros()
  {
    return this.shippingCostInMicros;
  }
  
  public long getTotalCostInMicros()
  {
    return this.totalCostInMicros;
  }
  
  public long getTotalTaxInMicros()
  {
    return this.totalTaxInMicros;
  }
  
  public String getTransactionId()
  {
    return this.transactionId;
  }
  
  public static class Builder
  {
    private String affiliation = null;
    private String currencyCode = null;
    private long shippingCostInMicros = 0L;
    private final long totalCostInMicros;
    private long totalTaxInMicros = 0L;
    private final String transactionId;
    
    public Builder(String paramString, long paramLong)
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("transactionId must not be empty or null");
      }
      this.transactionId = paramString;
      this.totalCostInMicros = paramLong;
    }
    
    public Transaction build()
    {
      return new Transaction(this, null);
    }
    
    public Builder setAffiliation(String paramString)
    {
      this.affiliation = paramString;
      return this;
    }
    
    Builder setCurrencyCode(String paramString)
    {
      this.currencyCode = paramString;
      return this;
    }
    
    public Builder setShippingCostInMicros(long paramLong)
    {
      this.shippingCostInMicros = paramLong;
      return this;
    }
    
    public Builder setTotalTaxInMicros(long paramLong)
    {
      this.totalTaxInMicros = paramLong;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/analytics/tracking/android/Transaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */