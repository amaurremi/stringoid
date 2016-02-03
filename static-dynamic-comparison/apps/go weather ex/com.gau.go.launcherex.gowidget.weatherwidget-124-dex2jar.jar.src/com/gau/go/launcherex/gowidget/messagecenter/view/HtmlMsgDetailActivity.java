package com.gau.go.launcherex.gowidget.messagecenter.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gtp.a.a.b.c;

public class HtmlMsgDetailActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener
{
  private View a;
  private MessageCenterWebView b = null;
  private TextView c;
  private b d;
  private Handler e;
  private boolean f = true;
  
  private void a(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      this.d.a = paramIntent.getString("extras_bundle_msg_id");
      this.d.b = paramIntent.getString("extras_bundle_msg_title");
      this.d.d = paramIntent.getString("extras_bundle_msg_url");
      this.d.c = paramIntent.getString("extras_bundle_msg_pubished_time");
      paramIntent = paramIntent.getString("weather_alerts_lists_entrance");
      if ((paramIntent != null) && (paramIntent.equals("widget&notification"))) {
        this.f = false;
      }
    }
    if ((TextUtils.isEmpty(this.d.a)) || (TextUtils.isEmpty(this.d.d)) || (TextUtils.isEmpty(this.d.c)) || (TextUtils.isEmpty(this.d.b)))
    {
      finish();
      return;
    }
    if (this.f) {
      this.b.a(this, this.d.a, 1);
    }
    for (;;)
    {
      this.b.a(this.d.b, this.d.c);
      this.b.a(this.d.d);
      this.c.setText(this.d.b);
      return;
      this.b.a(this, this.d.a, 2);
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    this.e.post(paramRunnable);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.a)) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903233);
    getWindow().clearFlags(134217728);
    c.a("MSGCenter", "onCreate");
    this.d = new b(this, null);
    this.e = new Handler();
    this.b = ((MessageCenterWebView)findViewById(2131231714));
    this.c = ((TextView)findViewById(2131230797));
    this.a = findViewById(2131230796);
    this.a.setOnClickListener(this);
    a(getIntent());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.b != null) {
      this.b.a();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.b != null) && (this.b.onKeyDown(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    c.a("MSGCenter", "onNewIntent");
    a(paramIntent);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onStop()
  {
    super.onStop();
    if (!this.f) {
      finish();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/view/HtmlMsgDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */