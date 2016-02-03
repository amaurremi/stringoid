package com.go.weatherex.d;

import android.os.AsyncTask;
import com.jiubang.goweather.b.c;
import com.jiubang.goweather.b.d;
import com.jiubang.goweather.b.e;
import com.jiubang.goweather.b.f;

final class g
  extends AsyncTask
{
  g(String paramString) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = d.a(true);
    long l = System.currentTimeMillis() / 1000L;
    paramVarArgs.b(this.a + "&ts=" + l, new e(this.a), new f());
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */