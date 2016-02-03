package mobi.beyondpod.services.player;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.TrackSorter;

public class FeedPlaylistTemplate
{
  public static List<Track> GeneratePlaylist(Feed paramFeed, int paramInt1, int paramInt2, int paramInt3, List<Track> paramList)
  {
    TrackList localTrackList = new TrackList();
    paramFeed = paramFeed.TracksAndSubTracks().iterator();
    for (;;)
    {
      if (!paramFeed.hasNext())
      {
        paramFeed = new TrackSorter();
        paramFeed.SortOrder = paramInt2;
        Collections.sort(localTrackList, paramFeed);
        paramFeed = localTrackList;
        if (paramInt1 > 0)
        {
          paramFeed = localTrackList;
          if (localTrackList.size() > paramInt1) {
            paramFeed = localTrackList.subList(0, paramInt1);
          }
        }
        return paramFeed;
      }
      Track localTrack = (Track)paramFeed.next();
      if ((localTrack.ContentType() != -1) || (((paramInt3 == -2) || (localTrack.ContentType() == paramInt3)) && (SmartPlaylistTemplate.CanIncludeInPlaylist(localTrack, paramList)))) {
        localTrackList.add(localTrack);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/FeedPlaylistTemplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */