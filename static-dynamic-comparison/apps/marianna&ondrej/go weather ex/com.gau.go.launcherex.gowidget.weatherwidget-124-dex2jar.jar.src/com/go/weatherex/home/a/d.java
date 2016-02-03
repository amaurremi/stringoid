package com.go.weatherex.home.a;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.gau.go.launcherex.gowidget.weather.dynamicbackground.DynamicBackgroundView;
import com.jiubang.core.a.l;
import java.lang.ref.WeakReference;

class d
  extends Handler
{
  WeakReference a;
  
  public d(a parama)
  {
    this.a = new WeakReference(parama);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    a locala = (a)this.a.get();
    if (locala == null) {
      return;
    }
    if (paramMessage.arg1 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a.a(locala).a((l)paramMessage.obj, bool);
      paramMessage = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DYNAMICBACKGROUND_LOAD_DONE");
      if (locala.getActivity() == null) {
        break;
      }
      locala.getActivity().sendBroadcast(paramMessage);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */