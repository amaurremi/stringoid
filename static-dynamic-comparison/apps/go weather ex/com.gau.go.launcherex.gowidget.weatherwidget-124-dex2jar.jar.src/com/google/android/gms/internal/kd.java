package com.google.android.gms.internal;

import com.google.android.gms.wearable.d;

public class kd
  implements d
{
  private final String Xy;
  private final String wp;
  
  public kd(d paramd)
  {
    this.wp = paramd.getId();
    this.Xy = paramd.mc();
  }
  
  public String getId()
  {
    return this.wp;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String mc()
  {
    return this.Xy;
  }
  
  public d mf()
  {
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetEntity[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.wp == null) {
      localStringBuilder.append(",noid");
    }
    for (;;)
    {
      localStringBuilder.append(", key=");
      localStringBuilder.append(this.Xy);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(",");
      localStringBuilder.append(this.wp);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/kd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */