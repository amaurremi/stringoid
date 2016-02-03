package android.support.v4.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V>
  extends g<K, V>
  implements Map<K, V>
{
  f<K, V> D;
  
  private f<K, V> j()
  {
    if (this.D == null) {
      this.D = new f()
      {
        protected int a(Object paramAnonymousObject)
        {
          if (paramAnonymousObject == null) {
            return a.this.s();
          }
          return a.this.indexOf(paramAnonymousObject, paramAnonymousObject.hashCode());
        }
        
        protected V a(int paramAnonymousInt, V paramAnonymousV)
        {
          return (V)a.this.setValueAt(paramAnonymousInt, paramAnonymousV);
        }
        
        protected void a(int paramAnonymousInt)
        {
          a.this.removeAt(paramAnonymousInt);
        }
        
        protected void a(K paramAnonymousK, V paramAnonymousV)
        {
          a.this.put(paramAnonymousK, paramAnonymousV);
        }
        
        protected int b(Object paramAnonymousObject)
        {
          return a.this.indexOfValue(paramAnonymousObject);
        }
        
        protected Object b(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return a.this.ae[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
        
        protected int k()
        {
          return a.this.U;
        }
        
        protected Map<K, V> l()
        {
          return a.this;
        }
        
        protected void m()
        {
          a.this.clear();
        }
      };
    }
    return this.D;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return j().o();
  }
  
  public Set<K> keySet()
  {
    return j().p();
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    ensureCapacity(this.U + paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public Collection<V> values()
  {
    return j().q();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/android/support/v4/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */