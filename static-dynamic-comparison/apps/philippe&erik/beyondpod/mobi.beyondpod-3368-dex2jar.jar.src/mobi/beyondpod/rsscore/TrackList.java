package mobi.beyondpod.rsscore;

import java.util.ArrayList;
import java.util.Iterator;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class TrackList
  extends ArrayList<Track>
{
  private static final long serialVersionUID = 5658483572878679944L;
  
  public Track GetFirstUnplayedOrPartiallyPlayedTrack()
  {
    Iterator localIterator;
    if (size() > 0) {
      localIterator = iterator();
    }
    Track localTrack;
    do
    {
      Object localObject;
      if (!localIterator.hasNext()) {
        localObject = null;
      }
      do
      {
        return (Track)localObject;
        localTrack = (Track)localIterator.next();
        localObject = localTrack;
      } while (localTrack.IsNew());
    } while (!localTrack.IsPartialyPlayed());
    return localTrack;
  }
  
  public Track GetTrackByNameOrUrl(String paramString1, String paramString2)
  {
    Iterator localIterator;
    if (size() > 0) {
      localIterator = iterator();
    }
    Track localTrack;
    do
    {
      Object localObject;
      if (!localIterator.hasNext()) {
        localObject = null;
      }
      do
      {
        return (Track)localObject;
        localTrack = (Track)localIterator.next();
        localObject = localTrack;
      } while (localTrack.TrackPath().endsWith(paramString1));
    } while ((StringUtils.IsNullOrEmpty(paramString2)) || (!StringUtils.EqualsIgnoreCase(localTrack.getUrl(), paramString2)));
    return localTrack;
  }
  
  public Track GetTrackByPath(String paramString)
  {
    Iterator localIterator;
    if (size() > 0) {
      localIterator = iterator();
    }
    Track localTrack;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localTrack = (Track)localIterator.next();
    } while (!StringUtils.EqualsIgnoreCase(localTrack.TrackPath(), paramString));
    return localTrack;
  }
  
  public boolean HasNotDownloaded()
  {
    Iterator localIterator = iterator();
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
    } while (((Track)localIterator.next()).IsFullyDownloaded());
    return true;
  }
  
  public boolean HasUnLocked()
  {
    Iterator localIterator = iterator();
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
    } while (!((Track)localIterator.next()).AllowAutoDelete());
    return true;
  }
  
  public boolean HasUnPlayed()
  {
    Iterator localIterator = iterator();
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
    } while (((Track)localIterator.next()).IsPlayed());
    return true;
  }
  
  public int getLocalTrackCount()
  {
    int i = 0;
    int j = 0;
    Iterator localIterator;
    if (size() > 0)
    {
      localIterator = iterator();
      i = j;
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return i;
      }
      if (((Track)localIterator.next()).Exists()) {
        i += 1;
      }
    }
  }
  
  public int getUnplayedTrackCount()
  {
    int i = 0;
    Iterator localIterator = iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return i;
      }
      if (((Track)localIterator.next()).IsNew()) {
        i += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/TrackList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */