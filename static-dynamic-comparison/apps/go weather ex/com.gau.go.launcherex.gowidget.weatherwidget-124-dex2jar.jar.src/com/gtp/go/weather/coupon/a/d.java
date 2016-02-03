package com.gtp.go.weather.coupon.a;

import android.os.AsyncTask;
import java.util.ArrayList;

class d
  extends AsyncTask
{
  private com.gtp.go.weather.coupon.a b;
  
  public d(a parama, com.gtp.go.weather.coupon.a parama1)
  {
    this.b = parama1;
  }
  
  protected ArrayList a(Object... paramVarArgs)
  {
    return a.a(a.a(this.a), new String[] { "coupon_id", "source_coupon_id", "title", "desc", "shop_name", "coupon_type", "exp_time", "code", "logo_url", "logo_path" }, null, null);
  }
  
  protected void a(ArrayList paramArrayList)
  {
    super.onPostExecute(paramArrayList);
    if (this.b != null)
    {
      this.b.a(a.a(this.a, paramArrayList));
      this.b = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */