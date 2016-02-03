package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.cookie.CookieSpec;
import com.amazonaws.org.apache.http.cookie.CookieSpecFactory;
import com.amazonaws.org.apache.http.params.HttpParams;
import java.util.Collection;
import org.apache.http.annotation.Immutable;

@Immutable
public class RFC2965SpecFactory
  implements CookieSpecFactory
{
  public CookieSpec newInstance(HttpParams paramHttpParams)
  {
    if (paramHttpParams != null)
    {
      localObject = (Collection)paramHttpParams.getParameter("http.protocol.cookie-datepatterns");
      if (localObject == null) {
        break label65;
      }
    }
    label65:
    for (Object localObject = (String[])((Collection)localObject).toArray(new String[((Collection)localObject).size()]);; localObject = null)
    {
      return new RFC2965Spec((String[])localObject, paramHttpParams.getBooleanParameter("http.protocol.single-cookie-header", false));
      return new RFC2965Spec();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/RFC2965SpecFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */