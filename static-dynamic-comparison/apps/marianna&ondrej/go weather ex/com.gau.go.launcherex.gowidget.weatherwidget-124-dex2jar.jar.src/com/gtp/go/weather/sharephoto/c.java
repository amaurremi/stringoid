package com.gtp.go.weather.sharephoto;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gtp.go.weather.sharephoto.b.a.d;
import com.gtp.go.weather.sharephoto.b.e;
import java.util.List;

class c
  extends AsyncTask
{
  c(PhotoDetailActivity paramPhotoDetailActivity, long paramLong) {}
  
  protected e a(Long... paramVarArgs)
  {
    paramVarArgs = this.b;
    Object localObject1 = "photo_id=" + this.a;
    paramVarArgs = d.a(paramVarArgs, new String[] { "_id", "photo_id", "photo_path", "photo_upload_size", "watermark_path", "watermark_upload_size", "description", "city_id", "city_name" }, (String)localObject1, null);
    if ((paramVarArgs != null) && (!paramVarArgs.isEmpty()))
    {
      localObject1 = this.b.getContentResolver();
      Object localObject2 = WeatherContentProvider.x;
      String str = "photo_id=" + this.a;
      localObject1 = ((ContentResolver)localObject1).query((Uri)localObject2, new String[] { "photo_id" }, str, null, null);
      if (localObject1 != null)
      {
        localObject2 = this.b;
        if (((Cursor)localObject1).getCount() == 0) {
          break label203;
        }
      }
      label203:
      for (boolean bool = true;; bool = false)
      {
        PhotoDetailActivity.a((PhotoDetailActivity)localObject2, bool);
        ((Cursor)localObject1).close();
        return (e)paramVarArgs.get(0);
      }
    }
    return null;
  }
  
  protected void a(e parame)
  {
    if (parame != null)
    {
      String str1 = parame.g();
      String str2 = parame.h();
      PhotoDetailActivity.a(this.b, parame.c());
      PhotoDetailActivity.a(this.b, str1, str2);
      return;
    }
    com.gtp.a.a.b.c.a("lishen", "找不到id为" + this.a + "的图片。");
    this.b.finish();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */