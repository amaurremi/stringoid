package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract interface a
{
  public abstract void a(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2);
  
  public abstract void onCreate(Bundle paramBundle);
  
  public abstract View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle);
  
  public abstract void onDestroy();
  
  public abstract void onDestroyView();
  
  public abstract void onLowMemory();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onSaveInstanceState(Bundle paramBundle);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/dynamic/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */