package com.gau.go.launcherex.gowidget.messagecenter.view;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.e;
import com.gau.go.launcherex.gowidget.weather.model.q;

public class NormalMsgDialogActivity
  extends GoWeatherEXActivity
{
  LinearLayout a;
  TextView b;
  TextView c;
  Button d;
  private Notification e;
  private NotificationManager f;
  private int g = 1;
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return "OK";
      if (paramString.startsWith("http://")) {
        return "打开浏览器";
      }
    } while (!paramString.startsWith("market://id="));
    return "打开电子市场";
  }
  
  private void a()
  {
    this.e = new Notification();
    this.f = ((NotificationManager)getSystemService("notification"));
    int i;
    if (c.a(getApplicationContext()).f().a().z == 1)
    {
      i = 1;
      if (i == 0) {
        break label80;
      }
    }
    label80:
    for (this.e.defaults = 7;; this.e.defaults = 6)
    {
      this.f.notify(this.g, this.e);
      return;
      i = 0;
      break;
    }
  }
  
  private void a(Intent paramIntent)
  {
    String str1 = null;
    paramIntent = getIntent().getExtras();
    String str3;
    String str2;
    int i;
    if (paramIntent != null)
    {
      str3 = paramIntent.getString("extras_bundle_msg_id");
      str2 = paramIntent.getString("extras_bundle_msg_title");
      str1 = paramIntent.getString("extras_bundle_msg_summary");
      i = paramIntent.getInt("extras_bundle_msg_acttype");
      paramIntent = paramIntent.getString("extras_bundle_msg_actvalue");
    }
    while ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1)))
    {
      finish();
      return;
      i = 0;
      paramIntent = "";
      str2 = null;
      str3 = null;
    }
    a();
    this.b.setText(2131166003);
    this.c.setText(str2 + "\n" + str1);
    this.d.setText(a(i, paramIntent));
    this.d.setOnClickListener(new h(this, str3));
  }
  
  public String a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 3: 
    case 4: 
    default: 
    case 7: 
    case 2: 
    case 5: 
      do
      {
        return "OK";
        return a(paramString);
        return "打开浏览器";
      } while ((paramString == null) || (!paramString.startsWith("market://")));
      return "打开电子市场";
    }
    return "下载";
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    super.dispatchKeyEvent(paramKeyEvent);
    if (this.f != null)
    {
      this.f.cancel(this.g);
      this.f = null;
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    super.dispatchTouchEvent(paramMotionEvent);
    if (this.f != null)
    {
      this.f.cancel(this.g);
      this.f = null;
    }
    return false;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903172);
    getWindow().clearFlags(134217728);
    this.a = ((LinearLayout)findViewById(2131231571));
    this.a.setVisibility(0);
    this.b = ((TextView)this.a.findViewById(2131231572));
    this.c = ((TextView)findViewById(2131231576));
    this.c.setVisibility(0);
    this.d = ((Button)findViewById(2131231578));
    this.d.setVisibility(0);
    a(getIntent());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.f != null)
    {
      this.f.cancel(this.g);
      this.f = null;
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/view/NormalMsgDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */