package com.gtp.go.weather.sharephoto.photo;

import android.os.AsyncTask;
import com.gtp.go.weather.sharephoto.b.g;
import java.util.ArrayList;

class ae
  extends AsyncTask
{
  ae(ad paramad, a parama, long paramLong) {}
  
  protected g a(Long... paramVarArgs)
  {
    Object localObject = null;
    paramVarArgs = "photo_id=" + String.valueOf(paramVarArgs[0]);
    ArrayList localArrayList = this.c.b(new String[] { "photo_id", "user_id", "photo_type", "favour", "backcount", "is_myfavourite", "city_id", "city", "belong_page", "image_type", "up_time_long", "up_time_date", "desc", "addr", "latlng", "original_url", "original_path", "original_w_h", "watermark_url", "watermark_path", "watermark_w_h", "compose_url", "compose_path", "compose_w_h" }, paramVarArgs, null);
    paramVarArgs = (Long[])localObject;
    if (localArrayList != null)
    {
      paramVarArgs = (Long[])localObject;
      if (!localArrayList.isEmpty()) {
        paramVarArgs = (g)localArrayList.get(0);
      }
    }
    return paramVarArgs;
  }
  
  protected void a(g paramg)
  {
    if (this.a != null) {
      this.a.a(Long.valueOf(this.b), paramg);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */