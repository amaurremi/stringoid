package android.support.v4.d;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V>
  extends k<K, V>
  implements Map<K, V>
{
  e<K, V> a;
  
  private e<K, V> b()
  {
    if (this.a == null) {
      this.a = new e()
      {
        protected int a()
        {
          return a.this.h;
        }
        
        protected int a(Object paramAnonymousObject)
        {
          if (paramAnonymousObject == null) {
            return a.this.a();
          }
          return a.this.a(paramAnonymousObject, paramAnonymousObject.hashCode());
        }
        
        protected Object a(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return a.this.g[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
        
        protected V a(int paramAnonymousInt, V paramAnonymousV)
        {
          return (V)a.this.a(paramAnonymousInt, paramAnonymousV);
        }
        
        protected void a(int paramAnonymousInt)
        {
          a.this.d(paramAnonymousInt);
        }
        
        protected void a(K paramAnonymousK, V paramAnonymousV)
        {
          a.this.put(paramAnonymousK, paramAnonymousV);
        }
        
        protected int b(Object paramAnonymousObject)
        {
          return a.this.a(paramAnonymousObject);
        }
        
        protected Map<K, V> b()
        {
          return a.this;
        }
        
        protected void c()
        {
          a.this.clear();
        }
      };
    }
    return this.a;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return b().d();
  }
  
  public Set<K> keySet()
  {
    return b().e();
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    a(this.h + paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public Collection<V> values()
  {
    return b().f();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */