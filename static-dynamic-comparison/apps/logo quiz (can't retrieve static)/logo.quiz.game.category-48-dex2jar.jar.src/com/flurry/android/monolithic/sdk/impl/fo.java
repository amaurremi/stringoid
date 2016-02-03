package com.flurry.android.monolithic.sdk.impl;

import java.util.HashMap;
import java.util.Vector;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

class fo
  implements fr
{
  fo(fm paramfm, fr paramfr) {}
  
  public void a(fq paramfq)
    throws Exception
  {
    if ((paramfq != null) && (paramfq.a()))
    {
      ft localft = new ft(paramfq.c().getJSONArray("set").getJSONObject(0));
      int i = 0;
      while (i < localft.b().size())
      {
        String str1 = ((NameValuePair)localft.b().get(i)).getName();
        String str2 = ((NameValuePair)localft.b().get(i)).getValue();
        this.b.c.put(str1, str2);
        go.c().a(str1, str2, this.b.a, null);
        i += 1;
      }
    }
    if (this.a != null) {
      this.a.a(paramfq);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/fo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */