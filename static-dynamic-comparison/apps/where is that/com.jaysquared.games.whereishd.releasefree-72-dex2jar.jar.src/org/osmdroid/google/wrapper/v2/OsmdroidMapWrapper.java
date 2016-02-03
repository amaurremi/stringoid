package org.osmdroid.google.wrapper.v2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.osmdroid.ResourceProxy;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.api.IMap;
import org.osmdroid.api.IMapController;
import org.osmdroid.api.IPosition;
import org.osmdroid.api.IProjection;
import org.osmdroid.api.Marker;
import org.osmdroid.api.Marker.Anchor;
import org.osmdroid.api.OnCameraChangeListener;
import org.osmdroid.api.Polyline;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.util.ResourceProxyImpl;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay.OnItemGestureListener;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.Overlay;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.OverlayItem.HotspotPlace;
import org.osmdroid.views.overlay.PathOverlay;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

class OsmdroidMapWrapper
  implements IMap
{
  private static final Random random = new Random();
  private ItemizedOverlayWithFocus<OverlayItem> mItemizedOverlay;
  private final MapView mMapView;
  private MyLocationNewOverlay mMyLocationOverlay;
  private OnCameraChangeListener mOnCameraChangeListener;
  private HashMap<Integer, PathOverlay> mPolylines;
  private ResourceProxy mResourceProxy;
  
  OsmdroidMapWrapper(MapView paramMapView)
  {
    this.mMapView = paramMapView;
    this.mMapView.getOverlays().add(new Overlay(this.mMapView.getContext())
    {
      protected void draw(Canvas paramAnonymousCanvas, MapView paramAnonymousMapView, boolean paramAnonymousBoolean) {}
      
      public boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent, MapView paramAnonymousMapView)
      {
        if (paramAnonymousMotionEvent.getAction() == 1) {
          OsmdroidMapWrapper.this.onCameraChange();
        }
        return super.onTouchEvent(paramAnonymousMotionEvent, paramAnonymousMapView);
      }
    });
  }
  
  private PathOverlay getPolyline(int paramInt)
  {
    if (this.mPolylines == null) {
      throw new IllegalArgumentException("No such id");
    }
    PathOverlay localPathOverlay = (PathOverlay)this.mPolylines.get(Integer.valueOf(paramInt));
    if (localPathOverlay == null) {
      throw new IllegalArgumentException("No such id");
    }
    return localPathOverlay;
  }
  
  private ResourceProxy getResourceProxy()
  {
    if (this.mResourceProxy == null) {
      this.mResourceProxy = new ResourceProxyImpl(this.mMapView.getContext());
    }
    return this.mResourceProxy;
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
      this.mItemizedOverlay = new ItemizedOverlayWithFocus(new ArrayList(), new ItemizedIconOverlay.OnItemGestureListener()
      {
        public boolean onItemLongPress(int paramAnonymousInt, OverlayItem paramAnonymousOverlayItem)
        {
          return false;
        }
        
        public boolean onItemSingleTapUp(int paramAnonymousInt, OverlayItem paramAnonymousOverlayItem)
        {
          return false;
        }
      }, getResourceProxy());
      this.mItemizedOverlay.setFocusItemsOnTap(true);
      this.mMapView.setUseSafeCanvas(false);
      this.mMapView.getOverlays().add(this.mItemizedOverlay);
    }
    OverlayItem localOverlayItem = new OverlayItem(paramMarker.title, paramMarker.snippet, new GeoPoint(paramMarker.latitude, paramMarker.longitude));
    if (paramMarker.bitmap != null) {
      localOverlayItem.setMarker(new BitmapDrawable(this.mMapView.getResources(), paramMarker.bitmap));
    }
    for (;;)
    {
      if (paramMarker.anchor == Marker.Anchor.CENTER) {
        localOverlayItem.setMarkerHotspot(OverlayItem.HotspotPlace.CENTER);
      }
      this.mItemizedOverlay.addItem(localOverlayItem);
      return;
      if (paramMarker.icon != 0) {
        localOverlayItem.setMarker(this.mMapView.getResources().getDrawable(paramMarker.icon));
      }
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
    PathOverlay localPathOverlay = new PathOverlay(paramPolyline.color, paramPolyline.width, getResourceProxy());
    localPathOverlay.addPoints(paramPolyline.points);
    this.mMapView.getOverlays().add(0, localPathOverlay);
    int i = random.nextInt();
    this.mPolylines.put(Integer.valueOf(i), localPathOverlay);
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
      PathOverlay localPathOverlay = (PathOverlay)localIterator.next();
      this.mMapView.getOverlays().remove(this.mPolylines.remove(localPathOverlay));
    }
  }
  
  public void clearPolyline(int paramInt)
  {
    PathOverlay localPathOverlay = getPolyline(paramInt);
    this.mMapView.getOverlays().remove(localPathOverlay);
    this.mPolylines.remove(Integer.valueOf(paramInt));
  }
  
  public float getBearing()
  {
    return -this.mMapView.getMapOrientation();
  }
  
  public IGeoPoint getCenter()
  {
    return this.mMapView.getMapCenter();
  }
  
  public IProjection getProjection()
  {
    return this.mMapView.getProjection();
  }
  
  public float getZoomLevel()
  {
    return this.mMapView.getZoomLevel();
  }
  
  public boolean isMyLocationEnabled()
  {
    return (this.mMyLocationOverlay != null) && (this.mMyLocationOverlay.isMyLocationEnabled());
  }
  
  public void setBearing(float paramFloat)
  {
    this.mMapView.setMapOrientation(-paramFloat);
  }
  
  public void setCenter(double paramDouble1, double paramDouble2)
  {
    this.mMapView.getController().setCenter(new GeoPoint(paramDouble1, paramDouble2));
    onCameraChange();
  }
  
  public void setMyLocationEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mMyLocationOverlay == null)
      {
        this.mMyLocationOverlay = new MyLocationNewOverlay(this.mMapView.getContext(), this.mMapView);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/google/wrapper/v2/OsmdroidMapWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */