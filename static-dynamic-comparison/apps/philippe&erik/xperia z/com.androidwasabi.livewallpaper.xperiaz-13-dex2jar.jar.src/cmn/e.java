package cmn;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class e
  extends LinkedHashMap
{
  protected final boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > 100;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */