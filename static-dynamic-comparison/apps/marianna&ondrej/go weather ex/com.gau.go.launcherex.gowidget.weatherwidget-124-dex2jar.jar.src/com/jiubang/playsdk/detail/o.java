package com.jiubang.playsdk.detail;

import com.android.a.aa;
import com.jiubang.playsdk.a.a.c;
import com.jiubang.playsdk.a.k;
import com.jiubang.playsdk.views.HorizontalListView;
import java.util.List;

class o
  implements k
{
  o(ThemePreviewLastItemView paramThemePreviewLastItemView) {}
  
  public void a(aa paramaa)
  {
    ThemePreviewLastItemView.a(this.a);
  }
  
  public void a(c paramc)
  {
    if ((paramc == null) || (paramc.a == null) || (paramc.a.isEmpty()))
    {
      ThemePreviewLastItemView.a(this.a);
      return;
    }
    ThemePreviewLastItemView.b(this.a);
    ThemePreviewLastItemView.c(this.a).a(new p(this.a, this.a.getContext(), paramc.a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */