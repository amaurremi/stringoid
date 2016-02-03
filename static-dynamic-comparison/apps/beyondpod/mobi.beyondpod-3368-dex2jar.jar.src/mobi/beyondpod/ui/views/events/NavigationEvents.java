package mobi.beyondpod.ui.views.events;

import java.util.EventListener;
import java.util.EventObject;

public class NavigationEvents
{
  public static class NavigationEvent
    extends EventObject
  {
    public static int NAVIGATE_BACK = 1;
    public static int NAVIGATE_FORWARD = 0;
    public int Direction;
    
    public NavigationEvent(Object paramObject, int paramInt)
    {
      super();
      this.Direction = paramInt;
    }
  }
  
  public static abstract interface NavigationEventListener
    extends EventListener
  {
    public abstract void OnNavigationEvent(NavigationEvents.NavigationEvent paramNavigationEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/events/NavigationEvents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */