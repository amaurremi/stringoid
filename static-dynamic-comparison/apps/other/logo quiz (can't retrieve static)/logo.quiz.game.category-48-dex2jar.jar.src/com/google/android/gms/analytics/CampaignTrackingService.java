package com.google.android.gms.analytics;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import java.io.IOException;
import java.io.OutputStream;

public class CampaignTrackingService
  extends IntentService
{
  public CampaignTrackingService()
  {
    super("CampaignIntentService");
  }
  
  public CampaignTrackingService(String paramString)
  {
    super(paramString);
  }
  
  public void onHandleIntent(Intent paramIntent)
  {
    processIntent(this, paramIntent);
  }
  
  public void processIntent(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("referrer");
    try
    {
      paramContext = paramContext.openFileOutput("gaInstallData", 0);
      paramContext.write(paramIntent.getBytes());
      paramContext.close();
      z.V("Stored campaign information.");
      return;
    }
    catch (IOException paramContext)
    {
      z.T("Error storing install campaign.");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/analytics/CampaignTrackingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */