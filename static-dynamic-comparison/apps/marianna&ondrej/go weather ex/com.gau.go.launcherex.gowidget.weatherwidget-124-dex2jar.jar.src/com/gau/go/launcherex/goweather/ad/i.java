package com.gau.go.launcherex.goweather.ad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.gau.go.launcherex.goweather.ad.a.b;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;

class i
  implements View.OnClickListener
{
  i(InlandAdView paramInlandAdView) {}
  
  public void onClick(View paramView)
  {
    paramView = GoWidgetApplication.c(InlandAdView.a(this.a)).a().edit();
    paramView.putInt("key_inland_ad_show_count", 0);
    paramView.commit();
    this.a.a();
    paramView = (b)InlandAdView.b(this.a).f().get(InlandAdView.c(this.a));
    if (paramView != null)
    {
      Intent localIntent = new Intent(InlandAdView.a(this.a), AdWebviewActivity.class);
      localIntent.putExtra("intent_extre_url", paramView.c);
      InlandAdView.a(this.a).startActivity(localIntent);
      ((Activity)InlandAdView.a(this.a)).overridePendingTransition(2130968604, 2130968605);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/goweather/ad/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */