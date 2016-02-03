package com.flurry.android;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class h
  extends LinkedHashMap
{
  h(af paramaf, int paramInt, float paramFloat)
  {
    super(paramInt, paramFloat, true);
  }
  
  protected final boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > af.a(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */