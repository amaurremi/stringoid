package com.gau.go.launcherex.gowidget.messagecenter.util;

import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gtp.a.a.a.a;
import com.gtp.a.a.b.c;
import java.util.Iterator;
import java.util.List;

class ac
  implements Runnable
{
  private List b;
  
  public ac(y paramy, List paramList)
  {
    this.b = paramList;
  }
  
  public void run()
  {
    Object localObject1 = new StringBuffer();
    Object localObject2 = this.b.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((StringBuffer)localObject1).append(((ab)((Iterator)localObject2).next()).a()).append("&");
    }
    ((StringBuffer)localObject1).delete(((StringBuffer)localObject1).length() - 1, ((StringBuffer)localObject1).length());
    if (r.c(y.a(this.a)))
    {
      Object localObject3 = this.a.a(y.b(this.a));
      if ((localObject3 != null) && (!((List)localObject3).isEmpty()))
      {
        localObject2 = new StringBuffer();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((StringBuffer)localObject2).append((String)((Iterator)localObject3).next()).append("&");
        }
        ((StringBuffer)localObject2).append((StringBuffer)localObject1);
        y.a(this.a, ((StringBuffer)localObject2).toString());
        return;
      }
      y.a(this.a, ((StringBuffer)localObject1).toString());
      return;
    }
    c.a("MSGCenterStatistics", "没有网络，写文件");
    localObject1 = ((StringBuffer)localObject1).toString().split("&");
    a.a().a("上传失败，保存到文件!", "message_center_statistics.txt");
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      a.a().a((String)localObject2, "message_center_statistics.txt");
      y.a(this.a, (String)localObject2, y.b(this.a));
      i += 1;
    }
    a.a().a("保存完毕", "message_center_statistics.txt");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */