package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class CampaignTrackingReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("referrer");
    if ((!"com.android.vending.INSTALL_REFERRER".equals(paramIntent.getAction())) || (str == null)) {
      return;
    }
    paramIntent = new Intent(paramContext, CampaignTrackingService.class);
    paramIntent.putExtra("referrer", str);
    paramContext.startService(paramIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/analytics/CampaignTrackingReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */