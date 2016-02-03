package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.eg;
import com.google.android.gms.maps.model.internal.c;

public final class GroundOverlay
{
  private final c Cy;
  
  public GroundOverlay(c paramc)
  {
    this.Cy = ((c)eg.f(paramc));
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GroundOverlay)) {
      return false;
    }
    try
    {
      boolean bool = this.Cy.a(((GroundOverlay)paramObject).Cy);
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
      float f = this.Cy.getBearing();
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
      LatLngBounds localLatLngBounds = this.Cy.getBounds();
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
      float f = this.Cy.getHeight();
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
      String str = this.Cy.getId();
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
      LatLng localLatLng = this.Cy.getPosition();
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
      float f = this.Cy.getTransparency();
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
      float f = this.Cy.getWidth();
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
      float f = this.Cy.getZIndex();
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
      int i = this.Cy.hashCodeRemote();
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
      boolean bool = this.Cy.isVisible();
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
      this.Cy.remove();
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
      this.Cy.setBearing(paramFloat);
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
      this.Cy.setDimensions(paramFloat);
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
      this.Cy.a(paramFloat1, paramFloat2);
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
      this.Cy.h(paramBitmapDescriptor.el());
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
      this.Cy.setPosition(paramLatLng);
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
      this.Cy.setPositionFromBounds(paramLatLngBounds);
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
      this.Cy.setTransparency(paramFloat);
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
      this.Cy.setVisible(paramBoolean);
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
      this.Cy.setZIndex(paramFloat);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/maps/model/GroundOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */