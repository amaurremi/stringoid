package com.go.weatherex.f;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.viewframe.viewholder.b;
import com.go.weatherex.framework.fragment.a;
import com.go.weatherex.framework.fragment.f;

class s
  extends b
{
  private TextView b;
  private ProgressBar c;
  
  public s(n paramn)
  {
    this.e = n.b(paramn).i().a(2130903274, null);
    this.b = ((TextView)b(2131231894));
    this.c = ((ProgressBar)b(2131231252));
  }
  
  void a(View.OnClickListener paramOnClickListener)
  {
    this.e.setOnClickListener(paramOnClickListener);
  }
  
  void a(boolean paramBoolean)
  {
    ProgressBar localProgressBar = this.c;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      return;
    }
  }
  
  void c(int paramInt)
  {
    this.b.setText(n.c(this.a).getString(paramInt));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */