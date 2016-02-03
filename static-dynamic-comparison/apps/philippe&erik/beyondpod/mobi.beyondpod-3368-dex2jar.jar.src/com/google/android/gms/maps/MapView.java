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
import com.google.android.gms.dynamic.d;
import com.google.android.gms.internal.eg;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.q;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapView
  extends FrameLayout
{
  private GoogleMap BU;
  private final b BY;
  
  public MapView(Context paramContext)
  {
    super(paramContext);
    this.BY = new b(this, paramContext, null);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.BY = new b(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.BY = new b(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
  }
  
  public MapView(Context paramContext, GoogleMapOptions paramGoogleMapOptions)
  {
    super(paramContext);
    this.BY = new b(this, paramContext, paramGoogleMapOptions);
  }
  
  public final GoogleMap getMap()
  {
    if (this.BU != null) {
      return this.BU;
    }
    this.BY.ex();
    if (this.BY.cZ() == null) {
      return null;
    }
    try
    {
      this.BU = new GoogleMap(((a)this.BY.cZ()).ey().getMap());
      return this.BU;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    this.BY.onCreate(paramBundle);
    if (this.BY.cZ() == null) {
      this.BY.a(this);
    }
  }
  
  public final void onDestroy()
  {
    this.BY.onDestroy();
  }
  
  public final void onLowMemory()
  {
    this.BY.onLowMemory();
  }
  
  public final void onPause()
  {
    this.BY.onPause();
  }
  
  public final void onResume()
  {
    this.BY.onResume();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    this.BY.onSaveInstanceState(paramBundle);
  }
  
  static class a
    implements LifecycleDelegate
  {
    private final ViewGroup BZ;
    private final IMapViewDelegate Ca;
    private View Cb;
    
    public a(ViewGroup paramViewGroup, IMapViewDelegate paramIMapViewDelegate)
    {
      this.Ca = ((IMapViewDelegate)eg.f(paramIMapViewDelegate));
      this.BZ = ((ViewGroup)eg.f(paramViewGroup));
    }
    
    public IMapViewDelegate ey()
    {
      return this.Ca;
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.Ca.onCreate(paramBundle);
        this.Cb = ((View)com.google.android.gms.dynamic.c.b(this.Ca.getView()));
        this.BZ.removeAllViews();
        this.BZ.addView(this.Cb);
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
        this.Ca.onDestroy();
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
        this.Ca.onLowMemory();
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
        this.Ca.onPause();
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
        this.Ca.onResume();
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
        this.Ca.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
  }
  
  static class b
    extends a<MapView.a>
  {
    protected d<MapView.a> BX;
    private final ViewGroup Cc;
    private final GoogleMapOptions Cd;
    private final Context mContext;
    
    b(ViewGroup paramViewGroup, Context paramContext, GoogleMapOptions paramGoogleMapOptions)
    {
      this.Cc = paramViewGroup;
      this.mContext = paramContext;
      this.Cd = paramGoogleMapOptions;
    }
    
    protected void a(d<MapView.a> paramd)
    {
      this.BX = paramd;
      ex();
    }
    
    public void ex()
    {
      if ((this.BX != null) && (cZ() == null)) {}
      try
      {
        IMapViewDelegate localIMapViewDelegate = q.u(this.mContext).a(com.google.android.gms.dynamic.c.h(this.mContext), this.Cd);
        this.BX.a(new MapView.a(this.Cc, localIMapViewDelegate));
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/maps/MapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */