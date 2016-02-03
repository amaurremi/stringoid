package com.gau.go.launcherex.gowidget.weather.dynamicbackground.preview;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.gau.go.launcherex.gowidget.scriptengine.parser.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

class b
  extends Handler
{
  b(a parama) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 1)
    {
      localObject = (Object[])paramMessage.obj;
      paramMessage = (String)localObject[0];
      localObject = (z)localObject[1];
      this.a.a.put(paramMessage, localObject);
      if (a.a(this.a) == this.a.a.size())
      {
        paramMessage = a.b(this.a);
        localObject = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_SCREEN_BACKGROUND_PREVIEW_DONE");
        ((Intent)localObject).putParcelableArrayListExtra("extra_dynamicbackground_preview", paramMessage);
        a.c(this.a).sendBroadcast((Intent)localObject);
      }
    }
    while (paramMessage.what != 0) {
      return;
    }
    paramMessage = a.d(this.a);
    a.a(this.a, paramMessage.size());
    Object localObject = paramMessage.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      a.e(this.a).execute(new c(this.a, a.c(this.a), str, true, false));
    }
    paramMessage.clear();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/dynamicbackground/preview/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */