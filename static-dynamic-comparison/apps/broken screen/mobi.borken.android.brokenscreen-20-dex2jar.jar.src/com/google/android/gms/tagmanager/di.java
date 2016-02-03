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
  private static Map<String, String> aiA;
  private static final String ait = b.aV.toString();
  private static final String aiu = b.be.toString();
  private static final String aiv = b.bd.toString();
  private static final String aiw = b.eg.toString();
  private static final String aix = b.ei.toString();
  private static final String aiy = b.ek.toString();
  private static Map<String, String> aiz;
  private final DataLayer aer;
  private final Set<String> aiB;
  private final de aiC;
  
  public di(Context paramContext, DataLayer paramDataLayer)
  {
    this(paramContext, paramDataLayer, new de(paramContext));
  }
  
  di(Context paramContext, DataLayer paramDataLayer, de paramde)
  {
    super(ID, new String[0]);
    this.aer = paramDataLayer;
    this.aiC = paramde;
    this.aiB = new HashSet();
    this.aiB.add("");
    this.aiB.add("0");
    this.aiB.add("false");
  }
  
  private Map<String, String> G(Map<String, d.a> paramMap)
  {
    paramMap = (d.a)paramMap.get(aix);
    if (paramMap != null) {
      return c(paramMap);
    }
    if (aiz == null)
    {
      paramMap = new HashMap();
      paramMap.put("transactionId", "&ti");
      paramMap.put("transactionAffiliation", "&ta");
      paramMap.put("transactionTax", "&tt");
      paramMap.put("transactionShipping", "&ts");
      paramMap.put("transactionTotal", "&tr");
      paramMap.put("transactionCurrency", "&cu");
      aiz = paramMap;
    }
    return aiz;
  }
  
  private Map<String, String> H(Map<String, d.a> paramMap)
  {
    paramMap = (d.a)paramMap.get(aiy);
    if (paramMap != null) {
      return c(paramMap);
    }
    if (aiA == null)
    {
      paramMap = new HashMap();
      paramMap.put("name", "&in");
      paramMap.put("sku", "&ic");
      paramMap.put("category", "&iv");
      paramMap.put("price", "&ip");
      paramMap.put("quantity", "&iq");
      paramMap.put("currency", "&cu");
      aiA = paramMap;
    }
    return aiA;
  }
  
  private void a(Tracker paramTracker, Map<String, d.a> paramMap)
  {
    String str = cu("transactionId");
    if (str == null) {
      bh.A("Cannot find transactionId in data layer.");
    }
    for (;;)
    {
      return;
      LinkedList localLinkedList = new LinkedList();
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = p((d.a)paramMap.get(aiv));
        ((Map)localObject1).put("&t", "transaction");
        localObject2 = G(paramMap).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          b((Map)localObject1, (String)((Map.Entry)localObject3).getValue(), cu((String)((Map.Entry)localObject3).getKey()));
        }
        localLinkedList.add(localObject1);
      }
      catch (IllegalArgumentException paramTracker)
      {
        bh.b("Unable to send transaction", paramTracker);
        return;
      }
      Object localObject1 = mZ();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map)((Iterator)localObject1).next();
          if (((Map)localObject2).get("name") == null)
          {
            bh.A("Unable to send transaction item hit due to missing 'name' field.");
            return;
          }
          localObject3 = p((d.a)paramMap.get(aiv));
          ((Map)localObject3).put("&t", "item");
          ((Map)localObject3).put("&ti", str);
          Iterator localIterator = H(paramMap).entrySet().iterator();
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
  
  private String cu(String paramString)
  {
    paramString = this.aer.get(paramString);
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
  
  private List<Map<String, String>> mZ()
  {
    Object localObject = this.aer.get("transactionProducts");
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
    if ((str != null) && (this.aiB.contains(str.toLowerCase()))) {
      parama.remove("&aip");
    }
    return parama;
  }
  
  public void y(Map<String, d.a> paramMap)
  {
    Tracker localTracker = this.aiC.cm("_GTM_DEFAULT_TRACKER_");
    if (e(paramMap, aiu))
    {
      localTracker.send(p((d.a)paramMap.get(aiv)));
      return;
    }
    if (e(paramMap, aiw))
    {
      a(localTracker, paramMap);
      return;
    }
    bh.D("Ignoring unknown tag.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */