package com.gtp.go.weather.coupon.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.weather.provider.WeatherContentProvider;
import com.gtp.go.weather.coupon.b.b;

class c
  extends AsyncTask
{
  private b b;
  
  public c(a parama, b paramb)
  {
    this.b = paramb;
  }
  
  protected Object doInBackground(Object... paramVarArgs)
  {
    paramVarArgs = new ContentValues();
    paramVarArgs.put("coupon_id", Long.valueOf(this.b.b()));
    paramVarArgs.put("source_coupon_id", Long.valueOf(this.b.c()));
    paramVarArgs.put("title", this.b.d());
    paramVarArgs.put("desc", this.b.e());
    paramVarArgs.put("shop_name", this.b.m());
    paramVarArgs.put("coupon_type", Integer.valueOf(this.b.f()));
    paramVarArgs.put("exp_time", this.b.g());
    paramVarArgs.put("code", this.b.h());
    paramVarArgs.put("logo_url", this.b.i());
    paramVarArgs.put("logo_path", this.b.j());
    a.a(this.a).getContentResolver().insert(WeatherContentProvider.C, paramVarArgs);
    return null;
  }
  
  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */