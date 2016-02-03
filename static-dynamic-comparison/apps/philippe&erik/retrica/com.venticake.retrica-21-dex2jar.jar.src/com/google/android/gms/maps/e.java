package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

class e
  implements LifecycleDelegate
{
  private final ViewGroup a;
  private final IMapViewDelegate b;
  private View c;
  
  public e(ViewGroup paramViewGroup, IMapViewDelegate paramIMapViewDelegate)
  {
    this.b = ((IMapViewDelegate)hm.f(paramIMapViewDelegate));
    this.a = ((ViewGroup)hm.f(paramViewGroup));
  }
  
  public IMapViewDelegate a()
  {
    return this.b;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    try
    {
      this.b.onCreate(paramBundle);
      this.c = ((View)com.google.android.gms.dynamic.e.e(this.b.getView()));
      this.a.removeAllViews();
      this.a.addView(this.c);
      return;
    }
    catch (RemoteException paramBundle)
    {
      throw new RuntimeRemoteException(paramBundle);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
  }
  
  public void onDestroy()
  {
    try
    {
      this.b.onDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void onDestroyView()
  {
    throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
  }
  
  public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
  {
    throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
  }
  
  public void onLowMemory()
  {
    try
    {
      this.b.onLowMemory();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void onPause()
  {
    try
    {
      this.b.onPause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void onResume()
  {
    try
    {
      this.b.onResume();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    try
    {
      this.b.onSaveInstanceState(paramBundle);
      return;
    }
    catch (RemoteException paramBundle)
    {
      throw new RuntimeRemoteException(paramBundle);
    }
  }
  
  public void onStart() {}
  
  public void onStop() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */