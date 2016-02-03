package com.gtp.nextlauncher.widget.weatherwidget;

import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnClickListener;

class t
  implements GLView.OnClickListener
{
  t(HourlyTypeView paramHourlyTypeView) {}
  
  public void onClick(GLView paramGLView)
  {
    if (HourlyTypeView.access$000(this.a) != 5) {
      return;
    }
    HourlyTypeView.access$200(this.a).c();
    this.a.postDelayed(new u(this), 1000L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */