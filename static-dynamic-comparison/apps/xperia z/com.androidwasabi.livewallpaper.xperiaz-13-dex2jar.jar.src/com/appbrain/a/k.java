package com.appbrain.a;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.appbrain.e.ap;

final class k
  implements View.OnClickListener
{
  k(j paramj) {}
  
  public final void onClick(View paramView)
  {
    j.a(this.a);
    x.a(j.b(this.a));
    Activity localActivity = j.c(this.a);
    if (j.d(this.a)) {}
    for (paramView = ap.d;; paramView = ap.c)
    {
      a.a(localActivity, paramView, j.e(this.a));
      j.c(this.a).finish();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */