package com.amazonaws.org.apache.http.message;

import com.amazonaws.org.apache.http.FormattedHeader;
import com.amazonaws.org.apache.http.HeaderElement;
import com.amazonaws.org.apache.http.ParseException;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.io.Serializable;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class BufferedHeader
  implements FormattedHeader, Serializable, Cloneable
{
  private final CharArrayBuffer buffer;
  private final String name;
  private final int valuePos;
  
  public BufferedHeader(CharArrayBuffer paramCharArrayBuffer)
  {
    if (paramCharArrayBuffer == null) {
      throw new IllegalArgumentException("Char array buffer may not be null");
    }
    int i = paramCharArrayBuffer.indexOf(58);
    if (i == -1) {
      throw new ParseException("Invalid header: " + paramCharArrayBuffer.toString());
    }
    String str = paramCharArrayBuffer.substringTrimmed(0, i);
    if (str.length() == 0) {
      throw new ParseException("Invalid header: " + paramCharArrayBuffer.toString());
    }
    this.buffer = paramCharArrayBuffer;
    this.name = str;
    this.valuePos = (i + 1);
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public CharArrayBuffer getBuffer()
  {
    return this.buffer;
  }
  
  public HeaderElement[] getElements()
  {
    ParserCursor localParserCursor = new ParserCursor(0, this.buffer.length());
    localParserCursor.updatePos(this.valuePos);
    return BasicHeaderValueParser.DEFAULT.parseElements(this.buffer, localParserCursor);
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getValue()
  {
    return this.buffer.substringTrimmed(this.valuePos, this.buffer.length());
  }
  
  public int getValuePos()
  {
    return this.valuePos;
  }
  
  public String toString()
  {
    return this.buffer.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/message/BufferedHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */