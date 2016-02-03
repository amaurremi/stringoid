package com.amazonaws.org.apache.http.message;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpVersion;
import com.amazonaws.org.apache.http.ParseException;
import com.amazonaws.org.apache.http.ProtocolVersion;
import com.amazonaws.org.apache.http.StatusLine;
import com.amazonaws.org.apache.http.protocol.HTTP;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import org.apache.http.annotation.Immutable;

@Immutable
public class BasicLineParser
  implements LineParser
{
  public static final BasicLineParser DEFAULT = new BasicLineParser();
  protected final ProtocolVersion protocol;
  
  public BasicLineParser()
  {
    this(null);
  }
  
  public BasicLineParser(ProtocolVersion paramProtocolVersion)
  {
    Object localObject = paramProtocolVersion;
    if (paramProtocolVersion == null) {
      localObject = HttpVersion.HTTP_1_1;
    }
    this.protocol = ((ProtocolVersion)localObject);
  }
  
  protected ProtocolVersion createProtocolVersion(int paramInt1, int paramInt2)
  {
    return this.protocol.forVersion(paramInt1, paramInt2);
  }
  
  protected StatusLine createStatusLine(ProtocolVersion paramProtocolVersion, int paramInt, String paramString)
  {
    return new BasicStatusLine(paramProtocolVersion, paramInt, paramString);
  }
  
  public boolean hasProtocolVersion(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor)
  {
    boolean bool2 = true;
    if (paramCharArrayBuffer == null) {
      throw new IllegalArgumentException("Char array buffer may not be null");
    }
    if (paramParserCursor == null) {
      throw new IllegalArgumentException("Parser cursor may not be null");
    }
    int j = paramParserCursor.getPos();
    paramParserCursor = this.protocol.getProtocol();
    int k = paramParserCursor.length();
    if (paramCharArrayBuffer.length() < k + 4) {
      break label79;
    }
    int i;
    label79:
    while (i + k + 4 > paramCharArrayBuffer.length())
    {
      return false;
      if (j >= 0) {
        break;
      }
      i = paramCharArrayBuffer.length() - 4 - k;
    }
    j = 0;
    boolean bool1 = true;
    label98:
    if ((bool1) && (j < k))
    {
      if (paramCharArrayBuffer.charAt(i + j) == paramParserCursor.charAt(j)) {}
      for (bool1 = true;; bool1 = false)
      {
        j += 1;
        break label98;
        i = j;
        if (j != 0) {
          break;
        }
        for (;;)
        {
          i = j;
          if (j >= paramCharArrayBuffer.length()) {
            break;
          }
          i = j;
          if (!HTTP.isWhitespace(paramCharArrayBuffer.charAt(j))) {
            break;
          }
          j += 1;
        }
      }
    }
    if (bool1) {
      if (paramCharArrayBuffer.charAt(i + k) == '/') {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = false;
    }
  }
  
  public Header parseHeader(CharArrayBuffer paramCharArrayBuffer)
  {
    return new BufferedHeader(paramCharArrayBuffer);
  }
  
  public ProtocolVersion parseProtocolVersion(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor)
  {
    int m = 1;
    if (paramCharArrayBuffer == null) {
      throw new IllegalArgumentException("Char array buffer may not be null");
    }
    if (paramParserCursor == null) {
      throw new IllegalArgumentException("Parser cursor may not be null");
    }
    String str = this.protocol.getProtocol();
    int i1 = str.length();
    n = paramParserCursor.getPos();
    k = paramParserCursor.getUpperBound();
    skipWhitespace(paramCharArrayBuffer, paramParserCursor);
    int i2 = paramParserCursor.getPos();
    if (i2 + i1 + 4 > k) {
      throw new ParseException("Not a valid protocol version: " + paramCharArrayBuffer.substring(n, k));
    }
    int j = 0;
    int i = 1;
    if ((i != 0) && (j < i1))
    {
      if (paramCharArrayBuffer.charAt(i2 + j) == str.charAt(j)) {}
      for (i = 1;; i = 0)
      {
        j += 1;
        break;
      }
    }
    if (i != 0)
    {
      if (paramCharArrayBuffer.charAt(i2 + i1) == '/') {
        i = m;
      }
      for (;;)
      {
        if (i == 0)
        {
          throw new ParseException("Not a valid protocol version: " + paramCharArrayBuffer.substring(n, k));
          i = 0;
          continue;
        }
        j = i1 + 1 + i2;
        i = paramCharArrayBuffer.indexOf(46, j, k);
        if (i == -1) {
          throw new ParseException("Invalid protocol version number: " + paramCharArrayBuffer.substring(n, k));
        }
        try
        {
          m = Integer.parseInt(paramCharArrayBuffer.substringTrimmed(j, i));
          i1 = i + 1;
          j = paramCharArrayBuffer.indexOf(32, i1, k);
          i = j;
          if (j == -1) {
            i = k;
          }
        }
        catch (NumberFormatException paramParserCursor)
        {
          try
          {
            j = Integer.parseInt(paramCharArrayBuffer.substringTrimmed(i1, i));
            paramParserCursor.updatePos(i);
            return createProtocolVersion(m, j);
          }
          catch (NumberFormatException paramParserCursor)
          {
            throw new ParseException("Invalid protocol minor version number: " + paramCharArrayBuffer.substring(n, k));
          }
          paramParserCursor = paramParserCursor;
          throw new ParseException("Invalid protocol major version number: " + paramCharArrayBuffer.substring(n, k));
        }
      }
    }
  }
  
  public StatusLine parseStatusLine(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor)
  {
    if (paramCharArrayBuffer == null) {
      throw new IllegalArgumentException("Char array buffer may not be null");
    }
    if (paramParserCursor == null) {
      throw new IllegalArgumentException("Parser cursor may not be null");
    }
    int m = paramParserCursor.getPos();
    int k = paramParserCursor.getUpperBound();
    label188:
    label259:
    for (;;)
    {
      ProtocolVersion localProtocolVersion;
      int j;
      int i;
      try
      {
        localProtocolVersion = parseProtocolVersion(paramCharArrayBuffer, paramParserCursor);
        skipWhitespace(paramCharArrayBuffer, paramParserCursor);
        j = paramParserCursor.getPos();
        i = paramCharArrayBuffer.indexOf(32, j, k);
        if (i >= 0) {
          break label259;
        }
        i = k;
        paramParserCursor = paramCharArrayBuffer.substringTrimmed(j, i);
        j = 0;
        if (j >= paramParserCursor.length()) {
          break label188;
        }
        if (!Character.isDigit(paramParserCursor.charAt(j))) {
          throw new ParseException("Status line contains invalid status code: " + paramCharArrayBuffer.substring(m, k));
        }
      }
      catch (IndexOutOfBoundsException paramParserCursor)
      {
        throw new ParseException("Invalid status line: " + paramCharArrayBuffer.substring(m, k));
      }
      j += 1;
      continue;
      for (;;)
      {
        try
        {
          j = Integer.parseInt(paramParserCursor);
          if (i < k)
          {
            paramParserCursor = paramCharArrayBuffer.substringTrimmed(i, k);
            return createStatusLine(localProtocolVersion, j, paramParserCursor);
          }
        }
        catch (NumberFormatException paramParserCursor)
        {
          throw new ParseException("Status line contains invalid status code: " + paramCharArrayBuffer.substring(m, k));
        }
        paramParserCursor = "";
      }
    }
  }
  
  protected void skipWhitespace(CharArrayBuffer paramCharArrayBuffer, ParserCursor paramParserCursor)
  {
    int i = paramParserCursor.getPos();
    int j = paramParserCursor.getUpperBound();
    while ((i < j) && (HTTP.isWhitespace(paramCharArrayBuffer.charAt(i)))) {
      i += 1;
    }
    paramParserCursor.updatePos(i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/message/BasicLineParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */