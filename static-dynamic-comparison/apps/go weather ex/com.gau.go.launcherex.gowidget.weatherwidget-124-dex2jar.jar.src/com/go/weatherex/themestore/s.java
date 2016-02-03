package com.go.weatherex.themestore;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class s
  extends FragmentPagerAdapter
{
  public s(q paramq, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return q.b(this.a).length;
  }
  
  public Fragment getItem(int paramInt)
  {
    paramInt = q.b(this.a)[paramInt];
    return f.a(this.a.getActivity(), q.c(this.a), paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */