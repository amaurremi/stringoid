package org.osmdroid.views.util;

import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import java.util.Iterator;
import java.util.List;
import org.osmdroid.util.BoundingBoxE6;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.util.TileSystem;
import org.osmdroid.views.MapView.Projection;

public class PathProjection
{
  public static Path toPixels(MapView.Projection paramProjection, List<? extends GeoPoint> paramList, Path paramPath)
  {
    return toPixels(paramProjection, paramList, paramPath, true);
  }
  
  public static Path toPixels(MapView.Projection paramProjection, List<? extends GeoPoint> paramList, Path paramPath, boolean paramBoolean)
    throws IllegalArgumentException
  {
    if (paramList.size() < 2) {
      throw new IllegalArgumentException("List of GeoPoints needs to be at least 2.");
    }
    int i;
    label45:
    Object localObject1;
    label247:
    int i1;
    int j;
    if (paramPath != null)
    {
      paramPath.incReserve(paramList.size());
      i = 1;
      Iterator localIterator = paramList.iterator();
      if (!localIterator.hasNext()) {
        return paramPath;
      }
      paramList = (GeoPoint)localIterator.next();
      Point localPoint = TileSystem.LatLongToPixelXY(paramList.getLatitudeE6() / 1000000.0D, paramList.getLongitudeE6() / 1000000.0D, paramProjection.getZoomLevel(), null);
      TileSystem.PixelXYToTileXY(localPoint.x, localPoint.y, localPoint);
      Object localObject2 = TileSystem.TileXYToPixelXY(localPoint.x, localPoint.y, null);
      localObject1 = TileSystem.TileXYToPixelXY(localPoint.x + TileSystem.getTileSize(), localPoint.y + TileSystem.getTileSize(), null);
      localObject2 = TileSystem.PixelXYToLatLong(((Point)localObject2).x, ((Point)localObject2).y, paramProjection.getZoomLevel(), null);
      localObject1 = TileSystem.PixelXYToLatLong(((Point)localObject1).x, ((Point)localObject1).y, paramProjection.getZoomLevel(), null);
      localObject1 = new BoundingBoxE6(((GeoPoint)localObject2).getLatitudeE6(), ((GeoPoint)localObject2).getLongitudeE6(), ((GeoPoint)localObject1).getLatitudeE6(), ((GeoPoint)localObject1).getLongitudeE6());
      if ((!paramBoolean) || (paramProjection.getZoomLevel() >= 7)) {
        break label417;
      }
      paramList = ((BoundingBoxE6)localObject1).getRelativePositionOfGeoPointInBoundingBoxWithExactGudermannInterpolation(paramList.getLatitudeE6(), paramList.getLongitudeE6(), null);
      localObject1 = paramProjection.getScreenRect();
      localObject1 = TileSystem.PixelXYToTileXY(((Rect)localObject1).centerX(), ((Rect)localObject1).centerY(), null);
      localObject2 = TileSystem.TileXYToPixelXY(((Point)localObject1).x, ((Point)localObject1).y, null);
      i1 = ((Point)localObject1).x;
      int i2 = localPoint.x;
      j = ((Point)localObject1).y;
      int k = localPoint.y;
      int i3 = ((Point)localObject2).x;
      int i4 = TileSystem.getTileSize();
      int m = ((Point)localObject2).y;
      int n = TileSystem.getTileSize();
      i1 = i3 - i4 * (i1 - i2) + (int)(paramList.x * TileSystem.getTileSize());
      j = m - n * (j - k) + (int)(paramList.y * TileSystem.getTileSize());
      if (i == 0) {
        break label435;
      }
      paramPath.moveTo(i1, j);
    }
    for (;;)
    {
      i = 0;
      break label45;
      paramPath = new Path();
      break;
      label417:
      paramList = ((BoundingBoxE6)localObject1).getRelativePositionOfGeoPointInBoundingBoxWithLinearInterpolation(paramList.getLatitudeE6(), paramList.getLongitudeE6(), null);
      break label247;
      label435:
      paramPath.lineTo(i1, j);
    }
    return paramPath;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/util/PathProjection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */