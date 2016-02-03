package mobi.beyondpod.ui.core;

import java.util.EventListener;
import java.util.EventObject;

public class ImageCacheEvents
{
  public static class ImageCacheEvent
    extends EventObject
  {
    public static final int EVENT_FeedImageCacheCleared = 1;
    public static final int EVENT_TrackImageCacheCleared = 0;
    public int Type;
    
    public ImageCacheEvent(int paramInt)
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
      }
      return "Track Image Cache Cleared";
    }
    
    public String toString()
    {
      return String.format("ImageCacheEvent: %s", new Object[] { GetEventName() });
    }
  }
  
  public static abstract interface ImageCacheEventListener
    extends EventListener
  {
    public abstract void OnImageCacheEvent(ImageCacheEvents.ImageCacheEvent paramImageCacheEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/ImageCacheEvents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */