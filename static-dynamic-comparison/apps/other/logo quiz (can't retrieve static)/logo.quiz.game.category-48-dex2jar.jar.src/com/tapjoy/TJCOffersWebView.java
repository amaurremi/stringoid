package com.tapjoy;

import android.annotation.TargetApi;
import android.os.Bundle;
import com.tapjoy.mraid.view.MraidView;

@TargetApi(9)
public class TJCOffersWebView
  extends TJAdUnitView
{
  private static final String TAG = "Offers";
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    TapjoyConnectCore.viewWillOpen(0);
    TapjoyConnectCore.viewDidOpen(0);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((!this.skipOfferWall) && (isFinishing()))
    {
      TapjoyConnectCore.viewWillClose(0);
      TapjoyConnectCore.viewDidClose(0);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((this.offersURL != null) && (this.webView != null) && (this.pauseCalled == true) && (this.redirectedActivity == true))
    {
      TapjoyLog.i("Offers", "onResume reload offer wall: " + this.offersURL);
      this.webView.loadUrl(this.offersURL);
      this.historyIndex += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TJCOffersWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */