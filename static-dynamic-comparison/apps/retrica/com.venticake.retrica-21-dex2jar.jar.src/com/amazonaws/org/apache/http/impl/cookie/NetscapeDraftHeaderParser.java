package com.amazonaws.org.apache.http.impl.cookie;

import com.amazonaws.org.apache.http.HeaderElement;
import com.amazonaws.org.apache.http.NameValuePair;
import com.amazonaws.org.apache.http.message.BasicHeaderElement;
import com.amazonaws.org.apache.http.message.BasicNameValuePair;
import com.amazonaws.org.apache.http.message.ParserCursor;
import com.amazonaws.org.apache.http.protocol.HTTP;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.annotation.Immutable;

@Immutable
public class NetscapeDraftHeaderParser
{
  public static final NetscapeDraftHeaderParser DEFAULT = new NetscapeDraftHeaderParser();
  
  private NameValuePair parseNameValuePair(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor)
  {
    int m = 1;
    int k = 0;
    int j = paramParserCursor.getPos();
    int i1 = paramParserCursor.getPos();
    int n = paramParserCursor.getUpperBound();
    int i = k;
    label50:
    String str;
    if (j < n)
    {
      i = paramCharArrayBuffer.charAt(j);
      if (i == 61) {
        i = k;
      }
    }
    else
    {
      if (j != n) {
        break label112;
      }
      str = paramCharArrayBuffer.substringTrimmed(i1, n);
    }
    for (k = 1;; k = i)
    {
      if (k == 0) {
        break label134;
      }
      paramParserCursor.updatePos(j);
      return new BasicNameValuePair(str, null);
      if (i == 59)
      {
        i = 1;
        break label50;
      }
      j += 1;
      break;
      label112:
      str = paramCharArrayBuffer.substringTrimmed(i1, j);
      j += 1;
    }
    label134:
    i = j;
    if (i < n) {
      if (paramCharArrayBuffer.charAt(i) == ';') {
        k = m;
      }
    }
    for (;;)
    {
      if ((j < i) && (HTTP.isWhitespace(paramCharArrayBuffer.charAt(j))))
      {
        j += 1;
        continue;
        i += 1;
        break;
      }
      for (;;)
      {
        if ((m > j) && (HTTP.isWhitespace(paramCharArrayBuffer.charAt(m - 1))))
        {
          m -= 1;
        }
        else
        {
          paramCharArrayBuffer = paramCharArrayBuffer.substring(j, m);
          if (k != 0) {
            i += 1;
          }
          for (;;)
          {
            paramParserCursor.updatePos(i);
            return new BasicNameValuePair(str, paramCharArrayBuffer);
          }
          m = i;
        }
      }
    }
  }
  
  public HeaderElement parseHeader(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor)
  {
    if (paramCharArrayBuffer == null) {
      throw new IllegalArgumentException("Char array buffer may not be null");
    }
    if (paramParserCursor == null) {
      throw new IllegalArgumentException("Parser cursor may not be null");
    }
    NameValuePair localNameValuePair = parseNameValuePair(paramCharArrayBuffer, paramParserCursor);
    ArrayList localArrayList = new ArrayList();
    while (!paramParserCursor.atEnd()) {
      localArrayList.add(parseNameValuePair(paramCharArrayBuffer, paramParserCursor));
    }
    return new BasicHeaderElement(localNameValuePair.getName(), localNameValuePair.getValue(), (NameValuePair[])localArrayList.toArray(new NameValuePair[localArrayList.size()]));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/cookie/NetscapeDraftHeaderParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */