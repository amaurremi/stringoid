package com.b.a.a.a;

import org.json.JSONObject;

public class j
{
  String a;
  String b;
  String c;
  String d;
  long e;
  int f;
  String g;
  String h;
  String i;
  String j;
  
  public j(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.i = paramString2;
    paramString1 = new JSONObject(this.i);
    this.b = paramString1.optString("orderId");
    this.c = paramString1.optString("packageName");
    this.d = paramString1.optString("productId");
    this.e = paramString1.optLong("purchaseTime");
    this.f = paramString1.optInt("purchaseState");
    this.g = paramString1.optString("developerPayload");
    this.h = paramString1.optString("token", paramString1.optString("purchaseToken"));
    this.j = paramString3;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public String d()
  {
    return this.h;
  }
  
  public String toString()
  {
    return "PurchaseInfo(type:" + this.a + "):" + this.i;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/b/a/a/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */