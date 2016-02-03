package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem
  implements SafeParcelable
{
  public static final Parcelable.Creator<LineItem> CREATOR = new f();
  String Gj;
  String Gk;
  String Gw;
  String Gx;
  int Gy;
  String description;
  private final int kg;
  
  LineItem()
  {
    this.kg = 1;
    this.Gy = 0;
  }
  
  LineItem(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    this.kg = paramInt1;
    this.description = paramString1;
    this.Gw = paramString2;
    this.Gx = paramString3;
    this.Gj = paramString4;
    this.Gy = paramInt2;
    this.Gk = paramString5;
  }
  
  public static Builder newBuilder()
  {
    LineItem localLineItem = new LineItem();
    localLineItem.getClass();
    return new Builder(null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCurrencyCode()
  {
    return this.Gk;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public String getQuantity()
  {
    return this.Gw;
  }
  
  public int getRole()
  {
    return this.Gy;
  }
  
  public String getTotalPrice()
  {
    return this.Gj;
  }
  
  public String getUnitPrice()
  {
    return this.Gx;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public LineItem build()
    {
      return LineItem.this;
    }
    
    public Builder setCurrencyCode(String paramString)
    {
      LineItem.this.Gk = paramString;
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      LineItem.this.description = paramString;
      return this;
    }
    
    public Builder setQuantity(String paramString)
    {
      LineItem.this.Gw = paramString;
      return this;
    }
    
    public Builder setRole(int paramInt)
    {
      LineItem.this.Gy = paramInt;
      return this;
    }
    
    public Builder setTotalPrice(String paramString)
    {
      LineItem.this.Gj = paramString;
      return this;
    }
    
    public Builder setUnitPrice(String paramString)
    {
      LineItem.this.Gx = paramString;
      return this;
    }
  }
  
  public static abstract interface Role
  {
    public static final int REGULAR = 0;
    public static final int SHIPPING = 2;
    public static final int TAX = 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/wallet/LineItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */