package org.codehaus.jackson.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class InternCache
  extends LinkedHashMap
{
  private static final int MAX_ENTRIES = 192;
  public static final InternCache instance = new InternCache();
  
  private InternCache()
  {
    super(192, 0.8F, true);
  }
  
  public String intern(String paramString)
  {
    try
    {
      String str2 = (String)get(paramString);
      String str1 = str2;
      if (str2 == null)
      {
        str1 = paramString.intern();
        put(str1, str1);
      }
      return str1;
    }
    finally {}
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > 192;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/util/InternCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */