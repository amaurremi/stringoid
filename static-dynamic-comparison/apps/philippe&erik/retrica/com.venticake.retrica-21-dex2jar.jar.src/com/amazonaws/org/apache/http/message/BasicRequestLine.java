package com.amazonaws.org.apache.http.message;

import com.amazonaws.org.apache.http.ProtocolVersion;
import com.amazonaws.org.apache.http.RequestLine;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.io.Serializable;
import org.apache.http.annotation.Immutable;

@Immutable
public class BasicRequestLine
  implements RequestLine, Serializable, Cloneable
{
  private final String method;
  private final ProtocolVersion protoversion;
  private final String uri;
  
  public BasicRequestLine(String paramString1, String paramString2, ProtocolVersion paramProtocolVersion)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Method must not be null.");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("URI must not be null.");
    }
    if (paramProtocolVersion == null) {
      throw new IllegalArgumentException("Protocol version must not be null.");
    }
    this.method = paramString1;
    this.uri = paramString2;
    this.protoversion = paramProtocolVersion;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public String getMethod()
  {
    return this.method;
  }
  
  public ProtocolVersion getProtocolVersion()
  {
    return this.protoversion;
  }
  
  public String getUri()
  {
    return this.uri;
  }
  
  public String toString()
  {
    return BasicLineFormatter.DEFAULT.formatRequestLine(null, this).toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/message/BasicRequestLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */