package cmn;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class ac
  extends LinkedHashMap
{
  ac(ab paramab, int paramInt)
  {
    super(paramInt, 0.75F, true);
  }
  
  protected final boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */