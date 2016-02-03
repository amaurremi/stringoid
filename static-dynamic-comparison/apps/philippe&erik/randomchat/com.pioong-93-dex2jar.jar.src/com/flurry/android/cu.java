package com.flurry.android;

import android.content.Context;
import android.content.Intent;

final class cu
  extends bk
{
  cu(FlurryAds paramFlurryAds, String paramString, AdUnit paramAdUnit, Context paramContext, boolean paramBoolean) {}
  
  public final void a()
  {
    if (this.eS != null)
    {
      str = this.eT.getAdSpace().toString();
      if (this.eS.startsWith("market://")) {
        this.ee.a(this.eO, this.eS, this.eT);
      }
      do
      {
        return;
        if (this.eS.startsWith("http"))
        {
          Intent localIntent = new Intent(this.eO, FlurryFullscreenTakeoverActivity.class);
          localIntent.putExtra("url", this.eS);
          if ((this.eU) && (bd.a(this.eO, localIntent)))
          {
            this.ee.a(this.eO, localIntent, str);
            return;
          }
          db.d(FlurryAds.d, "Unable to launch FlurryFullscreenTakeoverActivity, falling back to browser. Fix by declaring this Activity in your AndroidManifest.xml");
          this.ee.b(this.eO, this.eS, str);
          return;
        }
      } while (this.ee.b(this.eO, this.eS, str));
      db.g(FlurryAds.d, "Failed to launch intent for:" + this.eS);
      return;
    }
    String str = "Unable to launch intent for: " + this.eS;
    db.g(FlurryAds.d, str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */