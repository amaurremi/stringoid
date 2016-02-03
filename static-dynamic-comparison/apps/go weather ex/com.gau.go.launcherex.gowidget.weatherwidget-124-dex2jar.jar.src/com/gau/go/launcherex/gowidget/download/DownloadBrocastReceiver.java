package com.gau.go.launcherex.gowidget.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DownloadBrocastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {}
    c localc;
    long l;
    do
    {
      Object localObject;
      do
      {
        String str1;
        String str2;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  localObject = paramIntent.getAction();
                } while ((localObject == null) || ("".equals(((String)localObject).trim())));
                localc = c.a(paramContext.getApplicationContext());
                if (!"com.gau.go.launcherex.gowidget.download.DownloadBrocastReceiver.GOWEATHER_DOWNLOAD_STOP".equals(localObject)) {
                  break;
                }
                l = paramIntent.getLongExtra("download_task_id_key", Long.MIN_VALUE);
              } while ((l == Long.MIN_VALUE) || (localc == null));
              localc.a(l);
              return;
              if (!"com.gau.go.launcherex.gowidget.download.DownloadBrocastReceiver.GOWEATHER_DOWNLOAD_RESTART".equals(localObject)) {
                break;
              }
              l = paramIntent.getLongExtra("download_task_id_key", Long.MIN_VALUE);
            } while ((l == Long.MIN_VALUE) || (localc == null));
            localc.b(l);
            return;
            if (!"com.gau.go.launcherex.gowidget.download.DownloadBrocastReceiver.GOWEATHER_DOWNLOAD_START".equals(localObject)) {
              break;
            }
          } while (localc == null);
          l = paramIntent.getLongExtra("download_task_id_key", Long.MIN_VALUE);
          localObject = null;
          if (l != Long.MIN_VALUE) {
            localObject = localc.d(l);
          }
          str1 = paramIntent.getStringExtra("download_file_name_key");
          str2 = paramIntent.getStringExtra("download_url_key");
          String str3 = paramIntent.getStringExtra("download_save_file_path_key");
          paramIntent = paramIntent.getStringExtra("download_package_name_key");
          if (localObject == null)
          {
            paramIntent = new e(l, str2, str1, 0L, 0, str3, paramIntent);
            paramIntent.a(new a(paramContext.getApplicationContext()));
            localc.a(paramIntent);
            return;
          }
        } while ((((e)localObject).h() != 7) && (((e)localObject).h() != 4));
        ((e)localObject).b(str1);
        ((e)localObject).a(str2);
        localc.b((e)localObject);
        return;
      } while (!"com.gau.go.launcherex.gowidget.download.DownloadBrocastReceiver.GOWEATHER_DOWNLOAD_DELETE".equals(localObject));
      l = paramIntent.getLongExtra("download_task_id_key", Long.MIN_VALUE);
    } while ((l == Long.MIN_VALUE) || (localc == null));
    localc.c(l);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/download/DownloadBrocastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */