package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.messagecenter.a.d;
import com.gau.go.launcherex.gowidget.messagecenter.view.HtmlMsgDialogActivity;
import com.gau.go.launcherex.gowidget.messagecenter.view.NormalMsgDialogActivity;
import com.gtp.a.a.b.c;

public class h
{
  private static h b;
  private Context a = null;
  
  private h(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static h a(Context paramContext)
  {
    if (b == null) {
      b = new h(paramContext);
    }
    return b;
  }
  
  public void a(d paramd)
  {
    c.a("MSGCenter", "对话框消息 " + paramd.a);
    m.a(this.a).a(paramd.a, 4);
    Intent localIntent = new Intent();
    if (paramd.c == 3)
    {
      c.a("MSGCenter", "WebView " + paramd.a);
      localIntent.setClass(this.a, HtmlMsgDialogActivity.class);
      localIntent.setFlags(268435456);
      localIntent.putExtra("extras_bundle_msg_id", paramd.a);
      localIntent.putExtra("extras_bundle_msg_url", paramd.e);
      localIntent.putExtra("extras_bundle_msg_title", paramd.b);
      localIntent.putExtra("extras_bundle_msg_pubished_time", paramd.d);
    }
    for (;;)
    {
      this.a.startActivity(localIntent);
      m.a(this.a.getApplicationContext()).b(paramd);
      return;
      c.a("MSGCenter", "Normal " + paramd.a);
      localIntent.setClass(this.a, NormalMsgDialogActivity.class);
      localIntent.setFlags(268435456);
      localIntent.putExtra("extras_bundle_msg_id", paramd.a);
      localIntent.putExtra("extras_bundle_msg_title", paramd.b);
      localIntent.putExtra("extras_bundle_msg_summary", paramd.i);
      localIntent.putExtra("extras_bundle_msg_acttype", paramd.j);
      localIntent.putExtra("extras_bundle_msg_actvalue", paramd.k);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */