package com.vungle.sdk;

import android.content.Context;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import org.json.JSONException;
import org.json.JSONObject;

final class k
{
  int a;
  int b;
  String c = "";
  boolean d = false;
  a e;
  private String f;
  private String g;
  private final String h;
  private String i;
  private c j = null;
  
  public k(String paramString)
  {
    this.c = paramString;
    this.f = ba.c(ak.e());
    this.h = ba.a(ak.e());
    this.g = ba.a();
    this.j = new c();
  }
  
  public final String a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("campaign", this.e.g.replace('_', '|'));
      paramJSONObject.put("app_id", this.e.e);
      paramJSONObject.put("url", this.e.b);
      if (this.e.a != null) {
        paramJSONObject.put("id", this.e.a);
      }
      paramJSONObject.put("incentivized", ak.D);
      if ((ak.D) && (ak.E != null)) {
        paramJSONObject.put("name", ak.E);
      }
      paramJSONObject = b(paramJSONObject);
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      av.a(e.u, "JSONException", paramJSONObject);
    }
    return null;
  }
  
  public final String b(JSONObject paramJSONObject)
  {
    int k = 1;
    JSONObject localJSONObject1 = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject1 = new JSONObject();
    }
    try
    {
      localJSONObject2 = new JSONObject();
      localJSONObject3 = new JSONObject();
      localJSONObject4 = new JSONObject();
      paramJSONObject = new JSONObject();
      localJSONObject2.put("osVersion", Build.VERSION.RELEASE);
      localJSONObject2.put("platform", "android");
      this.d = aj.a();
      if (!this.d) {
        break label513;
      }
      localJSONObject2.put("isSdCardAvailable", k);
      ba.h(ak.e());
      paramJSONObject.put("width", ak.x);
      paramJSONObject.put("height", ak.y);
      localJSONObject2.put("dim", paramJSONObject);
      Object localObject = ak.e();
      paramJSONObject = e.B;
      localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
      if ((localObject == null) || (((ConnectivityManager)localObject).getActiveNetworkInfo() == null)) {
        break label562;
      }
      switch (((ConnectivityManager)localObject).getActiveNetworkInfo().getType())
      {
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        JSONObject localJSONObject2;
        JSONObject localJSONObject3;
        JSONObject localJSONObject4;
        label208:
        av.a(e.u, "JSONException", paramJSONObject);
        continue;
        continue;
        paramJSONObject = "mobile";
      }
    }
    this.i = paramJSONObject;
    localJSONObject2.put("connection", this.i);
    paramJSONObject = (AudioManager)ak.e().getSystemService("audio");
    localJSONObject2.put("volume", paramJSONObject.getStreamVolume(3) / paramJSONObject.getStreamMaxVolume(3));
    localJSONObject2.put("soundEnabled", ak.s);
    localJSONObject2.put("mac", this.h);
    localJSONObject2.put("model", ba.d());
    if ("NATIVE".equals("CORONA")) {
      localJSONObject2.put("corona", true);
    }
    for (;;)
    {
      paramJSONObject = ba.d(ak.e());
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {
        localJSONObject2.put("networkOperator", paramJSONObject);
      }
      if (!ba.b(this.g)) {
        localJSONObject2.put("serial", this.g);
      }
      localJSONObject3.put("gender", VunglePub.Gender.toString(this.a));
      localJSONObject3.put("age", this.b);
      localJSONObject4.put("lat", this.j.a);
      localJSONObject4.put("long", this.j.b);
      localJSONObject3.put("location", localJSONObject4);
      localJSONObject1.put("deviceInfo", localJSONObject2);
      localJSONObject1.put("demo", localJSONObject3);
      localJSONObject1.put("pubAppId", this.c);
      paramJSONObject = ay.g();
      if (paramJSONObject != null) {
        localJSONObject1.put("lastError", paramJSONObject);
      }
      localJSONObject1.put("isu", this.f);
      new StringBuilder("requestJSON : ").append(localJSONObject1.toString(3));
      return localJSONObject1.toString();
      label513:
      k = 0;
      break;
      paramJSONObject = "wifi";
      break label208;
      if ("NATIVE".equals("ADOBE_AIR")) {
        localJSONObject2.put("adobeAir", true);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */