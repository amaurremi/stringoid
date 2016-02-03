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
import com.appbrain.a;

public class bn
  extends Fragment
{
  private static final String a = bn.class.getName();
  private bc b;
  
  public static void a(Activity paramActivity, a parama, boolean paramBoolean)
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
      paramActivity.putSerializable("op", parama);
      paramActivity.putSerializable("mb", Boolean.valueOf(paramBoolean));
      parama = new bn();
      parama.setArguments(paramActivity);
      localFragmentManager.beginTransaction().add(16908290, parama).setTransition(4099).addToBackStack(a).commit();
      return;
      paramActivity = localFragmentManager.getBackStackEntryAt(i - 1);
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a locala = (a)getArguments().getSerializable("op");
    boolean bool = getArguments().getBoolean("mb");
    this.b = new bc(getActivity(), paramBundle, locala, bg.b, bool, new bo(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = this.b.a();
    long l = SystemClock.elapsedRealtime();
    paramLayoutInflater.setFocusableInTouchMode(true);
    paramLayoutInflater.requestFocus();
    paramLayoutInflater.setOnKeyListener(new bp(this, l));
    return paramLayoutInflater;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.b.a(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/a/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */