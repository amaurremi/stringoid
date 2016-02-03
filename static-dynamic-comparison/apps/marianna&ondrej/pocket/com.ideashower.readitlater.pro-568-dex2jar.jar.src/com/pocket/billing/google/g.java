package com.pocket.billing.google;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class g
{
  private final GooglePremiumProduct a;
  private final GooglePremiumProduct b;
  
  public g(GooglePremiumProduct paramGooglePremiumProduct1, GooglePremiumProduct paramGooglePremiumProduct2)
  {
    this.a = paramGooglePremiumProduct1;
    this.b = paramGooglePremiumProduct2;
  }
  
  protected static g a(ArrayList paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    paramArrayList = null;
    Object localObject = null;
    GooglePremiumProduct localGooglePremiumProduct;
    if (localIterator.hasNext())
    {
      localGooglePremiumProduct = (GooglePremiumProduct)localIterator.next();
      if (localGooglePremiumProduct.f().equalsIgnoreCase(a.a.b)) {
        localObject = localGooglePremiumProduct;
      }
    }
    for (;;)
    {
      break;
      if (localGooglePremiumProduct.f().equalsIgnoreCase(a.a.c))
      {
        paramArrayList = localGooglePremiumProduct;
        continue;
        if ((localObject == null) && (paramArrayList == null)) {
          return null;
        }
        return new g((GooglePremiumProduct)localObject, paramArrayList);
      }
    }
  }
  
  public GooglePremiumProduct a()
  {
    return this.a;
  }
  
  public boolean a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject(paramString);
    String str = localJSONObject.optString("productId");
    if ((str == null) || (str.length() == 0)) {}
    do
    {
      do
      {
        return false;
      } while (localJSONObject.optInt("purchaseState", -1) != 0);
      if ((this.a != null) && (this.a.f().equals(str)))
      {
        this.a.b(paramString);
        return true;
      }
    } while ((this.b == null) || (!this.b.f().equals(str)));
    this.b.b(paramString);
    return true;
  }
  
  public GooglePremiumProduct b()
  {
    return this.b;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/billing/google/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */