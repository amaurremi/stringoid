package com.amazonaws.javax.xml.stream.util;

import java.lang.ref.SoftReference;

public class ThreadLocalBufferAllocator
{
  private static ThreadLocal tlba = new ThreadLocal();
  
  public static BufferAllocator getBufferAllocator()
  {
    SoftReference localSoftReference2 = (SoftReference)tlba.get();
    SoftReference localSoftReference1;
    if (localSoftReference2 != null)
    {
      localSoftReference1 = localSoftReference2;
      if (localSoftReference2.get() != null) {}
    }
    else
    {
      localSoftReference1 = new SoftReference(new BufferAllocator());
      tlba.set(localSoftReference1);
    }
    return (BufferAllocator)localSoftReference1.get();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/util/ThreadLocalBufferAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */