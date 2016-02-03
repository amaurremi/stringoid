package com.go.weatherex.themestore.detail;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.e.e;
import com.jiubang.playsdk.main.c;

class i
  implements AdapterView.OnItemClickListener
{
  i(g paramg) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (e)paramAdapterView.getItemAtPosition(paramInt);
    if ((paramAdapterView != null) && (paramAdapterView.f() != null))
    {
      paramView = com.jiubang.playsdk.f.a.a(this.a.a, this.a.f.a(paramAdapterView.f()));
      com.jiubang.playsdk.f.a.a(this.a.a, this.a.g.o(), paramAdapterView.f().b(), this.a.g.r(), paramAdapterView.f().t(), paramView);
      paramView = this.a.f.a(this.a.a, paramAdapterView.f());
      if (!this.a.g.f(this.a.a, paramView)) {
        com.jiubang.playsdk.g.a.a(this.a.a, paramAdapterView.f());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/detail/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */