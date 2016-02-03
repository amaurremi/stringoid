package mobi.beyondpod.rsscore.repository;

import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.schedulercore.ScheduledTask;

public abstract interface IRepositoryStorage
{
  public abstract void DeleteFeed(Feed paramFeed);
  
  public abstract void DeleteRepositoryFiles();
  
  public abstract void DeleteTask(ScheduledTask paramScheduledTask);
  
  public abstract void DeleteTrack(Track paramTrack);
  
  public abstract void DeleteTracks(TrackList paramTrackList);
  
  public abstract void LoadRepository();
  
  public abstract void SaveRepository();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/repository/IRepositoryStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */