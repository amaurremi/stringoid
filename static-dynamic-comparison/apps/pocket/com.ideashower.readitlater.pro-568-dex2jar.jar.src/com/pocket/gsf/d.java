package com.pocket.gsf;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.ideashower.readitlater.a.g;
import com.ideashower.readitlater.util.e;
import com.ideashower.readitlater.util.l;
import com.pocket.p.o;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.json.JSONException;

public class d
{
  private static boolean a = false;
  private static boolean b = false;
  private static HashMap c = new HashMap();
  private static PackageManager d;
  private static ArrayList e = new ArrayList();
  private static ArrayList f = new ArrayList();
  private static ArrayList g = new ArrayList();
  private static ArrayList h = new ArrayList();
  private static ArrayList i = new ArrayList();
  private static ArrayList j = new ArrayList();
  
  public static int a()
  {
    if (e != null) {
      return e.size();
    }
    return -1;
  }
  
  private static ApplicationInfo a(String paramString)
  {
    try
    {
      paramString = d.getApplicationInfo(paramString, 1);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return null;
  }
  
  private static String a(String paramString, Context paramContext)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.contains("R.String")) {
        str = paramContext.getString(paramContext.getResources().getIdentifier(paramString.replace("R.String.", ""), "string", paramContext.getPackageName()));
      }
    }
    return str;
  }
  
  public static ArrayList a(Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (!a) {
      c(paramContext, paramBoolean);
    }
    if (!b) {
      a(paramContext);
    }
    int k = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3;
    do
    {
      if (localArrayList.size() >= 3) {
        break;
      }
      i3 = localArrayList.size();
      int m = i2;
      if (f.size() > i2)
      {
        localArrayList.add(f.get(i2));
        m = i2 + 1;
      }
      i2 = i1;
      if (g.size() > i1)
      {
        localArrayList.add(g.get(i1));
        i2 = i1 + 1;
      }
      i1 = n;
      if (h.size() > n)
      {
        localArrayList.add(h.get(n));
        i1 = n + 1;
      }
      n = k;
      if (i.size() > k)
      {
        localArrayList.add(i.get(k));
        n = k + 1;
      }
      k = n;
      n = i1;
      i1 = i2;
      i2 = m;
    } while (localArrayList.size() != i3);
    if (localArrayList.size() > 3) {
      return new ArrayList(localArrayList.subList(0, 3));
    }
    return localArrayList;
  }
  
  public static void a(Context paramContext)
  {
    d = paramContext.getPackageManager();
    d.getLaunchIntentForPackage("");
    Iterator localIterator = j.iterator();
    while (localIterator.hasNext())
    {
      ApplicationInfo localApplicationInfo = a(((GSFConfiguation)localIterator.next()).a());
      if (localApplicationInfo != null)
      {
        String str = localApplicationInfo.packageName;
        a locala = new a();
        if (str != null)
        {
          locala.a(localApplicationInfo);
          locala.a(str);
          locala.b(paramContext);
        }
        c.put(str, locala);
      }
    }
    b();
    b = true;
  }
  
  private static void a(GSFConfiguation paramGSFConfiguation, a parama, ArrayList paramArrayList)
  {
    if (paramGSFConfiguation.g())
    {
      paramArrayList.add(0, parama);
      return;
    }
    paramArrayList.add(parama);
  }
  
  private static void a(ArrayNode paramArrayNode, boolean paramBoolean, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = paramArrayNode.iterator();
    Object localObject3;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject3 = (JsonNode)((Iterator)localObject1).next();
      localObject2 = new GSFConfiguation();
      if (localObject3 == null) {
        return;
      }
      ((GSFConfiguation)localObject2).a(((JsonNode)localObject3).path("package").getTextValue());
      ((GSFConfiguation)localObject2).a(l.a((JsonNode)localObject3, "id", 0));
      ((GSFConfiguation)localObject2).c(((JsonNode)localObject3).path("category").getTextValue());
      ((GSFConfiguation)localObject2).d(((JsonNode)localObject3).path("thing").getTextValue());
      ((GSFConfiguation)localObject2).a(l.a((JsonNode)localObject3, "support_phone", true), l.a((JsonNode)localObject3, "support_tablet", true));
      if (((JsonNode)localObject3).has("same_as"))
      {
        paramArrayNode = ((JsonNode)localObject3).path("same_as").getTextValue();
        if (localHashMap.containsKey(paramArrayNode))
        {
          k = ((Integer)localHashMap.get(paramArrayNode)).intValue();
          paramArrayNode = (GSFConfiguation)j.get(k);
          ((GSFConfiguation)localObject2).b(paramArrayNode.b());
          ((GSFConfiguation)localObject2).a(paramArrayNode.d());
          ((GSFConfiguation)localObject2).e(paramArrayNode.e());
        }
      }
      for (;;)
      {
        localHashMap.put(((GSFConfiguation)localObject2).a(), Integer.valueOf(j.size()));
        j.add(localObject2);
        break;
        ((GSFConfiguation)localObject2).b(a(((JsonNode)localObject3).path("title").getTextValue(), paramContext));
        paramArrayNode = ((JsonNode)localObject3).path("steps").path("has_overflow");
        if ((paramBoolean) && (paramArrayNode.size() > 0)) {
          paramArrayNode = ((JsonNode)localObject3).path("steps").path("has_overflow");
        }
        while (paramArrayNode != null)
        {
          ArrayList localArrayList = new ArrayList();
          paramArrayNode = paramArrayNode.iterator();
          for (;;)
          {
            if (paramArrayNode.hasNext())
            {
              JsonNode localJsonNode = (JsonNode)paramArrayNode.next();
              localArrayList.add(new GSFDemoStep(a(localJsonNode.path("step").asText(), paramContext), localJsonNode.path("icon").asText()));
              continue;
              paramArrayNode = ((JsonNode)localObject3).path("steps").path("default");
              break;
            }
          }
          ((GSFConfiguation)localObject2).a(localArrayList);
        }
        paramArrayNode = ((JsonNode)localObject3).path("position");
        localObject3 = paramArrayNode.path("has_overflow");
        if ((localObject3 != null) && (((JsonNode)localObject3).getTextValue() != null)) {
          ((GSFConfiguation)localObject2).e(paramArrayNode.path("has_overflow").getTextValue());
        } else {
          ((GSFConfiguation)localObject2).e(paramArrayNode.path("default").getTextValue());
        }
      }
    }
    localObject1 = paramContext.getPackageManager();
    paramContext = o.a(paramContext).iterator();
    int k = 0;
    label495:
    boolean bool;
    while (paramContext.hasNext())
    {
      localObject2 = ((ResolveInfo)paramContext.next()).activityInfo.packageName;
      if (k == 0) {}
      for (bool = true;; bool = false)
      {
        paramArrayNode = (Integer)localHashMap.get(localObject2);
        if (paramArrayNode == null) {
          break label580;
        }
        paramArrayNode = (GSFConfiguation)j.get(paramArrayNode.intValue());
        if (bool) {
          paramArrayNode.a(true);
        }
        k += 1;
        break;
      }
      label580:
      if (((PackageManager)localObject1).getLaunchIntentForPackage((String)localObject2) == null)
      {
        k += 1;
      }
      else
      {
        localObject3 = new GSFConfiguation();
        ((GSFConfiguation)localObject3).c("browser");
        ((GSFConfiguation)localObject3).a((String)localObject2);
        if (!paramBoolean) {
          break label747;
        }
      }
    }
    label747:
    for (paramArrayNode = "bottom";; paramArrayNode = "top")
    {
      ((GSFConfiguation)localObject3).e(paramArrayNode);
      ((GSFConfiguation)localObject3).b(g.a(2131493190));
      paramArrayNode = new ArrayList(3);
      paramArrayNode.add(new GSFDemoStep(g.a(2131493188), "gsf_step_menu"));
      paramArrayNode.add(new GSFDemoStep(g.a(2131493189), null));
      ((GSFConfiguation)localObject3).a(paramArrayNode);
      ((GSFConfiguation)localObject3).a(1);
      ((GSFConfiguation)localObject3).a(bool);
      localHashMap.put(localObject2, Integer.valueOf(j.size()));
      j.add(localObject3);
      k += 1;
      break label495;
      break;
    }
  }
  
  public static ArrayList b(Context paramContext, boolean paramBoolean)
  {
    if (!a) {
      c(paramContext, paramBoolean);
    }
    if (!b) {
      a(paramContext);
    }
    Collections.sort(e);
    return e;
  }
  
  private static void b()
  {
    Iterator localIterator = j.iterator();
    while (localIterator.hasNext())
    {
      GSFConfiguation localGSFConfiguation = (GSFConfiguation)localIterator.next();
      if (localGSFConfiguation.h())
      {
        a locala = (a)c.get(localGSFConfiguation.a());
        if (locala != null)
        {
          locala.a(localGSFConfiguation);
          e.add(locala);
          localGSFConfiguation = locala.a();
          String str = localGSFConfiguation.c();
          if ((localGSFConfiguation != null) && (str != null)) {
            if (str.equals("browser")) {
              a(localGSFConfiguation, locala, f);
            } else if (str.equals("social")) {
              a(localGSFConfiguation, locala, g);
            } else if (str.equals("reader")) {
              a(localGSFConfiguation, locala, h);
            } else if (str.equals("news")) {
              a(localGSFConfiguation, locala, i);
            }
          }
        }
      }
    }
    Collections.sort(e);
  }
  
  private static void c(Context paramContext, boolean paramBoolean)
  {
    localObject3 = null;
    localObject1 = null;
    localObject2 = null;
    try
    {
      InputStream localInputStream = paramContext.getAssets().open("assets-extra/config/walkthrough/apps_ext.json");
      localObject2 = localInputStream;
      localObject3 = localInputStream;
      localObject1 = localInputStream;
      a((ArrayNode)l.a().readTree(localInputStream), paramBoolean, paramContext);
      org.apache.a.b.d.a(localInputStream);
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        localObject1 = localObject2;
        e.a(paramContext);
        org.apache.a.b.d.a((InputStream)localObject2);
      }
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        localObject1 = localObject3;
        e.a(paramContext);
        org.apache.a.b.d.a((InputStream)localObject3);
      }
    }
    finally
    {
      org.apache.a.b.d.a((InputStream)localObject1);
    }
    a = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/pocket/gsf/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */