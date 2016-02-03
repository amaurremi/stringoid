package com.google.android.gms.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerService
  extends IntentService
{
  CampaignTrackingService WE;
  Context WF;
  
  public InstallReferrerService()
  {
    super("InstallReferrerService");
  }
  
  private void b(Context paramContext, Intent paramIntent)
  {
    if (this.WE == null) {
      this.WE = new CampaignTrackingService();
    }
    this.WE.a(paramContext, paramIntent);
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("referrer");
    if (this.WF != null) {}
    for (Context localContext = this.WF;; localContext = getApplicationContext())
    {
      i.g(localContext, str);
      b(localContext, paramIntent);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/tagmanager/InstallReferrerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */