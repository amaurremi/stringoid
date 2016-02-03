package com.gau.go.launcherex.gowidget.weather.view.gl;

import android.content.Context;
import com.gau.go.launcherex.gowidget.weather.view.dh;
import com.go.gl.widget.GLTextView;

public class GLGoWidgetThemeEnteranceView
  extends GLWidgetChildView
{
  private GLTextView a = (GLTextView)findViewById(2131232102);
  
  public GLGoWidgetThemeEnteranceView(Context paramContext)
  {
    super(paramContext, dh.b);
    setOnClickListener(new a(this));
  }
  
  public int getContentViewLayoutId()
  {
    return 2130903353;
  }
  
  public GLTextView getTipView()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/gl/GLGoWidgetThemeEnteranceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */