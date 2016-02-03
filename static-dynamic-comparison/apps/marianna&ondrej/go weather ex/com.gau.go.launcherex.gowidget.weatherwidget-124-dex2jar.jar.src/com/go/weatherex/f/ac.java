package com.go.weatherex.f;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import java.lang.ref.WeakReference;

class ac
  extends Handler
{
  WeakReference a;
  
  public ac(t paramt)
  {
    this.a = new WeakReference(paramt);
  }
  
  public void handleMessage(Message paramMessage)
  {
    t localt = (t)this.a.get();
    if (localt == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 2: 
        t.e(localt);
        Toast.makeText(t.c(localt), 2131166461, 0).show();
        return;
      case 5: 
        t.e(localt);
        t.a(localt, t.c(localt).getString(2131165780), t.c(localt).getString(2131165698));
        return;
      case 3: 
        t.e(localt);
        t.a(localt, t.c(localt).getString(2131165780), t.c(localt).getString(2131165710));
        return;
      }
      t.e(localt);
      paramMessage = (com.gau.go.launcherex.gowidget.weather.model.b)paramMessage.obj;
    } while (t.f(localt));
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramMessage.b())) {
      localStringBuilder.append(paramMessage.b());
    }
    if (!TextUtils.isEmpty(paramMessage.d())) {
      localStringBuilder.append(",").append(paramMessage.d());
    }
    if (!TextUtils.isEmpty(paramMessage.c())) {
      localStringBuilder.append("(").append(paramMessage.c()).append(")");
    }
    com.gau.go.launcherex.gowidget.weather.globalview.b localb = new com.gau.go.launcherex.gowidget.weather.globalview.b(t.c(localt));
    localb.b(2131165690);
    localb.b(String.format(t.c(localt).getString(2131165691), new Object[] { localStringBuilder.toString() }));
    localb.d(2131165692);
    localb.a(new ad(this, paramMessage, localt));
    localb.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */