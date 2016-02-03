package com.go.weatherex.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.go.weatherex.framework.fragment.BaseFragmentActivity;
import com.go.weatherex.framework.fragment.g;

public class PersonalizeSettingsActivity
  extends BaseFragmentActivity
{
  private f a;
  private String b;
  
  public static Intent a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, PersonalizeSettingsActivity.class);
    localIntent.putExtra("cityId", paramString);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    return localIntent;
  }
  
  protected g b()
  {
    this.a = new f(this, this);
    return this.a;
  }
  
  public void onBackPressed()
  {
    if (this.a.b()) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903253);
    getWindow().setFormat(-3);
    getWindow().clearFlags(134217728);
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.b = paramBundle.getStringExtra("cityId");
    }
    this.a.e();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/PersonalizeSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */