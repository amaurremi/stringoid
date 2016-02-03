package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;

public class GoWidgetGuideActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener
{
  private View a;
  private View b;
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.b)) {
      finish();
    }
    while (!paramView.equals(this.a)) {
      return;
    }
    paramView = new Intent("android.intent.action.MAIN");
    paramView.addCategory("android.intent.category.HOME");
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903173);
    getWindow().clearFlags(134217728);
    this.a = findViewById(2131231073);
    this.a.setOnClickListener(this);
    this.b = findViewById(2131230796);
    this.b.setOnClickListener(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/GoWidgetGuideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */