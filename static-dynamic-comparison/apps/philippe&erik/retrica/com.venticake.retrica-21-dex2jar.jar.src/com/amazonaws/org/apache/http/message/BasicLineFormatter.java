package com.amazonaws.org.apache.http.message;

import com.amazonaws.org.apache.http.FormattedHeader;
import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.ProtocolVersion;
import com.amazonaws.org.apache.http.RequestLine;
import com.amazonaws.org.apache.http.StatusLine;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import org.apache.http.annotation.Immutable;

@Immutable
public class BasicLineFormatter
  implements LineFormatter
{
  public static final BasicLineFormatter DEFAULT = new BasicLineFormatter();
  
  public CharArrayBuffer appendProtocolVersion(CharArrayBuffer paramCharArrayBuffer, ProtocolVersion paramProtocolVersion)
  {
    if (paramProtocolVersion == null) {
      throw new IllegalArgumentException("Protocol version may not be null");
    }
    int i = estimateProtocolVersionLen(paramProtocolVersion);
    if (paramCharArrayBuffer == null) {
      paramCharArrayBuffer = new CharArrayBuffer(i);
    }
    for (;;)
    {
      paramCharArrayBuffer.append(paramProtocolVersion.getProtocol());
      paramCharArrayBuffer.append('/');
      paramCharArrayBuffer.append(Integer.toString(paramProtocolVersion.getMajor()));
      paramCharArrayBuffer.append('.');
      paramCharArrayBuffer.append(Integer.toString(paramProtocolVersion.getMinor()));
      return paramCharArrayBuffer;
      paramCharArrayBuffer.ensureCapacity(i);
    }
  }
  
  protected void doFormatHeader(CharArrayBuffer paramCharArrayBuffer, Header paramHeader)
  {
    String str = paramHeader.getName();
    paramHeader = paramHeader.getValue();
    int j = str.length() + 2;
    int i = j;
    if (paramHeader != null) {
      i = j + paramHeader.length();
    }
    paramCharArrayBuffer.ensureCapacity(i);
    paramCharArrayBuffer.append(str);
    paramCharArrayBuffer.append(": ");
    if (paramHeader != null) {
      paramCharArrayBuffer.append(paramHeader);
    }
  }
  
  protected void doFormatRequestLine(CharArrayBuffer paramCharArrayBuffer, RequestLine paramRequestLine)
  {
    String str1 = paramRequestLine.getMethod();
    String str2 = paramRequestLine.getUri();
    paramCharArrayBuffer.ensureCapacity(str1.length() + 1 + str2.length() + 1 + estimateProtocolVersionLen(paramRequestLine.getProtocolVersion()));
    paramCharArrayBuffer.append(str1);
    paramCharArrayBuffer.append(' ');
    paramCharArrayBuffer.append(str2);
    paramCharArrayBuffer.append(' ');
    appendProtocolVersion(paramCharArrayBuffer, paramRequestLine.getProtocolVersion());
  }
  
  protected void doFormatStatusLine(CharArrayBuffer paramCharArrayBuffer, StatusLine paramStatusLine)
  {
    int j = estimateProtocolVersionLen(paramStatusLine.getProtocolVersion()) + 1 + 3 + 1;
    String str = paramStatusLine.getReasonPhrase();
    int i = j;
    if (str != null) {
      i = j + str.length();
    }
    paramCharArrayBuffer.ensureCapacity(i);
    appendProtocolVersion(paramCharArrayBuffer, paramStatusLine.getProtocolVersion());
    paramCharArrayBuffer.append(' ');
    paramCharArrayBuffer.append(Integer.toString(paramStatusLine.getStatusCode()));
    paramCharArrayBuffer.append(' ');
    if (str != null) {
      paramCharArrayBuffer.append(str);
    }
  }
  
  protected int estimateProtocolVersionLen(ProtocolVersion paramProtocolVersion)
  {
    return paramProtocolVersion.getProtocol().length() + 4;
  }
  
  public CharArrayBuffer formatHeader(CharArrayBuffer paramCharArrayBuffer, Header paramHeader)
  {
    if (paramHeader == null) {
      throw new IllegalArgumentException("Header may not be null");
    }
    if ((paramHeader instanceof FormattedHeader)) {
      return ((FormattedHeader)paramHeader).getBuffer();
    }
    paramCharArrayBuffer = initBuffer(paramCharArrayBuffer);
    doFormatHeader(paramCharArrayBuffer, paramHeader);
    return paramCharArrayBuffer;
  }
  
  public CharArrayBuffer formatRequestLine(CharArrayBuffer paramCharArrayBuffer, RequestLine paramRequestLine)
  {
    if (paramRequestLine == null) {
      throw new IllegalArgumentException("Request line may not be null");
    }
    paramCharArrayBuffer = initBuffer(paramCharArrayBuffer);
    doFormatRequestLine(paramCharArrayBuffer, paramRequestLine);
    return paramCharArrayBuffer;
  }
  
  public CharArrayBuffer formatStatusLine(CharArrayBuffer paramCharArrayBuffer, StatusLine paramStatusLine)
  {
    if (paramStatusLine == null) {
      throw new IllegalArgumentException("Status line may not be null");
    }
    paramCharArrayBuffer = initBuffer(paramCharArrayBuffer);
    doFormatStatusLine(paramCharArrayBuffer, paramStatusLine);
    return paramCharArrayBuffer;
  }
  
  protected CharArrayBuffer initBuffer(CharArrayBuffer paramCharArrayBuffer)
  {
    if (paramCharArrayBuffer != null)
    {
      paramCharArrayBuffer.clear();
      return paramCharArrayBuffer;
    }
    return new CharArrayBuffer(64);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/message/BasicLineFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */