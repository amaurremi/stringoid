package cmn;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class ad
  extends LinkedHashMap
{
  protected final boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > 100;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */