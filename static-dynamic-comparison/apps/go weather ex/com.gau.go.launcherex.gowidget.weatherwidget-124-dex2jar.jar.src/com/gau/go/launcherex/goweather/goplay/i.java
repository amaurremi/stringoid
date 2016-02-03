package com.gau.go.launcherex.goweather.goplay;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import com.gau.go.launcherex.goweather.livewallpaper.b.h;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import com.gau.go.launcherex.gowidget.weather.globaltheme.view.a.b;
import com.gau.go.launcherex.gowidget.weather.globaltheme.view.a.y;
import com.gau.go.launcherex.gowidget.weather.view.AppWidgetGuideActivity;
import com.go.weatherex.setting.PersonalizeSettingsActivity;
import com.go.weatherex.themestore.t;
import com.go.weatherex.themestore.u;

public class i
  extends a
  implements b
{
  private LinearLayout a;
  private InstalledAppBackgroundPreviewView b;
  private y c;
  private ThemeDetailActivity d;
  
  private void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, AppWidgetGuideActivity.class));
  }
  
  private void b(Context paramContext)
  {
    paramContext.startActivity(PersonalizeSettingsActivity.a(paramContext, u.c().b));
    paramContext = GoWidgetApplication.c(paramContext.getApplicationContext()).a().edit();
    paramContext.putInt("key_need_recomment_live_wallpaper", 0);
    paramContext.commit();
  }
  
  public View a(Context paramContext, com.jiubang.playsdk.a.a parama)
  {
    e locale = null;
    if (this.b != null)
    {
      this.b.a();
      this.b = null;
    }
    this.b = new InstalledAppBackgroundPreviewView(paramContext);
    if (ThemeDataHandler.a(paramContext) != null) {
      locale = ThemeDataHandler.a(paramContext).a(parama);
    }
    paramContext = this.b.a(paramContext, locale);
    parama = (ViewGroup)paramContext.getParent();
    if (parama != null) {
      parama.removeView(paramContext);
    }
    return paramContext;
  }
  
  public View a(Context paramContext, com.jiubang.playsdk.a.a parama, com.jiubang.playsdk.main.i parami)
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
      ((ImageView)localObject).setImageResource(2130838859);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(parami.density * 22.0F), (int)(parami.density * 22.0F));
      localLayoutParams.setMargins((int)(parami.density * 8.0F), 0, (int)(parami.density * 8.0F), 0);
      this.a.addView((View)localObject, localLayoutParams);
      parami = new TextView(paramContext);
      parami.setTextSize(15.0F);
      parami.setTextColor(paramContext.getResources().getColor(2131361842));
      localObject = new LinearLayout.LayoutParams(-2, -2);
      this.a.addView(parami, (ViewGroup.LayoutParams)localObject);
    }
    this.a.setVisibility(8);
    if (ThemeDataHandler.a(paramContext) != null)
    {
      parama = ThemeDataHandler.a(paramContext).a(parama);
      if (parama != null)
      {
        if (!parama.D()) {
          break label366;
        }
        if (!com.gau.go.launcherex.gowidget.weather.globaltheme.a.a(paramContext))
        {
          this.a.setVisibility(0);
          i = 0;
          if (i < this.a.getChildCount())
          {
            paramContext = this.a.getChildAt(i);
            if (!(paramContext instanceof TextView)) {
              break label357;
            }
            ((TextView)paramContext).setText(2131166510);
          }
          this.a.setOnClickListener(new j(this));
        }
      }
    }
    label357:
    label366:
    label421:
    do
    {
      for (;;)
      {
        if (this.a.getParent() != null) {
          ((ViewGroup)this.a.getParent()).removeView(this.a);
        }
        return this.a;
        i += 1;
        break;
        if (parama.s())
        {
          parama = GoWidgetApplication.c(paramContext.getApplicationContext()).a();
          if (!h.a(paramContext.getApplicationContext())) {
            break label421;
          }
          paramContext = parama.edit();
          paramContext.putInt("key_need_recomment_live_wallpaper", 0);
          paramContext.commit();
        }
      }
    } while (parama.getInt("key_need_recomment_live_wallpaper", 1) != 1);
    this.a.setVisibility(0);
    int i = 0;
    for (;;)
    {
      if (i < this.a.getChildCount())
      {
        paramContext = this.a.getChildAt(i);
        if ((paramContext instanceof TextView)) {
          ((TextView)paramContext).setText(2131166417);
        }
      }
      else
      {
        this.a.setOnClickListener(new k(this));
        break;
      }
      i += 1;
    }
  }
  
  public y a()
  {
    return this.c;
  }
  
  public void a(ThemeDetailActivity paramThemeDetailActivity)
  {
    this.d = paramThemeDetailActivity;
    this.c = new y(this.d);
    this.c.a();
    this.c.a(this);
  }
  
  public void a(e parame) {}
  
  public Context b()
  {
    return this.d;
  }
  
  public void c()
  {
    this.c.b();
    if (this.b != null)
    {
      this.b.a();
      this.b = null;
    }
    this.a = null;
    this.d = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/goplay/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */