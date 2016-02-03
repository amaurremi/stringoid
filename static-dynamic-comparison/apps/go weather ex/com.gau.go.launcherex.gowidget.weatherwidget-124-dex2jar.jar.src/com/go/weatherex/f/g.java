package com.go.weatherex.f;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import java.lang.ref.WeakReference;

class g
  extends Handler
{
  WeakReference a;
  
  public g(a parama)
  {
    this.a = new WeakReference(parama);
  }
  
  public void handleMessage(Message paramMessage)
  {
    a locala = (a)this.a.get();
    if (locala == null) {}
    do
    {
      return;
      a.a(locala);
      switch (paramMessage.what)
      {
      default: 
        return;
      case 2: 
        Toast.makeText(a.b(locala), 2131166461, 0).show();
        return;
      case 5: 
        a.a(locala, a.b(locala).getString(2131165780), a.b(locala).getString(2131165698));
        return;
      case 3: 
        a.a(locala, a.b(locala).getString(2131165780), a.b(locala).getString(2131165710));
        return;
      }
      paramMessage = (com.gau.go.launcherex.gowidget.weather.model.b)paramMessage.obj;
    } while (a.c(locala));
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
    com.gau.go.launcherex.gowidget.weather.globalview.b localb = new com.gau.go.launcherex.gowidget.weather.globalview.b(a.b(locala));
    localb.b(2131165690);
    localb.b(String.format(a.b(locala).getString(2131165691), new Object[] { localStringBuilder.toString() }));
    localb.a(new h(this, paramMessage, locala));
    localb.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */