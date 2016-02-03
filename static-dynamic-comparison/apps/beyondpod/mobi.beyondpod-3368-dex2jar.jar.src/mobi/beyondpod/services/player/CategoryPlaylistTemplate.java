package mobi.beyondpod.services.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackSorter;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.repository.FeedRepository;

public class CategoryPlaylistTemplate
{
  public static List<Track> GeneratePlaylist(FeedCategory paramFeedCategory, int paramInt1, int paramInt2, int paramInt3, List<Track> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = FeedRepository.GetAllTracks().iterator();
    if (!localIterator.hasNext()) {
      if (localArrayList.size() > 0)
      {
        if (paramInt2 != 100) {
          break label156;
        }
        Collections.shuffle(localArrayList, new Random(System.nanoTime()));
      }
    }
    for (;;)
    {
      paramFeedCategory = localArrayList;
      if (paramInt1 > 0)
      {
        paramFeedCategory = localArrayList;
        if (localArrayList.size() > paramInt1) {
          paramFeedCategory = localArrayList.subList(0, paramInt1);
        }
      }
      return paramFeedCategory;
      Track localTrack = (Track)localIterator.next();
      if ((localTrack.ContentType() == -1) && (((paramInt3 != -2) && (localTrack.ContentType() != paramInt3)) || (!CategoryManager.IsInCategory(localTrack.getParentFeed(), paramFeedCategory)) || (!SmartPlaylistTemplate.CanIncludeInPlaylist(localTrack, paramList)))) {
        break;
      }
      localArrayList.add(localTrack);
      break;
      label156:
      Collections.sort(localArrayList, new TrackSorter(paramInt2));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/CategoryPlaylistTemplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */