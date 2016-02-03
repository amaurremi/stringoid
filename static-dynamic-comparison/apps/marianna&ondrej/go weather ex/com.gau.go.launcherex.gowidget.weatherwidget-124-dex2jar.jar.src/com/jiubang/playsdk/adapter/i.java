package com.jiubang.playsdk.adapter;

import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import com.jiubang.playsdk.imageload.KPNetworkImageView;
import com.jiubang.playsdk.main.BitmapBean;
import java.util.Map;

class i
  extends Handler
{
  i(h paramh) {}
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (String)paramMessage.obj;
    if ((h.a(this.a).containsKey(paramMessage)) && ((this.a.a.findViewWithTag(paramMessage) instanceof KPNetworkImageView)))
    {
      h.a(this.a, (BitmapBean)h.a(this.a).get(paramMessage), (KPNetworkImageView)this.a.a.findViewWithTag(paramMessage));
      h.a(this.a).remove(paramMessage);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/adapter/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */