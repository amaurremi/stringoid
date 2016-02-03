package com.amazonaws.org.apache.http.client.utils;

import com.amazonaws.org.apache.http.HttpHost;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Stack;
import org.apache.http.annotation.Immutable;

@Immutable
public class URIUtils
{
  public static HttpHost extractHost(URI paramURI)
  {
    if (paramURI == null) {
      return null;
    }
    int i;
    Object localObject;
    int j;
    if (paramURI.isAbsolute())
    {
      i = paramURI.getPort();
      String str = paramURI.getHost();
      localObject = str;
      j = i;
      if (str == null)
      {
        str = paramURI.getAuthority();
        localObject = str;
        j = i;
        if (str != null)
        {
          j = str.indexOf('@');
          if (j < 0) {
            break label228;
          }
          if (str.length() > j + 1) {
            localObject = str.substring(j + 1);
          }
        }
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        int n = ((String)localObject).indexOf(':');
        if (n >= 0)
        {
          int m = n + 1;
          j = m;
          int k = 0;
          for (;;)
          {
            if ((j < ((String)localObject).length()) && (Character.isDigit(((String)localObject).charAt(j))))
            {
              k += 1;
              j += 1;
              continue;
              localObject = null;
              break;
            }
          }
          if (k > 0)
          {
            try
            {
              j = Integer.parseInt(((String)localObject).substring(m, m + k));
              i = j;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;) {}
            }
            localObject = ((String)localObject).substring(0, n);
          }
        }
      }
      for (j = i;; j = i)
      {
        paramURI = paramURI.getScheme();
        if (localObject != null) {}
        for (paramURI = new HttpHost((String)localObject, j, paramURI);; paramURI = null) {
          return paramURI;
        }
        break;
      }
      label228:
      localObject = localNumberFormatException;
    }
  }
  
  private static URI removeDotSegments(URI paramURI)
  {
    Object localObject1 = paramURI.getPath();
    if ((localObject1 == null) || (((String)localObject1).indexOf("/.") == -1)) {
      return paramURI;
    }
    localObject1 = ((String)localObject1).split("/");
    Object localObject2 = new Stack();
    int i = 0;
    if (i < localObject1.length)
    {
      if ((localObject1[i].length() == 0) || (".".equals(localObject1[i]))) {}
      for (;;)
      {
        i += 1;
        break;
        if ("..".equals(localObject1[i]))
        {
          if (!((Stack)localObject2).isEmpty()) {
            ((Stack)localObject2).pop();
          }
        }
        else {
          ((Stack)localObject2).push(localObject1[i]);
        }
      }
    }
    localObject1 = new StringBuilder();
    localObject2 = ((Stack)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      ((StringBuilder)localObject1).append('/').append(str);
    }
    try
    {
      paramURI = new URI(paramURI.getScheme(), paramURI.getAuthority(), ((StringBuilder)localObject1).toString(), paramURI.getQuery(), paramURI.getFragment());
      return paramURI;
    }
    catch (URISyntaxException paramURI)
    {
      throw new IllegalArgumentException(paramURI);
    }
  }
  
  public static URI resolve(URI paramURI1, URI paramURI2)
  {
    if (paramURI1 == null) {
      throw new IllegalArgumentException("Base URI may nor be null");
    }
    if (paramURI2 == null) {
      throw new IllegalArgumentException("Reference URI may nor be null");
    }
    String str = paramURI2.toString();
    if (str.startsWith("?")) {
      return resolveReferenceStartingWithQueryString(paramURI1, paramURI2);
    }
    if (str.length() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramURI2 = URI.create("#");
      }
      paramURI2 = paramURI1.resolve(paramURI2);
      paramURI1 = paramURI2;
      if (i != 0)
      {
        paramURI1 = paramURI2.toString();
        paramURI1 = URI.create(paramURI1.substring(0, paramURI1.indexOf('#')));
      }
      return removeDotSegments(paramURI1);
    }
  }
  
  private static URI resolveReferenceStartingWithQueryString(URI paramURI1, URI paramURI2)
  {
    String str = paramURI1.toString();
    paramURI1 = str;
    if (str.indexOf('?') > -1) {
      paramURI1 = str.substring(0, str.indexOf('?'));
    }
    return URI.create(paramURI1 + paramURI2.toString());
  }
  
  public static URI rewriteURI(URI paramURI)
  {
    if (paramURI == null) {
      throw new IllegalArgumentException("URI may not be null");
    }
    URI localURI;
    if ((paramURI.getFragment() == null) && (paramURI.getUserInfo() == null) && (paramURI.getPath() != null))
    {
      localURI = paramURI;
      if (paramURI.getPath().length() != 0) {}
    }
    else
    {
      paramURI = new URIBuilder(paramURI);
      paramURI.setFragment(null).setUserInfo(null);
      if ((paramURI.getPath() == null) || (paramURI.getPath().length() == 0)) {
        paramURI.setPath("/");
      }
      localURI = paramURI.build();
    }
    return localURI;
  }
  
  public static URI rewriteURI(URI paramURI, HttpHost paramHttpHost, boolean paramBoolean)
  {
    if (paramURI == null) {
      throw new IllegalArgumentException("URI may not be null");
    }
    paramURI = new URIBuilder(paramURI);
    if (paramHttpHost != null)
    {
      paramURI.setScheme(paramHttpHost.getSchemeName());
      paramURI.setHost(paramHttpHost.getHostName());
      paramURI.setPort(paramHttpHost.getPort());
    }
    for (;;)
    {
      if (paramBoolean) {
        paramURI.setFragment(null);
      }
      if ((paramURI.getPath() == null) || (paramURI.getPath().length() == 0)) {
        paramURI.setPath("/");
      }
      return paramURI.build();
      paramURI.setScheme(null);
      paramURI.setHost(null);
      paramURI.setPort(-1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/client/utils/URIUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */