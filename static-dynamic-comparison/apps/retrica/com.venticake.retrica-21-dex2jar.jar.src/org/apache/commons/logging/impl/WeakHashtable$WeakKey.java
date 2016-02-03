package org.apache.commons.logging.impl;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class WeakHashtable$WeakKey
  extends WeakReference
{
  private final WeakHashtable.Referenced referenced;
  
  private WeakHashtable$WeakKey(Object paramObject, ReferenceQueue paramReferenceQueue, WeakHashtable.Referenced paramReferenced)
  {
    super(paramObject, paramReferenceQueue);
    this.referenced = paramReferenced;
  }
  
  private WeakHashtable.Referenced getReferenced()
  {
    return this.referenced;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/impl/WeakHashtable$WeakKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */