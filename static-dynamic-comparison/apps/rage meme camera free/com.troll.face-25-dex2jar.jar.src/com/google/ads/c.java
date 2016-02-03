package com.google.ads;

import com.google.ads.internal.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private static final Map<String, AdSize> a = Collections.unmodifiableMap(new HashMap() {});
  private final String b;
  private final String c;
  private final List<a> d;
  private final Integer e;
  private final Integer f;
  private final List<String> g;
  private final List<String> h;
  private final List<String> i;
  
  private c(String paramString1, String paramString2, List<a> paramList, Integer paramInteger1, Integer paramInteger2, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    com.google.ads.util.a.a(paramString1);
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramList;
    this.e = paramInteger1;
    this.f = paramInteger2;
    this.g = paramList1;
    this.h = paramList2;
    this.i = paramList3;
  }
  
  private static a a(JSONObject paramJSONObject)
    throws JSONException
  {
    String str1 = paramJSONObject.getString("id");
    String str2 = paramJSONObject.optString("allocation_id", null);
    Object localObject = paramJSONObject.getJSONArray("adapters");
    ArrayList localArrayList = new ArrayList(((JSONArray)localObject).length());
    int j = 0;
    while (j < ((JSONArray)localObject).length())
    {
      localArrayList.add(((JSONArray)localObject).getString(j));
      j += 1;
    }
    List localList = a(paramJSONObject, "imp_urls");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
    paramJSONObject = new HashMap(0);
    if (localJSONObject != null)
    {
      localObject = new HashMap(localJSONObject.length());
      Iterator localIterator = localJSONObject.keys();
      for (;;)
      {
        paramJSONObject = (JSONObject)localObject;
        if (!localIterator.hasNext()) {
          break;
        }
        paramJSONObject = (String)localIterator.next();
        ((HashMap)localObject).put(paramJSONObject, localJSONObject.getString(paramJSONObject));
      }
    }
    return new a(str2, str1, localArrayList, localList, paramJSONObject);
  }
  
  public static c a(String paramString)
    throws JSONException
  {
    Integer localInteger = null;
    paramString = new JSONObject(paramString);
    String str2 = paramString.getString("qdata");
    if (paramString.has("ad_type")) {}
    Object localObject1;
    ArrayList localArrayList;
    for (String str1 = paramString.getString("ad_type");; str1 = null)
    {
      localObject1 = paramString.getJSONArray("ad_networks");
      localArrayList = new ArrayList(((JSONArray)localObject1).length());
      int j = 0;
      while (j < ((JSONArray)localObject1).length())
      {
        localArrayList.add(a(((JSONArray)localObject1).getJSONObject(j)));
        j += 1;
      }
    }
    Object localObject2 = paramString.optJSONObject("settings");
    List localList;
    if (localObject2 != null) {
      if (((JSONObject)localObject2).has("refresh"))
      {
        paramString = Integer.valueOf(((JSONObject)localObject2).getInt("refresh"));
        if (((JSONObject)localObject2).has("ad_network_timeout_millis")) {
          localInteger = Integer.valueOf(((JSONObject)localObject2).getInt("ad_network_timeout_millis"));
        }
        localObject1 = a((JSONObject)localObject2, "imp_urls");
        localList = a((JSONObject)localObject2, "click_urls");
        localObject2 = a((JSONObject)localObject2, "nofill_urls");
      }
    }
    for (;;)
    {
      return new c(str2, str1, localArrayList, paramString, localInteger, (List)localObject1, localList, (List)localObject2);
      paramString = null;
      break;
      localObject2 = null;
      localObject1 = null;
      localList = null;
      localInteger = null;
      paramString = null;
    }
  }
  
  private static List<String> a(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject != null)
    {
      paramString = new ArrayList(paramJSONObject.length());
      int j = 0;
      while (j < paramJSONObject.length())
      {
        paramString.add(paramJSONObject.getString(j));
        j += 1;
      }
      return paramString;
    }
    return null;
  }
  
  public boolean a()
  {
    return this.f != null;
  }
  
  public int b()
  {
    return this.f.intValue();
  }
  
  public String c()
  {
    return this.b;
  }
  
  public boolean d()
  {
    return this.e != null;
  }
  
  public int e()
  {
    return this.e.intValue();
  }
  
  public List<a> f()
  {
    return this.d;
  }
  
  public List<String> g()
  {
    return this.g;
  }
  
  public List<String> h()
  {
    return this.h;
  }
  
  public List<String> i()
  {
    return this.i;
  }
  
  public h j()
  {
    if (this.c == null) {
      return null;
    }
    if ("interstitial".equals(this.c)) {
      return h.a;
    }
    AdSize localAdSize = (AdSize)a.get(this.c);
    if (localAdSize != null) {
      return h.a(localAdSize);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/google/ads/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */