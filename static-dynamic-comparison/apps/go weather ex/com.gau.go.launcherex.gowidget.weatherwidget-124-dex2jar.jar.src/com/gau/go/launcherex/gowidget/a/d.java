package com.gau.go.launcherex.gowidget.a;

import android.os.AsyncTask;
import com.gtp.a.a.a.a;
import com.jiubang.goweather.b.f;

class d
  extends AsyncTask
{
  private d(b paramb) {}
  
  protected f a(Void... paramVarArgs)
  {
    return this.a.b();
  }
  
  protected void a(f paramf)
  {
    switch (paramf.c())
    {
    }
    for (;;)
    {
      b.b(this.a, false);
      return;
      a.a().a("请求成功，计算下一次的调度时间。", "getjar_log.txt");
      b.c(this.a, false);
      b.a(this.a, false);
      continue;
      if (paramf.e() == 3)
      {
        a.a().a("没有网络，监听网络情况。", "getjar_log.txt");
        b.c(this.a, true);
      }
      else
      {
        a.a().a("请求失败，重新调度下一次。", "getjar_log.txt");
        b.c(this.a, false);
        b.a(this.a, true);
      }
    }
  }
  
  protected void onPreExecute()
  {
    b.b(this.a, true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */