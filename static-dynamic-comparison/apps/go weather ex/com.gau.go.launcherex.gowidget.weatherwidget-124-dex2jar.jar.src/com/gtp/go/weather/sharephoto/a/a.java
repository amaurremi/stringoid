package com.gtp.go.weather.sharephoto.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gtp.go.weather.sharephoto.award.k;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  @SuppressLint({"HandlerLeak"})
  Handler a = new b(this);
  private Context b;
  private boolean c = false;
  private d d;
  private e e;
  
  public a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private JSONObject a(int paramInt, String paramString, Context paramContext)
  {
    paramContext = new JSONObject();
    try
    {
      f.a(paramContext, "userId", paramString);
      f.a(paramContext, "type", paramInt);
      return paramContext;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return paramContext;
  }
  
  private void c()
  {
    k.a(this.b);
  }
  
  private void d()
  {
    k.b(this.b);
  }
  
  public void a()
  {
    if (!y.h(this.b)) {
      a(false);
    }
  }
  
  public void a(d paramd)
  {
    this.d = paramd;
  }
  
  public void a(e parame)
  {
    this.e = parame;
  }
  
  public void a(boolean paramBoolean)
  {
    com.gtp.a.a.b.c.a("GOID", "registGOID");
    if (y.a()) {
      return;
    }
    com.gtp.a.a.b.c.a("GOID", "SDCard is not exist");
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!this.c))
    {
      this.c = true;
      new c(this, paramBoolean, paramString, null).execute(new Object[0]);
    }
  }
  
  public void b()
  {
    this.e = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */