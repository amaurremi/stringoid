package com.gau.go.launcherex.gowidget.weather.systemwidget.configure;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.google.analytics.tracking.android.EasyTracker;

public class ThemeConfigureActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener
{
  private ThemeConfigureView a;
  private q b;
  private View c;
  private int d;
  
  private void a(int paramInt)
  {
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("appWidgetId", paramInt);
    setResult(-1, (Intent)localObject);
    finish();
    localObject = "";
    switch (this.b.b())
    {
    }
    for (;;)
    {
      sendBroadcast(new Intent((String)localObject));
      return;
      localObject = "com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_ADD_APPWIDGET42";
      continue;
      localObject = "com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_ADD_APPWIDGET41";
      continue;
      localObject = "com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_ADD_APPWIDGET21";
      continue;
      localObject = "com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_ADD_APPWIDGETDAYS42";
      continue;
      localObject = "com.gau.go.launcherex.gowidget.weatherwidget.ACTION_WIDGET_ADD_APPWIDGETDAYS41";
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.c)) {
      this.b.c();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = 0;
    paramBundle = getIntent().getExtras();
    if (paramBundle != null) {
      this.d = paramBundle.getInt("appWidgetId", 0);
    }
    if (this.d == 0) {
      finish();
    }
    do
    {
      return;
      setContentView(2130903300);
      getWindow().clearFlags(134217728);
      this.b = new q(this, findViewById(2131231670));
    } while (!this.b.a());
    this.a = ((ThemeConfigureView)findViewById(2131231672));
    this.a.a(this.b);
    this.a.a(this);
    this.c = findViewById(2131231673);
    this.c.setOnClickListener(this);
  }
  
  protected void onDestroy()
  {
    if (this.b != null) {
      this.b.d();
    }
    if (this.a != null) {
      this.a.a();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      a(this.d);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/systemwidget/configure/ThemeConfigureActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */