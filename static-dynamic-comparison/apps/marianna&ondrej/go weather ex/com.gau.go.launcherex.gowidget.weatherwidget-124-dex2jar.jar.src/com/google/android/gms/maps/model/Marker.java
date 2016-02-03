package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.model.internal.f;

public final class Marker
{
  private final f Te;
  
  public Marker(f paramf)
  {
    this.Te = ((f)fq.f(paramf));
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Marker)) {
      return false;
    }
    try
    {
      boolean bool = this.Te.h(((Marker)paramObject).Te);
      return bool;
    }
    catch (RemoteException paramObject)
    {
      throw new RuntimeRemoteException((RemoteException)paramObject);
    }
  }
  
  public float getAlpha()
  {
    try
    {
      float f = this.Te.getAlpha();
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
      String str = this.Te.getId();
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
      LatLng localLatLng = this.Te.getPosition();
      return localLatLng;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public float getRotation()
  {
    try
    {
      float f = this.Te.getRotation();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public String getSnippet()
  {
    try
    {
      String str = this.Te.getSnippet();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public String getTitle()
  {
    try
    {
      String str = this.Te.getTitle();
      return str;
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
      int i = this.Te.hashCodeRemote();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void hideInfoWindow()
  {
    try
    {
      this.Te.hideInfoWindow();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isDraggable()
  {
    try
    {
      boolean bool = this.Te.isDraggable();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isFlat()
  {
    try
    {
      boolean bool = this.Te.isFlat();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isInfoWindowShown()
  {
    try
    {
      boolean bool = this.Te.isInfoWindowShown();
      return bool;
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
      boolean bool = this.Te.isVisible();
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
      this.Te.remove();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setAlpha(float paramFloat)
  {
    try
    {
      this.Te.setAlpha(paramFloat);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    try
    {
      this.Te.setAnchor(paramFloat1, paramFloat2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    try
    {
      this.Te.setDraggable(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setFlat(boolean paramBoolean)
  {
    try
    {
      this.Te.setFlat(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    try
    {
      this.Te.l(paramBitmapDescriptor.id());
      return;
    }
    catch (RemoteException paramBitmapDescriptor)
    {
      throw new RuntimeRemoteException(paramBitmapDescriptor);
    }
  }
  
  public void setInfoWindowAnchor(float paramFloat1, float paramFloat2)
  {
    try
    {
      this.Te.setInfoWindowAnchor(paramFloat1, paramFloat2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    try
    {
      this.Te.setPosition(paramLatLng);
      return;
    }
    catch (RemoteException paramLatLng)
    {
      throw new RuntimeRemoteException(paramLatLng);
    }
  }
  
  public void setRotation(float paramFloat)
  {
    try
    {
      this.Te.setRotation(paramFloat);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setSnippet(String paramString)
  {
    try
    {
      this.Te.setSnippet(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      throw new RuntimeRemoteException(paramString);
    }
  }
  
  public void setTitle(String paramString)
  {
    try
    {
      this.Te.setTitle(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      throw new RuntimeRemoteException(paramString);
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    try
    {
      this.Te.setVisible(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void showInfoWindow()
  {
    try
    {
      this.Te.showInfoWindow();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/maps/model/Marker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */