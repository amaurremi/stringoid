package com.go.weatherex.home.a;

import com.gau.go.launcherex.gowidget.scriptengine.parser.z;
import com.jiubang.core.a.o;

class c
  implements Runnable
{
  private volatile boolean b;
  private final String c;
  private final z d;
  
  public c(a parama, z paramz, String paramString)
  {
    this.c = paramString;
    this.d = paramz;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void run()
  {
    if (this.a.getActivity() != null)
    {
      o localo = new com.gau.go.launcherex.gowidget.scriptengine.parser.c(this.d, this.a.getActivity(), this.c, false, Boolean.valueOf(false)).a(this.c);
      if (!this.b) {
        a.a(this.a, localo, a.e(this.a));
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */