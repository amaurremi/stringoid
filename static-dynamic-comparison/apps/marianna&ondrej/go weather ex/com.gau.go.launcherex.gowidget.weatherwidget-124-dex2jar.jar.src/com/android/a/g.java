package com.android.a;

import android.os.Handler;
import java.util.concurrent.Executor;

public class g
  implements w
{
  private final Executor a;
  
  public g(Handler paramHandler)
  {
    this.a = new h(this, paramHandler);
  }
  
  public void a(p paramp, aa paramaa)
  {
    paramp.a("post-error");
    paramaa = t.a(paramaa);
    this.a.execute(new i(this, paramp, paramaa, null));
  }
  
  public void a(p paramp, t paramt)
  {
    a(paramp, paramt, null);
  }
  
  public void a(p paramp, t paramt, Runnable paramRunnable)
  {
    paramp.v();
    paramp.a("post-response");
    this.a.execute(new i(this, paramp, paramt, paramRunnable));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */