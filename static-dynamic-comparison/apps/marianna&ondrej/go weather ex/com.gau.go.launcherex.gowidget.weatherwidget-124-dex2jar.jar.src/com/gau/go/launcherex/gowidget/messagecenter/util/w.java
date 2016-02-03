package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.messagecenter.a.d;
import com.gau.go.launcherex.gowidget.messagecenter.view.GCMMsgDetailActivity;
import com.gau.go.launcherex.gowidget.messagecenter.view.HtmlMsgDetailActivity;

public class w
{
  private Context a;
  private m b;
  
  public w(Context paramContext)
  {
    this.a = paramContext;
    this.b = m.a(this.a);
  }
  
  private void a(d paramd)
  {
    if (paramd != null) {
      switch (paramd.c)
      {
      default: 
        this.b.a(paramd, 2, this.a, false);
      }
    }
    for (;;)
    {
      this.b.b(paramd);
      return;
      b(paramd);
      continue;
      if (!TextUtils.isEmpty(paramd.e))
      {
        b(paramd);
      }
      else
      {
        this.b.a(paramd, 2, this.a, false);
        continue;
        Intent localIntent = new Intent(this.a, GCMMsgDetailActivity.class);
        localIntent.putExtra("extras_bundle_msg_id", paramd.a);
        localIntent.putExtra("extras_bundle_msg_title", paramd.b);
        localIntent.putExtra("extras_bundle_msg_summary", paramd.i);
        localIntent.putExtra("extras_bundle_msg_time", paramd.d);
        localIntent.putExtra("weather_alerts_lists_entrance", "widget&notification");
        localIntent.setFlags(872415232);
        this.a.startActivity(localIntent);
      }
    }
  }
  
  private void b(d paramd)
  {
    Intent localIntent = new Intent(this.a, HtmlMsgDetailActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("extras_bundle_msg_id", paramd.a);
    localBundle.putString("extras_bundle_msg_url", paramd.e);
    localBundle.putString("extras_bundle_msg_title", paramd.b);
    localBundle.putString("extras_bundle_msg_pubished_time", paramd.d);
    localIntent.putExtra("weather_alerts_lists_entrance", "widget&notification");
    localIntent.putExtras(localBundle);
    localIntent.setFlags(872415232);
    this.a.startActivity(localIntent);
    this.b.b(paramd.a, 2);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null) {
      switch (paramBundle.getInt("request_extra_message_notify_pending_code", -1))
      {
      }
    }
    do
    {
      return;
      paramBundle = paramBundle.getString("extras_message_notify_pending_code_click_msg_id");
    } while (TextUtils.isEmpty(paramBundle));
    this.b.a(paramBundle, new x(this));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */