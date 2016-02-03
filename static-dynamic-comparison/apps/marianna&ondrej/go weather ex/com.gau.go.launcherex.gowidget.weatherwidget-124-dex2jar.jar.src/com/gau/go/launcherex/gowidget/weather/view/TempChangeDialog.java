package com.gau.go.launcherex.gowidget.weather.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;

public class TempChangeDialog
  extends GoWeatherEXActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903121);
    getWindow().clearFlags(134217728);
    paramBundle = (String)getIntent().getCharSequenceExtra("extra_temp_change_dialog_extra");
    if (paramBundle == null)
    {
      finish();
      return;
    }
    ((TextView)findViewById(2131230797)).setText(2131166214);
    ((TextView)findViewById(2131231257)).setText(paramBundle);
    paramBundle = (TextView)findViewById(2131231275);
    paramBundle.setVisibility(0);
    paramBundle.setText(2131166239);
    paramBundle.setOnClickListener(new az(this));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/TempChangeDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */