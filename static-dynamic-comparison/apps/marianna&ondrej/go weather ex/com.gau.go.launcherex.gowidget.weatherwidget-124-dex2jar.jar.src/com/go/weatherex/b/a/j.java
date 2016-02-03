package com.go.weatherex.b.a;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class j
  implements View.OnClickListener
{
  j(g paramg, Activity paramActivity, com.go.weatherex.d.j paramj) {}
  
  public void onClick(View paramView)
  {
    g.a = true;
    paramView = g.c(this.c).keySet().iterator();
    while (paramView.hasNext())
    {
      FrameLayout localFrameLayout = (FrameLayout)paramView.next();
      if (localFrameLayout != null) {
        g.a(localFrameLayout, this.a.getApplicationContext());
      }
    }
    this.b.postDelayed(new k(this), 300L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/b/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */