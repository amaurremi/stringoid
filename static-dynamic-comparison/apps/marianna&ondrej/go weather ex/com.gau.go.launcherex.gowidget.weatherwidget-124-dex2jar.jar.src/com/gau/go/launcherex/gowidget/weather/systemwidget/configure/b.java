package com.gau.go.launcherex.gowidget.weather.systemwidget.configure;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.jiubang.playsdk.imageload.KPNetworkImageView;
import java.util.ArrayList;

class b
  extends BaseAdapter
{
  public b(a parama)
  {
    a.a(parama).a();
  }
  
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
    if (a.b(this.a) == null) {
      return 0;
    }
    return a.b(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    if (a.b(this.a) == null) {
      return null;
    }
    return a.b(this.a).get(paramInt);
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
      paramView = a.c(this.a).inflate(2130903301, null);
      paramViewGroup = new d();
      paramViewGroup.a = ((ViewGroup)paramView.findViewById(2131231945));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131231946));
      paramViewGroup.c = ((KPNetworkImageView)paramView.findViewById(2131231947));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131231948));
      paramView.setTag(paramViewGroup);
      paramViewGroup.b.setBackgroundResource(a(paramInt));
      localObject = (com.gau.go.launcherex.gowidget.weather.globaltheme.b.d)a.b(this.a).get(paramInt);
      paramViewGroup.f = paramInt;
      paramViewGroup.e = ((com.gau.go.launcherex.gowidget.weather.globaltheme.b.d)localObject);
      switch (((com.gau.go.launcherex.gowidget.weather.globaltheme.b.d)localObject).b())
      {
      case 3: 
      default: 
        paramViewGroup.d.setImageBitmap(null);
        label168:
        if (a.d(this.a))
        {
          if (((com.gau.go.launcherex.gowidget.weather.globaltheme.b.d)localObject).c() != 1) {
            break label303;
          }
          paramViewGroup.d.setImageResource(2130837768);
        }
        break;
      }
    }
    for (;;)
    {
      paramViewGroup.c.a(((com.gau.go.launcherex.gowidget.weather.globaltheme.b.d)localObject).a());
      paramViewGroup.c.a(2130838878);
      localObject = new c(this, paramViewGroup, (com.gau.go.launcherex.gowidget.weather.globaltheme.b.d)localObject, paramInt + 1);
      paramViewGroup.a.setOnClickListener((View.OnClickListener)localObject);
      return paramView;
      paramViewGroup = (d)paramView.getTag();
      break;
      paramViewGroup.d.setImageResource(2130838882);
      break label168;
      paramViewGroup.d.setImageResource(2130838881);
      break label168;
      paramViewGroup.d.setImageResource(2130838880);
      break label168;
      paramViewGroup.d.setImageResource(2130838879);
      break label168;
      label303:
      paramViewGroup.d.setImageBitmap(null);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/configure/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */