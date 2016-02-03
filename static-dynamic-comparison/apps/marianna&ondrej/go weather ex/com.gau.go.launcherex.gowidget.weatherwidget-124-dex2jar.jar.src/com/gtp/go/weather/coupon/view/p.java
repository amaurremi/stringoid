package com.gtp.go.weather.coupon.view;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Toast;
import com.gtp.a.a.c.d;
import com.gtp.go.weather.coupon.a.e;
import java.util.ArrayList;

class p
  implements AbsListView.OnScrollListener
{
  private p(CouponsActivity paramCouponsActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAbsListView != null) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (!CouponsActivity.a(this.a)) && (!CouponsActivity.b(this.a)) && (CouponsActivity.c(this.a).size() > 0))
    {
      if (d.b(this.a.getApplicationContext()))
      {
        CouponsActivity.a(this.a, true);
        CouponsActivity.b(this.a, true);
        CouponsActivity.d(this.a);
        CouponsActivity.f(this.a).a(CouponsActivity.e(this.a), CouponsActivity.c(this.a));
      }
    }
    else {
      return;
    }
    Toast.makeText(this.a.getApplicationContext(), this.a.getString(2131165748), 0).show();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/view/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */