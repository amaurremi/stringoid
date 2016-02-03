package mobi.beyondpod.ui.core.volley;

import com.android.volley.Cache;
import com.android.volley.Cache.Entry;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class DiskBasedCacheNoCache
  implements Cache
{
  private static final String TAG = DiskBasedCacheBP.class.getSimpleName();
  Cache.Entry _DummyEntry;
  
  public void clear() {}
  
  public Cache.Entry get(String paramString)
  {
    return null;
  }
  
  public void initialize()
  {
    CoreHelper.WriteTraceEntryInDebug(TAG, "Using 'No-Cache' disk image cache...");
  }
  
  public void invalidate(String paramString, boolean paramBoolean) {}
  
  public void put(String paramString, Cache.Entry paramEntry) {}
  
  public void remove(String paramString) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/volley/DiskBasedCacheNoCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */