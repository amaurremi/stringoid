package com.gau.go.launcherex.gowidget.weather.view;

import android.widget.ImageView;

class r
  implements Runnable
{
  r(AppWidgetGuideActivity paramAppWidgetGuideActivity) {}
  
  public void run()
  {
    ImageView localImageView = (ImageView)this.a.findViewById(2131231064);
    AppWidgetGuideActivity.a(this.a, localImageView);
    localImageView = (ImageView)this.a.findViewById(2131231065);
    AppWidgetGuideActivity.a(this.a, localImageView);
    localImageView = (ImageView)this.a.findViewById(2131231066);
    AppWidgetGuideActivity.a(this.a, localImageView);
    localImageView = (ImageView)this.a.findViewById(2131231068);
    AppWidgetGuideActivity.a(this.a, localImageView);
    localImageView = (ImageView)this.a.findViewById(2131231069);
    AppWidgetGuideActivity.a(this.a, localImageView);
    localImageView = (ImageView)this.a.findViewById(2131231070);
    AppWidgetGuideActivity.a(this.a, localImageView);
    int i = localImageView.getWidth();
    localImageView = (ImageView)this.a.findViewById(2131231072);
    int j = (int)(i / 0.60330576F);
    localImageView.getLayoutParams().height = j;
    localImageView.getLayoutParams().width = i;
    localImageView.requestLayout();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */