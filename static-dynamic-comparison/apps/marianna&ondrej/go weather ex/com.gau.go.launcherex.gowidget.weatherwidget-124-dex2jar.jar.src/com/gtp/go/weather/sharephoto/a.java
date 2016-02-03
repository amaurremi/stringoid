package com.gtp.go.weather.sharephoto;

import android.view.View;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

class a
  implements ViewSwitcher.ViewFactory
{
  a(PhotoDetailActivity paramPhotoDetailActivity) {}
  
  public View makeView()
  {
    TextView localTextView = new TextView(this.a);
    localTextView.setTextAppearance(this.a, 2131492886);
    return localTextView;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */