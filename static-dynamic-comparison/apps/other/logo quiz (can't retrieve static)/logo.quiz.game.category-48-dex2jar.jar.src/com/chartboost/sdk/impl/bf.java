package com.chartboost.sdk.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

abstract class bf<K, V, M extends Map<K, V>>
  implements Serializable, ConcurrentMap<K, V>
{
  private volatile M a = (Map)bg.a("delegate", a((Map)bg.a("map", paramN)));
  private final transient Lock b = new ReentrantLock();
  private final h<K, V> c;
  
  protected <N extends Map<? extends K, ? extends V>> bf(N paramN, bf.h.a parama)
  {
    this.c = ((bf.h.a)bg.a("viewType", parama)).a(this);
  }
  
  private boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  protected M a()
  {
    this.b.lock();
    try
    {
      Map localMap = a(this.a);
      return localMap;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  abstract <N extends Map<? extends K, ? extends V>> M a(N paramN);
  
  protected void b(M paramM)
  {
    this.a = paramM;
  }
  
  public final void clear()
  {
    this.b.lock();
    try
    {
      b(a(Collections.emptyMap()));
      return;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return this.a.containsKey(paramObject);
  }
  
  public final boolean containsValue(Object paramObject)
  {
    return this.a.containsValue(paramObject);
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    return this.c.b();
  }
  
  public final boolean equals(Object paramObject)
  {
    return this.a.equals(paramObject);
  }
  
  public final V get(Object paramObject)
  {
    return (V)this.a.get(paramObject);
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
  
  public final boolean isEmpty()
  {
    return this.a.isEmpty();
  }
  
  public final Set<K> keySet()
  {
    return this.c.a();
  }
  
  /* Error */
  public final V put(K paramK, V paramV)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	com/chartboost/sdk/impl/bf:b	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 95 1 0
    //   9: aload_0
    //   10: invokevirtual 141	com/chartboost/sdk/impl/bf:a	()Ljava/util/Map;
    //   13: astore_3
    //   14: aload_3
    //   15: aload_1
    //   16: aload_2
    //   17: invokeinterface 143 3 0
    //   22: astore_1
    //   23: aload_0
    //   24: aload_3
    //   25: invokevirtual 109	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
    //   28: aload_0
    //   29: getfield 56	com/chartboost/sdk/impl/bf:b	Ljava/util/concurrent/locks/Lock;
    //   32: invokeinterface 98 1 0
    //   37: aload_1
    //   38: areturn
    //   39: astore_1
    //   40: aload_0
    //   41: aload_3
    //   42: invokevirtual 109	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
    //   45: aload_1
    //   46: athrow
    //   47: astore_1
    //   48: aload_0
    //   49: getfield 56	com/chartboost/sdk/impl/bf:b	Ljava/util/concurrent/locks/Lock;
    //   52: invokeinterface 98 1 0
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	bf
    //   0	59	1	paramK	K
    //   0	59	2	paramV	V
    //   13	29	3	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   14	23	39	finally
    //   9	14	47	finally
    //   23	28	47	finally
    //   40	47	47	finally
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    this.b.lock();
    try
    {
      Map localMap = a();
      localMap.putAll(paramMap);
      b(localMap);
      return;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  public V putIfAbsent(K paramK, V paramV)
  {
    this.b.lock();
    try
    {
      if (!this.a.containsKey(paramK))
      {
        Map localMap = a();
        try
        {
          paramK = localMap.put(paramK, paramV);
          b(localMap);
          return paramK;
        }
        finally
        {
          b(localMap);
        }
      }
      paramK = this.a.get(paramK);
    }
    finally
    {
      this.b.unlock();
    }
    this.b.unlock();
    return paramK;
  }
  
  /* Error */
  public final V remove(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	com/chartboost/sdk/impl/bf:b	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 95 1 0
    //   9: aload_0
    //   10: getfield 72	com/chartboost/sdk/impl/bf:a	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 112 2 0
    //   19: istore_2
    //   20: iload_2
    //   21: ifne +14 -> 35
    //   24: aload_0
    //   25: getfield 56	com/chartboost/sdk/impl/bf:b	Ljava/util/concurrent/locks/Lock;
    //   28: invokeinterface 98 1 0
    //   33: aconst_null
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 141	com/chartboost/sdk/impl/bf:a	()Ljava/util/Map;
    //   39: astore_3
    //   40: aload_3
    //   41: aload_1
    //   42: invokeinterface 152 2 0
    //   47: astore_1
    //   48: aload_0
    //   49: aload_3
    //   50: invokevirtual 109	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
    //   53: aload_0
    //   54: getfield 56	com/chartboost/sdk/impl/bf:b	Ljava/util/concurrent/locks/Lock;
    //   57: invokeinterface 98 1 0
    //   62: aload_1
    //   63: areturn
    //   64: astore_1
    //   65: aload_0
    //   66: aload_3
    //   67: invokevirtual 109	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
    //   70: aload_1
    //   71: athrow
    //   72: astore_1
    //   73: aload_0
    //   74: getfield 56	com/chartboost/sdk/impl/bf:b	Ljava/util/concurrent/locks/Lock;
    //   77: invokeinterface 98 1 0
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	bf
    //   0	84	1	paramObject	Object
    //   19	2	2	bool	boolean
    //   39	28	3	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   40	48	64	finally
    //   9	20	72	finally
    //   35	40	72	finally
    //   48	53	72	finally
    //   65	72	72	finally
  }
  
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    this.b.lock();
    try
    {
      if ((this.a.containsKey(paramObject1)) && (a(paramObject2, this.a.get(paramObject1))))
      {
        paramObject2 = a();
        ((Map)paramObject2).remove(paramObject1);
        b((Map)paramObject2);
        return true;
      }
      return false;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  /* Error */
  public V replace(K paramK, V paramV)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	com/chartboost/sdk/impl/bf:b	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 95 1 0
    //   9: aload_0
    //   10: getfield 72	com/chartboost/sdk/impl/bf:a	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 112 2 0
    //   19: istore_3
    //   20: iload_3
    //   21: ifne +14 -> 35
    //   24: aload_0
    //   25: getfield 56	com/chartboost/sdk/impl/bf:b	Ljava/util/concurrent/locks/Lock;
    //   28: invokeinterface 98 1 0
    //   33: aconst_null
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 141	com/chartboost/sdk/impl/bf:a	()Ljava/util/Map;
    //   39: astore 4
    //   41: aload 4
    //   43: aload_1
    //   44: aload_2
    //   45: invokeinterface 143 3 0
    //   50: astore_1
    //   51: aload_0
    //   52: aload 4
    //   54: invokevirtual 109	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
    //   57: aload_0
    //   58: getfield 56	com/chartboost/sdk/impl/bf:b	Ljava/util/concurrent/locks/Lock;
    //   61: invokeinterface 98 1 0
    //   66: aload_1
    //   67: areturn
    //   68: astore_1
    //   69: aload_0
    //   70: aload 4
    //   72: invokevirtual 109	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: getfield 56	com/chartboost/sdk/impl/bf:b	Ljava/util/concurrent/locks/Lock;
    //   82: invokeinterface 98 1 0
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	bf
    //   0	89	1	paramK	K
    //   0	89	2	paramV	V
    //   19	2	3	bool	boolean
    //   39	32	4	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   41	51	68	finally
    //   9	20	77	finally
    //   35	41	77	finally
    //   51	57	77	finally
    //   69	77	77	finally
  }
  
  public boolean replace(K paramK, V paramV1, V paramV2)
  {
    this.b.lock();
    try
    {
      if (this.a.containsKey(paramK))
      {
        boolean bool = a(paramV1, this.a.get(paramK));
        if (bool) {}
      }
      else
      {
        return false;
      }
      paramV1 = a();
      paramV1.put(paramK, paramV2);
      b(paramV1);
      return true;
    }
    finally
    {
      this.b.unlock();
    }
  }
  
  public final int size()
  {
    return this.a.size();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  public final Collection<V> values()
  {
    return this.c.c();
  }
  
  protected static abstract class a<E>
    implements Collection<E>
  {
    abstract Collection<E> a();
    
    public final boolean add(E paramE)
    {
      throw new UnsupportedOperationException();
    }
    
    public final boolean addAll(Collection<? extends E> paramCollection)
    {
      throw new UnsupportedOperationException();
    }
    
    public final boolean contains(Object paramObject)
    {
      return a().contains(paramObject);
    }
    
    public final boolean containsAll(Collection<?> paramCollection)
    {
      return a().containsAll(paramCollection);
    }
    
    public boolean equals(Object paramObject)
    {
      return a().equals(paramObject);
    }
    
    public int hashCode()
    {
      return a().hashCode();
    }
    
    public final boolean isEmpty()
    {
      return a().isEmpty();
    }
    
    public final Iterator<E> iterator()
    {
      return new bf.f(a().iterator());
    }
    
    public final int size()
    {
      return a().size();
    }
    
    public final Object[] toArray()
    {
      return a().toArray();
    }
    
    public final <T> T[] toArray(T[] paramArrayOfT)
    {
      return a().toArray(paramArrayOfT);
    }
    
    public String toString()
    {
      return a().toString();
    }
  }
  
  private class b
    extends bf.a<Map.Entry<K, V>>
    implements Set<Map.Entry<K, V>>
  {
    private b() {}
    
    Collection<Map.Entry<K, V>> a()
    {
      return bf.a(bf.this).entrySet();
    }
    
    public void clear()
    {
      bf.b(bf.this).lock();
      try
      {
        Map localMap = bf.this.a();
        localMap.entrySet().clear();
        bf.this.b(localMap);
        return;
      }
      finally
      {
        bf.b(bf.this).unlock();
      }
    }
    
    /* Error */
    public boolean remove(Object paramObject)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   4: invokestatic 39	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   7: invokeinterface 44 1 0
      //   12: aload_0
      //   13: aload_1
      //   14: invokevirtual 60	com/chartboost/sdk/impl/bf$b:contains	(Ljava/lang/Object;)Z
      //   17: istore_2
      //   18: iload_2
      //   19: ifne +17 -> 36
      //   22: aload_0
      //   23: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   26: invokestatic 39	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   29: invokeinterface 55 1 0
      //   34: iconst_0
      //   35: ireturn
      //   36: aload_0
      //   37: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   40: invokevirtual 47	com/chartboost/sdk/impl/bf:a	()Ljava/util/Map;
      //   43: astore_3
      //   44: aload_3
      //   45: invokeinterface 33 1 0
      //   50: aload_1
      //   51: invokeinterface 62 2 0
      //   56: istore_2
      //   57: aload_0
      //   58: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   61: aload_3
      //   62: invokevirtual 52	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
      //   65: aload_0
      //   66: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   69: invokestatic 39	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   72: invokeinterface 55 1 0
      //   77: iload_2
      //   78: ireturn
      //   79: astore_1
      //   80: aload_0
      //   81: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   84: aload_3
      //   85: invokevirtual 52	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
      //   88: aload_1
      //   89: athrow
      //   90: astore_1
      //   91: aload_0
      //   92: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   95: invokestatic 39	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   98: invokeinterface 55 1 0
      //   103: aload_1
      //   104: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	105	0	this	b
      //   0	105	1	paramObject	Object
      //   17	61	2	bool	boolean
      //   43	42	3	localMap	Map
      // Exception table:
      //   from	to	target	type
      //   44	57	79	finally
      //   12	18	90	finally
      //   36	44	90	finally
      //   57	65	90	finally
      //   80	90	90	finally
    }
    
    /* Error */
    public boolean removeAll(Collection<?> paramCollection)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   4: invokestatic 39	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   7: invokeinterface 44 1 0
      //   12: aload_0
      //   13: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   16: invokevirtual 47	com/chartboost/sdk/impl/bf:a	()Ljava/util/Map;
      //   19: astore_3
      //   20: aload_3
      //   21: invokeinterface 33 1 0
      //   26: aload_1
      //   27: invokeinterface 66 2 0
      //   32: istore_2
      //   33: aload_0
      //   34: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   37: aload_3
      //   38: invokevirtual 52	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
      //   41: aload_0
      //   42: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   45: invokestatic 39	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   48: invokeinterface 55 1 0
      //   53: iload_2
      //   54: ireturn
      //   55: astore_1
      //   56: aload_0
      //   57: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   60: aload_3
      //   61: invokevirtual 52	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
      //   64: aload_1
      //   65: athrow
      //   66: astore_1
      //   67: aload_0
      //   68: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   71: invokestatic 39	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   74: invokeinterface 55 1 0
      //   79: aload_1
      //   80: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	81	0	this	b
      //   0	81	1	paramCollection	Collection<?>
      //   32	22	2	bool	boolean
      //   19	42	3	localMap	Map
      // Exception table:
      //   from	to	target	type
      //   20	33	55	finally
      //   12	20	66	finally
      //   33	41	66	finally
      //   56	66	66	finally
    }
    
    /* Error */
    public boolean retainAll(Collection<?> paramCollection)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   4: invokestatic 39	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   7: invokeinterface 44 1 0
      //   12: aload_0
      //   13: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   16: invokevirtual 47	com/chartboost/sdk/impl/bf:a	()Ljava/util/Map;
      //   19: astore_3
      //   20: aload_3
      //   21: invokeinterface 33 1 0
      //   26: aload_1
      //   27: invokeinterface 70 2 0
      //   32: istore_2
      //   33: aload_0
      //   34: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   37: aload_3
      //   38: invokevirtual 52	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
      //   41: aload_0
      //   42: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   45: invokestatic 39	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   48: invokeinterface 55 1 0
      //   53: iload_2
      //   54: ireturn
      //   55: astore_1
      //   56: aload_0
      //   57: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   60: aload_3
      //   61: invokevirtual 52	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
      //   64: aload_1
      //   65: athrow
      //   66: astore_1
      //   67: aload_0
      //   68: getfield 16	com/chartboost/sdk/impl/bf$b:a	Lcom/chartboost/sdk/impl/bf;
      //   71: invokestatic 39	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   74: invokeinterface 55 1 0
      //   79: aload_1
      //   80: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	81	0	this	b
      //   0	81	1	paramCollection	Collection<?>
      //   32	22	2	bool	boolean
      //   19	42	3	localMap	Map
      // Exception table:
      //   from	to	target	type
      //   20	33	55	finally
      //   12	20	66	finally
      //   33	41	66	finally
      //   56	66	66	finally
    }
  }
  
  final class c
    extends bf.h<K, V>
    implements Serializable
  {
    c() {}
    
    public Set<K> a()
    {
      return Collections.unmodifiableSet(bf.a(bf.this).keySet());
    }
    
    public Set<Map.Entry<K, V>> b()
    {
      return Collections.unmodifiableSet(bf.a(bf.this).entrySet());
    }
    
    public Collection<V> c()
    {
      return Collections.unmodifiableCollection(bf.a(bf.this).values());
    }
  }
  
  private class d
    extends bf.a<K>
    implements Set<K>
  {
    private d() {}
    
    Collection<K> a()
    {
      return bf.a(bf.this).keySet();
    }
    
    public void clear()
    {
      bf.b(bf.this).lock();
      try
      {
        Map localMap = bf.this.a();
        localMap.keySet().clear();
        bf.this.b(localMap);
        return;
      }
      finally
      {
        bf.b(bf.this).unlock();
      }
    }
    
    public boolean remove(Object paramObject)
    {
      return bf.this.remove(paramObject) != null;
    }
    
    /* Error */
    public boolean removeAll(Collection<?> paramCollection)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 16	com/chartboost/sdk/impl/bf$d:a	Lcom/chartboost/sdk/impl/bf;
      //   4: invokestatic 40	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   7: invokeinterface 45 1 0
      //   12: aload_0
      //   13: getfield 16	com/chartboost/sdk/impl/bf$d:a	Lcom/chartboost/sdk/impl/bf;
      //   16: invokevirtual 48	com/chartboost/sdk/impl/bf:a	()Ljava/util/Map;
      //   19: astore_3
      //   20: aload_3
      //   21: invokeinterface 33 1 0
      //   26: aload_1
      //   27: invokeinterface 65 2 0
      //   32: istore_2
      //   33: aload_0
      //   34: getfield 16	com/chartboost/sdk/impl/bf$d:a	Lcom/chartboost/sdk/impl/bf;
      //   37: aload_3
      //   38: invokevirtual 53	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
      //   41: aload_0
      //   42: getfield 16	com/chartboost/sdk/impl/bf$d:a	Lcom/chartboost/sdk/impl/bf;
      //   45: invokestatic 40	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   48: invokeinterface 56 1 0
      //   53: iload_2
      //   54: ireturn
      //   55: astore_1
      //   56: aload_0
      //   57: getfield 16	com/chartboost/sdk/impl/bf$d:a	Lcom/chartboost/sdk/impl/bf;
      //   60: aload_3
      //   61: invokevirtual 53	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
      //   64: aload_1
      //   65: athrow
      //   66: astore_1
      //   67: aload_0
      //   68: getfield 16	com/chartboost/sdk/impl/bf$d:a	Lcom/chartboost/sdk/impl/bf;
      //   71: invokestatic 40	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   74: invokeinterface 56 1 0
      //   79: aload_1
      //   80: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	81	0	this	d
      //   0	81	1	paramCollection	Collection<?>
      //   32	22	2	bool	boolean
      //   19	42	3	localMap	Map
      // Exception table:
      //   from	to	target	type
      //   20	33	55	finally
      //   12	20	66	finally
      //   33	41	66	finally
      //   56	66	66	finally
    }
    
    /* Error */
    public boolean retainAll(Collection<?> paramCollection)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 16	com/chartboost/sdk/impl/bf$d:a	Lcom/chartboost/sdk/impl/bf;
      //   4: invokestatic 40	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   7: invokeinterface 45 1 0
      //   12: aload_0
      //   13: getfield 16	com/chartboost/sdk/impl/bf$d:a	Lcom/chartboost/sdk/impl/bf;
      //   16: invokevirtual 48	com/chartboost/sdk/impl/bf:a	()Ljava/util/Map;
      //   19: astore_3
      //   20: aload_3
      //   21: invokeinterface 33 1 0
      //   26: aload_1
      //   27: invokeinterface 69 2 0
      //   32: istore_2
      //   33: aload_0
      //   34: getfield 16	com/chartboost/sdk/impl/bf$d:a	Lcom/chartboost/sdk/impl/bf;
      //   37: aload_3
      //   38: invokevirtual 53	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
      //   41: aload_0
      //   42: getfield 16	com/chartboost/sdk/impl/bf$d:a	Lcom/chartboost/sdk/impl/bf;
      //   45: invokestatic 40	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   48: invokeinterface 56 1 0
      //   53: iload_2
      //   54: ireturn
      //   55: astore_1
      //   56: aload_0
      //   57: getfield 16	com/chartboost/sdk/impl/bf$d:a	Lcom/chartboost/sdk/impl/bf;
      //   60: aload_3
      //   61: invokevirtual 53	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
      //   64: aload_1
      //   65: athrow
      //   66: astore_1
      //   67: aload_0
      //   68: getfield 16	com/chartboost/sdk/impl/bf$d:a	Lcom/chartboost/sdk/impl/bf;
      //   71: invokestatic 40	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   74: invokeinterface 56 1 0
      //   79: aload_1
      //   80: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	81	0	this	d
      //   0	81	1	paramCollection	Collection<?>
      //   32	22	2	bool	boolean
      //   19	42	3	localMap	Map
      // Exception table:
      //   from	to	target	type
      //   20	33	55	finally
      //   12	20	66	finally
      //   33	41	66	finally
      //   56	66	66	finally
    }
  }
  
  final class e
    extends bf.h<K, V>
    implements Serializable
  {
    private final transient bf<K, V, M>.d b = new bf.d(bf.this, null);
    private final transient bf<K, V, M>.b c = new bf.b(bf.this, null);
    private final transient bf<K, V, M>.g d = new bf.g(bf.this, null);
    
    e() {}
    
    public Set<K> a()
    {
      return this.b;
    }
    
    public Set<Map.Entry<K, V>> b()
    {
      return this.c;
    }
    
    public Collection<V> c()
    {
      return this.d;
    }
  }
  
  private static class f<T>
    implements Iterator<T>
  {
    private final Iterator<T> a;
    
    public f(Iterator<T> paramIterator)
    {
      this.a = paramIterator;
    }
    
    public boolean hasNext()
    {
      return this.a.hasNext();
    }
    
    public T next()
    {
      return (T)this.a.next();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  private final class g
    extends bf.a<V>
  {
    private g() {}
    
    Collection<V> a()
    {
      return bf.a(bf.this).values();
    }
    
    public void clear()
    {
      bf.b(bf.this).lock();
      try
      {
        Map localMap = bf.this.a();
        localMap.values().clear();
        bf.this.b(localMap);
        return;
      }
      finally
      {
        bf.b(bf.this).unlock();
      }
    }
    
    /* Error */
    public boolean remove(Object paramObject)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   4: invokestatic 37	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   7: invokeinterface 42 1 0
      //   12: aload_0
      //   13: aload_1
      //   14: invokevirtual 60	com/chartboost/sdk/impl/bf$g:contains	(Ljava/lang/Object;)Z
      //   17: istore_2
      //   18: iload_2
      //   19: ifne +17 -> 36
      //   22: aload_0
      //   23: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   26: invokestatic 37	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   29: invokeinterface 55 1 0
      //   34: iconst_0
      //   35: ireturn
      //   36: aload_0
      //   37: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   40: invokevirtual 45	com/chartboost/sdk/impl/bf:a	()Ljava/util/Map;
      //   43: astore_3
      //   44: aload_3
      //   45: invokeinterface 30 1 0
      //   50: aload_1
      //   51: invokeinterface 62 2 0
      //   56: istore_2
      //   57: aload_0
      //   58: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   61: aload_3
      //   62: invokevirtual 52	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
      //   65: aload_0
      //   66: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   69: invokestatic 37	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   72: invokeinterface 55 1 0
      //   77: iload_2
      //   78: ireturn
      //   79: astore_1
      //   80: aload_0
      //   81: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   84: aload_3
      //   85: invokevirtual 52	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
      //   88: aload_1
      //   89: athrow
      //   90: astore_1
      //   91: aload_0
      //   92: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   95: invokestatic 37	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   98: invokeinterface 55 1 0
      //   103: aload_1
      //   104: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	105	0	this	g
      //   0	105	1	paramObject	Object
      //   17	61	2	bool	boolean
      //   43	42	3	localMap	Map
      // Exception table:
      //   from	to	target	type
      //   44	57	79	finally
      //   12	18	90	finally
      //   36	44	90	finally
      //   57	65	90	finally
      //   80	90	90	finally
    }
    
    /* Error */
    public boolean removeAll(Collection<?> paramCollection)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   4: invokestatic 37	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   7: invokeinterface 42 1 0
      //   12: aload_0
      //   13: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   16: invokevirtual 45	com/chartboost/sdk/impl/bf:a	()Ljava/util/Map;
      //   19: astore_3
      //   20: aload_3
      //   21: invokeinterface 30 1 0
      //   26: aload_1
      //   27: invokeinterface 66 2 0
      //   32: istore_2
      //   33: aload_0
      //   34: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   37: aload_3
      //   38: invokevirtual 52	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
      //   41: aload_0
      //   42: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   45: invokestatic 37	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   48: invokeinterface 55 1 0
      //   53: iload_2
      //   54: ireturn
      //   55: astore_1
      //   56: aload_0
      //   57: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   60: aload_3
      //   61: invokevirtual 52	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
      //   64: aload_1
      //   65: athrow
      //   66: astore_1
      //   67: aload_0
      //   68: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   71: invokestatic 37	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   74: invokeinterface 55 1 0
      //   79: aload_1
      //   80: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	81	0	this	g
      //   0	81	1	paramCollection	Collection<?>
      //   32	22	2	bool	boolean
      //   19	42	3	localMap	Map
      // Exception table:
      //   from	to	target	type
      //   20	33	55	finally
      //   12	20	66	finally
      //   33	41	66	finally
      //   56	66	66	finally
    }
    
    /* Error */
    public boolean retainAll(Collection<?> paramCollection)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   4: invokestatic 37	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   7: invokeinterface 42 1 0
      //   12: aload_0
      //   13: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   16: invokevirtual 45	com/chartboost/sdk/impl/bf:a	()Ljava/util/Map;
      //   19: astore_3
      //   20: aload_3
      //   21: invokeinterface 30 1 0
      //   26: aload_1
      //   27: invokeinterface 70 2 0
      //   32: istore_2
      //   33: aload_0
      //   34: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   37: aload_3
      //   38: invokevirtual 52	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
      //   41: aload_0
      //   42: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   45: invokestatic 37	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   48: invokeinterface 55 1 0
      //   53: iload_2
      //   54: ireturn
      //   55: astore_1
      //   56: aload_0
      //   57: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   60: aload_3
      //   61: invokevirtual 52	com/chartboost/sdk/impl/bf:b	(Ljava/util/Map;)V
      //   64: aload_1
      //   65: athrow
      //   66: astore_1
      //   67: aload_0
      //   68: getfield 14	com/chartboost/sdk/impl/bf$g:a	Lcom/chartboost/sdk/impl/bf;
      //   71: invokestatic 37	com/chartboost/sdk/impl/bf:b	(Lcom/chartboost/sdk/impl/bf;)Ljava/util/concurrent/locks/Lock;
      //   74: invokeinterface 55 1 0
      //   79: aload_1
      //   80: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	81	0	this	g
      //   0	81	1	paramCollection	Collection<?>
      //   32	22	2	bool	boolean
      //   19	42	3	localMap	Map
      // Exception table:
      //   from	to	target	type
      //   20	33	55	finally
      //   12	20	66	finally
      //   33	41	66	finally
      //   56	66	66	finally
    }
  }
  
  public static abstract class h<K, V>
  {
    abstract Set<K> a();
    
    abstract Set<Map.Entry<K, V>> b();
    
    abstract Collection<V> c();
    
    public static abstract enum a
    {
      private a() {}
      
      abstract <K, V, M extends Map<K, V>> bf.h<K, V> a(bf<K, V, M> parambf);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */