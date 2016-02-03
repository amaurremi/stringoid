package com.gau.go.launcherex.gowidget.weather.systemwidget.configure;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import java.util.List;

class f
  extends BaseAdapter
{
  public f(e parame) {}
  
  private int a(int paramInt)
  {
    switch (paramInt % 2)
    {
    case 0: 
    default: 
      return 2130838877;
    }
    return 2130838875;
  }
  
  public int getCount()
  {
    if (e.a(this.a) == null) {
      return 0;
    }
    return e.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    if (e.a(this.a) == null) {
      return null;
    }
    return e.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = e.b(this.a).inflate(2130903302, null);
      paramViewGroup = new h();
      paramViewGroup.a = ((ViewGroup)paramView.findViewById(2131231945));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131231949));
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131231946));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131231947));
      paramViewGroup.e = ((ImageView)paramView.findViewById(2131231948));
      paramView.setTag(paramViewGroup);
      paramViewGroup.c.setBackgroundResource(a(paramInt));
      localObject = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)e.a(this.a).get(paramInt);
      paramViewGroup.f = ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject);
      paramViewGroup.g = paramInt;
      ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject).a(e.c(this.a));
      Drawable localDrawable = ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject).a(e.d(this.a));
      ImageView.ScaleType localScaleType = ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject).r();
      if (localDrawable == null) {
        break label274;
      }
      if (localScaleType != null) {
        paramViewGroup.d.setScaleType(localScaleType);
      }
      paramViewGroup.d.setImageDrawable(localDrawable);
      label198:
      if (!((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject).n()) {
        break label286;
      }
      paramViewGroup.e.setImageResource(2130838883);
      paramViewGroup.e.setVisibility(0);
      label223:
      if (!((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject).m()) {
        break label395;
      }
      paramViewGroup.b.setVisibility(0);
    }
    for (;;)
    {
      localObject = new g(this, paramViewGroup, (com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject);
      paramViewGroup.a.setOnClickListener((View.OnClickListener)localObject);
      return paramView;
      paramViewGroup = (h)paramView.getTag();
      break;
      label274:
      paramViewGroup.d.setImageResource(2130838878);
      break label198;
      label286:
      if ((((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject).l() == 2) && (!GoWidgetApplication.b(e.d(this.a)).b()))
      {
        paramViewGroup.e.setImageResource(2130838882);
        paramViewGroup.e.setVisibility(0);
        break label223;
      }
      if ((((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject).l() == 3) && (!((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject).g()) && (((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject).e()) && (((com.gau.go.launcherex.gowidget.weather.globaltheme.b.e)localObject).d()))
      {
        paramViewGroup.e.setImageResource(2130837768);
        paramViewGroup.e.setVisibility(0);
        break label223;
      }
      paramViewGroup.e.setVisibility(4);
      break label223;
      label395:
      paramViewGroup.b.setVisibility(4);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/configure/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */