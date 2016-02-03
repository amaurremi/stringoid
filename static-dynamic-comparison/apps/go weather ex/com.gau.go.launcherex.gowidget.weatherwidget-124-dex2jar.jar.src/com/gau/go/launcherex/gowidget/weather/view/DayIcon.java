package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DayIcon
  extends LinearLayout
{
  private TextView a;
  private ImageView b;
  
  public DayIcon(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.b.setImageDrawable(paramDrawable);
  }
  
  public void a(String paramString)
  {
    this.a.setText(paramString);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((TextView)findViewById(2131230835));
    this.b = ((ImageView)findViewById(2131230829));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/DayIcon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */