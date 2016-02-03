package com.gau.go.launcherex.gowidget.messagecenter.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.Window;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;

public class GCMMsgDetailActivity
  extends GoWeatherEXActivity
{
  TextView a = null;
  TextView b = null;
  TextView c = null;
  private boolean d = true;
  
  private void a(Intent paramIntent)
  {
    Object localObject3 = "";
    Object localObject2 = "";
    Object localObject1 = "";
    String str1 = "";
    Object localObject4 = paramIntent.getExtras();
    paramIntent = str1;
    if (localObject4 != null)
    {
      str1 = ((Bundle)localObject4).getString("extras_bundle_msg_id");
      String str2 = ((Bundle)localObject4).getString("extras_bundle_msg_title");
      String str3 = ((Bundle)localObject4).getString("extras_bundle_msg_summary");
      String str4 = ((Bundle)localObject4).getString("extras_bundle_msg_time");
      localObject4 = ((Bundle)localObject4).getString("weather_alerts_lists_entrance");
      paramIntent = str4;
      localObject1 = str3;
      localObject2 = str2;
      localObject3 = str1;
      if (localObject4 != null)
      {
        paramIntent = str4;
        localObject1 = str3;
        localObject2 = str2;
        localObject3 = str1;
        if (((String)localObject4).equals("widget&notification"))
        {
          this.d = false;
          localObject3 = str1;
          localObject2 = str2;
          localObject1 = str3;
          paramIntent = str4;
        }
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(paramIntent)))
    {
      finish();
      return;
    }
    this.a.setText((CharSequence)localObject2);
    this.c.setText(paramIntent);
    this.b.setText(Html.fromHtml((String)localObject1));
    this.b.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903236);
    getWindow().clearFlags(134217728);
    this.a = ((TextView)findViewById(2131231720));
    this.b = ((TextView)findViewById(2131231721));
    this.c = ((TextView)findViewById(2131231722));
    a(getIntent());
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
  
  protected void onStop()
  {
    super.onStop();
    if (!this.d) {
      finish();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/view/GCMMsgDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */