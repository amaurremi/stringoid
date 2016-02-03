package com.ideashower.readitlater.activity;

import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

public class StandaloneItemsTaggingActivity
  extends ItemsTaggingActivity
{
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/StandaloneItemsTaggingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */