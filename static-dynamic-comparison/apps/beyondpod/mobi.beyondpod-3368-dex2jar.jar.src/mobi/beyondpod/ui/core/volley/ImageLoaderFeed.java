package mobi.beyondpod.ui.core.volley;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v4.app.FragmentActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader.BatchedImageRequest;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import java.util.HashMap;
import mobi.beyondpod.rsscore.Feed;

public class ImageLoaderFeed
  extends ImageLoader
{
  private static final String TAG = ImageLoaderFeed.class.getSimpleName();
  
  public ImageLoaderFeed(FragmentActivity paramFragmentActivity)
  {
    super(newRequestQueue(paramFragmentActivity), BitmapCache.getInstance(paramFragmentActivity.getSupportFragmentManager()));
    setBatchedResponseDelay(0);
  }
  
  public static RequestQueue newRequestQueue(Context paramContext)
  {
    paramContext = new RequestQueue(new DiskBasedCacheNoOp(), new NetworkNoOp());
    paramContext.start();
    return paramContext;
  }
  
  public ImageLoader.ImageContainer get(String paramString, Feed paramFeed, ImageLoader.ImageListener paramImageListener, int paramInt1, int paramInt2)
  {
    throwIfNotOnMainThread();
    final String str = getCacheKey(paramString, paramInt1, paramInt2);
    Object localObject = this.mCache.getBitmap(str);
    if (localObject != null)
    {
      paramString = new ImageLoader.ImageContainer(this, (Bitmap)localObject, paramString, null, null);
      paramImageListener.onResponse(paramString, true);
      return paramString;
    }
    localObject = new ImageLoader.ImageContainer(this, null, paramString, str, paramImageListener);
    paramImageListener.onResponse((ImageLoader.ImageContainer)localObject, true);
    paramImageListener = (ImageLoader.BatchedImageRequest)this.mInFlightRequests.get(str);
    if (paramImageListener != null)
    {
      paramImageListener.addContainer((ImageLoader.ImageContainer)localObject);
      return (ImageLoader.ImageContainer)localObject;
    }
    paramString = new ImageRequestFeed(paramString, new Response.Listener()
    {
      public void onResponse(Bitmap paramAnonymousBitmap)
      {
        ImageLoaderFeed.this.onGetImageSuccess(str, paramAnonymousBitmap);
      }
    }, paramInt1, paramInt2, Bitmap.Config.RGB_565, new Response.ErrorListener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError)
      {
        ImageLoaderFeed.this.onGetImageError(str, paramAnonymousVolleyError);
      }
    }, paramFeed);
    paramString.setShouldCache(false);
    this.mRequestQueue.add(paramString);
    this.mInFlightRequests.put(str, new ImageLoader.BatchedImageRequest(this, paramString, (ImageLoader.ImageContainer)localObject));
    return (ImageLoader.ImageContainer)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/volley/ImageLoaderFeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */