package com.gau.go.launcherex.gowidget.statistics;

import android.content.Context;
import android.os.AsyncTask;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.go.weatherex.g.b;
import com.gtp.a.a.a.a;

class w
  extends AsyncTask
{
  w(u paramu) {}
  
  protected Void a(Void... paramVarArgs)
  {
    new b(u.b(this.a)).a();
    long l1 = System.currentTimeMillis();
    long l2 = u.d(this.a);
    StringBuffer localStringBuffer1;
    Object localObject;
    if ((l2 == 0L) || (l1 - l2 >= 28800000L) || (l1 - l2 <= 0L))
    {
      a.a().a("开启线程启动上传", "statistics_log.txt");
      boolean bool = i.a(y.a(u.b(this.a)), u.b(this.a));
      paramVarArgs = String.valueOf(2);
      String str = y.f(u.b(this.a));
      localStringBuffer1 = new StringBuffer();
      localObject = GoWidgetApplication.b(u.b(this.a).getApplicationContext());
      if (((f)localObject).a(32))
      {
        localStringBuffer1.append(4);
        localObject = String.valueOf(-1);
        com.gau.go.gostaticsdk.d.a(u.b(this.a)).a(paramVarArgs, str, localStringBuffer1.toString(), false, (String)localObject, true);
        StringBuffer localStringBuffer2 = new StringBuffer();
        localStringBuffer2.append("基础统计(upLoadBasicInfoStaticData) ");
        localStringBuffer2.append("[产品id:").append(paramVarArgs).append("] ");
        localStringBuffer2.append("[产品渠道:").append(str).append("] ");
        localStringBuffer2.append("[是否付费用户:").append(localStringBuffer1).append("] ");
        localStringBuffer2.append("[是否需要root信息:").append(false).append("] ");
        localStringBuffer2.append("[key:").append((String)localObject).append("] ");
        localStringBuffer2.append("[是否新用户:").append(true).append("] ");
        a.a().a(localStringBuffer2.toString(), "base_statistics.txt");
        if (!bool) {
          break label506;
        }
        a.a().a("上传成功，清除本次数据", "statistics_log.txt");
        y.b(u.b(this.a).getApplicationContext());
        u.a(this.a, l1);
        com.gau.go.launcherex.gowidget.weather.globaltheme.a.d.a(u.b(this.a));
        l1 = 28800000L;
      }
    }
    for (;;)
    {
      u.b(this.a, l1);
      return null;
      if (((f)localObject).a(1))
      {
        localStringBuffer1.append(1);
        break;
      }
      if ((((f)localObject).a(2)) && (((f)localObject).a(64)))
      {
        localStringBuffer1.append(2).append(",").append(3);
        break;
      }
      if ((((f)localObject).a(2)) && (!((f)localObject).a(64)))
      {
        localStringBuffer1.append(2);
        break;
      }
      if ((!((f)localObject).a(2)) && (((f)localObject).a(64)))
      {
        localStringBuffer1.append(3);
        break;
      }
      if (!((f)localObject).e()) {
        break;
      }
      localStringBuffer1.append(0);
      break;
      label506:
      a.a().a("上传不成功，本次数据保留", "statistics_log.txt");
      l1 = 1200000L;
      continue;
      l1 = 28800000L - (l1 - l2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */