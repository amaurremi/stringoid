package com.gau.go.launcherex.gowidget.messagecenter.util;

import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gtp.a.a.a.a;
import com.gtp.a.a.b.c;
import java.util.Iterator;
import java.util.List;

class ad
  implements Runnable
{
  private ab b;
  
  public ad(y paramy, ab paramab)
  {
    this.b = paramab;
  }
  
  public void run()
  {
    String str = this.b.a();
    if (r.c(y.a(this.a)))
    {
      Object localObject = this.a.a(y.b(this.a));
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuffer.append((String)((Iterator)localObject).next()).append("&");
        }
        localStringBuffer.append(str);
        y.a(this.a, localStringBuffer.toString());
        return;
      }
      y.a(this.a, str);
      return;
    }
    c.a("MSGCenterStatistics", "没有网络，写文件");
    a.a().a("没有网络，保存到文件!(" + str + ")", "message_center_statistics.txt");
    y.a(this.a, str, y.b(this.a));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */