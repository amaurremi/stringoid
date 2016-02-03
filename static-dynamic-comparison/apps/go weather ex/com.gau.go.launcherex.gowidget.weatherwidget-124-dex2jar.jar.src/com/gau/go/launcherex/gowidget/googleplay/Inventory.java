package com.gau.go.launcherex.gowidget.googleplay;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Inventory
{
  Map mPurchaseMap = new HashMap();
  Map mSkuMap = new HashMap();
  
  void addPurchase(Purchase paramPurchase)
  {
    this.mPurchaseMap.put(paramPurchase.getSku(), paramPurchase);
  }
  
  void addSkuDetails(SkuDetails paramSkuDetails)
  {
    this.mSkuMap.put(paramSkuDetails.getSku(), paramSkuDetails);
  }
  
  public void erasePurchase(String paramString)
  {
    if (this.mPurchaseMap.containsKey(paramString)) {
      this.mPurchaseMap.remove(paramString);
    }
  }
  
  List getAllOwnedSkus()
  {
    return new ArrayList(this.mPurchaseMap.keySet());
  }
  
  List getAllOwnedSkus(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mPurchaseMap.values().iterator();
    while (localIterator.hasNext())
    {
      Purchase localPurchase = (Purchase)localIterator.next();
      if (localPurchase.getItemType().equals(paramString)) {
        localArrayList.add(localPurchase.getSku());
      }
    }
    return localArrayList;
  }
  
  List getAllPurchases()
  {
    return new ArrayList(this.mPurchaseMap.values());
  }
  
  public Purchase getPurchase(String paramString)
  {
    return (Purchase)this.mPurchaseMap.get(paramString);
  }
  
  public SkuDetails getSkuDetails(String paramString)
  {
    return (SkuDetails)this.mSkuMap.get(paramString);
  }
  
  public boolean hasDetails(String paramString)
  {
    return this.mSkuMap.containsKey(paramString);
  }
  
  public boolean hasPurchase(String paramString)
  {
    return this.mPurchaseMap.containsKey(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/googleplay/Inventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */