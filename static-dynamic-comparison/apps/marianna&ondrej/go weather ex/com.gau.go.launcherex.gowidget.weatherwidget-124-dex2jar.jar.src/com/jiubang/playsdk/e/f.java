package com.jiubang.playsdk.e;

import android.text.TextUtils;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.a.y;
import com.jiubang.playsdk.main.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  public static g a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = paramString.split("_");
    } while ((paramString == null) || (paramString.length != 4));
    return new g(Long.parseLong(paramString[0]), Integer.parseInt(paramString[1]), Integer.parseInt(paramString[2]), Integer.parseInt(paramString[3]));
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    com.jiubang.playsdk.g.d.a("KtpDataLoader", "getClassificationRequestJSON begin >>>>");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    if (aa.a().c(b(paramLong, paramInt1, paramInt2, paramInt3)))
    {
      Object localObject2 = aa.a().a(b(paramLong, paramInt1, paramInt2, paramInt3));
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (paramLong == 0L)
        {
          localObject1 = localObject2;
          if (((d)localObject2).e().size() != 0)
          {
            localArrayList1.add(0, Long.valueOf(0L));
            localArrayList3.add(0, ((d)localObject2).k());
            localArrayList2.add(0, Integer.valueOf(0));
            localObject1 = (c)((d)localObject2).e().get(0);
            localObject1 = aa.a().a(b(((c)localObject1).a(), paramInt1, paramInt2, paramInt3));
          }
        }
        if (localObject1 != null)
        {
          localArrayList1.add(0, Long.valueOf(((d)localObject1).a()));
          localArrayList3.add(0, ((d)localObject1).k());
          localArrayList2.add(0, Integer.valueOf(0));
          if (((d)localObject1).i() == 1)
          {
            localObject1 = ((d)localObject1).e();
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              int i = 0;
              if (i < ((List)localObject1).size())
              {
                localObject2 = (c)((List)localObject1).get(i);
                if (localObject2 != null)
                {
                  d locald = aa.a().a(b(((c)localObject2).a(), 1, paramInt2, paramInt3));
                  if (locald == null) {
                    break label359;
                  }
                  localArrayList1.add(Long.valueOf(locald.a()));
                  localArrayList3.add(locald.k());
                  localArrayList2.add(Integer.valueOf(0));
                }
                for (;;)
                {
                  i += 1;
                  break;
                  label359:
                  localArrayList1.add(Long.valueOf(((c)localObject2).a()));
                  localArrayList3.add("");
                  localArrayList2.add(Integer.valueOf(1));
                }
              }
            }
          }
        }
      }
    }
    if (localArrayList1.size() <= 0)
    {
      localArrayList1.add(Long.valueOf(paramLong));
      localArrayList3.add("");
      localArrayList2.add(Integer.valueOf(1));
    }
    Object localObject1 = a(localArrayList2, localArrayList3, localArrayList1, paramInt2, paramInt1, paramInt3, 0).toString();
    com.jiubang.playsdk.g.d.a("KtpDataLoader", "getClassificationRequestJSON end >>>>");
    return (String)localObject1;
  }
  
  public static String a(h paramh)
  {
    return a(paramh.a(), paramh.b(), paramh.c(), paramh.d());
  }
  
  public static Map a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    com.jiubang.playsdk.g.d.a("KtpDataLoader", "parseClassificationResultJSON begin >>>>");
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject1;
    Object localObject1;
    Object localObject2;
    try
    {
      localJSONObject1 = new JSONObject(paramString);
      localObject1 = localJSONObject1.optJSONObject("result");
      if (localObject1 == null) {
        break label266;
      }
      localObject2 = new j();
      ((j)localObject2).a(((JSONObject)localObject1).toString());
      if (((j)localObject2).a() != 1) {
        break label266;
      }
      localJSONObject1 = localJSONObject1.optJSONObject("types");
      if ((localJSONObject1 == null) || (localJSONObject1.length() == 0))
      {
        if (com.jiubang.playsdk.g.d.a()) {
          com.jiubang.playsdk.g.c.a(paramString.getBytes(), b.b + "/exception.txt");
        }
        throw new y("type字段为空");
      }
    }
    catch (JSONException paramString)
    {
      throw new y(paramString);
    }
    if (localJSONObject1 != null)
    {
      localObject1 = localJSONObject1.keys();
      if (((Iterator)localObject1).hasNext())
      {
        paramString = (String)((Iterator)localObject1).next();
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject(paramString);
        localObject2 = new d();
        ((d)localObject2).a(localJSONObject2.toString());
        ((d)localObject2).b(paramInt1);
        if ((!((d)localObject2).d()) && (paramInt3 != 0)) {}
        for (paramString = b(paramLong, paramInt1, paramInt2, paramInt3);; paramString = b(Integer.parseInt(paramString), paramInt1, paramInt2, paramInt3))
        {
          localHashMap.put(paramString, localObject2);
          break;
        }
      }
    }
    label266:
    com.jiubang.playsdk.g.d.a("KtpDataLoader", "parseClassificationResultJSON edn <<<<<<");
    return localHashMap;
  }
  
  public static JSONObject a(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("packname", paramString);
      localJSONObject.put("extra", paramInt1);
      localJSONObject.put("phead", i.a(aa.a().d(), "6.3", paramInt2, 0, aa.a().b(aa.a().d())));
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localJSONObject;
  }
  
  private static JSONObject a(List paramList1, List paramList2, List paramList3, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    JSONObject localJSONObject1 = new JSONObject();
    if ((paramList1 == null) || (paramList2 == null) || (paramList3 == null)) {
      return localJSONObject1;
    }
    try
    {
      int j = paramList3.size();
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("typeid", paramList3.get(i));
        localJSONObject2.put("itp", paramInt3);
        localJSONObject2.put("must", paramList1.get(i));
        localJSONObject2.put("mark", paramList2.get(i));
        localJSONObject2.put("pageid", paramInt2);
        localJSONObject2.put("access", paramInt1);
        localJSONArray.put(localJSONObject2);
        i += 1;
      }
      localJSONObject1.put("phead", i.a(aa.a().d(), "6.3", aa.a().e(), paramInt4, aa.a().b(aa.a().d())));
      localJSONObject1.put("reqs", localJSONArray);
      return localJSONObject1;
    }
    catch (JSONException paramList1)
    {
      paramList1.printStackTrace();
    }
    return localJSONObject1;
  }
  
  public static com.jiubang.playsdk.a.a.c b(String paramString)
  {
    com.jiubang.playsdk.a.a.c localc = new com.jiubang.playsdk.a.a.c();
    Object localObject2;
    try
    {
      localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).optJSONObject("result");
      if (paramString == null) {
        break label172;
      }
      localObject2 = new j();
      ((j)localObject2).a(paramString.toString());
      if (((j)localObject2).a() != 1) {
        break label172;
      }
      paramString = ((JSONObject)localObject1).optJSONArray("apps");
      localc.b = ((JSONObject)localObject1).optInt("type");
      if ((paramString == null) || (paramString.length() == 0)) {
        throw new y("appinfo字段为空");
      }
    }
    catch (JSONException paramString)
    {
      throw new y(paramString);
    }
    Object localObject1 = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < paramString.length())
      {
        localObject2 = paramString.getJSONObject(i);
        if (localObject2 != null)
        {
          e locale = new e();
          locale.b(((JSONObject)localObject2).toString());
          ((List)localObject1).add(locale);
        }
      }
      else
      {
        localc.a = ((List)localObject1);
        label172:
        return localc;
      }
      i += 1;
    }
  }
  
  public static String b(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    return paramLong + "_" + paramInt1 + "_" + paramInt2 + "_" + paramInt3;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/e/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */