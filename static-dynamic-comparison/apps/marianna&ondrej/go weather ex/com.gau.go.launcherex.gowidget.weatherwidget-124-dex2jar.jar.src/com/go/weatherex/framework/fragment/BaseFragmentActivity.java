package com.go.weatherex.framework.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.gau.go.launcherex.gowidget.d.c;
import com.gau.go.launcherex.gowidget.language.GoWeatherExFragmentActivity;
import java.util.Iterator;
import java.util.List;

public abstract class BaseFragmentActivity
  extends GoWeatherExFragmentActivity
  implements d
{
  private final com.gau.go.launcherex.gowidget.d.a a = new c();
  private com.go.weatherex.framework.b b;
  private g c;
  
  public final g a()
  {
    return this.c;
  }
  
  public void a(com.gau.go.launcherex.gowidget.language.b paramb)
  {
    super.a(paramb);
    paramb = getSupportFragmentManager().getFragments();
    if (paramb != null)
    {
      paramb = paramb.iterator();
      while (paramb.hasNext())
      {
        Fragment localFragment = (Fragment)paramb.next();
        if ((localFragment instanceof a)) {
          ((a)localFragment).f();
        }
      }
    }
  }
  
  protected g b()
  {
    return null;
  }
  
  protected com.go.weatherex.framework.b c()
  {
    return new e(this);
  }
  
  public final com.gau.go.launcherex.gowidget.d.a d()
  {
    return this.a;
  }
  
  public final com.go.weatherex.framework.b e()
  {
    return this.b;
  }
  
  public final com.go.weatherex.framework.a.a f()
  {
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = c();
    this.c = b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.b != null) {
      this.b.a();
    }
    if (this.c != null) {
      this.c.c();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/framework/fragment/BaseFragmentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */