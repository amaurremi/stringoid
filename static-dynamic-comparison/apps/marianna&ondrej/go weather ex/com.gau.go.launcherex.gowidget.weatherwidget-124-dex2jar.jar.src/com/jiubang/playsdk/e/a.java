package com.jiubang.playsdk.e;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends b
  implements Serializable
{
  public long a = 0L;
  public int b = 0;
  private long c;
  private String d;
  private String e;
  private String f;
  private int g;
  private String h;
  private int i;
  private String j;
  private int k;
  private String l;
  private String m;
  private String n;
  private int o = 1;
  private String p = null;
  
  public long a()
  {
    return this.a;
  }
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      this.c = paramString.optLong("appid", 0L);
      this.d = paramString.optString("packname", "");
      this.e = paramString.optString("name", "");
      this.f = paramString.optString("icon", "");
      this.g = paramString.optInt("tag", 0);
      this.h = paramString.optString("pics", "");
      this.i = paramString.optInt("isfree", 0);
      this.j = paramString.optString("paytype", "");
      this.k = paramString.optInt("downloadtype", 0);
      this.l = paramString.optString("downloadurl", "");
      this.m = paramString.optString("ficon", "");
      this.n = paramString.optString("dependent_app", "");
      this.b = paramString.optInt("issupport_coupons", 0);
      this.o = paramString.optInt("purchase_process", 1);
      this.p = paramString.optString("summary");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public long b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public int f()
  {
    return this.g;
  }
  
  public String g()
  {
    return this.h;
  }
  
  public int h()
  {
    return this.i;
  }
  
  public int i()
  {
    return this.k;
  }
  
  public String j()
  {
    return this.l;
  }
  
  public String k()
  {
    return this.p;
  }
  
  public String l()
  {
    return this.m;
  }
  
  public boolean m()
  {
    if (this.j != null) {
      return this.j.contains("2");
    }
    return false;
  }
  
  public boolean n()
  {
    if (this.j != null) {
      return this.j.contains("1");
    }
    return false;
  }
  
  public boolean o()
  {
    if (this.j != null) {
      return this.j.contains("7");
    }
    return false;
  }
  
  public String p()
  {
    return this.n;
  }
  
  public boolean q()
  {
    return this.b == 1;
  }
  
  public JSONObject r()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", this.c);
      localJSONObject.put("packname", this.d);
      localJSONObject.put("name", this.e);
      localJSONObject.put("icon", this.f);
      localJSONObject.put("tag", this.g);
      localJSONObject.put("pics", this.h);
      localJSONObject.put("isfree", this.i);
      localJSONObject.put("paytype", this.j);
      localJSONObject.put("downloadtype", this.k);
      localJSONObject.put("downloadurl", this.l);
      localJSONObject.put("ficon", this.m);
      localJSONObject.put("dependent_app", this.n);
      localJSONObject.put("issupport_coupons", this.b);
      localJSONObject.put("purchase_process", this.o);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public int s()
  {
    if (m()) {
      return 2;
    }
    if (o()) {
      return 7;
    }
    return 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */