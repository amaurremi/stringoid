package com.getjar.sdk.data;

import android.os.Bundle;

public class PurchaseResult
{
  private long mCost = 0L;
  private String mProductId = "";
  private String mTransactionId = "";
  
  public PurchaseResult(Bundle paramBundle)
  {
    if (paramBundle == null) {
      throw new IllegalArgumentException("Must have a valid bundle.");
    }
    this.mTransactionId = paramBundle.getString("transactionId");
    this.mProductId = paramBundle.getString("id");
    this.mCost = paramBundle.getLong("price", 0L);
  }
  
  public long getCost()
  {
    return this.mCost;
  }
  
  public String getProductId()
  {
    return this.mProductId;
  }
  
  public String getTransactionId()
  {
    return this.mTransactionId;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/PurchaseResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */