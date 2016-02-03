package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

public final class Cart
  implements SafeParcelable
{
  public static final Parcelable.Creator<Cart> CREATOR = new b();
  String aiK;
  String aiL;
  ArrayList<LineItem> aiM;
  private final int xM;
  
  Cart()
  {
    this.xM = 1;
    this.aiM = new ArrayList();
  }
  
  Cart(int paramInt, String paramString1, String paramString2, ArrayList<LineItem> paramArrayList)
  {
    this.xM = paramInt;
    this.aiK = paramString1;
    this.aiL = paramString2;
    this.aiM = paramArrayList;
  }
  
  public static Cart.Builder newBuilder()
  {
    Cart localCart = new Cart();
    localCart.getClass();
    return new Cart.Builder(localCart, null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCurrencyCode()
  {
    return this.aiL;
  }
  
  public ArrayList<LineItem> getLineItems()
  {
    return this.aiM;
  }
  
  public String getTotalPrice()
  {
    return this.aiK;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/Cart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */