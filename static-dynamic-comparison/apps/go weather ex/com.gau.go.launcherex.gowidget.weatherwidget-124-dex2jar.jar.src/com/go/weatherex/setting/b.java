package com.go.weatherex.setting;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.go.weatherex.framework.fragment.a;
import com.go.weatherex.framework.fragment.g;
import com.go.weatherex.home.a.f;

class b
  extends g
{
  public b(LiveWallpaperSettingsActivity paramLiveWallpaperSettingsActivity, FragmentActivity paramFragmentActivity)
  {
    super(paramFragmentActivity);
  }
  
  protected void a(a parama, Class paramClass, Bundle paramBundle) {}
  
  public void e()
  {
    f localf = new f();
    localf.b(this.a);
    localf.setArguments(f.a(""));
    an localan = new an();
    localan.b(this.a);
    FragmentTransaction localFragmentTransaction = a().beginTransaction();
    localFragmentTransaction.add(2131231708, localf, f.class.getName());
    localFragmentTransaction.add(2131231708, localan, an.class.getName());
    localFragmentTransaction.commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */