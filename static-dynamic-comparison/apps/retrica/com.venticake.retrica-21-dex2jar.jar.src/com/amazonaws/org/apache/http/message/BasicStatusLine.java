package com.amazonaws.org.apache.http.message;

import com.amazonaws.org.apache.http.ProtocolVersion;
import com.amazonaws.org.apache.http.StatusLine;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.io.Serializable;
import org.apache.http.annotation.Immutable;

@Immutable
public class BasicStatusLine
  implements StatusLine, Serializable, Cloneable
{
  private final ProtocolVersion protoVersion;
  private final String reasonPhrase;
  private final int statusCode;
  
  public BasicStatusLine(ProtocolVersion paramProtocolVersion, int paramInt, String paramString)
  {
    if (paramProtocolVersion == null) {
      throw new IllegalArgumentException("Protocol version may not be null.");
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Status code may not be negative.");
    }
    this.protoVersion = paramProtocolVersion;
    this.statusCode = paramInt;
    this.reasonPhrase = paramString;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public ProtocolVersion getProtocolVersion()
  {
    return this.protoVersion;
  }
  
  public String getReasonPhrase()
  {
    return this.reasonPhrase;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public String toString()
  {
    return BasicLineFormatter.DEFAULT.formatStatusLine(null, this).toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/message/BasicStatusLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */