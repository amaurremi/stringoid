package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.FormattedHeader;
import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HeaderElement;
import com.amazonaws.org.apache.http.cookie.Cookie;
import com.amazonaws.org.apache.http.cookie.CookieOrigin;
import com.amazonaws.org.apache.http.cookie.MalformedCookieException;
import com.amazonaws.org.apache.http.message.BasicHeaderElement;
import com.amazonaws.org.apache.http.message.BasicHeaderValueFormatter;
import com.amazonaws.org.apache.http.message.BufferedHeader;
import com.amazonaws.org.apache.http.message.ParserCursor;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class BrowserCompatSpec
  extends CookieSpecBase
{
  private static final String[] DEFAULT_DATE_PATTERNS = { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z" };
  private final String[] datepatterns;
  
  public BrowserCompatSpec()
  {
    this(null);
  }
  
  public BrowserCompatSpec(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null) {}
    for (this.datepatterns = ((String[])paramArrayOfString.clone());; this.datepatterns = DEFAULT_DATE_PATTERNS)
    {
      registerAttribHandler("path", new BasicPathHandler());
      registerAttribHandler("domain", new BasicDomainHandler());
      registerAttribHandler("max-age", new BasicMaxAgeHandler());
      registerAttribHandler("secure", new BasicSecureHandler());
      registerAttribHandler("comment", new BasicCommentHandler());
      registerAttribHandler("expires", new BasicExpiresHandler(this.datepatterns));
      registerAttribHandler("version", new BrowserCompatVersionAttributeHandler());
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
    if (i < paramList.size())
    {
      Object localObject = (Cookie)paramList.get(i);
      if (i > 0) {
        localCharArrayBuffer.append("; ");
      }
      if (((Cookie)localObject).getVersion() > 0) {
        BasicHeaderValueFormatter.DEFAULT.formatHeaderElement(localCharArrayBuffer, new BasicHeaderElement(((Cookie)localObject).getName(), ((Cookie)localObject).getValue()), false);
      }
      for (;;)
      {
        i += 1;
        break;
        localCharArrayBuffer.append(((Cookie)localObject).getName());
        localCharArrayBuffer.append("=");
        localObject = ((Cookie)localObject).getValue();
        if (localObject != null) {
          localCharArrayBuffer.append((String)localObject);
        }
      }
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
      if ((paramHeader instanceof FormattedHeader))
      {
        localObject = ((FormattedHeader)paramHeader).getBuffer();
        paramHeader = new ParserCursor(((FormattedHeader)paramHeader).getValuePos(), ((CharArrayBuffer)localObject).length());
      }
    }
    for (paramHeader = new HeaderElement[] { localNetscapeDraftHeaderParser.parseHeader((CharArrayBuffer)localObject, paramHeader) };; paramHeader = (Header)localObject)
    {
      return parse(paramHeader, paramCookieOrigin);
      paramHeader = paramHeader.getValue();
      if (paramHeader == null) {
        throw new MalformedCookieException("Header value is null");
      }
      localObject = new CharArrayBuffer(paramHeader.length());
      ((CharArrayBuffer)localObject).append(paramHeader);
      paramHeader = new ParserCursor(0, ((CharArrayBuffer)localObject).length());
      break;
    }
  }
  
  public String toString()
  {
    return "compatibility";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/BrowserCompatSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */