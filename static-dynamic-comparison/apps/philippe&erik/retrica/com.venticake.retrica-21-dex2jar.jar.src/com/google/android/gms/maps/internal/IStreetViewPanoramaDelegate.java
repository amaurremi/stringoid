package com.google.android.gms.maps.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public abstract interface IStreetViewPanoramaDelegate
  extends IInterface
{
  public abstract void animateTo(StreetViewPanoramaCamera paramStreetViewPanoramaCamera, long paramLong);
  
  public abstract void enablePanning(boolean paramBoolean);
  
  public abstract void enableStreetNames(boolean paramBoolean);
  
  public abstract void enableUserNavigation(boolean paramBoolean);
  
  public abstract void enableZoom(boolean paramBoolean);
  
  public abstract StreetViewPanoramaCamera getPanoramaCamera();
  
  public abstract StreetViewPanoramaLocation getStreetViewPanoramaLocation();
  
  public abstract boolean isPanningGesturesEnabled();
  
  public abstract boolean isStreetNamesEnabled();
  
  public abstract boolean isUserNavigationEnabled();
  
  public abstract boolean isZoomGesturesEnabled();
  
  public abstract d orientationToPoint(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation);
  
  public abstract StreetViewPanoramaOrientation pointToOrientation(d paramd);
  
  public abstract void setOnStreetViewPanoramaCameraChangeListener(p paramp);
  
  public abstract void setOnStreetViewPanoramaChangeListener(q paramq);
  
  public abstract void setOnStreetViewPanoramaClickListener(r paramr);
  
  public abstract void setPosition(LatLng paramLatLng);
  
  public abstract void setPositionWithID(String paramString);
  
  public abstract void setPositionWithRadius(LatLng paramLatLng, int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/internal/IStreetViewPanoramaDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */