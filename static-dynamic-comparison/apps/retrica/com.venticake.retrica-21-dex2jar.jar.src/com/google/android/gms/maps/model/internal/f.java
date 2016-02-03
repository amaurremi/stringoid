package com.google.android.gms.maps.model.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.maps.model.LatLng;

public abstract interface f
  extends IInterface
{
  public abstract float getAlpha();
  
  public abstract String getId();
  
  public abstract LatLng getPosition();
  
  public abstract float getRotation();
  
  public abstract String getSnippet();
  
  public abstract String getTitle();
  
  public abstract boolean h(f paramf);
  
  public abstract int hashCodeRemote();
  
  public abstract void hideInfoWindow();
  
  public abstract boolean isDraggable();
  
  public abstract boolean isFlat();
  
  public abstract boolean isInfoWindowShown();
  
  public abstract boolean isVisible();
  
  public abstract void m(d paramd);
  
  public abstract void remove();
  
  public abstract void setAlpha(float paramFloat);
  
  public abstract void setAnchor(float paramFloat1, float paramFloat2);
  
  public abstract void setDraggable(boolean paramBoolean);
  
  public abstract void setFlat(boolean paramBoolean);
  
  public abstract void setInfoWindowAnchor(float paramFloat1, float paramFloat2);
  
  public abstract void setPosition(LatLng paramLatLng);
  
  public abstract void setRotation(float paramFloat);
  
  public abstract void setSnippet(String paramString);
  
  public abstract void setTitle(String paramString);
  
  public abstract void setVisible(boolean paramBoolean);
  
  public abstract void showInfoWindow();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */