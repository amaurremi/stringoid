package com.gau.go.launcherex.gowidget.statistics;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.gau.go.launcherex.gowidget.weather.model.FeedbackBean;
import com.gau.go.launcherex.gowidget.weather.service.NotifyService;

public class d
{
  private final Context a;
  
  public d(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, NotifyService.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("notify_request", 36);
    localBundle.putInt("key_intent_code", paramInt);
    if (paramBundle != null) {
      localBundle.putBundle("key_intent_extras", paramBundle);
    }
    localIntent.putExtras(localBundle);
    paramContext.startService(localIntent);
  }
  
  public void a(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    switch (paramIntent.getInt("key_intent_code", -1))
    {
    default: 
      return;
    case 1: 
      new f(this, null).execute(new Void[0]);
      return;
    }
    paramIntent = (FeedbackBean)paramIntent.getBundle("key_intent_extras").getParcelable("upload_statistics_data_file_2_extra_feedback_bean");
    new g(this, null).execute(new FeedbackBean[] { paramIntent });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */