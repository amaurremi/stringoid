package org.osmdroid.google.overlay;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.osmdroid.api.IGeoPoint;

public class GooglePolylineOverlay
  extends Overlay
{
  protected Paint mPaint = new Paint();
  private final Path mPath = new Path();
  private ArrayList<GeoPoint> mPoints;
  private final Point mTempPoint1 = new Point();
  private final Point mTempPoint2 = new Point();
  
  public GooglePolylineOverlay(int paramInt)
  {
    this(paramInt, 2.0F);
  }
  
  public GooglePolylineOverlay(int paramInt, float paramFloat)
  {
    this.mPaint.setColor(paramInt);
    this.mPaint.setStrokeWidth(paramFloat);
    this.mPaint.setStyle(Paint.Style.STROKE);
    clearPath();
  }
  
  public void addPoint(int paramInt1, int paramInt2)
  {
    this.mPoints.add(new GeoPoint(paramInt1, paramInt2));
  }
  
  public void addPoints(List<IGeoPoint> paramList)
  {
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return;
      }
      IGeoPoint localIGeoPoint = (IGeoPoint)paramList.next();
      addPoint(localIGeoPoint.getLatitudeE6(), localIGeoPoint.getLongitudeE6());
    }
  }
  
  public void addPoints(IGeoPoint... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      IGeoPoint localIGeoPoint = paramVarArgs[i];
      addPoint(localIGeoPoint.getLatitudeE6(), localIGeoPoint.getLongitudeE6());
      i += 1;
    }
  }
  
  public void clearPath()
  {
    this.mPoints = new ArrayList();
  }
  
  public void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    int i;
    do
    {
      return;
      i = this.mPoints.size();
    } while (i < 2);
    Projection localProjection = paramMapView.getProjection();
    Object localObject2 = null;
    this.mPath.rewind();
    Object localObject1 = (GeoPoint)this.mPoints.get(i - 1);
    i -= 2;
    if (i < 0)
    {
      paramCanvas.drawPath(this.mPath, this.mPaint);
      return;
    }
    GeoPoint localGeoPoint = (GeoPoint)this.mPoints.get(i);
    paramMapView = (MapView)localObject2;
    if (localObject2 == null)
    {
      paramMapView = localProjection.toPixels((GeoPoint)localObject1, this.mTempPoint1);
      this.mPath.moveTo(paramMapView.x, paramMapView.y);
    }
    localObject2 = localProjection.toPixels(localGeoPoint, this.mTempPoint2);
    if (Math.abs(((Point)localObject2).x - paramMapView.x) + Math.abs(((Point)localObject2).y - paramMapView.y) <= 1) {}
    for (;;)
    {
      i -= 1;
      localObject2 = paramMapView;
      break;
      this.mPath.lineTo(((Point)localObject2).x, ((Point)localObject2).y);
      localObject1 = localGeoPoint;
      paramMapView.x = ((Point)localObject2).x;
      paramMapView.y = ((Point)localObject2).y;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/google/overlay/GooglePolylineOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */