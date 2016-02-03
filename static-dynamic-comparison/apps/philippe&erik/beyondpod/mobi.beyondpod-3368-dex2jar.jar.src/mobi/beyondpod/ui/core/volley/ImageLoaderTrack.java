package mobi.beyondpod.ui.core.volley;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader.BatchedImageRequest;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import java.util.HashMap;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;

public class ImageLoaderTrack
  extends ImageLoader
{
  private static final int DEFAULT_DISK_USAGE_BYTES = 52428800;
  
  public ImageLoaderTrack(FragmentActivity paramFragmentActivity)
  {
    super(newRequestQueue(paramFragmentActivity), BitmapCache.getInstance(paramFragmentActivity.getSupportFragmentManager()));
  }
  
  public static RequestQueue newRequestQueue(Context paramContext)
  {
    String str1 = "BeyondPod/0";
    try
    {
      String str2 = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str2, 0);
      paramContext = str2 + "/" + paramContext.versionCode;
      if (Build.VERSION.SDK_INT >= 9) {}
      for (paramContext = new HurlStack();; paramContext = new HttpClientStack(AndroidHttpClient.newInstance(paramContext)))
      {
        paramContext = new RequestQueue(new DiskBasedCacheBP(52428800), new NetworkTrack(paramContext));
        paramContext.start();
        return paramContext;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = str1;
      }
    }
  }
  
  public ImageLoader.ImageContainer get(String paramString, Track paramTrack, Feed paramFeed, ImageLoader.ImageListener paramImageListener, int paramInt1, int paramInt2)
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
    paramTrack = new ImageRequestTrack(paramString, new Response.Listener()
    {
      public void onResponse(Bitmap paramAnonymousBitmap)
      {
        ImageLoaderTrack.this.onGetImageSuccess(str, paramAnonymousBitmap);
      }
    }, paramInt1, paramInt2, Bitmap.Config.RGB_565, new Response.ErrorListener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError)
      {
        ImageLoaderTrack.this.onGetImageError(str, paramAnonymousVolleyError);
      }
    }, paramTrack, paramFeed);
    paramTrack.setShouldCache(paramString.startsWith("episode://"));
    this.mRequestQueue.add(paramTrack);
    this.mInFlightRequests.put(str, new ImageLoader.BatchedImageRequest(this, paramTrack, (ImageLoader.ImageContainer)localObject));
    return (ImageLoader.ImageContainer)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/volley/ImageLoaderTrack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */