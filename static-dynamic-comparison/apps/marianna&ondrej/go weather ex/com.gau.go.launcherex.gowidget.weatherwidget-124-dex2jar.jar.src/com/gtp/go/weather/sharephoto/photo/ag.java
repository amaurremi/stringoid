package com.gtp.go.weather.sharephoto.photo;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gtp.go.weather.sharephoto.takephoto.ab;

class ag
  extends AsyncTask
{
  ag(ad paramad, ContentResolver paramContentResolver, long paramLong) {}
  
  protected Void a(Void... paramVarArgs)
  {
    if (this.a.delete(WeatherContentProvider.v, "photo_id = ? AND (photo_type = ? OR ( photo_type = ? AND image_type = ? ))", new String[] { String.valueOf(this.b), String.valueOf(3), String.valueOf(2), String.valueOf(1) }) < 1)
    {
      this.a.delete(WeatherContentProvider.w, "photo_id = ?", new String[] { String.valueOf(this.b) });
      r.a(ab.a(this.b));
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    paramVoid = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DELETE_USER_PHOTO");
    paramVoid.putExtra("extra_delete_photo_id", this.b);
    ad.b(this.c).sendBroadcast(paramVoid);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */