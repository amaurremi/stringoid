package com.tapjoy;

import android.os.Bundle;

public class TapjoyFullScreenAdWebView
  extends TJAdUnitView
{
  private static final String TAG = "Full Screen Ad";
  
  protected void onCreate(Bundle paramBundle)
  {
    TapjoyLog.i("Full Screen Ad", "TapjoyFullScreenAdWebView onCreate");
    super.onCreate(paramBundle);
    TapjoyConnectCore.viewWillOpen(1);
    TapjoyConnectCore.viewDidOpen(1);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (isFinishing())
    {
      TapjoyConnectCore.viewWillClose(1);
      TapjoyConnectCore.viewDidClose(1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TapjoyFullScreenAdWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */