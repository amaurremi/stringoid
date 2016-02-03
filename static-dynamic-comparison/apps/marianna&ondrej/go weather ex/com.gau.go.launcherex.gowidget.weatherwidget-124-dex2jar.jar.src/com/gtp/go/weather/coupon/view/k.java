package com.gtp.go.weather.coupon.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

class k
  extends BaseAdapter
{
  private LayoutInflater b;
  private o c;
  
  public k(CouponsActivity paramCouponsActivity)
  {
    this.b = LayoutInflater.from(paramCouponsActivity.getApplicationContext());
  }
  
  public int getCount()
  {
    return CouponsActivity.c(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return CouponsActivity.c(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.b.inflate(2130903105, null);
      this.c = new o(this);
      o.a(this.c, (ImageView)paramView.findViewById(2131231243));
      o.a(this.c, (TextView)paramView.findViewById(2131231244));
      o.a(this.c, paramView.findViewById(2131231245));
      o.b(this.c, (TextView)paramView.findViewById(2131231246));
      o.c(this.c, (TextView)paramView.findViewById(2131231247));
      o.b(this.c, paramView.findViewById(2131231248));
      o.d(this.c, (TextView)paramView.findViewById(2131231249));
      o.e(this.c, (TextView)paramView.findViewById(2131231250));
      o.a(this.c, (Button)paramView.findViewById(2131231251));
      o.c(this.c, paramView.findViewById(2131231242));
      paramView.setTag(this.c);
      paramViewGroup = (com.gtp.go.weather.coupon.b.b)CouponsActivity.c(this.a).get(paramInt);
      if (paramViewGroup != null)
      {
        o.a(this.c).setText(paramViewGroup.d());
        switch (paramViewGroup.f())
        {
        default: 
          label256:
          o.g(this.c).setOnClickListener(new l(this, paramViewGroup));
          o.h(this.c).setText(paramViewGroup.e());
          if (paramViewGroup.l())
          {
            o.i(this.c).setBackgroundResource(2130839069);
            o.i(this.c).setClickable(false);
            o.i(this.c).setText(this.a.getString(2131165863));
          }
          break;
        }
      }
    }
    for (;;)
    {
      String str1 = paramViewGroup.j();
      String str2 = String.valueOf(paramViewGroup.b());
      o.j(this.c).setTag(str2);
      if (!TextUtils.isEmpty(str1))
      {
        paramViewGroup = CouponsActivity.i(this.a).a(this.a.getApplicationContext(), str1, str2, "", new n(this, paramViewGroup));
        if (paramViewGroup == null) {
          break label605;
        }
        o.j(this.c).setImageDrawable(paramViewGroup);
      }
      return paramView;
      this.c = ((o)paramView.getTag());
      break;
      o.b(this.c).setVisibility(0);
      o.c(this.c).setVisibility(8);
      o.d(this.c).setText(this.a.getString(2131165860));
      o.e(this.c).setText(paramViewGroup.h());
      break label256;
      o.b(this.c).setVisibility(8);
      o.c(this.c).setVisibility(0);
      o.f(this.c).setText(this.a.getString(2131165861));
      break label256;
      o.i(this.c).setBackgroundResource(2130839068);
      o.i(this.c).setClickable(true);
      o.i(this.c).setText(this.a.getString(2131165862));
      o.i(this.c).setOnClickListener(new m(this, paramViewGroup));
    }
    label605:
    o.j(this.c).setImageResource(2130838889);
    return paramView;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/view/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */