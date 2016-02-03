package com.flurry.android;

import android.util.Log;
import com.inmobi.androidsdk.IMAdListener;
import com.inmobi.androidsdk.IMAdRequest.ErrorCode;
import com.inmobi.androidsdk.IMAdView;
import java.util.Collections;

final class as
  implements IMAdListener
{
  as(an paraman) {}
  
  public final void onAdRequestCompleted(IMAdView paramIMAdView)
  {
    this.bM.onAdFilled(Collections.emptyMap());
    this.bM.onAdShown(Collections.emptyMap());
    Log.d(an.d(), "InMobi imAdView ad request completed.");
  }
  
  public final void onAdRequestFailed(IMAdView paramIMAdView, IMAdRequest.ErrorCode paramErrorCode)
  {
    this.bM.onRenderFailed(Collections.emptyMap());
    Log.d(an.d(), "InMobi imAdView ad request failed.");
  }
  
  public final void onDismissAdScreen(IMAdView paramIMAdView)
  {
    this.bM.onAdClosed(Collections.emptyMap());
    Log.d(an.d(), "InMobi imAdView dismiss ad.");
  }
  
  public final void onLeaveApplication(IMAdView paramIMAdView)
  {
    Log.d(an.d(), "InMobi onLeaveApplication");
  }
  
  public final void onShowAdScreen(IMAdView paramIMAdView)
  {
    this.bM.onAdClicked(Collections.emptyMap());
    Log.d(an.d(), "InMobi imAdView ad shown.");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */