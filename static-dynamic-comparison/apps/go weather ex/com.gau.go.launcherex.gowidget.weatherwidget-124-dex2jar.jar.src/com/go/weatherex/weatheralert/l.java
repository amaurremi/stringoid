package com.go.weatherex.weatheralert;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.model.c;
import java.util.ArrayList;

class l
  extends BaseAdapter
{
  private boolean[] b;
  private ArrayList c = new ArrayList();
  
  public l(i parami) {}
  
  private void a()
  {
    int i = this.b.length - 1;
    for (;;)
    {
      if (i > -1)
      {
        if (this.b[i] != 0) {
          this.b[i] = false;
        }
      }
      else {
        return;
      }
      i -= 1;
    }
  }
  
  public void a(int paramInt)
  {
    a();
    this.b[paramInt] = true;
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      this.c.clear();
      this.c.addAll(paramArrayList);
      this.b = new boolean[this.c.size()];
      int i = this.b.length - 1;
      while (i > -1)
      {
        this.b[i] = false;
        i -= 1;
      }
    }
  }
  
  public int getCount()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.c == null) {
      return null;
    }
    return (c)this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    c localc;
    if (paramView == null)
    {
      paramViewGroup = new n(this);
      paramView = i.c(this.a).inflate(2130903343, null);
      paramViewGroup.a = paramView.findViewById(2131231144);
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131232054));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131230797));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131232055));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131231202));
      paramViewGroup.f = ((ImageView)paramView.findViewById(2131231146));
      paramView.setTag(paramViewGroup);
      localc = (c)this.c.get(paramInt);
      paramViewGroup.c.setText(localc.f());
      paramViewGroup.d.setText(i.a(this.a, localc.c()));
      paramViewGroup.e.setText(localc.i());
      if (this.b[paramInt] == 0) {
        break label293;
      }
      paramViewGroup.e.setVisibility(0);
      paramViewGroup.f.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.a.setOnClickListener(new m(this, paramInt, localc));
      if (!localc.b()) {
        break label314;
      }
      paramViewGroup.b.setImageResource(2130837870);
      paramViewGroup.c.setTextColor(this.a.getResources().getColor(2131361882));
      paramViewGroup.d.setTextColor(this.a.getResources().getColor(2131361882));
      paramViewGroup.e.setTextColor(this.a.getResources().getColor(2131361882));
      return paramView;
      paramViewGroup = (n)paramView.getTag();
      break;
      label293:
      paramViewGroup.e.setVisibility(8);
      paramViewGroup.f.setVisibility(8);
    }
    label314:
    paramViewGroup.b.setImageResource(2130837871);
    paramViewGroup.c.setTextColor(this.a.getResources().getColor(2131361881));
    paramViewGroup.d.setTextColor(this.a.getResources().getColor(2131361881));
    paramViewGroup.e.setTextColor(this.a.getResources().getColor(2131361881));
    return paramView;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/weatheralert/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */