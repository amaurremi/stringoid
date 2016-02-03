package com.amazonaws.org.apache.http.message;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HeaderElement;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.io.Serializable;
import org.apache.http.annotation.Immutable;

@Immutable
public class BasicHeader
  implements Header, Serializable, Cloneable
{
  private final String name;
  private final String value;
  
  public BasicHeader(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Name may not be null");
    }
    this.name = paramString1;
    this.value = paramString2;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public HeaderElement[] getElements()
  {
    if (this.value != null) {
      return BasicHeaderValueParser.parseElements(this.value, null);
    }
    return new HeaderElement[0];
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public String toString()
  {
    return BasicLineFormatter.DEFAULT.formatHeader(null, this).toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/message/BasicHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */