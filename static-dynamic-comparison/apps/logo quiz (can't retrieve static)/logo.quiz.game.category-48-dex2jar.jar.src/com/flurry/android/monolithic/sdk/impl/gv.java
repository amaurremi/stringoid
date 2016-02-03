package com.flurry.android.monolithic.sdk.impl;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

final class gv
  implements hz
{
  gv(HashMap paramHashMap, gx paramgx, fr paramfr) {}
  
  public void a(ft paramft)
  {
    ja.a(3, "FlurryAppCloudRequestManager", "RELOGIN SUCCEED, new APPCLOUD_USER_SESSION = " + gr.a);
    this.a.remove(gr.a());
    gr.a(this.a);
    switch (gw.a[this.b.ordinal()])
    {
    default: 
      return;
    case 1: 
      gr.b().submit(new hf(this.a));
      return;
    case 2: 
      gr.b().submit(new hg(this.a));
      return;
    }
    gr.b().submit(new gy(this.a));
  }
  
  public void a(hy paramhy)
  {
    ja.a(3, "FlurryAppCloudRequestManager", "RELOGIN FAILED DUE TO : " + paramhy.a() + " : " + paramhy.b());
    ft.a(null);
    try
    {
      paramhy = new fq(new JSONObject("{code:\"400\",note:\"invalid user session\"}"));
      this.c.a(paramhy);
      return;
    }
    catch (JSONException paramhy)
    {
      ja.a(6, "FlurryAppCloudRequestManager", "checkForTokenError onError JSONException: ", paramhy);
      return;
    }
    catch (Exception paramhy)
    {
      ja.a(6, "FlurryAppCloudRequestManager", "checkForTokenError onError Exception: ", paramhy);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/gv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */