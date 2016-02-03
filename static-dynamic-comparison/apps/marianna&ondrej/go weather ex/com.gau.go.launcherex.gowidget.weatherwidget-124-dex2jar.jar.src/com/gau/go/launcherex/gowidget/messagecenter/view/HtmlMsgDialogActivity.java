package com.gau.go.launcherex.gowidget.messagecenter.view;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.q;

public class HtmlMsgDialogActivity
  extends GoWeatherEXActivity
{
  private TextView a;
  private Notification b;
  private NotificationManager c;
  private int d = 1;
  private MessageCenterWebView e = null;
  private d f;
  private Handler g;
  
  private void a()
  {
    this.e = ((MessageCenterWebView)findViewById(2131231714));
    this.e.a(this, this.f.a, 4);
    this.a = ((TextView)findViewById(2131231716));
  }
  
  private void b()
  {
    this.b = new Notification();
    this.c = ((NotificationManager)getSystemService("notification"));
    int i;
    if (com.gau.go.launcherex.gowidget.weather.c.c.a(getApplicationContext()).f().a().z == 1)
    {
      i = 1;
      if (i == 0) {
        break label80;
      }
    }
    label80:
    for (this.b.defaults = 7;; this.b.defaults = 6)
    {
      this.c.notify(this.d, this.b);
      return;
      i = 0;
      break;
    }
  }
  
  private void f()
  {
    this.e.a(this.f.b, this.f.c);
    this.e.a(this.f.d);
    this.a.setText(2131166003);
  }
  
  public void a(Runnable paramRunnable)
  {
    this.g.post(paramRunnable);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    super.dispatchKeyEvent(paramKeyEvent);
    if (this.c != null)
    {
      this.c.cancel(this.d);
      this.c = null;
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    super.dispatchTouchEvent(paramMotionEvent);
    if (this.c != null)
    {
      this.c.cancel(this.d);
      this.c = null;
    }
    return false;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903234);
    getWindow().clearFlags(134217728);
    this.g = new Handler();
    this.f = new d(this, null);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      this.f.a = paramBundle.getString("extras_bundle_msg_id");
      this.f.b = paramBundle.getString("extras_bundle_msg_title");
      this.f.d = paramBundle.getString("extras_bundle_msg_url");
      this.f.c = paramBundle.getString("extras_bundle_msg_pubished_time");
    }
    com.gtp.a.a.b.c.a("MSGCenter", this.f.a);
    com.gtp.a.a.b.c.a("MSGCenter", this.f.b);
    com.gtp.a.a.b.c.a("MSGCenter", this.f.d);
    com.gtp.a.a.b.c.a("MSGCenter", this.f.c);
    if ((TextUtils.isEmpty(this.f.a)) || (TextUtils.isEmpty(this.f.d)) || (TextUtils.isEmpty(this.f.c)) || (TextUtils.isEmpty(this.f.b)))
    {
      finish();
      return;
    }
    a();
    f();
    b();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.c != null)
    {
      this.c.cancel(this.d);
      this.c = null;
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    paramIntent = getIntent().getExtras();
    if (paramIntent != null)
    {
      this.f.a = paramIntent.getString("extras_bundle_msg_id");
      this.f.b = paramIntent.getString("extras_bundle_msg_title");
      this.f.d = paramIntent.getString("extras_bundle_msg_url");
      this.f.c = paramIntent.getString("extras_bundle_msg_pubished_time");
    }
    if ((!TextUtils.isEmpty(this.f.a)) && (!TextUtils.isEmpty(this.f.d))) {
      f();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/view/HtmlMsgDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */