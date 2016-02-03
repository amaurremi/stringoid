package com.gau.go.launcherex.gowidget.weather.globalview;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

public class s
  extends f
{
  private ViewGroup b;
  private TextView c;
  private int d;
  
  public s(Activity paramActivity)
  {
    super(paramActivity);
    setContentView(2130903116);
    paramActivity = this.a.getResources().getDisplayMetrics();
    this.d = ((int)(Math.min(paramActivity.widthPixels, paramActivity.heightPixels) - paramActivity.density * 40.0F));
    paramActivity = getWindow().getAttributes();
    paramActivity.width = -2;
    paramActivity.height = -2;
    this.b = ((ViewGroup)findViewById(2131231062));
    this.c = ((TextView)findViewById(2131231257));
  }
  
  public void a(int paramInt)
  {
    this.b.setBackgroundResource(paramInt);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.c.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
    this.c.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getWindow().getAttributes().dimAmount = 1.0F;
      return;
    }
    getWindow().getAttributes().dimAmount = 0.0F;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globalview/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */