package org.osmdroid.google.wrapper.v2;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.osmdroid.ResourceProxy.bitmap;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.api.IMap;
import org.osmdroid.api.IPosition;
import org.osmdroid.api.IProjection;
import org.osmdroid.api.Marker;
import org.osmdroid.api.Marker.Anchor;
import org.osmdroid.api.OnCameraChangeListener;
import org.osmdroid.api.Polyline;
import org.osmdroid.google.overlay.GoogleItemizedOverlay;
import org.osmdroid.google.overlay.GooglePolylineOverlay;
import org.osmdroid.google.wrapper.Projection;
import org.osmdroid.util.ResourceProxyImpl;

class GoogleV1MapWrapper
  implements IMap
{
  private static final Random random = new Random();
  private GoogleItemizedOverlay mItemizedOverlay;
  private final MapView mMapView;
  private MyLocationOverlay mMyLocationOverlay;
  private OnCameraChangeListener mOnCameraChangeListener;
  private HashMap<Integer, GooglePolylineOverlay> mPolylines;
  
  GoogleV1MapWrapper(MapView paramMapView)
  {
    this.mMapView = paramMapView;
    this.mMapView.setClickable(true);
    this.mMapView.getOverlays().add(new Overlay()
    {
      public boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent, MapView paramAnonymousMapView)
      {
        if (paramAnonymousMotionEvent.getAction() == 1) {
          GoogleV1MapWrapper.this.onCameraChange();
        }
        return super.onTouchEvent(paramAnonymousMotionEvent, paramAnonymousMapView);
      }
    });
  }
  
  private GooglePolylineOverlay getPolyline(int paramInt)
  {
    if (this.mPolylines == null) {
      throw new IllegalArgumentException("No such id");
    }
    GooglePolylineOverlay localGooglePolylineOverlay = (GooglePolylineOverlay)this.mPolylines.get(Integer.valueOf(paramInt));
    if (localGooglePolylineOverlay == null) {
      throw new IllegalArgumentException("No such id");
    }
    return localGooglePolylineOverlay;
  }
  
  private void onCameraChange()
  {
    if (this.mOnCameraChangeListener != null) {
      this.mOnCameraChangeListener.onCameraChange(null);
    }
  }
  
  public void addMarker(Marker paramMarker)
  {
    if (this.mItemizedOverlay == null)
    {
      this.mItemizedOverlay = new GoogleItemizedOverlay(new ResourceProxyImpl(this.mMapView.getContext()).getDrawable(ResourceProxy.bitmap.marker_default));
      this.mMapView.getOverlays().add(this.mItemizedOverlay);
    }
    OverlayItem localOverlayItem = new OverlayItem(new com.google.android.maps.GeoPoint((int)(paramMarker.latitude * 1000000.0D), (int)(paramMarker.longitude * 1000000.0D)), paramMarker.title, paramMarker.snippet);
    Object localObject;
    if ((paramMarker.bitmap != null) || (paramMarker.icon != 0))
    {
      if (paramMarker.bitmap == null) {
        break label160;
      }
      localObject = new BitmapDrawable(this.mMapView.getResources(), paramMarker.bitmap);
      if (paramMarker.anchor != Marker.Anchor.CENTER) {
        break label178;
      }
      GoogleItemizedOverlay.setOverlayMarkerCentered(localOverlayItem, (Drawable)localObject);
    }
    for (;;)
    {
      this.mItemizedOverlay.addOverlay(localOverlayItem);
      return;
      label160:
      localObject = this.mMapView.getResources().getDrawable(paramMarker.icon);
      break;
      label178:
      localOverlayItem.setMarker((Drawable)localObject);
    }
  }
  
  public void addPointsToPolyline(int paramInt, IGeoPoint... paramVarArgs)
  {
    getPolyline(paramInt).addPoints(paramVarArgs);
  }
  
  public int addPolyline(Polyline paramPolyline)
  {
    if (this.mPolylines == null) {
      this.mPolylines = new HashMap();
    }
    GooglePolylineOverlay localGooglePolylineOverlay = new GooglePolylineOverlay(paramPolyline.color, paramPolyline.width);
    localGooglePolylineOverlay.addPoints(paramPolyline.points);
    this.mMapView.getOverlays().add(0, localGooglePolylineOverlay);
    int i = random.nextInt();
    this.mPolylines.put(Integer.valueOf(i), localGooglePolylineOverlay);
    return i;
  }
  
  public void clear()
  {
    if (this.mItemizedOverlay != null) {
      this.mItemizedOverlay.removeAllItems();
    }
    Iterator localIterator;
    if (this.mPolylines != null) {
      localIterator = this.mPolylines.values().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.mPolylines.clear();
        return;
      }
      GooglePolylineOverlay localGooglePolylineOverlay = (GooglePolylineOverlay)localIterator.next();
      this.mMapView.getOverlays().remove(this.mPolylines.remove(localGooglePolylineOverlay));
    }
  }
  
  public void clearPolyline(int paramInt)
  {
    GooglePolylineOverlay localGooglePolylineOverlay = getPolyline(paramInt);
    this.mMapView.getOverlays().remove(localGooglePolylineOverlay);
    this.mPolylines.remove(Integer.valueOf(paramInt));
  }
  
  public float getBearing()
  {
    return 0.0F;
  }
  
  public IGeoPoint getCenter()
  {
    return new org.osmdroid.google.wrapper.GeoPoint(this.mMapView.getMapCenter());
  }
  
  public IProjection getProjection()
  {
    return new Projection(this.mMapView);
  }
  
  public float getZoomLevel()
  {
    return this.mMapView.getZoomLevel();
  }
  
  public boolean isMyLocationEnabled()
  {
    return (this.mMyLocationOverlay != null) && (this.mMyLocationOverlay.isMyLocationEnabled());
  }
  
  public void setBearing(float paramFloat) {}
  
  public void setCenter(double paramDouble1, double paramDouble2)
  {
    this.mMapView.getController().setCenter(new com.google.android.maps.GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D)));
    onCameraChange();
  }
  
  public void setMyLocationEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mMyLocationOverlay == null)
      {
        this.mMyLocationOverlay = new MyLocationOverlay(this.mMapView.getContext(), this.mMapView);
        this.mMapView.getOverlays().add(this.mMyLocationOverlay);
      }
      this.mMyLocationOverlay.enableMyLocation();
    }
    if ((!paramBoolean) && (this.mMyLocationOverlay != null)) {
      this.mMyLocationOverlay.disableMyLocation();
    }
  }
  
  public void setOnCameraChangeListener(OnCameraChangeListener paramOnCameraChangeListener)
  {
    this.mOnCameraChangeListener = paramOnCameraChangeListener;
  }
  
  public void setPosition(IPosition paramIPosition)
  {
    if (paramIPosition.hasBearing()) {
      setBearing(paramIPosition.getBearing());
    }
    if (paramIPosition.hasZoomLevel()) {
      setZoom(paramIPosition.getZoomLevel());
    }
    setCenter(paramIPosition.getLatitude(), paramIPosition.getLongitude());
  }
  
  public void setZoom(float paramFloat)
  {
    this.mMapView.getController().setZoom((int)paramFloat);
  }
  
  public boolean zoomIn()
  {
    return this.mMapView.getController().zoomIn();
  }
  
  public boolean zoomOut()
  {
    return this.mMapView.getController().zoomOut();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/google/wrapper/v2/GoogleV1MapWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */