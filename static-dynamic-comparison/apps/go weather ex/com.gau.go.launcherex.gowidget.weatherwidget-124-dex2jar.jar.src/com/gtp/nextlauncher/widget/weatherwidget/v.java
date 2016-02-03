package com.gtp.nextlauncher.widget.weatherwidget;

import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnClickListener;

class v
  implements GLView.OnClickListener
{
  v(HourlyTypeView paramHourlyTypeView) {}
  
  public void onClick(GLView paramGLView)
  {
    if (HourlyTypeView.access$000(this.a) != 5) {}
    while ((!HourlyTypeView.access$300(this.a).getIfHourSwitchReady()) || (!HourlyTypeView.access$300(this.a).getIfTrendSwitchReady())) {
      return;
    }
    this.a.startDisppearAnimation();
    if (HourlyTypeView.access$400(this.a) == null) {
      HourlyTypeView.access$402(this.a, HourlyTypeView.access$300(this.a).getTrendView());
    }
    HourlyTypeView.access$400(this.a).startAppearAnimation();
    HourlyTypeView.access$300(this.a).setHourDisappearStart();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/weatherwidget/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */