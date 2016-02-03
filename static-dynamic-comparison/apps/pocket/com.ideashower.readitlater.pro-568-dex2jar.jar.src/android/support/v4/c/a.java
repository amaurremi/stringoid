package android.support.v4.c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
  extends l
  implements Map
{
  f a;
  
  private f b()
  {
    if (this.a == null) {
      this.a = new f()
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
        
        protected Object a(int paramAnonymousInt, Object paramAnonymousObject)
        {
          return a.this.a(paramAnonymousInt, paramAnonymousObject);
        }
        
        protected void a(int paramAnonymousInt)
        {
          a.this.d(paramAnonymousInt);
        }
        
        protected void a(Object paramAnonymousObject1, Object paramAnonymousObject2)
        {
          a.this.put(paramAnonymousObject1, paramAnonymousObject2);
        }
        
        protected int b(Object paramAnonymousObject)
        {
          return a.this.a(paramAnonymousObject);
        }
        
        protected Map b()
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
  
  public Set entrySet()
  {
    return b().d();
  }
  
  public Set keySet()
  {
    return b().e();
  }
  
  public void putAll(Map paramMap)
  {
    a(this.h + paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public Collection values()
  {
    return b().f();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */