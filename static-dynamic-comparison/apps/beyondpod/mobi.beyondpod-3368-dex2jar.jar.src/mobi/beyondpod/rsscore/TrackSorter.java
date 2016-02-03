package mobi.beyondpod.rsscore;

import java.util.Comparator;
import java.util.Date;

public class TrackSorter
  implements Comparator<Track>
{
  public int SortOrder = 0;
  
  public TrackSorter() {}
  
  public TrackSorter(int paramInt)
  {
    this.SortOrder = paramInt;
  }
  
  public int compare(Track paramTrack1, Track paramTrack2)
  {
    if (paramTrack1.equals(paramTrack2)) {
      return 0;
    }
    Date localDate1 = paramTrack1.getLastModifiedDate();
    Date localDate2 = paramTrack2.getLastModifiedDate();
    String str1 = paramTrack1.DisplayName();
    String str2 = paramTrack2.DisplayName();
    String str3 = paramTrack1.TrackPath();
    String str4 = paramTrack2.TrackPath();
    Long localLong1 = Long.valueOf(paramTrack1.getSizeOnDisk());
    Long localLong2 = Long.valueOf(paramTrack2.getSizeOnDisk());
    long l1;
    long l2;
    switch (this.SortOrder)
    {
    default: 
      return -1;
    case 2: 
      if ((localDate1 == null) && (localDate2 == null)) {
        return 0;
      }
      if ((localDate1 != null) && (localDate2 == null)) {
        return 1;
      }
      if ((localDate1 == null) && (localDate2 != null)) {
        return -1;
      }
      return localDate1.compareTo(localDate2);
    case 3: 
      if ((localDate1 == null) && (localDate2 == null)) {
        return 0;
      }
      if ((localDate2 != null) && (localDate1 == null)) {
        return 1;
      }
      if ((localDate2 == null) && (localDate1 != null)) {
        return -1;
      }
      return localDate2.compareTo(localDate1);
    case 0: 
      if ((str1 == null) && (str2 == null)) {
        return 0;
      }
      if ((str1 != null) && (str2 == null)) {
        return 1;
      }
      if ((str1 == null) && (str2 != null)) {
        return -1;
      }
      return str1.compareToIgnoreCase(str2);
    case 1: 
      if ((str1 == null) && (str2 == null)) {
        return 0;
      }
      if ((str2 != null) && (str1 == null)) {
        return 1;
      }
      if ((str2 == null) && (str1 != null)) {
        return -1;
      }
      return str2.compareToIgnoreCase(str1);
    case 4: 
      if (paramTrack1.getTotalTime() > 0L)
      {
        l1 = paramTrack1.getTotalTime();
        if (paramTrack2.getTotalTime() <= 0L) {
          break label354;
        }
      }
      for (l2 = paramTrack2.getTotalTime();; l2 = 2147483647L)
      {
        if (l2 != l1) {
          break label362;
        }
        return 0;
        l1 = 2147483647L;
        break;
      }
      if (l1 > l2) {
        return 1;
      }
      return -1;
    case 5: 
      if (paramTrack1.getTotalTime() > 0L)
      {
        l1 = paramTrack1.getTotalTime();
        if (paramTrack2.getTotalTime() <= 0L) {
          break label422;
        }
      }
      for (l2 = paramTrack2.getTotalTime();; l2 = -2147483648L)
      {
        if (l2 != l1) {
          break label430;
        }
        return 0;
        l1 = -2147483648L;
        break;
      }
      if (l2 > l1) {
        return 1;
      }
      return -1;
    case 6: 
      float f1 = paramTrack1.PlayedAsFraction();
      float f3 = paramTrack2.PlayedAsFraction();
      float f2;
      if (f1 == 0.0F)
      {
        f2 = 1.01F;
        if (f3 != 0.0F) {
          break label514;
        }
        f1 = 1.01F;
        if (paramTrack1.getTotalTime() <= 0L) {
          break label530;
        }
        if (paramTrack2.getTotalTime() <= 0L) {
          break label551;
        }
      }
      for (;;)
      {
        return Float.compare(f2, f1);
        f2 = f1;
        if (f1 != 1.0F) {
          break;
        }
        f2 = 1.1F;
        break;
        f1 = f3;
        if (f3 != 1.0F) {
          break label473;
        }
        f1 = 1.1F;
        break label473;
        if (paramTrack1.IsPlayed())
        {
          f2 = Float.MAX_VALUE;
          break label482;
        }
        f2 = 1.02F;
        break label482;
        if (paramTrack2.IsPlayed()) {
          f1 = Float.MAX_VALUE;
        } else {
          f1 = 1.02F;
        }
      }
    case 7: 
      int j = paramTrack1.ContentType();
      int k = paramTrack2.ContentType();
      int i;
      if (j != 0)
      {
        i = j;
        if (j != -1) {}
      }
      else
      {
        i = Integer.MAX_VALUE;
      }
      if (k != 0)
      {
        j = k;
        if (k != -1) {}
      }
      else
      {
        j = Integer.MAX_VALUE;
      }
      if (j == i) {
        return 0;
      }
      if (i > j) {
        return 1;
      }
      return -1;
    case 8: 
      if ((str3 == null) && (str4 == null)) {
        return 0;
      }
      if ((str3 != null) && (str4 == null)) {
        return 1;
      }
      if ((str3 == null) && (str4 != null)) {
        return -1;
      }
      return str3.compareToIgnoreCase(str4);
    case 9: 
      label354:
      label362:
      label422:
      label430:
      label473:
      label482:
      label514:
      label530:
      label551:
      if ((str3 == null) && (str4 == null)) {
        return 0;
      }
      if ((str4 != null) && (str3 == null)) {
        return 1;
      }
      if ((str4 == null) && (str3 != null)) {
        return -1;
      }
      return str4.compareToIgnoreCase(str3);
    }
    if ((localLong1 == null) && (localLong2 == null)) {
      return 0;
    }
    if ((localLong2 != null) && (localLong1 == null)) {
      return 1;
    }
    if ((localLong2 == null) && (localLong1 != null)) {
      return -1;
    }
    return localLong2.compareTo(localLong1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/TrackSorter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */