package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ao
{
  private final LinkedHashMap a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  private int c(Object paramObject1, Object paramObject2)
  {
    int i = a(paramObject1, paramObject2);
    if (i < 0) {
      throw new IllegalStateException("Negative size: " + paramObject1 + "=" + paramObject2);
    }
    return i;
  }
  
  protected int a(Object paramObject1, Object paramObject2)
  {
    return 1;
  }
  
  public final void a()
  {
    a(-1);
  }
  
  public void a(int paramInt)
  {
    Object localObject3;
    Object localObject2;
    try
    {
      if ((this.b < 0) || ((this.a.isEmpty()) && (this.b != 0))) {
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
      }
    }
    finally
    {
      throw ((Throwable)localObject1);
      if ((this.b <= paramInt) || (this.a.isEmpty())) {
        return;
      }
      localObject3 = (Map.Entry)this.a.entrySet().iterator().next();
      localObject2 = ((Map.Entry)localObject3).getKey();
      localObject3 = ((Map.Entry)localObject3).getValue();
      this.a.remove(localObject2);
      this.b -= c(localObject2, localObject3);
      this.e += 1;
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3) {}
  
  public final Object b(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      this.d += 1;
      this.b += c(paramObject1, paramObject2);
      Object localObject = this.a.put(paramObject1, paramObject2);
      if (localObject != null) {
        this.b -= c(paramObject1, localObject);
      }
      if (localObject != null) {
        a(false, paramObject1, localObject, paramObject2);
      }
      a(this.c);
      return localObject;
    }
    finally {}
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = this.f + this.g;
      if (j != 0) {
        i = this.f * 100 / j;
      }
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(i) });
      return str;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */