package org.osmdroid.events;

import android.os.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DelayedMapListener
  implements MapListener
{
  protected static final int DEFAULT_DELAY = 100;
  private static final Logger logger = LoggerFactory.getLogger(DelayedMapListener.class);
  protected CallbackTask callback;
  protected long delay;
  protected Handler handler;
  MapListener wrappedListener;
  
  public DelayedMapListener(MapListener paramMapListener)
  {
    this(paramMapListener, 100L);
  }
  
  public DelayedMapListener(MapListener paramMapListener, long paramLong)
  {
    this.wrappedListener = paramMapListener;
    this.delay = paramLong;
    this.handler = new Handler();
    this.callback = null;
  }
  
  protected void dispatch(MapEvent paramMapEvent)
  {
    if (this.callback != null) {
      this.handler.removeCallbacks(this.callback);
    }
    this.callback = new CallbackTask(paramMapEvent);
    this.handler.postDelayed(this.callback, this.delay);
  }
  
  public boolean onScroll(ScrollEvent paramScrollEvent)
  {
    dispatch(paramScrollEvent);
    return true;
  }
  
  public boolean onZoom(ZoomEvent paramZoomEvent)
  {
    dispatch(paramZoomEvent);
    return true;
  }
  
  private class CallbackTask
    implements Runnable
  {
    private final MapEvent event;
    
    public CallbackTask(MapEvent paramMapEvent)
    {
      this.event = paramMapEvent;
    }
    
    public void run()
    {
      if ((this.event instanceof ScrollEvent))
      {
        DelayedMapListener.this.wrappedListener.onScroll((ScrollEvent)this.event);
        return;
      }
      if ((this.event instanceof ZoomEvent))
      {
        DelayedMapListener.this.wrappedListener.onZoom((ZoomEvent)this.event);
        return;
      }
      DelayedMapListener.logger.debug("Unknown event received: " + this.event);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/events/DelayedMapListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */