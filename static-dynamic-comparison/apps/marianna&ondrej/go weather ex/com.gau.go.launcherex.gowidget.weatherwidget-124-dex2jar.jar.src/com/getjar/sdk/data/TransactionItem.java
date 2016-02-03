package com.getjar.sdk.data;

public class TransactionItem
{
  private String mClientTransactionID;
  private String mItemId;
  private String mItemMetaData;
  private String mPackageName;
  private String mTrackingData;
  
  public TransactionItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mPackageName = paramString1;
    this.mItemId = paramString2;
    this.mClientTransactionID = paramString3;
    this.mItemMetaData = paramString4;
    this.mTrackingData = paramString5;
  }
  
  public String getItemId()
  {
    return this.mItemId;
  }
  
  public String getMetaData()
  {
    return this.mItemMetaData;
  }
  
  public String getPackageName()
  {
    return this.mPackageName;
  }
  
  public String getTrackingData()
  {
    return this.mTrackingData;
  }
  
  public String getTransactionId()
  {
    return this.mClientTransactionID;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/data/TransactionItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */