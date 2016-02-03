package com.gau.go.launcherex.gowidget.weather.gowidget.configure;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.globaltheme.b.e;
import java.util.List;

class h
  extends BaseAdapter
{
  public h(f paramf) {}
  
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
    if (f.a(this.a) == null) {
      return 0;
    }
    return f.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    if (f.a(this.a) == null) {
      return null;
    }
    return f.a(this.a).get(paramInt);
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
      paramView = f.b(this.a).inflate(2130903302, null);
      paramViewGroup = new j(this.a, null);
      paramViewGroup.a = ((ViewGroup)paramView.findViewById(2131231945));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131231949));
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131231946));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131231947));
      paramViewGroup.e = ((ImageView)paramView.findViewById(2131231948));
      paramView.setTag(paramViewGroup);
      paramViewGroup.c.setBackgroundResource(a(paramInt));
      localObject = (e)f.a(this.a).get(paramInt);
      ((e)localObject).a(f.c(this.a));
      Drawable localDrawable = ((e)localObject).a(f.d(this.a));
      ImageView.ScaleType localScaleType = ((e)localObject).r();
      if (localDrawable == null) {
        break label277;
      }
      if (localScaleType != null) {
        paramViewGroup.d.setScaleType(localScaleType);
      }
      paramViewGroup.d.setImageDrawable(localDrawable);
      label192:
      if (!((e)localObject).n()) {
        break label289;
      }
      paramViewGroup.e.setImageResource(2130838883);
      paramViewGroup.e.setVisibility(0);
      label217:
      if (!((e)localObject).m()) {
        break label398;
      }
      f.a(this.a, (e)localObject);
      paramViewGroup.b.setVisibility(0);
    }
    for (;;)
    {
      localObject = new i(this, paramViewGroup, (e)localObject);
      paramViewGroup.a.setOnClickListener((View.OnClickListener)localObject);
      return paramView;
      paramViewGroup = (j)paramView.getTag();
      break;
      label277:
      paramViewGroup.d.setImageResource(2130838878);
      break label192;
      label289:
      if ((((e)localObject).l() == 2) && (!GoWidgetApplication.b(f.d(this.a)).b()))
      {
        paramViewGroup.e.setImageResource(2130838882);
        paramViewGroup.e.setVisibility(0);
        break label217;
      }
      if ((((e)localObject).l() == 3) && (!((e)localObject).g()) && (((e)localObject).e()) && (((e)localObject).d()))
      {
        paramViewGroup.e.setImageResource(2130837768);
        paramViewGroup.e.setVisibility(0);
        break label217;
      }
      paramViewGroup.e.setVisibility(4);
      break label217;
      label398:
      paramViewGroup.b.setVisibility(4);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/gowidget/configure/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */