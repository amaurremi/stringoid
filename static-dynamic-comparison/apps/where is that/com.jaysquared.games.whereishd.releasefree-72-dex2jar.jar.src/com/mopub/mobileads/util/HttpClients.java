package com.mopub.mobileads.util;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;

public class HttpClients
{
  public static void safeShutdown(HttpClient paramHttpClient)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        if ((this.val$httpClient != null) && (this.val$httpClient.getConnectionManager() != null)) {
          this.val$httpClient.getConnectionManager().shutdown();
        }
      }
    }).start();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/mopub/mobileads/util/HttpClients.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */