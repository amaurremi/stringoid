package com.gau.go.launcherex.gowidget.messagecenter.util;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.gau.go.launcherex.gowidget.messagecenter.a.d;
import com.gau.go.launcherex.gowidget.weather.globaltheme.a.b.b;

class r
  extends AsyncTask
{
  r(m paramm, d paramd) {}
  
  protected Bitmap a(String... paramVarArgs)
  {
    if (!TextUtils.isEmpty(paramVarArgs[0])) {
      return b.a(paramVarArgs[0], m.a(this.b));
    }
    return null;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    this.a.D = paramBitmap;
    ae.a(m.a(this.b)).a(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */