package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.cookie.CookieSpec;
import com.amazonaws.org.apache.http.cookie.CookieSpecFactory;
import com.amazonaws.org.apache.http.params.HttpParams;
import org.apache.http.annotation.Immutable;

@Immutable
public class IgnoreSpecFactory
  implements CookieSpecFactory
{
  public CookieSpec newInstance(HttpParams paramHttpParams)
  {
    return new IgnoreSpec();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/IgnoreSpecFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */