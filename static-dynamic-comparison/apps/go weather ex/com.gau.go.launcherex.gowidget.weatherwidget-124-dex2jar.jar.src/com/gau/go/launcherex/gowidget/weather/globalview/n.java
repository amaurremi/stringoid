package com.gau.go.launcherex.gowidget.weather.globalview;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.PopupWindow.OnDismissListener;
import com.a.a.an;

public class n
  implements View.OnClickListener
{
  private final FrameLayout a;
  private final View b;
  private Activity c;
  private an d;
  private an e;
  private boolean f = false;
  private PopupWindow.OnDismissListener g;
  
  public n(Activity paramActivity, View paramView, int paramInt1, int paramInt2)
  {
    this.c = paramActivity;
    this.b = paramView;
    this.a = new FrameLayout(this.c);
    this.a.setOnClickListener(this);
    this.a.addView(this.b, new ViewGroup.LayoutParams(paramInt1, paramInt2));
  }
  
  private void b()
  {
    if (this.e != null) {
      this.e.b();
    }
    this.d = an.b(new int[] { this.b.getHeight() - this.b.getScrollY(), 0 });
    this.d.a(new p(this));
    this.d.a(new AccelerateDecelerateInterpolator());
    this.d.c(300L);
    this.d.a();
  }
  
  public void a()
  {
    if (!this.f) {}
    do
    {
      return;
      this.f = false;
      if (this.d != null) {
        this.d.b();
      }
      this.e = an.b(new int[] { this.b.getScrollY(), this.b.getHeight() });
      this.e.a(new q(this));
      this.e.a(new r(this));
      this.e.c(300L);
      this.e.a(new AccelerateInterpolator());
      this.e.a();
    } while (this.g == null);
    this.g.onDismiss();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (this.f) {
      return;
    }
    this.f = true;
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    arrayOfInt[0] += paramInt1;
    arrayOfInt[1] = (arrayOfInt[1] + paramInt2 + paramView.getHeight());
    this.a.scrollTo(-arrayOfInt[0], -arrayOfInt[1]);
    ((ViewGroup)this.c.getWindow().getDecorView()).addView(this.a, new ViewGroup.LayoutParams(-1, -1));
    if (this.d == null)
    {
      this.b.getViewTreeObserver().addOnPreDrawListener(new o(this));
      return;
    }
    b();
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.g = paramOnDismissListener;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.a)) {
      a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globalview/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */