package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.cookie.ClientCookie;
import com.amazonaws.org.apache.http.cookie.Cookie;
import com.amazonaws.org.apache.http.cookie.CookieOrigin;
import com.amazonaws.org.apache.http.cookie.CookiePathComparator;
import com.amazonaws.org.apache.http.cookie.CookieRestrictionViolationException;
import com.amazonaws.org.apache.http.cookie.MalformedCookieException;
import com.amazonaws.org.apache.http.message.BufferedHeader;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class RFC2109Spec
  extends CookieSpecBase
{
  private static final String[] DATE_PATTERNS = { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy" };
  private static final CookiePathComparator PATH_COMPARATOR = new CookiePathComparator();
  private final String[] datepatterns;
  private final boolean oneHeader;
  
  public RFC2109Spec()
  {
    this(null, false);
  }
  
  public RFC2109Spec(String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString != null) {}
    for (this.datepatterns = ((String[])paramArrayOfString.clone());; this.datepatterns = DATE_PATTERNS)
    {
      this.oneHeader = paramBoolean;
      registerAttribHandler("version", new RFC2109VersionHandler());
      registerAttribHandler("path", new BasicPathHandler());
      registerAttribHandler("domain", new RFC2109DomainHandler());
      registerAttribHandler("max-age", new BasicMaxAgeHandler());
      registerAttribHandler("secure", new BasicSecureHandler());
      registerAttribHandler("comment", new BasicCommentHandler());
      registerAttribHandler("expires", new BasicExpiresHandler(this.datepatterns));
      return;
    }
  }
  
  private List<Header> doFormatManyHeaders(List<Cookie> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Cookie localCookie = (Cookie)paramList.next();
      int i = localCookie.getVersion();
      CharArrayBuffer localCharArrayBuffer = new CharArrayBuffer(40);
      localCharArrayBuffer.append("Cookie: ");
      localCharArrayBuffer.append("$Version=");
      localCharArrayBuffer.append(Integer.toString(i));
      localCharArrayBuffer.append("; ");
      formatCookieAsVer(localCharArrayBuffer, localCookie, i);
      localArrayList.add(new BufferedHeader(localCharArrayBuffer));
    }
    return localArrayList;
  }
  
  private List<Header> doFormatOneHeader(List<Cookie> paramList)
  {
    Object localObject = paramList.iterator();
    int i = Integer.MAX_VALUE;
    Cookie localCookie;
    if (((Iterator)localObject).hasNext())
    {
      localCookie = (Cookie)((Iterator)localObject).next();
      if (localCookie.getVersion() >= i) {
        break label165;
      }
      i = localCookie.getVersion();
    }
    label165:
    for (;;)
    {
      break;
      localObject = new CharArrayBuffer(paramList.size() * 40);
      ((CharArrayBuffer)localObject).append("Cookie");
      ((CharArrayBuffer)localObject).append(": ");
      ((CharArrayBuffer)localObject).append("$Version=");
      ((CharArrayBuffer)localObject).append(Integer.toString(i));
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localCookie = (Cookie)paramList.next();
        ((CharArrayBuffer)localObject).append("; ");
        formatCookieAsVer((CharArrayBuffer)localObject, localCookie, i);
      }
      paramList = new ArrayList(1);
      paramList.add(new BufferedHeader((CharArrayBuffer)localObject));
      return paramList;
    }
  }
  
  protected void formatCookieAsVer(CharArrayBuffer paramCharArrayBuffer, Cookie paramCookie, int paramInt)
  {
    formatParamAsVer(paramCharArrayBuffer, paramCookie.getName(), paramCookie.getValue(), paramInt);
    if ((paramCookie.getPath() != null) && ((paramCookie instanceof ClientCookie)) && (((ClientCookie)paramCookie).containsAttribute("path")))
    {
      paramCharArrayBuffer.append("; ");
      formatParamAsVer(paramCharArrayBuffer, "$Path", paramCookie.getPath(), paramInt);
    }
    if ((paramCookie.getDomain() != null) && ((paramCookie instanceof ClientCookie)) && (((ClientCookie)paramCookie).containsAttribute("domain")))
    {
      paramCharArrayBuffer.append("; ");
      formatParamAsVer(paramCharArrayBuffer, "$Domain", paramCookie.getDomain(), paramInt);
    }
  }
  
  public List<Header> formatCookies(List<Cookie> paramList)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("List of cookies may not be null");
    }
    if (paramList.isEmpty()) {
      throw new IllegalArgumentException("List of cookies may not be empty");
    }
    Object localObject = paramList;
    if (paramList.size() > 1)
    {
      localObject = new ArrayList(paramList);
      Collections.sort((List)localObject, PATH_COMPARATOR);
    }
    if (this.oneHeader) {
      return doFormatOneHeader((List)localObject);
    }
    return doFormatManyHeaders((List)localObject);
  }
  
  protected void formatParamAsVer(CharArrayBuffer paramCharArrayBuffer, String paramString1, String paramString2, int paramInt)
  {
    paramCharArrayBuffer.append(paramString1);
    paramCharArrayBuffer.append("=");
    if (paramString2 != null)
    {
      if (paramInt > 0)
      {
        paramCharArrayBuffer.append('"');
        paramCharArrayBuffer.append(paramString2);
        paramCharArrayBuffer.append('"');
      }
    }
    else {
      return;
    }
    paramCharArrayBuffer.append(paramString2);
  }
  
  public int getVersion()
  {
    return 1;
  }
  
  public Header getVersionHeader()
  {
    return null;
  }
  
  public List<Cookie> parse(Header paramHeader, CookieOrigin paramCookieOrigin)
  {
    if (paramHeader == null) {
      throw new IllegalArgumentException("Header may not be null");
    }
    if (paramCookieOrigin == null) {
      throw new IllegalArgumentException("Cookie origin may not be null");
    }
    if (!paramHeader.getName().equalsIgnoreCase("Set-Cookie")) {
      throw new MalformedCookieException("Unrecognized cookie header '" + paramHeader.toString() + "'");
    }
    return parse(paramHeader.getElements(), paramCookieOrigin);
  }
  
  public String toString()
  {
    return "rfc2109";
  }
  
  public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin)
  {
    if (paramCookie == null) {
      throw new IllegalArgumentException("Cookie may not be null");
    }
    String str = paramCookie.getName();
    if (str.indexOf(' ') != -1) {
      throw new CookieRestrictionViolationException("Cookie name may not contain blanks");
    }
    if (str.startsWith("$")) {
      throw new CookieRestrictionViolationException("Cookie name may not start with $");
    }
    super.validate(paramCookie, paramCookieOrigin);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/RFC2109Spec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */