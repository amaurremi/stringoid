package com.appbrain.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentManager.BackStackEntry;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.appbrain.AdOptions;

public class ak
  extends Fragment
{
  private static final String a = ak.class.getName();
  private ae b;
  
  public static void a(Activity paramActivity, AdOptions paramAdOptions, boolean paramBoolean)
  {
    Object localObject = null;
    FragmentManager localFragmentManager = paramActivity.getFragmentManager();
    int i = localFragmentManager.getBackStackEntryCount();
    if (i == 0)
    {
      paramActivity = null;
      if (paramActivity != null) {
        break label121;
      }
    }
    label121:
    for (paramActivity = (Activity)localObject;; paramActivity = paramActivity.getName())
    {
      if (TextUtils.equals(paramActivity, a)) {
        localFragmentManager.popBackStack();
      }
      paramActivity = new Bundle();
      paramActivity.putSerializable("op", paramAdOptions);
      paramActivity.putSerializable("mb", Boolean.valueOf(paramBoolean));
      paramAdOptions = new ak();
      paramAdOptions.setArguments(paramActivity);
      localFragmentManager.beginTransaction().add(16908290, paramAdOptions).setTransition(4099).addToBackStack(a).commit();
      return;
      paramActivity = localFragmentManager.getBackStackEntryAt(i - 1);
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AdOptions localAdOptions = (AdOptions)getArguments().getSerializable("op");
    boolean bool = getArguments().getBoolean("mb");
    this.b = new ae(getActivity(), paramBundle, localAdOptions, ae.d.b, bool, new al(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = this.b.a();
    long l = SystemClock.elapsedRealtime();
    paramLayoutInflater.setFocusableInTouchMode(true);
    paramLayoutInflater.requestFocus();
    paramLayoutInflater.setOnKeyListener(new am(this, l));
    return paramLayoutInflater;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.b.a(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */