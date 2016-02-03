package com.gtp.go.weather.sharephoto.photo;

import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;

class al
  extends AsyncTask
{
  private int b;
  private String c;
  
  public al(ad paramad, boolean paramBoolean, int paramInt, String paramString)
  {
    this.b = paramInt;
    this.c = paramString;
  }
  
  protected ArrayList a(Object... paramVarArgs)
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.c))
    {
      localObject = "photo_type=? and city_id=?";
      paramVarArgs = new String[2];
      paramVarArgs[0] = String.valueOf(this.b);
      paramVarArgs[1] = this.c;
    }
    for (;;)
    {
      paramVarArgs = this.a.b(new String[] { "photo_id", "user_id", "photo_type", "favour", "backcount", "is_myfavourite", "city_id", "city", "belong_page", "image_type", "up_time_long", "up_time_date", "desc", "addr", "latlng", "original_url", "original_path", "original_w_h", "watermark_url", "watermark_path", "watermark_w_h", "compose_url", "compose_path", "compose_w_h" }, (String)localObject, paramVarArgs);
      localObject = this.a.a(new String[] { "photo_id", "data_type", "data_value" }, "data_type=?", new String[] { String.valueOf(1) });
      ad.a(this.a, paramVarArgs, (HashMap)localObject);
      return paramVarArgs;
      localObject = "photo_type=?";
      paramVarArgs = new String[1];
      paramVarArgs[0] = String.valueOf(this.b);
    }
  }
  
  protected void a(ArrayList paramArrayList)
  {
    super.onPostExecute(paramArrayList);
    if (ad.a(this.a) != null) {
      ad.a(this.a).a(this.b, this.c, paramArrayList);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */