package com.google.ads;

import java.util.Map;

public class InstalledAppsResponse
  implements AdResponse
{
  private final AdViewCommunicator mCommunicator;
  private final InstalledApplications mInstalledApps;
  
  public InstalledAppsResponse(InstalledApplications paramInstalledApplications, AdViewCommunicator paramAdViewCommunicator)
  {
    this.mInstalledApps = paramInstalledApplications;
    this.mCommunicator = paramAdViewCommunicator;
  }
  
  public void run(Map<String, String> paramMap, GoogleAdView paramGoogleAdView)
  {
    paramMap = this.mInstalledApps.getInstallationState();
    AdViewCommunicator.sendJavaScriptMessage(paramGoogleAdView.getWebView(), AdViewCommunicator.JsMessageAction.JS_REPORT_INSTALL_STATE, paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/InstalledAppsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */