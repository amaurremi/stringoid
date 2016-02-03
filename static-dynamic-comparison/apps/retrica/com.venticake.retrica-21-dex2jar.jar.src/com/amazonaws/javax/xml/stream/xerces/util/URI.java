package com.amazonaws.javax.xml.stream.xerces.util;

import java.io.Serializable;

public class URI
  implements Serializable
{
  private static boolean DEBUG = false;
  private String m_fragment = null;
  private String m_host = null;
  private String m_path = null;
  private int m_port = -1;
  private String m_queryString = null;
  private String m_scheme = null;
  private String m_userinfo = null;
  
  public URI() {}
  
  public URI(URI paramURI, String paramString)
  {
    initialize(paramURI, paramString);
  }
  
  public URI(String paramString)
  {
    this((URI)null, paramString);
  }
  
  public URI(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6)
  {
    if ((paramString1 == null) || (paramString1.trim().length() == 0)) {
      throw new URI.MalformedURIException("Scheme is required!");
    }
    if (paramString3 == null)
    {
      if (paramString2 != null) {
        throw new URI.MalformedURIException("Userinfo may not be specified if host is not specified!");
      }
      if (paramInt != -1) {
        throw new URI.MalformedURIException("Port may not be specified if host is not specified!");
      }
    }
    if (paramString4 != null)
    {
      if ((paramString4.indexOf('?') != -1) && (paramString5 != null)) {
        throw new URI.MalformedURIException("Query string cannot be specified in path and query string!");
      }
      if ((paramString4.indexOf('#') != -1) && (paramString6 != null)) {
        throw new URI.MalformedURIException("Fragment cannot be specified in both the path and fragment!");
      }
    }
    setScheme(paramString1);
    setHost(paramString3);
    setPort(paramInt);
    setUserinfo(paramString2);
    setPath(paramString4);
    setQueryString(paramString5);
    setFragment(paramString6);
  }
  
  public URI(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, null, paramString2, -1, paramString3, paramString4, paramString5);
  }
  
  private void initialize(URI paramURI)
  {
    this.m_scheme = paramURI.getScheme();
    this.m_userinfo = paramURI.getUserinfo();
    this.m_host = paramURI.getHost();
    this.m_port = paramURI.getPort();
    this.m_path = paramURI.getPath();
    this.m_queryString = paramURI.getQueryString();
    this.m_fragment = paramURI.getFragment();
  }
  
  private void initialize(URI paramURI, String paramString)
  {
    if ((paramURI == null) && ((paramString == null) || (paramString.trim().length() == 0))) {
      throw new URI.MalformedURIException("Cannot initialize URI with empty parameters.");
    }
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      initialize(paramURI);
      return;
    }
    paramString = paramString.trim();
    int k = paramString.length();
    int i = paramString.indexOf(':');
    int j = paramString.indexOf('/');
    int m = paramString.indexOf('?');
    int n = paramString.indexOf('#');
    if ((i < 2) || ((i > j) && (j != -1)) || ((i > m) && (m != -1)) || ((i > n) && (n != -1)))
    {
      if ((paramURI == null) && (n != 0)) {
        throw new URI.MalformedURIException("No scheme found in URI.");
      }
    }
    else {
      initializeScheme(paramString);
    }
    for (i = this.m_scheme.length() + 1;; i = 0)
    {
      j = i;
      if (i + 1 < k)
      {
        j = i;
        if (paramString.substring(i).startsWith("//"))
        {
          j = i + 2;
          i = j;
          label200:
          if (i < k)
          {
            m = paramString.charAt(i);
            if ((m != 47) && (m != 63) && (m != 35)) {
              break label348;
            }
          }
          if (i <= j) {
            break label355;
          }
          initializeAuthority(paramString.substring(j, i));
        }
      }
      for (j = i;; j = i)
      {
        initializePath(paramString.substring(j));
        if (paramURI == null) {
          break;
        }
        if ((this.m_path.length() != 0) || (this.m_scheme != null) || (this.m_host != null)) {
          break label367;
        }
        this.m_scheme = paramURI.getScheme();
        this.m_userinfo = paramURI.getUserinfo();
        this.m_host = paramURI.getHost();
        this.m_port = paramURI.getPort();
        this.m_path = paramURI.getPath();
        if (this.m_queryString != null) {
          break;
        }
        this.m_queryString = paramURI.getQueryString();
        return;
        label348:
        i += 1;
        break label200;
        label355:
        this.m_host = "";
      }
      label367:
      if (this.m_scheme != null) {
        break;
      }
      this.m_scheme = paramURI.getScheme();
      if (this.m_host != null) {
        break;
      }
      this.m_userinfo = paramURI.getUserinfo();
      this.m_host = paramURI.getHost();
      this.m_port = paramURI.getPort();
      if ((this.m_path.length() > 0) && (this.m_path.startsWith("/"))) {
        break;
      }
      paramString = new String();
      String str = paramURI.getPath();
      paramURI = paramString;
      if (str != null)
      {
        i = str.lastIndexOf('/');
        paramURI = paramString;
        if (i != -1) {
          paramURI = str.substring(0, i + 1);
        }
      }
      for (paramURI = paramURI.concat(this.m_path);; paramURI = paramURI.substring(0, i + 1).concat(paramURI.substring(i + 3)))
      {
        i = paramURI.indexOf("/./");
        if (i == -1) {
          break;
        }
      }
      paramString = paramURI;
      if (paramURI.endsWith("/.")) {
        paramString = paramURI.substring(0, paramURI.length() - 1);
      }
      i = 1;
      paramURI = paramString;
      for (;;)
      {
        j = paramURI.indexOf("/../", i);
        if (j <= 0) {
          break;
        }
        paramString = paramURI.substring(0, paramURI.indexOf("/../"));
        i = paramString.lastIndexOf('/');
        if (i != -1)
        {
          if (!paramString.substring(i).equals("..")) {
            paramURI = paramURI.substring(0, i + 1).concat(paramURI.substring(j + 4));
          } else {
            i = j + 4;
          }
        }
        else {
          i = j + 4;
        }
      }
      paramString = paramURI;
      if (paramURI.endsWith("/.."))
      {
        i = paramURI.substring(0, paramURI.length() - 3).lastIndexOf('/');
        paramString = paramURI;
        if (i != -1) {
          paramString = paramURI.substring(0, i + 1);
        }
      }
      this.m_path = paramString;
      return;
    }
  }
  
  private void initializeAuthority(String paramString)
  {
    int m = 0;
    int n = paramString.length();
    String str1 = null;
    int j;
    int k;
    if (paramString.indexOf('@', 0) != -1)
    {
      i = 0;
      j = 0;
      if (j < n)
      {
        i = paramString.charAt(j);
        if (i != 64) {}
      }
      else
      {
        str1 = paramString.substring(0, j);
        k = j + 1;
        j = i;
      }
    }
    for (int i = k;; i = 0)
    {
      k = i;
      String str2;
      for (;;)
      {
        if (k < n)
        {
          j = paramString.charAt(k);
          if (j != 58) {}
        }
        else
        {
          str2 = paramString.substring(i, k);
          if ((str2.length() <= 0) || (j != 58)) {
            break label244;
          }
          j = k + 1;
          i = j;
          while (i < n) {
            i += 1;
          }
          j += 1;
          break;
        }
        k += 1;
      }
      paramString = paramString.substring(j, i);
      if (paramString.length() > 0)
      {
        i = m;
        while (i < paramString.length())
        {
          if (!isDigit(paramString.charAt(i))) {
            throw new URI.MalformedURIException(paramString + " is invalid. Port should only contain digits!");
          }
          i += 1;
        }
      }
      for (;;)
      {
        try
        {
          i = Integer.parseInt(paramString);
          setHost(str2);
          setPort(i);
          setUserinfo(str1);
          return;
        }
        catch (NumberFormatException paramString)
        {
          i = -1;
          continue;
        }
        label244:
        i = -1;
      }
      j = 0;
    }
  }
  
  private void initializePath(String paramString)
  {
    if (paramString == null) {
      throw new URI.MalformedURIException("Cannot initialize path from null string!");
    }
    int i1 = paramString.length();
    int j = 0;
    int k = 0;
    int i;
    if (k < i1)
    {
      i = paramString.charAt(k);
      j = i;
      if (i != 63)
      {
        if (i != 35) {
          break label208;
        }
        j = i;
      }
    }
    this.m_path = paramString.substring(0, k);
    int n = j;
    int m = k;
    if (j == 63)
    {
      m = k + 1;
      k = m;
      label89:
      if (k < i1)
      {
        i = paramString.charAt(k);
        if (i == 35) {
          j = i;
        }
      }
      else
      {
        this.m_queryString = paramString.substring(m, k);
        m = k;
        n = j;
      }
    }
    else
    {
      if (n != 35) {
        return;
      }
      k = m + 1;
      j = k;
    }
    for (;;)
    {
      if (j >= i1) {
        break label466;
      }
      i = paramString.charAt(j);
      if (i == 37)
      {
        if ((j + 2 < i1) && (isHex(paramString.charAt(j + 1))) && (isHex(paramString.charAt(j + 2)))) {
          break label459;
        }
        throw new URI.MalformedURIException("Fragment contains invalid escape sequence!");
        label208:
        if (i == 37)
        {
          if ((k + 2 >= i1) || (!isHex(paramString.charAt(k + 1))) || (!isHex(paramString.charAt(k + 2)))) {
            throw new URI.MalformedURIException("Path contains invalid escape sequence!");
          }
        }
        else if ((!isReservedCharacter(i)) && (!isUnreservedCharacter(i))) {
          throw new URI.MalformedURIException("Path contains invalid character: " + i);
        }
        k += 1;
        j = i;
        break;
        if (i == 37)
        {
          if ((k + 2 >= i1) || (!isHex(paramString.charAt(k + 1))) || (!isHex(paramString.charAt(k + 2)))) {
            throw new URI.MalformedURIException("Query string contains invalid escape sequence!");
          }
        }
        else if ((!isReservedCharacter(i)) && (!isUnreservedCharacter(i))) {
          throw new URI.MalformedURIException("Query string contains invalid character:" + i);
        }
        k += 1;
        j = i;
        break label89;
      }
      if ((!isReservedCharacter(i)) && (!isUnreservedCharacter(i))) {
        throw new URI.MalformedURIException("Fragment contains invalid character:" + i);
      }
      label459:
      j += 1;
    }
    label466:
    this.m_fragment = paramString.substring(k, j);
  }
  
  private void initializeScheme(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        int k = paramString.charAt(i);
        if ((k != 58) && (k != 47) && (k != 63) && (k != 35)) {}
      }
      else
      {
        paramString = paramString.substring(0, i);
        if (paramString.length() != 0) {
          break;
        }
        throw new URI.MalformedURIException("No scheme found in URI.");
      }
      i += 1;
    }
    setScheme(paramString);
  }
  
  private static boolean isAlpha(char paramChar)
  {
    return ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }
  
  private static boolean isAlphanum(char paramChar)
  {
    return (isAlpha(paramChar)) || (isDigit(paramChar));
  }
  
  public static boolean isConformantSchemeName(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      bool1 = false;
      return bool1;
    }
    if (!isAlpha(paramString.charAt(0))) {
      return false;
    }
    int i = 1;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramString.length()) {
        break;
      }
      char c = paramString.charAt(i);
      if ((!isAlphanum(c)) && ("+-.".indexOf(c) == -1)) {
        return false;
      }
      i += 1;
    }
  }
  
  private static boolean isDigit(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  private static boolean isHex(char paramChar)
  {
    return (isDigit(paramChar)) || ((paramChar >= 'a') && (paramChar <= 'f')) || ((paramChar >= 'A') && (paramChar <= 'F'));
  }
  
  private static boolean isReservedCharacter(char paramChar)
  {
    return ";/?:@&=+$,[]".indexOf(paramChar) != -1;
  }
  
  private static boolean isURIString(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int k = paramString.length();
    int i = 0;
    if (i < k)
    {
      char c = paramString.charAt(i);
      int j;
      if (c == '%')
      {
        if ((i + 2 >= k) || (!isHex(paramString.charAt(i + 1))) || (!isHex(paramString.charAt(i + 2)))) {
          return false;
        }
        j = i + 2;
      }
      do
      {
        do
        {
          i = j + 1;
          break;
          j = i;
        } while (isReservedCharacter(c));
        j = i;
      } while (isUnreservedCharacter(c));
      return false;
    }
    return true;
  }
  
  private static boolean isUnreservedCharacter(char paramChar)
  {
    return (isAlphanum(paramChar)) || ("-_.!~*'()".indexOf(paramChar) != -1);
  }
  
  public static boolean isWellFormedAddress(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    String str = paramString.trim();
    int k = str.length();
    if ((k == 0) || (k > 255)) {
      return false;
    }
    if ((str.startsWith(".")) || (str.startsWith("-"))) {
      return false;
    }
    int j = str.lastIndexOf('.');
    int i = j;
    if (str.endsWith(".")) {
      i = str.substring(0, j).lastIndexOf('.');
    }
    char c;
    if ((i + 1 < k) && (isDigit(paramString.charAt(i + 1))))
    {
      i = 0;
      j = 0;
      if (i < k)
      {
        c = str.charAt(i);
        if (c == '.')
        {
          if ((!isDigit(str.charAt(i - 1))) || ((i + 1 < k) && (!isDigit(str.charAt(i + 1))))) {
            return false;
          }
          j += 1;
        }
        while (isDigit(c))
        {
          i += 1;
          break;
        }
        return false;
      }
      if (j != 3) {
        return false;
      }
    }
    else
    {
      i = 0;
      while (i < k)
      {
        c = str.charAt(i);
        if (c == '.')
        {
          if (!isAlphanum(str.charAt(i - 1))) {
            return false;
          }
          if ((i + 1 < k) && (!isAlphanum(str.charAt(i + 1)))) {
            return false;
          }
        }
        else if ((!isAlphanum(c)) && (c != '-'))
        {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof URI))
    {
      paramObject = (URI)paramObject;
      if (((this.m_scheme == null) && (((URI)paramObject).m_scheme == null)) || ((this.m_scheme != null) && (((URI)paramObject).m_scheme != null) && (this.m_scheme.equals(((URI)paramObject).m_scheme)) && (((this.m_userinfo == null) && (((URI)paramObject).m_userinfo == null)) || ((this.m_userinfo != null) && (((URI)paramObject).m_userinfo != null) && (this.m_userinfo.equals(((URI)paramObject).m_userinfo)) && (((this.m_host == null) && (((URI)paramObject).m_host == null)) || ((this.m_host != null) && (((URI)paramObject).m_host != null) && (this.m_host.equals(((URI)paramObject).m_host)) && (this.m_port == ((URI)paramObject).m_port) && (((this.m_path == null) && (((URI)paramObject).m_path == null)) || ((this.m_path != null) && (((URI)paramObject).m_path != null) && (this.m_path.equals(((URI)paramObject).m_path)) && (((this.m_queryString == null) && (((URI)paramObject).m_queryString == null)) || ((this.m_queryString != null) && (((URI)paramObject).m_queryString != null) && (this.m_queryString.equals(((URI)paramObject).m_queryString)) && (((this.m_fragment == null) && (((URI)paramObject).m_fragment == null)) || ((this.m_fragment != null) && (((URI)paramObject).m_fragment != null) && (this.m_fragment.equals(((URI)paramObject).m_fragment)))))))))))))) {
        return true;
      }
    }
    return false;
  }
  
  public String getFragment()
  {
    return this.m_fragment;
  }
  
  public String getHost()
  {
    return this.m_host;
  }
  
  public String getPath()
  {
    return this.m_path;
  }
  
  public int getPort()
  {
    return this.m_port;
  }
  
  public String getQueryString()
  {
    return this.m_queryString;
  }
  
  public String getScheme()
  {
    return this.m_scheme;
  }
  
  public String getSchemeSpecificPart()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((this.m_userinfo != null) || (this.m_host != null) || (this.m_port != -1)) {
      localStringBuffer.append("//");
    }
    if (this.m_userinfo != null)
    {
      localStringBuffer.append(this.m_userinfo);
      localStringBuffer.append('@');
    }
    if (this.m_host != null) {
      localStringBuffer.append(this.m_host);
    }
    if (this.m_port != -1)
    {
      localStringBuffer.append(':');
      localStringBuffer.append(this.m_port);
    }
    if (this.m_path != null) {
      localStringBuffer.append(this.m_path);
    }
    if (this.m_queryString != null)
    {
      localStringBuffer.append('?');
      localStringBuffer.append(this.m_queryString);
    }
    if (this.m_fragment != null)
    {
      localStringBuffer.append('#');
      localStringBuffer.append(this.m_fragment);
    }
    return localStringBuffer.toString();
  }
  
  public String getUserinfo()
  {
    return this.m_userinfo;
  }
  
  public boolean isGenericURI()
  {
    return this.m_host != null;
  }
  
  public void setFragment(String paramString)
  {
    if (paramString == null)
    {
      this.m_fragment = null;
      return;
    }
    if (!isGenericURI()) {
      throw new URI.MalformedURIException("Fragment can only be set for a generic URI!");
    }
    if (getPath() == null) {
      throw new URI.MalformedURIException("Fragment cannot be set when path is null!");
    }
    if (!isURIString(paramString)) {
      throw new URI.MalformedURIException("Fragment contains invalid character!");
    }
    this.m_fragment = paramString;
  }
  
  public void setHost(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.m_host = paramString;
      this.m_userinfo = null;
      this.m_port = -1;
    }
    while (isWellFormedAddress(paramString))
    {
      this.m_host = paramString;
      return;
    }
    throw new URI.MalformedURIException("Host is not a well formed address!");
  }
  
  public void setPath(String paramString)
  {
    if (paramString == null)
    {
      this.m_path = null;
      this.m_queryString = null;
      this.m_fragment = null;
      return;
    }
    initializePath(paramString);
  }
  
  public void setPort(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 65535))
    {
      if (this.m_host == null) {
        throw new URI.MalformedURIException("Port cannot be set when host is null!");
      }
    }
    else if (paramInt != -1) {
      throw new URI.MalformedURIException("Invalid port number!");
    }
    this.m_port = paramInt;
  }
  
  public void setQueryString(String paramString)
  {
    if (paramString == null)
    {
      this.m_queryString = null;
      return;
    }
    if (!isGenericURI()) {
      throw new URI.MalformedURIException("Query string can only be set for a generic URI!");
    }
    if (getPath() == null) {
      throw new URI.MalformedURIException("Query string cannot be set when path is null!");
    }
    if (!isURIString(paramString)) {
      throw new URI.MalformedURIException("Query string contains invalid character!");
    }
    this.m_queryString = paramString;
  }
  
  public void setScheme(String paramString)
  {
    if (paramString == null) {
      throw new URI.MalformedURIException("Cannot set scheme from null string!");
    }
    if (!isConformantSchemeName(paramString)) {
      throw new URI.MalformedURIException("The scheme is not conformant.");
    }
    this.m_scheme = paramString.toLowerCase();
  }
  
  public void setUserinfo(String paramString)
  {
    if (paramString == null) {
      this.m_userinfo = null;
    }
    for (;;)
    {
      this.m_userinfo = paramString;
      return;
      if (this.m_host == null) {
        throw new URI.MalformedURIException("Userinfo cannot be set when host is null!");
      }
      int i = 0;
      int j = paramString.length();
      while (i < j)
      {
        char c = paramString.charAt(i);
        if (c == '%')
        {
          if ((i + 2 >= j) || (!isHex(paramString.charAt(i + 1))) || (!isHex(paramString.charAt(i + 2)))) {
            throw new URI.MalformedURIException("Userinfo contains invalid escape sequence!");
          }
        }
        else if ((!isUnreservedCharacter(c)) && (";:&=+$,".indexOf(c) == -1)) {
          throw new URI.MalformedURIException("Userinfo contains invalid character:" + c);
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.m_scheme != null)
    {
      localStringBuffer.append(this.m_scheme);
      localStringBuffer.append(':');
    }
    localStringBuffer.append(getSchemeSpecificPart());
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/util/URI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */