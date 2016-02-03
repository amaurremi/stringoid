package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.hn;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapView
  extends FrameLayout
{
  private GoogleMap ZA;
  private final b ZD;
  
  public MapView(Context paramContext)
  {
    super(paramContext);
    this.ZD = new b(this, paramContext, null);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.ZD = new b(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.ZD = new b(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
  }
  
  public MapView(Context paramContext, GoogleMapOptions paramGoogleMapOptions)
  {
    super(paramContext);
    this.ZD = new b(this, paramContext, paramGoogleMapOptions);
  }
  
  public final GoogleMap getMap()
  {
    if (this.ZA != null) {
      return this.ZA;
    }
    this.ZD.ju();
    if (this.ZD.gC() == null) {
      return null;
    }
    try
    {
      this.ZA = new GoogleMap(((a)this.ZD.gC()).jv().getMap());
      return this.ZA;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    this.ZD.onCreate(paramBundle);
    if (this.ZD.gC() == null)
    {
      paramBundle = this.ZD;
      b.b(this);
    }
  }
  
  public final void onDestroy()
  {
    this.ZD.onDestroy();
  }
  
  public final void onLowMemory()
  {
    this.ZD.onLowMemory();
  }
  
  public final void onPause()
  {
    this.ZD.onPause();
  }
  
  public final void onResume()
  {
    this.ZD.onResume();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    this.ZD.onSaveInstanceState(paramBundle);
  }
  
  static class a
    implements LifecycleDelegate
  {
    private final ViewGroup ZE;
    private final IMapViewDelegate ZF;
    private View ZG;
    
    public a(ViewGroup paramViewGroup, IMapViewDelegate paramIMapViewDelegate)
    {
      this.ZF = ((IMapViewDelegate)hn.f(paramIMapViewDelegate));
      this.ZE = ((ViewGroup)hn.f(paramViewGroup));
    }
    
    public IMapViewDelegate jv()
    {
      return this.ZF;
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.ZF.onCreate(paramBundle);
        this.ZG = ((View)e.e(this.ZF.getView()));
        this.ZE.removeAllViews();
        this.ZE.addView(this.ZG);
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
        this.ZF.onDestroy();
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
        this.ZF.onLowMemory();
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
        this.ZF.onPause();
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
        this.ZF.onResume();
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
        this.ZF.onSaveInstanceState(paramBundle);
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
  
  static class b
    extends a<MapView.a>
  {
    protected f<MapView.a> ZC;
    private final ViewGroup ZH;
    private final GoogleMapOptions ZI;
    private final Context mContext;
    
    b(ViewGroup paramViewGroup, Context paramContext, GoogleMapOptions paramGoogleMapOptions)
    {
      this.ZH = paramViewGroup;
      this.mContext = paramContext;
      this.ZI = paramGoogleMapOptions;
    }
    
    protected void a(f<MapView.a> paramf)
    {
      this.ZC = paramf;
      ju();
    }
    
    public void ju()
    {
      if ((this.ZC != null) && (gC() == null)) {}
      try
      {
        IMapViewDelegate localIMapViewDelegate = u.E(this.mContext).a(e.h(this.mContext), this.ZI);
        this.ZC.a(new MapView.a(this.ZH, localIMapViewDelegate));
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/maps/MapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */