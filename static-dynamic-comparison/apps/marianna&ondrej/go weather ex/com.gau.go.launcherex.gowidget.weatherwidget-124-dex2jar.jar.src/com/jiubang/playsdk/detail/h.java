package com.jiubang.playsdk.detail;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.e.e;
import com.jiubang.playsdk.main.c;

class h
  implements AdapterView.OnItemClickListener
{
  h(f paramf) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (e)paramAdapterView.getItemAtPosition(paramInt);
    if ((paramAdapterView != null) && (paramAdapterView.f() != null))
    {
      paramView = com.jiubang.playsdk.f.a.a(f.g(this.a), f.h(this.a).a(paramAdapterView.f()));
      com.jiubang.playsdk.f.a.a(f.i(this.a), f.j(this.a).o(), paramAdapterView.f().b(), f.k(this.a).r(), paramAdapterView.f().t(), paramView);
      paramView = f.m(this.a).a(f.l(this.a), paramAdapterView.f());
      if (!f.o(this.a).f(f.n(this.a), paramView)) {
        com.jiubang.playsdk.g.a.a(f.p(this.a), paramAdapterView.f());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */