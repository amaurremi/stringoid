package com.chartboost.sdk.impl;

import java.util.HashMap;
import java.util.Map;

abstract class bk<K, V>
  extends bf<K, V, Map<K, V>>
{
  protected bk(Map<? extends K, ? extends V> paramMap, bf.h.a parama)
  {
    super(paramMap, parama);
  }
  
  public static <K, V> a<K, V> b()
  {
    return new a();
  }
  
  public static <K, V> bk<K, V> c()
  {
    return b().a();
  }
  
  public static class a<K, V>
  {
    private bf.h.a a = bf.h.a.a;
    private final Map<K, V> b = new HashMap();
    
    public bk<K, V> a()
    {
      return new bk.b(this.b, this.a);
    }
  }
  
  static class b<K, V>
    extends bk<K, V>
  {
    b(Map<? extends K, ? extends V> paramMap, bf.h.a parama)
    {
      super(parama);
    }
    
    public <N extends Map<? extends K, ? extends V>> Map<K, V> a(N paramN)
    {
      return new HashMap(paramN);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */