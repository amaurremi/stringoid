package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;

class bl
  extends jf
{
  bl(bi parambi, String paramString, Context paramContext, boolean paramBoolean, AdUnit paramAdUnit) {}
  
  public void a()
  {
    String str = this.e.b(this.a);
    if (str != null)
    {
      this.e.a(this.b, str, this.c, this.d);
      return;
    }
    ja.a(5, bi.d(), "Redirect URL could not be found for: " + this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */