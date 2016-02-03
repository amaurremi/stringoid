package com.go.weatherex.themestore;

import android.view.View;
import android.view.View.OnClickListener;
import com.go.weatherex.viewex.SlidingTabStrip;

class b
  implements View.OnClickListener
{
  b(a parama) {}
  
  public void onClick(View paramView)
  {
    if (a.a(this.a) == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < a.b(this.a).getChildCount())
      {
        if (paramView == a.b(this.a).getChildAt(i))
        {
          a.a(this.a).a(paramView, i);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */