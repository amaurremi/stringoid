package com.mapbar.android.maps;

import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class OverlayBundle
{
  private final List<Overlay> a = Collections.synchronizedList(new ArrayList());
  
  final boolean draw(Canvas paramCanvas, MapView paramMapView, long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((Overlay)localIterator.next()).draw(paramCanvas, paramMapView, true, paramLong) | bool) {}
    localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      bool |= ((Overlay)localIterator.next()).draw(paramCanvas, paramMapView, false, paramLong);
    }
    return bool;
  }
  
  public final List<Overlay> getOverlays()
  {
    return this.a;
  }
  
  final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent, MapView paramMapView)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((Overlay)this.a.get(i)).onKeyDown(paramInt, paramKeyEvent, paramMapView)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent, MapView paramMapView)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((Overlay)this.a.get(i)).onKeyUp(paramInt, paramKeyEvent, paramMapView)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  final boolean onTap(GeoPoint paramGeoPoint, MapView paramMapView)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((Overlay)this.a.get(i)).onTap(paramGeoPoint, paramMapView)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  final boolean onTouchEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((Overlay)this.a.get(i)).onTouchEvent(paramMotionEvent, paramMapView)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  final boolean onTrackballEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((Overlay)this.a.get(i)).onTrackballEvent(paramMotionEvent, paramMapView)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/OverlayBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */