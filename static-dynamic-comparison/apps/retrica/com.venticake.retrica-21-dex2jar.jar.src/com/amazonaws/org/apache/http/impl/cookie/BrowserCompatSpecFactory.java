package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.cookie.CookieSpec;
import com.amazonaws.org.apache.http.cookie.CookieSpecFactory;
import com.amazonaws.org.apache.http.params.HttpParams;
import java.util.Collection;
import org.apache.http.annotation.Immutable;

@Immutable
public class BrowserCompatSpecFactory
  implements CookieSpecFactory
{
  public CookieSpec newInstance(HttpParams paramHttpParams)
  {
    if (paramHttpParams != null)
    {
      paramHttpParams = (Collection)paramHttpParams.getParameter("http.protocol.cookie-datepatterns");
      if (paramHttpParams == null) {
        break label56;
      }
    }
    label56:
    for (paramHttpParams = (String[])paramHttpParams.toArray(new String[paramHttpParams.size()]);; paramHttpParams = null)
    {
      return new BrowserCompatSpec(paramHttpParams);
      return new BrowserCompatSpec();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/BrowserCompatSpecFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */