package com.mobisystems.mobiscanner.controller;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.l;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.actionbarsherlock.app.SherlockFragment;

public class i
  extends SherlockFragment
  implements View.OnClickListener
{
  private PageEnhanceActivity azT;
  private ViewPager azU;
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.azU = ((ViewPager)getView().findViewById(2131165444));
    this.azU.setOnClickListener(this);
    this.azU.a(new a(getFragmentManager()));
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.azT = ((PageEnhanceActivity)paramActivity);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (this.azU.F() == this.azU.D().getCount() - 1)
    {
      this.azT.GS();
      return;
    }
    this.azU.j(this.azU.F() + 1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRetainInstance(true);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903109, paramViewGroup, false);
  }
  
  public void onDetach()
  {
    this.azT = null;
    super.onDetach();
  }
  
  private class a
    extends FragmentPagerAdapter
  {
    private SparseArray<Fragment> azV;
    
    public a(FragmentManager paramFragmentManager)
    {
      super();
    }
    
    public int getCount()
    {
      return 2;
    }
    
    public Fragment getItem(int paramInt)
    {
      if (this.azV == null) {
        this.azV = new SparseArray();
      }
      if (this.azV.get(paramInt) != null) {
        return (Fragment)this.azV.get(paramInt);
      }
      Bundle localBundle = new Bundle();
      switch (paramInt)
      {
      }
      for (;;)
      {
        j localj = new j();
        localj.setArguments(localBundle);
        localj.a(i.this);
        this.azV.put(0, localj);
        return localj;
        localBundle.putInt("CROP_HELP_IMAGE_RESOURCE", 2130837661);
        continue;
        localBundle.putInt("CROP_HELP_IMAGE_RESOURCE", 2130837662);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */