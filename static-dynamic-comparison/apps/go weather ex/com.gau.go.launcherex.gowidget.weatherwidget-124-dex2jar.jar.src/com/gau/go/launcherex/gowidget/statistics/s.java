package com.gau.go.launcherex.gowidget.statistics;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.gau.go.gostaticsdk.d;
import com.gau.go.launcherex.gowidget.statistics.a.a;

class s
  extends AsyncTask
{
  private a b;
  
  public s(r paramr, a parama)
  {
    this.b = parama;
  }
  
  protected String a(Void... paramVarArgs)
  {
    Object localObject = null;
    paramVarArgs = (Void[])localObject;
    if (this.b != null)
    {
      paramVarArgs = (Void[])localObject;
      if (!TextUtils.isEmpty(this.b.c())) {
        paramVarArgs = r.a(this.a, r.a(this.a), this.b);
      }
    }
    return paramVarArgs;
  }
  
  protected void a(String paramString)
  {
    super.onPostExecute(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      d.a(r.a(this.a)).a(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */