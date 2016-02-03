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
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.dc;
import com.google.android.gms.maps.a.e;
import com.google.android.gms.maps.a.j;
import com.google.android.gms.maps.a.x;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapView
  extends FrameLayout
{
  private final b UD;
  
  public MapView(Context paramContext)
  {
    super(paramContext);
    this.UD = new b(this, paramContext, null);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.UD = new b(this, paramContext, GoogleMapOptions.a(paramContext, paramAttributeSet));
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.UD = new b(this, paramContext, GoogleMapOptions.a(paramContext, paramAttributeSet));
  }
  
  static class a
    implements a
  {
    private final ViewGroup UE;
    private final e UF;
    private View UG;
    
    public a(ViewGroup paramViewGroup, e parame)
    {
      this.UF = ((e)dc.N(parame));
      this.UE = ((ViewGroup)dc.N(paramViewGroup));
    }
    
    public void a(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.UF.onCreate(paramBundle);
        this.UG = ((View)d.a(this.UF.pi()));
        this.UE.removeAllViews();
        this.UE.addView(this.UG);
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
        this.UF.onDestroy();
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
    
    public void onLowMemory()
    {
      try
      {
        this.UF.onLowMemory();
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
        this.UF.onPause();
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
        this.UF.onResume();
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
        this.UF.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
  }
  
  static class b
    extends b<MapView.a>
  {
    protected f<MapView.a> UC;
    private final ViewGroup UH;
    private final GoogleMapOptions UI;
    private final Context mContext;
    
    b(ViewGroup paramViewGroup, Context paramContext, GoogleMapOptions paramGoogleMapOptions)
    {
      this.UH = paramViewGroup;
      this.mContext = paramContext;
      this.UI = paramGoogleMapOptions;
    }
    
    protected void a(f<MapView.a> paramf)
    {
      this.UC = paramf;
      ui();
    }
    
    public void ui()
    {
      if ((this.UC != null) && (ny() == null)) {}
      try
      {
        e locale = x.Q(this.mContext).a(d.J(this.mContext), this.UI);
        this.UC.a(new MapView.a(this.UH, locale));
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/maps/MapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */