package com.appflood.c;

import android.content.Context;
import com.appflood.AppFlood.AFRequestDelegate;
import com.appflood.b.b;
import com.appflood.b.b.a;
import com.appflood.e.a;
import com.appflood.e.c;
import com.appflood.e.j;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
{
  private static g l;
  public JSONObject[] a;
  JSONObject[] b;
  JSONObject c;
  JSONObject d;
  public int e = 8000;
  ArrayList<HashMap<String, String>> f = null;
  public ArrayList<HashMap<String, String>> g = null;
  public ArrayList<HashMap<String, String>> h = null;
  boolean i = true;
  boolean j = false;
  private JSONObject[][] k;
  
  public static g a()
  {
    if (l == null) {
      l = new g();
    }
    return l;
  }
  
  static void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return;
    }
    JSONObject[] arrayOfJSONObject = new JSONObject[paramJSONArray.length()];
    int m = 0;
    for (;;)
    {
      if (m < paramJSONArray.length()) {
        try
        {
          arrayOfJSONObject[m] = paramJSONArray.getJSONObject(m);
          m += 1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            j.a(localThrowable, "Failed to get a jsonobject from JsonArray");
          }
        }
      }
    }
    a().b = arrayOfJSONObject;
  }
  
  static void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      d.x = j.a(paramJSONObject, "show_cb_url", null);
      paramJSONObject = j.a(paramJSONObject, "data", null);
    } while (j.a(paramJSONObject));
    paramJSONObject = j.f(paramJSONObject);
    JSONObject[] arrayOfJSONObject = new JSONObject[paramJSONObject.length()];
    int m = 0;
    for (;;)
    {
      if (m < paramJSONObject.length()) {
        try
        {
          arrayOfJSONObject[m] = paramJSONObject.getJSONObject(m);
          m += 1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            j.a(localThrowable, "Failed to get a jsonobject from JsonArray");
          }
        }
      }
    }
    a().a = arrayOfJSONObject;
  }
  
  public final ArrayList<HashMap<String, String>> a(int paramInt)
  {
    if (paramInt == 2) {
      return this.f;
    }
    if (paramInt == 1) {
      return this.h;
    }
    return this.g;
  }
  
  public final void a(final int paramInt, final AppFlood.AFRequestDelegate paramAFRequestDelegate)
  {
    String str;
    for (;;)
    {
      try
      {
        boolean bool = j.a(d.n);
        if (bool) {
          return;
        }
        str = "";
        if (paramInt == 0)
        {
          str = "game";
          new b(d.n + str, null).a(new b.a()
          {
            public final void a(b paramAnonymousb)
            {
              boolean bool = true;
              int i = 0;
              Object localObject1 = paramAnonymousb.c();
              for (;;)
              {
                Object localObject2;
                HashMap localHashMap;
                try
                {
                  localObject1 = j.e((String)localObject1);
                  int j = j.a((JSONObject)localObject1, "ret", -1);
                  new StringBuilder("aaaaaaaaa TYPE = ").append(paramInt).append("  url = ").append(paramAnonymousb.a().toString()).toString();
                  j.a();
                  if (j != 0) {
                    break label681;
                  }
                  paramAnonymousb = g.this;
                  if (j.a((JSONObject)localObject1, "use_default", 0) == 1) {
                    bool = false;
                  }
                  paramAnonymousb.i = bool;
                  paramAnonymousb = "";
                  if (!g.this.i) {
                    paramAnonymousb = j.a((JSONObject)localObject1, "bg_url", "");
                  }
                  if ((paramInt < 3) && (paramInt != 2)) {
                    break label500;
                  }
                  if (g.this.h == null)
                  {
                    g.this.h = new ArrayList();
                    if (g.this.g == null)
                    {
                      g.this.g = new ArrayList();
                      if (paramInt == 2)
                      {
                        if (g.this.f != null) {
                          break label487;
                        }
                        g.this.f = new ArrayList();
                      }
                      localObject1 = j.f(j.a((JSONObject)localObject1, "data", null));
                      if (i >= ((JSONArray)localObject1).length()) {
                        break label642;
                      }
                      localObject2 = ((JSONArray)localObject1).getJSONObject(i);
                      localHashMap = new HashMap();
                      localHashMap.put("name", j.a((JSONObject)localObject2, "name", ""));
                      localHashMap.put("des", j.a((JSONObject)localObject2, "desc", ""));
                      localHashMap.put("click_url", j.a((JSONObject)localObject2, "click_url", ""));
                      localHashMap.put("show_cb_url", j.a((JSONObject)localObject2, "show_cb_url", ""));
                      localHashMap.put("back_url", j.a((JSONObject)localObject2, "back_url", ""));
                      localHashMap.put("icon_url", j.a((JSONObject)localObject2, "icon_url", ""));
                      if ((paramInt != 4) && (paramInt != 3) && (paramInt != 2)) {
                        break label613;
                      }
                      if ((!"game".equals(j.a((JSONObject)localObject2, "app_type", "game"))) || (g.this.g == null)) {
                        break label587;
                      }
                      g.this.g.add(localHashMap);
                      if ((paramInt != 2) || (g.this.f == null)) {
                        break label714;
                      }
                      g.this.f.add(localHashMap);
                      break label714;
                    }
                  }
                  else
                  {
                    g.this.h.clear();
                    continue;
                  }
                  g.this.g.clear();
                }
                catch (JSONException paramAnonymousb)
                {
                  j.a(paramAnonymousb, "Failed to get a JsonArray");
                  return;
                }
                continue;
                label487:
                g.this.f.clear();
                continue;
                label500:
                if (paramInt == 0)
                {
                  if (g.this.g == null) {
                    g.this.g = new ArrayList();
                  } else {
                    g.this.g.clear();
                  }
                }
                else if (g.this.h == null)
                {
                  g.this.h = new ArrayList();
                }
                else
                {
                  g.this.h.clear();
                  continue;
                  label587:
                  if (g.this.h != null)
                  {
                    g.this.h.add(localHashMap);
                    continue;
                    label613:
                    localObject2 = g.this.a(paramInt);
                    if (localObject2 != null)
                    {
                      ((ArrayList)localObject2).add(localHashMap);
                      break label714;
                      label642:
                      if (paramAFRequestDelegate == null) {
                        continue;
                      }
                      paramAFRequestDelegate.onFinish(j.a("result", Integer.valueOf(1)).put("listbgurl", paramAnonymousb).put("type", 8));
                      return;
                      label681:
                      if (paramAFRequestDelegate == null) {
                        continue;
                      }
                      paramAFRequestDelegate.onFinish(j.a("result", Integer.valueOf(0)).put("type", 8));
                      return;
                    }
                    label714:
                    i += 1;
                  }
                }
              }
            }
            
            public final void a(b paramAnonymousb, int paramAnonymousInt)
            {
              paramAFRequestDelegate.onFinish(j.a("result", Integer.valueOf(0)));
            }
          }).f();
          continue;
        }
        if (paramInt != 1) {
          break;
        }
      }
      finally {}
      str = "app";
    }
    for (;;)
    {
      str = "mix";
      break;
      if (paramInt != 4) {
        if (paramInt != 3) {
          break;
        }
      }
    }
  }
  
  public final void a(final int paramInt, final AppFlood.AFRequestDelegate paramAFRequestDelegate, final boolean paramBoolean)
  {
    if (this.k == null) {
      this.k = new JSONObject[2][];
    }
    JSONObject[] arrayOfJSONObject = a().b;
    final JSONObject localJSONObject = j.a("result", Integer.valueOf(1));
    final boolean bool1;
    int m;
    label75:
    label98:
    final boolean bool2;
    if ((arrayOfJSONObject != null) && (arrayOfJSONObject.length > 0) && ((paramInt == 10) || (paramInt == 13)))
    {
      bool1 = true;
      JSONObject[][] arrayOfJSONObject1 = this.k;
      if (paramInt != 17) {
        break label165;
      }
      m = 0;
      if (arrayOfJSONObject1[m] == null) {
        break label177;
      }
      arrayOfJSONObject1 = this.k;
      if (paramInt != 17) {
        break label171;
      }
      m = 0;
      if ((arrayOfJSONObject1[m].length <= 0) || ((paramInt != 16) && (paramInt != 17))) {
        break label177;
      }
      bool2 = true;
      if ((!bool1) && (!bool2)) {
        break label195;
      }
    }
    label165:
    label171:
    label177:
    label195:
    while (((paramInt == 13) && (bool1)) || (j.a(d.k))) {
      try
      {
        localJSONObject.put("array", arrayOfJSONObject);
        if (paramAFRequestDelegate != null) {
          paramAFRequestDelegate.onFinish(localJSONObject);
        }
        if (paramBoolean)
        {
          return;
          bool1 = false;
          break;
          m = 1;
          break label75;
          m = 1;
          break label98;
          bool2 = false;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          j.b(localJSONException, "json error");
        }
      }
    }
    new b(d.l.replace("{1}", paramInt), null).a(new b.a()
    {
      public final void a(b paramAnonymousb)
      {
        boolean bool1 = true;
        boolean bool2 = false;
        paramAnonymousb = j.e(paramAnonymousb.c());
        int i = j.a(paramAnonymousb, "ret", -1);
        Object localObject = j.f(j.a(paramAnonymousb, "data", null));
        if (i == 0)
        {
          paramAnonymousb = new JSONObject[((JSONArray)localObject).length()];
          i = 0;
          for (;;)
          {
            if (i < ((JSONArray)localObject).length()) {
              try
              {
                paramAnonymousb[i] = ((JSONArray)localObject).getJSONObject(i);
                i += 1;
              }
              catch (Throwable localThrowable)
              {
                for (;;)
                {
                  j.a(localThrowable, "Failed to get a jsonobject from JsonArray");
                }
              }
            }
          }
          if (bool1) {
            g.a().b = paramAnonymousb;
          }
        }
        for (;;)
        {
          return;
          if (bool2)
          {
            localObject = g.this;
            bool1 = bool2;
            if (paramInt == 17) {
              bool1 = true;
            }
            ((g)localObject).a(bool1, paramAnonymousb);
            return;
          }
          if (paramBoolean)
          {
            localObject = g.this;
            if (paramInt != 17) {
              break label196;
            }
            ((g)localObject).a(bool1, paramAnonymousb);
          }
          try
          {
            localJSONObject.put("array", paramAnonymousb);
            if (paramAFRequestDelegate == null) {
              continue;
            }
            paramAFRequestDelegate.onFinish(localJSONObject);
            return;
            label196:
            bool1 = false;
          }
          catch (JSONException paramAnonymousb)
          {
            for (;;)
            {
              j.b(paramAnonymousb, "json error");
            }
          }
          if (paramAFRequestDelegate != null) {
            try
            {
              localJSONObject.put("result", 0);
              if (paramAFRequestDelegate != null)
              {
                paramAFRequestDelegate.onFinish(localJSONObject);
                return;
              }
            }
            catch (JSONException paramAnonymousb)
            {
              j.b(paramAnonymousb, "json error");
            }
          }
        }
      }
      
      public final void a(b paramAnonymousb, int paramAnonymousInt)
      {
        if ((!bool1) && (!bool2)) {
          f.a(new Runnable()
          {
            public final void run()
            {
              try
              {
                if (g.3.this.b != null)
                {
                  g.3.this.a.put("result", 0);
                  g.3.this.b.onFinish(g.3.this.a);
                }
                return;
              }
              catch (Throwable localThrowable) {}
            }
          });
        }
      }
    }).f();
  }
  
  public final void a(final Context paramContext)
  {
    new StringBuilder("send refer info refer =  ").append(c.z).toString();
    j.a();
    if ((j.a(c.z)) || (this.j) || (j.a(d.s))) {
      return;
    }
    this.j = true;
    b localb = new b(d.s + URLEncoder.encode(c.z));
    localb.a(new b.a()
    {
      public final void a(b paramAnonymousb)
      {
        a.b(paramContext, "google_refer");
        c.z = null;
        g.this.j = false;
      }
      
      public final void a(b paramAnonymousb, int paramAnonymousInt)
      {
        g.this.j = false;
      }
    });
    localb.b(false);
  }
  
  public final void a(boolean paramBoolean, JSONObject[] paramArrayOfJSONObject)
  {
    JSONObject[][] arrayOfJSONObject = this.k;
    if (paramBoolean) {}
    for (int m = 0;; m = 1)
    {
      arrayOfJSONObject[m] = paramArrayOfJSONObject;
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */