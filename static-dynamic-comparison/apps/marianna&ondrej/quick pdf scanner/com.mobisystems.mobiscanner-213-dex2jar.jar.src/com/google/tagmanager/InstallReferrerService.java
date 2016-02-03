package com.google.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.analytics.tracking.android.CampaignTrackingService;

public final class InstallReferrerService
  extends IntentService
{
  CampaignTrackingService aij;
  Context aik;
  
  public InstallReferrerService()
  {
    super("InstallReferrerService");
  }
  
  private void c(Context paramContext, Intent paramIntent)
  {
    if (this.aij == null) {
      this.aij = new CampaignTrackingService();
    }
    this.aij.a(paramContext, paramIntent);
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("referrer");
    if (this.aik != null) {}
    for (Context localContext = this.aik;; localContext = getApplicationContext())
    {
      e.i(localContext, str);
      c(localContext, paramIntent);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/InstallReferrerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */