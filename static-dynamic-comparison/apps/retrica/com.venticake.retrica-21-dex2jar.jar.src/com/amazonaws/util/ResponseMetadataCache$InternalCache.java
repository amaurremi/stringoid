package com.amazonaws.util;

import com.amazonaws.ResponseMetadata;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class ResponseMetadataCache$InternalCache
  extends LinkedHashMap<Integer, ResponseMetadata>
{
  private int maxSize;
  
  public ResponseMetadataCache$InternalCache(int paramInt)
  {
    super(paramInt);
    this.maxSize = paramInt;
  }
  
  protected boolean removeEldestEntry(Map.Entry paramEntry)
  {
    return size() > this.maxSize;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/ResponseMetadataCache$InternalCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */