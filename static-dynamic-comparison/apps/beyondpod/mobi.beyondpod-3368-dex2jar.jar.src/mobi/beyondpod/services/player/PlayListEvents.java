package mobi.beyondpod.services.player;

import java.util.EventListener;
import java.util.EventObject;

public class PlayListEvents
{
  public static class PlayListEvent
    extends EventObject
  {
    public static final int EVENT_CurrentTrackChanged = 1;
    public static final int EVENT_EndOfPlayList = 3;
    public static final int EVENT_PlaylistChanged = 0;
    public static final int EVENT_PlaystateChanged = 2;
    public int Type;
    
    public PlayListEvent(PlayList paramPlayList, int paramInt)
    {
      super();
      this.Type = paramInt;
    }
    
    private String GetEventName()
    {
      switch (this.Type)
      {
      default: 
        return "Unknown Event!";
      case 0: 
        return "Playlist Changed";
      case 1: 
        return "Current Track Changed";
      case 2: 
        return "Playstate Changed";
      }
      return "EndOfPlayList";
    }
    
    public String toString()
    {
      return String.format("PlayListEvent: %s", new Object[] { GetEventName() });
    }
  }
  
  public static abstract interface PlayListEventListener
    extends EventListener
  {
    public abstract void OnPlayListEvent(PlayListEvents.PlayListEvent paramPlayListEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/PlayListEvents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */