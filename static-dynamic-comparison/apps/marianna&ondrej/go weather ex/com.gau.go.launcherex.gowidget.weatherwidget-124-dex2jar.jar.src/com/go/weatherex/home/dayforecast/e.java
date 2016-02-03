package com.go.weatherex.home.dayforecast;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.scriptengine.parser.i;
import com.gau.go.launcherex.gowidget.weather.model.ForecastBean;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.go.weatherex.home.view.DashedLinearLayout;
import java.util.ArrayList;

class e
  extends BaseAdapter
{
  e(ForecastDaysForm paramForecastDaysForm) {}
  
  public int getCount()
  {
    return ForecastDaysForm.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return ForecastDaysForm.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ForecastBean localForecastBean = null;
    String str;
    label176:
    label277:
    float f1;
    float f2;
    if (paramView == null)
    {
      paramView = ForecastDaysForm.b(this.a).inflate(2130903130, null);
      paramViewGroup = new f(this.a, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131231253));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131230835));
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131231254));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131231310));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131231311));
      paramView.setTag(paramViewGroup);
      if (paramInt < ForecastDaysForm.a(this.a).size()) {
        localForecastBean = (ForecastBean)ForecastDaysForm.a(this.a).get(paramInt);
      }
      if (localForecastBean != null)
      {
        if (!r.a(localForecastBean.e(), localForecastBean.f(), localForecastBean.g(), ForecastDaysForm.c(this.a))) {
          break label368;
        }
        str = ForecastDaysForm.d(this.a);
        paramViewGroup.a.setText(str);
        int i = ForecastDaysForm.e(this.a).a().k;
        paramViewGroup.b.setText(r.a(localForecastBean.e(), localForecastBean.f(), localForecastBean.g(), false, i));
        paramViewGroup.c.setImageResource(r.a(i.h, localForecastBean.i(), true));
        if ((localForecastBean.d() != "--") && (!TextUtils.isEmpty(localForecastBean.d()))) {
          break label395;
        }
        paramViewGroup.d.setText(2131165323);
        i = ForecastDaysForm.e(this.a).a().g;
        f1 = localForecastBean.b(i);
        f2 = localForecastBean.a(i);
        if ((f1 != -10000.0F) && (f2 != -10000.0F)) {
          break label410;
        }
        paramViewGroup.e.setText("--°/--°");
      }
    }
    for (;;)
    {
      paramViewGroup = (DashedLinearLayout)paramView;
      if (paramInt != getCount() - 1) {
        break label451;
      }
      paramViewGroup.a(false);
      return paramView;
      paramViewGroup = (f)paramView.getTag();
      break;
      label368:
      str = ForecastDaysForm.a(this.a, localForecastBean.e(), localForecastBean.f(), localForecastBean.g());
      break label176;
      label395:
      paramViewGroup.d.setText(localForecastBean.d());
      break label277;
      label410:
      paramViewGroup.e.setText(String.format("%d°/%d°", new Object[] { Integer.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.a(f1)), Integer.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.a(f2)) }));
    }
    label451:
    paramViewGroup.a(true);
    return paramView;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/dayforecast/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */