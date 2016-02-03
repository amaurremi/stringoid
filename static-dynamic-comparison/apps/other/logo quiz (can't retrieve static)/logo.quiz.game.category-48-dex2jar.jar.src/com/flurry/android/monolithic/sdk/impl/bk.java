package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.content.Intent;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;

class bk
  extends jf
{
  bk(bi parambi, String paramString, AdUnit paramAdUnit, Context paramContext, boolean paramBoolean) {}
  
  public void a()
  {
    if (this.a != null)
    {
      str = this.b.b().toString();
      if (this.a.startsWith("market://")) {
        this.e.a(this.c, this.a, str);
      }
      do
      {
        return;
        if (this.a.startsWith("http"))
        {
          Intent localIntent = new Intent(ia.a().b(), FlurryFullscreenTakeoverActivity.class);
          localIntent.putExtra("url", this.a);
          if ((this.d) && (je.a(localIntent)))
          {
            this.e.a(this.c, localIntent, str);
            return;
          }
          ja.a(6, bi.d(), "Unable to launch FlurryFullscreenTakeoverActivity, falling back to browser. Fix by declaring this Activity in your AndroidManifest.xml");
          this.e.b(this.c, this.a, str);
          return;
        }
      } while (this.e.b(this.c, this.a, str));
      ja.a(5, bi.d(), "Failed to launch intent for:" + this.a);
      return;
    }
    String str = "Unable to launch intent for: " + this.a;
    ja.a(5, bi.d(), str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */