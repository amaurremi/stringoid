package com.jaysquared.games.whereishd.overlays;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.jaysquared.games.whereishd.utils.SLog;
import java.util.Iterator;
import java.util.List;
import org.osmdroid.ResourceProxy;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapView.Projection;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedIconOverlay.OnItemGestureListener;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.OverlayItem.HotspotPlace;

public class MarkerOverlay
  extends ItemizedIconOverlay<OverlayItem>
{
  private static final String LOG_TAG = MarkerOverlay.class.getSimpleName();
  private OverlayItem dragged = null;
  private List<OverlayItem> items = null;
  private MarkerDraggingListener listener = null;
  private Drawable marker = null;
  private int xMarkerOffset = 0;
  private int xOffset = 0;
  private int yMarkerOffset = 0;
  private int yOffset = 0;
  
  public MarkerOverlay(List<OverlayItem> paramList, Drawable paramDrawable, ItemizedIconOverlay.OnItemGestureListener<OverlayItem> paramOnItemGestureListener, ResourceProxy paramResourceProxy, MarkerDraggingListener paramMarkerDraggingListener, DisplayMetrics paramDisplayMetrics)
  {
    super(paramList, paramDrawable, paramOnItemGestureListener, paramResourceProxy);
    this.marker = paramDrawable;
    this.items = paramList;
    this.listener = paramMarkerDraggingListener;
    this.xMarkerOffset = ((int)(this.marker.getIntrinsicWidth() / 2.0D));
    this.yMarkerOffset = 0;
    populate();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    int k = paramMotionEvent.getAction();
    int m = (int)paramMotionEvent.getX();
    int n = (int)paramMotionEvent.getY();
    Object localObject1 = paramMapView.getProjection();
    int j = 0;
    Object localObject2 = new Point(0, 0);
    Point localPoint = new Point(0, 0);
    SLog.d(LOG_TAG, "marker x=" + m + " y=" + n);
    int i;
    if (k == 0)
    {
      Iterator localIterator = this.items.iterator();
      OverlayItem localOverlayItem;
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        localOverlayItem = (OverlayItem)localIterator.next();
        ((MapView.Projection)localObject1).fromMapPixels(m, n, localPoint);
        ((MapView.Projection)localObject1).toPixels(localOverlayItem.getPoint(), (Point)localObject2);
      } while (!hitTest(localOverlayItem, this.marker, localPoint.x - ((Point)localObject2).x, localPoint.y - ((Point)localObject2).y));
      SLog.d(LOG_TAG, "marker -----> HIT");
      i = 1;
      this.dragged = localOverlayItem;
      this.xOffset = (localPoint.x - ((Point)localObject2).x);
      this.yOffset = (localPoint.y - ((Point)localObject2).y);
    }
    while ((i != 0) || (super.onTouchEvent(paramMotionEvent, paramMapView)))
    {
      return true;
      if ((k == 2) && (this.dragged != null))
      {
        localObject1 = ((MapView.Projection)localObject1).fromPixels(this.xMarkerOffset + m, this.yMarkerOffset + n);
        localObject2 = new OverlayItem(this.dragged.getSnippet(), this.dragged.getTitle(), new GeoPoint(((IGeoPoint)localObject1).getLatitudeE6(), ((IGeoPoint)localObject1).getLongitudeE6()));
        this.items.remove(this.dragged);
        this.items.add(localObject2);
        populate();
        paramMapView.invalidate();
        if (this.listener != null) {
          this.listener.onDragging((IGeoPoint)localObject1, m, n);
        }
        this.dragged = ((OverlayItem)localObject2);
        i = 1;
      }
      else
      {
        i = j;
        if (k == 1)
        {
          i = j;
          if (this.dragged != null)
          {
            ((MapView.Projection)localObject1).fromMapPixels(m, n, localPoint);
            if ((localPoint.x - ((Point)localObject2).x == this.xOffset) && (localPoint.y - ((Point)localObject2).y == this.yOffset)) {
              return true;
            }
            localObject1 = ((MapView.Projection)localObject1).fromPixels(m, n);
            localObject2 = new OverlayItem(this.dragged.getSnippet(), this.dragged.getTitle(), new GeoPoint(((IGeoPoint)localObject1).getLatitudeE6(), ((IGeoPoint)localObject1).getLongitudeE6()));
            boundToHotspot(this.marker, OverlayItem.HotspotPlace.LOWER_LEFT_CORNER);
            this.items.remove(this.dragged);
            this.items.add(localObject2);
            populate();
            paramMapView.invalidate();
            if (this.listener != null) {
              this.listener.onDraggingFinished((IGeoPoint)localObject1);
            }
            this.dragged = null;
            i = 1;
          }
        }
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/overlays/MarkerOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */