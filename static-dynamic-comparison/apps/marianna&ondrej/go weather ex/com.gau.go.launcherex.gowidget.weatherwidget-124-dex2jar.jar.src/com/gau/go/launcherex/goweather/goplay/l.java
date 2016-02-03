package com.gau.go.launcherex.goweather.goplay;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.globaltheme.view.MyCouponsActivity;
import com.gau.go.launcherex.gowidget.weather.view.ThemeSettingActivity;
import com.jiubang.playsdk.main.i;

public class l
  extends a
  implements f
{
  private LinearLayout a;
  private ThemeSettingActivity b;
  
  private void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, MyCouponsActivity.class));
  }
  
  public View a(Context paramContext, i parami)
  {
    if (this.a == null)
    {
      parami = paramContext.getResources().getDisplayMetrics();
      this.a = new LinearLayout(paramContext);
      this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, (int)(34.0F * parami.density)));
      this.a.setBackgroundColor(paramContext.getResources().getColor(2131361841));
      this.a.setOrientation(0);
      this.a.setGravity(16);
      Object localObject = new ImageView(paramContext);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      ((ImageView)localObject).setImageResource(2130837764);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(parami.density * 22.0F), (int)(parami.density * 22.0F));
      localLayoutParams.setMargins((int)(parami.density * 8.0F), 0, (int)(parami.density * 8.0F), 0);
      this.a.addView((View)localObject, localLayoutParams);
      parami = new TextView(paramContext);
      parami.setText(2131166050);
      parami.setTextSize(15.0F);
      parami.setTextColor(paramContext.getResources().getColor(2131361842));
      localObject = new LinearLayout.LayoutParams(-2, -2);
      this.a.addView(parami, (ViewGroup.LayoutParams)localObject);
      this.a.setOnClickListener(new m(this));
    }
    if (this.a.getParent() != null) {
      ((ViewGroup)this.a.getParent()).removeView(this.a);
    }
    if ((ThemeDataHandler.a(paramContext) != null) && (ThemeDataHandler.a(paramContext).a())) {
      this.a.setVisibility(0);
    }
    for (;;)
    {
      return this.a;
      this.a.setVisibility(8);
    }
  }
  
  public void a(ThemeSettingActivity paramThemeSettingActivity)
  {
    this.b = paramThemeSettingActivity;
    ThemeDataHandler.a(this.b.getApplicationContext()).a(this);
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.setVisibility(0);
    }
  }
  
  public void a_() {}
  
  public Context b()
  {
    return this.b;
  }
  
  public void b(String paramString) {}
  
  public void c()
  {
    this.a = null;
    ThemeDataHandler.a(this.b.getApplicationContext()).b(this);
    this.b = null;
  }
  
  public void c(String paramString) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/goplay/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */