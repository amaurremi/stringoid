package org.osmdroid.contributor.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import org.osmdroid.contributor.util.constants.OpenStreetMapContributorConstants;

public class RecordedRouteGPXFormatter
  implements OpenStreetMapContributorConstants
{
  private static final String GPX_TAG = "<gpx version=\"1.1\" creator=\"%s\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://www.topografix.com/GPX/1/1\" xsi:schemaLocation=\"http://www.topografix.com/GPX/1/1 http://www.topografix.com/GPX/1/1/gpx.xsd\">";
  private static final String GPX_TAG_CLOSE = "</gpx>";
  private static final String GPX_TAG_TIME = "<time>%s</time>";
  private static final String GPX_TAG_TRACK = "<trk>";
  private static final String GPX_TAG_TRACK_CLOSE = "</trk>";
  private static final String GPX_TAG_TRACK_NAME = "<name>%s</name>";
  private static final String GPX_TAG_TRACK_SEGMENT = "<trkseg>";
  private static final String GPX_TAG_TRACK_SEGMENT_CLOSE = "</trkseg>";
  public static final String GPX_TAG_TRACK_SEGMENT_POINT = "<trkpt lat=\"%f\" lon=\"%f\">";
  public static final String GPX_TAG_TRACK_SEGMENT_POINT_CLOSE = "</trkpt>";
  public static final String GPX_TAG_TRACK_SEGMENT_POINT_ELE = "<ele>%d</ele>";
  public static final String GPX_TAG_TRACK_SEGMENT_POINT_SAT = "<sat>%d</sat>";
  public static final String GPX_TAG_TRACK_SEGMENT_POINT_TIME = "<time>%s</time>";
  private static final String GPX_VERSION = "1.1";
  private static final String XML_VERSION = "<?xml version=\"1.0\"?>";
  private static final SimpleDateFormat formatterCompleteDateTime = new SimpleDateFormat("yyyyMMdd'_'HHmmss");
  
  public static String create(List<RecordedGeoPoint> paramList)
    throws IllegalArgumentException
  {
    if (paramList == null) {
      throw new IllegalArgumentException("Records may not be null.");
    }
    if (paramList.size() == 0) {
      throw new IllegalArgumentException("Records size == 0");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Formatter localFormatter = new Formatter(localStringBuilder);
    localStringBuilder.append("<?xml version=\"1.0\"?>");
    localFormatter.format("<gpx version=\"1.1\" creator=\"%s\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://www.topografix.com/GPX/1/1\" xsi:schemaLocation=\"http://www.topografix.com/GPX/1/1 http://www.topografix.com/GPX/1/1/gpx.xsd\">", new Object[] { "AndNav - http://www.andnav.org - Android Navigation System" });
    localFormatter.format("<time>%s</time>", new Object[] { Util.convertTimestampToUTCString(System.currentTimeMillis()) });
    localStringBuilder.append("<trk>");
    localFormatter.format("<name>%s</name>", new Object[] { "PUT_YOUR_USERNAME_HERE--" + formatterCompleteDateTime.format(Long.valueOf(new Date(((RecordedGeoPoint)paramList.get(0)).getTimeStamp()).getTime())) + "-" + formatterCompleteDateTime.format(Long.valueOf(new Date(((RecordedGeoPoint)paramList.get(paramList.size() - 1)).getTimeStamp()).getTime())) });
    localStringBuilder.append("<trkseg>");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecordedGeoPoint localRecordedGeoPoint = (RecordedGeoPoint)paramList.next();
      localFormatter.format("<trkpt lat=\"%f\" lon=\"%f\">", new Object[] { Double.valueOf(localRecordedGeoPoint.getLatitudeAsDouble()), Double.valueOf(localRecordedGeoPoint.getLongitudeAsDouble()) });
      localFormatter.format("<time>%s</time>", new Object[] { Util.convertTimestampToUTCString(localRecordedGeoPoint.getTimeStamp()) });
      if (localRecordedGeoPoint.mNumSatellites != Integer.MIN_VALUE) {
        localFormatter.format("<sat>%d</sat>", new Object[] { Integer.valueOf(localRecordedGeoPoint.mNumSatellites) });
      }
      localStringBuilder.append("</trkpt>");
    }
    localStringBuilder.append("</trkseg>").append("</trk>").append("</gpx>");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/contributor/util/RecordedRouteGPXFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */