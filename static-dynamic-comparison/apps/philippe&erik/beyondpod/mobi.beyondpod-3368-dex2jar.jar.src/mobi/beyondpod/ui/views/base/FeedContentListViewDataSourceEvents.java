package mobi.beyondpod.ui.views.base;

import java.util.EventListener;
import java.util.EventObject;

public class FeedContentListViewDataSourceEvents
{
  public static class FeedContentListViewDataSourceEvent
    extends EventObject
  {
    public static int LOAD_COMPLETED = 1;
    public static int LOAD_STARTED = 0;
    public int Type;
    
    public FeedContentListViewDataSourceEvent(Object paramObject, int paramInt)
    {
      super();
      this.Type = paramInt;
    }
  }
  
  public static abstract interface FeedContentListViewDataSourceEventListener
    extends EventListener
  {
    public abstract void OnFeedContentListViewDataSourceEvent(FeedContentListViewDataSourceEvents.FeedContentListViewDataSourceEvent paramFeedContentListViewDataSourceEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/FeedContentListViewDataSourceEvents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */