package com.appbrain.b;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class j
  extends AbstractList
  implements k, RandomAccess
{
  public static final k a = new r(new j());
  private final List b;
  
  public j()
  {
    this.b = new ArrayList();
  }
  
  public j(k paramk)
  {
    this.b = new ArrayList(paramk.size());
    addAll(paramk);
  }
  
  private static String a(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    return ((c)paramObject).d();
  }
  
  public final c a(int paramInt)
  {
    Object localObject = this.b.get(paramInt);
    if ((localObject instanceof String))
    {
      localObject = c.a((String)localObject);
      this.b.set(paramInt, localObject);
      return (c)localObject;
    }
    return (c)localObject;
  }
  
  public final List a()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public final void a(c paramc)
  {
    this.b.add(paramc);
    this.modCount += 1;
  }
  
  public final boolean addAll(int paramInt, Collection paramCollection)
  {
    Object localObject = paramCollection;
    if ((paramCollection instanceof k)) {
      localObject = ((k)paramCollection).a();
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */