package com.jtpgodorncrqoeurl;

import android.view.animation.Animation;
import org.json.JSONObject;

final class l
  implements Runnable
{
  l(AdController paramAdController) {}
  
  public final void run()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = AdController.o(this.a).getString("windowcloseeffect");
      localObject2 = AdController.a(this.a, (String)localObject2, true);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (localObject1 != null)
    {
      ((Animation)localObject1).setAnimationListener(new m(this));
      AdController.p(this.a).startAnimation((Animation)localObject1);
      return;
    }
    if (AdController.p(this.a) != null)
    {
      AdController.a(this.a, AdController.p(this.a));
      return;
    }
    AdController.a(this.a, this.a.b);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */