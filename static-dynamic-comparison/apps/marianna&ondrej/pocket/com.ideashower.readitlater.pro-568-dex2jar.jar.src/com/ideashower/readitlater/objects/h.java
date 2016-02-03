package com.ideashower.readitlater.objects;

import android.util.SparseIntArray;
import com.ideashower.readitlater.e.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class h
  extends ArrayList
{
  private final SparseIntArray a = new SparseIntArray();
  private final SparseIntArray b = new SparseIntArray();
  
  private void a(o paramo, int paramInt)
  {
    if (paramInt != -1)
    {
      set(paramInt, paramo);
      b(paramo, paramInt);
    }
  }
  
  private void b(o paramo, int paramInt)
  {
    this.a.put(paramo.f(), paramInt);
    if (paramo.c() != 0) {
      this.b.put(paramo.c(), paramInt);
    }
  }
  
  private void g(int paramInt)
  {
    int i = size();
    while (paramInt < i)
    {
      b((o)get(paramInt), paramInt);
      paramInt += 1;
    }
  }
  
  public o a(int paramInt)
  {
    paramInt = c(paramInt);
    if (paramInt == -1) {
      return null;
    }
    return (o)get(paramInt);
  }
  
  public void a(int paramInt, o paramo)
  {
    throw new RuntimeException("not supported yet");
  }
  
  public boolean a(o paramo)
  {
    if (super.add(paramo))
    {
      b(paramo, size() - 1);
      return true;
    }
    return false;
  }
  
  public boolean addAll(int paramInt, Collection paramCollection)
  {
    throw new RuntimeException("not supported yet");
  }
  
  public boolean addAll(Collection paramCollection)
  {
    int i = size();
    if (super.addAll(paramCollection))
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        b((o)paramCollection.next(), i);
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public int b(o paramo)
  {
    if (paramo.h()) {
      return c(paramo.f());
    }
    return d(paramo.c());
  }
  
  public o b(int paramInt)
  {
    paramInt = d(paramInt);
    if (paramInt == -1) {
      return null;
    }
    return (o)get(paramInt);
  }
  
  public int c(int paramInt)
  {
    return this.a.get(paramInt, -1);
  }
  
  public int c(o paramo)
  {
    int i = c(paramo.f());
    a(paramo, i);
    return i;
  }
  
  public void clear()
  {
    this.a.clear();
    this.b.clear();
    super.clear();
  }
  
  public Object clone()
  {
    throw new RuntimeException("not supported yet");
  }
  
  public int d(int paramInt)
  {
    return this.b.get(paramInt, -1);
  }
  
  public int d(o paramo)
  {
    int i = d(paramo.c());
    a(paramo, i);
    return i;
  }
  
  public o e(int paramInt)
  {
    o localo = (o)super.remove(paramInt);
    if (localo != null)
    {
      this.a.delete(localo.f());
      if (localo.c() != 0) {
        this.b.delete(localo.c());
      }
      g(paramInt);
    }
    return localo;
  }
  
  public boolean f(int paramInt)
  {
    return c(paramInt) != -1;
  }
  
  public boolean remove(Object paramObject)
  {
    o localo = (o)paramObject;
    int i = indexOf(paramObject);
    if (i == -1) {
      return false;
    }
    if (e(i) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected void removeRange(int paramInt1, int paramInt2)
  {
    throw new RuntimeException("not supported yet");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/objects/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */