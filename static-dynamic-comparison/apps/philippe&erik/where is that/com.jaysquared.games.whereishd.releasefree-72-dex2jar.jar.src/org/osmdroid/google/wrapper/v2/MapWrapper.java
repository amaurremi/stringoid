package org.osmdroid.google.wrapper.v2;

import android.text.TextUtils;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.api.IMap;
import org.osmdroid.api.IPosition;
import org.osmdroid.api.IProjection;
import org.osmdroid.api.Marker;
import org.osmdroid.api.Marker.Anchor;
import org.osmdroid.api.OnCameraChangeListener;

class MapWrapper
  implements IMap
{
  private static final Random random = new Random();
  private GoogleMap mGoogleMap;
  private HashMap<Integer, com.google.android.gms.maps.model.Polyline> mPolylines;
  
  MapWrapper(GoogleMap paramGoogleMap)
  {
    this.mGoogleMap = paramGoogleMap;
  }
  
  private com.google.android.gms.maps.model.Polyline getPolyline(int paramInt)
  {
    if (this.mPolylines == null) {
      throw new IllegalArgumentException("No such id");
    }
    com.google.android.gms.maps.model.Polyline localPolyline = (com.google.android.gms.maps.model.Polyline)this.mPolylines.get(Integer.valueOf(paramInt));
    if (localPolyline == null) {
      throw new IllegalArgumentException("No such id");
    }
    return localPolyline;
  }
  
  public void addMarker(Marker paramMarker)
  {
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.position(new LatLng(paramMarker.latitude, paramMarker.longitude));
    if (!TextUtils.isEmpty(paramMarker.title)) {
      localMarkerOptions.title(paramMarker.title);
    }
    if (!TextUtils.isEmpty(paramMarker.snippet)) {
      localMarkerOptions.snippet(paramMarker.snippet);
    }
    if (paramMarker.bitmap != null) {
      localMarkerOptions.icon(BitmapDescriptorFactory.fromBitmap(paramMarker.bitmap));
    }
    for (;;)
    {
      if (paramMarker.anchor == Marker.Anchor.CENTER) {
        localMarkerOptions.anchor(0.5F, 0.5F);
      }
      this.mGoogleMap.addMarker(localMarkerOptions);
      return;
      if (paramMarker.icon != 0) {
        localMarkerOptions.icon(BitmapDescriptorFactory.fromResource(paramMarker.icon));
      }
    }
  }
  
  public void addPointsToPolyline(int paramInt, IGeoPoint... paramVarArgs)
  {
    com.google.android.gms.maps.model.Polyline localPolyline = getPolyline(paramInt);
    List localList = localPolyline.getPoints();
    int i = paramVarArgs.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= i)
      {
        localPolyline.setPoints(localList);
        return;
      }
      IGeoPoint localIGeoPoint = paramVarArgs[paramInt];
      localList.add(new LatLng(localIGeoPoint.getLatitude(), localIGeoPoint.getLongitude()));
      paramInt += 1;
    }
  }
  
  public int addPolyline(org.osmdroid.api.Polyline paramPolyline)
  {
    if (this.mPolylines == null) {
      this.mPolylines = new HashMap();
    }
    PolylineOptions localPolylineOptions = new PolylineOptions().color(paramPolyline.color).width(paramPolyline.width);
    paramPolyline = paramPolyline.points.iterator();
    for (;;)
    {
      if (!paramPolyline.hasNext())
      {
        paramPolyline = this.mGoogleMap.addPolyline(localPolylineOptions);
        int i = random.nextInt();
        this.mPolylines.put(Integer.valueOf(i), paramPolyline);
        return i;
      }
      IGeoPoint localIGeoPoint = (IGeoPoint)paramPolyline.next();
      localPolylineOptions.add(new LatLng(localIGeoPoint.getLatitude(), localIGeoPoint.getLongitude()));
    }
  }
  
  public void clear()
  {
    this.mGoogleMap.clear();
  }
  
  public void clearPolyline(int paramInt)
  {
    getPolyline(paramInt).remove();
  }
  
  public float getBearing()
  {
    return this.mGoogleMap.getCameraPosition().bearing;
  }
  
  public IGeoPoint getCenter()
  {
    return new GeoPoint(this.mGoogleMap.getCameraPosition().target);
  }
  
  public IProjection getProjection()
  {
    return new Projection(this.mGoogleMap.getProjection());
  }
  
  public float getZoomLevel()
  {
    return this.mGoogleMap.getCameraPosition().zoom;
  }
  
  public boolean isMyLocationEnabled()
  {
    return this.mGoogleMap.isMyLocationEnabled();
  }
  
  public void setBearing(float paramFloat)
  {
    Object localObject = this.mGoogleMap.getCameraPosition();
    localObject = CameraUpdateFactory.newCameraPosition(new CameraPosition(((CameraPosition)localObject).target, ((CameraPosition)localObject).zoom, ((CameraPosition)localObject).tilt, paramFloat));
    this.mGoogleMap.moveCamera((CameraUpdate)localObject);
  }
  
  public void setCenter(double paramDouble1, double paramDouble2)
  {
    LatLng localLatLng = new LatLng(paramDouble1, paramDouble2);
    this.mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(localLatLng));
  }
  
  public void setMyLocationEnabled(boolean paramBoolean)
  {
    this.mGoogleMap.setMyLocationEnabled(paramBoolean);
  }
  
  public void setOnCameraChangeListener(final OnCameraChangeListener paramOnCameraChangeListener)
  {
    if (paramOnCameraChangeListener == null)
    {
      this.mGoogleMap.setOnCameraChangeListener(null);
      return;
    }
    this.mGoogleMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener()
    {
      public void onCameraChange(CameraPosition paramAnonymousCameraPosition)
      {
        paramOnCameraChangeListener.onCameraChange(null);
      }
    });
  }
  
  public void setPosition(IPosition paramIPosition)
  {
    CameraPosition localCameraPosition = this.mGoogleMap.getCameraPosition();
    LatLng localLatLng = new LatLng(paramIPosition.getLatitude(), paramIPosition.getLongitude());
    float f1;
    if (paramIPosition.hasBearing())
    {
      f1 = paramIPosition.getBearing();
      if (!paramIPosition.hasZoomLevel()) {
        break label100;
      }
    }
    label100:
    for (float f2 = paramIPosition.getZoomLevel();; f2 = localCameraPosition.zoom)
    {
      paramIPosition = CameraUpdateFactory.newCameraPosition(new CameraPosition(localLatLng, f2, localCameraPosition.tilt, f1));
      this.mGoogleMap.moveCamera(paramIPosition);
      return;
      f1 = localCameraPosition.bearing;
      break;
    }
  }
  
  public void setZoom(float paramFloat)
  {
    this.mGoogleMap.moveCamera(CameraUpdateFactory.zoomTo(paramFloat));
  }
  
  public boolean zoomIn()
  {
    CameraPosition localCameraPosition = this.mGoogleMap.getCameraPosition();
    float f = this.mGoogleMap.getMaxZoomLevel();
    if (localCameraPosition.zoom < f)
    {
      this.mGoogleMap.moveCamera(CameraUpdateFactory.zoomIn());
      return true;
    }
    return false;
  }
  
  public boolean zoomOut()
  {
    CameraPosition localCameraPosition = this.mGoogleMap.getCameraPosition();
    float f = this.mGoogleMap.getMinZoomLevel();
    if (localCameraPosition.zoom > f)
    {
      this.mGoogleMap.moveCamera(CameraUpdateFactory.zoomOut());
      return true;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/google/wrapper/v2/MapWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */