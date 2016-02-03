package com.gau.go.launcherex.gowidget.billing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

class o
  extends BaseAdapter
{
  private ArrayList b = new ArrayList();
  
  public o(BillingActivity paramBillingActivity)
  {
    a();
  }
  
  private void a()
  {
    int j = 0;
    m localm = new m(this.a, null);
    localm.a = 2130838931;
    if (BillingActivity.v(this.a))
    {
      i = 2131166081;
      localm.b = i;
      localm.c = 0;
      localm.d = 0;
      if (!BillingActivity.v(this.a)) {
        break label301;
      }
      i = 2130838943;
      label62:
      localm.e = i;
      if (!BillingActivity.v(this.a)) {
        break label306;
      }
      i = 2130838938;
      label80:
      localm.f = i;
      this.b.add(localm);
      localm = new m(this.a, null);
      localm.a = 2130838932;
      if (!BillingActivity.v(this.a)) {
        break label311;
      }
      i = 2131166083;
      label126:
      localm.b = i;
      localm.c = 2131166096;
      localm.d = 0;
      if (!BillingActivity.v(this.a)) {
        break label317;
      }
      i = 2130838941;
      label155:
      localm.e = i;
      if (!BillingActivity.v(this.a)) {
        break label322;
      }
      i = 2130838936;
      label173:
      localm.f = i;
      this.b.add(localm);
      localm = new m(this.a, null);
      localm.a = 2130838933;
      if (!BillingActivity.v(this.a)) {
        break label327;
      }
      i = 2131166085;
      label219:
      localm.b = i;
      localm.c = 2131166097;
      if (!BillingActivity.v(this.a)) {
        break label333;
      }
      i = 0;
      label242:
      localm.d = i;
      if (!BillingActivity.v(this.a)) {
        break label339;
      }
    }
    label301:
    label306:
    label311:
    label317:
    label322:
    label327:
    label333:
    label339:
    for (int i = 2130838942;; i = 0)
    {
      localm.e = i;
      i = j;
      if (BillingActivity.v(this.a)) {
        i = 2130838937;
      }
      localm.f = i;
      this.b.add(localm);
      return;
      i = 2131166092;
      break;
      i = 0;
      break label62;
      i = 0;
      break label80;
      i = 2131166093;
      break label126;
      i = 0;
      break label155;
      i = 0;
      break label173;
      i = 2131166094;
      break label219;
      i = 2131166095;
      break label242;
    }
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    m localm;
    if (paramView == null)
    {
      paramView = BillingActivity.w(this.a).inflate(2130903319, null);
      paramViewGroup = new q(this.a, null);
      paramViewGroup.a = ((ImageView)paramView.findViewById(2131231970));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131231971));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131231973));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131231972));
      paramViewGroup.e = ((ImageView)paramView.findViewById(2131231974));
      paramView.setTag(paramViewGroup);
      localm = (m)this.b.get(paramInt);
      if (localm != null)
      {
        paramViewGroup.a.setImageResource(localm.a);
        paramViewGroup.b.setText(localm.b);
        if (localm.c == 0) {
          break label247;
        }
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.c.setText(localm.c);
        label171:
        if (localm.e == 0) {
          break label259;
        }
        paramViewGroup.e.setVisibility(0);
        paramViewGroup.e.setImageResource(localm.e);
      }
    }
    for (;;)
    {
      if (localm.d == 0) {
        break label271;
      }
      paramViewGroup.d.setText(localm.d);
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, localm.f, 0);
      return paramView;
      paramViewGroup = (q)paramView.getTag();
      break;
      label247:
      paramViewGroup.c.setVisibility(8);
      break label171;
      label259:
      paramViewGroup.e.setVisibility(8);
    }
    label271:
    paramViewGroup.d.setText("");
    paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, localm.f, 0);
    return paramView;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/billing/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */