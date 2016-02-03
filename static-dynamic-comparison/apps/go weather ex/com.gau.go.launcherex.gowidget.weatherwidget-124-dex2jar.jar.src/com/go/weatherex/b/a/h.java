package com.go.weatherex.b.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.gau.go.launcherex.gowidget.weather.util.r;

class h
  implements View.OnClickListener
{
  h(g paramg, FrameLayout paramFrameLayout, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    if (!r.a(paramView)) {
      return;
    }
    g.a = true;
    g.a(this.a, g.a(this.c));
    this.b.postDelayed(new i(this), 300L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/b/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */