package mobi.beyondpod.rsscore.repository;

import java.util.EventListener;
import java.util.EventObject;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;

public class RepositoryEvents
{
  public static class RepositoryEvent
    extends EventObject
  {
    public static final int EVENT_CategoryAdded = 12;
    public static final int EVENT_CategoryChanged = 14;
    public static final int EVENT_CategoryDeleted = 13;
    public static final int EVENT_FeedAdded = 6;
    public static final int EVENT_FeedChanged = 5;
    public static final int EVENT_FeedDeleted = 7;
    public static final int EVENT_ItemStatusChanged = 15;
    public static final int EVENT_LoadComplete = 2;
    public static final int EVENT_LoadingFeeds = 0;
    public static final int EVENT_RepositoryErrorOccurred = -1;
    public static final int EVENT_SaveComplete = 4;
    public static final int EVENT_SaveStarted = 3;
    public static final int EVENT_ScanningForChanges = 1;
    public static final int EVENT_TrackAdded = 8;
    public static final int EVENT_TrackBeforeDelete = 9;
    public static final int EVENT_TrackChanged = 11;
    public static final int EVENT_TrackDeleted = 10;
    public Feed Feed;
    public Exception LastException;
    public Track Track;
    public int Type;
    
    public RepositoryEvent(int paramInt)
    {
      super();
      this.Type = paramInt;
    }
    
    public RepositoryEvent(int paramInt, Feed paramFeed)
    {
      this(paramInt);
      this.Feed = paramFeed;
    }
    
    public RepositoryEvent(int paramInt, Track paramTrack)
    {
      this(paramInt);
      this.Track = paramTrack;
    }
    
    public static RepositoryEvent FromException(Exception paramException)
    {
      RepositoryEvent localRepositoryEvent = new RepositoryEvent(-1);
      localRepositoryEvent.LastException = paramException;
      return localRepositoryEvent;
    }
    
    private String GetEventName()
    {
      switch (this.Type)
      {
      default: 
        return "Unknown Event!";
      case -1: 
        return "RepositoryErrorOccurred";
      case 0: 
        return "LoadingFeeds";
      case 1: 
        return "ScanningForChanges";
      case 2: 
        return "LoadComplete";
      case 3: 
        return "SaveStarted";
      case 4: 
        return "SaveComplete";
      case 5: 
        return "FeedChanged";
      case 6: 
        return "FeedAdded";
      case 7: 
        return "FeedDeleted";
      case 8: 
        return "TrackAdded";
      case 9: 
        return "TrackBeforeDelete";
      case 10: 
        return "TrackDeleted";
      }
      return "TrackChanged";
    }
    
    public String toString()
    {
      String str4 = GetEventName();
      String str1;
      String str2;
      if (this.Feed != null)
      {
        str1 = this.Feed.getName();
        if (this.Track == null) {
          break label84;
        }
        str2 = this.Track.getName();
        label36:
        if (this.LastException == null) {
          break label90;
        }
      }
      label84:
      label90:
      for (String str3 = this.LastException.getMessage();; str3 = "")
      {
        return String.format("RepositoryEvent: %s - %s%s%s", new Object[] { str4, str1, str2, str3 });
        str1 = "";
        break;
        str2 = "";
        break label36;
      }
    }
  }
  
  public static abstract interface RepositoryEventListener
    extends EventListener
  {
    public abstract void OnRepositoryEvent(RepositoryEvents.RepositoryEvent paramRepositoryEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/repository/RepositoryEvents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */