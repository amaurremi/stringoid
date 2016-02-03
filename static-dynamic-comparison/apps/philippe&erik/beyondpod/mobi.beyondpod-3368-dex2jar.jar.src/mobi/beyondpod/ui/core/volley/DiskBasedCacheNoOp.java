package mobi.beyondpod.ui.core.volley;

import com.android.volley.Cache;
import com.android.volley.Cache.Entry;
import java.util.Collections;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class DiskBasedCacheNoOp
  implements Cache
{
  private static final String TAG = DiskBasedCacheBP.class.getSimpleName();
  Cache.Entry _DummyEntry = new Cache.Entry();
  
  public DiskBasedCacheNoOp()
  {
    this._DummyEntry.etag = null;
    this._DummyEntry.serverDate = Long.MIN_VALUE;
    this._DummyEntry.ttl = Long.MAX_VALUE;
    this._DummyEntry.softTtl = Long.MAX_VALUE;
    this._DummyEntry.responseHeaders = Collections.emptyMap();
  }
  
  public void clear() {}
  
  public Cache.Entry get(String paramString)
  {
    try
    {
      paramString = this._DummyEntry;
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void initialize()
  {
    CoreHelper.WriteTraceEntryInDebug(TAG, "Using dummy disk image cache...");
  }
  
  public void invalidate(String paramString, boolean paramBoolean) {}
  
  public void put(String paramString, Cache.Entry paramEntry) {}
  
  public void remove(String paramString) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/volley/DiskBasedCacheNoOp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */