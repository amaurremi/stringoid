package com.google.android.gms.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerService
  extends IntentService
{
  CampaignTrackingService apl;
  Context apm;
  
  public InstallReferrerService()
  {
    super("InstallReferrerService");
  }
  
  public InstallReferrerService(String paramString)
  {
    super(paramString);
  }
  
  private void a(Context paramContext, Intent paramIntent)
  {
    if (this.apl == null) {
      this.apl = new CampaignTrackingService();
    }
    this.apl.processIntent(paramContext, paramIntent);
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("referrer");
    if (this.apm != null) {}
    for (Context localContext = this.apm;; localContext = getApplicationContext())
    {
      ay.d(localContext, str);
      a(localContext, paramIntent);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/tagmanager/InstallReferrerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */