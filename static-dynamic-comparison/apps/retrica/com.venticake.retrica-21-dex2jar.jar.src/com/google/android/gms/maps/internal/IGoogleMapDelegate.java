package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.c;
import com.google.android.gms.maps.model.internal.h;

public abstract interface IGoogleMapDelegate
  extends IInterface
{
  public abstract com.google.android.gms.maps.model.internal.b addCircle(CircleOptions paramCircleOptions);
  
  public abstract c addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions);
  
  public abstract com.google.android.gms.maps.model.internal.f addMarker(MarkerOptions paramMarkerOptions);
  
  public abstract com.google.android.gms.maps.model.internal.g addPolygon(PolygonOptions paramPolygonOptions);
  
  public abstract IPolylineDelegate addPolyline(PolylineOptions paramPolylineOptions);
  
  public abstract h addTileOverlay(TileOverlayOptions paramTileOverlayOptions);
  
  public abstract void animateCamera(com.google.android.gms.dynamic.d paramd);
  
  public abstract void animateCameraWithCallback(com.google.android.gms.dynamic.d paramd, b paramb);
  
  public abstract void animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.d paramd, int paramInt, b paramb);
  
  public abstract void clear();
  
  public abstract CameraPosition getCameraPosition();
  
  public abstract com.google.android.gms.maps.model.internal.d getFocusedBuilding();
  
  public abstract int getMapType();
  
  public abstract float getMaxZoomLevel();
  
  public abstract float getMinZoomLevel();
  
  public abstract Location getMyLocation();
  
  public abstract IProjectionDelegate getProjection();
  
  public abstract com.google.android.gms.dynamic.d getTestingHelper();
  
  public abstract IUiSettingsDelegate getUiSettings();
  
  public abstract boolean isBuildingsEnabled();
  
  public abstract boolean isIndoorEnabled();
  
  public abstract boolean isMyLocationEnabled();
  
  public abstract boolean isTrafficEnabled();
  
  public abstract void moveCamera(com.google.android.gms.dynamic.d paramd);
  
  public abstract void setBuildingsEnabled(boolean paramBoolean);
  
  public abstract boolean setIndoorEnabled(boolean paramBoolean);
  
  public abstract void setInfoWindowAdapter(d paramd);
  
  public abstract void setLocationSource(ILocationSourceDelegate paramILocationSourceDelegate);
  
  public abstract void setMapType(int paramInt);
  
  public abstract void setMyLocationEnabled(boolean paramBoolean);
  
  public abstract void setOnCameraChangeListener(e parame);
  
  public abstract void setOnIndoorStateChangeListener(f paramf);
  
  public abstract void setOnInfoWindowClickListener(g paramg);
  
  public abstract void setOnMapClickListener(i parami);
  
  public abstract void setOnMapLoadedCallback(j paramj);
  
  public abstract void setOnMapLongClickListener(k paramk);
  
  public abstract void setOnMarkerClickListener(l paraml);
  
  public abstract void setOnMarkerDragListener(m paramm);
  
  public abstract void setOnMyLocationButtonClickListener(n paramn);
  
  public abstract void setOnMyLocationChangeListener(o paramo);
  
  public abstract void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setTrafficEnabled(boolean paramBoolean);
  
  public abstract void setWatermarkEnabled(boolean paramBoolean);
  
  public abstract void snapshot(s params, com.google.android.gms.dynamic.d paramd);
  
  public abstract void stopAnimation();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/internal/IGoogleMapDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */