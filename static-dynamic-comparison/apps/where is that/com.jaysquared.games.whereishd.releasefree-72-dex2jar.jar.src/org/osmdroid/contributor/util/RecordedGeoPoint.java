package org.osmdroid.contributor.util;

import org.osmdroid.contributor.util.constants.OpenStreetMapContributorConstants;
import org.osmdroid.util.GeoPoint;

public class RecordedGeoPoint
  extends GeoPoint
  implements OpenStreetMapContributorConstants
{
  private static final long serialVersionUID = 7304941424576720318L;
  protected final int mNumSatellites;
  protected final long mTimeStamp;
  
  public RecordedGeoPoint(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, System.currentTimeMillis(), Integer.MIN_VALUE);
  }
  
  public RecordedGeoPoint(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    super(paramInt1, paramInt2);
    this.mTimeStamp = paramLong;
    this.mNumSatellites = paramInt3;
  }
  
  public double getLatitudeAsDouble()
  {
    return getLatitudeE6() / 1000000.0D;
  }
  
  public double getLongitudeAsDouble()
  {
    return getLongitudeE6() / 1000000.0D;
  }
  
  public int getNumSatellites()
  {
    return this.mNumSatellites;
  }
  
  public long getTimeStamp()
  {
    return this.mTimeStamp;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/contributor/util/RecordedGeoPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */