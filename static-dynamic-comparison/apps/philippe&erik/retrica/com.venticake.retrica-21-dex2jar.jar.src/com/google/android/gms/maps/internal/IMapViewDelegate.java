package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.d;

public abstract interface IMapViewDelegate
  extends IInterface
{
  public abstract IGoogleMapDelegate getMap();
  
  public abstract d getView();
  
  public abstract void onCreate(Bundle paramBundle);
  
  public abstract void onDestroy();
  
  public abstract void onLowMemory();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onSaveInstanceState(Bundle paramBundle);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/internal/IMapViewDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */