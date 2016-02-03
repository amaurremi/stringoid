package com.go.weatherex.framework.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import java.util.ArrayList;
import java.util.List;

public abstract class g
{
  protected FragmentActivity a;
  private i b;
  
  public g(FragmentActivity paramFragmentActivity)
  {
    this.a = paramFragmentActivity;
  }
  
  private com.gau.go.launcherex.gowidget.d.a a(boolean paramBoolean)
  {
    com.gau.go.launcherex.gowidget.d.a locala;
    if ((this.a instanceof d))
    {
      locala = ((d)this.a).d();
      if ((locala == null) && (paramBoolean)) {
        throw new IllegalStateException("need to implements getCellBroadcastCenter in activity");
      }
    }
    else
    {
      throw new IllegalStateException("the fragment activity should implements FragmentFunctionExtended to make some features available");
    }
    return locala;
  }
  
  protected FragmentManager a()
  {
    return this.a.getSupportFragmentManager();
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    a(true).a(paramInt, paramObject);
  }
  
  public void a(Fragment paramFragment) {}
  
  protected final void a(a parama, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    parama.a(paramBundle);
  }
  
  protected abstract void a(a parama, Class paramClass, Bundle paramBundle);
  
  public final void a(int... paramVarArgs)
  {
    com.gau.go.launcherex.gowidget.d.a locala = a(true);
    if (this.b == null) {
      this.b = new i(this, null);
    }
    locala.a(this.b, paramVarArgs);
  }
  
  protected boolean a(a parama)
  {
    return false;
  }
  
  protected void b(int paramInt, Object paramObject) {}
  
  public void b(Fragment paramFragment) {}
  
  protected void b(a parama)
  {
    if (!a().popBackStackImmediate()) {
      this.a.finish();
    }
  }
  
  public boolean b()
  {
    Object localObject = a();
    int i;
    if ((localObject != null) && (((FragmentManager)localObject).getFragments() != null))
    {
      localObject = new ArrayList(((FragmentManager)localObject).getFragments());
      if (((List)localObject).size() > 0) {
        i = ((List)localObject).size() - 1;
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        Fragment localFragment = (Fragment)((List)localObject).get(i);
        if ((localFragment != null) && (localFragment.isVisible()) && ((localFragment instanceof a)))
        {
          if (((a)localFragment).g()) {
            return true;
          }
          if (!((a)localFragment).e()) {}
        }
      }
      else
      {
        return d();
      }
      i -= 1;
    }
  }
  
  public void c()
  {
    com.gau.go.launcherex.gowidget.d.a locala = a(false);
    if ((locala != null) && (this.b != null))
    {
      locala.a(this.b);
      this.b = null;
    }
  }
  
  public void c(Fragment paramFragment) {}
  
  public void d(Fragment paramFragment) {}
  
  protected boolean d()
  {
    return false;
  }
  
  public void e(Fragment paramFragment) {}
  
  public void f(Fragment paramFragment) {}
  
  public void g(Fragment paramFragment) {}
  
  public void h(Fragment paramFragment) {}
  
  public void i(Fragment paramFragment) {}
  
  public void j(Fragment paramFragment) {}
  
  public void k(Fragment paramFragment) {}
  
  public void l(Fragment paramFragment) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/framework/fragment/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */