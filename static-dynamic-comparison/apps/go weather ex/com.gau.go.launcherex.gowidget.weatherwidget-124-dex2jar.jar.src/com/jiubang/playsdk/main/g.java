package com.jiubang.playsdk.main;

import android.os.Handler;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.a.x;

class g
  implements Runnable
{
  g(e parame, String paramString) {}
  
  public void run()
  {
    x localx = this.b.f.b(this.a);
    if (localx != null)
    {
      e.a(this.b, localx);
      e.b(this.b).sendEmptyMessage(2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/main/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */