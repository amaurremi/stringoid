package com.amazonaws.org.apache.http.params;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class BasicHttpParams
  extends AbstractHttpParams
  implements Serializable, Cloneable
{
  private final HashMap<String, Object> parameters = new HashMap();
  
  public Object clone()
  {
    BasicHttpParams localBasicHttpParams = (BasicHttpParams)super.clone();
    copyParams(localBasicHttpParams);
    return localBasicHttpParams;
  }
  
  public void copyParams(HttpParams paramHttpParams)
  {
    Iterator localIterator = this.parameters.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getKey() instanceof String)) {
        paramHttpParams.setParameter((String)localEntry.getKey(), localEntry.getValue());
      }
    }
  }
  
  public Object getParameter(String paramString)
  {
    return this.parameters.get(paramString);
  }
  
  public HttpParams setParameter(String paramString, Object paramObject)
  {
    this.parameters.put(paramString, paramObject);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/params/BasicHttpParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */