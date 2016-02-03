package org.apache.commons.logging.impl;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class WeakHashtable$Referenced
{
  private final int hashCode;
  private final WeakReference reference;
  
  private WeakHashtable$Referenced(Object paramObject)
  {
    this.reference = new WeakReference(paramObject);
    this.hashCode = paramObject.hashCode();
  }
  
  private WeakHashtable$Referenced(Object paramObject, ReferenceQueue paramReferenceQueue)
  {
    this.reference = new WeakHashtable.WeakKey(paramObject, paramReferenceQueue, this, null);
    this.hashCode = paramObject.hashCode();
  }
  
  private Object getValue()
  {
    return this.reference.get();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Referenced))
    {
      paramObject = (Referenced)paramObject;
      Object localObject1 = getValue();
      Object localObject2 = ((Referenced)paramObject).getValue();
      boolean bool;
      if (localObject1 == null)
      {
        if (localObject2 == null) {}
        for (bool = true;; bool = false)
        {
          if (bool != true) {
            break label66;
          }
          if (hashCode() != ((Referenced)paramObject).hashCode()) {
            break;
          }
          return true;
        }
        return false;
      }
      return localObject1.equals(localObject2);
      label66:
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.hashCode;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/impl/WeakHashtable$Referenced.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */