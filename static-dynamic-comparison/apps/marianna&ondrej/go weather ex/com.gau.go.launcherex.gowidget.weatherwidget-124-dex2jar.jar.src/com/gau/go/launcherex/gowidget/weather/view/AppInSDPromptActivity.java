package com.gau.go.launcherex.gowidget.weather.view;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;

public class AppInSDPromptActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener
{
  private TextView a;
  private Button b;
  private Button c;
  
  private void a(String paramString)
  {
    Intent localIntent = new Intent();
    int i = Build.VERSION.SDK_INT;
    if (i >= 9)
    {
      localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", paramString, null));
    }
    try
    {
      startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      String str;
      paramString.printStackTrace();
    }
    if (i == 8) {}
    for (str = "pkg";; str = "com.android.settings.ApplicationPkgName")
    {
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
      localIntent.putExtra(str, paramString);
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.c))
    {
      a(getPackageName());
      finish();
    }
    while (!paramView.equals(this.b)) {
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903061);
    getWindow().setLayout(-1, -1);
    getWindow().clearFlags(134217728);
    paramBundle = getIntent();
    if (paramBundle != null) {}
    int i;
    switch (paramBundle.getIntExtra("app_in_sd_prompt_tips_type", 1))
    {
    default: 
      i = 2131165782;
    }
    for (;;)
    {
      this.a = ((TextView)findViewById(2131230931));
      this.a.setText(i);
      this.b = ((Button)findViewById(2131230932));
      this.b.setOnClickListener(this);
      this.c = ((Button)findViewById(2131230933));
      this.c.setOnClickListener(this);
      return;
      i = 2131165782;
      continue;
      i = 2131165820;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/AppInSDPromptActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */