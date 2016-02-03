package mobi.beyondpod.rsscore.rss;

import java.util.Comparator;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackSorter;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;

public class LocalEnclosureSorter
  implements Comparator<RssFeedItem>
{
  private TrackSorter _Sorter;
  
  public LocalEnclosureSorter(int paramInt)
  {
    this._Sorter = new TrackSorter(paramInt);
  }
  
  public int compare(RssFeedItem paramRssFeedItem1, RssFeedItem paramRssFeedItem2)
  {
    if (paramRssFeedItem1.equals(paramRssFeedItem2)) {}
    Track localTrack;
    do
    {
      return 0;
      localTrack = null;
      Object localObject = null;
      if (paramRssFeedItem1.Enclosure() != null) {
        localTrack = paramRssFeedItem1.Enclosure().GetLocalEnclosureTrack();
      }
      paramRssFeedItem1 = (RssFeedItem)localObject;
      if (paramRssFeedItem2.Enclosure() != null) {
        paramRssFeedItem1 = paramRssFeedItem2.Enclosure().GetLocalEnclosureTrack();
      }
      if ((localTrack != null) && (paramRssFeedItem1 != null)) {
        return this._Sorter.compare(localTrack, paramRssFeedItem1);
      }
    } while ((localTrack == null) && (paramRssFeedItem1 == null));
    if (localTrack != null) {
      return 1;
    }
    return -1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/LocalEnclosureSorter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */