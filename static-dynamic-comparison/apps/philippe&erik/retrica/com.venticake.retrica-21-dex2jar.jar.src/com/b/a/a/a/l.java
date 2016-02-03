package com.b.a.a.a;

import org.json.JSONObject;

public class l
{
  String a;
  String b;
  String c;
  String d;
  String e;
  String f;
  String g;
  
  public l(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.g = paramString2;
    paramString1 = new JSONObject(this.g);
    this.b = paramString1.optString("productId");
    this.c = paramString1.optString("type");
    this.d = paramString1.optString("price");
    this.e = paramString1.optString("title");
    this.f = paramString1.optString("description");
  }
  
  public String a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public String toString()
  {
    return "SkuDetails:" + this.g;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/b/a/a/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */