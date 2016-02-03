package cmn;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class o
  extends LinkedHashMap
{
  o(n.b paramb, int paramInt)
  {
    super(paramInt, 0.75F, true);
  }
  
  protected final boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */