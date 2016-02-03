package com.vungle.publisher.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.vungle.publisher.bq;
import com.vungle.publisher.br;
import com.vungle.publisher.log.Logger;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class AndroidNetwork
  implements br
{
  @Inject
  ConnectivityManager a;
  @Inject
  Provider<NetworkBroadcastReceiver> b;
  @Inject
  TelephonyManager c;
  
  public final bq a()
  {
    for (;;)
    {
      try
      {
        localObject = this.a.getActiveNetworkInfo();
        if (localObject == null) {
          break;
        }
        int i = ((NetworkInfo)localObject).getType();
        switch (i)
        {
        case 1: 
          Logger.d("VungleNetwork", "unknown connectivity type: " + i);
          return null;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        Logger.d("VungleNetwork", "error getting connectivity type", localException);
        return null;
      }
      return bq.b;
      localObject = bq.a;
      return (bq)localObject;
    }
    return null;
  }
  
  public final String b()
  {
    try
    {
      String str = this.c.getNetworkOperatorName();
      return str;
    }
    catch (Exception localException)
    {
      Logger.d("VungleNetwork", "error getting network operator", localException);
    }
    return null;
  }
  
  public final boolean c()
  {
    try
    {
      boolean bool = this.a.getActiveNetworkInfo().isConnected();
      return bool;
    }
    catch (Exception localException)
    {
      Logger.d("VungleNetwork", "error getting connectivity availability", localException);
    }
    return false;
  }
  
  public final void d()
  {
    NetworkBroadcastReceiver localNetworkBroadcastReceiver = (NetworkBroadcastReceiver)this.b.get();
    String str;
    if (!localNetworkBroadcastReceiver.c.c()) {
      str = Thread.currentThread().getName();
    }
    try
    {
      if ((!localNetworkBroadcastReceiver.a) && (!localNetworkBroadcastReceiver.c.c())) {
        localNetworkBroadcastReceiver.a(true);
      }
      for (;;)
      {
        boolean bool = localNetworkBroadcastReceiver.a;
        if (!bool) {
          break;
        }
        try
        {
          Logger.d("VungleNetwork", "Waiting for network availability: " + str);
          localNetworkBroadcastReceiver.wait();
          Logger.d("VungleNetwork", "Connectivity restored: " + str);
        }
        catch (InterruptedException localInterruptedException) {}
      }
      return;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/net/AndroidNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */