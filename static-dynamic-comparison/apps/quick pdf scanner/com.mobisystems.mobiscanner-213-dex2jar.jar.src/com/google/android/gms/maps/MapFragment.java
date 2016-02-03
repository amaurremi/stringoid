package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.dc;
import com.google.android.gms.maps.a.j;
import com.google.android.gms.maps.a.w;
import com.google.android.gms.maps.a.x;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapFragment
  extends Fragment
{
  private final b Uz = new b(this);
  
  public void onActivityCreated(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MapFragment.class.getClassLoader());
    }
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    b.a(this.Uz, paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.Uz.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.Uz.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    this.Uz.onDestroy();
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.Uz.onDestroyView();
    super.onDestroyView();
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    b.a(this.Uz, paramActivity);
    paramAttributeSet = GoogleMapOptions.a(paramActivity, paramAttributeSet);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("MapOptions", paramAttributeSet);
    this.Uz.a(paramActivity, localBundle, paramBundle);
  }
  
  public void onLowMemory()
  {
    this.Uz.onLowMemory();
    super.onLowMemory();
  }
  
  public void onPause()
  {
    this.Uz.onPause();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.Uz.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MapFragment.class.getClassLoader());
    }
    super.onSaveInstanceState(paramBundle);
    this.Uz.onSaveInstanceState(paramBundle);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }
  
  static class a
    implements a
  {
    private final Fragment UA;
    private final com.google.android.gms.maps.a.d UB;
    
    public a(Fragment paramFragment, com.google.android.gms.maps.a.d paramd)
    {
      this.UB = ((com.google.android.gms.maps.a.d)dc.N(paramd));
      this.UA = ((Fragment)dc.N(paramFragment));
    }
    
    public void a(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      paramBundle1 = (GoogleMapOptions)paramBundle1.getParcelable("MapOptions");
      try
      {
        this.UB.a(com.google.android.gms.dynamic.d.J(paramActivity), paramBundle1, paramBundle2);
        return;
      }
      catch (RemoteException paramActivity)
      {
        throw new RuntimeRemoteException(paramActivity);
      }
    }
    
    public void onCreate(Bundle paramBundle)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {}
      try
      {
        localBundle = new Bundle();
        paramBundle = this.UA.getArguments();
        if ((paramBundle != null) && (paramBundle.containsKey("MapOptions"))) {
          w.a(localBundle, "MapOptions", paramBundle.getParcelable("MapOptions"));
        }
        this.UB.onCreate(localBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      try
      {
        paramLayoutInflater = this.UB.a(com.google.android.gms.dynamic.d.J(paramLayoutInflater), com.google.android.gms.dynamic.d.J(paramViewGroup), paramBundle);
        return (View)com.google.android.gms.dynamic.d.a(paramLayoutInflater);
      }
      catch (RemoteException paramLayoutInflater)
      {
        throw new RuntimeRemoteException(paramLayoutInflater);
      }
    }
    
    public void onDestroy()
    {
      try
      {
        this.UB.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onDestroyView()
    {
      try
      {
        this.UB.onDestroyView();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onLowMemory()
    {
      try
      {
        this.UB.onLowMemory();
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
        this.UB.onPause();
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
        this.UB.onResume();
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
        this.UB.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
  }
  
  static class b
    extends b<MapFragment.a>
  {
    private Activity Cy;
    private final Fragment UA;
    protected f<MapFragment.a> UC;
    
    b(Fragment paramFragment)
    {
      this.UA = paramFragment;
    }
    
    private void setActivity(Activity paramActivity)
    {
      this.Cy = paramActivity;
      ui();
    }
    
    protected void a(f<MapFragment.a> paramf)
    {
      this.UC = paramf;
      ui();
    }
    
    public void ui()
    {
      if ((this.Cy != null) && (this.UC != null) && (ny() == null)) {}
      try
      {
        c.P(this.Cy);
        com.google.android.gms.maps.a.d locald = x.Q(this.Cy).g(com.google.android.gms.dynamic.d.J(this.Cy));
        this.UC.a(new MapFragment.a(this.UA, locald));
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/MapFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */