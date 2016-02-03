package mobi.beyondpod.ui.core;

import android.graphics.drawable.Drawable;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GenericImageCache<T>
{
  private static final String TAG = GenericImageCache.class.getSimpleName();
  private final String _CacheName;
  private final HashMap<T, Drawable> _HardBitmapCache;
  private final ConcurrentHashMap<T, SoftReference<Drawable>> _SoftBitmapCache;
  
  GenericImageCache(final int paramInt, String paramString)
  {
    this._CacheName = paramString;
    this._HardBitmapCache = new LinkedHashMap(paramInt / 2, 0.75F, true)
    {
      private static final long serialVersionUID = 1L;
      
      protected boolean removeEldestEntry(Map.Entry<T, Drawable> paramAnonymousEntry)
      {
        if (size() > paramInt)
        {
          GenericImageCache.this._SoftBitmapCache.put(paramAnonymousEntry.getKey(), new SoftReference((Drawable)paramAnonymousEntry.getValue()));
          return true;
        }
        return false;
      }
    };
    this._SoftBitmapCache = new ConcurrentHashMap(paramInt / 2);
  }
  
  public void clearCache()
  {
    this._HardBitmapCache.clear();
    this._SoftBitmapCache.clear();
    System.gc();
  }
  
  public Drawable getDrawableFromCache(T paramT)
  {
    if (paramT == null) {
      ??? = null;
    }
    Drawable localDrawable;
    do
    {
      return (Drawable)???;
      synchronized (this._HardBitmapCache)
      {
        localDrawable = (Drawable)this._HardBitmapCache.get(paramT);
        if (localDrawable != null)
        {
          this._HardBitmapCache.remove(paramT);
          this._HardBitmapCache.put(paramT, localDrawable);
          return localDrawable;
        }
      }
      ??? = (SoftReference)this._SoftBitmapCache.get(paramT);
      if (??? == null) {
        break;
      }
      localDrawable = (Drawable)((SoftReference)???).get();
      ??? = localDrawable;
    } while (localDrawable != null);
    this._SoftBitmapCache.remove(paramT);
    return null;
  }
  
  public void purgeHardCache()
  {
    synchronized (this._HardBitmapCache)
    {
      Iterator localIterator = this._HardBitmapCache.entrySet().iterator();
      if (!localIterator.hasNext())
      {
        this._HardBitmapCache.clear();
        return;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this._SoftBitmapCache.put(localEntry.getKey(), new SoftReference((Drawable)localEntry.getValue()));
    }
  }
  
  public void putDrawableToCache(T paramT, Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      synchronized (this._HardBitmapCache)
      {
        this._HardBitmapCache.put(paramT, paramDrawable);
        return;
      }
    }
  }
  
  public void removeImage(T paramT)
  {
    if (paramT != null) {}
    synchronized (this._HardBitmapCache)
    {
      this._HardBitmapCache.remove(paramT);
      this._SoftBitmapCache.remove(paramT);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/GenericImageCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */