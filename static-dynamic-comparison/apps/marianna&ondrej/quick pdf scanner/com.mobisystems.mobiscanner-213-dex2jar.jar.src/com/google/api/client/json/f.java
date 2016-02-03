package com.google.api.client.json;

import com.google.api.client.util.v;
import com.google.api.client.util.x;
import com.google.api.client.util.y;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class f
  implements v
{
  private final d acn;
  private final Set<String> acp;
  
  protected f(a parama)
  {
    this.acn = parama.acn;
    this.acp = new HashSet(parama.acq);
  }
  
  private void a(g paramg)
  {
    boolean bool = true;
    if (this.acp.isEmpty()) {
      return;
    }
    for (;;)
    {
      try
      {
        if ((paramg.c(this.acp) != null) && (paramg.yn() != JsonToken.acx))
        {
          x.b(bool, "wrapper key(s) not found: %s", new Object[] { this.acp });
          return;
        }
      }
      finally
      {
        paramg.close();
      }
      bool = false;
    }
  }
  
  public <T> T a(InputStream paramInputStream, Charset paramCharset, Class<T> paramClass)
  {
    return (T)a(paramInputStream, paramCharset, paramClass);
  }
  
  public Object a(InputStream paramInputStream, Charset paramCharset, Type paramType)
  {
    paramInputStream = this.acn.a(paramInputStream, paramCharset);
    a(paramInputStream);
    return paramInputStream.a(paramType, true);
  }
  
  public final d xg()
  {
    return this.acn;
  }
  
  public Set<String> yk()
  {
    return Collections.unmodifiableSet(this.acp);
  }
  
  public static class a
  {
    final d acn;
    Collection<String> acq = y.yU();
    
    public a(d paramd)
    {
      this.acn = ((d)x.ad(paramd));
    }
    
    public a e(Collection<String> paramCollection)
    {
      this.acq = paramCollection;
      return this;
    }
    
    public f yl()
    {
      return new f(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/json/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */