package com.getjar.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ConsumableProduct
  extends Product
{
  public static final Parcelable.Creator<ConsumableProduct> CREATOR = new Parcelable.Creator()
  {
    public ConsumableProduct createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ConsumableProduct(paramAnonymousParcel, null);
    }
    
    public ConsumableProduct[] newArray(int paramAnonymousInt)
    {
      return new ConsumableProduct[paramAnonymousInt];
    }
  };
  
  private ConsumableProduct(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public ConsumableProduct(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    super(paramString1, paramString2, paramString3, paramLong);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/internal/ConsumableProduct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */