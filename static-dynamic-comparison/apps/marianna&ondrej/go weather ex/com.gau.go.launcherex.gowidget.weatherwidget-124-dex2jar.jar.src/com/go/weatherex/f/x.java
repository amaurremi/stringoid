package com.go.weatherex.f;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

class x
  implements View.OnClickListener
{
  x(t paramt, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!t.a(this.b).equals(t.l(this.b)))
    {
      t.a(this.b, t.l(this.b));
      int i = t.m(this.b).getChildCount() - this.a - 1;
      if (i > 0) {
        t.m(this.b).removeViews(this.a + 1, i);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */