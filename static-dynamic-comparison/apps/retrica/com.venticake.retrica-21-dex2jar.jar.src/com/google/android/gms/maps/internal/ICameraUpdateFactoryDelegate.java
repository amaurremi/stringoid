package com.google.android.gms.maps.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public abstract interface ICameraUpdateFactoryDelegate
  extends IInterface
{
  public abstract d newCameraPosition(CameraPosition paramCameraPosition);
  
  public abstract d newLatLng(LatLng paramLatLng);
  
  public abstract d newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt);
  
  public abstract d newLatLngBoundsWithSize(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract d newLatLngZoom(LatLng paramLatLng, float paramFloat);
  
  public abstract d scrollBy(float paramFloat1, float paramFloat2);
  
  public abstract d zoomBy(float paramFloat);
  
  public abstract d zoomByWithFocus(float paramFloat, int paramInt1, int paramInt2);
  
  public abstract d zoomIn();
  
  public abstract d zoomOut();
  
  public abstract d zoomTo(float paramFloat);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/internal/ICameraUpdateFactoryDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */