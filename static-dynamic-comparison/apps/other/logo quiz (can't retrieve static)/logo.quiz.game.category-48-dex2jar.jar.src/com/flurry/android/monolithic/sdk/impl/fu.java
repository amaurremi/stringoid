package com.flurry.android.monolithic.sdk.impl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class fu
  implements fr
{
  fu(String paramString, hz paramhz) {}
  
  public void a(fq paramfq)
    throws Exception
  {
    if (paramfq != null) {
      try
      {
        if (paramfq.a())
        {
          Object localObject = paramfq.b.getJSONArray("set").getJSONObject(0);
          ft localft = new ft((JSONObject)localObject);
          paramfq.a = localft;
          ja.a(4, "AppCloudUser", "Login user" + paramfq.toString());
          ft.a(localft);
          String str1 = ((JSONObject)localObject).getString("_id");
          String str2 = ((JSONObject)localObject).getString("username");
          localObject = ((JSONObject)localObject).getString("email");
          paramfq = paramfq.b.getString("APPCLOUD_USER_SESSION");
          fy.a(str1);
          fy.a(str2, (String)localObject, paramfq);
          fy.b(this.a);
          localft.d();
          this.b.a(localft);
          return;
        }
        this.b.a(new hy(paramfq.d(), paramfq.b()));
        ja.a(4, "AppCloudUser", "Login Fail: " + paramfq.b().toString());
        return;
      }
      catch (JSONException paramfq)
      {
        paramfq.printStackTrace();
        return;
      }
    }
    this.b.a(new hy(400, "Bad response"));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/fu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */