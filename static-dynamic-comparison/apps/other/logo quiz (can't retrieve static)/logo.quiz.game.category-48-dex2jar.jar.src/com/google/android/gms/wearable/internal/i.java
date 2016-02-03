package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public class i
  implements DataItemAsset
{
  private final String BL;
  private final String JH;
  
  public i(DataItemAsset paramDataItemAsset)
  {
    this.BL = paramDataItemAsset.getId();
    this.JH = paramDataItemAsset.getDataItemKey();
  }
  
  public String getDataItemKey()
  {
    return this.JH;
  }
  
  public String getId()
  {
    return this.BL;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public DataItemAsset pV()
  {
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetEntity[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.BL == null) {
      localStringBuilder.append(",noid");
    }
    for (;;)
    {
      localStringBuilder.append(", key=");
      localStringBuilder.append(this.JH);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(",");
      localStringBuilder.append(this.BL);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wearable/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */