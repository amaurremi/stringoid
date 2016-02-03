package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HitBuilders$HitBuilder<T extends HitBuilder>
{
  ProductAction wA;
  Map<String, List<Product>> wB = new HashMap();
  List<Promotion> wC = new ArrayList();
  List<Product> wD = new ArrayList();
  private Map<String, String> wz = new HashMap();
  
  public T addImpression(Product paramProduct, String paramString)
  {
    if (paramProduct == null)
    {
      aa.D("product should be non-null");
      return this;
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (!this.wB.containsKey(str)) {
      this.wB.put(str, new ArrayList());
    }
    ((List)this.wB.get(str)).add(paramProduct);
    return this;
  }
  
  public T addProduct(Product paramProduct)
  {
    if (paramProduct == null)
    {
      aa.D("product should be non-null");
      return this;
    }
    this.wD.add(paramProduct);
    return this;
  }
  
  public T addPromotion(Promotion paramPromotion)
  {
    if (paramPromotion == null)
    {
      aa.D("promotion should be non-null");
      return this;
    }
    this.wC.add(paramPromotion);
    return this;
  }
  
  public Map<String, String> build()
  {
    HashMap localHashMap = new HashMap(this.wz);
    if (this.wA != null) {
      localHashMap.putAll(this.wA.build());
    }
    Iterator localIterator = this.wC.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      localHashMap.putAll(((Promotion)localIterator.next()).X(o.v(i)));
      i += 1;
    }
    localIterator = this.wD.iterator();
    i = 1;
    while (localIterator.hasNext())
    {
      localHashMap.putAll(((Product)localIterator.next()).X(o.u(i)));
      i += 1;
    }
    localIterator = this.wB.entrySet().iterator();
    i = 1;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = (List)localEntry.getValue();
      String str = o.x(i);
      localObject = ((List)localObject).iterator();
      int j = 1;
      while (((Iterator)localObject).hasNext())
      {
        localHashMap.putAll(((Product)((Iterator)localObject).next()).X(str + o.w(j)));
        j += 1;
      }
      if (!TextUtils.isEmpty((CharSequence)localEntry.getKey())) {
        localHashMap.put(str + "nm", localEntry.getKey());
      }
      i += 1;
    }
    return localHashMap;
  }
  
  protected String get(String paramString)
  {
    return (String)this.wz.get(paramString);
  }
  
  public final T set(String paramString1, String paramString2)
  {
    u.a().a(u.a.uW);
    if (paramString1 != null)
    {
      this.wz.put(paramString1, paramString2);
      return this;
    }
    aa.D(" HitBuilder.set() called with a null paramName.");
    return this;
  }
  
  public final T setAll(Map<String, String> paramMap)
  {
    u.a().a(u.a.uX);
    if (paramMap == null) {
      return this;
    }
    this.wz.putAll(new HashMap(paramMap));
    return this;
  }
  
  public T setCampaignParamsFromUrl(String paramString)
  {
    u.a().a(u.a.uZ);
    paramString = t.b(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return this;
    }
    paramString = t.a(paramString);
    set("&cc", (String)paramString.get("utm_content"));
    set("&cm", (String)paramString.get("utm_medium"));
    set("&cn", (String)paramString.get("utm_campaign"));
    set("&cs", (String)paramString.get("utm_source"));
    set("&ck", (String)paramString.get("utm_term"));
    set("&ci", (String)paramString.get("utm_id"));
    set("&gclid", (String)paramString.get("gclid"));
    set("&dclid", (String)paramString.get("dclid"));
    set("&gmob_t", (String)paramString.get("gmob_t"));
    return this;
  }
  
  public T setCustomDimension(int paramInt, String paramString)
  {
    set(o.s(paramInt), paramString);
    return this;
  }
  
  public T setCustomMetric(int paramInt, float paramFloat)
  {
    set(o.t(paramInt), Float.toString(paramFloat));
    return this;
  }
  
  protected T setHitType(String paramString)
  {
    set("&t", paramString);
    return this;
  }
  
  public T setNewSession()
  {
    set("&sc", "start");
    return this;
  }
  
  public T setNonInteraction(boolean paramBoolean)
  {
    set("&ni", t.a(paramBoolean));
    return this;
  }
  
  public T setProductAction(ProductAction paramProductAction)
  {
    this.wA = paramProductAction;
    return this;
  }
  
  public T setPromotionAction(String paramString)
  {
    this.wz.put("&promoa", paramString);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/HitBuilders$HitBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */