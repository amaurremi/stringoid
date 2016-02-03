package mobi.beyondpod.ui.core;

import java.util.ArrayList;
import java.util.Iterator;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.helpers.MediaFile;
import mobi.beyondpod.rsscore.helpers.MediaFile.MediaFileType;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import mobi.beyondpod.services.player.PlayList;

public class FeedRssItemList
  extends ArrayList<RssFeedItem>
{
  private static final long serialVersionUID = 4912655395776997747L;
  Feed _Feed;
  
  public FeedRssItemList(Feed paramFeed)
  {
    this._Feed = paramFeed;
  }
  
  public boolean hasItemsThatCanBeAddedToPlaylist()
  {
    boolean bool = true;
    Object localObject = iterator();
    Track localTrack;
    label135:
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        bool = false;
      }
      int i;
      do
      {
        return bool;
        RssFeedItem localRssFeedItem = (RssFeedItem)((Iterator)localObject).next();
        if (localRssFeedItem.Enclosure() == null) {
          break;
        }
        localTrack = this._Feed.Tracks().GetTrackByNameOrUrl(localRssFeedItem.Enclosure().FileName(), localRssFeedItem.Enclosure().Url);
        if (localTrack != null) {
          break label135;
        }
        int j = MediaFile.getFileTypeForMimeType(localRssFeedItem.Enclosure().Type);
        i = j;
        if (j == 0)
        {
          localObject = MediaFile.getFileType(localRssFeedItem.Enclosure().FileName());
          i = j;
          if (localObject != null) {
            i = ((MediaFile.MediaFileType)localObject).fileType;
          }
        }
      } while ((Configuration.AllowEpisodeStreaming() != 2) && (!MediaFile.isImageFileType(i)));
      return false;
    } while (!BeyondPodApplication.GetInstance().PlayList().CanAddToPlaylist(localTrack));
    return true;
  }
  
  public boolean hasItemsThatCanBeDeleted()
  {
    Iterator localIterator = iterator();
    RssFeedItem localRssFeedItem;
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
      localRssFeedItem = (RssFeedItem)localIterator.next();
    } while ((localRssFeedItem.Enclosure() == null) || (this._Feed.Tracks().GetTrackByNameOrUrl(localRssFeedItem.Enclosure().FileName(), localRssFeedItem.Enclosure().Url) == null));
    return true;
  }
  
  public boolean hasItemsThatCanBeRemovedFromPlaylist()
  {
    Iterator localIterator = iterator();
    Object localObject;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          return false;
        }
        localObject = (RssFeedItem)localIterator.next();
      } while (((RssFeedItem)localObject).Enclosure() == null);
      localObject = this._Feed.Tracks().GetTrackByNameOrUrl(((RssFeedItem)localObject).Enclosure().FileName(), ((RssFeedItem)localObject).Enclosure().Url);
    } while ((localObject == null) || (!BeyondPodApplication.GetInstance().PlayList().HasTrack((Track)localObject)));
    return true;
  }
  
  public boolean hasNonMockOrNonReaderLockedItems()
  {
    Iterator localIterator = iterator();
    RssFeedItem localRssFeedItem;
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
      localRssFeedItem = (RssFeedItem)localIterator.next();
    } while ((localRssFeedItem.IsMockItem().booleanValue()) || ((!Configuration.IgnoreGoogleReaderReadStatus()) && (localRssFeedItem.IsGoogleReadLocked)));
    return true;
  }
  
  public boolean hasNotFullyDownloaded()
  {
    Iterator localIterator = iterator();
    Object localObject;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          return false;
        }
        localObject = (RssFeedItem)localIterator.next();
      } while (((RssFeedItem)localObject).Enclosure() == null);
      localObject = this._Feed.Tracks().GetTrackByNameOrUrl(((RssFeedItem)localObject).Enclosure().FileName(), ((RssFeedItem)localObject).Enclosure().Url);
    } while ((localObject != null) && (((Track)localObject).IsFullyDownloaded()));
    return true;
  }
  
  public boolean hasUnreadItems()
  {
    Iterator localIterator = iterator();
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
    } while (((RssFeedItem)localIterator.next()).getRead());
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/FeedRssItemList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */