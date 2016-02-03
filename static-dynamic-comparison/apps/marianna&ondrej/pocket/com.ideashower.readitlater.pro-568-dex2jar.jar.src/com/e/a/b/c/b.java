package com.e.a.b.c;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public final class b
  implements HostnameVerifier
{
  public static final b a = new b();
  private static final Pattern b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
  
  private List a(X509Certificate paramX509Certificate, int paramInt)
  {
    localArrayList = new ArrayList();
    try
    {
      paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
      if (paramX509Certificate == null) {
        return Collections.emptyList();
      }
      paramX509Certificate = paramX509Certificate.iterator();
      while (paramX509Certificate.hasNext())
      {
        Object localObject = (List)paramX509Certificate.next();
        if ((localObject != null) && (((List)localObject).size() >= 2))
        {
          Integer localInteger = (Integer)((List)localObject).get(0);
          if ((localInteger != null) && (localInteger.intValue() == paramInt))
          {
            localObject = (String)((List)localObject).get(1);
            if (localObject != null) {
              localArrayList.add(localObject);
            }
          }
        }
      }
      return localArrayList;
    }
    catch (CertificateParsingException paramX509Certificate)
    {
      return Collections.emptyList();
    }
  }
  
  static boolean a(String paramString)
  {
    return b.matcher(paramString).matches();
  }
  
  private boolean b(String paramString, X509Certificate paramX509Certificate)
  {
    paramX509Certificate = a(paramX509Certificate, 7).iterator();
    while (paramX509Certificate.hasNext()) {
      if (paramString.equalsIgnoreCase((String)paramX509Certificate.next())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean c(String paramString, X509Certificate paramX509Certificate)
  {
    paramString = paramString.toLowerCase(Locale.US);
    Iterator localIterator = a(paramX509Certificate, 2).iterator();
    for (int i = 0; localIterator.hasNext(); i = 1) {
      if (a(paramString, (String)localIterator.next())) {
        return true;
      }
    }
    if (i == 0)
    {
      paramX509Certificate = new a(paramX509Certificate.getSubjectX500Principal()).a("cn");
      if (paramX509Certificate != null) {
        return a(paramString, paramX509Certificate);
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {
      bool1 = false;
    }
    int i;
    int j;
    int k;
    do
    {
      do
      {
        return bool1;
        paramString2 = paramString2.toLowerCase(Locale.US);
        if (!paramString2.contains("*")) {
          return paramString1.equals(paramString2);
        }
        if (!paramString2.startsWith("*.")) {
          break;
        }
        bool1 = bool2;
      } while (paramString1.regionMatches(0, paramString2, 2, paramString2.length() - 2));
      i = paramString2.indexOf('*');
      if (i > paramString2.indexOf('.')) {
        return false;
      }
      if (!paramString1.regionMatches(0, paramString2, 0, i)) {
        return false;
      }
      j = paramString2.length() - (i + 1);
      k = paramString1.length() - j;
      if ((paramString1.indexOf('.', i) < k) && (!paramString1.endsWith(".clients.google.com"))) {
        return false;
      }
      bool1 = bool2;
    } while (paramString1.regionMatches(k, paramString2, i + 1, j));
    return false;
  }
  
  public boolean a(String paramString, X509Certificate paramX509Certificate)
  {
    if (a(paramString)) {
      return b(paramString, paramX509Certificate);
    }
    return c(paramString, paramX509Certificate);
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      boolean bool = a(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
      return bool;
    }
    catch (SSLException paramString) {}
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/e/a/b/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */