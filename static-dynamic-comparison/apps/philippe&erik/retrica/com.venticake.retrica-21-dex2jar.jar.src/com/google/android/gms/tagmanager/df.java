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

class df
  extends dc
{
  private static final String a = a.aF.toString();
  private static final String b = b.aV.toString();
  private static final String c = b.be.toString();
  private static final String d = b.bd.toString();
  private static final String e = b.eg.toString();
  private static final String f = b.ei.toString();
  private static final String g = b.ek.toString();
  private static Map<String, String> h;
  private static Map<String, String> i;
  private final Set<String> j;
  private final cz k;
  private final DataLayer l;
  
  public df(Context paramContext, DataLayer paramDataLayer)
  {
    this(paramContext, paramDataLayer, new cz(paramContext));
  }
  
  df(Context paramContext, DataLayer paramDataLayer, cz paramcz)
  {
    super(a, new String[0]);
    this.l = paramDataLayer;
    this.k = paramcz;
    this.j = new HashSet();
    this.j.add("");
    this.j.add("0");
    this.j.add("false");
  }
  
  private String a(String paramString)
  {
    paramString = this.l.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.toString();
  }
  
  private Map<String, String> a(d.a parama)
  {
    parama = de.f(parama);
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
  
  private void a(Tracker paramTracker, Map<String, d.a> paramMap)
  {
    String str = a("transactionId");
    if (str == null) {
      as.a("Cannot find transactionId in data layer.");
    }
    for (;;)
    {
      return;
      LinkedList localLinkedList = new LinkedList();
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = b((d.a)paramMap.get(d));
        ((Map)localObject1).put("&t", "transaction");
        localObject2 = c(paramMap).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          a((Map)localObject1, (String)((Map.Entry)localObject3).getValue(), a((String)((Map.Entry)localObject3).getKey()));
        }
        localLinkedList.add(localObject1);
      }
      catch (IllegalArgumentException paramTracker)
      {
        as.a("Unable to send transaction", paramTracker);
        return;
      }
      Object localObject1 = d();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map)((Iterator)localObject1).next();
          if (((Map)localObject2).get("name") == null)
          {
            as.a("Unable to send transaction item hit due to missing 'name' field.");
            return;
          }
          localObject3 = b((d.a)paramMap.get(d));
          ((Map)localObject3).put("&t", "item");
          ((Map)localObject3).put("&ti", str);
          Iterator localIterator = d(paramMap).entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            a((Map)localObject3, (String)localEntry.getValue(), (String)((Map)localObject2).get(localEntry.getKey()));
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
  
  private void a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  private boolean a(Map<String, d.a> paramMap, String paramString)
  {
    paramMap = (d.a)paramMap.get(paramString);
    if (paramMap == null) {
      return false;
    }
    return de.e(paramMap).booleanValue();
  }
  
  private Map<String, String> b(d.a parama)
  {
    if (parama == null) {
      return new HashMap();
    }
    parama = a(parama);
    if (parama == null) {
      return new HashMap();
    }
    String str = (String)parama.get("&aip");
    if ((str != null) && (this.j.contains(str.toLowerCase()))) {
      parama.remove("&aip");
    }
    return parama;
  }
  
  private Map<String, String> c(Map<String, d.a> paramMap)
  {
    paramMap = (d.a)paramMap.get(f);
    if (paramMap != null) {
      return a(paramMap);
    }
    if (h == null)
    {
      paramMap = new HashMap();
      paramMap.put("transactionId", "&ti");
      paramMap.put("transactionAffiliation", "&ta");
      paramMap.put("transactionTax", "&tt");
      paramMap.put("transactionShipping", "&ts");
      paramMap.put("transactionTotal", "&tr");
      paramMap.put("transactionCurrency", "&cu");
      h = paramMap;
    }
    return h;
  }
  
  private List<Map<String, String>> d()
  {
    Object localObject = this.l.get("transactionProducts");
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
  
  private Map<String, String> d(Map<String, d.a> paramMap)
  {
    paramMap = (d.a)paramMap.get(g);
    if (paramMap != null) {
      return a(paramMap);
    }
    if (i == null)
    {
      paramMap = new HashMap();
      paramMap.put("name", "&in");
      paramMap.put("sku", "&ic");
      paramMap.put("category", "&iv");
      paramMap.put("price", "&ip");
      paramMap.put("quantity", "&iq");
      paramMap.put("currency", "&cu");
      i = paramMap;
    }
    return i;
  }
  
  public void b(Map<String, d.a> paramMap)
  {
    Tracker localTracker = this.k.a("_GTM_DEFAULT_TRACKER_");
    if (a(paramMap, c))
    {
      localTracker.send(b((d.a)paramMap.get(d)));
      return;
    }
    if (a(paramMap, e))
    {
      a(localTracker, paramMap);
      return;
    }
    as.b("Ignoring unknown tag.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */