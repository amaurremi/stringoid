package com.mapbar.android.maps;

import android.graphics.Matrix;
import android.graphics.Point;
import android.util.Log;

final class PixelConverter
  implements Projection
{
  private final MapView a;
  private final Matrix b = new Matrix();
  private final Matrix c = new Matrix();
  private final float[] d = new float[2];
  private final Point e = new Point();
  
  PixelConverter(MapView paramMapView)
  {
    this.a = paramMapView;
    this.b.reset();
    this.c.reset();
  }
  
  private void transformTempPoint()
  {
    this.d[0] = this.e.x;
    this.d[1] = this.e.y;
    this.b.mapPoints(this.d);
    this.e.x = ((int)this.d[0]);
    this.e.y = ((int)this.d[1]);
  }
  
  public final GeoPoint fromPixels(int paramInt1, int paramInt2)
  {
    synchronized (this.e)
    {
      this.d[0] = paramInt1;
      this.d[1] = paramInt2;
      this.c.mapPoints(this.d);
      paramInt1 = (int)this.d[0];
      paramInt2 = (int)this.d[1];
      ??? = this.a.toMapCoordinate2(paramInt1, paramInt2);
      return new GeoPoint(???[1], ???[0]);
    }
  }
  
  public final double geoPointToMeters(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    double d1 = paramGeoPoint1.getLatitudeE6() / 1000000.0D;
    double d2 = paramGeoPoint2.getLatitudeE6() / 1000000.0D;
    double d3 = paramGeoPoint1.getLongitudeE6() / 1000000.0D;
    double d4 = paramGeoPoint2.getLongitudeE6() / 1000000.0D;
    double d5 = Math.abs(d1 - d2);
    return Math.sqrt(Math.abs(d1 - d2) * d5 + Math.abs(d3 - d4) * Math.abs(d3 - d4)) * 100000.0D;
  }
  
  public final float metersToEquatorPixels(float paramFloat)
  {
    paramFloat = new Double(1.0D / geoPointToMeters(pointToGeoPoint(new Point(0, 0)), pointToGeoPoint(new Point(1, 0)))).floatValue() * paramFloat;
    return (float)((paramFloat + (float)(paramFloat * 0.11111D)) / 0.8D);
  }
  
  public final GeoPoint pointToGeoPoint(Point paramPoint)
  {
    return this.a.pointToGeoPoint(paramPoint);
  }
  
  final void resetMatrix()
  {
    this.b.reset();
    this.c.reset();
  }
  
  final void setMatrix(Matrix paramMatrix, float paramFloat1, GeoPoint paramGeoPoint, float paramFloat2, float paramFloat3)
  {
    this.b.reset();
    synchronized (this.e)
    {
      this.a.getPointXY(paramGeoPoint.getPoint(), this.e);
      this.b.postTranslate(-this.e.x, -this.e.y);
      this.b.postScale(paramFloat1, paramFloat1);
      this.b.postTranslate(paramFloat2, paramFloat3);
      paramFloat1 = this.e.x;
      float f = this.e.y;
      paramMatrix.postTranslate(paramFloat1 - paramFloat2, f - paramFloat3);
      this.b.postConcat(paramMatrix);
      if (!this.b.invert(this.c)) {
        Log.e("PixelConverter", "Setting singular matrix " + this.b);
      }
      return;
    }
  }
  
  public final Point toPixels(GeoPoint paramGeoPoint, Point paramPoint)
  {
    return toPixels(paramGeoPoint, paramPoint, true);
  }
  
  final Point toPixels(GeoPoint paramGeoPoint, Point arg2, boolean paramBoolean)
  {
    if (paramGeoPoint == null) {
      return null;
    }
    Point localPoint = ???;
    if (??? == null) {
      localPoint = new Point();
    }
    synchronized (this.e)
    {
      this.a.getPointXY(paramGeoPoint.getPoint(), this.e);
      if (paramBoolean) {
        transformTempPoint();
      }
      localPoint.x = this.e.x;
      localPoint.y = this.e.y;
      return localPoint;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/PixelConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */