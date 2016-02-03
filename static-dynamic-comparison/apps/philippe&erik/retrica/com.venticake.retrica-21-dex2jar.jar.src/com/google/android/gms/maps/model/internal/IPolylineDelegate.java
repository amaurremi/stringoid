package com.google.android.gms.maps.model.internal;

import android.os.IInterface;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public abstract interface IPolylineDelegate
  extends IInterface
{
  public abstract boolean equalsRemote(IPolylineDelegate paramIPolylineDelegate);
  
  public abstract int getColor();
  
  public abstract String getId();
  
  public abstract List<LatLng> getPoints();
  
  public abstract float getWidth();
  
  public abstract float getZIndex();
  
  public abstract int hashCodeRemote();
  
  public abstract boolean isGeodesic();
  
  public abstract boolean isVisible();
  
  public abstract void remove();
  
  public abstract void setColor(int paramInt);
  
  public abstract void setGeodesic(boolean paramBoolean);
  
  public abstract void setPoints(List<LatLng> paramList);
  
  public abstract void setVisible(boolean paramBoolean);
  
  public abstract void setWidth(float paramFloat);
  
  public abstract void setZIndex(float paramFloat);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/internal/IPolylineDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */