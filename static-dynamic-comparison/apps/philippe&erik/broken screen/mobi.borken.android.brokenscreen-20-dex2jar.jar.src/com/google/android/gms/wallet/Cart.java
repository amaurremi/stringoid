package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class Cart
  implements SafeParcelable
{
  public static final Parcelable.Creator<Cart> CREATOR = new b();
  String aiH;
  String aiI;
  ArrayList<LineItem> aiJ;
  private final int xJ;
  
  Cart()
  {
    this.xJ = 1;
    this.aiJ = new ArrayList();
  }
  
  Cart(int paramInt, String paramString1, String paramString2, ArrayList<LineItem> paramArrayList)
  {
    this.xJ = paramInt;
    this.aiH = paramString1;
    this.aiI = paramString2;
    this.aiJ = paramArrayList;
  }
  
  public static Builder newBuilder()
  {
    Cart localCart = new Cart();
    localCart.getClass();
    return new Builder(null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCurrencyCode()
  {
    return this.aiI;
  }
  
  public ArrayList<LineItem> getLineItems()
  {
    return this.aiJ;
  }
  
  public String getTotalPrice()
  {
    return this.aiH;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public Builder addLineItem(LineItem paramLineItem)
    {
      Cart.this.aiJ.add(paramLineItem);
      return this;
    }
    
    public Cart build()
    {
      return Cart.this;
    }
    
    public Builder setCurrencyCode(String paramString)
    {
      Cart.this.aiI = paramString;
      return this;
    }
    
    public Builder setLineItems(List<LineItem> paramList)
    {
      Cart.this.aiJ.clear();
      Cart.this.aiJ.addAll(paramList);
      return this;
    }
    
    public Builder setTotalPrice(String paramString)
    {
      Cart.this.aiH = paramString;
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/wallet/Cart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */