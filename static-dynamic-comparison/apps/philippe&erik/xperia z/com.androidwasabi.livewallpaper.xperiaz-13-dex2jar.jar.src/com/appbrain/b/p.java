package com.appbrain.b;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class p
  extends AbstractList
  implements q, RandomAccess
{
  public static final q a = new ac(new p());
  private final List b;
  
  public p()
  {
    this.b = new ArrayList();
  }
  
  public p(q paramq)
  {
    this.b = new ArrayList(paramq.size());
    addAll(paramq);
  }
  
  private static String a(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    return ((d)paramObject).e();
  }
  
  public final d a(int paramInt)
  {
    Object localObject = this.b.get(paramInt);
    if ((localObject instanceof String))
    {
      localObject = d.a((String)localObject);
      this.b.set(paramInt, localObject);
      return (d)localObject;
    }
    return (d)localObject;
  }
  
  public final List a()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public final void a(d paramd)
  {
    this.b.add(paramd);
    this.modCount += 1;
  }
  
  public final boolean addAll(int paramInt, Collection paramCollection)
  {
    Object localObject = paramCollection;
    if ((paramCollection instanceof q)) {
      localObject = ((q)paramCollection).a();
    }
    boolean bool = this.b.addAll(paramInt, (Collection)localObject);
    this.modCount += 1;
    return bool;
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    return addAll(size(), paramCollection);
  }
  
  public final void clear()
  {
    this.b.clear();
    this.modCount += 1;
  }
  
  public final int size()
  {
    return this.b.size();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */