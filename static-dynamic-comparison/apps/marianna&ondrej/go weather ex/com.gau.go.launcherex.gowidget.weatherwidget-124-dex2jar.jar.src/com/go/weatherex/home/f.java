package com.go.weatherex.home;

import android.view.View;
import android.widget.ViewSwitcher.ViewFactory;
import com.go.weatherex.viewex.j;

class f
  implements ViewSwitcher.ViewFactory
{
  f(c paramc) {}
  
  public View makeView()
  {
    j localj = new j(this.a.getActivity());
    this.a.a(localj.b, 4, 0);
    return localj;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */