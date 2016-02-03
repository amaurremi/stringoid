package com.chartboost.sdk;

import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.impl.i;
import com.chartboost.sdk.impl.i.b;
import com.chartboost.sdk.impl.j;
import org.json.JSONObject;

final class d
{
  private static d a = null;
  private i b = new i("https://www.chartboost.com", null);
  
  private static d a()
  {
    if (a == null) {
      a = new d();
    }
    return a;
  }
  
  protected static void a(Chartboost.CBAPIResponseCallback paramCBAPIResponseCallback)
  {
    j localj = new j("api/more");
    localj.a("format", "data");
    a().a(localj, paramCBAPIResponseCallback);
  }
  
  private void a(j paramj, final Chartboost.CBAPIResponseCallback paramCBAPIResponseCallback)
  {
    paramj.a(Chartboost.sharedChartboost().e());
    this.b.a(paramj, new i.b()
    {
      public void a(j paramAnonymousj, CBError paramAnonymousCBError)
      {
        if (paramCBAPIResponseCallback != null) {
          paramCBAPIResponseCallback.onFailure(paramAnonymousCBError.b());
        }
      }
      
      public void a(JSONObject paramAnonymousJSONObject, j paramAnonymousj)
      {
        if (paramCBAPIResponseCallback != null) {
          paramCBAPIResponseCallback.onSuccess(paramAnonymousJSONObject);
        }
      }
    });
  }
  
  protected static void a(String paramString, int paramInt, Chartboost.CBAPIResponseCallback paramCBAPIResponseCallback)
  {
    j localj = new j("api/get_batch");
    localj.a("raw", Integer.valueOf(1));
    localj.a("cache", Integer.valueOf(1));
    if (paramString != null) {
      localj.a("location", paramString);
    }
    int i = paramInt;
    if (paramInt > 10) {
      i = 10;
    }
    localj.a("amount", Integer.valueOf(i));
    a().a(localj, paramCBAPIResponseCallback);
  }
  
  protected static void a(String paramString, Chartboost.CBAPIResponseCallback paramCBAPIResponseCallback)
  {
    j localj = new j("api/get");
    localj.a("raw", Integer.valueOf(1));
    localj.a("cache", Integer.valueOf(1));
    if (paramString != null) {
      localj.a("location", paramString);
    }
    a().a(localj, paramCBAPIResponseCallback);
  }
  
  protected static void b(String paramString, Chartboost.CBAPIResponseCallback paramCBAPIResponseCallback)
  {
    j localj = new j("api/show");
    localj.a("ad_id", paramString);
    a().a(localj, paramCBAPIResponseCallback);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */