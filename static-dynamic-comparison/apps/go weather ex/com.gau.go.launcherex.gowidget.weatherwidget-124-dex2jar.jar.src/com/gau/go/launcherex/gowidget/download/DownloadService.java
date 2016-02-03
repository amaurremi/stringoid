package com.gau.go.launcherex.gowidget.download;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadService
  extends Service
{
  private int a = 0;
  
  public void a(e parame)
  {
    if (parame != null) {
      new d(this, parame).execute(new Object[] { new Object() });
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.a += 1;
    if (paramIntent != null)
    {
      Object localObject = Long.valueOf(paramIntent.getLongExtra("download_task_id_key", -1L));
      if (((Long)localObject).longValue() != -1L)
      {
        c localc = c.a(getApplicationContext());
        if ((localc != null) && (localc.a() != null))
        {
          localObject = (e)localc.a().get(localObject);
          if (localObject != null) {
            a((e)localObject);
          }
        }
      }
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/download/DownloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */