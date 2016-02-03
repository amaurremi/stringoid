package com.jiubang.playsdk.detail.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.jiubang.playsdk.views.TouchMaskFrameLayout;

class m
  implements View.OnClickListener
{
  m(l paraml, ViewGroup paramViewGroup, TouchMaskFrameLayout paramTouchMaskFrameLayout, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (l.a(this.d) != null) {
      l.a(this.d).onItemClick((AdapterView)this.a, this.b, this.c, this.c);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */