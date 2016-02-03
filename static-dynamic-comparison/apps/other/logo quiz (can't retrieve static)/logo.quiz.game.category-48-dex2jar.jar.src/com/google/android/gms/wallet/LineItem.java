package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem
  implements SafeParcelable
{
  public static final Parcelable.Creator<LineItem> CREATOR = new i();
  private final int BR;
  String asE;
  String asF;
  int asG;
  String ask;
  String asl;
  String description;
  
  LineItem()
  {
    this.BR = 1;
    this.asG = 0;
  }
  
  LineItem(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    this.BR = paramInt1;
    this.description = paramString1;
    this.asE = paramString2;
    this.asF = paramString3;
    this.ask = paramString4;
    this.asG = paramInt2;
    this.asl = paramString5;
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
    return this.asl;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public String getQuantity()
  {
    return this.asE;
  }
  
  public int getRole()
  {
    return this.asG;
  }
  
  public String getTotalPrice()
  {
    return this.ask;
  }
  
  public String getUnitPrice()
  {
    return this.asF;
  }
  
  public int getVersionCode()
  {
    return this.BR;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    i.a(this, paramParcel, paramInt);
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
      LineItem.this.asl = paramString;
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      LineItem.this.description = paramString;
      return this;
    }
    
    public Builder setQuantity(String paramString)
    {
      LineItem.this.asE = paramString;
      return this;
    }
    
    public Builder setRole(int paramInt)
    {
      LineItem.this.asG = paramInt;
      return this;
    }
    
    public Builder setTotalPrice(String paramString)
    {
      LineItem.this.ask = paramString;
      return this;
    }
    
    public Builder setUnitPrice(String paramString)
    {
      LineItem.this.asF = paramString;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/wallet/LineItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */