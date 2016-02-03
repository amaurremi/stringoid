package com.gtp.go.weather.sharephoto.takephoto;

import android.location.Location;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.y;
import java.util.HashMap;

class p
  extends AsyncTask
{
  private p(m paramm) {}
  
  protected q a(Location... paramVarArgs)
  {
    Object localObject = paramVarArgs[0];
    paramVarArgs = new q();
    q.a(paramVarArgs, (Location)localObject);
    q.a(paramVarArgs, m.b(this.a, (Location)localObject));
    String str2 = m.a(this.a, m.c(this.a), (Location)localObject, "en");
    if (!TextUtils.isEmpty(str2)) {
      q.b(paramVarArgs).put("en", str2);
    }
    String str1 = y.k(m.c(this.a));
    if (!TextUtils.isEmpty(str2))
    {
      localObject = m.a(this.a, m.c(this.a), (Location)localObject, str1);
      q.b(paramVarArgs).put(str1, localObject);
    }
    return paramVarArgs;
  }
  
  protected void a(q paramq)
  {
    m.a(this.a, SystemClock.elapsedRealtime());
    m.a(this.a, paramq);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */