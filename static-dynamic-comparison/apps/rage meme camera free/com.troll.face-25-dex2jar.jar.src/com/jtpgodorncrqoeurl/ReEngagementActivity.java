package com.jtpgodorncrqoeurl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

public class ReEngagementActivity
  extends Activity
{
  private ProgressDialog a;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      paramBundle = getIntent().getExtras();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getString("sectionid");
        AdLog.d("LBAdController", "Section Id passed - " + paramBundle);
        this.a = ProgressDialog.show(this, "", "Loading App....Please Wait!", true);
        new AdController(this, paramBundle, new af(this)).loadAd();
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/ReEngagementActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */