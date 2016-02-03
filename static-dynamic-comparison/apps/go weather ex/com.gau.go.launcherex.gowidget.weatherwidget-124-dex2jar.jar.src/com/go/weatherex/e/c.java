package com.go.weatherex.e;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.messagecenter.a.d;
import com.gau.go.launcherex.gowidget.messagecenter.util.i;
import java.util.Vector;

class c
  extends BaseAdapter
{
  private LayoutInflater b;
  
  c(a parama)
  {
    this.b = ((LayoutInflater)parama.getActivity().getSystemService("layout_inflater"));
  }
  
  public int getCount()
  {
    if (a.a(this.a) != null) {
      return a.a(this.a).size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < getCount()) {
      return a.a(this.a).get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.b.inflate(2130903238, null);
      paramViewGroup = new e(null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131231727));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131231728));
      paramViewGroup.c = paramView.findViewById(2131231729);
      paramView.setTag(paramViewGroup);
      d locald = (d)a.a(this.a).get(paramInt);
      if (locald != null)
      {
        paramViewGroup.a.setText(locald.b);
        paramViewGroup.b.setText(locald.d);
        if (locald.y) {
          break label173;
        }
        paramViewGroup.a.setTextColor(-1);
        paramViewGroup.b.setTextColor(-1275068417);
      }
    }
    for (;;)
    {
      if (paramInt != a.a(this.a).size() - 1) {
        break label194;
      }
      paramViewGroup.c.setVisibility(8);
      return paramView;
      paramViewGroup = (e)paramView.getTag();
      break;
      label173:
      paramViewGroup.a.setTextColor(-2130706433);
      paramViewGroup.b.setTextColor(-2130706433);
    }
    label194:
    paramViewGroup.c.setVisibility(0);
    return paramView;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    if (a.b(this.a)) {
      a.a(this.a, 0);
    }
    for (;;)
    {
      a.c(this.a);
      a.a(this.a, i.a(a.a(this.a)), a.a(this.a).size());
      return;
      a.a(this.a, 8);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */