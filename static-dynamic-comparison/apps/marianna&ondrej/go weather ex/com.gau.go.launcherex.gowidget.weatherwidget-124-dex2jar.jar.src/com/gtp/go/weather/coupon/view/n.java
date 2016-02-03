package com.gtp.go.weather.coupon.view;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ListView;
import com.gtp.go.weather.coupon.b.b;
import com.gtp.go.weather.sharephoto.photo.e;

class n
  implements e
{
  n(k paramk, b paramb) {}
  
  public void a(Drawable paramDrawable, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = (ImageView)CouponsActivity.h(this.b.a).findViewWithTag(paramString2);
    if (paramString1 != null)
    {
      if (paramDrawable != null) {
        paramString1.setImageDrawable(paramDrawable);
      }
    }
    else {
      return;
    }
    paramString1.setImageResource(2130838889);
    CouponsActivity.b(this.b.a, this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/view/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */