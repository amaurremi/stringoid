package com.gau.go.launcherex.gowidget.messagecenter.util;

import com.gtp.a.a.b.c;

class n
  extends Thread
{
  n(m paramm, int paramInt) {}
  
  public void run()
  {
    long l1 = 28800000L;
    super.run();
    long l2 = System.currentTimeMillis();
    long l3 = i.c(m.a(this.b));
    if ((l3 == 0L) || (l2 - l3 >= 28800000L) || (l2 - l3 <= 0L))
    {
      c.a("MSGCenter", "距离上次更新消息超过8小时，启动更新");
      if (m.b(this.b).a(this.a))
      {
        c.a("MSGCenter", "更新成功，保存消息");
        i.a(l2, m.a(this.b));
        i.a(m.a(this.b), 0);
      }
    }
    for (;;)
    {
      i.b(l1, m.a(this.b));
      return;
      c.a("MSGCenter", "更新失败，重新请求");
      l1 = 1200000L;
      continue;
      l1 = 28800000L - (l2 - l3);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/messagecenter/util/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */