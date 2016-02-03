package mobi.beyondpod.ui.core.volley;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader.ImageCache;

public class ImageLoader
  extends com.android.volley.toolbox.ImageLoader
{
  public ImageLoader(RequestQueue paramRequestQueue, ImageLoader.ImageCache paramImageCache)
  {
    super(paramRequestQueue, paramImageCache);
    init();
  }
  
  public RequestQueue getRequestQueue()
  {
    return this.mRequestQueue;
  }
  
  protected void init()
  {
    VolleyLog.setTag("BeyondPod");
  }
  
  public void release()
  {
    this.mRequestQueue.stop();
  }
  
  public static abstract interface ImageLoaderProvider
  {
    public abstract ImageLoader getImageLoaderInstance();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/volley/ImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */