package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.FormattedHeader;
import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HeaderElement;
import com.amazonaws.org.apache.http.cookie.Cookie;
import com.amazonaws.org.apache.http.cookie.CookieOrigin;
import com.amazonaws.org.apache.http.cookie.MalformedCookieException;
import com.amazonaws.org.apache.http.message.BufferedHeader;
import com.amazonaws.org.apache.http.message.ParserCursor;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class NetscapeDraftSpec
  extends CookieSpecBase
{
  private final String[] datepatterns;
  
  public NetscapeDraftSpec()
  {
    this(null);
  }
  
  public NetscapeDraftSpec(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null) {}
    for (this.datepatterns = ((String[])paramArrayOfString.clone());; this.datepatterns = new String[] { "EEE, dd-MMM-yy HH:mm:ss z" })
    {
      registerAttribHandler("path", new BasicPathHandler());
      registerAttribHandler("domain", new NetscapeDomainHandler());
      registerAttribHandler("max-age", new BasicMaxAgeHandler());
      registerAttribHandler("secure", new BasicSecureHandler());
      registerAttribHandler("comment", new BasicCommentHandler());
      registerAttribHandler("expires", new BasicExpiresHandler(this.datepatterns));
      return;
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
    CharArrayBuffer localCharArrayBuffer = new CharArrayBuffer(paramList.size() * 20);
    localCharArrayBuffer.append("Cookie");
    localCharArrayBuffer.append(": ");
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (Cookie)paramList.get(i);
      if (i > 0) {
        localCharArrayBuffer.append("; ");
      }
      localCharArrayBuffer.append(((Cookie)localObject).getName());
      localObject = ((Cookie)localObject).getValue();
      if (localObject != null)
      {
        localCharArrayBuffer.append("=");
        localCharArrayBuffer.append((String)localObject);
      }
      i += 1;
    }
    paramList = new ArrayList(1);
    paramList.add(new BufferedHeader(localCharArrayBuffer));
    return paramList;
  }
  
  public int getVersion()
  {
    return 0;
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
    NetscapeDraftHeaderParser localNetscapeDraftHeaderParser = NetscapeDraftHeaderParser.DEFAULT;
    CharArrayBuffer localCharArrayBuffer;
    if ((paramHeader instanceof FormattedHeader)) {
      localCharArrayBuffer = ((FormattedHeader)paramHeader).getBuffer();
    }
    for (paramHeader = new ParserCursor(((FormattedHeader)paramHeader).getValuePos(), localCharArrayBuffer.length());; paramHeader = new ParserCursor(0, localCharArrayBuffer.length()))
    {
      return parse(new HeaderElement[] { localNetscapeDraftHeaderParser.parseHeader(localCharArrayBuffer, paramHeader) }, paramCookieOrigin);
      paramHeader = paramHeader.getValue();
      if (paramHeader == null) {
        throw new MalformedCookieException("Header value is null");
      }
      localCharArrayBuffer = new CharArrayBuffer(paramHeader.length());
      localCharArrayBuffer.append(paramHeader);
    }
  }
  
  public String toString()
  {
    return "netscape";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/NetscapeDraftSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */