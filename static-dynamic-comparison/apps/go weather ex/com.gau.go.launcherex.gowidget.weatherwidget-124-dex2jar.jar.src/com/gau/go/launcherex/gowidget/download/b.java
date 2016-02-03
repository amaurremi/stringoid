package com.gau.go.launcherex.gowidget.download;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;

public class b
{
  private static final String a = Environment.getExternalStorageDirectory() + "/GOWeatherEX/download/";
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    if ((paramContext == null) || (paramString1 == null) || ("".equals(paramString1.trim())) || (paramString2 == null) || ("".equals(paramString2.trim()))) {
      return;
    }
    String str = paramString1.trim();
    int i = str.lastIndexOf(".");
    paramString1 = str;
    if (i != -1)
    {
      paramString1 = str.substring(0, i);
      str = str.substring(i);
      paramString1 = paramString1 + "_" + System.currentTimeMillis() + str;
    }
    str = a + paramString1;
    Intent localIntent = new Intent();
    localIntent.setAction("com.gau.go.launcherex.gowidget.download.DownloadBrocastReceiver.GOWEATHER_DOWNLOAD_START");
    localIntent.setData(Uri.parse("download://"));
    localIntent.putExtra("download_task_id_key", paramLong);
    localIntent.putExtra("download_file_name_key", paramString1);
    localIntent.putExtra("download_url_key", paramString2);
    localIntent.putExtra("download_save_file_path_key", str);
    localIntent.putExtra("download_package_name_key", paramString3);
    paramContext.sendBroadcast(localIntent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/download/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */