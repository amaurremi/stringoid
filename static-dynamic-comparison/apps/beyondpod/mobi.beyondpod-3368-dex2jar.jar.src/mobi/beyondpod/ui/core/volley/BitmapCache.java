package mobi.beyondpod.ui.core.volley;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.LruCache;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class BitmapCache
  implements ImageLoader.ImageCache
{
  private static final float DEFAULT_MEM_CACHE_PERCENT = 0.15F;
  private static final String TAG = "BitmapCache";
  private static int _InstanceCount = 0;
  private LruCache<String, Bitmap> mMemoryCache;
  
  private BitmapCache(int paramInt)
  {
    init(paramInt);
    _InstanceCount += 1;
    CoreHelper.WriteTraceEntryInDebug("BitmapCache", "Bitmap Memory Cache created (size = " + paramInt + "KB). Instances: " + _InstanceCount);
  }
  
  public static int calculateMemCacheSize(float paramFloat)
  {
    if ((paramFloat < 0.05F) || (paramFloat > 0.8F)) {
      throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)");
    }
    return Math.round((float)Runtime.getRuntime().maxMemory() * paramFloat / 1024.0F);
  }
  
  @TargetApi(12)
  public static int getBitmapSize(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public static BitmapCache getInstance(FragmentManager paramFragmentManager)
  {
    return getInstance(paramFragmentManager, 0.15F);
  }
  
  public static BitmapCache getInstance(FragmentManager paramFragmentManager, float paramFloat)
  {
    return getInstance(paramFragmentManager, calculateMemCacheSize(paramFloat));
  }
  
  public static BitmapCache getInstance(FragmentManager paramFragmentManager, int paramInt)
  {
    return getInstance(paramFragmentManager, "BeyondPod.BitmapCache", paramInt);
  }
  
  public static BitmapCache getInstance(FragmentManager paramFragmentManager, String paramString, int paramInt)
  {
    BitmapCache localBitmapCache = null;
    RetainFragment localRetainFragment = null;
    if (paramFragmentManager != null)
    {
      localRetainFragment = getRetainFragment(paramFragmentManager, paramString);
      localBitmapCache = (BitmapCache)localRetainFragment.getObject();
    }
    paramFragmentManager = localBitmapCache;
    if (localBitmapCache == null)
    {
      paramString = new BitmapCache(paramInt);
      paramFragmentManager = paramString;
      if (localRetainFragment != null)
      {
        localRetainFragment.setObject(paramString);
        paramFragmentManager = paramString;
      }
    }
    return paramFragmentManager;
  }
  
  private static RetainFragment getRetainFragment(FragmentManager paramFragmentManager, String paramString)
  {
    RetainFragment localRetainFragment2 = (RetainFragment)paramFragmentManager.findFragmentByTag(paramString);
    RetainFragment localRetainFragment1 = localRetainFragment2;
    if (localRetainFragment2 == null)
    {
      localRetainFragment1 = new RetainFragment();
      paramFragmentManager.beginTransaction().add(localRetainFragment1, paramString).commitAllowingStateLoss();
    }
    return localRetainFragment1;
  }
  
  private void init(int paramInt)
  {
    this.mMemoryCache = new LruCache(paramInt)
    {
      protected int sizeOf(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        int j = BitmapCache.getBitmapSize(paramAnonymousBitmap) / 1024;
        int i = j;
        if (j == 0) {
          i = 1;
        }
        return i;
      }
    };
  }
  
  public void addBitmapToCache(String paramString, Bitmap paramBitmap)
  {
    if ((paramString == null) || (paramBitmap == null)) {
      return;
    }
    synchronized (this.mMemoryCache)
    {
      if (this.mMemoryCache.get(paramString) == null) {
        this.mMemoryCache.put(paramString, paramBitmap);
      }
      return;
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    _InstanceCount -= 1;
    CoreHelper.WriteTraceEntryInDebug("BitmapCache", "Bitmap Memory Cache finalized! Instances: " + _InstanceCount);
    super.finalize();
  }
  
  public Bitmap getBitmap(String paramString)
  {
    return getBitmapFromMemCache(paramString);
  }
  
  public Bitmap getBitmapFromMemCache(String paramString)
  {
    if (paramString != null) {
      synchronized (this.mMemoryCache)
      {
        paramString = (Bitmap)this.mMemoryCache.get(paramString);
        if (paramString != null) {
          return paramString;
        }
      }
    }
    return null;
  }
  
  public void putBitmap(String paramString, Bitmap paramBitmap)
  {
    addBitmapToCache(paramString, paramBitmap);
  }
  
  public void releaseAll()
  {
    this.mMemoryCache.evictAll();
  }
  
  public static class RetainFragment
    extends Fragment
  {
    private Object mObject;
    
    protected void finalize()
      throws Throwable
    {
      CoreHelper.WriteTraceEntryInDebug("BitmapCache", "Bitmap Memory Cache fragment holder finalized!");
      super.finalize();
    }
    
    public Object getObject()
    {
      return this.mObject;
    }
    
    public void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      CoreHelper.WriteTraceEntryInDebug("BitmapCache", "Bitmap Memory Cache fragment holder created!");
      setRetainInstance(true);
    }
    
    public void onDestroy()
    {
      CoreHelper.WriteTraceEntryInDebug("BitmapCache", "Bitmap Memory Cache fragment holder destroyed!");
      super.onDestroy();
    }
    
    public void setObject(Object paramObject)
    {
      this.mObject = paramObject;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/volley/BitmapCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */