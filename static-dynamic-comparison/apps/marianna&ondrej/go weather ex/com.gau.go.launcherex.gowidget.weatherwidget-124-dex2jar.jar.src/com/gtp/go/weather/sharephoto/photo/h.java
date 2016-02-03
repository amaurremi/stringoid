package com.gtp.go.weather.sharephoto.photo;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.globaltheme.a.b.b;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gtp.a.a.b.c;
import com.gtp.go.weather.sharephoto.b.g;
import java.io.File;
import java.util.HashMap;

class h
  extends AsyncTask
{
  private h(f paramf) {}
  
  protected g a(g... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    if ((paramVarArgs != null) && (!TextUtils.isEmpty(paramVarArgs.x())))
    {
      c.a("download_photo", "=================》Url = " + paramVarArgs.x());
      Object localObject = new File(ad.a + f.a(this.a, paramVarArgs.x()) + ".png");
      c.a("download_photo", "=================》File = " + ((File)localObject).toString());
      if (!((File)localObject).exists())
      {
        if (y.a())
        {
          localObject = new File(ad.a);
          if (!((File)localObject).exists()) {
            ((File)localObject).mkdirs();
          }
          localObject = ((File)localObject).getPath() + File.separator + f.a(this.a, paramVarArgs.x()) + ".png";
          if (b.a(paramVarArgs.x(), f.a(this.a), (String)localObject))
          {
            c.a("download_photo", "=================》imgPath = " + (String)localObject);
            paramVarArgs.m((String)localObject);
            localObject = new ContentValues();
            ((ContentValues)localObject).put("compose_path", paramVarArgs.y());
            f.a(this.a).getContentResolver().update(WeatherContentProvider.v, (ContentValues)localObject, "photo_id=?", new String[] { String.valueOf(paramVarArgs.a()) });
            return paramVarArgs;
          }
        }
      }
      else
      {
        paramVarArgs.m(((File)localObject).getAbsolutePath());
        localObject = new ContentValues();
        ((ContentValues)localObject).put("compose_path", paramVarArgs.y());
        f.a(this.a).getContentResolver().update(WeatherContentProvider.v, (ContentValues)localObject, "photo_id=?", new String[] { String.valueOf(paramVarArgs.a()) });
        return paramVarArgs;
      }
    }
    f.b(this.a).remove(Long.valueOf(paramVarArgs.a()));
    return null;
  }
  
  protected void a(g paramg)
  {
    if (paramg != null)
    {
      long l = paramg.a();
      paramg = paramg.y();
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_SHARE_PHOTO_REFRESH");
      localIntent.putExtra("extra_share_photo_id", l);
      localIntent.putExtra("extra_share_photo_path", paramg);
      f.a(this.a).sendBroadcast(localIntent);
    }
    f.c(this.a);
    f.d(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */