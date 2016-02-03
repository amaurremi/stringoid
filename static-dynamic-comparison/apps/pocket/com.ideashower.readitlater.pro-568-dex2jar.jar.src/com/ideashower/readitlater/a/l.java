package com.ideashower.readitlater.a;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.ideashower.readitlater.f.a;
import com.ideashower.readitlater.f.b;
import com.ideashower.readitlater.f.d;
import java.net.HttpCookie;
import java.util.Iterator;
import java.util.List;
import org.apache.http.client.methods.HttpGet;

public class l
{
  public static String a(String paramString)
  {
    return CookieManager.getInstance().getCookie(paramString);
  }
  
  public static void a() {}
  
  public static void a(Context paramContext)
  {
    CookieSyncManager.createInstance(paramContext);
    CookieSyncManager.getInstance().sync();
  }
  
  public static void a(String paramString, List paramList)
  {
    CookieManager localCookieManager = CookieManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (HttpCookie)localIterator.next();
      localStringBuilder.setLength(0);
      paramList = ((HttpCookie)localObject).getValue();
      String str1 = ((HttpCookie)localObject).getDomain();
      String str2 = ((HttpCookie)localObject).getPath();
      boolean bool = ((HttpCookie)localObject).getSecure();
      localObject = localStringBuilder.append(((HttpCookie)localObject).getName()).append("=");
      if (paramList != null) {}
      for (;;)
      {
        ((StringBuilder)localObject).append(paramList).append(";").append("expires=Fri, 01 Jan 2049 01:01:01 GMT;");
        if ((str1 != null) && (str1.length() > 0)) {
          localStringBuilder.append("Domain=").append(str1).append(";");
        }
        if ((str2 != null) && (str2.length() > 0)) {
          localStringBuilder.append("Path=").append(str2).append(";");
        }
        if (bool) {
          localStringBuilder.append("Secure").append(";");
        }
        localCookieManager.setCookie(paramString, localStringBuilder.toString());
        break;
        paramList = "";
      }
    }
  }
  
  public static ag b()
  {
    return null;
  }
  
  public static void b(String paramString)
  {
    a(paramString, a.a(new d(new HttpGet(paramString), 0), true, true).c());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */