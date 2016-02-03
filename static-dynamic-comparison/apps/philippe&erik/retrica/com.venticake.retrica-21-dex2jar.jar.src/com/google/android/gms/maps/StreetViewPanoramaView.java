package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class StreetViewPanoramaView
  extends FrameLayout
{
  private StreetViewPanorama ZT;
  private final i aac;
  
  public StreetViewPanoramaView(Context paramContext)
  {
    super(paramContext);
    this.aac = new i(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.aac = new i(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.aac = new i(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
  {
    super(paramContext);
    this.aac = new i(this, paramContext, paramStreetViewPanoramaOptions);
  }
  
  public final StreetViewPanorama getStreetViewPanorama()
  {
    if (this.ZT != null) {
      return this.ZT;
    }
    this.aac.a();
    if (this.aac.gH() == null) {
      return null;
    }
    try
    {
      this.ZT = new StreetViewPanorama(((j)this.aac.gH()).a().getStreetViewPanorama());
      return this.ZT;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    this.aac.onCreate(paramBundle);
    if (this.aac.gH() == null)
    {
      paramBundle = this.aac;
      i.b(this);
    }
  }
  
  public final void onDestroy()
  {
    this.aac.onDestroy();
  }
  
  public final void onLowMemory()
  {
    this.aac.onLowMemory();
  }
  
  public final void onPause()
  {
    this.aac.onPause();
  }
  
  public final void onResume()
  {
    this.aac.onResume();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    this.aac.onSaveInstanceState(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/StreetViewPanoramaView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */