package com.gtp.go.weather.sharephoto.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.gtp.a.a.b.c;
import java.util.concurrent.ConcurrentHashMap;

class k
  extends BroadcastReceiver
{
  k(d paramd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    c.a("UploadLikeAndBgHandler", "UploadLikeAndBgHandler.action = " + paramContext);
    if ("LIKE_OR_BG_UPLOAD".equals(paramContext))
    {
      paramContext = d.g(this.a).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()))
      {
        paramContext = new ConcurrentHashMap(d.c(this.a));
        paramIntent = new ConcurrentHashMap(d.d(this.a));
        localConcurrentHashMap = new ConcurrentHashMap(d.e(this.a));
        new f(this.a, paramContext, paramIntent, localConcurrentHashMap).execute(new Void[0]);
      }
    }
    do
    {
      do
      {
        return;
        d.b(this.a, true);
        return;
      } while (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext));
      paramContext = d.g(this.a).getActiveNetworkInfo();
    } while ((paramContext == null) || (!paramContext.isConnected()) || (!d.h(this.a)));
    d.b(this.a, false);
    paramContext = new ConcurrentHashMap(d.c(this.a));
    paramIntent = new ConcurrentHashMap(d.d(this.a));
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(d.e(this.a));
    new f(this.a, paramContext, paramIntent, localConcurrentHashMap).execute(new Void[0]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */