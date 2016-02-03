package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapView
  extends FrameLayout
{
  private GoogleMap ZD;
  private final f ZG;
  
  public MapView(Context paramContext)
  {
    super(paramContext);
    this.ZG = new f(this, paramContext, null);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.ZG = new f(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.ZG = new f(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
  }
  
  public MapView(Context paramContext, GoogleMapOptions paramGoogleMapOptions)
  {
    super(paramContext);
    this.ZG = new f(this, paramContext, paramGoogleMapOptions);
  }
  
  public final GoogleMap getMap()
  {
    if (this.ZD != null) {
      return this.ZD;
    }
    this.ZG.a();
    if (this.ZG.gH() == null) {
      return null;
    }
    try
    {
      this.ZD = new GoogleMap(((e)this.ZG.gH()).a().getMap());
      return this.ZD;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    this.ZG.onCreate(paramBundle);
    if (this.ZG.gH() == null)
    {
      paramBundle = this.ZG;
      f.b(this);
    }
  }
  
  public final void onDestroy()
  {
    this.ZG.onDestroy();
  }
  
  public final void onLowMemory()
  {
    this.ZG.onLowMemory();
  }
  
  public final void onPause()
  {
    this.ZG.onPause();
  }
  
  public final void onResume()
  {
    this.ZG.onResume();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    this.ZG.onSaveInstanceState(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/MapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */