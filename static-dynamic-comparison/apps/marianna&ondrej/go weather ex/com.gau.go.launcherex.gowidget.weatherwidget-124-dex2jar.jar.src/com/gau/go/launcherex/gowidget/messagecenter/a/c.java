package com.gau.go.launcherex.gowidget.messagecenter.a;

import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private Vector a = new Vector();
  
  private String a(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null)) {
      return null;
    }
    return paramJSONObject.optString(paramString, null);
  }
  
  private JSONArray b(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null)) {
      return null;
    }
    return paramJSONObject.optJSONArray(paramString);
  }
  
  private int c(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject == null) || (paramString == null)) {
      return -1;
    }
    return paramJSONObject.optInt(paramString, -1);
  }
  
  public Vector a()
  {
    return this.a;
  }
  
  public void a(JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject2 = (JSONObject)paramJSONArray.opt(i);
      if (localObject2 != null)
      {
        Object localObject1 = a((JSONObject)localObject2, "id");
        Object localObject3 = a((JSONObject)localObject2, "title");
        int j = c((JSONObject)localObject2, "type");
        int k = c((JSONObject)localObject2, "viewtype");
        Object localObject4 = a((JSONObject)localObject2, "time");
        localObject1 = new d("go" + (String)localObject1, (String)localObject3, j, k, (String)localObject4);
        ((d)localObject1).f = a((JSONObject)localObject2, "stime_start");
        ((d)localObject1).g = a((JSONObject)localObject2, "stime_end");
        ((d)localObject1).i = a((JSONObject)localObject2, "intro");
        ((d)localObject1).j = c((JSONObject)localObject2, "acttype");
        ((d)localObject1).k = a((JSONObject)localObject2, "actvalue");
        ((d)localObject1).o = a((JSONObject)localObject2, "packagename");
        ((d)localObject1).p = a((JSONObject)localObject2, "mapid");
        a((JSONObject)localObject2, "ztime");
        ((d)localObject1).t = 0L;
        if (j == 3) {
          ((d)localObject1).e = a((JSONObject)localObject2, "msgurl");
        }
        if (j == 4)
        {
          ((d)localObject1).e = a((JSONObject)localObject2, "msgurl");
          ((d)localObject1).a(((JSONObject)localObject2).optJSONArray("yhjs"));
        }
        if (j == 5)
        {
          localObject3 = ((JSONObject)localObject2).optJSONObject("cxj");
          if (localObject3 != null) {
            com.gtp.a.a.b.c.a("MSGCenter", "促销券：" + ((JSONObject)localObject3).toString());
          }
          d.a((d)localObject1, (JSONObject)localObject3);
        }
        if ((k & 0x2) != 0)
        {
          ((d)localObject1).h = a((JSONObject)localObject2, "icon");
          ((d)localObject1).v = c((JSONObject)localObject2, "dynamic");
          ((d)localObject1).w = c((JSONObject)localObject2, "iconpos");
          ((d)localObject1).x = a((JSONObject)localObject2, "fullscreenicon");
        }
        localObject3 = b((JSONObject)localObject2, "filter_pkgs");
        if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
        {
          localObject4 = new StringBuilder();
          j = 0;
          for (;;)
          {
            if (j < ((JSONArray)localObject3).length()) {
              try
              {
                String str = (String)((JSONArray)localObject3).get(j);
                if (!str.equals(""))
                {
                  ((StringBuilder)localObject4).append(str);
                  ((StringBuilder)localObject4).append(",");
                }
                j += 1;
              }
              catch (JSONException localJSONException2)
              {
                for (;;)
                {
                  localJSONException2.printStackTrace();
                }
              }
            }
          }
          ((d)localObject1).m = ((StringBuilder)localObject4).toString();
        }
        localObject2 = b((JSONObject)localObject2, "whitelist");
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          localObject3 = new StringBuilder();
          j = 0;
          for (;;)
          {
            if (j < ((JSONArray)localObject2).length()) {
              try
              {
                localObject4 = (String)((JSONArray)localObject2).get(j);
                if (!((String)localObject4).equals(""))
                {
                  ((StringBuilder)localObject3).append((String)localObject4);
                  ((StringBuilder)localObject3).append(",");
                }
                j += 1;
              }
              catch (JSONException localJSONException1)
              {
                for (;;)
                {
                  localJSONException1.printStackTrace();
                }
              }
            }
          }
          ((d)localObject1).n = ((StringBuilder)localObject3).toString();
        }
        if (!((d)localObject1).a()) {
          this.a.add(localObject1);
        }
      }
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */