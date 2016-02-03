package com.mapbar.android.maps;

import android.graphics.Point;
import android.graphics.PointF;

public class l
{
  private GeoPoint a;
  private Point b = new Point();
  private Point c = new Point();
  private Point d = new Point();
  private Point e = new Point();
  private PointF f = new PointF();
  
  static
  {
    int[] arrayOfInt = { -16842908, -16842913, 16842919 };
    arrayOfInt = new int[] { -16842908, 16842913, -16842919 };
    arrayOfInt = new int[] { -16842908, 16842913, 16842919 };
    arrayOfInt = new int[] { 16842908, -16842913, -16842919 };
    arrayOfInt = new int[] { 16842908, -16842913, 16842919 };
    arrayOfInt = new int[] { 16842908, 16842913, -16842919 };
  }
  
  public l(GeoPoint paramGeoPoint, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramGeoPoint;
  }
  
  final PointF a()
  {
    this.f.x = ((float)(this.b.x + this.d.x + (-this.d.x + this.e.x) / 2.0D));
    this.f.y = ((float)(this.b.y + this.d.y + (-this.d.y + this.e.y) / 2.0D));
    return this.f;
  }
  
  final Point b()
  {
    return this.b;
  }
  
  final Point c()
  {
    return this.c;
  }
  
  final Point d()
  {
    return this.d;
  }
  
  final Point e()
  {
    return this.e;
  }
  
  public final GeoPoint f()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */