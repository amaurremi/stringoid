package com.gau.go.launcherex.gowidget.weather.gowidget.configure;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.google.analytics.tracking.android.EasyTracker;

public class ThemeConfigure42Activity
  extends GoWeatherEXActivity
  implements View.OnClickListener
{
  private ImageView a;
  private ThemeConfigureView b;
  private View c;
  
  private void a()
  {
    this.b.b();
    finish();
  }
  
  private void b()
  {
    this.b.c();
    finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.c)) {
      a();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903210);
    getWindow().clearFlags(134217728);
    this.a = ((ImageView)findViewById(2131231671));
    this.a.setTag(m.a);
    this.b = ((ThemeConfigureView)findViewById(2131231672));
    this.b.a(this);
    this.b.a(this.a);
    this.c = findViewById(2131231673);
    this.c.setOnClickListener(this);
    paramBundle = new Intent("com.gau.gowidget_action_config_finish");
    paramBundle.putExtras(getIntent().getExtras());
    sendBroadcast(paramBundle);
  }
  
  protected void onDestroy()
  {
    if (this.b != null) {
      this.b.a();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      b();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onStart()
  {
    super.onStart();
    EasyTracker.getInstance().activityStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    EasyTracker.getInstance().activityStop(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/gowidget/configure/ThemeConfigure42Activity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */