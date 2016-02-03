package com.amazonaws.org.apache.http.conn.ssl;

import com.amazonaws.org.apache.http.conn.util.InetAddressUtils;
import java.io.InputStream;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.security.auth.x500.X500Principal;
import org.apache.http.annotation.Immutable;

@Immutable
public abstract class AbstractVerifier
  implements X509HostnameVerifier
{
  private static final String[] BAD_COUNTRY_2LDS = { "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org" };
  
  static
  {
    Arrays.sort(BAD_COUNTRY_2LDS);
  }
  
  public static boolean acceptableCountryWildcard(String paramString)
  {
    paramString = paramString.split("\\.");
    if ((paramString.length != 3) || (paramString[2].length() != 2)) {}
    while (Arrays.binarySearch(BAD_COUNTRY_2LDS, paramString[1]) < 0) {
      return true;
    }
    return false;
  }
  
  public static int countDots(String paramString)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramString.length(); j = k)
    {
      k = j;
      if (paramString.charAt(i) == '.') {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public static String[] getCNs(X509Certificate paramX509Certificate)
  {
    LinkedList localLinkedList = new LinkedList();
    paramX509Certificate = new StringTokenizer(paramX509Certificate.getSubjectX500Principal().toString(), ",");
    while (paramX509Certificate.hasMoreTokens())
    {
      String str = paramX509Certificate.nextToken().trim();
      if ((str.length() > 3) && (str.substring(0, 3).equalsIgnoreCase("CN="))) {
        localLinkedList.add(str.substring(3));
      }
    }
    if (!localLinkedList.isEmpty())
    {
      paramX509Certificate = new String[localLinkedList.size()];
      localLinkedList.toArray(paramX509Certificate);
      return paramX509Certificate;
    }
    return null;
  }
  
  private static String[] getSubjectAlts(X509Certificate paramX509Certificate, String paramString)
  {
    int i;
    if (isIPAddress(paramString)) {
      i = 7;
    }
    for (;;)
    {
      paramString = new LinkedList();
      try
      {
        paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
        if (paramX509Certificate != null)
        {
          paramX509Certificate = paramX509Certificate.iterator();
          while (paramX509Certificate.hasNext())
          {
            List localList = (List)paramX509Certificate.next();
            if (((Integer)localList.get(0)).intValue() == i)
            {
              paramString.add((String)localList.get(1));
              continue;
              i = 2;
            }
          }
        }
      }
      catch (CertificateParsingException paramX509Certificate)
      {
        for (;;)
        {
          paramX509Certificate = null;
        }
        if (!paramString.isEmpty())
        {
          paramX509Certificate = new String[paramString.size()];
          paramString.toArray(paramX509Certificate);
          return paramX509Certificate;
        }
      }
    }
    return null;
  }
  
  private static boolean isIPAddress(String paramString)
  {
    return (paramString != null) && ((InetAddressUtils.isIPv4Address(paramString)) || (InetAddressUtils.isIPv6Address(paramString)));
  }
  
  public final void verify(String paramString, X509Certificate paramX509Certificate)
  {
    verify(paramString, getCNs(paramX509Certificate), getSubjectAlts(paramX509Certificate, paramString));
  }
  
  public final void verify(String paramString, SSLSocket paramSSLSocket)
  {
    if (paramString == null) {
      throw new NullPointerException("host to verify is null");
    }
    SSLSession localSSLSession2 = paramSSLSocket.getSession();
    SSLSession localSSLSession1 = localSSLSession2;
    if (localSSLSession2 == null)
    {
      paramSSLSocket.getInputStream().available();
      localSSLSession2 = paramSSLSocket.getSession();
      localSSLSession1 = localSSLSession2;
      if (localSSLSession2 == null)
      {
        paramSSLSocket.startHandshake();
        localSSLSession1 = paramSSLSocket.getSession();
      }
    }
    verify(paramString, (X509Certificate)localSSLSession1.getPeerCertificates()[0]);
  }
  
  public final void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean)
  {
    Object localObject1 = new LinkedList();
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length > 0) && (paramArrayOfString1[0] != null)) {
      ((LinkedList)localObject1).add(paramArrayOfString1[0]);
    }
    int i;
    if (paramArrayOfString2 != null)
    {
      int j = paramArrayOfString2.length;
      i = 0;
      while (i < j)
      {
        paramArrayOfString1 = paramArrayOfString2[i];
        if (paramArrayOfString1 != null) {
          ((LinkedList)localObject1).add(paramArrayOfString1);
        }
        i += 1;
      }
    }
    if (((LinkedList)localObject1).isEmpty()) {
      throw new SSLException("Certificate for <" + paramString + "> doesn't contain CN or DNS subjectAlt");
    }
    paramArrayOfString1 = new StringBuilder();
    paramArrayOfString2 = paramString.trim().toLowerCase(Locale.US);
    localObject1 = ((LinkedList)localObject1).iterator();
    boolean bool2 = false;
    boolean bool1 = bool2;
    String str1;
    if (((Iterator)localObject1).hasNext())
    {
      str1 = ((String)((Iterator)localObject1).next()).toLowerCase(Locale.US);
      paramArrayOfString1.append(" <");
      paramArrayOfString1.append(str1);
      paramArrayOfString1.append('>');
      if (((Iterator)localObject1).hasNext()) {
        paramArrayOfString1.append(" OR");
      }
      Object localObject2 = str1.split("\\.");
      if ((localObject2.length < 3) || (!localObject2[0].endsWith("*")) || (!acceptableCountryWildcard(str1)) || (isIPAddress(paramString))) {
        break label428;
      }
      i = 1;
      label263:
      if (i == 0) {
        break label461;
      }
      String str2 = localObject2[0];
      if (str2.length() <= 1) {
        break label440;
      }
      localObject2 = str2.substring(0, str2.length() - 1);
      str2 = str1.substring(str2.length());
      String str3 = paramArrayOfString2.substring(((String)localObject2).length());
      if ((!paramArrayOfString2.startsWith((String)localObject2)) || (!str3.endsWith(str2))) {
        break label434;
      }
      bool2 = true;
      label343:
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (paramBoolean)
        {
          if (countDots(paramArrayOfString2) != countDots(str1)) {
            break label455;
          }
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      if (bool1) {
        return;
      }
      throw new SSLException("hostname in certificate didn't match: <" + paramString + "> !=" + paramArrayOfString1);
      label428:
      i = 0;
      break label263;
      label434:
      bool2 = false;
      break label343;
      label440:
      bool2 = paramArrayOfString2.endsWith(str1.substring(1));
      break label343;
      label455:
      bool1 = false;
      continue;
      label461:
      bool1 = paramArrayOfString2.equals(str1);
    }
  }
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      verify(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
      return true;
    }
    catch (SSLException paramString) {}
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/conn/ssl/AbstractVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */