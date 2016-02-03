package com.gtp.go.weather.coupon.a;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.gtp.a.a.b.c;
import com.gtp.go.weather.coupon.c.a;
import org.json.JSONException;
import org.json.JSONObject;

class j
  extends AsyncTask
{
  private String b;
  private long c;
  private i d;
  
  public j(e parame, String paramString, long paramLong, i parami)
  {
    this.b = paramString;
    this.c = paramLong;
    this.d = parami;
  }
  
  protected Boolean a(Object... paramVarArgs)
  {
    boolean bool2 = false;
    if ((this.c == 0L) || (TextUtils.isEmpty(this.b))) {
      return Boolean.valueOf(false);
    }
    paramVarArgs = a.a(e.a(this.a), "http://www.retailmenot.com/ajax/sendCouponEmail.php", this.c, this.b);
    if (!TextUtils.isEmpty(paramVarArgs)) {
      for (;;)
      {
        try
        {
          paramVarArgs = new JSONObject(paramVarArgs);
          if (paramVarArgs == null) {
            continue;
          }
          paramVarArgs = paramVarArgs.optString("form");
          boolean bool3 = TextUtils.isEmpty(paramVarArgs);
          bool1 = bool2;
          if (!bool3) {
            bool1 = true;
          }
        }
        catch (JSONException paramVarArgs)
        {
          boolean bool1 = bool2;
          if (!c.a()) {
            continue;
          }
          paramVarArgs.printStackTrace();
          bool1 = bool2;
          continue;
        }
        return Boolean.valueOf(bool1);
        paramVarArgs = null;
      }
    }
    return Boolean.valueOf(false);
  }
  
  protected void a(Boolean paramBoolean)
  {
    super.onPostExecute(paramBoolean);
    if (this.d != null)
    {
      this.d.a(paramBoolean.booleanValue());
      this.d = null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */