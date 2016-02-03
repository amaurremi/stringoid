package com.flurry.android.monolithic.sdk.impl;

import org.json.JSONException;
import org.json.JSONObject;

class hp
  implements fr
{
  hp(ho paramho) {}
  
  public void a(fq arg1)
    throws Exception
  {
    if (??? != null) {}
    try
    {
      if (???.a())
      {
        ho.a(this.a, ???.c().getString("_id"));
        ja.a(4, "OperationsExecutor", "Created object" + ???.c().getString("_id"));
        ho.a(this.a).a = 701;
        ho.a(this.a).b = ???;
      }
    }
    catch (JSONException ???)
    {
      synchronized (ho.b(this.a))
      {
        for (;;)
        {
          ho.b(this.a).notifyAll();
          return;
          ja.a(4, "OperationsExecutor", "Created object Fail: " + ???.b());
          ho.a(this.a).a = 731;
        }
        ??? = ???;
        ???.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/hp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */