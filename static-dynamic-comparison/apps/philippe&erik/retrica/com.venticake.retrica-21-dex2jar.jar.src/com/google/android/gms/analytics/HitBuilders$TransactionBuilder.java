package com.google.android.gms.analytics;

@Deprecated
public class HitBuilders$TransactionBuilder
  extends HitBuilders.HitBuilder<TransactionBuilder>
{
  public HitBuilders$TransactionBuilder()
  {
    u.a().a(u.a.vC);
    set("&t", "transaction");
  }
  
  public TransactionBuilder setAffiliation(String paramString)
  {
    set("&ta", paramString);
    return this;
  }
  
  public TransactionBuilder setCurrencyCode(String paramString)
  {
    set("&cu", paramString);
    return this;
  }
  
  public TransactionBuilder setRevenue(double paramDouble)
  {
    set("&tr", Double.toString(paramDouble));
    return this;
  }
  
  public TransactionBuilder setShipping(double paramDouble)
  {
    set("&ts", Double.toString(paramDouble));
    return this;
  }
  
  public TransactionBuilder setTax(double paramDouble)
  {
    set("&tt", Double.toString(paramDouble));
    return this;
  }
  
  public TransactionBuilder setTransactionId(String paramString)
  {
    set("&ti", paramString);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/HitBuilders$TransactionBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */