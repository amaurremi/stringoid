package mobi.beyondpod.downloadengine;

import java.util.EventListener;
import java.util.EventObject;
import mobi.beyondpod.rsscore.Track;

public class UpdateAndDownloadEvents
{
  public static class UpdateAndDownloadEvent
    extends EventObject
  {
    public static int ENCLOSURE_DOWNLOAD_COMPLETED;
    public static int ENCLOSURE_DOWNLOAD_QUEUE_CHANGED = 4;
    public static int ENCLOSURE_DOWNLOAD_STARTED;
    public static int UPDATE_AND_DOWNLOAD_COMPLETED;
    public static int UPDATE_AND_DOWNLOAD_STARTED = 0;
    public Track Track;
    public int Type;
    
    static
    {
      UPDATE_AND_DOWNLOAD_COMPLETED = 1;
      ENCLOSURE_DOWNLOAD_COMPLETED = 2;
      ENCLOSURE_DOWNLOAD_STARTED = 3;
    }
    
    public UpdateAndDownloadEvent(Object paramObject, int paramInt)
    {
      super();
      this.Type = paramInt;
    }
    
    public UpdateAndDownloadEvent(Object paramObject, int paramInt, Track paramTrack)
    {
      this(paramObject, paramInt);
      this.Track = paramTrack;
    }
  }
  
  public static abstract interface UpdateAndDownloadEventListener
    extends EventListener
  {
    public abstract void OnUpdateAndDownloadEvent(UpdateAndDownloadEvents.UpdateAndDownloadEvent paramUpdateAndDownloadEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/downloadengine/UpdateAndDownloadEvents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */