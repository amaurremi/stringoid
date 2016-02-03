package com.gtp.go.weather.sharephoto.view;

import android.view.View;
import com.a.a.s;

public class b
{
  public static void a(d paramd, View paramView)
  {
    paramView = s.a(new PropertyHeightAnimWrapper(paramView), "height", new int[] { paramView.getHeight(), 0 });
    paramView.b(500L);
    if (paramd != null) {
      paramView.a(new c(paramd));
    }
    paramView.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/view/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */