package com.go.weatherex.setting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.go.weatherex.framework.fragment.a;

class f
  extends com.go.weatherex.framework.fragment.g
{
  public f(PersonalizeSettingsActivity paramPersonalizeSettingsActivity, FragmentActivity paramFragmentActivity)
  {
    super(paramFragmentActivity);
  }
  
  protected void a(a parama, Class paramClass, Bundle paramBundle)
  {
    Object localObject = a();
    paramBundle = (a)Fragment.instantiate(this.a, paramClass.getName(), paramBundle);
    paramBundle.b(this.a);
    localObject = ((FragmentManager)localObject).beginTransaction();
    ((FragmentTransaction)localObject).setCustomAnimations(2130968587, 2130968589, 2130968587, 2130968589);
    ((FragmentTransaction)localObject).hide(parama);
    ((FragmentTransaction)localObject).add(2131231797, paramBundle, paramClass.getName());
    ((FragmentTransaction)localObject).addToBackStack(paramClass.getName());
    ((FragmentTransaction)localObject).commit();
  }
  
  public void e()
  {
    com.go.weatherex.home.a.f localf = new com.go.weatherex.home.a.f();
    localf.b(this.a);
    localf.setArguments(com.go.weatherex.home.a.f.a(PersonalizeSettingsActivity.a(this.b)));
    g localg = new g();
    localg.b(this.a);
    FragmentTransaction localFragmentTransaction = a().beginTransaction();
    localFragmentTransaction.add(2131231797, localf, com.go.weatherex.home.a.f.class.getName());
    localFragmentTransaction.add(2131231797, localg, g.class.getName());
    localFragmentTransaction.commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */