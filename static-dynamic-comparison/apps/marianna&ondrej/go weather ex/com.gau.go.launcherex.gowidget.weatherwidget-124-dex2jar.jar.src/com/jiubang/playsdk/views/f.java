package com.jiubang.playsdk.views;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsListView.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;

class f
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  f(HeaderListView paramHeaderListView) {}
  
  public void onGlobalLayout()
  {
    int i;
    if ((HeaderListView.a(this.a) != null) && (HeaderListView.b(this.a).getChildAt(HeaderListView.b(this.a).getHeaderViewsCount()) != null))
    {
      i = HeaderListView.b(this.a).getChildAt(HeaderListView.b(this.a).getHeaderViewsCount()).getMeasuredHeight() * HeaderListView.a(this.a).getCount() + HeaderListView.c(this.a).getDimensionPixelSize(com.jiubang.playsdk.d.D) + HeaderListView.d(this.a).getHeight();
      int j = this.a.getMeasuredHeight();
      this.a.removeView(HeaderListView.e(this.a));
      HeaderListView.b(this.a).removeFooterView(HeaderListView.f(this.a));
      if (i > j) {
        break label237;
      }
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, HeaderListView.c(this.a).getDimensionPixelSize(com.jiubang.playsdk.d.D));
      localLayoutParams.gravity = 80;
      HeaderListView.e(this.a).setLayoutParams(localLayoutParams);
      this.a.addView(HeaderListView.e(this.a), this.a.getChildCount() - 1);
      HeaderListView.a(this.a, false);
    }
    for (;;)
    {
      HeaderListView.b(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
      return;
      i = HeaderListView.b(this.a).getMeasuredHeight();
      break;
      label237:
      HeaderListView.f(this.a).setLayoutParams(new AbsListView.LayoutParams(-1, HeaderListView.c(this.a).getDimensionPixelSize(com.jiubang.playsdk.d.D)));
      HeaderListView.b(this.a).addFooterView(HeaderListView.f(this.a), null, false);
      HeaderListView.a(this.a, true);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */