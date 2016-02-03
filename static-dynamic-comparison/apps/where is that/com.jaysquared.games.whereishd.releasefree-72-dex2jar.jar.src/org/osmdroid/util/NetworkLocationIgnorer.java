package org.osmdroid.util;

import org.osmdroid.util.constants.UtilConstants;

public class NetworkLocationIgnorer
  implements UtilConstants
{
  private long mLastGps = 0L;
  
  public boolean shouldIgnore(String paramString, long paramLong)
  {
    if ("gps".equals(paramString)) {
      this.mLastGps = paramLong;
    }
    while (paramLong >= this.mLastGps + 20000L) {
      return false;
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/util/NetworkLocationIgnorer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */