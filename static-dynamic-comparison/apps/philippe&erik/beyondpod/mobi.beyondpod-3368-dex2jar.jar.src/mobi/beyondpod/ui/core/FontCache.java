package mobi.beyondpod.ui.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import java.util.Hashtable;

public class FontCache
{
  private static final Hashtable<String, Typeface> cache = new Hashtable();
  
  public static Typeface get(Context paramContext, String paramString)
  {
    synchronized (cache)
    {
      boolean bool = cache.containsKey(paramString);
      if (bool) {}
    }
    try
    {
      float f = paramContext.getResources().getDisplayMetrics().density;
      if (f == 1.0F) {
        return null;
      }
      paramContext = Typeface.createFromAsset(paramContext.getAssets(), paramString);
      cache.put(paramString, paramContext);
      paramContext = (Typeface)cache.get(paramString);
      return paramContext;
    }
    catch (Exception paramContext) {}
    paramContext = finally;
    throw paramContext;
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/FontCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */