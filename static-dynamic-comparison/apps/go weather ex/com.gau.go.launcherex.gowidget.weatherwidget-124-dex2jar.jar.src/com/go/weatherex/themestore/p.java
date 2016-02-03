package com.go.weatherex.themestore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.app.FragmentTransaction;
import com.gau.go.launcherex.gowidget.weather.view.ba;
import com.go.weatherex.framework.fragment.a;
import com.go.weatherex.framework.fragment.g;

public class p
  extends g
  implements FragmentManager.OnBackStackChangedListener
{
  public p(FragmentActivity paramFragmentActivity)
  {
    super(paramFragmentActivity);
    a().addOnBackStackChangedListener(this);
  }
  
  private int e()
  {
    return 2131231954;
  }
  
  public void a(ba paramba)
  {
    u.c().a(paramba);
    paramba = (a)Fragment.instantiate(this.a, q.class.getName(), null);
    paramba.b(this.a);
    FragmentTransaction localFragmentTransaction = a().beginTransaction();
    localFragmentTransaction.add(e(), paramba, q.class.getName());
    localFragmentTransaction.commit();
  }
  
  protected void a(a parama, Class paramClass, Bundle paramBundle) {}
  
  protected void b(int paramInt, Object paramObject)
  {
    super.b(paramInt, paramObject);
  }
  
  public void b(ba paramba)
  {
    u.c().a(paramba);
  }
  
  public void d(Fragment paramFragment)
  {
    super.d(paramFragment);
  }
  
  protected boolean d()
  {
    return super.d();
  }
  
  public void onBackStackChanged() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */