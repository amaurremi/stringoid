package org.osmdroid.contributor;

import android.location.Location;
import java.util.ArrayList;
import org.osmdroid.contributor.util.RecordedGeoPoint;
import org.osmdroid.util.GeoPoint;

public class RouteRecorder
{
  protected final ArrayList<RecordedGeoPoint> mRecords = new ArrayList();
  
  public void add(Location paramLocation, int paramInt)
  {
    this.mRecords.add(new RecordedGeoPoint((int)(paramLocation.getLatitude() * 1000000.0D), (int)(paramLocation.getLongitude() * 1000000.0D), System.currentTimeMillis(), paramInt));
  }
  
  public void add(GeoPoint paramGeoPoint, int paramInt)
  {
    this.mRecords.add(new RecordedGeoPoint(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6(), System.currentTimeMillis(), paramInt));
  }
  
  public ArrayList<RecordedGeoPoint> getRecordedGeoPoints()
  {
    return this.mRecords;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/contributor/RouteRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */