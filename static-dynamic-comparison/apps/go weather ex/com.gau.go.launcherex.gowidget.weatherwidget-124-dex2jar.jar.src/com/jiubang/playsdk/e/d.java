package com.jiubang.playsdk.e;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  public List a = new ArrayList();
  private long b;
  private String c;
  private int d;
  private String e;
  private int f;
  private int g;
  private int h;
  private int i;
  private List j = new ArrayList();
  private int k;
  private String l;
  
  public long a()
  {
    return this.b;
  }
  
  public e a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < f().size())) {
      return (e)f().get(paramInt);
    }
    return null;
  }
  
  public void a(String paramString)
  {
    int n = 0;
    int m = 0;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.b = paramString.optLong("typeid", 0L);
        this.c = paramString.optString("typename", "");
        this.d = paramString.optInt("hasnew", 0);
        this.e = paramString.optString("mark", "");
        this.f = paramString.optInt("pages", 0);
        this.g = paramString.optInt("pageid", 1);
        this.h = paramString.optInt("datatype", 0);
        this.k = paramString.optInt("feature", 0);
        this.i = paramString.optInt("viewtype", 0);
        this.l = paramString.optString("dependent_app", "");
        JSONObject localJSONObject;
        Object localObject;
        if (this.h == 1)
        {
          paramString = paramString.optJSONArray("typedata");
          if ((paramString != null) && (m < paramString.length()))
          {
            localJSONObject = paramString.getJSONObject(m);
            if (localJSONObject == null) {
              break label300;
            }
            localObject = new c();
            ((c)localObject).a(localJSONObject.toString());
            this.a.add(localObject);
            break label300;
          }
        }
        else if (this.h == 2)
        {
          paramString = paramString.optJSONArray("appdata");
          if (paramString != null)
          {
            m = n;
            if (m < paramString.length())
            {
              localJSONObject = paramString.getJSONObject(m);
              if (localJSONObject != null)
              {
                localObject = new e();
                ((e)localObject).a(this.b);
                ((e)localObject).b(localJSONObject.toString());
                this.j.add(localObject);
              }
              m += 1;
              continue;
            }
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      label300:
      m += 1;
    }
  }
  
  public int b()
  {
    return this.g;
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public boolean d()
  {
    return this.d == 1;
  }
  
  public List e()
  {
    return this.a;
  }
  
  public List f()
  {
    return this.j;
  }
  
  public boolean g()
  {
    return this.h == 1;
  }
  
  public int h()
  {
    return this.a.size();
  }
  
  public int i()
  {
    return this.h;
  }
  
  public int j()
  {
    return this.i;
  }
  
  public String k()
  {
    return this.e;
  }
  
  public String l()
  {
    return this.l;
  }
  
  public JSONObject m()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      int m;
      try
      {
        localJSONObject.put("typeid", this.b);
        localJSONObject.put("typename", this.c);
        localJSONObject.put("hasnew", this.d);
        localJSONObject.put("mark", this.e);
        localJSONObject.put("pages", this.f);
        localJSONObject.put("pageid", this.g);
        localJSONObject.put("datatype", this.h);
        localJSONObject.put("feature", this.k);
        localJSONObject.put("viewtype", this.i);
        localJSONObject.put("dependent_app", this.l);
        JSONArray localJSONArray;
        Object localObject;
        if (this.h == 1)
        {
          localJSONArray = new JSONArray();
          m = 0;
          if (m < this.a.size())
          {
            localObject = (c)this.a.get(m);
            if (localObject != null) {
              localJSONArray.put(((c)localObject).d());
            }
          }
          else
          {
            localJSONObject.put("typedata", localJSONArray);
            return localJSONObject;
          }
        }
        else
        {
          if (this.h != 2) {
            break label280;
          }
          localJSONArray = new JSONArray();
          m = 0;
          if (m < this.j.size())
          {
            localObject = (e)this.j.get(m);
            if (localObject == null) {
              break label282;
            }
            localJSONArray.put(((e)localObject).g());
            break label282;
          }
          localJSONObject.put("appdata", localJSONArray);
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localJSONObject;
      }
      m += 1;
      continue;
      label280:
      return localJSONObject;
      label282:
      m += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */