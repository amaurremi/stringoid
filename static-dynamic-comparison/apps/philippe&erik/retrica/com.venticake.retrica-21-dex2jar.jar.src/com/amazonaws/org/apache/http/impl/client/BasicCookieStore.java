package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.client.CookieStore;
import com.amazonaws.org.apache.http.cookie.Cookie;
import com.amazonaws.org.apache.http.cookie.CookieIdentityComparator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class BasicCookieStore
  implements CookieStore, Serializable
{
  @GuardedBy("this")
  private final TreeSet<Cookie> cookies = new TreeSet(new CookieIdentityComparator());
  
  public void addCookie(Cookie paramCookie)
  {
    if (paramCookie != null) {}
    try
    {
      this.cookies.remove(paramCookie);
      if (!paramCookie.isExpired(new Date())) {
        this.cookies.add(paramCookie);
      }
      return;
    }
    finally
    {
      paramCookie = finally;
      throw paramCookie;
    }
  }
  
  public List<Cookie> getCookies()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.cookies);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String toString()
  {
    try
    {
      String str = this.cookies.toString();
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/BasicCookieStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */