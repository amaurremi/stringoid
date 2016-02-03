package com.google.android.gms.analytics;

@Deprecated
public class HitBuilders$ItemBuilder
  extends HitBuilders.HitBuilder<ItemBuilder>
{
  public HitBuilders$ItemBuilder()
  {
    u.a().a(u.a.vV);
    set("&t", "item");
  }
  
  public ItemBuilder setCategory(String paramString)
  {
    set("&iv", paramString);
    return this;
  }
  
  public ItemBuilder setCurrencyCode(String paramString)
  {
    set("&cu", paramString);
    return this;
  }
  
  public ItemBuilder setName(String paramString)
  {
    set("&in", paramString);
    return this;
  }
  
  public ItemBuilder setPrice(double paramDouble)
  {
    set("&ip", Double.toString(paramDouble));
    return this;
  }
  
  public ItemBuilder setQuantity(long paramLong)
  {
    set("&iq", Long.toString(paramLong));
    return this;
  }
  
  public ItemBuilder setSku(String paramString)
  {
    set("&ic", paramString);
    return this;
  }
  
  public ItemBuilder setTransactionId(String paramString)
  {
    set("&ti", paramString);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/HitBuilders$ItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */