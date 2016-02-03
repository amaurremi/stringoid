package mobi.beyondpod.ui.views.events;

import java.util.EventListener;
import java.util.EventObject;
import mobi.beyondpod.rsscore.categories.FeedCategory;

public class CategoryEvents
{
  public static abstract interface CategoryEventListener
    extends EventListener
  {
    public abstract void OnCategorySelectedEvent(CategoryEvents.CategorySelectedEvent paramCategorySelectedEvent);
  }
  
  public static class CategorySelectedEvent
    extends EventObject
  {
    public FeedCategory Category;
    
    public CategorySelectedEvent(Object paramObject, FeedCategory paramFeedCategory)
    {
      super();
      this.Category = paramFeedCategory;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/events/CategoryEvents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */