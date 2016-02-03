package com.amazonaws.org.apache.http.message;

import com.amazonaws.org.apache.http.FormattedHeader;
import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HeaderElement;
import com.amazonaws.org.apache.http.HeaderElementIterator;
import com.amazonaws.org.apache.http.HeaderIterator;
import com.amazonaws.org.apache.http.util.CharArrayBuffer;
import java.util.NoSuchElementException;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class BasicHeaderElementIterator
  implements HeaderElementIterator
{
  private CharArrayBuffer buffer = null;
  private HeaderElement currentElement = null;
  private ParserCursor cursor = null;
  private final HeaderIterator headerIt;
  private final HeaderValueParser parser;
  
  public BasicHeaderElementIterator(HeaderIterator paramHeaderIterator)
  {
    this(paramHeaderIterator, BasicHeaderValueParser.DEFAULT);
  }
  
  public BasicHeaderElementIterator(HeaderIterator paramHeaderIterator, HeaderValueParser paramHeaderValueParser)
  {
    if (paramHeaderIterator == null) {
      throw new IllegalArgumentException("Header iterator may not be null");
    }
    if (paramHeaderValueParser == null) {
      throw new IllegalArgumentException("Parser may not be null");
    }
    this.headerIt = paramHeaderIterator;
    this.parser = paramHeaderValueParser;
  }
  
  private void bufferHeaderValue()
  {
    this.cursor = null;
    this.buffer = null;
    Object localObject;
    do
    {
      if (this.headerIt.hasNext())
      {
        localObject = this.headerIt.nextHeader();
        if ((localObject instanceof FormattedHeader))
        {
          this.buffer = ((FormattedHeader)localObject).getBuffer();
          this.cursor = new ParserCursor(0, this.buffer.length());
          this.cursor.updatePos(((FormattedHeader)localObject).getValuePos());
        }
      }
      else
      {
        return;
      }
      localObject = ((Header)localObject).getValue();
    } while (localObject == null);
    this.buffer = new CharArrayBuffer(((String)localObject).length());
    this.buffer.append((String)localObject);
    this.cursor = new ParserCursor(0, this.buffer.length());
  }
  
  private void parseNextElement()
  {
    for (;;)
    {
      if ((this.headerIt.hasNext()) || (this.cursor != null))
      {
        if ((this.cursor == null) || (this.cursor.atEnd())) {
          bufferHeaderValue();
        }
        if (this.cursor == null) {}
      }
      else
      {
        while (!this.cursor.atEnd())
        {
          HeaderElement localHeaderElement = this.parser.parseHeaderElement(this.buffer, this.cursor);
          if ((localHeaderElement.getName().length() != 0) || (localHeaderElement.getValue() != null))
          {
            this.currentElement = localHeaderElement;
            return;
          }
        }
        if (this.cursor.atEnd())
        {
          this.cursor = null;
          this.buffer = null;
        }
      }
    }
  }
  
  public boolean hasNext()
  {
    if (this.currentElement == null) {
      parseNextElement();
    }
    return this.currentElement != null;
  }
  
  public final Object next()
  {
    return nextElement();
  }
  
  public HeaderElement nextElement()
  {
    if (this.currentElement == null) {
      parseNextElement();
    }
    if (this.currentElement == null) {
      throw new NoSuchElementException("No more header elements available");
    }
    HeaderElement localHeaderElement = this.currentElement;
    this.currentElement = null;
    return localHeaderElement;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Remove not supported");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/message/BasicHeaderElementIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */