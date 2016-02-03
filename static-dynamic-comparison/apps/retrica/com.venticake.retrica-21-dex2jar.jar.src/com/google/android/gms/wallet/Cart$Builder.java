package com.google.android.gms.wallet;

import java.util.ArrayList;
import java.util.List;

public final class Cart$Builder
{
  private Cart$Builder(Cart paramCart) {}
  
  public Builder addLineItem(LineItem paramLineItem)
  {
    this.aiN.aiM.add(paramLineItem);
    return this;
  }
  
  public Cart build()
  {
    return this.aiN;
  }
  
  public Builder setCurrencyCode(String paramString)
  {
    this.aiN.aiL = paramString;
    return this;
  }
  
  public Builder setLineItems(List<LineItem> paramList)
  {
    this.aiN.aiM.clear();
    this.aiN.aiM.addAll(paramList);
    return this;
  }
  
  public Builder setTotalPrice(String paramString)
  {
    this.aiN.aiK = paramString;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wallet/Cart$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */