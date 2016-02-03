package com.gau.go.launcherex.gowidget.weather.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.model.h;
import java.util.ArrayList;

class aa
  extends BaseAdapter
{
  private LayoutInflater b;
  
  public aa(LanguageSetting paramLanguageSetting)
  {
    this.b = LayoutInflater.from(paramLanguageSetting);
  }
  
  public int getCount()
  {
    return LanguageSetting.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return LanguageSetting.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    h localh;
    if (paramView == null)
    {
      paramView = this.b.inflate(2130903225, null);
      paramViewGroup = new ac(this.a);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131231700));
      paramViewGroup.b = ((RadioButton)paramView.findViewById(2131231701));
      paramViewGroup.c = ((Button)paramView.findViewById(2131231702));
      paramView.setTag(paramViewGroup);
      localh = (h)LanguageSetting.a(this.a).get(paramInt);
      String str2 = localh.i();
      String str1 = str2;
      if (str2.equals("default")) {
        str1 = this.a.getString(2131165544);
      }
      paramViewGroup.a.setText(str1);
      if (localh.a) {
        break label191;
      }
      paramViewGroup.b.setVisibility(8);
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.c.setText(2131165547);
    }
    for (;;)
    {
      paramViewGroup.c.setOnClickListener(new ab(this, paramInt));
      return paramView;
      paramViewGroup = (ac)paramView.getTag();
      break;
      label191:
      if (!localh.b)
      {
        paramViewGroup.c.setVisibility(8);
        paramViewGroup.b.setVisibility(0);
        if (LanguageSetting.c(this.a).equals(localh.b())) {
          paramViewGroup.b.setChecked(true);
        } else {
          paramViewGroup.b.setChecked(false);
        }
      }
      else
      {
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.c.setText(2131165546);
        if (LanguageSetting.c(this.a).equals(localh.b()))
        {
          paramViewGroup.b.setVisibility(0);
          paramViewGroup.b.setChecked(true);
        }
        else
        {
          paramViewGroup.b.setVisibility(8);
          paramViewGroup.b.setChecked(false);
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */