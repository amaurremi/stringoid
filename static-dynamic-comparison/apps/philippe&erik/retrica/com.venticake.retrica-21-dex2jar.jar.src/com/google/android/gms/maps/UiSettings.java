package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class UiSettings
{
  private final IUiSettingsDelegate aai;
  
  UiSettings(IUiSettingsDelegate paramIUiSettingsDelegate)
  {
    this.aai = paramIUiSettingsDelegate;
  }
  
  public boolean isCompassEnabled()
  {
    try
    {
      boolean bool = this.aai.isCompassEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isIndoorLevelPickerEnabled()
  {
    try
    {
      boolean bool = this.aai.isIndoorLevelPickerEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isMyLocationButtonEnabled()
  {
    try
    {
      boolean bool = this.aai.isMyLocationButtonEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isRotateGesturesEnabled()
  {
    try
    {
      boolean bool = this.aai.isRotateGesturesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isScrollGesturesEnabled()
  {
    try
    {
      boolean bool = this.aai.isScrollGesturesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isTiltGesturesEnabled()
  {
    try
    {
      boolean bool = this.aai.isTiltGesturesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isZoomControlsEnabled()
  {
    try
    {
      boolean bool = this.aai.isZoomControlsEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isZoomGesturesEnabled()
  {
    try
    {
      boolean bool = this.aai.isZoomGesturesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setAllGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.aai.setAllGesturesEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setCompassEnabled(boolean paramBoolean)
  {
    try
    {
      this.aai.setCompassEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setIndoorLevelPickerEnabled(boolean paramBoolean)
  {
    try
    {
      this.aai.setIndoorLevelPickerEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setMyLocationButtonEnabled(boolean paramBoolean)
  {
    try
    {
      this.aai.setMyLocationButtonEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setRotateGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.aai.setRotateGesturesEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setScrollGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.aai.setScrollGesturesEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setTiltGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.aai.setTiltGesturesEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setZoomControlsEnabled(boolean paramBoolean)
  {
    try
    {
      this.aai.setZoomControlsEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setZoomGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.aai.setZoomGesturesEnabled(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/UiSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */