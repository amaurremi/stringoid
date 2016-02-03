package org.osmdroid.util;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.views.util.constants.MapViewConstants;

public class BoundingBoxE6
  implements Parcelable, Serializable, MapViewConstants
{
  public static final Parcelable.Creator<BoundingBoxE6> CREATOR = new Parcelable.Creator()
  {
    public BoundingBoxE6 createFromParcel(Parcel paramAnonymousParcel)
    {
      return BoundingBoxE6.readFromParcel(paramAnonymousParcel);
    }
    
    public BoundingBoxE6[] newArray(int paramAnonymousInt)
    {
      return new BoundingBoxE6[paramAnonymousInt];
    }
  };
  static final long serialVersionUID = 2L;
  protected final int mLatNorthE6;
  protected final int mLatSouthE6;
  protected final int mLonEastE6;
  protected final int mLonWestE6;
  
  public BoundingBoxE6(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    this.mLatNorthE6 = ((int)(paramDouble1 * 1000000.0D));
    this.mLonEastE6 = ((int)(paramDouble2 * 1000000.0D));
    this.mLatSouthE6 = ((int)(paramDouble3 * 1000000.0D));
    this.mLonWestE6 = ((int)(paramDouble4 * 1000000.0D));
  }
  
  public BoundingBoxE6(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLatNorthE6 = paramInt1;
    this.mLonEastE6 = paramInt2;
    this.mLatSouthE6 = paramInt3;
    this.mLonWestE6 = paramInt4;
  }
  
  public static BoundingBoxE6 fromGeoPoints(ArrayList<? extends GeoPoint> paramArrayList)
  {
    int m = Integer.MAX_VALUE;
    int j = Integer.MAX_VALUE;
    int k = Integer.MIN_VALUE;
    int i = Integer.MIN_VALUE;
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      GeoPoint localGeoPoint = (GeoPoint)paramArrayList.next();
      int i1 = localGeoPoint.getLatitudeE6();
      int n = localGeoPoint.getLongitudeE6();
      m = Math.min(m, i1);
      j = Math.min(j, n);
      k = Math.max(k, i1);
      i = Math.max(i, n);
    }
    return new BoundingBoxE6(k, i, m, j);
  }
  
  private static BoundingBoxE6 readFromParcel(Parcel paramParcel)
  {
    return new BoundingBoxE6(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt());
  }
  
  public GeoPoint bringToBoundingBox(int paramInt1, int paramInt2)
  {
    return new GeoPoint(Math.max(this.mLatSouthE6, Math.min(this.mLatNorthE6, paramInt1)), Math.max(this.mLonWestE6, Math.min(this.mLonEastE6, paramInt2)));
  }
  
  public boolean contains(int paramInt1, int paramInt2)
  {
    return (paramInt1 < this.mLatNorthE6) && (paramInt1 > this.mLatSouthE6) && (paramInt2 < this.mLonEastE6) && (paramInt2 > this.mLonWestE6);
  }
  
  public boolean contains(IGeoPoint paramIGeoPoint)
  {
    return contains(paramIGeoPoint.getLatitudeE6(), paramIGeoPoint.getLongitudeE6());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public GeoPoint getCenter()
  {
    return new GeoPoint((this.mLatNorthE6 + this.mLatSouthE6) / 2, (this.mLonEastE6 + this.mLonWestE6) / 2);
  }
  
  public int getDiagonalLengthInMeters()
  {
    return new GeoPoint(this.mLatNorthE6, this.mLonWestE6).distanceTo(new GeoPoint(this.mLatSouthE6, this.mLonEastE6));
  }
  
  public GeoPoint getGeoPointOfRelativePositionWithExactGudermannInterpolation(float paramFloat1, float paramFloat2)
  {
    double d1 = MyMath.gudermannInverse(this.mLatNorthE6 / 1000000.0D);
    double d2 = MyMath.gudermannInverse(this.mLatSouthE6 / 1000000.0D);
    int i = (int)(1000000.0D * MyMath.gudermann((1.0F - paramFloat2) * (d1 - d2) + d2));
    int k = (int)(this.mLonWestE6 + getLongitudeSpanE6() * paramFloat1);
    int j;
    for (;;)
    {
      j = i;
      if (i <= 90500000) {
        break;
      }
      i -= 90500000;
    }
    for (;;)
    {
      i = k;
      if (j >= -90500000) {
        break;
      }
      j += 90500000;
    }
    for (;;)
    {
      k = i;
      if (i <= 180000000) {
        break;
      }
      i -= 180000000;
    }
    while (k < -180000000) {
      k += 180000000;
    }
    return new GeoPoint(j, k);
  }
  
  public GeoPoint getGeoPointOfRelativePositionWithLinearInterpolation(float paramFloat1, float paramFloat2)
  {
    int i = (int)(this.mLatNorthE6 - getLatitudeSpanE6() * paramFloat2);
    int k = (int)(this.mLonWestE6 + getLongitudeSpanE6() * paramFloat1);
    int j;
    for (;;)
    {
      j = i;
      if (i <= 90500000) {
        break;
      }
      i -= 90500000;
    }
    for (;;)
    {
      i = k;
      if (j >= -90500000) {
        break;
      }
      j += 90500000;
    }
    for (;;)
    {
      k = i;
      if (i <= 180000000) {
        break;
      }
      i -= 180000000;
    }
    while (k < -180000000) {
      k += 180000000;
    }
    return new GeoPoint(j, k);
  }
  
  public int getLatNorthE6()
  {
    return this.mLatNorthE6;
  }
  
  public int getLatSouthE6()
  {
    return this.mLatSouthE6;
  }
  
  public int getLatitudeSpanE6()
  {
    return Math.abs(this.mLatNorthE6 - this.mLatSouthE6);
  }
  
  public int getLonEastE6()
  {
    return this.mLonEastE6;
  }
  
  public int getLonWestE6()
  {
    return this.mLonWestE6;
  }
  
  public int getLongitudeSpanE6()
  {
    return Math.abs(this.mLonEastE6 - this.mLonWestE6);
  }
  
  public PointF getRelativePositionOfGeoPointInBoundingBoxWithExactGudermannInterpolation(int paramInt1, int paramInt2, PointF paramPointF)
  {
    if (paramPointF != null) {}
    for (;;)
    {
      float f = (float)((MyMath.gudermannInverse(this.mLatNorthE6 / 1000000.0D) - MyMath.gudermannInverse(paramInt1 / 1000000.0D)) / (MyMath.gudermannInverse(this.mLatNorthE6 / 1000000.0D) - MyMath.gudermannInverse(this.mLatSouthE6 / 1000000.0D)));
      paramPointF.set(1.0F - (this.mLonEastE6 - paramInt2) / getLongitudeSpanE6(), f);
      return paramPointF;
      paramPointF = new PointF();
    }
  }
  
  public PointF getRelativePositionOfGeoPointInBoundingBoxWithLinearInterpolation(int paramInt1, int paramInt2, PointF paramPointF)
  {
    if (paramPointF != null) {}
    for (;;)
    {
      float f = (this.mLatNorthE6 - paramInt1) / getLatitudeSpanE6();
      paramPointF.set(1.0F - (this.mLonEastE6 - paramInt2) / getLongitudeSpanE6(), f);
      return paramPointF;
      paramPointF = new PointF();
    }
  }
  
  public BoundingBoxE6 increaseByScale(float paramFloat)
  {
    GeoPoint localGeoPoint = getCenter();
    int i = (int)(getLatitudeSpanE6() * paramFloat / 2.0F);
    int j = (int)(getLongitudeSpanE6() * paramFloat / 2.0F);
    return new BoundingBoxE6(localGeoPoint.getLatitudeE6() + i, localGeoPoint.getLongitudeE6() + j, localGeoPoint.getLatitudeE6() - i, localGeoPoint.getLongitudeE6() - j);
  }
  
  public String toString()
  {
    return "N:" + this.mLatNorthE6 + "; E:" + this.mLonEastE6 + "; S:" + this.mLatSouthE6 + "; W:" + this.mLonWestE6;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mLatNorthE6);
    paramParcel.writeInt(this.mLonEastE6);
    paramParcel.writeInt(this.mLatSouthE6);
    paramParcel.writeInt(this.mLonWestE6);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/util/BoundingBoxE6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */