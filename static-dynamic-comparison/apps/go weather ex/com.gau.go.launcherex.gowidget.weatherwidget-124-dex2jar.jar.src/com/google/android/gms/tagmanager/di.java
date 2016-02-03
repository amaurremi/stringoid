package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class di
  extends df
{
  private static final String ID = a.aF.toString();
  private static final String aaO = b.aV.toString();
  private static final String aaP = b.be.toString();
  private static final String aaQ = b.bd.toString();
  private static final String aaR = b.eg.toString();
  private static final String aaS = b.ei.toString();
  private static final String aaT = b.ek.toString();
  private static Map<String, String> aaU;
  private static Map<String, String> aaV;
  private final DataLayer WK;
  private final Set<String> aaW;
  private final de aaX;
  
  public di(Context paramContext, DataLayer paramDataLayer)
  {
    this(paramContext, paramDataLayer, new de(paramContext));
  }
  
  di(Context paramContext, DataLayer paramDataLayer, de paramde)
  {
    super(ID, new String[0]);
    this.WK = paramDataLayer;
    this.aaX = paramde;
    this.aaW = new HashSet();
    this.aaW.add("");
    this.aaW.add("0");
    this.aaW.add("false");
  }
  
  private Map<String, String> H(Map<String, d.a> paramMap)
  {
    paramMap = (d.a)paramMap.get(aaS);
    if (paramMap != null) {
      return c(paramMap);
    }
    if (aaU == null)
    {
      paramMap = new HashMap();
      paramMap.put("transactionId", "&ti");
      paramMap.put("transactionAffiliation", "&ta");
      paramMap.put("transactionTax", "&tt");
      paramMap.put("transactionShipping", "&ts");
      paramMap.put("transactionTotal", "&tr");
      paramMap.put("transactionCurrency", "&cu");
      aaU = paramMap;
    }
    return aaU;
  }
  
  private Map<String, String> I(Map<String, d.a> paramMap)
  {
    paramMap = (d.a)paramMap.get(aaT);
    if (paramMap != null) {
      return c(paramMap);
    }
    if (aaV == null)
    {
      paramMap = new HashMap();
      paramMap.put("name", "&in");
      paramMap.put("sku", "&ic");
      paramMap.put("category", "&iv");
      paramMap.put("price", "&ip");
      paramMap.put("quantity", "&iq");
      paramMap.put("currency", "&cu");
      aaV = paramMap;
    }
    return aaV;
  }
  
  private void a(Tracker paramTracker, Map<String, d.a> paramMap)
  {
    String str = cc("transactionId");
    if (str == null) {
      bh.w("Cannot find transactionId in data layer.");
    }
    for (;;)
    {
      return;
      LinkedList localLinkedList = new LinkedList();
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = p((d.a)paramMap.get(aaQ));
        ((Map)localObject1).put("&t", "transaction");
        localObject2 = H(paramMap).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          b((Map)localObject1, (String)((Map.Entry)localObject3).getValue(), cc((String)((Map.Entry)localObject3).getKey()));
        }
        localLinkedList.add(localObject1);
      }
      catch (IllegalArgumentException paramTracker)
      {
        bh.b("Unable to send transaction", paramTracker);
        return;
      }
      Object localObject1 = lU();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map)((Iterator)localObject1).next();
          if (((Map)localObject2).get("name") == null)
          {
            bh.w("Unable to send transaction item hit due to missing 'name' field.");
            return;
          }
          localObject3 = p((d.a)paramMap.get(aaQ));
          ((Map)localObject3).put("&t", "item");
          ((Map)localObject3).put("&ti", str);
          Iterator localIterator = I(paramMap).entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            b((Map)localObject3, (String)localEntry.getValue(), (String)((Map)localObject2).get(localEntry.getKey()));
          }
          localLinkedList.add(localObject3);
        }
      }
      paramMap = localLinkedList.iterator();
      while (paramMap.hasNext()) {
        paramTracker.send((Map)paramMap.next());
      }
    }
  }
  
  private void b(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  private Map<String, String> c(d.a parama)
  {
    parama = dh.o(parama);
    if (!(parama instanceof Map)) {
      return null;
    }
    Object localObject = (Map)parama;
    parama = new LinkedHashMap();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      parama.put(localEntry.getKey().toString(), localEntry.getValue().toString());
    }
    return parama;
  }
  
  private String cc(String paramString)
  {
    paramString = this.WK.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.toString();
  }
  
  private boolean e(Map<String, d.a> paramMap, String paramString)
  {
    paramMap = (d.a)paramMap.get(paramString);
    if (paramMap == null) {
      return false;
    }
    return dh.n(paramMap).booleanValue();
  }
  
  private List<Map<String, String>> lU()
  {
    Object localObject = this.WK.get("transactionProducts");
    if (localObject == null) {
      return null;
    }
    if (!(localObject instanceof List)) {
      throw new IllegalArgumentException("transactionProducts should be of type List.");
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext()) {
      if (!(localIterator.next() instanceof Map)) {
        throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
      }
    }
    return (List)localObject;
  }
  
  private Map<String, String> p(d.a parama)
  {
    if (parama == null) {
      return new HashMap();
    }
    parama = c(parama);
    if (parama == null) {
      return new HashMap();
    }
    String str = (String)parama.get("&aip");
    if ((str != null) && (this.aaW.contains(str.toLowerCase()))) {
      parama.remove("&aip");
    }
    return parama;
  }
  
  public void z(Map<String, d.a> paramMap)
  {
    Tracker localTracker = this.aaX.bU("_GTM_DEFAULT_TRACKER_");
    if (e(paramMap, aaP))
    {
      localTracker.send(p((d.a)paramMap.get(aaQ)));
      return;
    }
    if (e(paramMap, aaR))
    {
      a(localTracker, paramMap);
      return;
    }
    bh.z("Ignoring unknown tag.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */