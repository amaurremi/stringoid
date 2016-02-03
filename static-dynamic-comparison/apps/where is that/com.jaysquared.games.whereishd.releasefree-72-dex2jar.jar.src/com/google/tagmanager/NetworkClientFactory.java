package com.google.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;

class NetworkClientFactory
{
  public NetworkClient createNetworkClient()
  {
    if (getSdkVersion() < 8) {
      return new HttpNetworkClient();
    }
    return new HttpUrlConnectionNetworkClient();
  }
  
  @VisibleForTesting
  int getSdkVersion()
  {
    return Build.VERSION.SDK_INT;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/NetworkClientFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */