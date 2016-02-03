package mobi.beyondpod.rsscore.events;

import java.util.EventListener;
import java.util.EventObject;

public class ApplicationEvents
{
  public static class ApplicationErrorEvent
    extends EventObject
  {
    public static final int EVENT_IntializationError = 2;
    public static final int EVENT_InvalidGoogleLogin = 1;
    public static final int EVENT_LocalTimeDrifted = 6;
    public static final int EVENT_PodcastDownloadSkipped_DeviceIsNotPluggedIn = 3;
    public static final int EVENT_PodcastDownloadSkipped_WiFiNotDetected = 4;
    public static final int EVENT_StorageCardCorrupted = 0;
    public static final int EVENT_UpdateAndDownload_Error = 5;
    public int Type;
    
    public ApplicationErrorEvent(Exception paramException, int paramInt)
    {
      super();
      this.Type = paramInt;
    }
    
    private String GetEventName()
    {
      switch (this.Type)
      {
      case 5: 
      default: 
        return "Unknown Event!";
      case 0: 
        return "Storage Card Corrupted";
      case 1: 
        return "Invalid Google Login";
      case 2: 
        return "Initialization Error";
      case 4: 
        return "PodcastDownloadSkipped_WiFiNotDetected";
      case 3: 
        return "PodcastDownloadSkipped_DeviceIsNotPluggedIn";
      }
      return "LocalTimeDrifted";
    }
    
    public String toString()
    {
      return String.format("ApplicationErrorEvent: %s", new Object[] { GetEventName() });
    }
  }
  
  public static abstract interface ApplicationErrorEventListener
    extends EventListener
  {
    public abstract void OnApplicationErrorEvent(ApplicationEvents.ApplicationErrorEvent paramApplicationErrorEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/events/ApplicationEvents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */