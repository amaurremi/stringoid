package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.model.internal.c;

public final class GroundOverlay
{
  private final c SP;
  
  public GroundOverlay(c paramc)
  {
    this.SP = ((c)fq.f(paramc));
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GroundOverlay)) {
      return false;
    }
    try
    {
      boolean bool = this.SP.a(((GroundOverlay)paramObject).SP);
      return bool;
    }
    catch (RemoteException paramObject)
    {
      throw new RuntimeRemoteException((RemoteException)paramObject);
    }
  }
  
  public float getBearing()
  {
    try
    {
      float f = this.SP.getBearing();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public LatLngBounds getBounds()
  {
    try
    {
      LatLngBounds localLatLngBounds = this.SP.getBounds();
      return localLatLngBounds;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public float getHeight()
  {
    try
    {
      float f = this.SP.getHeight();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public String getId()
  {
    try
    {
      String str = this.SP.getId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public LatLng getPosition()
  {
    try
    {
      LatLng localLatLng = this.SP.getPosition();
      return localLatLng;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public float getTransparency()
  {
    try
    {
      float f = this.SP.getTransparency();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public float getWidth()
  {
    try
    {
      float f = this.SP.getWidth();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public float getZIndex()
  {
    try
    {
      float f = this.SP.getZIndex();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = this.SP.hashCodeRemote();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isVisible()
  {
    try
    {
      boolean bool = this.SP.isVisible();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void remove()
  {
    try
    {
      this.SP.remove();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setBearing(float paramFloat)
  {
    try
    {
      this.SP.setBearing(paramFloat);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setDimensions(float paramFloat)
  {
    try
    {
      this.SP.setDimensions(paramFloat);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setDimensions(float paramFloat1, float paramFloat2)
  {
    try
    {
      this.SP.a(paramFloat1, paramFloat2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setImage(BitmapDescriptor paramBitmapDescriptor)
  {
    try
    {
      this.SP.k(paramBitmapDescriptor.id());
      return;
    }
    catch (RemoteException paramBitmapDescriptor)
    {
      throw new RuntimeRemoteException(paramBitmapDescriptor);
    }
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    try
    {
      this.SP.setPosition(paramLatLng);
      return;
    }
    catch (RemoteException paramLatLng)
    {
      throw new RuntimeRemoteException(paramLatLng);
    }
  }
  
  public void setPositionFromBounds(LatLngBounds paramLatLngBounds)
  {
    try
    {
      this.SP.setPositionFromBounds(paramLatLngBounds);
      return;
    }
    catch (RemoteException paramLatLngBounds)
    {
      throw new RuntimeRemoteException(paramLatLngBounds);
    }
  }
  
  public void setTransparency(float paramFloat)
  {
    try
    {
      this.SP.setTransparency(paramFloat);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    try
    {
      this.SP.setVisible(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setZIndex(float paramFloat)
  {
    try
    {
      this.SP.setZIndex(paramFloat);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/maps/model/GroundOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */