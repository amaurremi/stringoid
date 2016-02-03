package com.go.weatherex.setting;

import android.os.Bundle;
import android.view.Window;
import com.go.weatherex.framework.fragment.BaseFragmentActivity;
import com.go.weatherex.framework.fragment.g;

public class LiveWallpaperSettingsActivity
  extends BaseFragmentActivity
{
  private b a;
  
  protected g b()
  {
    this.a = new b(this, this);
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
    setContentView(2130903229);
    getWindow().setFormat(-3);
    getWindow().clearFlags(134217728);
    this.a.e();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/LiveWallpaperSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */