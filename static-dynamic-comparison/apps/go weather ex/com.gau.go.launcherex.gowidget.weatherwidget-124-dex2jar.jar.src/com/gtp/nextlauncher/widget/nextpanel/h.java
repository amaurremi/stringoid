package com.gtp.nextlauncher.widget.nextpanel;

import android.graphics.Rect;
import com.go.gl.view.GLView;
import com.go.gl.view.GLView.OnClickListener;
import java.util.ArrayList;

class h
  implements GLView.OnClickListener
{
  h(PanelMain paramPanelMain) {}
  
  public void onClick(GLView paramGLView)
  {
    PanelMain.access$000(this.a);
    if (PanelMain.access$300(this.a).contains((int)PanelMain.access$100(this.a), (int)PanelMain.access$200(this.a)))
    {
      PanelMain.access$400(this.a, false);
      return;
    }
    if (PanelMain.access$500(this.a).contains((int)PanelMain.access$100(this.a), (int)PanelMain.access$200(this.a)))
    {
      PanelMain.access$400(this.a, true);
      return;
    }
    if (PanelMain.access$600(this.a).contains((int)PanelMain.access$100(this.a), (int)PanelMain.access$200(this.a)))
    {
      PanelMain.access$700(this.a);
      return;
    }
    if ((PanelMain.access$800(this.a) != null) && (PanelMain.access$800(this.a).size() > 0))
    {
      ((CityView)PanelMain.access$800(this.a).get(PanelMain.access$900(this.a))).startWeatherAnimation();
      return;
    }
    PanelMain.access$1000(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/nextlauncher/widget/nextpanel/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */