package com.gau.go.launcherex.gowidget.statistics;

import com.gau.go.launcherex.gowidget.weather.util.r;
import com.gtp.a.a.a.a;
import java.util.Iterator;
import java.util.List;

class q
  implements Runnable
{
  private o b;
  
  public q(p paramp, o paramo)
  {
    this.b = paramo;
  }
  
  private void a(String paramString)
  {
    a.a().a("开始上传!(" + paramString + ")", "payment_log.txt");
    if (i.a(c.a(paramString, "lvsiqiaoil611230"), p.a(this.a)))
    {
      a.a().a("上传成功!(" + paramString + ")", "payment_log.txt");
      return;
    }
    a.a().a("上传失败，保存到文件!(" + paramString + ")", "payment_log.txt");
    p.a(this.a, paramString);
  }
  
  public void run()
  {
    Object localObject = p.a(this.a, this.b);
    if (r.c(p.a(this.a)))
    {
      List localList = this.a.a();
      if ((localList != null) && (!localList.isEmpty()))
      {
        localList.add(localObject);
        localObject = localList.iterator();
      }
      while (((Iterator)localObject).hasNext())
      {
        a((String)((Iterator)localObject).next());
        continue;
        a((String)localObject);
      }
      return;
    }
    a.a().a("没有网络，保存到文件!(" + (String)localObject + ")", "payment_log.txt");
    p.a(this.a, (String)localObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */