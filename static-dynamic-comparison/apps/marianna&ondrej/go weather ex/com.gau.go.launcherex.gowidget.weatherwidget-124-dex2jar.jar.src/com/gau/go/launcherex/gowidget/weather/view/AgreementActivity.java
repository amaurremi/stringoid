package com.gau.go.launcherex.gowidget.weather.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

public class AgreementActivity
  extends Activity
  implements View.OnClickListener
{
  private TextView a;
  
  public void onClick(View paramView)
  {
    if (paramView == this.a) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903249);
    getWindow().clearFlags(134217728);
    this.a = ((TextView)findViewById(2131231793));
    this.a.setOnClickListener(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/AgreementActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */