package org.osmdroid.util;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import org.osmdroid.api.IGeoPoint;
import org.osmdroid.util.constants.GeoConstants;
import org.osmdroid.views.util.constants.MathConstants;

public class GeoPoint
  implements IGeoPoint, MathConstants, GeoConstants, Parcelable, Serializable, Cloneable
{
  public static final Parcelable.Creator<GeoPoint> CREATOR = new Parcelable.Creator()
  {
    public GeoPoint createFromParcel(Parcel paramAnonymousParcel)
    {
      return new GeoPoint(paramAnonymousParcel, null);
    }
    
    public GeoPoint[] newArray(int paramAnonymousInt)
    {
      return new GeoPoint[paramAnonymousInt];
    }
  };
  static final long serialVersionUID = 1L;
  private int mAltitude;
  private int mLatitudeE6;
  private int mLongitudeE6;
  
  public GeoPoint(double paramDouble1, double paramDouble2)
  {
    this.mLatitudeE6 = ((int)(paramDouble1 * 1000000.0D));
    this.mLongitudeE6 = ((int)(paramDouble2 * 1000000.0D));
  }
  
  public GeoPoint(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    this.mLatitudeE6 = ((int)(paramDouble1 * 1000000.0D));
    this.mLongitudeE6 = ((int)(paramDouble2 * 1000000.0D));
    this.mAltitude = ((int)paramDouble3);
  }
  
  public GeoPoint(int paramInt1, int paramInt2)
  {
    this.mLatitudeE6 = paramInt1;
    this.mLongitudeE6 = paramInt2;
  }
  
  public GeoPoint(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mLatitudeE6 = paramInt1;
    this.mLongitudeE6 = paramInt2;
    this.mAltitude = paramInt3;
  }
  
  public GeoPoint(Location paramLocation)
  {
    this(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getAltitude());
  }
  
  private GeoPoint(Parcel paramParcel)
  {
    this.mLatitudeE6 = paramParcel.readInt();
    this.mLongitudeE6 = paramParcel.readInt();
    this.mAltitude = paramParcel.readInt();
  }
  
  public GeoPoint(GeoPoint paramGeoPoint)
  {
    this.mLatitudeE6 = paramGeoPoint.mLatitudeE6;
    this.mLongitudeE6 = paramGeoPoint.mLongitudeE6;
    this.mAltitude = paramGeoPoint.mAltitude;
  }
  
  public static GeoPoint fromCenterBetween(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    return new GeoPoint((paramGeoPoint1.getLatitudeE6() + paramGeoPoint2.getLatitudeE6()) / 2, (paramGeoPoint1.getLongitudeE6() + paramGeoPoint2.getLongitudeE6()) / 2);
  }
  
  public static GeoPoint fromDoubleString(String paramString, char paramChar)
  {
    int i = paramString.indexOf(paramChar);
    paramChar = paramString.indexOf(paramChar, i + 1);
    if (paramChar == '￿') {
      return new GeoPoint((int)(Double.parseDouble(paramString.substring(0, i)) * 1000000.0D), (int)(Double.parseDouble(paramString.substring(i + 1, paramString.length())) * 1000000.0D));
    }
    return new GeoPoint((int)(Double.parseDouble(paramString.substring(0, i)) * 1000000.0D), (int)(Double.parseDouble(paramString.substring(i + 1, paramChar)) * 1000000.0D), (int)Double.parseDouble(paramString.substring(paramChar + '\001', paramString.length())));
  }
  
  public static GeoPoint fromIntString(String paramString)
  {
    int i = paramString.indexOf(',');
    int j = paramString.indexOf(',', i + 1);
    if (j == -1) {
      return new GeoPoint(Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1, paramString.length())));
    }
    return new GeoPoint(Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1, j)), Integer.parseInt(paramString.substring(j + 1, paramString.length())));
  }
  
  public static GeoPoint fromInvertedDoubleString(String paramString, char paramChar)
  {
    int i = paramString.indexOf(paramChar);
    paramChar = paramString.indexOf(paramChar, i + 1);
    if (paramChar == '￿') {
      return new GeoPoint((int)(Double.parseDouble(paramString.substring(i + 1, paramString.length())) * 1000000.0D), (int)(Double.parseDouble(paramString.substring(0, i)) * 1000000.0D));
    }
    return new GeoPoint((int)(Double.parseDouble(paramString.substring(i + 1, paramChar)) * 1000000.0D), (int)(Double.parseDouble(paramString.substring(0, i)) * 1000000.0D), (int)Double.parseDouble(paramString.substring(paramChar + '\001', paramString.length())));
  }
  
  public double bearingTo(IGeoPoint paramIGeoPoint)
  {
    double d1 = Math.toRadians(this.mLatitudeE6 / 1000000.0D);
    double d3 = Math.toRadians(this.mLongitudeE6 / 1000000.0D);
    double d2 = Math.toRadians(paramIGeoPoint.getLatitudeE6() / 1000000.0D);
    d3 = Math.toRadians(paramIGeoPoint.getLongitudeE6() / 1000000.0D) - d3;
    return (360.0D + Math.toDegrees(Math.atan2(Math.sin(d3) * Math.cos(d2), Math.cos(d1) * Math.sin(d2) - Math.sin(d1) * Math.cos(d2) * Math.cos(d3)))) % 360.0D;
  }
  
  public GeoPoint clone()
  {
    return new GeoPoint(this.mLatitudeE6, this.mLongitudeE6, this.mAltitude);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public GeoPoint destinationPoint(double paramDouble, float paramFloat)
  {
    double d2 = paramDouble / 6378137.0D;
    paramFloat = 0.017453292F * paramFloat;
    double d3 = 0.017453292F * getLatitudeE6() / 1000000.0D;
    paramDouble = 0.017453292F * getLongitudeE6() / 1000000.0D;
    double d1 = Math.asin(Math.sin(d3) * Math.cos(d2) + Math.cos(d3) * Math.sin(d2) * Math.cos(paramFloat));
    d2 = Math.atan2(Math.sin(paramFloat) * Math.sin(d2) * Math.cos(d3), Math.cos(d2) - Math.sin(d3) * Math.sin(d1));
    return new GeoPoint(d1 / 0.01745329238474369D, (paramDouble + d2) / 0.01745329238474369D);
  }
  
  public int distanceTo(IGeoPoint paramIGeoPoint)
  {
    double d1 = 0.017453292F * this.mLatitudeE6 / 1000000.0D;
    double d2 = 0.017453292F * this.mLongitudeE6 / 1000000.0D;
    double d3 = 0.017453292F * paramIGeoPoint.getLatitudeE6() / 1000000.0D;
    double d4 = 0.017453292F * paramIGeoPoint.getLongitudeE6() / 1000000.0D;
    double d5 = Math.cos(d1);
    double d6 = Math.cos(d3);
    return (int)(6378137.0D * Math.acos(Math.cos(d2) * d5 * d6 * Math.cos(d4) + Math.sin(d2) * d5 * d6 * Math.sin(d4) + Math.sin(d1) * Math.sin(d3)));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while (paramObject.getClass() != getClass());
    paramObject = (GeoPoint)paramObject;
    if ((((GeoPoint)paramObject).mLatitudeE6 == this.mLatitudeE6) && (((GeoPoint)paramObject).mLongitudeE6 == this.mLongitudeE6) && (((GeoPoint)paramObject).mAltitude == this.mAltitude)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int getAltitude()
  {
    return this.mAltitude;
  }
  
  public double getLatitude()
  {
    return this.mLatitudeE6 * 1.0E-6D;
  }
  
  public int getLatitudeE6()
  {
    return this.mLatitudeE6;
  }
  
  public double getLongitude()
  {
    return this.mLongitudeE6 * 1.0E-6D;
  }
  
  public int getLongitudeE6()
  {
    return this.mLongitudeE6;
  }
  
  public int hashCode()
  {
    return (this.mLatitudeE6 * 17 + this.mLongitudeE6) * 37 + this.mAltitude;
  }
  
  public void setAltitude(int paramInt)
  {
    this.mAltitude = paramInt;
  }
  
  public void setCoordsE6(int paramInt1, int paramInt2)
  {
    this.mLatitudeE6 = paramInt1;
    this.mLongitudeE6 = paramInt2;
  }
  
  public void setLatitudeE6(int paramInt)
  {
    this.mLatitudeE6 = paramInt;
  }
  
  public void setLongitudeE6(int paramInt)
  {
    this.mLongitudeE6 = paramInt;
  }
  
  public String toDoubleString()
  {
    return this.mLatitudeE6 / 1000000.0D + "," + this.mLongitudeE6 / 1000000.0D + "," + this.mAltitude;
  }
  
  public String toInvertedDoubleString()
  {
    return this.mLongitudeE6 / 1000000.0D + "," + this.mLatitudeE6 / 1000000.0D + "," + this.mAltitude;
  }
  
  public String toString()
  {
    return this.mLatitudeE6 + "," + this.mLongitudeE6 + "," + this.mAltitude;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mLatitudeE6);
    paramParcel.writeInt(this.mLongitudeE6);
    paramParcel.writeInt(this.mAltitude);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/util/GeoPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */