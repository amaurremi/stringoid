package org.apache.commons.logging.impl;

import java.util.Enumeration;

class WeakHashtable$1
  implements Enumeration
{
  WeakHashtable$1(WeakHashtable paramWeakHashtable, Enumeration paramEnumeration)
  {
    this.this$0 = paramWeakHashtable;
    this.val$enumer = paramEnumeration;
  }
  
  public boolean hasMoreElements()
  {
    return this.val$enumer.hasMoreElements();
  }
  
  public Object nextElement()
  {
    return WeakHashtable.Referenced.access$100((WeakHashtable.Referenced)this.val$enumer.nextElement());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/impl/WeakHashtable$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */