package com.gtp.nextlauncher.widget.weatherwidget;

import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnClickListener;

class r
  implements GLView.OnClickListener
{
  r(HourlyTypeView paramHourlyTypeView) {}
  
  public void onClick(GLView paramGLView)
  {
    if (HourlyTypeView.access$000(this.a) != 5) {
      return;
    }
    if (HourlyTypeView.access$200(this.a).i() > 1)
    {
      HourlyTypeView.access$200(this.a).f();
      return;
    }
    HourlyTypeView.access$100(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */