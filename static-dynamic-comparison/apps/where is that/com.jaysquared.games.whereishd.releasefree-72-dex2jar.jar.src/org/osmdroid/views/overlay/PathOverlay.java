package org.osmdroid.views.overlay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.ResourceProxy;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapView.Projection;

public class PathOverlay
  extends Overlay
{
  private final Rect mLineBounds = new Rect();
  protected Paint mPaint = new Paint();
  private final Path mPath = new Path();
  private ArrayList<Point> mPoints;
  private int mPointsPrecomputed;
  private final Point mTempPoint1 = new Point();
  private final Point mTempPoint2 = new Point();
  
  public PathOverlay(int paramInt, float paramFloat, ResourceProxy paramResourceProxy)
  {
    super(paramResourceProxy);
    this.mPaint.setColor(paramInt);
    this.mPaint.setStrokeWidth(paramFloat);
    this.mPaint.setStyle(Paint.Style.STROKE);
    clearPath();
  }
  
  public PathOverlay(int paramInt, Context paramContext)
  {
    this(paramInt, 2.0F, new DefaultResourceProxyImpl(paramContext));
  }
  
  public PathOverlay(int paramInt, ResourceProxy paramResourceProxy)
  {
    this(paramInt, 2.0F, paramResourceProxy);
  }
  
  public void addGreatCircle(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    addGreatCircle(paramGeoPoint1, paramGeoPoint2, paramGeoPoint1.distanceTo(paramGeoPoint2) / 100000);
  }
  
  public void addGreatCircle(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2, int paramInt)
  {
    double d1 = paramGeoPoint1.getLatitude() * 3.141592653589793D / 180.0D;
    double d2 = paramGeoPoint1.getLongitude() * 3.141592653589793D / 180.0D;
    double d3 = paramGeoPoint2.getLatitude() * 3.141592653589793D / 180.0D;
    double d4 = paramGeoPoint2.getLongitude() * 3.141592653589793D / 180.0D;
    double d5 = 2.0D * Math.asin(Math.sqrt(Math.pow(Math.sin((d1 - d3) / 2.0D), 2.0D) + Math.cos(d1) * Math.cos(d3) * Math.pow(Math.sin((d2 - d4) / 2.0D), 2.0D)));
    double d6 = Math.atan2(Math.sin(d2 - d4) * Math.cos(d3), Math.cos(d1) * Math.sin(d3) - Math.sin(d1) * Math.cos(d3) * Math.cos(d2 - d4)) / -0.017453292519943295D;
    if (d6 < 0.0D) {}
    int i = 0;
    while (i < paramInt + 1)
    {
      double d7 = 1.0D / paramInt * i;
      d6 = Math.sin((1.0D - d7) * d5) / Math.sin(d5);
      double d9 = Math.sin(d7 * d5) / Math.sin(d5);
      d7 = Math.cos(d1) * d6 * Math.cos(d2) + Math.cos(d3) * d9 * Math.cos(d4);
      double d8 = Math.cos(d1) * d6 * Math.sin(d2) + Math.cos(d3) * d9 * Math.sin(d4);
      d6 = Math.atan2(Math.sin(d1) * d6 + Math.sin(d3) * d9, Math.sqrt(Math.pow(d7, 2.0D) + Math.pow(d8, 2.0D)));
      d7 = Math.atan2(d8, d7);
      addPoint((int)(d6 / 0.017453292519943295D * 1000000.0D), (int)(d7 / 0.017453292519943295D * 1000000.0D));
      i += 1;
    }
  }
  
  public void addPoint(int paramInt1, int paramInt2)
  {
    this.mPoints.add(new Point(paramInt1, paramInt2));
  }
  
  public void addPoint(IGeoPoint paramIGeoPoint)
  {
    addPoint(paramIGeoPoint.getLatitudeE6(), paramIGeoPoint.getLongitudeE6());
  }
  
  public void addPoints(List<IGeoPoint> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      addPoint((IGeoPoint)paramList.next());
    }
  }
  
  public void addPoints(IGeoPoint... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      addPoint(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public void clearPath()
  {
    this.mPoints = new ArrayList();
    this.mPointsPrecomputed = 0;
  }
  
  protected void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    int i;
    do
    {
      return;
      i = this.mPoints.size();
    } while (i < 2);
    MapView.Projection localProjection = paramMapView.getProjection();
    while (this.mPointsPrecomputed < i)
    {
      paramMapView = (Point)this.mPoints.get(this.mPointsPrecomputed);
      localProjection.toMapPixelsProjected(paramMapView.x, paramMapView.y, paramMapView);
      this.mPointsPrecomputed += 1;
    }
    Object localObject2 = null;
    localProjection.fromPixelsToProjected(localProjection.getScreenRect());
    this.mPath.rewind();
    Object localObject1 = (Point)this.mPoints.get(i - 1);
    this.mLineBounds.set(((Point)localObject1).x, ((Point)localObject1).y, ((Point)localObject1).x, ((Point)localObject1).y);
    i -= 2;
    if (i >= 0)
    {
      Point localPoint = (Point)this.mPoints.get(i);
      this.mLineBounds.union(localPoint.x, localPoint.y);
      paramMapView = (MapView)localObject2;
      if (localObject2 == null)
      {
        paramMapView = localProjection.toMapPixelsTranslated((Point)localObject1, this.mTempPoint1);
        this.mPath.moveTo(paramMapView.x, paramMapView.y);
      }
      localObject2 = localProjection.toMapPixelsTranslated(localPoint, this.mTempPoint2);
      if (Math.abs(((Point)localObject2).x - paramMapView.x) + Math.abs(((Point)localObject2).y - paramMapView.y) <= 1) {}
      for (;;)
      {
        i -= 1;
        localObject2 = paramMapView;
        break;
        this.mPath.lineTo(((Point)localObject2).x, ((Point)localObject2).y);
        localObject1 = localPoint;
        paramMapView.x = ((Point)localObject2).x;
        paramMapView.y = ((Point)localObject2).y;
        this.mLineBounds.set(((Point)localObject1).x, ((Point)localObject1).y, ((Point)localObject1).x, ((Point)localObject1).y);
      }
    }
    paramCanvas.drawPath(this.mPath, this.mPaint);
  }
  
  public int getNumberOfPoints()
  {
    return this.mPoints.size();
  }
  
  public Paint getPaint()
  {
    return this.mPaint;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }
  
  public void setColor(int paramInt)
  {
    this.mPaint.setColor(paramInt);
  }
  
  public void setPaint(Paint paramPaint)
  {
    if (paramPaint == null) {
      throw new IllegalArgumentException("pPaint argument cannot be null");
    }
    this.mPaint = paramPaint;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/views/overlay/PathOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */