package mobi.beyondpod.ui.core.volley;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.HurlStack;
import java.io.File;

public class ImageLoaderFeedSearch
  extends ImageLoader
{
  private static final String DEFAULT_CACHE_DIR = "img";
  private static final int DEFAULT_DISK_USAGE_BYTES = 2097152;
  
  public ImageLoaderFeedSearch(FragmentActivity paramFragmentActivity)
  {
    super(newRequestQueue(paramFragmentActivity), BitmapCache.getInstance(paramFragmentActivity.getSupportFragmentManager()));
  }
  
  public static RequestQueue newRequestQueue(Context paramContext)
  {
    new File(paramContext.getCacheDir(), "img");
    String str1 = "BeyondPod/0";
    try
    {
      String str2 = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str2, 0);
      paramContext = str2 + "/" + paramContext.versionCode;
      if (Build.VERSION.SDK_INT >= 9) {}
      for (paramContext = new HurlStack();; paramContext = new HttpClientStack(AndroidHttpClient.newInstance(paramContext)))
      {
        paramContext = new RequestQueue(new DiskBasedCacheNoCache(), new BasicNetwork(paramContext));
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/volley/ImageLoaderFeedSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */