package com.e.a.b.a;

import com.e.a.j;
import com.e.a.k;
import com.e.a.l;
import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static final j a = new j()
  {
    private InetAddress a(Proxy paramAnonymousProxy, URL paramAnonymousURL)
    {
      if ((paramAnonymousProxy != null) && (paramAnonymousProxy.type() != Proxy.Type.DIRECT)) {
        return ((InetSocketAddress)paramAnonymousProxy.address()).getAddress();
      }
      return InetAddress.getByName(paramAnonymousURL.getHost());
    }
    
    public l a(Proxy paramAnonymousProxy, URL paramAnonymousURL, List paramAnonymousList)
    {
      paramAnonymousList = paramAnonymousList.iterator();
      while (paramAnonymousList.hasNext())
      {
        Object localObject = (k)paramAnonymousList.next();
        localObject = Authenticator.requestPasswordAuthentication(paramAnonymousURL.getHost(), a(paramAnonymousProxy, paramAnonymousURL), paramAnonymousURL.getPort(), paramAnonymousURL.getProtocol(), ((k)localObject).b(), ((k)localObject).a(), paramAnonymousURL, Authenticator.RequestorType.SERVER);
        if (localObject != null) {
          return l.a(((PasswordAuthentication)localObject).getUserName(), new String(((PasswordAuthentication)localObject).getPassword()));
        }
      }
      return null;
    }
    
    public l b(Proxy paramAnonymousProxy, URL paramAnonymousURL, List paramAnonymousList)
    {
      paramAnonymousList = paramAnonymousList.iterator();
      while (paramAnonymousList.hasNext())
      {
        Object localObject = (k)paramAnonymousList.next();
        InetSocketAddress localInetSocketAddress = (InetSocketAddress)paramAnonymousProxy.address();
        localObject = Authenticator.requestPasswordAuthentication(localInetSocketAddress.getHostName(), a(paramAnonymousProxy, paramAnonymousURL), localInetSocketAddress.getPort(), paramAnonymousURL.getProtocol(), ((k)localObject).b(), ((k)localObject).a(), paramAnonymousURL, Authenticator.RequestorType.PROXY);
        if (localObject != null) {
          return l.a(((PasswordAuthentication)localObject).getUserName(), new String(((PasswordAuthentication)localObject).getPassword()));
        }
      }
      return null;
    }
  };
  
  private static List a(s params, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < params.e())
    {
      if (!paramString.equalsIgnoreCase(params.a(i))) {}
      label171:
      for (;;)
      {
        i += 1;
        break;
        String str1 = params.b(i);
        int j = 0;
        for (;;)
        {
          if (j >= str1.length()) {
            break label171;
          }
          int k = b.a(str1, j, " ");
          String str2 = str1.substring(j, k).trim();
          j = b.a(str1, k);
          if (!str1.regionMatches(j, "realm=\"", 0, "realm=\"".length())) {
            break;
          }
          j += "realm=\"".length();
          k = b.a(str1, j, "\"");
          String str3 = str1.substring(j, k);
          j = b.a(str1, b.a(str1, k + 1, ",") + 1);
          localArrayList.add(new k(str2, str3));
        }
      }
    }
    return localArrayList;
  }
  
  public static boolean a(j paramj, int paramInt, s params1, s params2, Proxy paramProxy, URL paramURL)
  {
    Object localObject;
    if (paramInt == 401) {
      localObject = "WWW-Authenticate";
    }
    for (String str = "Authorization";; str = "Proxy-Authorization")
    {
      localObject = a(params1, (String)localObject);
      if (!((List)localObject).isEmpty()) {
        break label61;
      }
      return false;
      if (paramInt != 407) {
        break;
      }
      localObject = "Proxy-Authenticate";
    }
    throw new IllegalArgumentException();
    label61:
    if (params1.c() == 407) {}
    for (paramj = paramj.b(paramProxy, paramURL, (List)localObject); paramj == null; paramj = paramj.a(paramProxy, paramURL, (List)localObject)) {
      return false;
    }
    params2.b(str, paramj.a());
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */