package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;

class CtfeHost
{
  private static final String CTFE_SERVER_ADDRESS = "https://www.googletagmanager.com";
  @VisibleForTesting
  static final String CTFE_URL_PATH_PREFIX = "/d?";
  static final String DEBUG_EVENT_NUMBER_QUERY = "&event_number=";
  private String mCtfeServerAddress = "https://www.googletagmanager.com";
  
  String constructCtfeDebugUrl(int paramInt)
  {
    return this.mCtfeServerAddress + "/d?" + PreviewManager.getInstance().getCTFEUrlDebugQuery() + "&event_number=" + paramInt;
  }
  
  public String getCtfeServerAddress()
  {
    return this.mCtfeServerAddress;
  }
  
  public void setCtfeServerAddress(String paramString)
  {
    this.mCtfeServerAddress = paramString;
    Log.i("The Ctfe server endpoint was changed to: " + paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/CtfeHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */