package com.flurry.android;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

final class af
{
  private LinkedHashMap a = new h(this, (int)Math.ceil(100 / 0.75F) + 1, 0.75F);
  private int b = 100;
  
  af(int paramInt) {}
  
  final int a()
  {
    try
    {
      int i = this.a.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final Object a(Object paramObject)
  {
    try
    {
      paramObject = this.a.get(paramObject);
      return paramObject;
    }
    finally
    {
      paramObject = finally;
      throw ((Throwable)paramObject);
    }
  }
  
  final void a(Object paramObject1, Object paramObject2)
  {
    try
    {
      this.a.put(paramObject1, paramObject2);
      return;
    }
    finally
    {
      paramObject1 = finally;
      throw ((Throwable)paramObject1);
    }
  }
  
  final List b()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.a.entrySet());
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final Set c()
  {
    try
    {
      Set localSet = this.a.keySet();
      return localSet;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */