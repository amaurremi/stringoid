package com.jiubang.goweather.c;

import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.language.d;
import com.gau.go.launcherex.gowidget.weather.model.b;
import com.jiubang.goweather.b.f;
import java.util.List;

public class a
  extends AsyncTask
{
  private Context a;
  private p b;
  private Location c;
  private f d;
  private String e;
  
  public a(Context paramContext, p paramp, Location paramLocation)
  {
    this.a = paramContext;
    this.b = paramp;
    this.c = paramLocation;
    this.d = new f();
    this.e = d.a(this.a).d();
    if (TextUtils.isEmpty(this.e)) {
      this.e = com.jiubang.goweather.e.a.a(paramContext);
    }
  }
  
  protected b a(Object... paramVarArgs)
  {
    paramVarArgs = (Location)paramVarArgs[0];
    paramVarArgs = u.a(this.a, paramVarArgs, this.d, this.e);
    if ((paramVarArgs != null) && (paramVarArgs.size() > 0)) {
      return (b)paramVarArgs.get(0);
    }
    return null;
  }
  
  protected void a(b paramb)
  {
    if (paramb != null)
    {
      this.b.a(paramb, this.c);
      return;
    }
    this.b.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/goweather/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */