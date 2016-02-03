package com.gau.go.launcherex.gowidget.gcm;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.util.f;
import java.util.ArrayList;

class d
  extends AsyncTask
{
  private e b;
  
  d(b paramb) {}
  
  protected Integer a(e... paramVarArgs)
  {
    this.b = paramVarArgs[0];
    paramVarArgs = this.b.a;
    if ((paramVarArgs != null) && (paramVarArgs.length() > 0))
    {
      int i = new a(paramVarArgs).a();
      com.gtp.a.a.a.a.a().a("Url : " + paramVarArgs + "--- Result : " + i, "gcm_log.txt");
      if ((i == 200) || (i == 401)) {
        return Integer.valueOf(1);
      }
    }
    return Integer.valueOf(0);
  }
  
  protected void a(Integer paramInteger)
  {
    if (paramInteger.intValue() == 1)
    {
      if (this.b.b == 1)
      {
        paramInteger = GoWidgetApplication.c(b.a(this.a).getApplicationContext()).a().edit();
        paramInteger.putString("gcm_cur_reg_id", this.b.c);
        paramInteger.commit();
        b.b(this.a).remove(this.b);
        b.a(this.a, false);
        if (f.a(b.a(this.a)).e() > 0) {
          this.a.b();
        }
      }
      do
      {
        return;
        if (this.b.b != 2) {
          break label238;
        }
        paramInteger = GoWidgetApplication.c(b.a(this.a).getApplicationContext()).a().edit();
        paramInteger.putString("gcm_cur_reg_id", this.b.c);
        paramInteger.commit();
        b.a(this.a, false);
        if (!this.b.d) {
          break;
        }
        b.b(this.a).remove(this.b);
      } while (f.a(b.a(this.a)).e() <= 0);
      this.a.b();
      return;
      b.a(this.a, this.b);
      return;
      label238:
      b.a(this.a, this.b);
      return;
    }
    if (this.b.b == 2)
    {
      paramInteger = GoWidgetApplication.c(b.a(this.a).getApplicationContext()).a().edit();
      paramInteger.remove("gcm_cur_reg_id");
      paramInteger.commit();
      b.a(this.a, false);
      this.a.c();
      return;
    }
    b.a(this.a, false);
    b.c(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/gcm/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */