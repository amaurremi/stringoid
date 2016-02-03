package com.gau.go.launcherex.gowidget.messagecenter.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.gau.go.launcherex.gowidget.messagecenter.a.d;
import com.gau.go.launcherex.gowidget.messagecenter.util.m;

class h
  implements View.OnClickListener
{
  h(NormalMsgDialogActivity paramNormalMsgDialogActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new d();
    paramView.a = this.a;
    m.a(this.b.getApplicationContext()).a(paramView, 4, this.b, true);
    this.b.finish();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/view/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */