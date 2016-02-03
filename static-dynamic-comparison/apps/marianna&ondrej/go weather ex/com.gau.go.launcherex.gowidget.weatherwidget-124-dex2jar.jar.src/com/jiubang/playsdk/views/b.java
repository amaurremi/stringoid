package com.jiubang.playsdk.views;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.jiubang.playsdk.e.d;

class b
  extends Handler
{
  b(DefaultTabLoadingView paramDefaultTabLoadingView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof String))
    {
      paramMessage = (String)paramMessage.obj;
      if (!TextUtils.isEmpty(paramMessage))
      {
        d locald = new d();
        locald.a(paramMessage);
        DefaultTabLoadingView.a(this.a).a(locald);
        this.a.addView(DefaultTabLoadingView.a(this.a));
        DefaultTabLoadingView.b(this.a).setVisibility(8);
        this.a.removeView(DefaultTabLoadingView.b(this.a));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/views/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */