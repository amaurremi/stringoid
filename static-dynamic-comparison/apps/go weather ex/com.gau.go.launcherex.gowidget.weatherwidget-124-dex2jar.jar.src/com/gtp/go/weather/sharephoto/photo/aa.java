package com.gtp.go.weather.sharephoto.photo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

class aa
  extends BaseAdapter
{
  private aa(PhotoActivity paramPhotoActivity) {}
  
  public int getCount()
  {
    if (PhotoActivity.f(this.a) != null) {
      return PhotoActivity.f(this.a).size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (PhotoActivity.f(this.a) != null) {
      return (ab)PhotoActivity.f(this.a).get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = PhotoActivity.g(this.a).inflate(2130903263, null);
    }
    paramView = (TextView)paramViewGroup.findViewById(2131231833);
    if (PhotoActivity.f(this.a) != null) {
      paramView.setText(((ab)PhotoActivity.f(this.a).get(paramInt)).a);
    }
    return paramViewGroup;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */