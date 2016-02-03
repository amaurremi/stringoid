package com.go.weatherex.a;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gtp.a.a.b.c;
import org.json.JSONObject;

class f
  extends AsyncTask
{
  private Context b;
  private String c;
  private String d;
  
  public f(d paramd, Context paramContext, String paramString1, String paramString2)
  {
    this.b = paramContext;
    this.c = paramString1;
    if (paramString2 != null) {}
    for (;;)
    {
      this.d = paramString2;
      return;
      paramString2 = "";
    }
  }
  
  protected String a(Object... paramVarArgs)
  {
    paramVarArgs = g.a(this.b, this.c, this.d);
    if (paramVarArgs != null) {}
    for (paramVarArgs = paramVarArgs.toString();; paramVarArgs = "")
    {
      c.a("ActivationManager", "phead --> " + paramVarArgs);
      if (!TextUtils.isEmpty(paramVarArgs)) {
        break;
      }
      return null;
    }
    if (y.p(this.b)) {}
    for (String str = "http://activatecode.3g.cn/activationcode/nlValifyclient.do";; str = "http://api.goforandroid.com/activationcode/nlValifyclient.do")
    {
      c.a("ActivationManager", "url --> " + str);
      paramVarArgs = g.b(this.b, str, paramVarArgs);
      c.a("ActivationManager", "【result】 --> " + paramVarArgs);
      return paramVarArgs;
    }
  }
  
  protected void a(String paramString)
  {
    super.onPostExecute(paramString);
    if (d.a(this.a) != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        break label160;
      }
      if (paramString.equals("200")) {
        d.a(this.a).a(1);
      }
    }
    else
    {
      return;
    }
    if (paramString.equals("400"))
    {
      d.a(this.a).a(2);
      return;
    }
    if (paramString.equals("401"))
    {
      d.a(this.a).a(3);
      return;
    }
    if (paramString.equals("402"))
    {
      d.a(this.a).a(4);
      return;
    }
    if ((paramString.equals("405")) || (paramString.equals("406")))
    {
      d.a(this.a).a(5);
      return;
    }
    d.a(this.a).a(0);
    return;
    label160:
    d.a(this.a).a(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */