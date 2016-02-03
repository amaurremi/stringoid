package com.go.weatherex.setting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.go.weatherex.framework.fragment.g;
import com.go.weatherex.home.a.f;

class a
  extends g
{
  public a(AnimationAndWallpaperSettingsActivity paramAnimationAndWallpaperSettingsActivity, FragmentActivity paramFragmentActivity)
  {
    super(paramFragmentActivity);
  }
  
  protected void a(com.go.weatherex.framework.fragment.a parama, Class paramClass, Bundle paramBundle)
  {
    Object localObject = a();
    paramBundle = (com.go.weatherex.framework.fragment.a)Fragment.instantiate(this.a, paramClass.getName(), paramBundle);
    paramBundle.b(this.a);
    localObject = ((FragmentManager)localObject).beginTransaction();
    ((FragmentTransaction)localObject).setCustomAnimations(2130968587, 2130968589, 2130968587, 2130968589);
    ((FragmentTransaction)localObject).hide(parama);
    ((FragmentTransaction)localObject).add(2131230929, paramBundle, paramClass.getName());
    ((FragmentTransaction)localObject).addToBackStack(paramClass.getName());
    ((FragmentTransaction)localObject).commit();
  }
  
  public void e()
  {
    f localf = new f();
    localf.b(this.a);
    localf.setArguments(f.a(AnimationAndWallpaperSettingsActivity.a(this.b)));
    w localw = new w();
    localw.b(this.a);
    FragmentTransaction localFragmentTransaction = a().beginTransaction();
    localFragmentTransaction.add(2131230929, localf, f.class.getName());
    localFragmentTransaction.add(2131230929, localw, w.class.getName());
    localFragmentTransaction.commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */