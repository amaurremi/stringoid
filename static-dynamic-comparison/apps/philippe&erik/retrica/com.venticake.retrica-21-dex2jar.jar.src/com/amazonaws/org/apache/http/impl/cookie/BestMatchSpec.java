package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.FormattedHeader;
import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HeaderElement;
import com.amazonaws.org.apache.http.cookie.Cookie;
import com.amazonaws.org.apache.http.cookie.CookieOrigin;
import com.amazonaws.org.apache.http.cookie.CookieSpec;
import com.amazonaws.org.apache.http.cookie.MalformedCookieException;
import com.amazonaws.org.apache.http.cookie.SetCookie2;
import com.amazonaws.org.apache.http.message.ParserCursor;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.util.Iterator;
import java.util.List;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class BestMatchSpec
  implements CookieSpec
{
  private BrowserCompatSpec compat;
  private final String[] datepatterns;
  private RFC2109Spec obsoleteStrict;
  private final boolean oneHeader;
  private RFC2965Spec strict;
  
  public BestMatchSpec()
  {
    this(null, false);
  }
  
  public BestMatchSpec(String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString == null) {}
    for (paramArrayOfString = null;; paramArrayOfString = (String[])paramArrayOfString.clone())
    {
      this.datepatterns = paramArrayOfString;
      this.oneHeader = paramBoolean;
      return;
    }
  }
  
  private BrowserCompatSpec getCompat()
  {
    if (this.compat == null) {
      this.compat = new BrowserCompatSpec(this.datepatterns);
    }
    return this.compat;
  }
  
  private RFC2109Spec getObsoleteStrict()
  {
    if (this.obsoleteStrict == null) {
      this.obsoleteStrict = new RFC2109Spec(this.datepatterns, this.oneHeader);
    }
    return this.obsoleteStrict;
  }
  
  private RFC2965Spec getStrict()
  {
    if (this.strict == null) {
      this.strict = new RFC2965Spec(this.datepatterns, this.oneHeader);
    }
    return this.strict;
  }
  
  public List<Header> formatCookies(List<Cookie> paramList)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("List of cookies may not be null");
    }
    Iterator localIterator = paramList.iterator();
    int i = Integer.MAX_VALUE;
    int j = 1;
    if (localIterator.hasNext())
    {
      Cookie localCookie = (Cookie)localIterator.next();
      if (!(localCookie instanceof SetCookie2)) {
        j = 0;
      }
      if (localCookie.getVersion() >= i) {
        break label116;
      }
      i = localCookie.getVersion();
    }
    label116:
    for (;;)
    {
      break;
      if (i > 0)
      {
        if (j != 0) {
          return getStrict().formatCookies(paramList);
        }
        return getObsoleteStrict().formatCookies(paramList);
      }
      return getCompat().formatCookies(paramList);
    }
  }
  
  public int getVersion()
  {
    return getStrict().getVersion();
  }
  
  public Header getVersionHeader()
  {
    return getStrict().getVersionHeader();
  }
  
  public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin)
  {
    if (paramCookie == null) {
      throw new IllegalArgumentException("Cookie may not be null");
    }
    if (paramCookieOrigin == null) {
      throw new IllegalArgumentException("Cookie origin may not be null");
    }
    if (paramCookie.getVersion() > 0)
    {
      if ((paramCookie instanceof SetCookie2)) {
        return getStrict().match(paramCookie, paramCookieOrigin);
      }
      return getObsoleteStrict().match(paramCookie, paramCookieOrigin);
    }
    return getCompat().match(paramCookie, paramCookieOrigin);
  }
  
  public List<Cookie> parse(Header paramHeader, CookieOrigin paramCookieOrigin)
  {
    if (paramHeader == null) {
      throw new IllegalArgumentException("Header may not be null");
    }
    if (paramCookieOrigin == null) {
      throw new IllegalArgumentException("Cookie origin may not be null");
    }
    Object localObject = paramHeader.getElements();
    int m = localObject.length;
    int i = 0;
    int j = 0;
    int k = 0;
    NetscapeDraftHeaderParser localNetscapeDraftHeaderParser;
    while (i < m)
    {
      localNetscapeDraftHeaderParser = localObject[i];
      if (localNetscapeDraftHeaderParser.getParameterByName("version") != null) {
        k = 1;
      }
      if (localNetscapeDraftHeaderParser.getParameterByName("expires") != null) {
        j = 1;
      }
      i += 1;
    }
    if ((j != 0) || (k == 0))
    {
      localNetscapeDraftHeaderParser = NetscapeDraftHeaderParser.DEFAULT;
      if ((paramHeader instanceof FormattedHeader)) {
        localObject = ((FormattedHeader)paramHeader).getBuffer();
      }
      for (paramHeader = new ParserCursor(((FormattedHeader)paramHeader).getValuePos(), ((CharArrayBuffer)localObject).length());; paramHeader = new ParserCursor(0, ((CharArrayBuffer)localObject).length()))
      {
        paramHeader = localNetscapeDraftHeaderParser.parseHeader((CharArrayBuffer)localObject, paramHeader);
        return getCompat().parse(new HeaderElement[] { paramHeader }, paramCookieOrigin);
        paramHeader = paramHeader.getValue();
        if (paramHeader == null) {
          throw new MalformedCookieException("Header value is null");
        }
        localObject = new CharArrayBuffer(paramHeader.length());
        ((CharArrayBuffer)localObject).append(paramHeader);
      }
    }
    if ("Set-Cookie2".equals(paramHeader.getName())) {
      return getStrict().parse((HeaderElement[])localObject, paramCookieOrigin);
    }
    return getObsoleteStrict().parse((HeaderElement[])localObject, paramCookieOrigin);
  }
  
  public String toString()
  {
    return "best-match";
  }
  
  public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin)
  {
    if (paramCookie == null) {
      throw new IllegalArgumentException("Cookie may not be null");
    }
    if (paramCookieOrigin == null) {
      throw new IllegalArgumentException("Cookie origin may not be null");
    }
    if (paramCookie.getVersion() > 0)
    {
      if ((paramCookie instanceof SetCookie2))
      {
        getStrict().validate(paramCookie, paramCookieOrigin);
        return;
      }
      getObsoleteStrict().validate(paramCookie, paramCookieOrigin);
      return;
    }
    getCompat().validate(paramCookie, paramCookieOrigin);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/BestMatchSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */