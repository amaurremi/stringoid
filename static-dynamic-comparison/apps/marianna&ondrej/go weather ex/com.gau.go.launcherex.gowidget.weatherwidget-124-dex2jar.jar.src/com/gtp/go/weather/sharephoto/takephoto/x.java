package com.gtp.go.weather.sharephoto.takephoto;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import java.util.List;

class x
  extends BaseAdapter
{
  private RadioButton b = null;
  
  public x(PublishPhotoActivity paramPublishPhotoActivity) {}
  
  public int getCount()
  {
    return PublishPhotoActivity.b(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return PublishPhotoActivity.b(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    WeatherBean localWeatherBean;
    if (paramView == null)
    {
      paramViewGroup = new z(this);
      paramView = paramViewGroup.a;
      paramView.setTag(paramViewGroup);
      localWeatherBean = (WeatherBean)PublishPhotoActivity.b(this.a).get(paramInt);
      paramViewGroup.c.setText(localWeatherBean.d());
      paramViewGroup.b.setId(paramInt);
      if ((TextUtils.isEmpty(localWeatherBean.c())) || (PublishPhotoActivity.c(this.a) == null) || (!localWeatherBean.c().equals(PublishPhotoActivity.c(this.a).c()))) {
        break label150;
      }
      this.b = paramViewGroup.b;
      paramViewGroup.b.setChecked(true);
    }
    for (;;)
    {
      paramViewGroup.a.setOnClickListener(new y(this, localWeatherBean, paramViewGroup));
      return paramView;
      paramViewGroup = (z)paramView.getTag();
      break;
      label150:
      paramViewGroup.b.setChecked(false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */