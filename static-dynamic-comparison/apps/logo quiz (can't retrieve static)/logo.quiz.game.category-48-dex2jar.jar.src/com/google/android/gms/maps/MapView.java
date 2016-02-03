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
import com.google.android.gms.common.internal.n;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapView
  extends FrameLayout
{
  private GoogleMap aiG;
  private final b aiJ;
  
  public MapView(Context paramContext)
  {
    super(paramContext);
    this.aiJ = new b(this, paramContext, null);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.aiJ = new b(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.aiJ = new b(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
  }
  
  public MapView(Context paramContext, GoogleMapOptions paramGoogleMapOptions)
  {
    super(paramContext);
    this.aiJ = new b(this, paramContext, paramGoogleMapOptions);
  }
  
  public final GoogleMap getMap()
  {
    if (this.aiG != null) {
      return this.aiG;
    }
    this.aiJ.my();
    if (this.aiJ.it() == null) {
      return null;
    }
    try
    {
      this.aiG = new GoogleMap(((a)this.aiJ.it()).mz().getMap());
      return this.aiG;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    this.aiJ.onCreate(paramBundle);
    if (this.aiJ.it() == null)
    {
      paramBundle = this.aiJ;
      b.b(this);
    }
  }
  
  public final void onDestroy()
  {
    this.aiJ.onDestroy();
  }
  
  public final void onLowMemory()
  {
    this.aiJ.onLowMemory();
  }
  
  public final void onPause()
  {
    this.aiJ.onPause();
  }
  
  public final void onResume()
  {
    this.aiJ.onResume();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    this.aiJ.onSaveInstanceState(paramBundle);
  }
  
  static class a
    implements LifecycleDelegate
  {
    private final ViewGroup aiK;
    private final IMapViewDelegate aiL;
    private View aiM;
    
    public a(ViewGroup paramViewGroup, IMapViewDelegate paramIMapViewDelegate)
    {
      this.aiL = ((IMapViewDelegate)n.i(paramIMapViewDelegate));
      this.aiK = ((ViewGroup)n.i(paramViewGroup));
    }
    
    public IMapViewDelegate mz()
    {
      return this.aiL;
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.aiL.onCreate(paramBundle);
        this.aiM = ((View)e.f(this.aiL.getView()));
        this.aiK.removeAllViews();
        this.aiK.addView(this.aiM);
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
        this.aiL.onDestroy();
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
        this.aiL.onLowMemory();
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
        this.aiL.onPause();
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
        this.aiL.onResume();
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
        this.aiL.onSaveInstanceState(paramBundle);
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
    protected f<MapView.a> aiI;
    private final ViewGroup aiN;
    private final GoogleMapOptions aiO;
    private final Context mContext;
    
    b(ViewGroup paramViewGroup, Context paramContext, GoogleMapOptions paramGoogleMapOptions)
    {
      this.aiN = paramViewGroup;
      this.mContext = paramContext;
      this.aiO = paramGoogleMapOptions;
    }
    
    protected void a(f<MapView.a> paramf)
    {
      this.aiI = paramf;
      my();
    }
    
    public void my()
    {
      if ((this.aiI != null) && (it() == null)) {}
      try
      {
        IMapViewDelegate localIMapViewDelegate = u.R(this.mContext).a(e.k(this.mContext), this.aiO);
        this.aiI.a(new MapView.a(this.aiN, localIMapViewDelegate));
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/maps/MapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */