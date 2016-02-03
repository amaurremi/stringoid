package org.osmdroid.contributor.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import org.osmdroid.contributor.util.constants.OpenStreetMapContributorConstants;
import org.osmdroid.util.BoundingBoxE6;

public class Util
  implements OpenStreetMapContributorConstants
{
  public static final SimpleDateFormat UTCSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
  
  private Util()
  {
    UTCSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
  }
  
  public static final String convertTimestampToUTCString(long paramLong)
  {
    return UTCSimpleDateFormat.format(new Date(paramLong));
  }
  
  public static boolean isSufficienDataForUpload(ArrayList<RecordedGeoPoint> paramArrayList)
  {
    if (paramArrayList == null) {}
    while ((paramArrayList.size() < 100) || (BoundingBoxE6.fromGeoPoints(paramArrayList).getDiagonalLengthInMeters() < 300)) {
      return false;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/contributor/util/Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */