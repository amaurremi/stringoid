package com.tapjoy;

import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import com.tapjoy.mraid.view.MraidView;

public class TapjoyDailyRewardAdWebView
  extends TJAdUnitView
{
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.webView != null) {
      new RefreshTask(null).execute(new Void[0]);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    TapjoyConnectCore.viewWillOpen(2);
    TapjoyConnectCore.viewDidOpen(2);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (isFinishing())
    {
      TapjoyConnectCore.viewWillClose(2);
      TapjoyConnectCore.viewDidClose(2);
    }
  }
  
  private class RefreshTask
    extends AsyncTask<Void, Void, Boolean>
  {
    private RefreshTask() {}
    
    protected Boolean doInBackground(Void... paramVarArgs)
    {
      try
      {
        Thread.sleep(200L);
        return Boolean.valueOf(true);
      }
      catch (InterruptedException paramVarArgs)
      {
        for (;;)
        {
          paramVarArgs.printStackTrace();
        }
      }
    }
    
    protected void onPostExecute(Boolean paramBoolean)
    {
      if (TapjoyDailyRewardAdWebView.this.webView != null) {
        TapjoyDailyRewardAdWebView.this.webView.loadUrl("javascript:window.onorientationchange();");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TapjoyDailyRewardAdWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */